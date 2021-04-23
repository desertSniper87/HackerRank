import Data.List (group, sort, reverse)
import Data.Ord (comparing)
import Data.Foldable (maximumBy)

migratoryBirds birds = snd . maximumBy (comparing fst) $ reverse $ zip (map length g) (map head g)
    where g = (group. sort) birds

