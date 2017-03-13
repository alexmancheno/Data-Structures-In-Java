/**
 * Created by Alex on 3/10/17.
 */
public class ArrayStack<E> implements Stack<E> {

    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;

    public ArrayStack() {
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return t + 1;
    }

    public boolean isEmpty() {
        return t == -1;
    }

    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full.");
        data[++t] = e;
    }

    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }

    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

    public void reverse() {
        E[] newData = (E[]) new Object[data.length];
        for (int i = 0; data[i] != null; i++)
            newData[i] = data[i];
        
    }

    public int count() {
        int answer = 0;
        for (int i = 0; data[i] != null; i++)
            answer++;

        return answer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; data[i] != null; i++)
            sb.append(data[i].toString() + " ");

        return sb.toString();
    }
}
