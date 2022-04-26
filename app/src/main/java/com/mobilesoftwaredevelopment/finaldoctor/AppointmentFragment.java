package com.mobilesoftwaredevelopment.finaldoctor;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class AppointmentFragment extends Fragment{

    public CardView cardiology,psychiatry,covid,paediatrics,dermatology,general;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_appointment, container, false);
        cardiology = view.findViewById(R.id.cardiology);
        psychiatry = view.findViewById(R.id.psychiatry);
        covid = view.findViewById(R.id.covid);
        paediatrics = view.findViewById(R.id.paediatrics);
        dermatology = view.findViewById(R.id.dermatology);
        general = view.findViewById(R.id.general);

        cardiology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragment = new DoctorOPFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frameLayout,fragment).commit();
                Intent intent = new Intent(getActivity(),PatientDoctorBookingActivity.class);
                intent.putExtra("get_categories","CARDIOLOGY");
                startActivity(intent);
            }
        });

        psychiatry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragment = new DoctorOPFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frameLayout,fragment).commit();
                Intent intent = new Intent(getActivity(),PatientDoctorBookingActivity.class);
                intent.putExtra("get_categories","PSYCHIATRY");
                startActivity(intent);
            }
        });

        covid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragment = new DoctorOPFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frameLayout,fragment).commit();
                Intent intent = new Intent(getActivity(),PatientDoctorBookingActivity.class);
                intent.putExtra("get_categories","COVID CONSULTATION");
                startActivity(intent);
            }
        });

        paediatrics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragment = new DoctorOPFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frameLayout,fragment).commit();
                Intent intent = new Intent(getActivity(),PatientDoctorBookingActivity.class);
                intent.putExtra("get_categories","PEADIATRICS");
                startActivity(intent);
            }
        });

        dermatology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragment = new DoctorOPFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frameLayout,fragment).commit();
                Intent intent = new Intent(getActivity(),PatientDoctorBookingActivity.class);
                intent.putExtra("get_categories","DERMATOLOGY");
                startActivity(intent);
            }
        });

        general.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment fragment = new DoctorOPFragment();
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.frameLayout,fragment).commit();
                Intent intent = new Intent(getActivity(),PatientDoctorBookingActivity.class);
                intent.putExtra("get_categories","GENERAL PHYSICIAN");
                startActivity(intent);
            }
        });
    return view;
    }

}