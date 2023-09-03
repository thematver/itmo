from algorithms import algos_inform
from iomanager import read_graph, print_path


def search(graph, distances, start, finish, algorithm, name='Название алгоритма'):
    path = algorithm(graph, distances, start, finish)
    print(f'{name}:')
    print_path(graph, distances, path, finish)
    print()


if __name__ == "__main__":
    graph, distances = read_graph('graph')
    start = "Рига"
    finish = "Одесса"

    for name, algorithm in algos_inform.items():
        search(graph, distances, start, finish, algorithm, name)