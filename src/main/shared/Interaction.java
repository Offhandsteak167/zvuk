package main.shared;

import java.util.Date;

public class Interaction {

    private final int rating;
    private Date e;
    private Date s;
    private Customer c;
    private Business b;

    public Interaction(Date s, int rate, Customer c, Business b){
        this.b = b;
        this.e = null;
        this.s = s;
        this.c = c;
        rating = rate;
    }

    public void setE(Date e) {
        this.e = e;
    }

    public int getRating(){
        return rating;
    }
}
