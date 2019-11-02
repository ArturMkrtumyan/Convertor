package com.example.convertor.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currencies {
    @SerializedName("rates")
    @Expose
    private Rates rates;

    public Rates getRates() {
        return rates;
    }
}
