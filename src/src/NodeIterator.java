import java.util.Iterator;

public class NodeIterator<E> implements Iterator<E> {

    Node<E> node;

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public E next() {
        E element = node.getValue();
        node = node.getNext();
        return element;
    }
}
