package com.example.coviddetails.MyModels;

import com.google.gson.annotations.SerializedName;
import android.os.Parcelable;
import android.os.Parcel;
public class CovidTests implements Parcelable{
    @SerializedName("1M_pop")
    String pop;
    long total ;

    public CovidTests(String pop, long total) {
        this.pop = pop;
        this.total = total;
    }
    protected CovidTests(Parcel in) {
        pop = in.readString();
        total = in.readLong();
    }

    public static final Creator<CovidTests> CREATOR = new Creator<CovidTests>() {
        @Override
        public CovidTests createFromParcel(Parcel in) {
            return new CovidTests(in);
        }

        @Override
        public CovidTests[] newArray(int size) {
            return new CovidTests[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pop);
        dest.writeLong(total);
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
