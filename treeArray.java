package Tree;

public class treeArray {
        int[] tree;
        int size;

        // Constructor to initialize the tree with a given size
        public treeArray(int size) {
            this.size = size;
            tree = new int[size];
        }

        // Function to set the value of a node at a given index
        public void setNodeValue(int index, int value) {
            if (index >= 0 && index < size) {
                tree[index] = value;
            } else {
                System.out.println("Index out of bounds");
            }
        }

        // Function to get the value of a node at a given index
        public int getNodeValue(int index) {
            if (index >= 0 && index < size) {
                return tree[index];
            } else {
                System.out.println("Index out of bounds");
                return -1; // return an invalid value if the index is out of bounds
            }
        }

        // Function to get the left child of a node at a given index
        public int getLeftChild(int index) {
            int leftIndex = 2 * index + 1;
            if (leftIndex < size) {
                return tree[leftIndex];
            } else {
                System.out.println("No left child");
                return -1;
            }
        }

        // Function to get the right child of a node at a given index
        public int getRightChild(int index) {
            int rightIndex = 2 * index + 2;
            if (rightIndex < size) {
                return tree[rightIndex];
            } else {
                System.out.println("No right child");
                return -1;
            }
        }

        // Function to get the parent of a node at a given index
        public int getParent(int index) {
            if (index == 0) {
                System.out.println("No parent for root");
                return -1;
            } else {
                int parentIndex = (index - 1) / 2;
                return tree[parentIndex];
            }
        }

        // Function to print the tree
        public void printTree() {
            for (int i = 0; i < size; i++) {
                System.out.print(tree[i] + " ");
            }
            System.out.println();
        }

        public static void main(String[] args) {
            treeArray bt = new treeArray(7);

            // Set values in the tree
            bt.setNodeValue(0, 1);  // Root
            bt.setNodeValue(1, 2);  // Left child of root
            bt.setNodeValue(2, 3);  // Right child of root
            bt.setNodeValue(3, 4);  // Left child of node at index 1
            bt.setNodeValue(4, 5);  // Right child of node at index 1
            bt.setNodeValue(5, 6);  // Left child of node at index 2
            bt.setNodeValue(6, 7);  // Right child of node at index 2

            // Print tree values
            bt.printTree();

            // Example of getting parent and children
            System.out.println("Left child of node 0: " + bt.getLeftChild(0));
            System.out.println("Right child of node 0: " + bt.getRightChild(0));
            System.out.println("Parent of node 4: " + bt.getParent(4));
        }
    }
