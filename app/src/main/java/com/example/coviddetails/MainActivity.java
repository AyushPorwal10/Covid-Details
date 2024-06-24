package com.example.coviddetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coviddetails.MyAdapters.HomePageAdapter;
import com.example.coviddetails.MyModels.Countries;
import com.example.coviddetails.MyModels.CovidStatistics;
import com.example.coviddetails.MyUtils.MethodHelper;
import com.example.coviddetails.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.http.Header;


public class MainActivity extends AppCompatActivity {
    HomePageAdapter homePageAdapter;
    ActivityMainBinding binding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.mainRecyclerView.getContext(), LinearLayoutManager.VERTICAL);
        binding.mainRecyclerView.addItemDecoration(dividerItemDecoration);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }

        // Change the status bar icon color to dark
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        MyViewModel myViewModel = new MyViewModel();
        myViewModel.fetchCountries(getApplicationContext());  //this will fetch countries list

        myViewModel.getCountriesLiveData().observe(this, new Observer<Countries>() {
            @Override
            public void onChanged(Countries countries) {
                List<String> list = countries.getResponse();
                if(list.isEmpty()){
                    MethodHelper.showToast("List empty",getApplicationContext());
                }
            }
        });
        myViewModel.fetchStatistics(getApplicationContext());  //this will fetch statistics

        myViewModel.getCountriesStatisticsData().observe(this, new Observer<CovidStatistics>() {
            @Override
            public void onChanged(CovidStatistics statistics) {
                if(statistics == null){
                    MethodHelper.showToast("Statistics are unavailble",getApplicationContext());
                }
                else{
                    showDataToRecyclerView(statistics);
                }
            }
        });
    }
    public void showDataToRecyclerView(CovidStatistics statistics){
        binding.progressBar.setVisibility(View.GONE);
        homePageAdapter = new HomePageAdapter(statistics,MainActivity.this);
        binding.mainRecyclerView.setAdapter(homePageAdapter);
    }
}