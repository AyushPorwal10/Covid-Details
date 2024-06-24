package com.example.coviddetails.MyModels;
import android.os.Parcelable;
import android.os.Parcel;
public class CountryWiseData implements Parcelable {
    String continent , country ,day , time;
    long population;
    CovidCases cases;
    CovidDeaths deaths;
    CovidTests tests;

    protected CountryWiseData(Parcel in){
        continent = in.readString();
        country = in.readString();
        day = in.readString();
        time = in.readString();
        population = in.readLong();
        cases = in.readParcelable(CovidCases.class.getClassLoader());
        deaths = in.readParcelable(CovidDeaths.class.getClassLoader());
        tests = in.readParcelable(CovidTests.class.getClassLoader());
    }
    public static final Creator<CountryWiseData> CREATOR = new Creator<CountryWiseData>() {
        @Override
        public CountryWiseData createFromParcel(Parcel source) {
            return new CountryWiseData(source);
        }

        @Override
        public CountryWiseData[] newArray(int size) {
            return new CountryWiseData[size];
        }

    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(continent);
        dest.writeString(country);
        dest.writeString(day);
        dest.writeString(time);
        dest.writeLong(population);
        dest.writeParcelable((Parcelable) cases, flags);
        dest.writeParcelable((Parcelable) deaths, flags);
        dest.writeParcelable((Parcelable) tests, flags);
    }
    public CountryWiseData(String continent, String country, String day, String time, long population, CovidCases cases, CovidDeaths deaths, CovidTests tests) {
        this.continent = continent;
        this.country = country;
        this.day = day;
        this.time = time;
        this.population = population;
        this.cases = cases;
        this.deaths = deaths;
        this.tests = tests;
    }


    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public CovidCases getCases() {
        return cases;
    }

    public void setCases(CovidCases cases) {
        this.cases = cases;
    }

    public CovidDeaths getDeaths() {
        return deaths;
    }

    public void setDeaths(CovidDeaths deaths) {
        this.deaths = deaths;
    }

    public CovidTests getTests() {
        return tests;
    }

    public void setTests(CovidTests tests) {
        this.tests = tests;
    }
}
