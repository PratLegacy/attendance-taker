package com.example.arpitha.att_4th_proto;

/**
 * Created by Arpitha on 24/04/2016.
 */
public class Sem {
    private String sem, section;

    public Sem() {

    }

    public Sem(String sem, String section) {
        this.sem = sem;
        this.section = section;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
