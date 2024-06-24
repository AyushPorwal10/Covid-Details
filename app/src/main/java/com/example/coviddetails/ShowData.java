package com.example.coviddetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.coviddetails.MyModels.CovidCases;
import com.example.coviddetails.MyModels.CovidDeaths;
import com.example.coviddetails.MyModels.CovidStatistics;
import com.example.coviddetails.MyModels.CovidTests;
import com.example.coviddetails.MyUtils.MethodHelper;
import com.example.coviddetails.databinding.ActivityShowDataBinding;

public class ShowData extends AppCompatActivity {
    ActivityShowDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         binding = ActivityShowDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }

        // Change the status bar icon color to dark
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);



        CovidCases covidCases = getIntent().getParcelableExtra("casesModel");
        CovidTests covidTests = getIntent().getParcelableExtra("testsModel");
        CovidDeaths covidDeaths = getIntent().getParcelableExtra("deathModel");
        String country = getIntent().getStringExtra("country");
        String day = getIntent().getStringExtra("day");

        binding.country.setText(country);

        showCovidCases(covidCases);
        showCovidDeaths(covidDeaths);
        showCovidTest(covidTests);
    }

    public void showCovidCases(CovidCases covidCases){
        if(covidCases != null){
            if(covidCases.getNewCases() == 0){
                binding.newCases.setText("No New Cases");
            }else {
                binding.newCases.setText("New Cases : "+String.valueOf(covidCases.getNewCases()));
            }
            if(covidCases.getActive() == 0){
                binding.activeCase.setText("No active Cases");
            }

            else{
                binding.activeCase.setText("Active Cases : "+String.valueOf(covidCases.getActive()));
            }


            if(covidCases.getCritical() == 0){
                binding.criticalCase.setText("No critical Cases");
            }

            else{
                binding.criticalCase.setText("Critical Cases : "+String.valueOf(covidCases.getCritical()));
            }

            if(covidCases.getRecovered() == 0){
                binding.recoveredCase.setText("No recovery");
            }

            else{
                binding.recoveredCase.setText("Recovered Cases : "+String.valueOf(covidCases.getRecovered()));
            }


            if(covidCases.getTotal() == 0){
                binding.totalCase.setText("No Cases");
            }

            else{
                binding.totalCase.setText("Total Case : " + String.valueOf(covidCases.getTotal()));
            }

        }
        else{
            MethodHelper.showToast("Covid Cases are null",getApplicationContext());
        }
    }
    public void showCovidDeaths(CovidDeaths covidDeaths){
        if(covidDeaths != null){
            if(covidDeaths.getTotal() == 0){
                binding.totalDeaths.setText("No death");
            }
            else {
                binding.totalDeaths.setText("Total Deaths : " + String.valueOf(covidDeaths.getTotal()));
            }
            if(covidDeaths.getNewCases() == 0){
                binding.newDeaths.setText("No new death");
            }
            else {
                binding.newDeaths.setText("New Deaths" + String.valueOf(covidDeaths.getTotal()));
            }

                binding.perMillionDeath.setText("Death per million " +String.valueOf(covidDeaths.getPop()));

        }
        else{
            MethodHelper.showToast("Deaths data is not available",ShowData.this);
        }
    }
    public void showCovidTest(CovidTests covidTests){
        if(covidTests != null){
            if(covidTests.getTotal() == 0){
                binding.totalTest.setText("No test conducted");
            }
            else{
                binding.totalTest.setText(String.valueOf(covidTests.getTotal()));
            }

                if(covidTests.getPop() != null){
                    binding.totalTest.setText("No test conducted");
                }
                else{
                    binding.totalTest.setText(covidTests.getPop());
                }


        }
        else {
            MethodHelper.showToast("Test data is not available",ShowData.this);
        }
    }
}