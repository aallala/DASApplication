package com.mobilesoftwaredevelopment.finaldoctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DoctorCompletedOpAdpter extends RecyclerView.Adapter<DoctorCompletedOpAdpter.MyViewHoler> {

    ArrayList<GetDoctorCompletedOp> dataModels;

    public DoctorCompletedOpAdpter(ArrayList<GetDoctorCompletedOp> dataModels) {
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_completed_op_singlepage, parent, false);
        return new MyViewHoler(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        holder.dname.setText(dataModels.get(position).getName());
        holder.demail.setText(dataModels.get(position).getEmail());
        holder.dfname.setText(dataModels.get(position).getFname());
        holder.bookedDate.setText(dataModels.get(position).getDate());
        holder.bookedTime.setText(dataModels.get(position).getTime());
        holder.bookedStatus.setText(dataModels.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    class MyViewHoler extends RecyclerView.ViewHolder {
        TextView dname, demail, dfname,bookedStatus,bookedTime,bookedDate;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            dname = (TextView) itemView.findViewById(R.id.displayname);
            demail = (TextView) itemView.findViewById(R.id.displayname1);
            dfname = (TextView) itemView.findViewById(R.id.displayname2);
            bookedDate = (TextView) itemView.findViewById(R.id.bookedDate);
            bookedTime = (TextView) itemView.findViewById(R.id.bookedTime);
            bookedStatus = (TextView) itemView.findViewById(R.id.bookedStatus);

        }
    }
}
