package com.mobilesoftwaredevelopment.finaldoctor;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

public class DoctorProfileFragment extends Fragment {

    DatabaseHelper databaseHelper;
    Button edit_profile;
    SessionManager sessionManager;
    ImageView doctor_images;
    TextView doctorName,doctorEmail,doctorNumber,doctorPassword,doctorExperience,doctorSpecilization,doctorCategories;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor_profile, container, false);
//        dataTransfer();
        View viewById = view.findViewById(R.id.edit_profile);

        doctor_images = view.findViewById(R.id.doctor_images);
        doctorName = view.findViewById(R.id.doctor_name);
        doctorEmail = view.findViewById(R.id.doctor_email);
        doctorNumber = view.findViewById(R.id.doctor_number);
        doctorPassword = view.findViewById(R.id.doctor_password);
        doctorExperience = view.findViewById(R.id.doctor_experience);
        doctorSpecilization = view.findViewById(R.id.doctor_specialization);
        doctorCategories = view.findViewById(R.id.doctor_categories);
        sessionManager = new SessionManager(getContext());
        String username = sessionManager.getUsername();
        databaseHelper = new DatabaseHelper(getActivity());
        Cursor userInformation = databaseHelper.getUserInformation(username);
        while(userInformation.moveToNext()){
            doctorName.setText(userInformation.getString(1));
            doctorEmail.setText(userInformation.getString(2));
            doctorNumber.setText(userInformation.getString(4));
            doctorPassword.setText(userInformation.getString(3));
            doctorExperience.setText(userInformation.getString(5)+" Yrs");
            doctorSpecilization.setText(userInformation.getString(6));
            doctorCategories.setText(userInformation.getString(7));
            String string = userInformation.getString(8);
//            string.
//            doctor_images.setImageBitmap();
//            if(string != "EMPTY") {
////            Bitmap string1 = (Bitmap) string;
//            }else{
//                byte[] byteArray1;
//                byteArray1 = Base64.decode(string, Base64.DEFAULT);
//                Bitmap bmp = BitmapFactory.decodeByteArray(byteArray1, 0,
//                        byteArray1.length);
//                doctor_images.setImageBitmap(bmp);
//            }
            //Working
//            byte[] byteArray1;
//                byteArray1 = Base64.decode(string, Base64.DEFAULT);
//                Bitmap bmp = BitmapFactory.decodeByteArray(byteArray1, 0,
//                        byteArray1.length);
//                doctor_images.setImageBitmap(bmp);
        }

        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ProfileEditActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

//    public Cursor dataTransfer(){
//        String a = "sa";
//        databaseHelper.addBookingRecords(a,a,a);
//        return null;
//    }
}