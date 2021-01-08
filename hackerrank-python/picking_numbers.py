#!/bin/python3

import math
import os
import random
import re
import sys



def pickingNumbers(array):
    array.sort()

    main_index = 0
    max_subarray_len = 0

    array_length = len(array)

    while main_index < array_length - 1:
        sub_index = main_index + 1
        subarray_len = 1
        while sub_index < array_length and array[sub_index] - array[main_index] <= 1:
            sub_index += 1
            subarray_len += 1
        max_subarray_len = max(max_subarray_len, subarray_len)
        main_index += 1

    return max_subarray_len


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    a = list(map(int, input().rstrip().split()))
    

    result = pickingNumbers(a)

    fptr.write(str(result) + '\n')

    fptr.close()
