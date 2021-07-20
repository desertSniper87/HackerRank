from extra_long_factorials import extraLongFactorials
import unittest

class MyTestCase(unittest.TestCase):
    def test_1(self):
        self.assertEqual(extraLongFactorials(5), 120)
        self.assertEqual(extraLongFactorials(25), 15511210043330985984000000)

if __name__ == '__main__':
    unittest.main()

