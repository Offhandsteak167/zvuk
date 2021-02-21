package main.shared;

import java.util.Date;

public class Interaction {

    private final int rating;
    private Date e;

    public Interaction(Date s, int rate, Customer c, Business b){
        this.e = null;
        rating = rate;
    }

    public void setE(Date e) {
        this.e = e;
    }

    public int getRating(){
        return rating;
    }
}
