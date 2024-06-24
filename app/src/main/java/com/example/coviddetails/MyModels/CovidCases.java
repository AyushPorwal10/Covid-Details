package com.example.coviddetails.MyModels;

import com.google.gson.annotations.SerializedName;
import android.os.Parcelable;
import android.os.Parcel;
public class CovidCases implements Parcelable{
     @SerializedName("new")
     long newCases;
     long active , critical , recovered , total ;
     @SerializedName("1M_pop")
     String pop;

    public CovidCases(long newCases, long active, long critical, long recovered, long total, String pop) {
        this.newCases = newCases;
        this.active = active;
        this.critical = critical;
        this.recovered = recovered;
        this.total = total;
        this.pop = pop;
    }
    protected CovidCases(Parcel in) {
        newCases = in.readLong();
        active = in.readLong();
        critical = in.readLong();
        recovered = in.readLong();
        total = in.readLong();
        pop = in.readString();
    }

    public static final Creator<CovidCases> CREATOR = new Creator<CovidCases>() {
        @Override
        public CovidCases createFromParcel(Parcel in) {
            return new CovidCases(in);
        }

        @Override
        public CovidCases[] newArray(int size) {
            return new CovidCases[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(newCases);
        dest.writeLong(active);
        dest.writeLong(critical);
        dest.writeLong(recovered);
        dest.writeLong(total);
        dest.writeString(pop);
    }

    public long getNewCases() {
        return newCases;
    }

    public void setNewCases(long newCases) {
        this.newCases = newCases;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public long getCritical() {
        return critical;
    }

    public void setCritical(long critical) {
        this.critical = critical;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getPop() {
        return pop;
    }

    public void setPop(String pop) {
        this.pop = pop;
    }
}
