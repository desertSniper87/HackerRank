import unittest

from picking_numbers import *

class MyTestCase(unittest.TestCase):
    def test_1(self):
        self.assertEqual(pickingNumbers([1, 1, 2, 2, 4, 4, 5, 5, 5]), 5)
        self.assertEqual(pickingNumbers([1, 2, 2, 3, 1, 2]), 5)



