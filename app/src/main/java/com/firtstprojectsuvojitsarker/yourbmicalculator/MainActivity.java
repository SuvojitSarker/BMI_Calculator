package com.firtstprojectsuvojitsarker.yourbmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edweight, edFeet, edInch;
    Button buttonCalculator;
    TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edweight = findViewById(R.id.edweight);
        edFeet = findViewById(R.id.edFeet);
        edInch = findViewById(R.id.edInch);
        buttonCalculator = findViewById(R.id.buttonCalculator);
        result = findViewById(R.id.result);

        buttonCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Sweight = edweight.getText().toString();
                String Sfeet = edFeet.getText().toString();
                String Sinch = edInch.getText().toString();
                if (Sweight.isEmpty()) {
                    edweight.setError("Please input weight");
                } else {
                    if (Sfeet.isEmpty()) {
                        edFeet.setError("Please input feet");
                    } else {
                        if (Sinch.isEmpty()) {
                            edInch.setError("Please input inch");
                        } else {
                            float weight = Float.parseFloat(Sweight);
                            float feet = Float.parseFloat(Sfeet);
                            float inch = Float.parseFloat(Sinch);

                            float height = (float) (feet * 0.3084 + inch * 0.0254);
                            float bmicalculate = weight / (height * height);

                            if (bmicalculate > 24) {
                                result.setText("your BMI result :" + bmicalculate + "\n Over Weight");
                                // Toast.makeText(MainActivity.this, "You're  pig", Toast.LENGTH_SHORT).show();
                            } else if (bmicalculate > 18) {
                                result.setText("your BMI result :" + bmicalculate + "\n Perfect");
                                // Toast.makeText(MainActivity.this, "Fit", Toast.LENGTH_SHORT).show();
                            } else {
                                result.setText("your BMI result :" + bmicalculate + "\n Under Weight");
                                //   Toast.makeText(MainActivity.this, "Thin", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            }
        });
    }
}