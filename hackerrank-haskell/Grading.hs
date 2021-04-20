module Grading where

grade :: Integer -> Integer   
grade x
    | x < 38 = x
    | nearestRound - x < 3 = nearestRound
    | otherwise = x
    where nearestRound = (*) 5 . ceiling $ (/) (fromInteger x) 5


gradingStudents :: [Integer] -> [Integer]
gradingStudents = map grade

