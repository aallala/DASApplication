package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.mobilesoftwaredevelopment.finaldoctor.database.DBHelper;

import java.util.ArrayList;

public class BasicActivity extends AppCompatActivity {

    TextInputLayout nametext,contact,email;
    AppCompatButton button;
    FloatingActionButton fbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic2);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        nametext = (TextInputLayout) findViewById(R.id.nametext);
        contact = (TextInputLayout) findViewById(R.id.contacttext);
        email = (TextInputLayout) findViewById(R.id.email);
        button = (AppCompatButton) findViewById(R.id.sbmt_add);
        fbtn = (FloatingActionButton) findViewById(R.id.fbtn);

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
                startActivity(new Intent(getApplicationContext(),DoctorCompletedOPFragment.class));
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

    public static class DoctorCompletedOpActivity extends AppCompatActivity {

        RecyclerView doctorcompleted;
        private ArrayList<GetDoctorCompletedOp> getData = new ArrayList<>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_doctor_completed_op);

            doctorcompleted = (RecyclerView) findViewById(R.id.doctorcompleted);
            doctorcompleted.setLayoutManager(new LinearLayoutManager(this));

            Cursor cursor = new DBHelper(this).readalldata();
            while(cursor.moveToNext()){
                GetDoctorCompletedOp model = new GetDoctorCompletedOp(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(6),cursor.getString(6),cursor.getString(9));
                getData.add(model);

            }
            DoctorCompletedOpAdpter adpter = new DoctorCompletedOpAdpter(getData);
            doctorcompleted.setAdapter(adpter);
        }
    }
}