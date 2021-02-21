package main.shared;

import java.util.Date;

public class Interaction {

    private final int rating;

    public Interaction(Date s, Date e, int rate, Customer c, Business b){
        rating = rate;
    }
    public int getRating(){
        return rating;
    }
}
