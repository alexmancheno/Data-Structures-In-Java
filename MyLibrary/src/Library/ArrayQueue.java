/**
 * Created by Alex on 3/14/17.
 */

package Library;

public class ArrayQueue<E> implements Queue<E> {

    private static final int CAPACITY = 1000;
    private E[] data;
    private int front = 0;
    private int size = 0;

    public ArrayQueue() {
        this(CAPACITY);
    }

    public ArrayQueue(int c) {
        data = (E[]) new Object[c];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) throws IllegalStateException {
        if (size == data.length) throw new IllegalStateException("Queue is full.");

        data[(size + front) % data.length] = e;
        size++;
    }

    public E first() {
        if (isEmpty()) return null;
        return data[front];
    }

    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return answer;
    }

    public int count() {
        int answer = 0;
        for (int i = front; data[i] != null; i++, answer++);

        return answer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = front; data[i] != null; i++)
            sb.append(data[i].toString() + " ");

        return sb.toString();
    }
}
