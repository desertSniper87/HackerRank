module Main where

import Lib (breakingRecords)

main :: IO ()
main = print (breakingRecords [3, 4, 21, 36, 10, 28, 35, 5, 24, 42])
