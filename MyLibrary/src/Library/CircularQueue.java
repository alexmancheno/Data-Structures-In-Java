/**
 * Created by Alex on 3/18/17.
 */

package Library;

public interface CircularQueue<E> extends Queue<E> {

    /**
     * Rotates the front of element of the queue to the back of the queue.
     * This does nothing if the queue is empty.
     */

    void rotate();
}
