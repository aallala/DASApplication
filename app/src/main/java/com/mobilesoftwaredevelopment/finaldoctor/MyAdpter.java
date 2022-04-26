package com.mobilesoftwaredevelopment.finaldoctor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdpter extends RecyclerView.Adapter<MyAdpter.MyViewHoler>{
    ArrayList<GetDataModel> dataModels;
    Button button;
    public MyAdpter(ArrayList<GetDataModel> dataModels) {
        this.dataModels = dataModels;
    }

    @NonNull
    @Override
    public MyViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlepage,parent,false);
        button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return new MyViewHoler(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoler holder, int position) {
        holder.dname.setText(dataModels.get(position).getName());
        holder.demail.setText(dataModels.get(position).getEmail());
        holder.dfname.setText(dataModels.get(position).getFname());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class MyViewHoler extends RecyclerView.ViewHolder{
        TextView dname,demail,dfname;

        public MyViewHoler(@NonNull View itemView) {
            super(itemView);
            dname = (TextView)itemView.findViewById(R.id.displayname);
            demail = (TextView)itemView.findViewById(R.id.displayname1);
            dfname = (TextView)itemView.findViewById(R.id.displayname2);

        }
    }

}