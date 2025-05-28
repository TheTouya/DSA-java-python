from collections import deque
import heapq
class Graph:
    def __init__(self):
        self.graph = dict()
    def addVertex(self, u):
        if u not in self.graph:
            self.graph[u] = list()
    def addEdge(self,u,v,weigh=1):  
        if u not in self.graph:
            self.addVertex(u)
        if v not in self.graph:
            self.addVertex(v)
        self.graph[u].append((weigh,v))
        self.graph[v].append((weigh,u))
    def removeEdge(self, u,v):
        if u in self.graph and v in self.graph:
            self.graph[u] = [x for x in self.graph[u] if x[1] != v]
            self.graph[v] = [x for x in self.graph[v] if x[1] != u]
    def removeVertex(self, u):
        if u in self.graph:
            for x in self.graph:
                for y in self.graph[x]:
                    if y[1] == u:
                        self.graph[x].remove(y)
            del self.graph[u]
    def BFS(self, root):
        que = deque([root])
        visited_node = []
        visited_node.append(root)
        while que:
            node = que.popleft()
            adj_nodes = [x[1] for x in self.graph[node]]
            remaining = set(adj_nodes) - set(visited_node)
            if remaining:
                for x in sorted(remaining):
                    visited_node.append(x)
                    que.append(x)
        return visited_node
    def dijkstra(self, start, end):
        heap = [(0, start, [])]
        visited = set()
        while heap:
            cost, node, path = heapq.heappop(heap)
            if node in visited:
                continue
            visited.add(node)
            path = path + [node]
            if node == end:
                return cost, path
            for weight, adj_node in self.graph[node]:
                if adj_node not in visited:
                    heapq.heappush(heap, (weight + cost, adj_node, path))