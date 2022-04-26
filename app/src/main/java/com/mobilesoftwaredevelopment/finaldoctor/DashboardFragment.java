package com.mobilesoftwaredevelopment.finaldoctor;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobilesoftwaredevelopment.finaldoctor.database.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DashboardFragment extends Fragment {

    TextView date;
    private TextView dateTimeDisplay;
    private Calendar calendar;
    private SimpleDateFormat dateFormat;
    private String date1;
    SessionManager sessionManager;
    TextView dashboardname,completedOP,pendingOp;
    DatabaseHelper databaseHelper;
    public String username;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        databaseHelper = new DatabaseHelper(getActivity());
        sessionManager = new SessionManager(getActivity());
        username = sessionManager.getUsername();
        Calendar calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date1 = dateFormat.format(calendar.getTime());
        date = view.findViewById(R.id.date);
        completedOP = view.findViewById(R.id.completedOP);
        pendingOp = view.findViewById(R.id.pendingOp);
        date.setText(date1);

        Cursor cursor = databaseHelper.completedCount(date1);
        Cursor cursor1 = databaseHelper.pendingCount(date1);
        if(cursor.moveToNext()){
            String string = cursor.getString(0);
            completedOP.setText(string);
        }
        if(cursor1.moveToNext()){
            String string = cursor1.getString(0);
            pendingOp.setText(string);
        }

        dashboardname = view.findViewById(R.id.dashboardname);

        Bundle data = getArguments();
        if(data != null){
            username = data.getString("username");
        }
        Cursor userInformation = databaseHelper.getUserInformation(username);
        if(userInformation.moveToNext()){
            String string = userInformation.getString(1);
            dashboardname.setText(string);
        }else {
            dashboardname.setText(username);
        }
        return view;
    }
}