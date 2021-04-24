module Main where

import Data.List (unfoldr)
import Data.Maybe (fromJust)
import GHC.OldList (elemIndex)

pageCount :: (Num a, Enum a, Eq a) => a -> a -> Int
pageCount totalPage destPage = min groupCount (length pageGroup - groupCount - 1)
  where
    groupCount = fromJust $ elemIndex (head $ filter (elem destPage) pageGroup) pageGroup
    pageGroup =
      takeWhile (not . null)
        . unfoldr (Just . splitAt 2)
        $ [0 .. totalPage]



main :: IO ()
main = print $ pageCount 5 3
