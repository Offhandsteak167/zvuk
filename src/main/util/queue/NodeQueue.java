package main.util.queue;

import main.util.logger.Event;

import static main.server.dummy.DummyDatabase.logger;

/**
 * Represents a node-based queue.
 *
 * @param <T> the generic parameter
 * @author Jake D
 **/
public class NodeQueue<T> implements Queue<T> {
    private int size;
    private Node<T> front;
    private Node<T> back;

    /**
     * Constructor for NodeQueue
     */
    public NodeQueue(){
        front = null;
        back = null;
        size = 0;
    }

    /**
     * Gets the queue's size
     *
     * @return the size of the queue
     */
    @Override
    public int size(){
        return size;
    }

    /**
     * enqueues an item into the queue
     *
     * @param value the item to enqueue
     */
    @Override
    public void enqueue(T value){
        Node<T> node = new Node<>(value);
        if(back == null && front == null){
            this.front = node;
        } else {
            assert this.back != null;
            this.back.setNext(node);
        }
        this.back = node;
        this.size++;
    }

    /**
     * Dequeues an item from the queue
     *
     * @return the dequeued item
     * @throws IndexOutOfBoundsException when queue is empty
     */
    @Override
    public T dequeue() throws IndexOutOfBoundsException{
        if (this.front == null){
            logger.addEvent(new Event("WARN","Nothing to dequeue in NodeQueue.java"));
            throw new IndexOutOfBoundsException("Nothing to dequeue.");
        }
        T temp_val = this.front.getValue();
        this.front = this.front.getNext();
        if (this.size == 1){
            this.back = null;
        }
        this.size--;
        return temp_val;
    }

    /**
     * Gets the ith item of the Queue, does not dequeue
     *
     * @param i the item's index to get
     * @return the item.
     */
    public Node<T> getPlace(int i){
        int z = 0;
        Node<T> thing = front;
        while (z < size){
            if (i == z){
                return thing;
            }
            if (thing.getNext() != null) {
                thing = thing.getNext();
                z++;
            } else {
                logger.addEvent(new Event("WARN","Out of bound exception in NodeQueue.java"));
                throw new IndexOutOfBoundsException();
            }
        }
        return null;
}

    /**
     * Override for toString
     *
     * @return the newly created string
     */
    @Override
    public String toString() {
        String toreturn = "main.util.queue.NodeQueue{" +
                "size=" + size;
                if(front != null) {
                    toreturn+=", items=" + front.toString();
                }
                toreturn+='}';
                return toreturn;
    }

}
