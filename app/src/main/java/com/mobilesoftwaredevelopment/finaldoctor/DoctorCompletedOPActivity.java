package com.mobilesoftwaredevelopment.finaldoctor;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

import java.util.ArrayList;

public class DoctorCompletedOPActivity extends AppCompatActivity {

    RecyclerView doctorcompleted;
    private ArrayList<GetDoctorCompletedOp> getData = new ArrayList<>();
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_completed_op);
        doctorcompleted = (RecyclerView) findViewById(R.id.doctorcompleted);
        doctorcompleted.setLayoutManager(new LinearLayoutManager(this));
        getSupportActionBar().setTitle("Completed Op List");
        sessionManager = new SessionManager(getApplicationContext());
        String username = sessionManager.getUsername();
        //Status bar color change
        Window window = DoctorCompletedOPActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(DoctorCompletedOPActivity.this,R.color.custom));

        Cursor cursor = new DatabaseHelper(this).getCompletedStatus(username);
        while(cursor.moveToNext()){
           GetDoctorCompletedOp model = new GetDoctorCompletedOp(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(6),cursor.getString(7),cursor.getString(9));
            getData.add(model);

        }
        DoctorCompletedOpAdpter adpter = new DoctorCompletedOpAdpter(getData);
        doctorcompleted.setAdapter(adpter);
    }
}
