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
public class SemsAdapter extends RecyclerView.Adapter<SemsAdapter.MyViewHolder> {

    private List<Sem> semsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        public TextView sem,section;

        public MyViewHolder(View view) {
            super(view);

            cardView = (CardView)view.findViewById(R.id.cardView);
            sem = (TextView)view.findViewById(R.id.sem);
            section = (TextView)view.findViewById(R.id.section);
        }
    }

    public SemsAdapter(List<Sem> semsList) {
        this.semsList = semsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sem_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Sem sem = semsList.get(position);
        holder.sem.setText(sem.getSem());
        holder.section.setText(sem.getSection());

    }

    @Override
    public int getItemCount() {
        return semsList.size();
    }
}
