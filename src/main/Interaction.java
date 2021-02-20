package main;
public class Interaction {

    private Date start;
    private Date end;
    private int rating;
    private Customer customer;
    private Business business;
    public Interaction(Date s, Date e, int rate, Customer c, Business b){
        start = s;
        end = e;
        rating = rate;
        customer = c;
        business = b;
    }
    public int getRating(){
        return rating;
    }
}
