/**
 * Created by Alex on 2/25/17.
 */

package Library;

public interface Stack <E> {

    int size ();

    boolean isEmpty();

    void push(E e);

    E top();

    E pop();
    
}
