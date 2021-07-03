#!/bin/python3


#
# Complete the 'longestSubarray' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#

def longestSubarray(arr):
    i, l = 1, len(arr)

    if l < 2:
        return l

    best = 1
    bestLower = 1
    bestHigher = 1

    # Traversing through list
    while i < l:
        # Next element is the same
        if arr[i] == arr[i-1]:
            bestLower += 1
            bestHigher += 1

        # Next element is greater than one
        elif arr[i] == arr[i-1] + 1:
            bestLower = bestHigher + 1
            bestHigher = 1

        # Next element is less than one
        elif arr[i] + 1 == arr[i-1]:
            bestHigher = bestLower + 1
            bestLower = 1

        # Next element difference is greater than 1
        else:
            bestLower = 1
            bestHigher = 1

        # ??
        best = max(best, bestLower, bestHigher)

        i += 1

    return best

if __name__ == '__main__':
    arr = [1, 2, 1, 2, 3]
    print(longestSubarray(arr))