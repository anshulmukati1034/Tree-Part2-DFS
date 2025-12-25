import java.util.LinkedList;
import java.util.Queue;

public class Q12_LevelOrderSuccessorofanodeinBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }   


    public static TreeNode levelOrderSuccessor(TreeNode root, int key) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);

            if (curr.val == key) {
                return queue.peek(); // successor
            }
        }

        return null;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int key = 3;
        TreeNode successor = levelOrderSuccessor(root, key);
        if (successor != null) {
            System.out.println("Level order successor of " + key + " is: " + successor.val);
        } else {
            System.out.println("Level order successor of " + key + " does not exist.");
        }
    }   
}
