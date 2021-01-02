import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CompareTheTriplets {
    static List<Integer> compareTriplets(List<Integer> alicePoints, List<Integer> bobPoints) {
        int aliceTotal = 0;
        int bobTotal = 0;

        Iterator<Integer> itAlice = alicePoints.iterator();
        Iterator<Integer> itBob = bobPoints.iterator();

        while (itAlice.hasNext() && itBob.hasNext()) {
            int alice = itAlice.next();
            int bob = itBob.next();

            if (alice > bob) {
                aliceTotal++;
            } else if (bob > alice) {
                bobTotal++;
            }
        }

        return new ArrayList<Integer>(
                Arrays.asList(aliceTotal, bobTotal)
        );

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//        int input = 2;
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("io/compareTheTriplets/input."+input+".txt"));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("io/compareTheTriplets/output."+input+".txt"));

        String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a.add(aItem);
        }

        String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> b = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int bItem = Integer.parseInt(bItems[i]);
            b.add(bItem);
        }

        List<Integer> result = compareTriplets(a, b);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
