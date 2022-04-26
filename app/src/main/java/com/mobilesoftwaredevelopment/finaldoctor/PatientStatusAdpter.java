package com.mobilesoftwaredevelopment.finaldoctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PatientStatusAdpter extends RecyclerView.Adapter<PatientStatusAdpter.MyViewHoler>{

    ArrayList<GetPatientBookingStatusData> dataModels;
    public PatientStatusAdpter(ArrayList<GetPatientBookingStatusData> dataModels) {
        this.dataModels = dataModels;
    }
    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_booking_status,parent,false);
        return new MyViewHoler(view);

    }

    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        holder.dname.setText(dataModels.get(position).getPatient_name());
        holder.demail.setText(dataModels.get(position).getHealth_issue());
        holder.dfname.setText(dataModels.get(position).getMobile_no());
        holder.dDate.setText(dataModels.get(position).getDate());
        holder.dTime.setText(dataModels.get(position).getTime());
        String status = dataModels.get(position).getBookedStatus();
        if(status.equals("Pending")){
            holder.bookedStatus.setText("Booked");
        }else{
            holder.bookedStatus.setText(dataModels.get(position).getBookedStatus());
        }

    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    class MyViewHoler extends RecyclerView.ViewHolder{
        TextView dname,demail,dfname,dDate,dTime,bookedStatus;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            dname = (TextView)itemView.findViewById(R.id.displayname);
            demail = (TextView)itemView.findViewById(R.id.displayname1);
            dfname = (TextView)itemView.findViewById(R.id.displayname2);
            dDate = (TextView)itemView.findViewById(R.id.bookedDate);
            dTime = (TextView)itemView.findViewById(R.id.bookedTime);
            bookedStatus = (TextView)itemView.findViewById(R.id.bookedStatus);
        }
    }
}
