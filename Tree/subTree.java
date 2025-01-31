package Tree;
    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public class subTree {

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) return false;  // If main tree is empty, return false
            if (isSameTree(root, subRoot)) return true; // If trees match, return true

            // Recursively check left and right subtree
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == null && t == null) return true;  // Both trees are null
            if (s == null || t == null) return false; // One tree is null, the other isn't
            if (s.val != t.val) return false;         // Mismatched values

            // Recursively check left and right subtrees
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }

        public static void main(String[] args) {
            subTree solution = new subTree();

            // Construct main tree
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(4);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(2);

            // Construct subtree
            TreeNode subRoot = new TreeNode(4);
            subRoot.left = new TreeNode(1);
            subRoot.right = new TreeNode(2);

            // Check if subRoot is a subtree of root
            System.out.println(solution.isSubtree(root, subRoot)); // Output: true
        }
    }

