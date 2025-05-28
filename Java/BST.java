import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class BST {
    class Node {
        Node left;
        Node right;
        int value;
        public Node(int val) {
            this.value = val;
        }
    }
    private Node root;
    private int size;
    public BST(int val) {
        Node nd = new Node(val);
        root = nd;
        size++;
    }
    public boolean insert(int val) {
        Node nd = new Node(val);
        Node temp = root;
        while(true) {
            if(temp.value == val) {
                return false;
            } else if(temp.value > val) {
                if(temp.left == null) {
                    temp.left = nd;
                    return true;
                }
                temp = temp.left;
            } else if (val > temp.value) {
                if(temp.right == null) {
                    temp.right = nd;
                    return true;
                }
                temp = temp.right;
            }
        }
    }
    public boolean contains(int val) {
        Node temp = root;
        while(temp != null) {
            if(temp.value == val) {
                return true;
            } else if(temp.value < val) {
                temp = temp.right;
            } else if(temp.value > val) {
                temp = temp.left;
            }
        }
        return false;
    }
    public ArrayList<Integer> BFS() {
        Node temp = root;
        Queue<Node> que = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        que.add(temp);
        while(que.size() > 0) {
            temp = que.remove();
            result.add(temp.value);
            if(temp.left != null) {
                que.add(temp.left);
            }
            if(temp.right!=null) {
                que.add(temp.right);
            }
        }
        return result;
    }
    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> arr = new ArrayList<>();
        class Traverse {
            public Traverse(Node temp) {
                arr.add(temp.value);
                if(temp.left != null) {
                    new Traverse(temp.left);
                }
                if(temp.right != null) {
                    new Traverse(temp.right);
                }
            }
        }
        new Traverse(root);
        return arr;
    }
    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> arr = new ArrayList<>();
        class Traverse {
            public Traverse(Node temp) {
                if(temp.left != null) {
                    new Traverse(temp.left);
                }
                if(temp.right != null) {
                    new Traverse(temp.right);
                }
                arr.add(temp.value);
            }
        }
        new Traverse(root);
        return arr;
    }
    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> arr = new ArrayList<>();
        class Traverse {
            public Traverse(Node temp) {
                if(temp.left != null) {
                    new Traverse(temp.left);
                }
                arr.add(temp.value);
                if(temp.right != null) {
                    new Traverse(temp.right);
                }
            }
        }
        new Traverse(root);
        return arr;
    }
}
