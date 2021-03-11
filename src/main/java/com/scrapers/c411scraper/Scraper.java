package com.scrapers.c411scraper;

import com.scrapers.c411scraper.c411.VoterC411;
import com.scrapers.c411scraper.entity.VoterEntity;
import com.scrapers.c411scraper.mapping.VoterEntityToC411;
import com.scrapers.c411scraper.mapping.VoterStringArrayToEntityMapper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Scraper {
    public static void main(String[] args) throws URISyntaxException {

        final Charset westernEuropeCharset = StandardCharsets.ISO_8859_1;
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(
                        Paths.get(Scraper.class.getResource("/database.csv").toURI()), westernEuropeCharset);
                BufferedWriter bufferedWriter = Files.newBufferedWriter(
                        Paths.get(Scraper.class.getResource("/database_out.csv").toURI()), westernEuropeCharset)) {

            // The file contains a header.
            String header = bufferedReader.readLine();
            bufferedWriter.write(header + ";Telephone");
            bufferedWriter.newLine();

            String line;
            int counter = 0;
            while ((line = bufferedReader.readLine()) != null) {
                String phoneNumber = getPhoneNumberFromLine(line);
                bufferedWriter.write(line + ";" + phoneNumber);
                bufferedWriter.newLine();

                System.out.println("Voter #" + counter + ": " + phoneNumber);
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPhoneNumberFromLine(final String line) {
        VoterEntity entity = VoterStringArrayToEntityMapper.toEntity(line.split(";"));
        VoterC411 c411 = VoterEntityToC411.toC411(entity);
        return new PhoneNumberProvider(c411).getPhoneNumber();
    }
}
