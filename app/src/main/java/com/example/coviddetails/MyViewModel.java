package com.example.coviddetails;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.coviddetails.MyModels.Countries;
import com.example.coviddetails.MyModels.CovidStatistics;

public class MyViewModel extends ViewModel {
    MutableLiveData<Countries>countriesLiveData = new MutableLiveData<>();
    MutableLiveData<CovidStatistics>countriesStatisticsData = new MutableLiveData<>();
    MyRepository myRepository;
    MyListOfMethods listOfMethods;
    public MyViewModel(){
        myRepository = new MyRepository();
    }
    public MutableLiveData<Countries> getCountriesLiveData(){
        return countriesLiveData;
    }
    public MutableLiveData<CovidStatistics> getCountriesStatisticsData(){
        return countriesStatisticsData;
    }

    public void fetchCountries(Context context){
        myRepository.sendRequest(new MyListOfMethods() {
            @Override
            public void fetchListOfCountries(Countries countries) {
                countriesLiveData.postValue(countries);
            }
        },context);
    }
    public void fetchStatistics(Context context){
        myRepository.sendStatisticsRequest(new StatisticsMethods() {
            @Override
            public void fetchCovidStatistics(CovidStatistics statistics) {
                countriesStatisticsData.postValue(statistics);
            }
        },context);
    }



}
