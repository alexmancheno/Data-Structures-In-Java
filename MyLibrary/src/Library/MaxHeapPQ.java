package Library;

/**
 * Created by alexmancheno on 5/14/17.
 */
public class MaxHeapPQ<Key extends Comparable<Key>> {

    private static final int CAPACITY = 1000;
    private Key[] heap;
    int size = 0;

    public MaxHeapPQ() {
        this(CAPACITY);
    }

    public MaxHeapPQ(int capacity) {
        heap = (Key[]) new Comparable[capacity + 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(Key v) {
        heap[++size] = v;
        System.out.println(String.format("%d is swimming.", v));
        swim(size);
    }

    public Key deleteMax() {
        Key max = heap[1];
        swap(1, size--);
        heap[size + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            System.out.println("Swim swim");
            swap(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= size) {
            int j = k * 2;
            if (j < size && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        Key t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= size; i++)
            sb.append(heap[i] + " ");
        return sb.toString();
    }

}
