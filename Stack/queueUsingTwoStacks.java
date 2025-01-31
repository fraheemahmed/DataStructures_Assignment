    package Stack;

    import java.util.Stack;

    public class queueUsingTwoStacks {
        static Stack<Node> stack1 = new Stack<>();
        static Stack<Node> stack2 = new Stack<>();

        public static class Node{
            int data;

            Node(int data){
                this.data = data;
            }
        }
        static class queue {

            public static void enqueue(int data) {
                Node newNode = new Node(data);

                stack1.push(newNode);
            }

            public static int dequeue(){
                    if (stack1.isEmpty() && stack2.isEmpty()){
                        return -1;
                    }
                    if(stack2.isEmpty()) {
                        while (!stack1.isEmpty()) {
                            stack2.push(stack1.pop());
                        }
                    }
                    int temp = stack2.pop().data;
                    return temp;
            }
        }

        public static void main(String[] args) {
            queue q = new queue();
            q.enqueue(1);
            q.enqueue(2);
            q.enqueue(3);

            System.out.println("Dequeued: " + q.dequeue());

            q.enqueue(4);
            System.out.println("Dequeued: " + q.dequeue());




        }
    }
