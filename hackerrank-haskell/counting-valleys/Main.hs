module Main where

import Data.List (groupBy)
p2int :: Char -> Int 
p2int 'U' = 1
p2int 'D' = -1

-- _ path

countingValleys :: [Char] -> Int
countingValleys path = length $
                  filter (all (< 0)) $
                  (groupBy (\x y -> x /= 0 && y /= 0) . scanl (+) 0) $
                   map p2int path
    

main :: IO ()
main = putStrLn "Hello, Haskell!"
