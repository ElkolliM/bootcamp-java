package com.stackroute.hackathon.partieA;

public class Country {
    private String countryId;
    private String CountryName;


    public Country(String countryId, String countryName) {
        this.countryId = countryId;
        CountryName = countryName;
    }


    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }


}
