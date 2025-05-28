import java.util.ArrayList;
public class HashMap {
    class Node {
        String key;
        int value;
        Node next;

        public Node(String k, int val) {
            this.key = k;
            this.value = val;
        }
    }

    private int size = 7;
    private Node[] dataMap;

    public HashMap() {
        dataMap = new Node[size];
    }

    private int hash(String key) {
        int hash = 0;
        char[] cahrs = key.toCharArray();
        for (int i = 0; i < cahrs.length; i++) {
            int asciiVal = cahrs[i];
            hash = (hash + asciiVal * 23) % dataMap.length;
        }
        return hash;
    }
    private boolean check(String key) {
        ArrayList<String> keyss = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                keyss.add(temp.key);
                temp = temp.next;
            }
        }
        for(int i=0; i < keyss.size(); i++) {
            if(keyss.get(i).equals(key)) {
                return true;
            }
        }
        return false;
    }
    public void set(String key, int value) {
        Node newNode = new Node(key, value);
        int index = hash(key);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            if (check(key)) {
                Node temp = dataMap[index];
                while (temp != null) {
                    if(temp.key.equals(key)) {
                        temp.value = value;
                        return;
                    }
                    temp = temp.next;
                }
            } else {
                Node temp = dataMap[index];
                Node before = dataMap[index];
                while (temp != null) {
                    before = temp;
                    temp = temp.next;
                }
                before.next = newNode;
            }

        }
    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public String toString() {
        String str = "{\n";
        for(int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                str += temp.key + " : " + temp.value + "\n";
                temp = temp.next;
            }
        }
        str += "}";
        return str;
    }
    public ArrayList<String> keys() {
        ArrayList<String> keyss = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                keyss.add(temp.key);
                temp = temp.next;
            }
        }
        return keyss;
    }
    public ArrayList<Integer> values() {
        ArrayList<Integer> keyss = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null) {
                keyss.add(temp.value);
                temp = temp.next;
            }
        }
        return keyss;
    }
}

