package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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

public class DoctorPendingOpActivity extends AppCompatActivity {
    RecyclerView doctorpending;
    private ArrayList<GetDoctorPendingOp> getData = new ArrayList<>();
    SessionManager sessionManager;
    Button changeStatus;
    String username,id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_pending_op);

        getSupportActionBar().setTitle("Pending OP List");

        //Status bar color change
        Window window = DoctorPendingOpActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(DoctorPendingOpActivity.this,R.color.custom));


//        changeStatus = findViewById(R.id.changeStatus);
//
//        changeStatus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        changeStatus =(Button) findViewById(R.id.changeStatus);
//       id = changeStatus.getText().toString();
//        changeStatus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(DoctorPendingOpActivity.this,ChangeOpStatusActivity.class);
//                startActivity(intent);
//            }
//        });

        doctorpending = (RecyclerView) findViewById(R.id.doctorpending);
        doctorpending.setLayoutManager(new LinearLayoutManager(this));
        sessionManager = new SessionManager(getApplicationContext());
        username = sessionManager.getUsername();

        Cursor cursor = new DatabaseHelper(this).getPendingStatus(username);
        while(cursor.moveToNext()){
            GetDoctorPendingOp model = new GetDoctorPendingOp(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(6),cursor.getString(7),cursor.getString(9));
           id = cursor.getString(0);
            getData.add(model);

        }
        DoctorPendingOpAdpter adpter = new DoctorPendingOpAdpter(getData);

        doctorpending.setAdapter(adpter);

    }

//    private void replaseFragment(ChangeOpStatusFragment changeOpStatusFragment) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout,changeOpStatusFragment);
//        fragmentTransaction.commit();
//    }

    public void changeButton(View view){
        Intent intent = new Intent(DoctorPendingOpActivity.this,ChangeOpStatusActivity.class);
        intent.putExtra("doctorEmail",username);//doctor Email
        intent.putExtra("opId",id);
//        intent.putExtra("patirntEmail",id);
//        intent.putExtra("get_categories","CARDIOLOGY");
//        intent.putExtra("get_categories","CARDIOLOGY");
//        intent.putExtra("get_categories","CARDIOLOGY");
//        intent.putExtra("get_categories","CARDIOLOGY");
//        intent.putExtra("get_categories","CARDIOLOGY");
        startActivity(intent);

    }

}