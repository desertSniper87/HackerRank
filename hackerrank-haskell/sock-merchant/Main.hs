module Main where

import Data.List (group, sort)
sockMerchant :: Ord a => p -> [a] -> Int
sockMerchant _ ar = sum $ map ((`div` 2) . length) $ (group . sort) ar
    

main :: IO ()
main = putStrLn "Hello, Haskell!"
