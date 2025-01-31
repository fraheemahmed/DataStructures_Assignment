package LinkedList;

class SinglyLL {
    class Node {
        int data;
        Node next;

        Node (int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head;

    public void Print(){
        Node current = head;
        while (current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("Null");
    }

    public void addLast(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void remove(int data){
        if (head == null){
            return;
        }
        if (head.data == data){
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data){
            current = current.next;
        }
        if (current.next != null){
            current.next = current.next.next;
        }
    }
    public boolean search(int data){
        Node current = head;
        while (current != null){
            if (current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLL list = new SinglyLL();

        list.addLast(5);
        list.addLast(4);
        list.addLast(7);
        list.addLast(2);
        list.addFirst(69);
        list.remove(4);

        list.Print();
        System.out.println("Present: " + list.search(7  ));


    }





























































}
