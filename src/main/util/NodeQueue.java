package main.util;

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
            front = node;
        } else {
            assert back != null;
            back.setNext(node);
        }
        back = node;
        size++;
    }

    @Override
    public T dequeue() throws IndexOutOfBoundsException{
        if (front == null){
            ServerSetup.logger.addEvent(new Event("WARN","Nothing to dequeue in NodeQueue.java"));
            throw new IndexOutOfBoundsException("Nothing to dequeue.");
        }
        T temp_val = front.getValue();
        front = front.getNext();
        if (size == 1){
            back = null;
        }
        size--;
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
                ServerSetup.logger.addEvent(new Event("WARN","Out of bound exception in NodeQueue.java"));
                throw new IndexOutOfBoundsException();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "main.util.NodeQueue{" +
                "size=" + size +
                ", items=" + front.toString() +
                '}';
    }

}
