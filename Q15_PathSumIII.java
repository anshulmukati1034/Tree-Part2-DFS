import java.util.HashMap;
import java.util.Map;

public class Q15_PathSumIII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
   
    public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1); // base case
        return dfs(root, 0, targetSum, map);
    }

    private static int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> map) {
        if (node == null) return 0;

        currSum += node.val;

        int count = map.getOrDefault(currSum - target, 0);

        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        count += dfs(node.left, currSum, target, map);
        count += dfs(node.right, currSum, target, map);

        // backtrack
        map.put(currSum, map.get(currSum) - 1);

        return count;
    }

    public static void main(String[] args) {
        /*
              10
             /  \
            5   -3
           / \    \
          3   2    11
         / \   \
        3  -2   1

        Target Sum = 8

        Paths that sum to 8:
        1. 5 -> 3
        2. 5 -> 2 -> 1
        3. -3 -> 11

        Total paths = 3
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        int result = pathSum(root, targetSum);
        System.out.println("Number of paths that sum to " + targetSum + ": " + result);
    }
}

