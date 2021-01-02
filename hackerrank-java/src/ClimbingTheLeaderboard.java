import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        ranked.sort(Integer::compareTo);

        List<Integer> finalRank = new ArrayList<Integer>();
        // System.out.println("ranked = " + ranked);
        // System.out.println("player = " + player);

        HashMap<Integer, Integer> rankMap = updateRankmap(ranked);

        // System.out.println("rankMap = " + rankMap);
        for (int p: player) {
            if (rankMap.containsKey(p)) {
                finalRank.add(rankMap.size() - rankMap.get(p) + 1);
            } else {
                int index = Collections.binarySearch(ranked, p);
                // System.out.println("p = " + p);
                // System.out.println("index = " + index);
                int insertionPoint = -(index+1);
                // System.out.println("insertionPoint = " + insertionPoint);
//                // System.out.println("ranked.get(insertionPoint) = " + ranked.get(insertionPoint));
                ranked.add(insertionPoint, p);
                // System.out.println("ranked = " + ranked);
                rankMap = updateRankmap(ranked);
                finalRank.add(Math.max(rankMap.size() - rankMap.get(p), 1));
            }
        }

        // System.out.println("ranked = " + ranked);
        // System.out.println("finalRank = " + finalRank);

        return finalRank;

//        return finalRank.stream().map(
//                i -> finalRank.size() - i
//        ).collect(Collectors.toList());
    }

    private static HashMap<Integer, Integer> updateRankmap(List<Integer> ranked) {
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0; i < ranked.size(); i++) {
            rankMap.put(ranked.get(i), i);
        }
        return rankMap;
    }

}

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        int input = 1;
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("io/climbingLeaderboard/input."+input+".txt"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("io/climbingLeaderboard/output."+input+".txt"));

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
