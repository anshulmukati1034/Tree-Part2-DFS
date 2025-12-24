public class Q11_MinimumDepthofBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }   

     public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        // If leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // If one child is null
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }

        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        // Both children exist
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = minDepth(root);
        System.out.println(depth); // Output: 2
    }
}
