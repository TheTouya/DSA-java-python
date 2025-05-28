public class DoublyLinkedList {
    class Node{
        int val;
        Node next;
        Node before;
        public Node(int val) {
            this.val = val;
        }
    }
    Node tail;
    Node head;
    int length = 0;
    public void append(int val) {
        Node new_node = new Node(val);
        if(length == 0) {
            tail = new_node;
            head = new_node;
        } else {
            Node temp = tail;
            temp.next = new_node;
            head = new_node;
            new_node.before = temp;

        }
        length++;
    }
    public void prepend(int val) {
        Node new_node = new Node(val);
        if(length == 0) {
            tail = new_node;
            head = new_node;
        } else {
            new_node.next = head;
            head.before = new_node;
            head = new_node;
        }
        length++;
    }
    public int pop() {
        if(length == 0) {
            return -1;
        } else if(length == 1) {
            int val = tail.val;
            tail = null;
            head = null;
            length--;
            return val;
        } else {
            Node temp = tail.before;
            int val = tail.val;
            temp.next = null;
            tail = temp;
            length--;
            return val;
        }
    }
    public int dequeue() {
        if(length == 0) {
            return -1;
        } else if (length == 1) {
            int val = head.val;
            head = null;
            tail = null;
            length--;
            return val;
        } else {
            int val = head.val;
            Node temp = head.next;
            temp.before = null;
            head = temp;
            length--;
            return val;
        }
    }
}
