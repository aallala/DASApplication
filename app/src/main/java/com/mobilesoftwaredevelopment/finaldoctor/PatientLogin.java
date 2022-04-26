package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

public class PatientLogin extends AppCompatActivity {

    EditText patientUsername,patientPassword;
    Button patientLoginButton;
    TextView patientSignUpButton;
    DatabaseHelper data;
    SessionManager sessionManager;
    TextInputLayout patientUsername1,patientPassword1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);
        getSupportActionBar().hide();
        Window window = PatientLogin.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(PatientLogin.this,R.color.custom));
        patientUsername1 = (TextInputLayout) findViewById(R.id.patientUsername);
        patientPassword1 = (TextInputLayout) findViewById(R.id.patientPassword);
//        patientUsername = (EditText) findViewById(R.id.patientUsername);
//        patientPassword = (EditText) findViewById(R.id.patientPassword);
        patientLoginButton = (Button) findViewById(R.id.patientLoginButton);
        patientSignUpButton = (TextView) findViewById(R.id.patientSignUpButton);
        data = new DatabaseHelper(this);
        sessionManager = new SessionManager(getApplicationContext());
        patientLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = patientUsername1.getEditText().getText().toString();
                String password = patientPassword1.getEditText().getText().toString();
//                String username = patientUsername.getText().toString();
//                String password = patientPassword.getText().toString();

                if(username.equals("")){
                    Toast.makeText(PatientLogin.this,"Please Enter Username",Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals("")){
                        Toast.makeText(PatientLogin.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                    }else{
                        if(data.checkUsernamePassword(username,password)){
//                          setContentView(R.layout.fragment_patient_dashboard);
                            navigateIntoPatientDashboard(username);
                            Toast.makeText(PatientLogin.this,"User Validation Successfully Completed",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(PatientLogin.this,"Please Enter Valid Cridencials",Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            }
        });


        patientSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpButton();
//                setContentView(R.layout.activity_patient_register);
            }
        });
    }

    private void navigateIntoPatientDashboard(String username) {
        Intent intent = new Intent(PatientLogin.this,PatientActivity.class);
        sessionManager.setUsername(username);
        startActivity(intent);
    }

    private void signUpButton() {
        Intent intent = new Intent(PatientLogin.this,PatientRegistration.class);
        startActivity(intent);
    }
}