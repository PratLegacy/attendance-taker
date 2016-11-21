package com.example.arpitha.att_4th_proto;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
//import com.firebase.ui.StudAdapter;

import java.util.ArrayList;
import java.util.List;



public class student extends AppCompatActivity
        {

  //  private List<Sub1All> sub1allList = new ArrayList<>();

    private List<StudentList> studsList = new ArrayList<>();
        private RecyclerView recyclerView;

    public StudAdapter studAdapter;
    public static String dep = "dName";
    public static String se = "Sem";
    public String msgd = null;
   /* public String dep = null;
    public String se = null;*/
    public String msgs = null;
    public String na = null;
   /* public final static String dep = "dName";
    public final static String se = "dName";*/
   // public final static String dep = "com.example.arpitha.att_4th_proto.Stud.getSname()";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_student);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //  intent.putExtra(msga, sub1all.getSubCode());
                   /* intent.putExtra(dep, msgd);
                    intent.putExtra(se, msgs);*/
                    startActivity(intent);
                }
            });
            Intent intent = getIntent();
            studAdapter = new StudAdapter(studsList);
            //studsList.add(new StudentList("mukesh"));
            dep = intent.getStringExtra("dName");
            se = intent.getStringExtra("Sem");
            //msga = intent.getStringExtra("Sub");
            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

            Firebase.setAndroidContext(this);
            final Firebase ref = new Firebase("https://jssateb.firebaseio.com");
            //Firebase ref = new Firebase("https://luminous-torch-9353.firebaseio.com/");
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(studAdapter);
            ref.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(final DataSnapshot snapshot, String previousChild) {
                    final StudentList facts = snapshot.getValue(StudentList.class);
                    Intent ntent = getIntent();

                    msgd = ntent.getStringExtra(sub1AllActivity.dep);
                 msgs = ntent.getStringExtra(sub1AllActivity.se);
                    //System.out.println(snapshot.getKey() + " was " + facts.getDept() + " meters tall");
                  //  Toast.makeText(getApplicationContext(), snapshot.getKey() + "of department " + msgd + "and sem" + msgs + " is selected!", Toast.LENGTH_SHORT).show();
                    //na=snapshot.getKey();

                   /* Log.e("WORKING",facts.getDept());
                    Log.e("WORKING",facts.getUsn());
                    Log.e("WORKING", String.valueOf(facts.getSem()));
                    Log.e("WORKING",facts.getSub1attend());*/

                    //if(msgd.equals(facts.getDept())) {
                        recyclerView.addOnItemTouchListener(new sub1AllActivity.RecyclerTouchListener(getApplicationContext(), recyclerView, new sub1AllActivity.ClickListener() {
                            @Override
                            public void onClick(View view, int position) {
                                StudentList m = new StudentList();
                                //hardcoded


                                if(snapshot.getKey()=="Prathik") {
                                    m.setSub1attend((facts.getSub1attend()));
                                    m.setSub2attend((facts.getSub2attend()));
                                    m.setUsn((facts.getUsn()));
                                    m.setDept(facts.getDept());
                                    m.setSem(facts.getSem());
                                    ref.child(snapshot.getKey()).setValue(m);
                                }
                               else if(snapshot.getKey().equals("Arpitha")) {
                                    m.setSub1attend((facts.getSub1attend()));
                                    m.setSub2attend((facts.getSub2attend()));
                                    m.setUsn((facts.getUsn()));
                                    m.setDept(facts.getDept());
                                    m.setSem(facts.getSem());
                                    ref.child(snapshot.getKey()).setValue(m);
                                }
                                else if(snapshot.getKey()=="Vagi") {
                                    m.setSub1attend((facts.getSub1attend()));
                                    m.setSub2attend((facts.getSub2attend()));
                                    m.setUsn((facts.getUsn()));
                                    m.setDept(facts.getDept());
                                    m.setSem(facts.getSem());
                                    ref.child(snapshot.getKey()).setValue(m);
                                }
else {
                                    m.setSub1attend((facts.getSub1attend()) + 1);
                                    m.setSub2attend((facts.getSub2attend()));
                                    m.setUsn((facts.getUsn()));
                                    m.setDept(facts.getDept());
                                    m.setSem(facts.getSem());
                                    ref.child(snapshot.getKey()).setValue(m);
                                }
                                    //   m.setDescription(descText.getText().toString());

                                    //ref.child(snapshot.getKey()).setValue(m);

                                    /*Sub1All sub1all = sub1allList.get(position);

                            Intent ntent = getIntent();

                            String msgd = ntent.getStringExtra(semList.dep);
                            String msgs = ntent.getStringExtra(semList.se);

                            Toast.makeText(getApplicationContext(), sub1all.getSubName() + " " + msgd + " " + msgs + " is selected!", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(), student.class);
                            //  intent.putExtra(msga, sub1all.getSubCode());
                            intent.putExtra(dep, msgd);
                            intent.putExtra(se, msgs);
                            startActivity(intent);*/
                            }

                            @Override
                            public void onLongClick(View view, int position) {

                            }
                        }));
                    //}
                    //prepareSubData(msgd, msgs);
                    studsList.add(new StudentList(snapshot.getKey()));

                   // studAdapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
                // ....
            });











        }




    }
