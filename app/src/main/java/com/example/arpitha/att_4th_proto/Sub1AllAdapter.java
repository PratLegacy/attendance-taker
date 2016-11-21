package com.example.arpitha.att_4th_proto;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Prathik on 25-Apr-16.
 */

public class Sub1AllAdapter extends RecyclerView.Adapter<Sub1AllAdapter.MyViewHolder> {

    private List<Sub1All> sub3IemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        public TextView subName,subCode;

        public MyViewHolder(View view) {
            super(view);

            cardView = (CardView)view.findViewById(R.id.cardView);
            subName = (TextView)view.findViewById(R.id.subName);
            subCode = (TextView)view.findViewById(R.id.subCode);
        }
    }



    public Sub1AllAdapter(List<Sub1All> sub3IemList) {
        this.sub3IemList = sub3IemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sub1all_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Sub1All sub3Iem = sub3IemList.get(position);
        holder.subName.setText(sub3Iem.getSubName());
        holder.subCode.setText(sub3Iem.getSubCode());

    }

    @Override
    public int getItemCount() {
        return sub3IemList.size();
    }
}
