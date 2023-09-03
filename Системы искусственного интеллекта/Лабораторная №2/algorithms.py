from queue import Queue, PriorityQueue


def bfs(g, d, start, _):
    q = Queue()
    q.put(start)
    used = {start: True}
    p = {}
    while not q.empty():
        v = q.get()
        for to in g[v]:
            if not used.get(to, False):
                used[to] = True
                p[to] = v
                q.put(to)
    return p


def dfs(g, d, start, _, max_depth=999999):
    used = {}
    p = {}

    def step(v, depth=0):
        if depth >= max_depth:
            return
        used[v] = True
        for to in g[v]:
            if to not in used:
                p[to] = v
                step(to, depth + 1)

    step(start)
    return p


def dfs_with_limited_depth(g, d, start, _):
    return dfs(g, d, start, _, 6)


def iddfs(g, d, start, finish):
    max_depth = 1
    p = {}
    while True:
        p = dfs(g, d, start, finish, max_depth)
        if finish in p:
            break
        max_depth += 1
    return p


def bidirectional(g, d, start, finish):
    q = Queue()
    q.put(start)
    q.put(finish)
    used = {start: 0, finish: 1}
    p = {}
    while not q.empty():
        v = q.get()
        for to in g[v]:
            if to not in used:
                used[to] = used[v]
                p[to] = v
                q.put(to)
            else:
                if used[to] != used[v]:
                    while True:
                        if to == finish:
                            p[to] = v
                            break
                        if used[to] == used[start]:
                            to, v = v, to
                        next = p[to]
                        p[to] = v
                        v = to
                        to = next
                    return p


def a_astericks(g, d, start, _):
    q = PriorityQueue()
    q.put((0, start))
    used = {start: True}
    p = {}
    f = {start: 0}
    while not q.empty():
        l, v = q.get()
        for to in g[v]:
            f_new = d[v][to] + f[v]
            if not used.get(to, False) and f_new < f.get(to, 9999999):
                used[to] = True
                p[to] = v
                f[to] = f_new
                q.put((f_new, to))
    return p


def greedy(g, d, start, _):
    q = PriorityQueue()
    q.put((0, start))
    used = {start: True}
    p = {}
    while not q.empty():
        l, v = q.get()
        for to in g[v]:
            if not used.get(to, False):
                used[to] = True
                p[to] = v
                q.put((d[v][to], to))
    return p


algos_inform = {
    'BFS': bfs,
    'DFS': dfs,
    'DFS с ограниченной глубиной': dfs_with_limited_depth,
    'IDDFS': iddfs,
    'Двунаправленный поиск': bidirectional,
    'Жадный': greedy,
    'A*': a_astericks
}