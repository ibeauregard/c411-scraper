package com.scrapers.c411scraper;

import com.scrapers.c411scraper.entity.VoterEntity;
import com.scrapers.c411scraper.entity.VoterEntityField;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VoterEntityTest {
    private static final String CITY = "Ville-Émard";
    private static final String LAST_NAME = "Moulin";
    private static final String FIRST_NAME = "Jean";
    private static final String CIVIC_NUMBER = "3674";
    private static final String STREET = "Érables";
    private static final String STREET_DIRECTION = "N";
    private static final String STREET_GENERIC = "rue";
    private static final String STREET_LINK = "des";
    private static final String POSTAL_CODE = "H2M 2C5";
    private static final String PHONE_NUMBER = "5141234567";

    private VoterEntity entity;

    @Before
    public void setup() {
        entity = VoterEntity.create()
                .withCity(CITY)
                .withLastName(LAST_NAME)
                .withFirstName(FIRST_NAME)
                .withCivicNumber(CIVIC_NUMBER)
                .withStreet(STREET)
                .withStreetDirection(STREET_DIRECTION)
                .withStreetGeneric(STREET_GENERIC)
                .withStreetLink(STREET_LINK)
                .withPostalCode(POSTAL_CODE)
                .withPhoneNumber(PHONE_NUMBER).build();
    }

    @Test
    public void constructor() {
        final String assertionFailErrorMessage = "Object getter does not return value assigned by constructor";
        assertEquals(assertionFailErrorMessage, CITY, entity.getCity());
        assertEquals(assertionFailErrorMessage, LAST_NAME, entity.getLastName());
        assertEquals(assertionFailErrorMessage, FIRST_NAME, entity.getFirstName());
        assertEquals(assertionFailErrorMessage, CIVIC_NUMBER, entity.getCivicNumber());
        assertEquals(assertionFailErrorMessage, STREET, entity.getStreet());
        assertEquals(assertionFailErrorMessage, POSTAL_CODE, entity.getPostalCode());
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldFailNoCity() {
        VoterEntity.create()
                .withLastName(LAST_NAME)
                .withFirstName(FIRST_NAME)
                .withCivicNumber(CIVIC_NUMBER)
                .withStreet(STREET)
                .withPostalCode(POSTAL_CODE).build();
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldFailNoLastName() {
        VoterEntity.create()
                .withCity(CITY)
                .withFirstName(FIRST_NAME)
                .withCivicNumber(CIVIC_NUMBER)
                .withStreet(STREET)
                .withPostalCode(POSTAL_CODE).build();
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldFailNoFirstName() {
        VoterEntity.create()
                .withCity(CITY)
                .withFirstName(LAST_NAME)
                .withCivicNumber(CIVIC_NUMBER)
                .withStreet(STREET)
                .withPostalCode(POSTAL_CODE).build();
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldFailNoCivicNumber() {
        VoterEntity.create()
                .withCity(CITY)
                .withLastName(LAST_NAME)
                .withFirstName(FIRST_NAME)
                .withStreet(STREET)
                .withPostalCode(POSTAL_CODE).build();
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldFailNoStreet() {
        VoterEntity.create()
                .withCity(CITY)
                .withLastName(LAST_NAME)
                .withFirstName(FIRST_NAME)
                .withCivicNumber(CIVIC_NUMBER)
                .withPostalCode(POSTAL_CODE).build();
    }

    @Test(expected = AssertionError.class)
    public void constructorShouldFailNoPostalCode() {
        VoterEntity.create()
                .withCity(CITY)
                .withLastName(LAST_NAME)
                .withFirstName(FIRST_NAME)
                .withCivicNumber(CIVIC_NUMBER)
                .withStreet(STREET).build();
    }

    @Test
    public void getWithCityField() {
        assertEquals("Getter implementation error",
                entity.getCity(),
                entity.get(VoterEntityField.CITY));
    }

    @Test
    public void getWithLastNameField() {
        assertEquals("Getter implementation error",
                entity.getLastName(),
                entity.get(VoterEntityField.LAST_NAME));
    }

    @Test
    public void getWithFirstNameField() {
        assertEquals("Getter implementation error",
                entity.getFirstName(),
                entity.get(VoterEntityField.FIRST_NAME));
    }

    @Test
    public void getWithCivicNumberField() {
        assertEquals("Getter implementation error",
                entity.getCivicNumber(),
                entity.get(VoterEntityField.CIVIC_NUMBER));
    }

    @Test
    public void getWithStreetField() {
        assertEquals("Getter implementation error",
                entity.getStreet(),
                entity.get(VoterEntityField.STREET));
    }

    @Test
    public void getWithStreetDirectionField() {
        assertEquals("Getter implementation error",
                entity.getStreetDirection(),
                entity.get(VoterEntityField.STREET_DIRECTION));
    }

    @Test
    public void getWithStreetGenericField() {
        assertEquals("Getter implementation error",
                entity.getStreetGeneric(),
                entity.get(VoterEntityField.STREET_GENERIC));
    }

    @Test
    public void getWithStreetLinkField() {
        assertEquals("Getter implementation error",
                entity.getStreetLink(),
                entity.get(VoterEntityField.STREET_LINK));
    }

    @Test
    public void getWithPostalCodeCityField() {
        assertEquals("Getter implementation error",
                entity.getPostalCode(),
                entity.get(VoterEntityField.POSTAL_CODE));
    }

    @Test
    public void getWithPhoneNumberField() {
        assertEquals("Getter implementation error",
                entity.getPhoneNumber(),
                entity.get(VoterEntityField.PHONE_NUMBER));
    }
}
