import java.util.ArrayList;
import java.util.List;

public class Q3_BinaryTreePostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }   
    }

     public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        postorder(root, res);
        return res;    
    }

    private static  void postorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }

        postorder(node.left, res);
        postorder(node.right, res);
        res.add(node.val);
    }  

    public static void main(String[] args) {
        // Example usage:
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> postorder = postorderTraversal(root);
        System.out.println(postorder); // Output: [3, 2, 1]
    }   
}
