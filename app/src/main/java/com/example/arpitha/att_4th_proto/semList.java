package com.example.arpitha.att_4th_proto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class semList extends AppCompatActivity {

    private List<Sem> semList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SemsAdapter sAdapter;
    public Sem movieModel;
    public Dept deep;
    public final static String dep = "dName";
    public final static String se = "Sem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_list);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        sAdapter = new SemsAdapter(semList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Sem sem = semList.get(position);
                Intent ntent = getIntent();

                String message = ntent.getStringExtra(DeptActivity.dep);

                Toast.makeText(getApplicationContext(), sem.getSem() + " is selected!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), sub1AllActivity.class);
                intent.putExtra(dep, message);
                intent.putExtra(se, sem.getSem());
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));





            prepareDeptData();
    }

    private void prepareDeptData() {


        Sem sem = new Sem("First Semester", "Section: A");
        semList.add(sem);

        sem = new Sem("First Semester", "Section: B");
        semList.add(sem);

        sem = new Sem("Second Semester", "Section: A");
        semList.add(sem);

        sem = new Sem("Second Semester", "Section: B");
        semList.add(sem);

        sem = new Sem("Third Semester", "Section: A");
        semList.add(sem);

        sem = new Sem("Third Semester", "Section: B");
        semList.add(sem);

        sem = new Sem("Fourth Semester", "Section: A");
        semList.add(sem);

        sem = new Sem("Fourth Semester", "Section: B");
        semList.add(sem);

        sem = new Sem("Fifth Semester", "Section: A");
        semList.add(sem);

        sem = new Sem("Fifth Semester", "Section: B");
        semList.add(sem);

        sem = new Sem("Sixth Semester", "Section: A");
        semList.add(sem);

        sem = new Sem("Sixth Semester", "Section: B");
        semList.add(sem);

        sem = new Sem("Seventh Semester", "Section: A");
        semList.add(sem);

        sem = new Sem("Seventh Semester", "Section: B");
        semList.add(sem);

        sem = new Sem("Eighth Semester", "Section: A");
        semList.add(sem);

        sem = new Sem("Eighth Semester", "Section: B");
        semList.add(sem);

        sAdapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
