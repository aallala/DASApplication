package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.mobilesoftwaredevelopment.finaldoctor.database.DBHelper;
import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

public class SampleActivity extends AppCompatActivity {

    TextInputLayout nametext,contact,email;
    AppCompatButton button;
    FloatingActionButton fbtn;
    Button button2;
    EditText patient_name,health_issue,mobile_no;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        nametext = (TextInputLayout) findViewById(R.id.nametext);
        contact = (TextInputLayout) findViewById(R.id.contacttext);
        email = (TextInputLayout) findViewById(R.id.email);
        button = (AppCompatButton) findViewById(R.id.sbmt_add);
        fbtn = (FloatingActionButton) findViewById(R.id.fbtn);
        databaseHelper = new DatabaseHelper(this);

        Bundle extras = getIntent().getExtras();
        String patient = extras.getString("patient");
        String health = extras.getString("health");
        String mobile = extras.getString("mobile");
        String dCategories = extras.getString("doctor_categories");
        String dId = extras.getString("doctors_id");
        String dBookingDate = extras.getString("doctor_booking_date");
        String dBookingTime = extras.getString("doctor_booking_time");
        String loggedUserUsername = extras.getString("logged_user_username");
        String status = "Pending";
        String s = databaseHelper.addBookingRecords(patient, health, mobile,dCategories,dId,dBookingDate,dBookingTime,loggedUserUsername,status);
        if(s != null){
            Toast.makeText(SampleActivity.this, "Successfully Insert", Toast.LENGTH_SHORT).show();
        }
//        button2 = (Button) findViewById(R.id.button2);
//        Bundle bundle = new Bundle();
//        int name = savedInstanceState.getInt("name");
//        String issue = savedInstanceState.getString("issue");
//        String mobile = savedInstanceState.getString("mobile");

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String patient = patient_name.getText().toString();
//                String health = health_issue.getText().toString();
//                String mobile = mobile_no.getText().toString();
//                add(patient,health,mobile);
//            }
//        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =  nametext.getEditText().getText().toString();
                String contactNo = contact.getEditText().getText().toString();
                String emailId = email.getEditText().getText().toString();

                processInsert(username,contactNo,emailId);
            }
        });

        fbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PatientBookedDataFetchActivity.class));
            }
        });
    }

    private void processInsert(String username, String contactNo, String emailId) {
        String res = new DBHelper(this).addRecord(username,contactNo,emailId);
        nametext.getEditText().setText("");
        contact.getEditText().setText("");
        email.getEditText().setText("");

        Toast.makeText(getApplicationContext(), res, Toast.LENGTH_SHORT).show();
    }

//    public String add(String patientName, String healthIssue, String mobileMo) {
//        String res = databaseHelper.addBookingRecords(patientName,healthIssue,mobileMo);
//        if(res == "Success"){
//            return "true";
//        }else{
//            return "false";
//        }
//    }
}