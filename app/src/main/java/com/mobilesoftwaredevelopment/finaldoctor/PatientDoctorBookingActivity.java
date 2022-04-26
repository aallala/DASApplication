package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

import java.util.ArrayList;

public class PatientDoctorBookingActivity extends AppCompatActivity {
    RecyclerView doctor_booked_data_fetch;
    private ArrayList<GetDoctorBookingInfo> getData = new ArrayList<>();
    Bundle bundle = new Bundle();
    Button doctorBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_doctor_booking);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        String id = intent.getStringExtra("get_categories");
        //Status bar color change
        Window window = PatientDoctorBookingActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(PatientDoctorBookingActivity.this,R.color.custom));


        doctor_booked_data_fetch = (RecyclerView) findViewById(R.id.doctor_booked_data_fetch);
        doctor_booked_data_fetch.setLayoutManager(new LinearLayoutManager(this));
        Cursor cursor = new DatabaseHelper(this).allDataBasedOnCategories(id);
        while(cursor.moveToNext()){
            GetDoctorBookingInfo model = new GetDoctorBookingInfo(cursor.getString(1),cursor.getString(5),cursor.getString(7),cursor.getString(6));
            String save = cursor.getString(2);
            bundle.putString("docutorId",cursor.getString(2));
            getData.add(model);
        }
        FetchDoctorsListAdpter adpter = new FetchDoctorsListAdpter(getData);
        doctor_booked_data_fetch.setAdapter(adpter);

    }
    public void bookNow(View view){
        Fragment fragment = new DateFragment();
//        Bundle bundle = new Bundle();
        Intent intent = getIntent();
        String id = intent.getStringExtra("get_categories");
        bundle.putString("categories",id);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content,fragment);
        fragmentTransaction.commit();
    }
}