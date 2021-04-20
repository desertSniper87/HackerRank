#!/bin/python3

import os

class Vertex:
    def __init__(self, node):
        self.id = node
        self.adjacent = {}

    def __str__(self):
        return str(self.id) + ' adjacent: ' + str([x.id for x in self.adjacent])

    def add_neighbor(self, neighbor, weight=0):
        self.adjacent[neighbor] = weight

    def get_connections(self):
        return self.adjacent.keys()

    def get_id(self):
        return self.id

    def get_weight(self, neighbor):
        return self.adjacent[neighbor]

class Graph:
    def __init__(self):
        self.vert_dict = {}
        self.num_vertices = 0

    def __str__(self):
        for v in self.vert_dict:
            print(str(self.vert_dict[v]) + "-->" + str(self.vert_dict[v].adjacent.values()))

    def __iter__(self):
        return iter(self.vert_dict.values())

    def add_vertex(self, node):
        self.num_vertices = self.num_vertices + 1
        new_vertex = Vertex(node)
        self.vert_dict[node] = new_vertex
        return new_vertex

    def get_vertex(self, n):
        if n in self.vert_dict:
            return self.vert_dict[n]
        else:
            return None

    def add_edge(self, frm, to, cost = 0):
        if frm not in self.vert_dict:
            self.add_vertex(frm)
        if to not in self.vert_dict:
            self.add_vertex(to)

        self.vert_dict[frm].add_neighbor(self.vert_dict[to], cost)

    def get_vertices(self):
        return self.vert_dict.keys()

    def dfs(self):
        nodes_to_visit = [self.vert_dict[1]]

        while len(nodes_to_visit) > 0:
            current_node = nodes_to_visit.pop()
            print("LINE:66 -- len(nodes_to_visit) = " + str(len(nodes_to_visit)))
            print("visiting " + str(current_node.id))
            for vertex in current_node.adjacent.keys():
                nodes_to_visit.append(vertex)


def cutTheTree(data, edges, nos_vertex):
    g = Graph()

    for i in range(1, nos_vertex + 1):
        g.add_vertex(i)

    for d in zip(data, edges):
        cost = d[0]
        edge = d[1]
        g.add_edge(edge[0], edge[1], cost)

    g.dfs()


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    data = list(map(int, input().rstrip().split()))

    edges = []

    for _ in range(n - 1):
        edges.append(list(map(int, input().rstrip().split())))

    result = cutTheTree(data, edges, n)

    fptr.write(str(result) + '\n')

    fptr.close()
