package com.example.convertor.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rates {
    @SerializedName("USD")
    @Expose
    private double usdEur;
    @SerializedName("AMD")
    @Expose
    private double amdEur;
    @SerializedName("RUB")
    @Expose
    private double rubEur;
    @SerializedName("GBP")
    @Expose
    private double gbpEur;

    public double getEurUSD() {
        return usdEur;
    }

    public double getEURAMD() {
        return amdEur;
    }

    public double getEURRub() {
        return rubEur;
    }

    public double getEURGBP() {
        return gbpEur;
    }
}
