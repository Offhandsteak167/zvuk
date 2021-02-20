import java.util.ArrayList;

public class Company {
    private static int nextId = 1;
    public final int id;
    private String name;
    


    ArrayList<Business> employees = new ArrayList<>();

    public Company(String name) {
        this.name = name;
        this.id = nextId++;
    }

    public int getId(){ return this.id; }
    public ArrayList<Business> getEmployees() { return this.employees; }

    public void addEmployee (Business newEmployee){ this.employees.add(newEmployee);}
    public void removeEmployee (Business employee) {this.employees.remove(employee);}

    public void setName(String newName) { this.name = newName; }
    public String getName() { return this.name; }

}
