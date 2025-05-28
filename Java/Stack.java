
public class Stack {
     private static class Node {
        int value;
        Node next;
        public Node(int val) {
            this.value = val;
        }
    }
    private int height;
    private Node top;
    public void push(int val) {
        Node new_node = new Node(val);
        if(height == 0) {
            top = new_node;
        } else {
            new_node.next = top;
            top = new_node;
        }
        height++;
    }
    public int pop() {
        if(height == 0) {
            return -1;
        } else if(height == 1) {
            int val = top.value;
            top = null;
            height--;
            return val;
        } else {
            int val = top.value;
            Node temp = top.next;
            top.next = null;
            top = temp;
            height--;
            return val;
        }
    }
    public int size() {
        return height;
    }
    @Override
    public String toString() {
        Node temp = top;
        String str = "";
        while (temp != null) {
            str += temp.value + ", ";
            temp = temp.next;
        }
        if(!str.equals("")) {
            str = "[" + str.substring(0,str.length() - 2) + "]";
        } else {
            str = "[]";
        }
        return  str;
    }
}
