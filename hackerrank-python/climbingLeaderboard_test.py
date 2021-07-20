from climbingLeaderboard import climbingLeaderboard
import unittest

class MyTestCase(unittest.TestCase):
    def test_1(self):
        self.assertEqual(climbingLeaderboard([100, 90, 90, 80], [70, 80, 105]), [4, 3, 1])
        self.assertEqual(climbingLeaderboard([100, 100, 50, 40, 40, 20, 10], [5, 25, 50, 120]), [6, 4, 2, 1])

if __name__ == '__main__':
    unittest.main()

