public class Set {
    class Node{
        Node next;
        int val;
        public Node(int val) {
            this.val = val;
        }
    }
    Node top;
    int size = 0;
    public void insert(int val) {
        Node new_node = new Node(val);
        if(size == 0) {
            top = new_node;
            size ++;
        } else {
            boolean canAdd = true;
            Node temp = top;
            while(temp != null) {
                if(temp.val == val) {
                    canAdd = false;
                    break;
                }
                temp = temp.next;
            }
            if(canAdd) {
                new_node.next = top;
                top = new_node;
                size++;
            }
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean contains(int val) {
        if(size == 0) {
            return false;
        } else {
            Node temp = top;
            while(temp != null) {
                if(temp.val == val) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }
    @Override
    public String toString() {
        String str = "";
        Node temp = top;
        while(temp != null) {
            str += temp.val + ", ";
            temp = temp.next;
        }
        if(str.length() != 0) {
            str = "{" + str.substring(0, str.length() - 2) + "}";
        } else {
            str = "{}";
        }
        return str;
    }
}
