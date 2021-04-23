module Main where

excludeNth :: Int -> [Int] -> [Int]
excludeNth n xs = fst splitted ++ tail (snd splitted)
    where splitted = splitAt n xs


bonAppetit :: [Int] -> Int -> Int -> [Char]
bonAppetit bills notAnna annasCharge
    | refund == 0 = "Bon Appetit" 
    | otherwise = show refund  
    where annasBill = sum (excludeNth notAnna bills) `div` 2
          refund = annasCharge - annasBill


main :: IO ()
main = putStrLn  "bonAppetit"
