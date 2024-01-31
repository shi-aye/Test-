package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonConvert = findViewById(R.id.buttonConvert);

       EditText editTextTemperature = findViewById(R.id.editTextTemperature);

        RadioGroup radioGroupUnits =findViewById(R.id.radioGroupUnits);

        TextView textViewResult = findViewById(R.id.textViewResult);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature(editTextTemperature.getText().toString(), radioGroupUnits.getCheckedRadioButtonId(),textViewResult);

            }
        });
        Button buttonExit = findViewById(R.id.buttonExit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Long press to exit", Toast.LENGTH_SHORT).show();
            }
        });

        buttonExit.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                finish();
                return false;
            }
        });

    }

    private void convertTemperature(String temperature, int selectedUnit, TextView resultTextView){

        if (!temperature.isEmpty()) {



            double inputTemp = Double.parseDouble(temperature);

            if (selectedUnit == R.id.radioButtonCelsius) {

                double fahrenheit = (inputTemp * 9 / 5) + 32;

                resultTextView.setText(String.format("%.2f°F", fahrenheit));

            } else {

                double celsius = (inputTemp - 32) * 5 / 9;

                resultTextView.setText(String.format("%.2f°C", celsius));

            }

        } else {



            resultTextView.setText("Please enter a temperature.");

        }


    }

    public void callUs(View view){
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:+966550047213"));
        startActivity(i);
    }
    public void About (View view){
        Intent i = new Intent(this, inform.class);
        startActivity(i);
    }
}