package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

public class PatientActivity extends AppCompatActivity implements  View.OnClickListener{

    public CardView cardiology;

    ImageView booking,booking2,booking3,booking4,booking5;
    Button button2;
    TextView book_time,book_date,todayTime,today;
    EditText patient_name,health_issue,mobile_no;
    DatabaseHelper data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient);
        getSupportActionBar().hide();
        dashboard(new PatientDashboardFragment());

        Window window = PatientActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(PatientActivity.this,R.color.custom));
        data = new DatabaseHelper(this);
        booking = findViewById(R.id.booking);
        booking2 = findViewById(R.id.booking2);
        booking3 = findViewById(R.id.booking3);
        booking4 = findViewById(R.id.booking4);
        booking5 = findViewById(R.id.booking5);
        cardiology = findViewById(R.id.cardiology);

        book_time = findViewById(R.id.book_time);
        book_date = findViewById(R.id.book_date);

        patient_name = findViewById(R.id.patient_name);
        health_issue = findViewById(R.id.health_issue);
        mobile_no = findViewById(R.id.mobile_no);
        button2 = findViewById(R.id.button2);

//        todayTime = findViewById(R.id.todayTime);
        today = findViewById(R.id.today);


//        today.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String todayString = today.getText().toString();
//            }
//        });
//        todayTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String todayTimeString = todayTime.getText().toString();
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String patient = patient_name.getText().toString();
//                String health = health_issue.getText().toString();
//                String mobile = mobile_no.getText().toString();
//                storedBookedData(patient,health,mobile);
//
//            }
//        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                replaseFragment(new AppointmentFragment());
                replaseFragment(new PatientDashboardFragment());
            }
        });

        booking2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                replaseFragment(new MedicalReportFragment());
                replaseFragment(new AppointmentFragment());
            }
        });

        booking3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                replaseFragment(new TestReportFragment());
                replaseFragment(new MedicalReportFragment());
            }
        });

        booking4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PatientActivity.this,PatientBookingStatus.class));
            }
        });

        booking5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaseFragment(new ProfileFragment());
            }
        });

    }

//    private void storedBookedData(String patient, String health, String mobile) {
//        String result = data.addBookingRecords(patient, health, mobile);
//
//    }

    private void dashboard(PatientDashboardFragment patientDashboardFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,patientDashboardFragment);
        fragmentTransaction.commit();
    }

    private void replaseFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {

    }
    public void getBoard(View view){
        Fragment fragment = new TimeFragment();
        FragmentTransaction ft = PatientActivity.this.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout,fragment).commit();
    }

    public void getTime(View view){
        Fragment fragment = new Book();
        FragmentTransaction ft = PatientActivity.this.getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout,fragment).commit();
    }
}