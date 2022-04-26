package com.mobilesoftwaredevelopment.finaldoctor;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mobilesoftwaredevelopment.finaldoctor.database.DBHelper;

import java.util.ArrayList;

public abstract class DoctorCompletedOPFragment extends Fragment {

    public DoctorCompletedOPFragment() {

    }

    RecyclerView image;
    private ArrayList<GetDataModel> getData = new ArrayList<>();
    DoctorActivity doctorActivity = new DoctorActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctor_completed_o_p, container, false);
        image = view.findViewById(R.id.image);
        image.setLayoutManager(new LinearLayoutManager(doctorActivity));

        Cursor cursor = new DBHelper(doctorActivity).readalldata();
        while(cursor.moveToNext()){
            GetDataModel model = new GetDataModel(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            getData.add(model);

        }
        MyAdpter adpter = new MyAdpter(getData);
        image.setAdapter(adpter);

        return view;
    }
}