package com.example.coviddetails.MyAdapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coviddetails.MyModels.CountryWiseData;
import com.example.coviddetails.MyModels.CovidStatistics;
import com.example.coviddetails.R;
import com.example.coviddetails.ShowData;
import com.example.coviddetails.databinding.SingleRowMainBinding;

import java.util.ArrayList;
import java.util.List;

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.MyViewHolder> {
    CovidStatistics statistics;
    Context context ;
    ArrayList<CountryWiseData> countryWiseDataList;
    int lastPosition = -1;

    public HomePageAdapter(CovidStatistics statistics, Context context) {
        this.statistics = statistics;
        this.context = context;
        countryWiseDataList = statistics.getResponse();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        SingleRowMainBinding binding = SingleRowMainBinding.inflate(inflater,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.binding.continent.setText("Continent : " + countryWiseDataList.get(position).getContinent());
        holder.binding.country.setText("Country : " + countryWiseDataList.get(position).getCountry());
        holder.binding.population.setText("Country's Population : " + String.valueOf(countryWiseDataList.get(position).getPopulation()));

        setAnimation(holder.itemView,position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ShowData.class);
                intent.putExtra("casesModel",countryWiseDataList.get(holder.getAdapterPosition()).getCases());
                intent.putExtra("deathModel",countryWiseDataList.get(holder.getAdapterPosition()).getDeaths());
                intent.putExtra("testsModel",countryWiseDataList.get(holder.getAdapterPosition()).getTests());
                intent.putExtra("country",countryWiseDataList.get(holder.getAdapterPosition()).getCountry());
                intent.putExtra("day",countryWiseDataList.get(holder.getAdapterPosition()).getDay());
                context.startActivity(new Intent(intent));
            }
        });
    }

    @Override
    public int getItemCount() {
        return countryWiseDataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        SingleRowMainBinding binding;

        public MyViewHolder(@NonNull SingleRowMainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public  void setAnimation(View view,int position){
        if(position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(animation);
            lastPosition = position;
        }

    }
}
