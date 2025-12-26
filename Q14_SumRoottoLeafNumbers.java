class Q14_SumRoottoLeafNumbers {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static int sum = 0;

    public static int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }

    private static void dfs(TreeNode node, int current) {
        if (node == null) return;

        current = current * 10 + node.val;

        // leaf node
        if (node.left == null && node.right == null) {
            sum += current;
            return;
        }

        dfs(node.left, current);
        dfs(node.right, current);
    }

    public static void main(String[] args) {

        /*
              1
             / \
            2   3

        Paths:
        1 -> 2 = 12
        1 -> 3 = 13
        Sum = 25
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int result = sumNumbers(root);
        System.out.println("Sum of Root to Leaf Numbers: " + result);
    }
}
