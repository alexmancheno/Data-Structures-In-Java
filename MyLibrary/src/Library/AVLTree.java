package Library;

/**
 * Created by alexmancheno on 5/9/17.
 */
public class AVLTree<E> {

    private AVLNode<E> root;

    private static class AVLNode<E> {

        private E t;
        private int height;
        private AVLNode<E> left;
        private AVLNode<E> right;

        private AVLNode(E t) {
            this.t = t;
            height = 1;
        }

        public String toString() {
            return t.toString();
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
        else return root.t;
    }

    public void insert(E value) {
        root = insert(root, value);
    }

    private AVLNode<E> insert(AVLNode<E> n, E v) {
        if (n == null) {
            n = new AVLNode<E>(v);
            return n;
        } else {
            int k = ((Comparable) n.t).compareTo(v);
            if (k > 0) {
                n.left = insert(n.left, v);
            } else {
                n.right = insert(n.right, v);
            }
            n.height = Math.max(height(n.left), height(n.right)) + 1;
            int heightDiff = heightDiff(n);
            if (heightDiff < -1) {
                if (heightDiff(n.right) > 0) {
                    n.right = rightRotate(n.right);
                    return leftRotate(n);
                } else {
                    return leftRotate(n);
                }
            } else if (heightDiff > 1) {
                if (heightDiff(n.left) < 0) {
                    n.left = leftRotate(n.left);
                    return rightRotate(n);
                } else {
                    return rightRotate(n);
                }
            } else;

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

