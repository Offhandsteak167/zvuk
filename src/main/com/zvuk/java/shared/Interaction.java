package main.com.zvuk.java.shared;

import java.util.Date;

public class Interaction {

    private final int rating;
    private Date e;

    public Interaction(Date s, int rate, Member c, Member b){
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
