module Lib
    ( breakingRecords
    ) where

import Data.List ( group, inits )

breakingRecords :: Ord a => [a] -> [Int]
breakingRecords scores = [maxi, mini]
    where maxi = length (group $ Prelude.map maximum . tail $ inits scores) - 1
          mini = length (group $ Prelude.map minimum . tail $ inits scores) - 1

-- let s = [3, 4, 21, 36, 10, 28, 35, 5, 24, 42]