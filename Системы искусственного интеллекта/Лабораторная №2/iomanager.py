from collections import defaultdict

import networkx as nx
from matplotlib import pyplot as plt
from pygraphviz import AGraph


def read_graph(path):
    distances = defaultdict(lambda: defaultdict(lambda: 0))
    graph = defaultdict(lambda: [])
    with open(path, encoding='utf-8') as file:
        for line in file.readlines():
            a, b, distance = line.split(' ')
            distances[a][b] = int(distance)
            distances[b][a] = int(distance)
            graph[a].append(b)
            graph[b].append(a)
    return graph, distances


def print_path(graph, distances, p, v):
    names = [v]
    red_edges = []
    while v in p:
        red_edges.append(((min(p[v], v)), (max(p[v], v))))
        v = p[v]
        names.append(v)
    names.reverse()
    for name in names:
        print(name)

    A = AGraph()
    A.add_nodes_from(graph.keys())
    for v in distances:
        for to in graph[v]:
            if v < to:
                A.add_edge(v, to, len=distances[v][to], color='red' if (v, to) in red_edges else 'black')

    G = nx.nx_agraph.from_agraph(A)
    labels = {}
    for u, v, data in G.edges(data=True):
        labels[(u, v)] = data['len']
    pos = nx.nx_agraph.graphviz_layout(G)
    edges = G.edges()
    colors = [G[u][v]['color'] for u, v in edges]
    nx.draw(G, pos, with_labels=True, edge_color=colors, node_size=20, font_size=10)
    nx.draw_networkx_edge_labels(G, pos, edge_labels=labels, font_size=5)
    plt.show()
