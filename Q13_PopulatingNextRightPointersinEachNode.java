public class Q13_PopulatingNextRightPointersinEachNode {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }   
    }

    public static Node connect(Node root) {
        if (root == null) return null;

        Node leftmost = root;

        // Traverse level by level
        while (leftmost.left != null) {
            Node curr = leftmost;

            while (curr != null) {
                //  Connect left -> right
                curr.left.next = curr.right;

                //  Connect right -> next.left
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                curr = curr.next;
            }

            leftmost = leftmost.left;
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node connectedRoot = connect(root);

        // Print the next pointers for each level
        Node levelStart = connectedRoot;
        while (levelStart != null) {
            Node curr = levelStart;
            while (curr != null) {
                System.out.print(curr.val + " -> ");
                if (curr.next != null) {
                    System.out.print(curr.next.val + "   ");
                } else {
                    System.out.print("null   ");
                }
                curr = curr.next;
            }
            System.out.println();
            levelStart = levelStart.left;
        }
    }
}
