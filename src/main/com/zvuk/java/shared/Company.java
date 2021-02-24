package main.com.zvuk.java.shared;

import org.zoodb.api.impl.ZooPC;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 */
public class Company extends ZooPC implements Serializable {
    private static int nextId = 0;
    public final int id;
    private String name;
    private final MeetingQueue queue;
    private ArrayList<Interaction> interactions;
    private ArrayList<Channel> channels;

    /**
     * @param e
     */
    public void addInteraction(Interaction e) {
        interactions.add(e);
    }

    final ArrayList<Member> members = new ArrayList<>();

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
    public Company(int id){
        name = "Brick";
        this.id = id;
        this.channels = new ArrayList<>();
        this.queue = new MeetingQueue();
    }
    final ArrayList<Interaction> currentInteractions = new ArrayList<>();
    final ArrayList<Interaction> interactionHistory = new ArrayList<>();

    public int getId(){ return this.id; }
    public ArrayList<Member> getMembers() { return this.members; }

    public void addChannel(Channel channel){ this.channels.add(channel);}

    public void addMember (Member newEmployee){ this.members.add(newEmployee);}
    public void removeMember (Member employee) {this.members.remove(employee);}

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
                ", employees=" + members +
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
