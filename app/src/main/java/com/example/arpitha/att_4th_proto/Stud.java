package com.example.arpitha.att_4th_proto;

/**
 * Created by Arpitha on 24/04/2016.
 */
public class Stud {
    private String usn, dept, sname;
    private int sem, Attend, Fi, Si, Ti;

    public Stud() {

    }

    public Stud(String usn, String dept, String sname, int sem, int Attend, int Fi, int Si, int Ti) {
        this.usn = usn;
        this.dept = dept;
        this.sname = sname;
        this.sem = sem;
        this.Attend = Attend;
        this.Fi = Fi;
        this.Si = Si;
        this.Ti = Ti;


    }

    public String getSname() {
        return sname;
    }
    public String getUsn() {
        return usn;
    }
    public String getDept() {
        return dept;
    }
    public int  getSem() {
        return sem;
    }
    public int  getAttend() {
        return Attend;
    }
    public int  getSi() {
        return Si;
    }
    public int  getFi() {
        return Fi;
    }
    public int  getTi() {
        return Ti;
    }
   /* public void setDname(String dname) {
        this.dname = dname;
    }*/

/*
    public void setHODname(String HODname) {
        this.HODname = HODname;
    }*/
}
