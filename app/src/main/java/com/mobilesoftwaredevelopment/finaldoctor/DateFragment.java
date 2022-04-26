package com.mobilesoftwaredevelopment.finaldoctor;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DateFragment extends Fragment {
    TextView today,tomorrow,date1,date2;
    CardView first,second,third,fourth;
    Bundle bundle = new Bundle();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date, container, false);
        today = view.findViewById(R.id.today);
        tomorrow = view.findViewById(R.id.tomorrow);
        date1 = view.findViewById(R.id.date1);
        date2 = view.findViewById(R.id.date2);
        first = view.findViewById(R.id.first);
        second = view.findViewById(R.id.second);
        third = view.findViewById(R.id.third);
        fourth = view.findViewById(R.id.fourth);
        Bundle data = getArguments();

        if(data != null){
            String str = data.getString("categories");
            String str2 = data.getString("docutorId");
            bundle.putString("categori",str);
            bundle.putString("did",str2);
        }
        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date1 = today.getText().toString();
                bundle.putString("book_date",date1);
                Fragment fragment = new TimeFragment();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragment).commit();
            }
        });
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date2 = tomorrow.getText().toString();
                bundle.putString("book_date",date2);
                Fragment fragment = new TimeFragment();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragment).commit();
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date3 = date1.getText().toString();
                bundle.putString("book_date",date3);
                Fragment fragment = new TimeFragment();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragment).commit();
            }
        });
        fourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date4 = date2.getText().toString();
                bundle.putString("book_date",date4);
                Fragment fragment = new TimeFragment();
                fragment.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout,fragment).commit();
            }
        });


        String sdate = today.getText().toString();
//        Bundle bundle = new Bundle();
//        bundle.putString("key",sdate);
//        TimeFragment timeFragment = new TimeFragment();
//        timeFragment.setArguments(bundle);
        TimeFragment timeFragment = new TimeFragment();
//        Bundle bundle = new Bundle();
        bundle.getString("apple","waos");
        timeFragment.setArguments(bundle);

        return view;
    }
}