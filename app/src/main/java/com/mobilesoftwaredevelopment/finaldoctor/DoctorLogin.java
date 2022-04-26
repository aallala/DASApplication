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

public class DoctorLogin extends AppCompatActivity {

//    EditText doctorUsername,doctorPassword;
    Button doctorLoginButton;
    TextView doctorSignUpButton;
    TextInputLayout doctorUsername,doctorPassword;
    DatabaseHelper data;

    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_doctor_login);
        getSupportActionBar().hide();
        Window window = DoctorLogin.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(DoctorLogin.this,R.color.custom));

        doctorUsername = (TextInputLayout) findViewById(R.id.doctorUsername);
        doctorPassword = (TextInputLayout) findViewById(R.id.doctorPassword);
        doctorLoginButton = (Button) findViewById(R.id.doctorLoginButton);
        doctorSignUpButton = (TextView) findViewById(R.id.doctorSignUpButton);
        data=new DatabaseHelper(this);
        sessionManager = new SessionManager(getApplicationContext());

        doctorLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String username = doctorUsername.getText().toString();
//                String password = doctorPassword.getText().toString();
                String username = doctorUsername.getEditText().getText().toString();
                String password = doctorPassword.getEditText().getText().toString();
                if(username.equals("")){
                    Toast.makeText(DoctorLogin.this,"Please Enter Username",Toast.LENGTH_SHORT).show();
                }else{
                    if(password.equals("")){
                        Toast.makeText(DoctorLogin.this,"Please Enter Password",Toast.LENGTH_SHORT).show();
                    }else{
                        if(data.checkDoctorUsernamePassword(username,password)){
//                            setContentView(R.layout.activity_dashboard);
                            navigateIntoDoctorDashBoard(username);
                            Toast.makeText(DoctorLogin.this,"User Validation Successfully Completed",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(DoctorLogin.this,"Please Enter Valid Cridencials",Toast.LENGTH_SHORT).show();
                        }

                    }
                }

            }
        });
        doctorSignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpButton();
            }
        });

    }

    private void navigateIntoDoctorDashBoard(String username) {
       Intent intent = new Intent(DoctorLogin.this,DoctorActivity.class);
//       intent.putExtra("username",username);
        sessionManager.setUsername(username);
        startActivity(intent);
    }

    private void signUpButton() {
        Intent intent = new Intent(DoctorLogin.this,DoctorRegistration.class);
        startActivity(intent);
    }
}