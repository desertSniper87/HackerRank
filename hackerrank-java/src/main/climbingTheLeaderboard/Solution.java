package main.climbingTheLeaderboard;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> finalRank = new ArrayList<Integer>();

        for (int gamePoint : player) {
            int index = Collections.binarySearch(ranked, gamePoint);
            if (index < 0) {
                index *= -1;
                ranked.add(index, gamePoint);
            }
            finalRank.add(index);
        }

        return finalRank;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<>();

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
        }

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
