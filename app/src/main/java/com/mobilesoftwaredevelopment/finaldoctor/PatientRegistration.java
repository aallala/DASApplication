package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.mobilesoftwaredevelopment.finaldoctor.database.DBHelper;
import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

public class PatientRegistration extends AppCompatActivity {

//    EditText patientName,patientEmail,patientMobileNO,patientPassword,patientPassword2;
    TextInputLayout patientName,patientEmail,patientMobileNO,patientPassword,patientPassword2;
    Button patientRegistration;
    TextView navigateSignInPage;
    DBHelper data;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);
        getSupportActionBar().hide();
        Window window = PatientRegistration.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(PatientRegistration.this,R.color.custom));

        patientName = (TextInputLayout) findViewById(R.id.patientName);
        patientEmail = (TextInputLayout) findViewById(R.id.patientEmail);
        patientMobileNO = (TextInputLayout) findViewById(R.id.patientMobileNO);
        patientPassword = (TextInputLayout) findViewById(R.id.patientPassword);
        patientPassword2 = (TextInputLayout) findViewById(R.id.patientPassword2);
        patientRegistration = (Button) findViewById(R.id.patientRegistration);
        navigateSignInPage = (TextView) findViewById(R.id.navigateSignInPage);
        data = new DBHelper(this);
        databaseHelper = new DatabaseHelper(this);
        patientRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String name =  patientName.getText().toString();
//                String email = patientEmail.getText().toString();
//                String mobileNo = patientMobileNO.getText().toString();
//                String password = patientPassword.getText().toString();
//                String pw2 = patientPassword2.getText().toString();

                String name = patientName.getEditText().getText().toString();
                String email = patientEmail.getEditText().getText().toString();
                String mobileNo = patientMobileNO.getEditText().getText().toString();
                String password = patientPassword.getEditText().getText().toString();
                String pw2 = patientPassword2.getEditText().getText().toString();



                if(name.equals("") || email.equals("") || mobileNo.equals("") || password.equals("") || pw2.equals("")){
                    Toast.makeText(PatientRegistration.this, "Please Fill All the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals(pw2)){
                        Boolean result = databaseHelper.checkUser(email);
                        if(result == false){
                            String resultInsert = databaseHelper.userRegistration(name,email,mobileNo,password);
                            if(resultInsert != null){

                                navigateLoginPage();
                                Toast.makeText(PatientRegistration.this,"UserCreate Successfully",Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(PatientRegistration.this, "User Already Exits. \n please SignIn", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(PatientRegistration.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        navigateSignInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInPage();
//                setContentView(R.layout.activity_patient_login);
            }
        });
    }
    private void navigateLoginPage() {
        Intent intent = new Intent(PatientRegistration.this,PatientLogin.class);
        startActivity(intent);
    }

    private void signInPage() {
        Intent intent = new Intent(PatientRegistration.this,PatientLogin.class);
        startActivity(intent);
    }
}