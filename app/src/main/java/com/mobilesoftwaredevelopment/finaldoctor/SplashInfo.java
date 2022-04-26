package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SplashInfo extends AppCompatActivity {

    Button doctorButton,patientButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_info);
        getSupportActionBar().hide();

        Window window = SplashInfo.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(SplashInfo.this,R.color.custom));

        doctorButton = (Button) findViewById(R.id.doctorButton);
        patientButton = (Button) findViewById(R.id.patientButton);
        doctorButton.setTextColor(Color.WHITE);
        patientButton.setTextColor(Color.WHITE);
        doctorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doctorButton();
            }
        });

        patientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientButton();
            }
        });
    }
    private void patientButton() {
        Intent intent = new Intent(SplashInfo.this,PatientLogin.class);
        startActivity(intent);
    }

    private void doctorButton() {
        Intent intent = new Intent(SplashInfo.this,DoctorLogin.class);
        startActivity(intent);
    }
}