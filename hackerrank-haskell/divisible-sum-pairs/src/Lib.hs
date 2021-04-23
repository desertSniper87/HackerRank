module Lib
    ( divisibleSumPairs
    ) where

divisibleSumPairs :: Integral a => p -> [a] -> a -> Int
divisibleSumPairs _ ar k = Prelude.length [() | (ix, i)  <- Prelude.zip  [1..] ar,
                                    (ij, j) <- Prelude.zip [1..] ar,
                                     ix < ij,
                                    (i + j) `mod` k == 0] 
