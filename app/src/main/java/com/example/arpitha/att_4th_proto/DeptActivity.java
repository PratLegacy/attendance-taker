package com.example.arpitha.att_4th_proto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class DeptActivity extends AppCompatActivity {

    private List<Dept> deptList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DeptsAdapter dAdapter;
    public final static String dep = "com.example.arpitha.att_4th_proto.Dept.getDname()";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        dAdapter = new DeptsAdapter(deptList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Dept dept = deptList.get(position);
                Toast.makeText(getApplicationContext(), dept.getDname() + " is selected!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), semList.class);
                intent.putExtra(dep, dept.getDname());

                        startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareDeptData();
    }

    private void prepareDeptData() {
        Dept dept = new Dept("Information Science and Engineering", "HOD: Dr. M L Chayadevi");
        deptList.add(dept);

        dept = new Dept("Computer Science and Engineering", "HOD: Dr. Prabhudev Jagadeesh");
        deptList.add(dept);

        dept = new Dept("Industrial Engineering and Management", "HOD: Dr. B P Mahesh  ");
        deptList.add(dept);

        dept = new Dept("Mechanical Engineering", "HOD: Dr. B P Shiva Kumar ");
        deptList.add(dept);

        dept = new Dept("Civil Engineering", "HOD: Dr. Nagabhushan ");
        deptList.add(dept);

        dept = new Dept("Electronics and Communication Engineering", "HOD: Dr. Aravind H S  ");
        deptList.add(dept);

        dept = new Dept("Electronics and Instrumentation Engineering", "HOD: Dr. D Mahesh Kumar");
        deptList.add(dept);

        dAdapter.notifyDataSetChanged();
    }

    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private DeptActivity.ClickListener clickListener;

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
