package Library;

/**
 * Created by alexmancheno on 5/9/17.
 */
public class AVLTree<E> {

    private AVLNode<E> root;

    private static class AVLNode<E> {

        private E element;
        private int height;
        private AVLNode<E> left;
        private AVLNode<E> right;

        private AVLNode(E t) {
            this.element = t;
            height = 1;
        }

        public String toString() {
            return element.toString();
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public AVLTree getLeft() {
        if (root == null) return null;
        else {
            AVLTree t = new AVLTree();
            t.root = root.left;
            return t;
        }
    }

    public AVLTree getRight() {
        if (root == null) return null;
        else {
            AVLTree t = new AVLTree();
            t.root = root.right;
            return t;
        }
    }

    public E getRootObj() {
        if (root == null) return null;
        else return root.element;
    }

    public void insert(E value) {
        root = insert(root, value);
    }

    private AVLNode<E> insert(AVLNode<E> n, E v) {
        //System.out.println("Attempting to insert " + v);
        if (n == null) {
            System.out.println("Inserting " + v);
            n = new AVLNode<E>(v);
            return n;
        } else {
            int k = ((Comparable) n.element).compareTo(v);

            if (k <= 0) {
                System.out.println("Going right with " + v);
                n.right = insert(n.right, v);
            } else {
                System.out.println("Going left with " + v);
                n.left = insert(n.left, v);
            }
            n.height = Math.max(height(n.left), height(n.right)) + 1;
            System.out.println("n.height: " + n.height);

            int heightDiff = heightDiff(n);
            System.out.println("heightDiff: " + heightDiff);

            if (heightDiff < -1) {
                if (heightDiff(n.right) > 0) {
                    System.out.println("First, right rotate at n.right - n is: " + n.toString());
                    n.right = rightRotate(n.right);
                    System.out.println("Then, left rotate at n - n is: " + n.toString());
                    return leftRotate(n);
                } else {
                    System.out.println("Only left rotate at n: " + n.toString());
                    return leftRotate(n);
                }
            } else if (heightDiff > 1) {
                if (heightDiff(n.left) < 0) {
                    System.out.println("First, left rotate at n.left - n is: " + n.toString());
                    n.left = leftRotate(n.left);
                    System.out.println("Then, right rotate at n - n is: " + n.toString());
                    return rightRotate(n);
                } else {
                    System.out.println("Only right rotate at n " + n.toString());
                    return rightRotate(n);
                }
            }

        }
        return n;
    }

    private AVLNode<E> leftRotate(AVLNode<E> n) {
        AVLNode<E> r = n.right;
        n.right = r.left;
        r.left = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        return r;
    }

    private AVLNode<E> rightRotate(AVLNode<E> n) {
        AVLNode<E> r = n.left;
        n.left = r.right;
        r.right = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        return r;
    }

    private int heightDiff(AVLNode<E> a) {
        if (a == null) {
            return 0;
        }
        return height(a.left) - height(a.right);
    }

    private int height(AVLNode<E> a) {
        if (a == null) {
            return 0;
        }
        return a.height;
    }

    public static void inOrder(AVLTree t) {
        if (!t.isEmpty()) {
            inOrder((t.getLeft()));
            System.out.print(t.getRootObj() + " ");
            inOrder(t.getRight());
        }
    }
}

