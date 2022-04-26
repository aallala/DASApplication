package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

import java.util.ArrayList;

public class PatientBookedDataFetchActivity extends AppCompatActivity {

    RecyclerView booked_data_fetch;
    private ArrayList<GetPatientBookingStatusData> getData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_booked_data_fetch);

        booked_data_fetch = (RecyclerView) findViewById(R.id.booked_data_fetch);
        booked_data_fetch.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new DatabaseHelper(this).readalldata();
        while(cursor.moveToNext()){
            GetPatientBookingStatusData model = new GetPatientBookingStatusData(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(3),cursor.getString(3),cursor.getString(3));
            getData.add(model);

        }
        MyFetchDataAdpter adpter = new MyFetchDataAdpter(getData);
        booked_data_fetch.setAdapter(adpter);
    }
}