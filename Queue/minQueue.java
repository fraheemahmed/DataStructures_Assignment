package Queue;
import java.util.*;

public class minQueue {
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class Queue{
        static Node head;
        static Node tail;

        public static int Min() {
            int min = head.data;
            Node current = head;

            while (current != null) {
                if(current.data < min){
                    min = current.data;
                }
                current = current.next;
            }
            return min;
        }

        public static void add(int data){
            Node newNode = new Node(data);
            if (tail == null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(8);
        q.add(54);
        q.add(15);
        q.add(2);
        q.add(78);

        int minNum =  q.Min();
        System.out.println("Min Element is: " + minNum);






    }
}
