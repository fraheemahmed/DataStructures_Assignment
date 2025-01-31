package Tree;

    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    class BinaryTree {
        Node root;

        // Function to calculate the height of a given node
        int getHeight(Node node) {
            if (node == null)
                return -1; // Base case: height of an empty tree is -1

            int leftHeight = getHeight(node.left);
            int rightHeight = getHeight(node.right);

            return Math.max(leftHeight, rightHeight) + 1;
        }

        public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();

            // Constructing the binary tree
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.right = new Node(6);
            tree.root.left.right.left = new Node(7);

            Node targetNode = tree.root.left; // Node with value 2

            int height = tree.getHeight(targetNode);
            System.out.println("Height of node " + targetNode.data + " is: " + height);
        }
    }


