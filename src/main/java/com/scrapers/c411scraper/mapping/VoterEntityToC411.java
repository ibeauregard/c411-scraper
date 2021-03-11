package com.scrapers.c411scraper.mapping;

import com.scrapers.c411scraper.c411.VoterC411;
import com.scrapers.c411scraper.entity.VoterEntity;

public class VoterEntityToC411 {
    public static VoterC411 toC411(final VoterEntity entity) {
        return VoterC411.create()
                .withFirstName(entity.getFirstName())
                .withLastName(entity.getLastName())
                .withStreetAddress(getEntityStreetAddress(entity))
                .withCity(entity.getCity())
                .withProvince(entity.getProvince())
                .withPostalCode(entity.getPostalCode()).build();
    }

    private static String getEntityStreetAddress(final VoterEntity entity) {
        return String.format("%s %s %s %s %s",
                entity.getCivicNumber(),
                entity.getStreetGeneric(),
                entity.getStreetLink(),
                entity.getStreet(),
                entity.getStreetDirection());
    }
}
