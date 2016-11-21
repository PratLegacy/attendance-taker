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

public class sub1AllActivity extends AppCompatActivity {

    private List<Sub1All> sub1allList = new ArrayList<>();
    private RecyclerView recyclerView;
    public static String dep = "dName";
    public static String se = "dName";

    private Sub1AllAdapter sub1allAdapter;
    public String messd;
    public String messs;
    String msgd = null;
    String msgs = null;
    String msga = null;
    public String IS = "Information Science and Engineering";
    public String CS = "Computer Science and Engineering";
    public String IM = "Industrial Engineering and Management";
    public String EC = "Electronics and Communication Engineering";
    public String CV = "Civil Engineering";
    public String IT = "Electronics and Instrumentation Engineering";
    public String ME = "Mechanical Engineering";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1all);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        msgd = intent.getStringExtra("dName");
        msgs = intent.getStringExtra("Sem");
        msga = intent.getStringExtra("Sub");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        sub1allAdapter = new Sub1AllAdapter(sub1allList);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(sub1allAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Sub1All sub1all = sub1allList.get(position);

                Intent ntent = getIntent();

                String msgd = ntent.getStringExtra(semList.dep);
                String msgs = ntent.getStringExtra(semList.se);

                Toast.makeText(getApplicationContext(), sub1all.getSubName() + " " + msgd + " " + msgs + " is selected!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), student.class);
              //  intent.putExtra(msga, sub1all.getSubCode());
                intent.putExtra(dep, msgd);
                intent.putExtra(se, msgs);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        prepareSubData(msgd, msgs);

    }

    private void prepareSubData(String d, String s) {

        if((msgd.equals(IS)||msgd.equals(CS)||msgd.equals(IM)||msgd.equals(ME)||msgd.equals(CV)||msgd.equals(EC)||msgd.equals(IT)) && (msgs.equals("First Semester")||msgs.equals("Second Semester"))) {

            sub1allList.add(new Sub1All("Engineering Mathematics - I", "10MAT11"));
            sub1allList.add(new Sub1All("Engineering Mathematics - II", "10MAT21"));
            sub1allList.add(new Sub1All("Engineering Physics", "10PHY12/10PHY22"));
            sub1allList.add(new Sub1All("Engineering Chemistry", "10CHE12/10CHE22"));
            sub1allList.add(new Sub1All("Elements of Civil Engineering and Mechanics", "10CIV13/10CIV23"));
            sub1allList.add(new Sub1All("Programming in C & Data Structure", "10CCP13/10CCP23"));
            sub1allList.add(new Sub1All("Elements of Mechanical Engineering", "10EME14/10EME24"));
            sub1allList.add(new Sub1All("Computer Aided Engineering Drawing", "10CED14/10CED24"));
            sub1allList.add(new Sub1All("Basic Electrical Engineering", "10ELE15/10ELE25"));
            sub1allList.add(new Sub1All("Basic Electronics", "10ELN15/10ELN25"));
            sub1allList.add(new Sub1All("Constitution of India and Professional Ethics", "10CIP18/10CIP28"));
            sub1allList.add(new Sub1All("Environmental Studies", "10CIV18/10CIV28"));
            sub1allList.add(new Sub1All("Workshop Practice Laboratory", "10WSL16/10WSL26"));
            sub1allList.add(new Sub1All("Computer Programming Laboratory", "10CPL16/10CPL26"));
            sub1allList.add(new Sub1All("Engineering Physics Laboratory", "10PHYL17/10PHYL27"));
            sub1allList.add(new Sub1All("Engineering Chemistry Laboratory", "10CHEL17/10CHEL27"));
        }

        else if(msgd.equals(IS) && msgs.equals("Third Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - III", "10MAT31"));
            sub1allList.add(new Sub1All("Electronic Circuits", "10CS32"));
            sub1allList.add(new Sub1All("Logic Design", "10CS33"));
            sub1allList.add(new Sub1All("Discrete Mathematical Structures", "10CS34"));
            sub1allList.add(new Sub1All("Data Structure with C", "10CS35"));
            sub1allList.add(new Sub1All("Oops With C++", "10CS36"));
            sub1allList.add(new Sub1All("Data Structure with C/C++ Laboratory", "10CSL37"));
            sub1allList.add(new Sub1All("EC & LD Laboratory", "10CSL38"));
        }

        else if(msgd.equals(IS) && msgs.equals("Fourth Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - IV", "10MAT41"));
            sub1allList.add(new Sub1All("Graph Theory and Combinatorics", "10CS42"));
            sub1allList.add(new Sub1All("Design and Analysis of Algorithm", "10CS43"));
            sub1allList.add(new Sub1All("Unix and Shell Programming", "10CS44"));
            sub1allList.add(new Sub1All("Microprocessors", "10CS45"));
            sub1allList.add(new Sub1All("Computer Organisation", "10CS46"));
            sub1allList.add(new Sub1All("Design and Analysis of Algorithm Laboratory", "10CSL47"));
            sub1allList.add(new Sub1All("Microprocessors Laboratory ","10CSL48"));
        }

        else if(msgd.equals(IS) && msgs.equals("Fifth Semester")) {

            sub1allList.add(new Sub1All("Software Engineering", "10IS51"));
            sub1allList.add(new Sub1All("System Software", "10CS52"));
            sub1allList.add(new Sub1All("Operating System", "10CS53"));
            sub1allList.add(new Sub1All("Database Management System", "10CS54"));
            sub1allList.add(new Sub1All("Computer Networks - I", "10CS55"));
            sub1allList.add(new Sub1All("Formal Languages and Automata Theory", "10CS56"));
            sub1allList.add(new Sub1All("Database Applications Laboratory", "10CSL57"));
            sub1allList.add(new Sub1All("System Software and Operating Systems Laboratory ","10CSL58"));
        }

        else if(msgd.equals(IS) && msgs.equals("Sixth Semester")) {

            sub1allList.add(new Sub1All("Management and Entrepreneurship", "10AL61"));
            sub1allList.add(new Sub1All("Unix System Programming", "10CS62"));
            sub1allList.add(new Sub1All("File Structures", "10IS63"));
            sub1allList.add(new Sub1All("Computer Networks - II", "10CS64"));
            sub1allList.add(new Sub1All("Software Testing", "10IS65"));
            sub1allList.add(new Sub1All("Elective I - Operations Research", "10IS661"));
            sub1allList.add(new Sub1All("Elective I - Compiler Design", "10IS662"));
            sub1allList.add(new Sub1All("Elective I - Data Compression", "10IS663"));
            sub1allList.add(new Sub1All("Elective I - Pattern Recognition", "10IS664"));
            sub1allList.add(new Sub1All("Elective I - Computer Graphics and Visualization", "10IS665"));
            sub1allList.add(new Sub1All("Elective I - Programming Languages", "10IS666"));
            sub1allList.add(new Sub1All("File Structures Laboratory", "10ISL67"));
            sub1allList.add(new Sub1All("Software Testing Laboratory ","10ISL68"));
        }

        else if(msgd.equals(IS) && msgs.equals("Seventh Semester")) {

            sub1allList.add(new Sub1All("Object-Oriented Modeling and Design", "10C71S"));
            sub1allList.add(new Sub1All("Information Systems", "10IS72"));
            sub1allList.add(new Sub1All("Programming the Web", "10CS73"));
            sub1allList.add(new Sub1All("Data Warehousing and Data Mining", "10IS74"));
            sub1allList.add(new Sub1All("Elective II - Advanced DBMS", "10IS751"));
            sub1allList.add(new Sub1All("Elective II - Embedded Computing Systems", "10IS752"));
            sub1allList.add(new Sub1All("Elective II - JAVA and J2EE", "10IS753"));
            sub1allList.add(new Sub1All("Elective II - Multimedia Computing", "10IS754"));
            sub1allList.add(new Sub1All("Elective II - Advanced Software Engineering", "10IS755"));
            sub1allList.add(new Sub1All("Elective II - Neutral Networks", "10IS756"));
            sub1allList.add(new Sub1All("Elective III - C# Programming and .NET", "10IS761"));
            sub1allList.add(new Sub1All("Elective III - Digital Image Processing", "10IS762"));
            sub1allList.add(new Sub1All("Elective III - Game Theory", "10IS763"));
            sub1allList.add(new Sub1All("Elective III - Artificial Intelligence", "10IS764"));
            sub1allList.add(new Sub1All("Elective III - Storage Area Networks", "10IS765"));
            sub1allList.add(new Sub1All("Elective III - Fuzzy Logic", "10IS766"));
            sub1allList.add(new Sub1All("Networks Laboratory", "10CSL77"));
            sub1allList.add(new Sub1All("Web Programming Laboratory ","10CSL78"));
        }

        else if(msgd.equals(IS) && msgs.equals("Eighth Semester")) {

            sub1allList.add(new Sub1All("Software Architecture", "10IS81"));
            sub1allList.add(new Sub1All("System Modeling and Simulation", "10CS82"));
            sub1allList.add(new Sub1All("Elective IV - Wireless Networks and Mobile Computing", "10IS831"));
            sub1allList.add(new Sub1All("Elective IV - Web 2.0 and Rich Internet Application", "10IS832"));
            sub1allList.add(new Sub1All("Elective IV - User Interface Design", "10IS833"));
            sub1allList.add(new Sub1All("Elective IV - Network Management Systems", "10IS834"));
            sub1allList.add(new Sub1All("Elective IV - Information and Networks Security", "10IS835"));
            sub1allList.add(new Sub1All("Elective IV - Microcontroller Based Systems", "10IS836"));
            sub1allList.add(new Sub1All("Elective V - ADHOC Networks", "10IS841"));
            sub1allList.add(new Sub1All("Elective V - Information Retrieval", "10IS842"));
            sub1allList.add(new Sub1All("Elective V - Supply Chain Management", "10IS843"));
            sub1allList.add(new Sub1All("Elective V - Services Oriented Architecture", "10IS844"));
            sub1allList.add(new Sub1All("Elective V - Clouds Grids and Clusters", "10IS845"));
            sub1allList.add(new Sub1All("Elective V - Decision Support Systems", "10IS846"));
        }

        else if(msgd.equals(CS) && msgs.equals("Third Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - III", "10MAT31"));
            sub1allList.add(new Sub1All("Electronic Circuits", "10CS32"));
            sub1allList.add(new Sub1All("Logic Design", "10CS33"));
            sub1allList.add(new Sub1All("Discrete Mathematical Structures", "10CS34"));
            sub1allList.add(new Sub1All("Data Structure with C", "10CS35"));
            sub1allList.add(new Sub1All("Oops With C++", "10CS36"));
            sub1allList.add(new Sub1All("Data Structure with C/C++ Laboratory", "10CSL37"));
            sub1allList.add(new Sub1All("EC & LD Laboratory", "10CSL38"));
        }

        else if(msgd.equals(CS) && msgs.equals("Fourth Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - IV", "10MAT41"));
            sub1allList.add(new Sub1All("Graph Theory and Combinatorics", "10CS42"));
            sub1allList.add(new Sub1All("Design and Analysis of Algorithm", "10CS43"));
            sub1allList.add(new Sub1All("Unix and Shell Programming", "10CS44"));
            sub1allList.add(new Sub1All("Microprocessors", "10CS45"));
            sub1allList.add(new Sub1All("Computer Organisation", "10CS46"));
            sub1allList.add(new Sub1All("Design and Analysis of Algorithm Laboratory", "10CSL47"));
            sub1allList.add(new Sub1All("Microprocessors Laboratory ","10CSL48"));
        }

        else if(msgd.equals(CS) && msgs.equals("Fifth Semester")) {

            sub1allList.add(new Sub1All("Software Engineering", "10IS51"));
            sub1allList.add(new Sub1All("System Software", "10CS52"));
            sub1allList.add(new Sub1All("Operating System", "10CS53"));
            sub1allList.add(new Sub1All("Database Management System", "10CS54"));
            sub1allList.add(new Sub1All("Computer Networks - I", "10CS55"));
            sub1allList.add(new Sub1All("Formal Languages and Automata Theory", "10CS56"));
            sub1allList.add(new Sub1All("Database Applications Laboratory", "10CSL57"));
            sub1allList.add(new Sub1All("System Software and Operating Systems Laboratory ","10CSL58"));
        }

        else if(msgd.equals(CS) && msgs.equals("Sixth Semester")) {

            sub1allList.add(new Sub1All("Management and Entrepreneurship", "10AL61"));
            sub1allList.add(new Sub1All("Unix System Programming", "10CS62"));
            sub1allList.add(new Sub1All("Compiler Design", "10CS63"));
            sub1allList.add(new Sub1All("Computer Networks - II", "10CS64"));
            sub1allList.add(new Sub1All("Computer Graphics and Visualization", "10CS65"));
            sub1allList.add(new Sub1All("Elective I - Operations Research", "10CS661"));
            sub1allList.add(new Sub1All("Elective I - Signals ans Systems", "10CS662"));
            sub1allList.add(new Sub1All("Elective I - Data Compression", "10CS663"));
            sub1allList.add(new Sub1All("Elective I - Pattern Recognition", "10CS664"));
            sub1allList.add(new Sub1All("Elective I - Stochastic Models and Applications", "10CS665"));
            sub1allList.add(new Sub1All("Elective I - Programming Languages", "10CS666"));
            sub1allList.add(new Sub1All("Unix System Programming and Compiler Design Laboratory", "10CSL67"));
            sub1allList.add(new Sub1All("Computer Graphics and Visualization ","10CSL68"));
        }

        else if(msgd.equals(CS) && msgs.equals("Seventh Semester")) {

            sub1allList.add(new Sub1All("Object-Oriented Modeling and Design", "10CS71"));
            sub1allList.add(new Sub1All("Embedded Computing Systems", "10CS72"));
            sub1allList.add(new Sub1All("Programming the Web", "10CS73"));
            sub1allList.add(new Sub1All("Advanced Computer Architecture", "10CS74"));
            sub1allList.add(new Sub1All("Elective II - Advanced DBMS", "10CS751"));
            sub1allList.add(new Sub1All("Elective II - Digital Signal Processing ", "10CS752"));
            sub1allList.add(new Sub1All("Elective II - JAVA and J2EE", "10CS753"));
            sub1allList.add(new Sub1All("Elective II - Multimedia Computing", "10CS754"));
            sub1allList.add(new Sub1All("Elective II - Data Warehousing and Data Mining", "10CS755"));
            sub1allList.add(new Sub1All("Elective II - Neural Networks", "10CS756"));
            sub1allList.add(new Sub1All("Elective III - C# Programming and .NET", "10CS761"));
            sub1allList.add(new Sub1All("Elective III - Digital Image Processing", "10CS762"));
            sub1allList.add(new Sub1All("Elective III - Game Theory", "10CS763"));
            sub1allList.add(new Sub1All("Elective III - Artificial Intelligence", "10CS764"));
            sub1allList.add(new Sub1All("Elective III - Storage Area Networks", "10CS765"));
            sub1allList.add(new Sub1All("Elective III - Fuzzy Logic", "10CS766"));
            sub1allList.add(new Sub1All("Networks Laboratory", "10CSL77"));
            sub1allList.add(new Sub1All("Web Programming Laboratory ","10CSL78"));
        }

        else if(msgd.equals(CS) && msgs.equals("Eighth Semester")) {
            sub1allList.add(new Sub1All("Software Architecture", "10CS81"));
            sub1allList.add(new Sub1All("System Modeling and Simulation", "10CS82"));
            sub1allList.add(new Sub1All("Elective IV - Wireless Networks and Mobile Computing", "10CS831"));
            sub1allList.add(new Sub1All("Elective IV - Web 2.0 and Rich Internet Application", "10CS832"));
            sub1allList.add(new Sub1All("Elective IV - VLSI Design and Algorithm", "10CS833"));
            sub1allList.add(new Sub1All("Elective IV - Network Management Systems", "10CS834"));
            sub1allList.add(new Sub1All("Elective IV - Information and Networks Security", "10CS835"));
            sub1allList.add(new Sub1All("Elective IV - Microcontrollers Based Systems", "10CS836"));
            sub1allList.add(new Sub1All("Elective V - ADHOC Networks", "10CS841"));
            sub1allList.add(new Sub1All("Elective V - Software Testing", "10CS842"));
            sub1allList.add(new Sub1All("Elective V - ARM Based System Design", "10CS843"));
            sub1allList.add(new Sub1All("Elective V - Service Oriented Architecture", "10CS844"));
            sub1allList.add(new Sub1All("Elective V - Clouds Grids and Clusters", "10CS845"));
            sub1allList.add(new Sub1All("Elective V - Multi-Core Architecture and Programming", "10CS846"));
        }

        else if(msgd.equals(IM) && msgs.equals("Third Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - III", "10MAT31"));
            sub1allList.add(new Sub1All("Material Science And Metallurgy", "10ME32A"));
            sub1allList.add(new Sub1All("Mechanical Measurements And Metrology", "10ME32B"));
            sub1allList.add(new Sub1All("Basic Thermodynamics", "10ME33"));
            sub1allList.add(new Sub1All("Mechanics Of Materials", "10ME34"));
            sub1allList.add(new Sub1All("Manufacturing Process - I", "10ME35"));
            sub1allList.add(new Sub1All("Computer Aided Machine Drawing" , "10ME36A"));
            sub1allList.add(new Sub1All("Fluid Mechanics", "10ME36B"));
            sub1allList.add(new Sub1All("Metallography And Material Testing Laboratory", "10MEL37A"));
            sub1allList.add(new Sub1All("Mechanical Measurements and Metrology Laboratory","10MEL37B"));
            sub1allList.add(new Sub1All("Foundry And Forging Laboratory", "10MEL38A"));
            sub1allList.add(new Sub1All("Machine Shop", "10MEL38B"));

        }

        else if(msgd.equals(IM) && msgs.equals("Fourth Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - IV", "10IMAT41"));
            sub1allList.add(new Sub1All("Material Science And Metallurgy", "10ME42A"));
            sub1allList.add(new Sub1All("Mechanical Measurements And Metrology", "10ME42B"));
            sub1allList.add(new Sub1All("Applied Thermodynamics", "10ME43"));
            sub1allList.add(new Sub1All("Kinematics Of Machines", "10ME44"));
            sub1allList.add(new Sub1All("Manufacturing Process-II", "10ME45"));
            sub1allList.add(new Sub1All("Computer Aided Machine Drawing" , "10ME46A"));
            sub1allList.add(new Sub1All("Fluid Mechanics", "10ME46B"));
            sub1allList.add(new Sub1All("Metallography And Material Testing Laboratory", "10MEL47A"));
            sub1allList.add(new Sub1All("Mechanical Measurements and Metrology Laboratory","10MEL47B"));
            sub1allList.add(new Sub1All("Foundry And Forging Laboratory", "10MEL48A"));
            sub1allList.add(new Sub1All("Machine Shop", "10MEL48B"));

        }

        else if(msgd.equals(IM) && msgs.equals("Fifth Semester")) {

            sub1allList.add(new Sub1All("Management And Entrepreneurship", "10AL51"));
            sub1allList.add(new Sub1All("Engineering Economy", "10IM52"));
            sub1allList.add(new Sub1All("Work Study And Ergonomics", "10IM53"));
            sub1allList.add(new Sub1All("CAD/CAM", "10IM54"));
            sub1allList.add(new Sub1All("Design Of Machine Elements", "10IM55"));
            sub1allList.add(new Sub1All("Statistics For Engineers", "10IM56"));
            sub1allList.add(new Sub1All("Mechanical Laboratory", "10IML57"));
            sub1allList.add(new Sub1All("Work Study And Ergonomics Laboratory ","10IML58"));
        }

        else if(msgd.equals(IM) && msgs.equals("Sixth Semester")) {

            sub1allList.add(new Sub1All("Materials Management", "10IM61"));
            sub1allList.add(new Sub1All("Quality Assurance And Reliability", "10IM62"));
            sub1allList.add(new Sub1All("Operations Research", "10IM63"));
            sub1allList.add(new Sub1All("Simulation Modeling And Analysis", "10IM64"));
            sub1allList.add(new Sub1All("Software Engineering And Management", "10IM65"));
            sub1allList.add(new Sub1All("Elective I - Value Engineering", "10IM661"));
            sub1allList.add(new Sub1All("Elective I - Theory Of Metal Forming", "10IM662"));
            sub1allList.add(new Sub1All("Elective I - Finite Element Method", "10IM663"));
            sub1allList.add(new Sub1All("Elective I - Human Resource Management", "10IM664"));
            sub1allList.add(new Sub1All("Elective I - Advanced Machining Process", "10IM665"));
            sub1allList.add(new Sub1All("CAD/CAM Laboratory", "10IML67"));
            sub1allList.add(new Sub1All("Simulation Laboratory", "10IML68"));
        }

        else if(msgd.equals(IM) && msgs.equals("Seventh Semester")) {

            sub1allList.add(new Sub1All("Total Quality Management", "10IM71"));
            sub1allList.add(new Sub1All("Operations Management", "10IM72"));
            sub1allList.add(new Sub1All("Financial Accounting And Costing", "10IM73"));
            sub1allList.add(new Sub1All("Management Information Systems", "10IM74"));
            sub1allList.add(new Sub1All("Elective II -Enterprise Resource Planning ", "10IM751"));
            sub1allList.add(new Sub1All("Elective II - Concurrent Engineering ", "10IM752"));
            sub1allList.add(new Sub1All("Elective II - Marketing Management", "10IM753"));
            sub1allList.add(new Sub1All("Elective II - Technology Management", "10IM754"));
            sub1allList.add(new Sub1All("Elective II - Design And Development Of Enterprises", "10IM755"));
            sub1allList.add(new Sub1All("Elective III - Financial Management", "10IM761"));
            sub1allList.add(new Sub1All("Elective III - Project Management", "10IM762"));
            sub1allList.add(new Sub1All("Elective III - Composite Materials", "10IM763"));
            sub1allList.add(new Sub1All("Elective III - World Class Manufacturing", "10IM764"));
            sub1allList.add(new Sub1All("Elective III - Combinatorial Optimization", "10IM765"));
            sub1allList.add(new Sub1All("Enterprise Resource Planning Laboratory", "10IML77"));
            sub1allList.add(new Sub1All("Quality Engineering Laboratory","10IML78"));
        }

        else if(msgd.equals(IM) && msgs.equals("Eighth Semester")) {

            sub1allList.add(new Sub1All("Supply Chain Management", "10IM81"));
            sub1allList.add(new Sub1All("Facilities Planning And Designing", "10IM82"));
            sub1allList.add(new Sub1All("Elective IV - Organisational Behaviour", "10IM831"));
            sub1allList.add(new Sub1All("Elective IV - Knowledge Management", "10IM832"));
            sub1allList.add(new Sub1All("Elective IV - Design Of Experiments", "10IM833"));
            sub1allList.add(new Sub1All("Elective IV - Advanced Operations Research", "10IM834"));
            sub1allList.add(new Sub1All("Elective IV - Database Management Systems", "10IM835"));
            sub1allList.add(new Sub1All("Elective IV - Strategic Management", "10IM836"));
            sub1allList.add(new Sub1All("Elective V -  Artificial Intelligence And Expert Systems", "10IM841"));
            sub1allList.add(new Sub1All("Elective V -  Just In Time Manufacturing", "10IM842"));
            sub1allList.add(new Sub1All("Elective V -  Automation In Manufacture", "10IM843"));
            sub1allList.add(new Sub1All("Elective V -  Decision Support Systems", "10IM844"));
            sub1allList.add(new Sub1All("Elective V -  Reliability Engineering", "10IM845"));
            sub1allList.add(new Sub1All("Elective V -  Data Warehousing And Mining", "10IM846"));
        }

        else if(msgd.equals(ME) && msgs.equals("Third Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - III", "10MAT31"));
            sub1allList.add(new Sub1All("Material Science And Metallurgy", "10ME32A"));
            sub1allList.add(new Sub1All("Mechanical Measurements And Metrology", "10ME32B"));
            sub1allList.add(new Sub1All("Basic Thermodynamics", "10ME33"));
            sub1allList.add(new Sub1All("Mechanics Of Materials", "10ME34"));
            sub1allList.add(new Sub1All("Manufacturing Process - I", "10ME35"));
            sub1allList.add(new Sub1All("Computer Aided Machine Drawing" , "10ME36A"));
            sub1allList.add(new Sub1All("Fluid Mechanics", "10ME36B"));
            sub1allList.add(new Sub1All("Metallography And Material Testing Laboratory", "10ME37A"));
            sub1allList.add(new Sub1All("Mechanical Measurement and Metrology Laboratory", "10ME37B"));
            sub1allList.add(new Sub1All("Foundry And Forging Laboratory", "10MEL38A"));
            sub1allList.add(new Sub1All("Machine Shop", "10MEL38B"));

        }

        else if(msgd.equals(ME) && msgs.equals("Fourth Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - IV", "10MAT41"));
            sub1allList.add(new Sub1All("Material Science And Metallurgy", "10ME42A"));
            sub1allList.add(new Sub1All("Mechanical Measurements And Metrology", "10ME42B"));
            sub1allList.add(new Sub1All("Applied Thermodynamics", "10ME43"));
            sub1allList.add(new Sub1All("Kinematics Of Machines", "10ME44"));
            sub1allList.add(new Sub1All("Manufacturing Process-II", "10ME45"));
            sub1allList.add(new Sub1All("Computer Aided Machine Drawing" , "10ME46A"));
            sub1allList.add(new Sub1All("Fluid Mechanics", "10ME46B"));
            sub1allList.add(new Sub1All("Metallography And Material Testing Laboratory", "10ME47A"));
            sub1allList.add(new Sub1All("Mechanical Measurement and Metrology Laboratory", "10ME47B"));
            sub1allList.add(new Sub1All("Foundry And Forging Laboratory", "10ME48A"));
            sub1allList.add(new Sub1All("Machine Shop", "10MEL48B"));

        }

        else if(msgd.equals(ME) && msgs.equals("Fifth Semester")) {

            sub1allList.add(new Sub1All("Management And Entrepreneurship", "10AL51"));
            sub1allList.add(new Sub1All("Design of Machine Elements - I", "10ME52"));
            sub1allList.add(new Sub1All("Energy Engineering", "10ME53"));
            sub1allList.add(new Sub1All("Dynamics of Machine", "10ME54"));
            sub1allList.add(new Sub1All("Manufacturing Process-III", "10ME55"));
            sub1allList.add(new Sub1All("Turbo Machines", "10ME56"));
            sub1allList.add(new Sub1All("Fluid Mechanics and Machine Laboratory ", "10MEL57"));
            sub1allList.add(new Sub1All("Energy Conversion Engineering Laboratory", "10MEL58"));
        }

        else if(msgd.equals(ME) && msgs.equals("Sixth Semester")) {

            sub1allList.add(new Sub1All("Computer Integrated Manufacturing", "10ME61"));
            sub1allList.add(new Sub1All("Design of Machine Elements - II", "10ME62"));
            sub1allList.add(new Sub1All("Heat and Mass Transfer", "10ME63"));
            sub1allList.add(new Sub1All("Finite Element Method", "10ME64"));
            sub1allList.add(new Sub1All("Mechatronics and Microprocessor", "10ME65"));
            sub1allList.add(new Sub1All("Elective I - Theory of Elasticity", "10ME661"));
            sub1allList.add(new Sub1All("Elective I - Mechanics of Composite Material", "10ME662"));
            sub1allList.add(new Sub1All("Elective I - Refrigeration and Air Conditioning", "10ME663"));
            sub1allList.add(new Sub1All("Elective I - Design of Heat Exchanger", "10ME664"));
            sub1allList.add(new Sub1All("Elective I - Non-Traditional Machining", "10ME665"));
            sub1allList.add(new Sub1All("Elective I - Knowledge Management", "10ME666"));
            sub1allList.add(new Sub1All("Elective I - Project Management", "10ME667"));
            sub1allList.add(new Sub1All("Elective I - Statistical Quality Control", "10ME668"));
            sub1allList.add(new Sub1All("Heat and Mass Transfer Laboratory", "10MEL67"));
            sub1allList.add(new Sub1All("Computer Aided Modeling and Analysis Laboratory", "10MEL68"));
        }

        else if(msgd.equals(ME) && msgs.equals("Seventh Semester")) {

            sub1allList.add(new Sub1All("Engineering Economy", "10ME71"));
            sub1allList.add(new Sub1All("Mechanical Vibrations", "10ME72"));
            sub1allList.add(new Sub1All("Hydraulics and Pneumatics", "10ME73"));
            sub1allList.add(new Sub1All("Operations Research", "10ME74"));
            sub1allList.add(new Sub1All("Elective II - Mechanism Design ", "10ME751"));
            sub1allList.add(new Sub1All("Elective II - Theory of Plasticity ", "10ME752"));
            sub1allList.add(new Sub1All("Elective II - Engineering Design", "10ME753"));
            sub1allList.add(new Sub1All("Elective II - Non-Conventional Energy Sources", "10ME754"));
            sub1allList.add(new Sub1All("Elective II - Gas Dynamics", "10ME755"));
            sub1allList.add(new Sub1All("Elective II - Management Information System", "10ME756"));
            sub1allList.add(new Sub1All("Elective II - Automation in Manufacturing", "10ME757"));
            sub1allList.add(new Sub1All("Elective II - Total Quality Management", "10ME758"));
            sub1allList.add(new Sub1All("Elective III - Experimental Stress Analysis", "10ME761"));
            sub1allList.add(new Sub1All("Elective III - Tool Design", "10ME762"));
            sub1allList.add(new Sub1All("Elective III - Cryogenics", "10ME763"));
            sub1allList.add(new Sub1All("Elective III - Smart Materials", "10ME764"));
            sub1allList.add(new Sub1All("Elective III - Agile Manufacturing", "10ME765"));
            sub1allList.add(new Sub1All("Elective III - Robotics", "10ME766"));
            sub1allList.add(new Sub1All("Elective III - Finance Management", "10ME767"));
            sub1allList.add(new Sub1All("Elective III - Micro and Smart Systems Technology", "10ME768"));
            sub1allList.add(new Sub1All("Elective III - Product Life Cycle Management", "10ME769"));
            sub1allList.add(new Sub1All("Design Laboratory", "10MEL77"));
            sub1allList.add(new Sub1All("CIM & Automation Laboratory","10MEL78"));
        }

        else if(msgd.equals(ME) && msgs.equals("Eighth Semester")) {

            sub1allList.add(new Sub1All("Operation Management", "10ME81"));
            sub1allList.add(new Sub1All("Control Engineering", "10ME82"));
            sub1allList.add(new Sub1All("Elective IV - Tribology", "10ME831"));
            sub1allList.add(new Sub1All("Elective IV - Fracture Mechanics", "10ME832"));
            sub1allList.add(new Sub1All("Elective IV - Power Plant Engineering", "10ME833"));
            sub1allList.add(new Sub1All("Elective IV - Nano Technology", "10ME834"));
            sub1allList.add(new Sub1All("Elective IV - Organizational Behaviour and Professional Communication", "10ME835"));
            sub1allList.add(new Sub1All("Elective IV - Computer Graphics", "10ME836"));
            sub1allList.add(new Sub1All("Elective IV - Rapid Prototyping", "10ME837"));
            sub1allList.add(new Sub1All("Elective IV - Foundry Technology", "10ME838"));
            sub1allList.add(new Sub1All("Elective V - Machine Tool Design", "10ME841"));
            sub1allList.add(new Sub1All("Elective V - Industrial Engineering and Ergonomics", "10ME842"));
            sub1allList.add(new Sub1All("Elective V - Biomass Energy Systems", "10ME843"));
            sub1allList.add(new Sub1All("Elective V - Automotive Engineering", "10ME844"));
            sub1allList.add(new Sub1All("Elective V - Database Management System", "10ME845"));
            sub1allList.add(new Sub1All("Elective V - Artificial Intelligence", "10ME846"));
            sub1allList.add(new Sub1All("Elective V - Design Of Experiments", "10ME847"));
            sub1allList.add(new Sub1All("Elective V - Design for Manufacturing and Assembly", "10ME848"));
        }

        else if(msgd.equals(CV) && msgs.equals("Third Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - III", "1OMAT31"));
            sub1allList.add(new Sub1All("Building Materials And Construction Technology", "1OCV32"));
            sub1allList.add(new Sub1All("Strength Of Materials", "1OCV33"));
            sub1allList.add(new Sub1All("Surveying - I", "1OCV34"));
            sub1allList.add(new Sub1All("Fluid Mechanics", "1OCV35"));
            sub1allList.add(new Sub1All("Applied Engineering Geology", "1OCV36"));
            sub1allList.add(new Sub1All("Basic Material Testing Laboratory", "1OCVL37"));
            sub1allList.add(new Sub1All("Surveying Practice - I", "1OCVL38"));
        }

        else if(msgd.equals(CV) && msgs.equals("Fourth Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - IV", "1OMAT41"));
            sub1allList.add(new Sub1All("Concrete Technology", "1OCV42"));
            sub1allList.add(new Sub1All("Structural Analysis - I", "1OCV43"));
            sub1allList.add(new Sub1All("Surveying - II", "1OCV44"));
            sub1allList.add(new Sub1All("Hydraulics and Hydraulic Machines", "1OCV45"));
            sub1allList.add(new Sub1All("Building Planning and Drawing", "1OCV46"));
            sub1allList.add(new Sub1All("Surveying Practice - II", "1OCVL47"));
            sub1allList.add(new Sub1All("Applied Engineering Geology Laboratory ","1OCVL48"));
        }

        else if(msgd.equals(CV) && msgs.equals("Fifth Semester")) {

            sub1allList.add(new Sub1All("Management and Entrepreneurship", "1OAL51"));
            sub1allList.add(new Sub1All("Design Of RCC Structural Elements", "1OCV52"));
            sub1allList.add(new Sub1All("Structural Analysis - II", "1OCV53"));
            sub1allList.add(new Sub1All("Geotechnical Engineering - I", "1OCV54"));
            sub1allList.add(new Sub1All("Hydrology and Irrigation Engineering", "1OCV55"));
            sub1allList.add(new Sub1All("Transportation Engineering - I", "1OCV56"));
            sub1allList.add(new Sub1All("Hydraulics and Hydraulic Machinery Laboratory", "1OCVL57"));
            sub1allList.add(new Sub1All("Computer Aided Design Laboratory ","1OCVL58"));
        }

        else if(msgd.equals(CV) && msgs.equals("Sixth Semester")) {

            sub1allList.add(new Sub1All("Environmental Engineering - I", "1OCV61"));
            sub1allList.add(new Sub1All("Design and Drawing Of RC Structures", "1OCV62"));
            sub1allList.add(new Sub1All("Transportation Engineering - II", "1OCV63"));
            sub1allList.add(new Sub1All("Geotechnical Engineering - II", "1OCV64"));
            sub1allList.add(new Sub1All("Hydraulic Structures and Irrigation Design - Drawing", "1OCV65"));
            sub1allList.add(new Sub1All("Elective I - Theory Of Elasticity", "1OCV661"));
            sub1allList.add(new Sub1All("Elective I - Alternative Building Materials and Technologies", "1OCV662"));
            sub1allList.add(new Sub1All("Elective I - Ground Improvement Techniques", "1OCV663"));
            sub1allList.add(new Sub1All("Elective I - Advanced Surveying", "1OCV664"));
            sub1allList.add(new Sub1All("Elective I - Ground Water Hydrology", "1OCV665"));
            sub1allList.add(new Sub1All("Elective I - Rural Water Supply and Sanitation", "1OCV666"));
            sub1allList.add(new Sub1All("Elective I - Traffic Engineering", "1OCV667"));
            sub1allList.add(new Sub1All("Geotechnical Engineering Laboratory", "1OCVL67"));
            sub1allList.add(new Sub1All("Extensive Survey Viva-Voce ","1OCVL68"));
        }

        else if(msgd.equals(CV) && msgs.equals("Seventh Semester")) {

            sub1allList.add(new Sub1All("Environmental Engineering - II", "10CV71"));
            sub1allList.add(new Sub1All("Design Of Steel Structures", "10CV72"));
            sub1allList.add(new Sub1All("Estimation and Valuation", "10CV73"));
            sub1allList.add(new Sub1All("Design Of Pre-stressed Concrete Structures", "10CV74"));
            sub1allList.add(new Sub1All("Elective II - Matrix Methods Of Structural Analysis", "10CV751"));
            sub1allList.add(new Sub1All("Elective II - Advanced Design Of RC Structures", "10CV752"));
            sub1allList.add(new Sub1All("Elective II - Design Of Masonry Structures", "10CV753"));
            sub1allList.add(new Sub1All("Elective II - Earth and Earth Retaining Structures", "10CV754"));
            sub1allList.add(new Sub1All("Elective II - Highway Geometric Design", "10CV755"));
            sub1allList.add(new Sub1All("Elective II - Open Channel Hydraulics", "10CV756"));
            sub1allList.add(new Sub1All("Elective II - Solid Waste Management", "10CV757"));
            sub1allList.add(new Sub1All("Elective III - Numerical Method in Civil Engineering ", "10CV761"));
            sub1allList.add(new Sub1All("Elective III - Rock Mechanics", "10CV762"));
            sub1allList.add(new Sub1All("Elective III - Pavement Materials and Construction", "10CV763"));
            sub1allList.add(new Sub1All("Elective III - Photogrammetry and Remote Sensing", "10CV764"));
            sub1allList.add(new Sub1All("Elective III - Air Pollution and Control", "10CV765"));
            sub1allList.add(new Sub1All("Elective III - Design and Drawing of Bridges ", "10CV766"));
            sub1allList.add(new Sub1All("Elective III - Structural Dynamics", "10CV767"));
            sub1allList.add(new Sub1All("Environmental Engineering Laboratory", "10CVL77"));
            sub1allList.add(new Sub1All("Concrete and Highway Materials Laboratory ","10CVL78"));
        }

        else if(msgd.equals(CV) && msgs.equals("Eighth Semester")) {
            sub1allList.add(new Sub1All("Advanced Concrete Technology", "10CV81"));
            sub1allList.add(new Sub1All("Design and Drawing of Steel Structures", "10CV82"));
            sub1allList.add(new Sub1All("Advanced Pre-Stressed Concrete Structures", "10CV831"));
            sub1allList.add(new Sub1All("Elective IV - Advanced Foundation Design", "10CV832"));
            sub1allList.add(new Sub1All("Elective IV - Pavement Design", "10CV833"));
            sub1allList.add(new Sub1All("Elective IV - Earthquake Resistant Design Structures", "10CV834"));
            sub1allList.add(new Sub1All("Elective IV - Industrial Waste Water Treatment", "10CV835"));
            sub1allList.add(new Sub1All("Elective IV - Quality Management System in Civil Engineering", "10CV836"));
            sub1allList.add(new Sub1All("Elective V -  Finite Element Analysis", "10CV841"));
            sub1allList.add(new Sub1All("Elective V -  Reimforced Earth Structures", "10CV842"));
            sub1allList.add(new Sub1All("Elective V -  Urban Transport Planning", "10CV843"));
            sub1allList.add(new Sub1All("Elective V -  Geographic Information System", "10CV844"));
            sub1allList.add(new Sub1All("Elective V -  Advanced Design of Steel Structures", "10CV845"));
            sub1allList.add(new Sub1All("Elective V -  Water Resources Engineering", "1OCV846"));
            sub1allList.add(new Sub1All("Elective V -  Environmental Impact Assessment", "10CV847"));
        }

        else if(msgd.equals(EC) && msgs.equals("Third Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - III", "10MAT31"));
            sub1allList.add(new Sub1All("Analog Electronic Circuits", "10ES32"));
            sub1allList.add(new Sub1All("Logic Design", "10ES33"));
            sub1allList.add(new Sub1All("Network Analysis", "10ES34"));
            sub1allList.add(new Sub1All("Electronic Instrumentation", "10IT35"));
            sub1allList.add(new Sub1All("Field Theory", "10ES36"));
            sub1allList.add(new Sub1All("Analog Electronic Laboratory", "10ESL37"));
            sub1allList.add(new Sub1All("Logic Design Laboratory", "10ESL38"));
        }

        else if(msgd.equals(EC) && msgs.equals("Fourth Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - IV", "10MAT41"));
            sub1allList.add(new Sub1All("Microcontroller", "10ES42"));
            sub1allList.add(new Sub1All("Control Systems", "10ES43"));
            sub1allList.add(new Sub1All("Signals and Systems", "10EC44"));
            sub1allList.add(new Sub1All("Fundamentaks of HDL", "10EC45"));
            sub1allList.add(new Sub1All("Linear IC's and Application", "10EC46"));
            sub1allList.add(new Sub1All("Microcontroller Laboratory", "10ESL47"));
            sub1allList.add(new Sub1All("HDL Laboratory ","10ECL48"));
        }

        else if(msgd.equals(EC) && msgs.equals("Fifth Semester")) {

            sub1allList.add(new Sub1All("Management and Entrepreneurship", "10AL51"));
            sub1allList.add(new Sub1All("Digital Signal Processing", "10EC52"));
            sub1allList.add(new Sub1All("Analog Communication", "10EC53"));
            sub1allList.add(new Sub1All("Microwaves and Radar", "10EC54"));
            sub1allList.add(new Sub1All("Information Theory and Coding", "10EC55"));
            sub1allList.add(new Sub1All("Fundamentals of CMOS VLSI", "10EC56"));
            sub1allList.add(new Sub1All("Digital Signal Processing Laboratory", "10ECL57"));
            sub1allList.add(new Sub1All("Analog Communication Laboratory + LIC Laboratory","10ECL58"));
        }

        else if(msgd.equals(EC) && msgs.equals("Sixth Semester")) {

            sub1allList.add(new Sub1All("Digital Communication", "10EC61"));
            sub1allList.add(new Sub1All("Microprocessor", "10EC62"));
            sub1allList.add(new Sub1All("Microelectronics Circuits", "10EC63"));
            sub1allList.add(new Sub1All("Antennas and Propagation", "10EC64"));
            sub1allList.add(new Sub1All("Operating Systems", "10EC65"));
            sub1allList.add(new Sub1All("Elective I - Analog and Mixed Mode VLSI Design", "10EC631"));
            sub1allList.add(new Sub1All("Elective I - Satellite Communication", "10EC632"));
            sub1allList.add(new Sub1All("Elective I - Random Processes", "10EC663"));
            sub1allList.add(new Sub1All("Elective I - Low Power VLSI Design", "10EC664"));
            sub1allList.add(new Sub1All("Elective I - Data Structure using C++", "10EC665"));
            sub1allList.add(new Sub1All("Elective I - Digital Systems Design Using Verilog", "10EC666"));
            sub1allList.add(new Sub1All("Elective I - Virtual Instrumentation", "10EC667"));
            sub1allList.add(new Sub1All("Advanced Communication Laboratory", "10ECL67"));
            sub1allList.add(new Sub1All("Microprocessor Laboratory ","10ECL68"));
        }

        else if(msgd.equals(EC) && msgs.equals("Seventh Semester")) {

            sub1allList.add(new Sub1All("Computer Communication Networks", "10EC71"));
            sub1allList.add(new Sub1All("Optical Fiber Communication", "10EC72"));
            sub1allList.add(new Sub1All("Power Electronics", "10EC73"));
            sub1allList.add(new Sub1All("Embedded System Design", "10EC74"));
            sub1allList.add(new Sub1All("Elective II - DSP Algorithm and Architecture", "10EC751"));
            sub1allList.add(new Sub1All("Elective II - Micro and Smart Systems Technology", "10EC752"));
            sub1allList.add(new Sub1All("Elective II - Artificial Neural Networks", "10EC753"));
            sub1allList.add(new Sub1All("Elective II - CAD for VLSI", "10EC754"));
            sub1allList.add(new Sub1All("Elective II - Applied Embedded System Design", "10EC755"));
            sub1allList.add(new Sub1All("Elective II - Speech Processing", "10EC756"));
            sub1allList.add(new Sub1All("Elective III - Programming in C++", "10EC761"));
            sub1allList.add(new Sub1All("Elective III - Real-time Systems", "10EC762"));
            sub1allList.add(new Sub1All("Elective III - Image Processing", "10EC763"));
            sub1allList.add(new Sub1All("Elective III - Radio Frequency Integrated Circuits", "10EC764"));
            sub1allList.add(new Sub1All("Elective III - WAVELET Transforms", "10EC765"));
            sub1allList.add(new Sub1All("Elective III - Modeling and Simulation of Data Networks", "10EC766"));
            sub1allList.add(new Sub1All("VLSI Laboratory", "10ECL76"));
            sub1allList.add(new Sub1All("Power Electronics Laboratory ","10ECL77"));
        }

        else if(msgd.equals(EC) && msgs.equals("Eighth Semester")) {
            sub1allList.add(new Sub1All("Wireless Communication", "10EC81"));
            sub1allList.add(new Sub1All("Digital Switching Systems", "10EC82"));
            sub1allList.add(new Sub1All("Elective IV - Distributed System", "10EC831"));
            sub1allList.add(new Sub1All("Elective IV - Network Security", "10EC8322"));
            sub1allList.add(new Sub1All("Elective IV - Optical Networks", "10EC833"));
            sub1allList.add(new Sub1All("Elective IV - High Performance Computer Networks", "10EC834"));
            sub1allList.add(new Sub1All("Elective IV - Internet Engineering", "10EC835"));
            sub1allList.add(new Sub1All("Elective V - Multimedia Communications", "10EC841"));
            sub1allList.add(new Sub1All("Elective V - Real-time Operating System", "10EC842"));
            sub1allList.add(new Sub1All("Elective V - GSM", "10EC843"));
            sub1allList.add(new Sub1All("Elective V - ADHOC Wireless Networks", "10EC844"));
            sub1allList.add(new Sub1All("Elective V - Optical Computing", "10EC845"));
        }

        else if(msgd.equals(IT) && msgs.equals("Third Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - III", "10MAT31"));
            sub1allList.add(new Sub1All("Analog Electronic Circuits", "10ES32"));
            sub1allList.add(new Sub1All("Logic Design", "10ES33"));
            sub1allList.add(new Sub1All("Network Analysis", "10ES34"));
            sub1allList.add(new Sub1All("Electronic Instrumentation", "10IT35"));
            sub1allList.add(new Sub1All("Instrument Transudcers", "10IT36"));
            sub1allList.add(new Sub1All("Analog Electronic Laboratory", "10ESL37"));
            sub1allList.add(new Sub1All("Logic Design Laboratory", "10ESL38"));
        }

        else if(msgd.equals(IT) && msgs.equals("Fourth Semester")) {

            sub1allList.add(new Sub1All("Engineering Mathematics - IV", "10MAT41"));
            sub1allList.add(new Sub1All("Microcontroller", "10ES42"));
            sub1allList.add(new Sub1All("Control Systems", "10ES43"));
            sub1allList.add(new Sub1All("Signals and Systems", "10EC44"));
            sub1allList.add(new Sub1All("Fundamentaks of HDL", "10EC45"));
            sub1allList.add(new Sub1All("Linear IC's and Application", "10EC46"));
            sub1allList.add(new Sub1All("Microcontroller Laboratory", "10ESL47"));
            sub1allList.add(new Sub1All("HDL Laboratory ","10ECL48"));
        }

        else if(msgd.equals(IT) && msgs.equals("Fifth Semester")) {

            sub1allList.add(new Sub1All("Management and Entrepreneurship", "10AL51"));
            sub1allList.add(new Sub1All("Advanced Microprocessor and Peripherals", "10IT52"));
            sub1allList.add(new Sub1All("Digital Signal Processing", "10IT53"));
            sub1allList.add(new Sub1All("Process Instrumentation", "10IT54"));
            sub1allList.add(new Sub1All("Biomedical Instrumentation", "10IT55"));
            sub1allList.add(new Sub1All("C++ and DataStructures", "10IT56"));
            sub1allList.add(new Sub1All("Analog IC Laboratory", "10ITL57"));
            sub1allList.add(new Sub1All("Microprocessor Laboratory","10ITL58"));
        }

        else if(msgd.equals(IT) && msgs.equals("Sixth Semester")) {

            sub1allList.add(new Sub1All("Communication Systems", "10IT61"));
            sub1allList.add(new Sub1All("Advanced Control System", "10IT62"));
            sub1allList.add(new Sub1All("Digital Image Processing", "10IT63"));
            sub1allList.add(new Sub1All("Process Control System", "10IT64"));
            sub1allList.add(new Sub1All("Analytical and Pharmaceutical Instrmentation", "10IT65"));
            sub1allList.add(new Sub1All("Elective I - Computer Networks", "10IT65"));
            sub1allList.add(new Sub1All("Elective I - PIC Microcontroller", "10IT661"));
            sub1allList.add(new Sub1All("Elective I - Applied Numerical Methods", "10IT662"));
            sub1allList.add(new Sub1All("Elective I - Operating Systems", "10IT663"));
            sub1allList.add(new Sub1All("Elective I - Data St", "10IT664"));
            sub1allList.add(new Sub1All("Control System and Data Convertor Laboratory", "10ITL67"));
            sub1allList.add(new Sub1All("Instrumentation Laboratory ","10ITL68"));
        }

        else if(msgd.equals(IT) && msgs.equals("Seventh Semester")) {

            sub1allList.add(new Sub1All("VLSI Design", "10IT71"));
            sub1allList.add(new Sub1All("DSP Architecture", "10IT72"));
            sub1allList.add(new Sub1All("Robotics and Control", "10IT73"));
            sub1allList.add(new Sub1All("Automation in Process Control", "10IT74"));
            sub1allList.add(new Sub1All("Elective II - ARM Processor", "10IT751"));
            sub1allList.add(new Sub1All("Elective II - Aircraft Instrumentation", "10IT752"));
            sub1allList.add(new Sub1All("Elective II - System Modelling", "10IT753"));
            sub1allList.add(new Sub1All("Elective II - Medical Imaging Systems", "10IT754"));
            sub1allList.add(new Sub1All("Elective III - Embedded System and RTOS", "10IT761"));
            sub1allList.add(new Sub1All("Elective III - Distributed Sensor Networks", "10IT762"));
            sub1allList.add(new Sub1All("Elective III - Hardware Software Co-Design", "10IT763"));
            sub1allList.add(new Sub1All("Elective III - Micro and Smart System Technology", "10MS769"));
            sub1allList.add(new Sub1All("DSP Laboratory", "10ITL77"));
            sub1allList.add(new Sub1All("Process Control Laboratory ","10ITL78"));
        }

        else if(msgd.equals(IT) && msgs.equals("Eighth Semester")) {
            sub1allList.add(new Sub1All("Lasers and Optical Instrumentation", "10IT81"));
            sub1allList.add(new Sub1All("Neural Networks and Fuzzy Logic", "10IT82"));
            sub1allList.add(new Sub1All("Elective IV - Pattern Recognition", "10IT831"));
            sub1allList.add(new Sub1All("Elective IV - Speech Signal Processing", "10IT832"));
            sub1allList.add(new Sub1All("Elective IV - Industrial Instrumentation", "10IT833"));
            sub1allList.add(new Sub1All("Elective IV - WAVELET Transform", "10IT834"));
            sub1allList.add(new Sub1All("Elective V - Low Power VLSI Design", "10IT841"));
            sub1allList.add(new Sub1All("Elective V - Biomedical DSP", "10IT842"));
            sub1allList.add(new Sub1All("Elective V - Mobile Communication", "10IT843"));
            sub1allList.add(new Sub1All("Elective V - Smart Sensors", "10IT844"));
        }
        
        




        sub1allAdapter.notifyDataSetChanged();

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
