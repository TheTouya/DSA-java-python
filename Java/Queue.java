public class Queue {
    class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    private Node top;
    private Node bottom;
    private int length = 0;
    public void enqueue(int val) {
        Node new_node = new Node(val);
        if(length == 0) {
            top = new_node;
            bottom = new_node;
            length++;
        } else {
            Node temp = top;
            temp.next = new_node;
            top = new_node;
            length++;
        }
    }
    public int dequeue() {
        if(length == 0) {
            return -1;
        } else if(length == 1) {
            int val = bottom.value;
            bottom = null;
            top = null;
            length--;
            return val;
        } else {
            Node temp = bottom.next;
            int val = bottom.value;
            bottom.next = null;
            bottom = temp;
            length--;
            return val;
        }
    }
    public int size() {
        return length;
    }
    @Override
    public String toString() {
        String str = "";
        Node temp = bottom;
        while(temp != null) {
            str += temp.value + ", ";
            temp = temp.next;
        }
        if(str.length() != 0) {
            str = "[" + str.substring(0,str.length() - 2) + "]";
        } else {
            str = "[]";
        }
        return str;
    }
}
