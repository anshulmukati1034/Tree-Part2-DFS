public class Q7_BalancedBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }   

    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }   

    public static int checkBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }   

        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is not balanced
        }   

        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is not balanced
        }   

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current node is not balanced
        }   

        return Math.max(leftHeight, rightHeight) + 1; // Return height
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        boolean balanced = isBalanced(root);
        System.out.println(balanced); // Output: false
    }   
}
