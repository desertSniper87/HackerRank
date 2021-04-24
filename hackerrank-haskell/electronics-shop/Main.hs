module Main where

import Data.List (sort)
getMoneySpent :: (Ord p, Num p) => [p] -> [p] -> p -> p
getMoneySpent keyboards drives budget 
        | null options = -1
        | otherwise = maximum options
        where options = filter (<= budget) [sum [k, d] | k <- keyboards, d <- drives]

main :: IO ()
main = do 
    print $ getMoneySpent [3, 1] [5, 2, 8] 10
    print $ getMoneySpent [4] [5] 5
    print $ getMoneySpent [99] [5, 2, 8] 10
