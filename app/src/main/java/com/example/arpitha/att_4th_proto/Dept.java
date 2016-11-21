package com.example.arpitha.att_4th_proto;

/**
 * Created by Arpitha on 24/04/2016.
 */
public class Dept {
    private String dname, HODname;

    public Dept() {

    }

    public Dept(String dname, String HODname) {
        this.dname = dname;
        this.HODname = HODname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getHODname() {
        return HODname;
    }

    public void setHODname(String HODname) {
        this.HODname = HODname;
    }
}
