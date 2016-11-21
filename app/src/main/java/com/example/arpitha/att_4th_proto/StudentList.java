package com.example.arpitha.att_4th_proto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.json.JSONObject;

/**
 * Created by kai on 1/5/16.
 */
public class StudentList {
    public String dept;
    public int sem;
    public String usn;// = "1js13is004";
    public int sub1attend;
    public int sub2attend;
    public StudentList() {
        // empty default constructor, necessary for Firebase to be able to deserialize blog posts
    }

    public StudentList(String usn) {
        this.usn = usn;
        //this.section = section;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String getDept() {
        return dept;
    }
    public int getSem() {
        return sem;
    }
    public String getUsn(){
        return usn;
    }
    public void setSub1attend(int sub1attend) {
        this.sub1attend = sub1attend;
    }
    public void setSub2attend(int sub2attend) {
        this.sub2attend = sub2attend;
    }public void setSem(int sem) {
        this.sem = sem;
    }
    public void setUsn(String usn) {
        this.usn = usn;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public int getSub1attend(){
        return sub1attend;
    }
    public int getSub2attend(){
        return sub2attend;
    }


}