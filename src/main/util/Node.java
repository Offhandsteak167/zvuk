package main.util;

import java.io.Serializable;

/**
 * Constructor for nodes.
 *
 * @param <T> the generic parameter
 * @author Jake Downie
 * @author jwd2488
 */
public class Node<T> implements Serializable {
    private T value;
    private Node<T> next;

    /**
     * Constructor for a node.
     *
     * @param value a generic value
     * @param next the next node
     */
    public Node(T value, Node<T> next){
        this.value = value;
        this.next = next;
    }

    /**
     * Constructor for a node.
     *
     * @param value the value for the node
     */
    public Node (T value) {
        this(value, null);
    }

    /**
     * Gets a node's value
     *
     * @return the node's value
     */
    public T getValue() {
        return value;
    }

    /**
     * @param next
     */
    public void setNext(Node<T> next){
        this.next = next;
    }

    /**
     * Gets the next node
     *
     * @return the next node
     */
    public Node<T> getNext(){
        return this.next;
    }

    /**
     * Sets the node's value
     *
     * @param value the value to set the node to
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * creates a string representation of the node
     *
     * @return the newly created string
     */
    @Override
    public String toString() {
        String toReturn =  "node.main.util.Node{" +
                "value=" + value;
                if(next != null) {
                    toReturn+=", next=" + next.toString();
                }else{
                    toReturn+=", next=null";
                }
                toReturn+= '}';
                return toReturn;
    }
}
