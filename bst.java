package Tree;

import java.util.*;

class bst {
    class treeNode {

        int value;
        treeNode left, right;

        treeNode(int value) {
            this.value = value;
            left = right = null;
        }
    }

    treeNode root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private treeNode insertRec(treeNode root, int value) {
        if (root == null) {
            root = new treeNode(value);
            return root;
        }
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    public treeNode deleteRec(treeNode root, int value) {
        if (root == null) {
            return root;
        } else if (value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);

        }
        return root;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    public void inOrderRec(treeNode root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.value + " ");
            inOrderRec(root.right);
        }
    }

    public int minValue(treeNode root) {
        int minValue = root.value;
        while (root.left != null) {
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        bst tree = new bst();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Tree: ");
        tree.inOrder();

        System.out.println("Deleting 50: ");
        tree.delete(20);

        System.out.println("Tree: ");
        tree.inOrder();


    }
}

