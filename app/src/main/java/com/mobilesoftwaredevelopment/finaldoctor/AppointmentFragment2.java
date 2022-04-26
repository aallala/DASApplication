package com.mobilesoftwaredevelopment.finaldoctor;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class AppointmentFragment2 extends Fragment {


    RecyclerView image;
    private ArrayList<GetDataModel> getData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appointment2, container, false);
        image =  view.findViewById(R.id.image);
        PatientActivity patientActivity = new PatientActivity();
        image.setLayoutManager(new LinearLayoutManager(patientActivity));

        return view;
    }

}