/**
 * Created by Alex on 2/20/17.
 */

public class main {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        System.out.println("Hello!");

        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();

        list1.addFirst("e");
        list1.addFirst("gg");
        list1.addFirst("fff");
        list1.addFirst("hhhh");

        list1.addLast("I-am-last");

        System.out.println(list1);

        list1.removeFirst();

        System.out.println(list1);

        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();

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
        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime));
    }
}
