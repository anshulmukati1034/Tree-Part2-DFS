import java.util.ArrayList;
import java.util.List;
public class Q6_BinaryTreePaths {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static List<String> result = new ArrayList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return result;
        dfs(root, "");
        return result;
    }

    private static void dfs(TreeNode root, String path) {
        if (root == null) return;

        path += root.val;

        // If leaf node
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        path += "->";

        dfs(root.left, path);
        dfs(root.right, path);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(5);

        List<String> paths = binaryTreePaths(root);
        System.out.println(paths); // Output: ["1->2->5", "1->3"]
    }
}
