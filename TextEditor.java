package LinkedList;

import java.util.Scanner;

class TextEditor {

    // Node class
    private static class Node {
        String data;
        Node next;
        Node prev;

        // Constructor
        Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head; // Head of the list
    private Node tail; // Tail of the list

    // Add a new line at the end of the list
    public void addLine(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insert a line before a specific line number
    public void insertLineBefore(int lineNumber, String data) {
        if (head == null) {
            System.out.println("The text is empty. Cannot insert at line " + lineNumber);
            return;
        }

        Node current = head;
        int currentIndex = 1;

        // Traverse to find the target line
        while (current != null && currentIndex < lineNumber) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            System.out.println("Line number " + lineNumber + " is out of range.");
            return;
        }

        Node newNode = new Node(data);

        // If the target line is the head
        if (current == head) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
    }

    // Delete a line by line number
    public void deleteLine(int lineNumber) {
        if (head == null) {
            System.out.println("The text is empty. Cannot delete line " + lineNumber);
            return;
        }

        Node current = head;
        int currentIndex = 1;

        // Traverse to find the target line
        while (current != null && currentIndex < lineNumber) {
            current = current.next;
            currentIndex++;
        }

        if (current == null) {
            System.out.println("Line number " + lineNumber + " is out of range.");
            return;
        }

        // If the target line is the head
        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null;
            }
        } else if (current == tail) { // If the target line is the tail
            tail = current.prev;
            tail.next = null;
        } else { // Middle of the list
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Display the text
    public void displayText() {
        if (head == null) {
            System.out.println("The text is empty.");
            return;
        }

        Node current = head;
        int lineNumber = 1;

        System.out.println("Text content:");
        while (current != null) {
            System.out.println(lineNumber + ": " + current.data);
            current = current.next;
            lineNumber++;
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nText Editor Options:");
            System.out.println("1. Add a line");
            System.out.println("2. Insert a line before a specific line");
            System.out.println("3. Delete a line");
            System.out.println("4. Display text");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the line to add: ");
                    String line = scanner.nextLine();
                    editor.addLine(line);
                    break;

                case 2:
                    System.out.print("Enter the line number to insert before: ");
                    int lineNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter the line to insert: ");
                    String newLine = scanner.nextLine();
                    editor.insertLineBefore(lineNumber, newLine);
                    break;

                case 3:
                    System.out.print("Enter the line number to delete: ");
                    int deleteLineNumber = scanner.nextInt();
                    editor.deleteLine(deleteLineNumber);
                    break;

                case 4:
                    editor.displayText();
                    break;

                case 5:
                    System.out.println("Exiting editor.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
