package com.example.coviddetails.MyModels;

import com.google.gson.annotations.SerializedName;
import android.os.Parcelable;
import android.os.Parcel;
public class CovidDeaths implements Parcelable{
    @SerializedName("new")
    long newCases;
    @SerializedName("1M_pop")
    String pop;
    long total ;

    public CovidDeaths(long newCases, String pop, long total) {
        this.newCases = newCases;
        this.pop = pop;
        this.total = total;
    }
    protected CovidDeaths(Parcel in) {
        newCases = in.readLong();
        pop = in.readString();
        total = in.readLong();
    }

    public static final Creator<CovidDeaths> CREATOR = new Creator<CovidDeaths>() {
        @Override
        public CovidDeaths createFromParcel(Parcel in) {
            return new CovidDeaths(in);
        }

        @Override
        public CovidDeaths[] newArray(int size) {
            return new CovidDeaths[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(newCases);
        dest.writeString(pop);
        dest.writeLong(total);
    }


    public long getNewCases() {
        return newCases;
    }

    public void setNewCases(long newCases) {
        this.newCases = newCases;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
