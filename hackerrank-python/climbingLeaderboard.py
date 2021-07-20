#!/bin/python3

import math
import os
import random
import re
import sys
import bisect
from copy import deepcopy

#
# Complete the 'climbingLeaderboard' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY ranked
#  2. INTEGER_ARRAY player
#

def getUniqueElementFromList(l) -> list:
    """
    Get unique element while preserving order.
    """
    seen = set()
    seen_add = seen.add
    return [x for x in l if not (x in seen or seen_add(x))]

def getCount(uniqueList: list, l: list) -> dict:
    d = {}
    for i in uniqueList:
        d[i] = l.count(i)
    
    return d

def leftElements(l: list, item: int) -> list:
    """
    Get elements that are larger than item in list.
    """
    return [x for x in l if x > item]



def climbingLeaderboard(ranked, player):
    res = []
    ranked = sorted(deepcopy(ranked))

    for p in player:
        # insert p into ranked
        bisect.insort(ranked, p)

        #Get unique elements
        uniqueElements = getUniqueElementFromList(ranked)

        # Get rank of p
        res.append(len(uniqueElements) - uniqueElements.index(p))

    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    ranked_count = int(input().strip())

    ranked = list(map(int, input().rstrip().split()))

    player_count = int(input().strip())

    player = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(ranked, player)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
