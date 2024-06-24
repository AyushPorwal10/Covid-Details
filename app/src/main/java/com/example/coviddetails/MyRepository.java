package com.example.coviddetails;

import android.content.Context;
import android.provider.ContactsContract;
import android.widget.Toast;

import com.example.coviddetails.MyModels.Countries;
import com.example.coviddetails.MyModels.CovidStatistics;
import com.example.coviddetails.MyUtils.MethodHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyRepository {
    public final String API_KEY = "958f1b2498mshd2549ec2620595cp1efabajsnda88dd1e9bb6";
    public final String API_HOST = "covid-193.p.rapidapi.com";

    Retrofit retrofit;
    DatabaseRetrofit.RequestParameter requestParameter;
    public MyRepository(){
        DatabaseRetrofit databaseRetrofit = new DatabaseRetrofit();
        retrofit = databaseRetrofit.getInstance();
        requestParameter = retrofit.create(DatabaseRetrofit.RequestParameter.class);
    }

    public void sendRequest(MyListOfMethods obj, Context context){

        Call<Countries> call = requestParameter.getCountry(API_KEY,API_HOST);
        call.enqueue(new Callback<Countries>() {
            @Override
            public void onResponse(Call<Countries> call, Response<Countries> response) {
                if(response.body() != null){
                    obj.fetchListOfCountries(response.body());
                }
            }

            @Override
            public void onFailure(Call<Countries> call, Throwable throwable) {
                MethodHelper.showToast("Error in response",context);
            }
        });
    }
    public void sendStatisticsRequest(StatisticsMethods obj , Context context){
        Call<CovidStatistics> call = requestParameter.getStatistics(API_KEY,API_HOST);
        call.enqueue(new Callback<CovidStatistics>() {
            @Override
            public void onResponse(Call<CovidStatistics> call, Response<CovidStatistics> response) {
                if(response.body() != null){

                    obj.fetchCovidStatistics(response.body());
                }
                else{
                    MethodHelper.showToast("Statistics are empty",context);
                }
            }

            @Override
            public void onFailure(Call<CovidStatistics> call, Throwable throwable) {

            }
        });
    }

}
