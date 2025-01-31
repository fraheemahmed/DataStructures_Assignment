package Queue;

import java.util.*;
class QueueLL{

        public static void reverseQueue(Queue<Integer> queue){
            if (queue.isEmpty()){
                return;
            }
            int front = queue.remove();
            reverseQueue(queue);
            queue.add(front);
        }

        public static void sortQueue(Queue<Integer> queue){

            if (queue.isEmpty()){
                return;
            }
            int size = queue.size();
            for (int i = 0; i<size; i++){

            }



        }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(6);
        queue.add(8);
        queue.add(1);
        queue.add(3);

        reverseQueue(queue);
        System.out.println("Reversed Queue " + queue);

        queue.clear();
        queue.add(6);
        queue.add(8);
        queue.add(1);
        queue.add(3);

        sortQueue(queue);
        System.out.println("Sorted Queue " + queue);

    }

}
