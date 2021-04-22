module Spec where

import Lib (kangaroo)
main :: IO ()
main = putStrLn $ kangaroo [5, 3, 0, 2]
