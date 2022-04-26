package com.mobilesoftwaredevelopment.finaldoctor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ProfileEditActivity extends AppCompatActivity {

    final int CODE_GALLERY_REQUEST = 999;
    Bitmap bitmap;
    TextInputLayout experience,specialization;
    String[] items =  {"CARDIOLOGY","PSYCHIATRY","COVID CONSULTATION","PEADIATRICS","DERMATOLOGY","GENERAL PHYSICIAN"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    Button updateDoctors;
    TextView username;
    SessionManager sessionManager;
    DatabaseHelper data;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        getSupportActionBar().setTitle("Update Profile");
        experience = (TextInputLayout) findViewById(R.id.experience);
        specialization = (TextInputLayout) findViewById(R.id.specialization);
        updateDoctors = (Button) findViewById(R.id.updateDoctors);
        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
//        username = findViewById(R.id.username);
        data = new DatabaseHelper(this);
//        imageView = findViewById(R.id.imageView);
        //Status bar color change
        Window window = ProfileEditActivity.this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(ProfileEditActivity.this, R.color.custom));

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                ActivityCompat.requestPermissions(ProfileEditActivity.this,
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                        CODE_GALLERY_REQUEST);
//            }
//        });
        sessionManager = new SessionManager(getApplicationContext());
        String username = sessionManager.getUsername();

        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);
        final String[] item = new String[1];
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item[0] = parent.getItemAtPosition(position).toString();

            }
        });

        updateDoctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String expert =  experience.getEditText().getText().toString();
                String specia = specialization.getEditText().getText().toString();
                String sa = item[0];
                String user = username;
//                String image = bitmap.toString();
//                ByteArrayOutputStream baos=new ByteArrayOutputStream();
//                String temp = null;
//                if(bitmap != null){
//                ByteArrayOutputStream baos=new ByteArrayOutputStream();
////                    bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
////                    byte [] b=baos.toByteArray();
////                    temp=Base64.encodeToString(b, Base64.DEFAULT);
//                }else{
//                    temp = "EMPTY";
//                }
//                String s = bitmap.toString();

                Boolean aBoolean = data.updateDoctorsInfo(sa, expert, specia,user,bitmap);
                if(aBoolean){
                   // openProfileFragment(new DoctorProfileFragment());
                    Toast.makeText(ProfileEditActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(ProfileEditActivity.this, "Failure", Toast.LENGTH_SHORT).show();
                }



            }
        });


    }

    private void openProfileFragment(DoctorProfileFragment doctorProfileFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,doctorProfileFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CODE_GALLERY_REQUEST){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,"Select Image"),CODE_GALLERY_REQUEST);
            }else{
                Toast.makeText(ProfileEditActivity.this, "Your don't have to access the permission for Gallery", Toast.LENGTH_SHORT).show();
            }
            return;
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == CODE_GALLERY_REQUEST && resultCode == RESULT_OK && data != null){
            Uri filePath = data.getData();
            try{
                InputStream inputStream = getContentResolver().openInputStream(filePath);
                bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}