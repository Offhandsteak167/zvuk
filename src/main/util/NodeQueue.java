package main.util;

import static main.dummy.DummyDatabase.logger;

public class NodeQueue<T> implements Queue<T> {
    private int size;
    private Node<T> front;
    private Node<T> back;

    public NodeQueue(){
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public int size(){
        return size;
    }

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

    @Override
    public String toString() {
        String toreturn = "main.util.NodeQueue{" +
                "size=" + size;
                if(front != null) {
                    toreturn+=", items=" + front.toString();
                }
                toreturn+='}';
                return toreturn;
    }

}
