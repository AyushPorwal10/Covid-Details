package com.example.coviddetails.MyModels;

import java.util.ArrayList;

public class Countries {
    String countries;
    ArrayList<String> response ;
    int results;

    public Countries(String countries, ArrayList<String> response, int results) {
        this.countries = countries;
        this.response = response;
        this.results = results;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }

    public ArrayList<String> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<String> response) {
        this.response = response;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }
}
