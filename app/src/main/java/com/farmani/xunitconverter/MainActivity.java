package com.farmani.xunitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    EditText etValue;
    Spinner unitsSpinner;
    MaterialButton convertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etValue = findViewById(R.id.et_value);
        tvResult = findViewById(R.id.tv_result);
        unitsSpinner = findViewById(R.id.spinner_unit);

        ArrayAdapter<CharSequence> unitsAdapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        unitsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitsSpinner.setAdapter(unitsAdapter);
        convertBtn = findViewById(R.id.btn_convert);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etValue.getText().toString().trim().length() > 0) {
                    double value = Double.parseDouble(etValue.getText().toString());
                    String selectedUnit = unitsSpinner.getSelectedItem().toString();
                    if (selectedUnit.equals("kg to gram")) {
                        tvResult.setText("" + kgToGram(value) + " g");
                    } else if (selectedUnit.equals("gram to kg")) {
                        tvResult.setText("" + gramToKg(value) + " kg");
                    } else if (selectedUnit.equals("celsius to fahrenheit")) {
                        tvResult.setText("" + celsiusToFahrenheit(value) + " F");
                    } else if (selectedUnit.equals("fahrenheit to celsius")) {
                        tvResult.setText("" + fahrenheitToCelsius(value) + " C");
                    } else if (selectedUnit.equals("km to miles")) {
                        tvResult.setText("" + kmToMiles(value) + " m");
                    } else if (selectedUnit.equals("miles to km")) {
                        tvResult.setText("" + milesToKm(value) + " km");
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Value Can't be Empty", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    public double kgToGram(double value) {
        return value * 1000;
    }

    public double gramToKg(double value) {
        return value / 1000;
    }

    public double celsiusToFahrenheit(double value) {
        return value * 1.8 + 32;
    }

    public double fahrenheitToCelsius(double value) {
        return (value - 32) / 1.8;
    }

    public double kmToMiles(double value) {
        return value * 0.62137;
    }

    public double milesToKm(double value) {
        return value * 1.6093;
    }
}