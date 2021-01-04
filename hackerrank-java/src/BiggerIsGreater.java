import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BiggerIsGreater {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        System.out.println(w);
        char[] ch_array = w.toCharArray();

        for (int ch: ch_array) {
            System.out.print(ch);
            System.out.print(" ");
        }

        System.out.println();

        for (int i = 0; i < ch_array.length ; i++) {
            System.out.print("i-");
            System.out.print((int)ch_array[i]);
            System.out.print('-');
            System.out.print(ch_array[i]);
            System.out.print(" ");
            for (int j = i + 1; j < ch_array.length; j++) {
                System.out.print("j-");
                System.out.print((int)ch_array[j]);
                System.out.print('-');
                System.out.print(ch_array[i]);
                System.out.print(" ");
                if (ch_array[i] > ch_array[j]) {
                    System.out.printf("swapping %c with %c\n", ch_array[i], ch_array[j]);
                    swap(ch_array, i, j);
                    System.out.println("ch_array = " + Arrays.toString(ch_array));
                    return String.valueOf(ch_array);
                }
                System.out.println();
            }
        }

        return "no answer";
    }

    public static <T> void swap (char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int input = 1;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("io/BiggerIsGreater/output."+input+".txt"));
        Scanner scanner = new Scanner(new File("io/BiggerIsGreater/input."+input+".txt"));
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
