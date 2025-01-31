package LinkedList;

public class DoublyLL {
    class Node{
        Node next;
        Node prev;
        int data;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    Node head;
    Node tail;

    public void printList() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("Null");
    }

    public void addAtEnd(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void addStart(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void remove(int data){
        if (head == null){
            return;
        }
        if (head.data == data){
            head = head.next;
            if (head != null){
                head.prev = null;
            }
            else {
                tail.next = null;
            }
        }
        Node current = head;
        while (current.next != null && current.next.data != data){
            current = current.next;
        }
        if (current != null){

        }
    }

    public void printReverse(){
        Node current = tail;
        while (current != null){
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("Null");
    }


    public static void main(String[] args) {
        DoublyLL Dlist = new DoublyLL();

        Dlist.addAtEnd(5);
        Dlist.addAtEnd(7);
        Dlist.addAtEnd(9);
        Dlist.addAtEnd(14);
        Dlist.addAtEnd(15);
        Dlist.printList();
        Dlist.printReverse();

    }



















}
