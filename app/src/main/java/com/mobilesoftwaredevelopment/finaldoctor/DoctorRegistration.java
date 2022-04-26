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
import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

public class DoctorRegistration extends AppCompatActivity {

//    EditText doctorName,doctorEmail,doctorMobileNO,doctorPassword,doctorPassword2;
    TextInputLayout doctorName,doctorEmail,doctorMobileNO,doctorPassword,doctorPassword2;
    Button doctorRegistration;
    TextView navigateSignInPage;
    DatabaseHelper data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_registration);
        getSupportActionBar().hide();

        //Status Bar Color Code
        Window window = DoctorRegistration.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(DoctorRegistration.this,R.color.custom));

        doctorName = (TextInputLayout) findViewById(R.id.doctorName);
        doctorEmail = (TextInputLayout) findViewById(R.id.doctorEmail);
        doctorMobileNO = (TextInputLayout) findViewById(R.id.doctorMobileNO);
        doctorPassword = (TextInputLayout) findViewById(R.id.doctorPassword);
        doctorPassword2 = (TextInputLayout) findViewById(R.id.doctorPassword2);
        doctorRegistration = (Button) findViewById(R.id.doctorRegistration);
        navigateSignInPage = (TextView) findViewById(R.id.navigateSignInPage);
        data=new DatabaseHelper(this);
        doctorRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name =  doctorName.getEditText().getText().toString();
                String email = doctorEmail.getEditText().getText().toString();
                String mobileNo = doctorMobileNO.getEditText().getText().toString();
                String pw = doctorPassword.getEditText().getText().toString();
                String pw2 = doctorPassword2.getEditText().getText().toString();
                String role = "Doctor";


                if(name.equals("") || email.equals("") || mobileNo.equals("") || pw.equals("") || pw2.equals("")){
                    Toast.makeText(DoctorRegistration.this, "Please Fill All the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(pw.equals(pw2)){
                        Boolean result = data.checkDoctor(email);
                        if(result == false){
                            Boolean resultInsert = data.doctorRegistration(name, email, mobileNo, pw);
                            if(resultInsert == true){
                                Toast.makeText(DoctorRegistration.this,"UserCreate Successfully",Toast.LENGTH_SHORT).show();
                                navigateDoctorLoginPage();
                            }
                        }else{
                            Toast.makeText(DoctorRegistration.this, "User Already Exits. \n please SignIn", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(DoctorRegistration.this, "Password Not Matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        navigateSignInPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInPage();
//                setContentView(R.layout.activity_doctor_login);
            }
        });
    }
    private void navigateDoctorLoginPage() {
        Intent intent = new Intent(DoctorRegistration.this,DoctorLogin.class);
        startActivity(intent);
    }

    private void signInPage() {
        Intent intent = new Intent(DoctorRegistration.this,DoctorLogin.class);
        startActivity(intent);
    }
}