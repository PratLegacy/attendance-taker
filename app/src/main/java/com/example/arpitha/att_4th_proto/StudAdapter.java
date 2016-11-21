package com.example.arpitha.att_4th_proto;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class StudAdapter extends RecyclerView.Adapter<StudAdapter.MyViewHolder> {

    private List<StudentList> sList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        public TextView usn;

        public MyViewHolder(View view) {
            super(view);
            view.setClickable(true);
          //  view.setOnClickListener(this);
            cardView = (CardView)view.findViewById(R.id.cardView);
            usn = (TextView)view.findViewById(R.id.usn);
            //HODname = (TextView)view.findViewById(R.id.HODname);
        }
    }

    public StudAdapter(List<StudentList> sList) {
        this.sList = sList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        StudentList studentList = sList.get(position);
        holder.usn.setText(studentList.getUsn());
        //holder.HODname.setText(dept.getHODname());

    }

    @Override
    public int getItemCount() {
        return sList.size();
    }
}

