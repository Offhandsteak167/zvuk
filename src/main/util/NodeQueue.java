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
        Node<T> node = new Node<T>(value);
        if(back == null && front == null){
            front = node;
            back = node;
        } else {
            back.setNext(node);
            back = node;
        }
        size++;
    }

    @Override
    public T dequeue() throws IndexOutOfBoundsException{
        if (front == null){
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
