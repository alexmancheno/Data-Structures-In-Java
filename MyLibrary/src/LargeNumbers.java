import Library.SinglyLinkedList;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created by Alex on 3/20/17.
 */
public class LargeNumbers {

    // nested Node class
    private static class Node {
        private int data;
        private Node next;

        public Node(int e) {
            data = e;
            next = null;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node n) {
            next = n;
        }

        public String toString() { return Integer.toString(data); }
    }
    // end of nested Node class

    // beginning of LargeNumbers class
    private Node head;
    private Node tail;

    public LargeNumbers() {
        this(0);
    }

    public LargeNumbers(String number) {
        if (number.length() == 0 || number == null) number = "0";
        while (number.length() >= 3) {
            Node n = new Node (Integer.parseInt(number.substring(number.length() - 3)));
            if (head == null) {
                head = n;
                tail = n;
            } else {
                tail.setNext(n);
                tail = n;
            }
            number = number.substring(0, number.length() - 3);
        }

        if (number.length() > 0) {
            Node n = new Node(Integer.parseInt(number));
            if (tail != head) {
                tail.next = n;
                tail = n;
            } else {
                head = n;
                tail = n;
            }
        }
    }

    public LargeNumbers(int number) {
        head = new Node(number % 1000);
        tail = head;
        number /= 1000;
        while (number != 0) {
            Node n = new Node(number % 1000);
            tail.setNext(n);
            tail = n;
            number /= 1000;
        }
    }

    public LargeNumbers add(LargeNumbers other) {
        LargeNumbers answer = new LargeNumbers();
        int sum = 0;
        int carry = 0;

        Node i = this.head;
        Node j = other.head;

        boolean firstNode = true;
        while (i != null || j != null) {
            System.out.println("inside the loop");
            if (i != null) sum += i.data;
            if (j != null) sum += j.data;

            sum += carry;
            carry = sum / 1000;
            Node n = new Node(sum % 1000);
            System.out.println("n.data: " + n.toString());

            if (firstNode) {
                answer.head = n;
                answer.tail = n;
                firstNode = false;
            } else {
                answer.tail.next = n;
                answer.tail = n;
            }

            if (i != null) i = i.next;
            if (j != null) j = j.next;

            sum = 0;
        }

        if (carry == 1) {
            Node n = new Node(carry);
            answer.tail.next = n;
            answer.tail = n;
        }

        return answer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        Node i = head;
        for (; i.getNext() != null; i = i.getNext()) {
            String num = ",";
            if (i.getData() < 10) num += "00";
            else if (i.getData() < 100) num += "0";
            num += i.toString();
            sb.insert(0, num);
        }

        sb.insert(0, i.toString());

        return sb.toString();
    }
}