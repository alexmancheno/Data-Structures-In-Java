/**
 * Created by Alex on 2/20/17.
 */

package Library;

public class CircularlyLinkedList<E> {

    // ----Nested Node class----
    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            data = e;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

        public String toString() { return data.toString(); }
    }
    // ----End of nested Node class----

    // ----CircularlyLinkedList class----
    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {}

    //access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;
        return tail.getNext().getData();
    }

    public E last() {
        if (isEmpty())
            return null;
        return tail.getData();
    }

    //update methods
    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<E>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<E>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext(); //tail becomes head
    }

//    public void removeFirst() {
//        if (size > 1) {
//            tail.next = tail.next.getNext();
//            size--;
//        } else if (size == 1) {
//            tail.next = null;
//            size--;
//        }
//    }

    public E removeFirst() {
        if (isEmpty()) return null;
        Node<E> head = tail.getNext();

        if (head == tail) {
            tail.next = null;
            tail = null;
        } else {
            tail.next = tail.next.next;
        }
        size--;
        return head.getData();
    }

    //etc. methods
    public String toString() {
        StringBuilder results = new StringBuilder("");

        if (tail != null) {
            Node<E> iterator = tail.getNext();
            for (int i = 0; i < size; i++) {
                results.append(iterator.getData());
                results.append(" ");
                iterator = iterator.next;
            }
        }

        return results.toString();
    }

    public int countList() {
        int count = 0;
        if (tail != null) {

            Node<E> iterator = tail.getNext();

            do {
                count++;
                iterator = iterator.getNext();
            } while (iterator != tail.getNext());
        }

        return count;
    }

    public void makeEmpty() {
        tail.next = null;
        tail = null;
        size = 0;
    }

    public E getTail() {
        return tail.data;
    }
}
