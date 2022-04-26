package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

import java.util.ArrayList;

public class PatientBookingStatus extends AppCompatActivity {

    RecyclerView image;
    private ArrayList<GetPatientBookingStatusData> getData = new ArrayList<>();
    DatabaseHelper databaseHelper;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_booking_status);
        getSupportActionBar().setTitle("Booking OP Status");
        databaseHelper = new DatabaseHelper(this);
        sessionManager = new SessionManager(getApplicationContext());
        //Status bar color change
        Window window = PatientBookingStatus.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(PatientBookingStatus.this,R.color.custom));

        Bundle extras = getIntent().getExtras();
        if(extras != null){
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
            if(s == "Success"){
                Toast.makeText(PatientBookingStatus.this, "Successfully Insert", Toast.LENGTH_SHORT).show();
            }

            image = (RecyclerView) findViewById(R.id.image);
            image.setLayoutManager(new LinearLayoutManager(this));
            String username = sessionManager.getUsername();
            Cursor cursor = new DatabaseHelper(this).getBookingDataBasedOnUId(username);
            while(cursor.moveToNext()){
                GetPatientBookingStatusData model = new GetPatientBookingStatusData(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(6),cursor.getString(7),cursor.getString(9));
                getData.add(model);

            }
            PatientStatusAdpter adpter = new PatientStatusAdpter(getData);
            image.setAdapter(adpter);
        }else{
            image = (RecyclerView) findViewById(R.id.image);
            image.setLayoutManager(new LinearLayoutManager(this));
            String username = sessionManager.getUsername();
            Cursor cursor = new DatabaseHelper(this).getBookingDataBasedOnUId(username);
            while(cursor.moveToNext()){
                GetPatientBookingStatusData model = new GetPatientBookingStatusData(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(6),cursor.getString(7),cursor.getString(9));
                getData.add(model);

            }
            PatientStatusAdpter adpter = new PatientStatusAdpter(getData);
            image.setAdapter(adpter);
        }


    }
}