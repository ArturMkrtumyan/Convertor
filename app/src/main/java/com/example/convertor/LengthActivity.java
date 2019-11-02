package com.example.convertor;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class LengthActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText val;
    private TextView ans;
    private Spinner from, to;
    private Integer positionFrom, positionTO;
    private Button convert;
    private double value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
        val = findViewById(R.id.editText_from);
        ans = findViewById(R.id.textview_to);
        from = findViewById(R.id.spinner_from);
        to = findViewById(R.id.spinner_to);

        convert = findViewById(R.id.button_convert);
        List<String> unitlength = new ArrayList<String>();

        unitlength.add("Meter");
        unitlength.add("Centimeter");
        unitlength.add("Kilometer");
        unitlength.add("Miles");
        unitlength.add("Foot");
        unitlength.add("Inches");
        unitlength.add("Yard");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unitlength);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        from.setAdapter(dataAdapter);

        ArrayAdapter<String> unit = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, unitlength);
        unit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        to.setAdapter(unit);
        from.setOnItemSelectedListener(this);
        to.setOnItemSelectedListener(this);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method(v);
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        parent.getItemAtPosition(position);

        switch (parent.getId()) {
            case R.id.spinner_from:
                from.setSelection(position);
                positionFrom = from.getSelectedItemPosition();
                break;

            case R.id.spinner_to:
                to.setSelection(position);
                positionTO = to.getSelectedItemPosition();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void method(View view) {
        double res;
        if (val.getText().toString() != null) {
            try {
                value = Double.parseDouble(val.getText().toString());
            } catch (Exception e) {

            }
        }
        if (positionFrom == 0) {
            if (positionTO == 0) {
                if (val != null) {
                    try {
                        ans.setText(val.getText().toString());
                    } catch (Exception e) {

                    }
                }
            }
            if (positionTO == 1) {
                res = value * 100;
                ans.setText(Double.toString(res));
            }

            if (positionTO == 2) {
                res = value / 1000;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 3) {
                res = value * 1609.34;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 4) {
                res = value * 3.28084;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 5) {
                res = value * 39.3701;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 6) {
                res = value * 1.09361;
                ans.setText(Double.toString(res));
            }
        }
        if (positionFrom == 1) {
            if (positionTO == 0) {
                res = value / 100;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 1) {
                ans.setText(val.getText().toString());
            }
            if (positionTO == 2) {
                res = value / 100000;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 3) {
                res = value / 160934;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 4) {
                res = value * 0.0328084;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 5) {
                res = value * 0.393701;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 6) {
                res = value * 0.0109361;
                ans.setText(Double.toString(res));
            }
        }
        if (positionFrom == 2) {
            if (positionTO == 0) {
                res = value * 1000;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 1) {
                res = value * 100000;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 2) {
                ans.setText(val.getText().toString());
            }
            if (positionTO == 3) {
                res = value * 0.621371;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 4) {
                res = value * 3280.84;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 5) {
                res = value * 39370.1;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 6) {
                res = value * 1093.61;
                ans.setText(Double.toString(res));
            }
        }
        if (positionFrom == 3) {
            if (positionTO == 0) {
                res = value * 1609.34;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 1) {
                res = value * 160934;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 2) {
                res = value * 160934;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 3) {
                ans.setText(val.getText().toString());
            }
            if (positionTO == 4) {
                res = value * 5280;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 5) {
                res = value * 63360;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 6) {
                res = value * 1760;
                ans.setText(Double.toString(res));
            }
        }
        if (positionFrom == 4) {
            if (positionTO == 0) {
                res = value * 0.3048;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 1) {
                res = value * 30.48;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 2) {
                res = value / 3280.84;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 3) {
                res = value * 0.000189394;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 4) {
                ans.setText(val.getText().toString());
            }
            if (positionTO == 5) {
                res = value * 12;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 6) {
                res = value * 0.333333;
                ans.setText(Double.toString(res));
            }
        }
        if (positionFrom == 5) {
            if (positionTO == 0) {
                res = value * 0.0254;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 1) {
                res = value * 2.54;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 2) {
                res = value * 2.54e-5;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 3) {
                res = value * 1.5783e-5;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 4) {
                res = value * 0.0833333;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 5) {
                ans.setText(val.getText().toString());
            }
            if (positionTO == 6) {
                res = value * 0.0277778;
                ans.setText(Double.toString(res));
            }
        }
        if (positionFrom == 6) {
            if (positionTO == 0) {
                res = value * 0.9144;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 1) {
                res = value * 91.44;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 2) {
                res = value * 0.0009144;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 3) {
                res = value * 0.000568182;
                ans.setText(Double.toString(res));
            }
            if (positionTO == 4) {
                res = value * 3;
                ans.setText(Double.toString(res));
            }

            if (positionTO == 5) {
                res = value * 36;
                ans.setText(Double.toString(res));
            }

            if (positionTO == 6) {
                ans.setText(val.getText().toString());
            }
        }
    }
}

