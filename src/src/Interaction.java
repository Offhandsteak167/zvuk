public class Interaction {
    class Date{
        private int year;
        private int month;
        private int day;
        private int hour;
        private int minute;
        private int second;
        public Date(int year, int month, int day, int hour, int minute, int second){
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
        @Override
        public String toString(){
            return this.month + "/" + this.day + "/" + this.year + " " + this.hour + ":" + this.minute + "." + this.second;
        }
    }
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
