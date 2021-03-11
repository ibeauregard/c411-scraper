package com.scrapers.c411scraper.mapping;

import com.scrapers.c411scraper.entity.VoterEntity;
import com.scrapers.c411scraper.entity.VoterEntityField;

import java.util.HashMap;
import java.util.Map;

public class VoterStringArrayToEntityMapper {

    static final Map<VoterEntityField, Integer> FIELD_TO_INDEX = new HashMap<>();

    static {
        FIELD_TO_INDEX.put(VoterEntityField.CITY, 1);
        FIELD_TO_INDEX.put(VoterEntityField.LAST_NAME, 10);
        FIELD_TO_INDEX.put(VoterEntityField.FIRST_NAME, 11);
        FIELD_TO_INDEX.put(VoterEntityField.CIVIC_NUMBER, 14);
        FIELD_TO_INDEX.put(VoterEntityField.STREET, 19);
        FIELD_TO_INDEX.put(VoterEntityField.STREET_DIRECTION, 20);
        FIELD_TO_INDEX.put(VoterEntityField.STREET_GENERIC, 21);
        FIELD_TO_INDEX.put(VoterEntityField.STREET_LINK, 22);
        FIELD_TO_INDEX.put(VoterEntityField.POSTAL_CODE, 23);
        FIELD_TO_INDEX.put(VoterEntityField.PHONE_NUMBER, 33);
    }

    public static VoterEntity toEntity(final String[] voterArray) {
        return VoterEntity.create()
                .withCity(voterArray[FIELD_TO_INDEX.get(VoterEntityField.CITY)])
                .withLastName(voterArray[FIELD_TO_INDEX.get(VoterEntityField.LAST_NAME)])
                .withFirstName(voterArray[FIELD_TO_INDEX.get(VoterEntityField.FIRST_NAME)])
                .withCivicNumber(voterArray[FIELD_TO_INDEX.get(VoterEntityField.CIVIC_NUMBER)])
                .withStreet(voterArray[FIELD_TO_INDEX.get(VoterEntityField.STREET)])
                .withStreetDirection(voterArray[FIELD_TO_INDEX.get(VoterEntityField.STREET_DIRECTION)])
                .withStreetGeneric(voterArray[FIELD_TO_INDEX.get(VoterEntityField.STREET_GENERIC)])
                .withStreetLink(voterArray[FIELD_TO_INDEX.get(VoterEntityField.STREET_LINK)])
                .withPostalCode(voterArray[FIELD_TO_INDEX.get(VoterEntityField.POSTAL_CODE)]).build();
    }
}
