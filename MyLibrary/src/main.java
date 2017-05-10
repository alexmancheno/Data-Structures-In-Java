/**
 * Created by Alex on 2/20/17.
 */

import Library.*;
import Library.BinaryTree;
import com.sun.source.tree.*;

public class main {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("Hello!");
        System.out.println("----------------------------");
        System.out.println("SinglyLinkedList tests: ");

        SinglyLinkedList<String> list1 = new SinglyLinkedList<String>();

        list1.addFirst("e");
        list1.addFirst("gg");
        list1.addFirst("fff");
        list1.addFirst("hhhh");

        list1.addLast("I-am-last");

        System.out.println(list1);

        list1.removeFirst();

        System.out.println(list1);

        SinglyLinkedList<String> list2 = new SinglyLinkedList<String>();

        for (int i = 0; i < 32000; i++) {
            list2.addLast(Integer.toString(i));
        }

        for (int i = 0; i < 32000; i++) {
            list2.addFirst(Integer.toString(i));
        }

        //System.out.println(list2);
        System.out.println("countList(): " + list2.countList());
        System.out.println("list2.size(): " + list2.size());


        for (int i = 0; i < 10000; i++) {
            list2.removeFirst();
        }

        System.out.println("countList(): " + list2.countList());
        System.out.println("list2.size(): " + list2.size());

        System.out.println("----------------------------");
        System.out.println("CircularlyLinkedList tests: ");
        CircularlyLinkedList<String> clist1 = new CircularlyLinkedList<String>();

        for (int i = 0; i <= 10; i++) {
            clist1.addFirst(Integer.toString(i));
        }

        for (int i = 10; i >= 0; i--) {
            clist1.addLast(Integer.toString(i));
        }

        System.out.println(clist1.size());
        clist1.removeFirst();
        clist1.removeFirst();
        clist1.removeFirst();
        System.out.println(clist1);
        System.out.println(clist1.size());
        System.out.println(clist1.countList());

        clist1.makeEmpty();
        System.out.println(clist1);
        //System.out.println(clist1.getTail());

        System.out.println("----------------------------");
        System.out.println("DoublyLinkedList tests:");

        DoublyLinkedList<String> dlist1 = new DoublyLinkedList<String>();
        for (int i = 0; i < 10; i++) {
            dlist1.addLast(Integer.toString(i));
        }

        System.out.println(dlist1);
        System.out.println(".size(): " + dlist1.size() + " ----- .countList(): " + dlist1.countList());

        dlist1.removeFirst();
        dlist1.removeLast();

        System.out.println(dlist1);
        System.out.println(".size(): " + dlist1.size() + " ----- .countList(): " + dlist1.countList());

        final long endTime = System.currentTimeMillis();

        System.out.println("----------------------------");
        System.out.println("ArrayStack tests:");
        ArrayStack<Integer> arrayStack1 = new ArrayStack<Integer>();

        for (int i = 0; i < 50; i++)
            arrayStack1.push(i);

        System.out.println("arrayStack1.size(): " + arrayStack1.size() + ", arrayStack1.count(): " + arrayStack1.count());
        System.out.println("arrayStack1.toString(): " + arrayStack1.toString());

        for (int i = 0; i < 21; i++)
            arrayStack1.pop();

        System.out.println("arrayStack1.size(): " + arrayStack1.size() + ", arrayStack1.count(): " + arrayStack1.count());
        System.out.println("arrayStack1.toString(): " + arrayStack1.toString());

        arrayStack1.reverse();
        System.out.println("arrayStack1.toString(): " + arrayStack1.toString());

        System.out.println("----------------------------");
        System.out.println("ArrayQueue tests:");

        ArrayQueue<Integer> arrayQueue1 = new ArrayQueue<Integer>(1000);

        for (int i = 0; i < 50; i++)
            arrayQueue1.enqueue(i);

        System.out.println("arrayQueue1.toString(): " + arrayQueue1.toString());

        for (int i = 0; i < 20; i++)
            arrayQueue1.dequeue();
        System.out.println("arrayQueue1.toString(): " + arrayQueue1.toString());


        System.out.println("arrayQueue1.count(): " + arrayQueue1.count() + ", arrayQueue1.size(): " + arrayQueue1.size());

        System.out.println("----------------------------");
        System.out.println("LargeNumber tests:");

        LargeNumbers largeNumber1 = new LargeNumbers("2139128309128302374982374824");
        LargeNumbers largeNumber2 = new LargeNumbers("984738127648792136498");
        LargeNumbers largeNumber3 = (largeNumber1.add(largeNumber2));
        LargeNumbers largeNumber4 = new LargeNumbers("1234568728947283947982347982374982374987");

        System.out.println("largeNumber1.toString(): " + largeNumber1.toString());
        System.out.println("largeNumber4.toString(): " + largeNumber4.toString());

        System.out.println(largeNumber3);

        System.out.println("----------------------------");
        System.out.println("BinaryTree tests:");
       int[] array1 = {1, 7, 3, 4, 5};
       int[] array2 = {0, 4, 1, 2, 3} ;

        BinaryTree t = new BinaryTree();
        BinaryTree tt = new BinaryTree();
        try {
            for (int i = 0; i < array1.length; i++) {
                t = BinaryTree.insert(t, array1[i]);
                tt = BinaryTree.insert(tt, array2[i]);
            }
        } catch (Exception e) {
            System.out.println("error inserting into array1");
        }

        System.out.println("Binary trees are structurally equal (static version): " + BinaryTree.compareTrees(t, tt));
        System.out.println("Binary trees are structurally equal (instance version): " + t.compareTrees(tt));

        System.out.println("----------------------------");
        System.out.println("AVLTree tests:");

        int[] array3 = {20, 1, 7, 3, 4, 5, 8, 10, 32, 14, 22, 35, 6, 50, 100, 32, 45};

        AVLTree<Integer> avl = new AVLTree<Integer>();
        for (int i = 0; i < array3.length; i++) {
            avl.insert(array3[i]);
        }

        System.out.println("avl.inOrder(): ");
        AVLTree.inOrder(avl);
        System.out.println("Total execution time: " + (endTime - startTime) * 0.001 + " seconds");


    }
}
