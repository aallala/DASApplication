package com.mobilesoftwaredevelopment.finaldoctor;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

public class ProfileFragment extends Fragment {

    TextView patientName,patientmobileNo,patientusername,patientpassword;
    DatabaseHelper data ;
    SessionManager sessionManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        data = new DatabaseHelper(getActivity());
        patientName = view.findViewById(R.id.pname);
        patientmobileNo = view.findViewById(R.id.pmobileNo);
        patientusername = view.findViewById(R.id.pusername);
        patientpassword = view.findViewById(R.id.ppassword);

        sessionManager = new SessionManager(getActivity());
        String username = sessionManager.getUsername();
        Cursor userInformation = data.getUserInfo(username);
        while(userInformation.moveToNext()){
            patientName.setText(userInformation.getString(1));
            patientmobileNo.setText(userInformation.getString(4));
            patientusername.setText(userInformation.getString(2));
            patientpassword.setText(userInformation.getString(3));
        }
        return view;
    }
}