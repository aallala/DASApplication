package com.mobilesoftwaredevelopment.finaldoctor;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

public class DoctorActivity extends AppCompatActivity implements  View.OnClickListener{
    public CardView cardiology;
    ImageView booking,booking2,booking1,booking5;
    DatabaseHelper data;
    SessionManager sessionManager;
//    TextView dashboardname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        getSupportActionBar().hide();

//        dashboardname = (TextView) findViewById(R.id.dashboardname);

//        dashboard(new DashboardFragment());

        //Status bar color change
        Window window = DoctorActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(DoctorActivity.this,R.color.custom));
        
        booking = findViewById(R.id.booking);
        booking2 = findViewById(R.id.booking2);
        booking1 = findViewById(R.id.booking1);
        booking5 = findViewById(R.id.booking5);
        cardiology = findViewById(R.id.cardiology);
        data = new DatabaseHelper(this);
                
        sessionManager = new SessionManager(getApplicationContext());
        String username = sessionManager.getUsername();
        String userinformation = getUserinformation(username);
        dashboard(new DashboardFragment(),userinformation);


//        dashboardname.setText(sessionManager.getUsername());
//        Bundle extras = getIntent().getExtras();
//        String username1 = extras.getString("username");
//        dashboardname.setText(username1);

        booking1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username;
                replaseFragment(new DashboardFragment(),user);
//                dashboard

            }
        });
        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorActivity.this, DoctorCompletedOPActivity.class);
                startActivity(intent);
            }
        });

        booking2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorActivity.this, DoctorPendingOpActivity.class);
                startActivity(intent);
            }
        });

        booking5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username;
                data.getUserInformation(user);
                replaseFragment(new DoctorProfileFragment(),user);
            }
        });
    }

    private String getUserinformation(String username) {
        Cursor userInformation = data.getUserInformation(username);
        String string = null;
        while(userInformation.moveToNext()){
            string = userInformation.getString(1);
        }
        return string;
    }

    private void dashboard(DashboardFragment dashboardFragment,String username) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("username",username);
        dashboardFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.frameLayout,dashboardFragment);
        fragmentTransaction.commit();
    }

    
    private void replaseFragment(Fragment fragment,String user) {
        Bundle bundle = new Bundle();
        bundle.putString("username",user);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {

    }
}