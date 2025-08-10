from node import Node
from collections import deque
class BinaryTree:
    def __init__(self):
        self.root = None
    def insert(self, val):
        new_node = Node(val)
        if self.root == None:
            self.root = new_node
        else:
            cur = self.root
            while True:
                if new_node.val > cur.val:
                    if not cur.right:
                        cur.right = new_node
                        break
                    else:
                        cur = cur.right
                elif new_node.val < cur.val:
                    if not cur.left:
                        cur.left = new_node
                        break
                    else:
                        cur = cur.left
                else:
                    raise KeyError("Cannot insert same value")
    def contains(self, val):
        if not self.root:
            return False
        else:
            cur = self.root
            while cur:
                if cur.val == val:
                    return True
                elif val < cur.val:
                    cur = cur.left
                else:
                    cur = cur.right
            return False
    def BFS(self):
        que = deque([self.root])
        visited = []
        while que:
            level = len(que)
            for i in range(level):
                cur = que.popleft()
                visited.append(cur.val)
                if cur.left : que.append(cur.left)
                if cur.right : que.append(cur.right)
        return ",".join([str(x) for x in visited])
    def preorder(self):
        arr = []
        def traverse(node):
            arr.append(node.val)
            if node.left : traverse(node.left)
            if node.right : traverse(node.right)
        traverse(self.root)
        return " , ".join([str(x) for x in arr])
    def inorder(self):
        arr = []
        def traverse(node):
            if node.left : traverse(node.left)
            arr.append(node.val)
            if node.right : traverse(node.right)
        traverse(self.root)
        return " , ".join([str(x) for x in arr])
    def postorder(self):
        arr = []
        def traverse(node):
            if node.left : traverse(node.left)
            if node.right : traverse(node.right)
            arr.append(node.val)
        traverse(self.root)
        return " , ".join([str(x) for x in arr])

tr = BinaryTree()
tr.insert(98)
tr.insert(78)
tr.insert(-98)
tr.insert(12)
tr.insert(76)
print(tr.inorder())