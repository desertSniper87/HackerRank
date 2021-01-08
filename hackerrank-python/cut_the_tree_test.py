import unittest

from cut_the_tree import *

class MyTestCase(unittest.TestCase):
    def test_1(self):
        data = [100, 200, 100, 500, 100, 600]
        edges = [[1, 2], [2, 3], [2, 5], [4, 5], [5, 6]]
        self.assertEqual(cutTheTree(data, edges, 6), 5)



