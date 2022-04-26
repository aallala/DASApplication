package com.mobilesoftwaredevelopment.finaldoctor;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TimeFragment extends Fragment {

    CardView card1,card2,card3,card4,card5;
    TextView time1,time2,time3,time4,time5;
    Bundle bundle = new Bundle();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time, container, false);
        card1 = view.findViewById(R.id.card1);
        card2 = view.findViewById(R.id.card2);
        card3 = view.findViewById(R.id.card3);
        card4 = view.findViewById(R.id.card4);
        card5 = view.findViewById(R.id.card5);

        time1 = view.findViewById(R.id.time1);
        time2 = view.findViewById(R.id.time2);
        time3 = view.findViewById(R.id.time3);
        time4 = view.findViewById(R.id.time4);
        time5 = view.findViewById(R.id.time5);
        Bundle data = getArguments();
        if(data != null){
            String str = data.getString("categori");
            String str2 = data.getString("did");
            String str3 = data.getString("book_date");
            bundle.putString("booking_categories",str);
            bundle.putString("booking_doctor_id",str2);
            bundle.putString("booking_date",str3);
        }
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String booking_time1 = time1.getText().toString();
                bundle.putString("book_time",booking_time1);

                Fragment fragment = new Book();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragment).commit();
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String booking_time2 = time2.getText().toString();
                bundle.putString("book_time",booking_time2);
                Fragment fragment = new Book();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragment).commit();
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String booking_time3 = time3.getText().toString();
                bundle.putString("book_time",booking_time3);
                Fragment fragment = new Book();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragment).commit();
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String booking_time4 = time4.getText().toString();
                bundle.putString("book_time",booking_time4);
                Fragment fragment = new Book();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragment).commit();
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String booking_time5 = time5.getText().toString();
                bundle.putString("book_time",booking_time5);
                Fragment fragment = new Book();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragment).commit();
            }
        });
        return view;
    }
}