package com.example.coviddetails;

import com.example.coviddetails.MyModels.Countries;
import com.example.coviddetails.MyModels.CovidStatistics;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;


public class DatabaseRetrofit {
    Retrofit retrofit ;
    private final String URL = "https://covid-193.p.rapidapi.com/";
    DatabaseRetrofit(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(URL)
                    .build();
        }
    }


    public Retrofit getInstance(){
        if(retrofit == null){
            new DatabaseRetrofit();
        }
        return retrofit;
    }
    public interface RequestParameter{
        @GET("countries")
        public Call<Countries> getCountry(
                @Header("x-rapidapi-key")String apiKey,
                @Header("x-rapidapi-host")String apiHost
        );
        @GET("statistics")
        public Call<CovidStatistics> getStatistics(
                @Header("x-rapidapi-key")String apiKey,
                @Header("x-rapidapi-host") String apiHost
        );


    }
}
