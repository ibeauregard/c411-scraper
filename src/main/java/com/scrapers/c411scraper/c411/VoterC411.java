package com.scrapers.c411scraper.c411;

public class VoterC411 {
    private final String firstName;
    private final String lastName;
    private final String streetAddress;
    private final String city;
    private final String province;
    private final String postalCode;

    public static class Builder {
        private String firstName;
        private String lastName;
        private String streetAddress;
        private String city;
        private String province;
        private String postalCode;

        private Builder() {

        }

        public Builder withFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withStreetAddress(final String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder withCity(final String city) {
            this.city = city;
            return this;
        }

        public Builder withProvince(final String province) {
            this.province = province;
            return this;
        }

        public Builder withPostalCode(final String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public VoterC411 build() {
            return new VoterC411(this);
        }
    }

    private VoterC411(final Builder builder) {
        assert builder.firstName != null : "VoterC411 must have non null first name";
        firstName = builder.firstName;

        assert builder.lastName != null : "VoterC411 must have non null last name";
        lastName = builder.lastName;

        assert builder.streetAddress != null : "VoterC411 must have non null street address";
        streetAddress = builder.streetAddress;

        assert builder.city != null : "VoterC411 must have non null city";
        city = builder.city;

        assert builder.province != null : "VoterC411 must have non null province";
        province = builder.province;

        assert builder.postalCode != null : "VoterC411 must have non null postal code";
        postalCode = builder.postalCode;
    }

    public static Builder create() {
        return new Builder();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
