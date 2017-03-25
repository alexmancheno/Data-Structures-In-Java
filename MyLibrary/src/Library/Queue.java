/**
 * Created by Alex on 3/14/17.
 */

package Library;

public interface Queue<E> {

        int size();

        boolean isEmpty();

        void enqueue(E e) throws IllegalStateException;

        E dequeue();

}
