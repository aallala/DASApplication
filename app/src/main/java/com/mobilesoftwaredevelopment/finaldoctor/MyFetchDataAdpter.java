package com.mobilesoftwaredevelopment.finaldoctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyFetchDataAdpter extends RecyclerView.Adapter<MyFetchDataAdpter.MyViewHoler>{

    ArrayList<GetPatientBookingStatusData> dataModels;
    Button button;
    public MyFetchDataAdpter(ArrayList<GetPatientBookingStatusData> dataModels) {
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_patient_booked_data_frame,parent,false);
        return new MyViewHoler(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        holder.dname.setText(dataModels.get(position).getPatient_name());
        holder.demail.setText(dataModels.get(position).getHealth_issue());
        holder.dfname.setText(dataModels.get(position).getMobile_no());
    }



    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    class MyViewHoler extends RecyclerView.ViewHolder{
        TextView dname,demail,dfname;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            dname = (TextView)itemView.findViewById(R.id.displayname);
            demail = (TextView)itemView.findViewById(R.id.displayname1);
            dfname = (TextView)itemView.findViewById(R.id.displayname2);

        }
    }

}
