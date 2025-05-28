public class LinkedList {
    private static class Node {
        int value;
        Node next;
        public Node(int val) {
            this.value = val;
        }
    }
    private int length;
    private Node head;
    private Node tail;
    public void push(int value) {
        Node new_node = new Node(value);
        if(length == 0) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
        length++;
    }
    public void prepend(int value) {
        Node new_node = new Node(value);
        if(length == 0) {
            head = new_node;
            tail = new_node;
        } else {
            Node temp = head;
            head = new_node;
            head.next = temp;
        }
        length++;
    }
    public void insert(int index, int val) {
        Node new_node = new Node(val);
        if(index == 0) {
            prepend(val);
        } else if (index == length) {
            push(val);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node after = temp.next;
            temp.next = new_node;
            new_node.next = after;
            length++;
        }
    }
    public int dequeue() {
        if(length == 0) {
            return -1;
        } else if(length == 1) {
            int val = head.value;
            tail = null;
            head = null;
            length--;
            return val;
        } else {
            Node temp = head.next;
            int val = head.value;
            head.next = null;
            head = temp;
            length--;
            return val;
        }
    }
    public int pop() {
        if(length == 0) {
            return -1;
        } else if(length == 1) {
            int val = tail.value;
            tail = null;
            head = null;
            length--;
            return val;
        } else {
            Node temp = head;
            while(temp.next != tail) {
                temp = temp.next;
            }
            int val = temp.next.value;
            temp.next = null;
            tail = temp;
            length--;
            return val;
        }
    }
    public void remove(int index) {
        if(index == 0) {
            dequeue();
        } else if (index == length - 1) {
            pop();
        } else {
            Node temp = head;
            for(int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node after = temp.next;
            temp.next = after.next;
            after.next = null;
            length--;
        }
    }
    public void reverse() {
        Node temp = head;
        Node after = temp;
        Node before = null;
        head = tail;
        while(temp != null) {
            after = after.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public int size() {
        return length;
    }
    @Override
    public String toString() {
        Node temp = head;
        String str = "";
        while(temp != null) {
            str += temp.value + " -> ";
            temp = temp.next;
        }
        if(!str.equals("")) {
            str = "[" + str.substring(0, str.length() - 4) + "]";
        } else {
            str = "[]";
        }
        return str;
    }
}
