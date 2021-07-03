#!/bin/python3

from collections import Counter


def mostActive(customers):
    counts = Counter(customers)
    percentageCount = [(c, counts[c] / len(customers)) for c in counts]
    percentageCount = list(filter(lambda x: x[1] >= 0.05, percentageCount))
    percentageCount = sorted(percentageCount, key=lambda x:x[0])
    return [i[0] for i in percentageCount]


if __name__ == '__main__':
    custormer = customers = ["Acme", "Bigcorp", "Bigcorp", "Bigcorp", "Zork", "Zork", "Abc", "Bigcorp", "Acme", "Bigcorp", "Bigcorp", "Zork", "Bigcorp", "Zork", "Zork", "Bigcorp", "Acme", "Bigcorp", "Acme", "Bigcorp", "Acme", "Littlecorp", "Nadircorp"]
    print(mostActive(customers))