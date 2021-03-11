package com.scrapers.c411scraper.entity;

public class VoterEntity {
    private final String city;
    private final String lastName;
    private final String firstName;
    private final String civicNumber;
    private final String street;
    private final String streetDirection;
    private final String streetGeneric;
    private final String streetLink;
    private final String postalCode;
    private final String province;
    private final String phoneNumber;

    public static class Builder {
        private String city;
        private String lastName;
        private String firstName;
        private String civicNumber;
        private String street;
        private String streetDirection;
        private String streetGeneric;
        private String streetLink;
        private String postalCode;
        private String province = "QC";
        private String phoneNumber;

        private Builder() {

        }

        public Builder withCity(final String city) {
            this.city = city;
            return this;
        }

        public Builder withLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withCivicNumber(final String civicNumber) {
            this.civicNumber = civicNumber;
            return this;
        }

        public Builder withStreet(final String street) {
            this.street = street;
            return this;
        }

        public Builder withStreetDirection(final String streetDirection) {
            this.streetDirection = streetDirection;
            return this;
        }

        public Builder withStreetGeneric(final String streetGeneric) {
            this.streetGeneric = streetGeneric;
            return this;
        }

        public Builder withStreetLink(final String streetLink) {
            this.streetLink = streetLink;
            return this;
        }

        public Builder withPostalCode(final String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder withProvince(final String province) {
            this.province = province;
            return this;
        }

        public Builder withPhoneNumber(final String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public VoterEntity build() {
            return new VoterEntity(this);
        }
    }

    private VoterEntity(final Builder builder) {
        assert builder.city != null : "Voter entity cannot have null city";
        city = builder.city;

        assert builder.lastName != null : "Voter entity cannot have null last name";
        lastName = builder.lastName;

        assert builder.firstName != null : "Voter entity cannot have null first name";
        firstName = builder.firstName;

        assert builder.civicNumber != null : "Voter entity cannot have null civic number";
        civicNumber = builder.civicNumber;

        assert builder.street != null : "Voter entity cannot have null street";
        street = builder.street;

        streetDirection = builder.streetDirection;

        streetGeneric = builder.streetGeneric;

        streetLink = builder.streetLink;

        assert builder.postalCode != null : "Voter entity cannot have null postal code";
        postalCode = builder.postalCode;

        province = builder.province;

        phoneNumber = builder.phoneNumber;
    }

    public static Builder create() {
        return new Builder();
    }

    public String getCity() {
        return city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCivicNumber() {
        return civicNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetDirection() {
        return streetDirection;
    }

    public String getStreetGeneric() {
        return streetGeneric;
    }

    public String getStreetLink() {
        return streetLink;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String get(final VoterEntityField field) {
        switch (field) {
            case CITY:
                return city;
            case LAST_NAME:
                return lastName;
            case FIRST_NAME:
                return firstName;
            case CIVIC_NUMBER:
                return civicNumber;
            case STREET:
                return street;
            case STREET_DIRECTION:
                return streetDirection;
            case STREET_GENERIC:
                return streetGeneric;
            case STREET_LINK:
                return streetLink;
            case POSTAL_CODE:
                return postalCode;
            case PHONE_NUMBER:
                return phoneNumber;
            default:
                throw new RuntimeException("Enum variable had a value other than enum constants");
        }
    }
}
