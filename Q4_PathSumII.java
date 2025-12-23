import java.util.ArrayList;
import java.util.List;

public class Q4_PathSumII {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }   

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }

    private static void dfs(TreeNode root, int targetSum, List<Integer> path) {
        if (root == null) return;

        path.add(root.val);
        targetSum -= root.val;

        // Check leaf node
        if (root.left == null && root.right == null && targetSum == 0) {
            result.add(new ArrayList<>(path));
        }

        dfs(root.left, targetSum, path);
        dfs(root.right, targetSum, path);

        // Backtracking
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> paths = pathSum(root, targetSum);
        System.out.println(paths); // Output: [[5, 4, 11, 2], [5, 8, 4, 5]]
    }   
}
