package com.mobilesoftwaredevelopment.finaldoctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FetchDoctorsListAdpter extends RecyclerView.Adapter<FetchDoctorsListAdpter.MyViewHoler>{

    ArrayList<GetDoctorBookingInfo> dataModels;
    Button doctorBooking;
    public FetchDoctorsListAdpter(ArrayList<GetDoctorBookingInfo> dataModels) {
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public FetchDoctorsListAdpter.MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_patient_doctor_booked_frame,parent,false);
        return new FetchDoctorsListAdpter.MyViewHoler(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FetchDoctorsListAdpter.MyViewHoler holder, int position) {
        holder.doctorName.setText(dataModels.get(position).getName());
        holder.doctorSpecilization.setText(dataModels.get(position).getSpecialization());
        holder.doctorexperience.setText(dataModels.get(position).getExperience());
        holder.doctorCategories.setText(dataModels.get(position).getCategories()+" Yrs");
    }



    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    class MyViewHoler extends RecyclerView.ViewHolder{
        TextView doctorName,doctorSpecilization,doctorexperience,doctorCategories;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            doctorName = (TextView)itemView.findViewById(R.id.display_doctor_name);
            doctorSpecilization = (TextView)itemView.findViewById(R.id.display_doctor_specilization);
            doctorexperience = (TextView)itemView.findViewById(R.id.display_doctor_experience);
            doctorCategories = (TextView) itemView.findViewById(R.id.display_doctor_categories);
        }
    }



}
