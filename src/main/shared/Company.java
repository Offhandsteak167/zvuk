package main.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 */
public class Company implements Serializable {
    private static int nextId = 0;
    public final int id;
    private String name;
    private final MeetingQueue queue;
    private ArrayList<Interaction> interactions;

    /**
     * @param e
     */
    public void addInteraction(Interaction e) {
        interactions.add(e);
    }

    final ArrayList<Business> employees = new ArrayList<>();

    /**
     * @param name
     */
    public Company(String name) {
        this.name = name;
        this.id = nextId++;
        this.queue = new MeetingQueue();
    }

    /**
     *
     */
    public Company(){
        name = "";
        this.queue = new MeetingQueue();
        id = nextId++;
        queue.addMeetingToQueue(new Meeting(new Customer("Jake","Downie","jakedownie8@gmail.com","123","78 Battin","Plan 1")));
        queue.addMeetingToQueue(new Meeting(new Customer("Jake","Downie","jakedownie8@gmail.com","123","78 Battin","Plan 1")));

    }
    final ArrayList<Interaction> currentInteractions = new ArrayList<>();
    final ArrayList<Interaction> interactionHistory = new ArrayList<>();

    public int getId(){ return this.id; }
    public ArrayList<Business> getEmployees() { return this.employees; }

    public void addEmployee (Business newEmployee){ this.employees.add(newEmployee);}
    public void removeEmployee (Business employee) {this.employees.remove(employee);}

    public void setName(String newName) { this.name = newName; }
    public String getName() { return this.name; }

    void addOrder(Interaction order) {currentInteractions.add(order);}

    void closeOrder(Interaction order) {
        currentInteractions.remove(order);
        interactionHistory.add(order);
        }

    public MeetingQueue getMeetingQueue(){
        return queue;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", queue=" + queue.toString() +
                ", interactions=" + interactions +
                ", employees=" + employees +
                ", currentInteractions=" + currentInteractions +
                ", interactionHistory=" + interactionHistory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
