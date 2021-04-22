-- {-# LANGUAGE FlexibleInstances, UndecidableInstances, DuplicateRecordFields #-}

-- module Main where

-- import Control.Monad
-- import Data.Array
-- import Data.Bits
-- import Data.List
-- import Data.List.Split
-- import Data.Set
-- import Debug.Trace
-- import System.Environment
-- import System.IO
-- import System.IO.Unsafe

-- -- Complete the plusMinus function below.
-- -- plusMinus :: [Int] -> Int Int Int
-- -- plusMinus arr = sum

-- readMultipleLinesAsStringArray :: Int -> IO [String]
-- readMultipleLinesAsStringArray 0 = return []
-- readMultipleLinesAsStringArray n = do
--     line <- getLine
--     rest <- readMultipleLinesAsStringArray(n - 1)
--     return (line : rest)

-- -- main :: IO()
-- -- main = do
--     -- n <- readLn :: IO Int

--     -- arrTemp <- getLine

--     -- let arr = Data.List.map (read :: String -> Int) . words $ arrTemp

--     -- plusMinus arr
