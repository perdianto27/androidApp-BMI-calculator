package com.example.perdianto.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //deklarasi variable
    EditText etHeight, etWeight;
    TextView tvScore, tvSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menyambung view d xml ke java
        etHeight= findViewById(R.id.etHeight);
        etWeight= findViewById(R.id.etWeight);
        tvScore=findViewById(R.id.tvScore);
        tvSummary= findViewById(R.id.tvScore);
    }

    public void hitungBMI(View view) {

        String sHeight, sWeight;
        Double dHeight, dWeight;

        //ambil value dari edittext
        sHeight=etHeight.getText().toString();

        //konversi dari String ke double
        dHeight=Double.parseDouble(sHeight)/100;

        sWeight=etWeight.getText().toString();
        dWeight=Double.parseDouble(sWeight);

        //hitung rumus bmi
        double dScore = dWeight / (dHeight*dHeight);

        //letakan output ditextview
        tvScore.setText(""+dScore);

        //logika summary
        if(dScore < 18.5) {
            tvSummary.setText("Your BMI is less than ideal.");
        }else if (dScore > 23){
            tvSummary.setText("Your BMI is more than ideal");
        }
        else{
            tvSummary.setText("Your BMI is ideal");

            //pindah halaman
            Intent niat = new Intent
                    (this, SecondActivity.class);
            startActivity(niat);
        }

        Toast.makeText(this, ""+(dScore), Toast.LENGTH_SHORT).show();

    }
}
