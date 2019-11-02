package com.example.convertor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.convertor.Api.ApiClient;
import com.example.convertor.Api.ApiInterface;
import com.example.convertor.Models.Currencies;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private Spinner spinner;
    private Button buttonCalculate;
    private TextView goLenghtconvertor;
    private double inputEuro;
    private StringBuilder nameRate;
    private ArrayAdapter<CharSequence> adapter;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goLenghtconvertor = findViewById(R.id.length_convertor);
        textView = findViewById(R.id.tvOutputRate);
        editText = findViewById(R.id.euroInput);
        spinner = findViewById(R.id.spinner);
        buttonCalculate = findViewById(R.id.btnCalculate);
        nameRate = new StringBuilder();
        adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nameRate.setLength(0);
                switch (position) {
                    case 0:
                        nameRate.append(parent.getItemAtPosition(position).toString());
                        break;
                    case 1:
                        nameRate.append(parent.getItemAtPosition(position).toString());
                        break;
                    case 2:
                        nameRate.append(parent.getItemAtPosition(position).toString());
                        break;
                    case 3:
                        nameRate.append(parent.getItemAtPosition(position).toString());
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText() != null) {
                    try {
                        inputEuro = Double.parseDouble(editText.getText().toString());
                        loadJson();
                    } catch (Exception e) {
                    }
                }
            }
        });
        goLenghtconvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LengthActivity.class));

            }
        });
    }

    public void loadJson() {
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Currencies> call;
        call = apiInterface.getCurrency();
        call.enqueue(new Callback<Currencies>() {
            @Override
            public void onResponse(Call<Currencies> call, Response<Currencies> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (nameRate.toString().equals("USD")) {
                        inputEuro = inputEuro * response.body().getRates().getEurUSD();
                    }
                    if (nameRate.toString().equals("AMD")) {
                        inputEuro = inputEuro * response.body().getRates().getEURAMD();
                    }
                    if (nameRate.toString().equals("GBP")) {
                        inputEuro = inputEuro * response.body().getRates().getEURGBP();
                    }
                    if (nameRate.toString().equals("RUB")) {
                        inputEuro = inputEuro * response.body().getRates().getEURRub();
                    }
                    textView.setText(String.valueOf(inputEuro));
                } else {
                    Toast.makeText(getApplicationContext(), "Not response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Currencies> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Call Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
