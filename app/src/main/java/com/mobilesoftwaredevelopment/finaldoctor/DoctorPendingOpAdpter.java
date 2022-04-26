package com.mobilesoftwaredevelopment.finaldoctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorPendingOpAdpter extends RecyclerView.Adapter<DoctorPendingOpAdpter.MyViewHoler>{

    Button changeStatus;
    ArrayList<GetDoctorPendingOp> dataModels;
    public DoctorPendingOpAdpter(ArrayList<GetDoctorPendingOp> dataModels) {
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_pending_op_singlepage,parent,false);
        return new MyViewHoler(view);

    }


    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        holder.dname.setText(dataModels.get(position).getName());
        holder.demail.setText(dataModels.get(position).getEmail());
        holder.dfname.setText(dataModels.get(position).getFname());
        holder.date.setText(dataModels.get(position).getDate());
        holder.time.setText(dataModels.get(position).getTime());
        holder.status.setText(dataModels.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    class MyViewHoler extends RecyclerView.ViewHolder{
        TextView dname,demail,dfname,date,time,status;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            dname = (TextView)itemView.findViewById(R.id.displayname);
            demail = (TextView)itemView.findViewById(R.id.displayname1);
            dfname = (TextView)itemView.findViewById(R.id.displayname2);
            date = (TextView)itemView.findViewById(R.id.bookedDate);
            time = (TextView)itemView.findViewById(R.id.bookedTime);
            status = (TextView)itemView.findViewById(R.id.bookedStatus);

        }
    }


}
