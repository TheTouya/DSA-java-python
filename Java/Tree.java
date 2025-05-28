import java.util.Queue;
import java.util.LinkedList;
public class Tree {
    class Node {
        Node left;
        Node right;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    Node root;
    public void insert(int val) {
        Node new_node = new Node(val);
        if(root == null) {
            root = new_node;
        } else {
            Queue<Node> que = new LinkedList<>();
            que.add(root);
            while(!que.isEmpty()) {
                int level = que.size();
                for(int i = 0; i < level; i++) {
                    Node temp = que.remove();
                    if(temp.left == null) {
                        temp.left = new_node;
                        break;
                    }
                    if(temp.right == null) {
                        temp.right = new_node;
                        break;
                    }
                    if(temp.left != null) {
                        que.add(temp.left);
                    }
                    if(temp.right != null) {
                        que.add(temp.right);
                    }
                }
            }
        }
    }
}
