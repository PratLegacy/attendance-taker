package com.example.arpitha.att_4th_proto;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Arpitha on 24/04/2016.
 */
public class DeptsAdapter extends RecyclerView.Adapter<DeptsAdapter.MyViewHolder> {

    private List<Dept> deptsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        public TextView dname,HODname;

        public MyViewHolder(View view) {
            super(view);

            cardView = (CardView)view.findViewById(R.id.cardView);
            dname = (TextView)view.findViewById(R.id.dname);
            HODname = (TextView)view.findViewById(R.id.HODname);
        }
    }

    public DeptsAdapter(List<Dept> deptsList) {
        this.deptsList = deptsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dept_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Dept dept = deptsList.get(position);
        holder.dname.setText(dept.getDname());
        holder.HODname.setText(dept.getHODname());

    }

    @Override
    public int getItemCount() {
        return deptsList.size();
    }
}
