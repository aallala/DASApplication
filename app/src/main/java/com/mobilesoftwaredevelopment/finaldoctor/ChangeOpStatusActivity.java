package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

public class ChangeOpStatusActivity extends AppCompatActivity {

    Button statusButton;
    String[] items =  {"Completed","Pending"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_op_status);
        getSupportActionBar().setTitle("Change Op Status");
        //Status bar color change
        Window window = ChangeOpStatusActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(ChangeOpStatusActivity.this,R.color.custom));

        statusButton = findViewById(R.id.statusButton);
        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);
        databaseHelper = new DatabaseHelper(this);
        final String[] item = new String[1];
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item[0] = parent.getItemAtPosition(position).toString();

            }
        });

        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = item[0];
                Intent intent = getIntent();
                String id = intent.getStringExtra("doctorEmail");
                String pid = intent.getStringExtra("opId");
                boolean b = databaseHelper.updatePatientOpStatus(status, id, pid);
                if(b == true){
//                    Toast.makeText(ChangeOpStatusActivity.this, "SuccessFully Updated", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(ChangeOpStatusActivity.this,DoctorCompletedOPActivity.class);
                    startActivity(intent1);
                }else{
                    Toast.makeText(ChangeOpStatusActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}