package com.example.coviddetails.MyModels;

import java.util.ArrayList;
import java.util.List;

public class CovidStatistics {
    String get , results;
    ArrayList<CountryWiseData> response;

    public CovidStatistics(String get, String results, ArrayList<CountryWiseData> response) {
        this.get = get;
        this.results = results;
        this.response = response;
    }

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public ArrayList<CountryWiseData> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<CountryWiseData> response) {
        this.response = response;
    }
}
