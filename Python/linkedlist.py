from node import Node
class Linked_List:
    def __init__(self):
        self.head = None
        self.tail = None
        self.length = 0
    def push(self, val):
        new_node = Node(val)
        if self.length == 0:
            self.head = new_node
            self.tail = new_node
            self.length += 1
        else:
            temp = self.tail
            temp.next = new_node
            self.tail = new_node
            self.length += 1
    def pop(self):
        if self.length == 0:
            return -1
        elif self.length == 1:
            val = self.tail.val
            self.head = None
            self.tail = None
            length -= 1
            return val
        else:
            cur = self.head
            while cur.next != self.tail:
                cur = cur.next
            value = cur.next.val
            cur.next = None
            self.tail = cur
            length -= 1
            return value
    def reverse(self):
        before = None
        cur = self.head
        after = None
        while cur:
            after = cur.next
            cur.next = before
            before = cur
            cur = after
        self.tail = self.head
        self.head = before
    def is_empty(self):
        return self.length == 0
    def __len__(self):
        return self.length
    def __iter__(self):
        cur = self.head
        while cur:
            yield cur.val
            cur = cur.next
    def __getitem__(self, index):
        if index < 0 or index >= self.length:
            raise IndexError("invalid index")
        else:
            cur = self.head
            for x in range(index):
                cur = cur.next
            return cur.val
    def __str__(self):
        cur = self.head
        string = ""
        while cur:
            string += str(cur.val) + " -> "
            cur = cur.next
        if string:
            string = string[:len(string) - 3]
        else:
            string = "[]"
        return string