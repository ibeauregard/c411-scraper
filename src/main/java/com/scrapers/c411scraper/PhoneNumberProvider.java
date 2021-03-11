package com.scrapers.c411scraper;

import com.scrapers.c411scraper.c411.VoterC411;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class PhoneNumberProvider {
    private final VoterC411 voterC411;

    public PhoneNumberProvider(final VoterC411 c411) {
        voterC411 = c411;
    }

    public String getPhoneNumber() {
        String phoneNumber = "";
        boolean completed;
        do {
            try {
                Document document = Jsoup.connect(getUrl()).get();
                validateRequestNotRejected(document);
                Element phoneNumberElement = document.select("#contact .vcard__label").first();
                if (phoneNumberElement != null) {
                    phoneNumber = phoneNumberElement.text();
                }
                completed = true;
            } catch (IOException e) {
                completed = false;
            }
        } while (!completed);
        return phoneNumber;
    }

    private String getUrl() throws UnsupportedEncodingException {
        return "http://www.canada411.ca/search/?" +
                        "stype=av" +
                        "&firstname=" + URLEncoder.encode(voterC411.getFirstName(), "UTF-8") +
                        "&lastname=" + URLEncoder.encode(voterC411.getLastName(), "UTF-8") +
                        "&st=" + URLEncoder.encode(voterC411.getStreetAddress(), "UTF-8") +
                        "&ci=" + URLEncoder.encode(voterC411.getCity(), "UTF-8") +
                        "&pv=" + URLEncoder.encode(voterC411.getProvince(), "UTF-8") +
                        "&pc=" + URLEncoder.encode(voterC411.getPostalCode(), "UTF-8");
    }

    private void validateRequestNotRejected(final Document document) throws IOException {
        if (document.select("title").first().text().equalsIgnoreCase("Request Rejected")) {
            throw new IOException("Request Rejected");
        }
    }
}
