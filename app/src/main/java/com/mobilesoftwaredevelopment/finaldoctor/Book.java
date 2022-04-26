package com.mobilesoftwaredevelopment.finaldoctor;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

public class Book extends Fragment {

    Button button2;
    TextView book_time,book_date;
//    EditText patient_name,health_issue,mobile_no;
    TextInputLayout patient_name,health_issue,mobile_no;
    String str,str2,str3,str4;

    SessionManager sessionManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_book, container, false);

        book_time = view.findViewById(R.id.book_time);
        book_date = view.findViewById(R.id.book_date);
        patient_name = view.findViewById(R.id.patient_name);
        health_issue = view.findViewById(R.id.health_issue);
        mobile_no = view.findViewById(R.id.mobile_no);
        button2 = view.findViewById(R.id.button2);

        Bundle data = getArguments();
        if(data != null){
            str = data.getString("booking_categories");
            str2 = data.getString("booking_doctor_id");
            str3 = data.getString("booking_date");
            str4 = data.getString("book_time");
//            book_time.setText(str4);
//            book_date.setText(str3);
        }

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String patientName = patient_name.getEditText().getText().toString();
                String healthIssue = health_issue.getEditText().getText().toString();
                String mobileNo = mobile_no.getEditText().getText().toString();
                String doctorCategories = str;
                String doctorId = str2;
                String doctorBookingDate = str3;
                String doctorBookingTime = str4;
                sessionManager = new SessionManager(getContext());
                String username = sessionManager.getUsername();
                Intent intent = new Intent(getActivity(), PatientBookingStatus.class);
                intent.putExtra("patient",patientName);
                intent.putExtra("health",healthIssue);
                intent.putExtra("mobile",mobileNo);
                intent.putExtra("doctor_categories",doctorCategories);
                intent.putExtra("doctors_id",doctorId);
                intent.putExtra("doctor_booking_date",doctorBookingDate);
                intent.putExtra("doctor_booking_time",doctorBookingTime);
                intent.putExtra("logged_user_username",username);
                startActivity(intent);
            }
        });

//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Fragment fragment = new DateFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frameLayout,fragment).commit();
//            }
//        });
        return view;
    }
}