/**
 * Created by Alex on 2/19/17.
 */


public class SinglyLinkedList<E> {

    // ----nested Node class----
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

    // ----SinglyLinkedList class----
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    //access methods
    public SinglyLinkedList() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (size == 0) return null;

        return head.getData();
    }

    //update methods
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;

        size++;
    }

    public void addLast(E e) {
        Node<E> newLast = new Node<>(e, null);
        if (size == 0)
            head = newLast;
        else
            tail.next = newLast;

        tail = newLast;
        size++;
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            E temp = head.getData();
            head = head.getNext();
            size--;

            if (size == 0) {
                tail = null;
            }

            return temp;
        }
    }

    public void makeEmpty() {
        head = null;
        size = 0;
    }


    //etc methods
    public String toString() {
        StringBuilder results = new StringBuilder("");
        Node<E> iterator = head;

        while (iterator != null) {
            results.append(iterator.getData());
            results.append(" ");
            iterator = iterator.next;
        }

        return results.toString();
    }

    public int countList() {
        Node<E> iterator = head;
        int count = 0;

        while (iterator != null) {
            count++;
            iterator = iterator.getNext();
        }

        return count;
    }

}