/**
 * Created by Alex on 2/25/17.
 */

package Library;

public class DoublyLinkedList <E> {

    // ----Nested Node class----
    private static class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;


        public Node(E e, Node<E> p, Node<E> n) {
            data = e;
            prev = p;
            next = n;
        }

        public E getData() {
            return data;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
    // ----End of nested Node class----

    // ----DoublyLinkedList class----
    private Node<E> header; //header sentinel
    private Node<E> trailer; //trailer sentinel
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null); //create header
        trailer = new Node<>(null, header, null); //create trailer with header preceding it
        header.next = trailer; //now make header follow trailer
    }

    //access methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        return header.getNext().getData();
    }

    public E last() {
        return trailer.getPrev().getData();
    }

    //public update methods
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e) {
        addBetween (e, trailer.getPrev(), trailer);
    }

    public E removeFirst() {
        if (size == 0) return null;
        return remove(header.getNext());
    }

    public E removeLast() {
        if (size == 0) return null;
        return remove(trailer.getPrev());
    }

    //private update methods
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.next = newest;
        successor.prev = newest;
        size++;
    }

    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.next = successor;
        successor.prev = predecessor;
        size--;
        return node.getData();
    }

    //etc methods

    public String toString() {
        StringBuilder results = new StringBuilder("");

        if (size > 0) {
            Node<E> iterator = header.getNext();
            while (iterator.next != null) {
                if (iterator.data != null) {
                    results.append(iterator.data.toString());
                    results.append(" ");
                }
                iterator = iterator.next;
            }
        }

        return results.toString();
    }

    public int countList() {
        int count = 0;
        Node<E> iterator = header.getNext();
        while (iterator.getNext() != null) {
            count++;
            iterator = iterator.next;
        }

        return count;
    }
}