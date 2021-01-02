import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Encryption {

    // Complete the encryption function below.
    static String encryption(String s) {
        int senlength = s.length();
        System.out.println("l = " + senlength);
        double diagonalLength = Math.sqrt(senlength);

        int row= (int) Math.ceil(diagonalLength);
        int col= (int) Math.ceil(diagonalLength);

        System.out.println("row = " + row);
        System.out.println("col = " + col);

        char[][] matrix = new char[row][col];

        int index = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col && index < senlength; c++) {
                System.out.println("r = " + r);
                System.out.println("c = " + c);
                System.out.println("s.charAt(r+c) = " + s.charAt(r + c));
                matrix[r][c] = s.charAt(index++);
            }
        }

        System.out.println("final matrix = " + Arrays.deepToString(matrix));

        final StringBuilder sb = new StringBuilder(row*col);

        for (int c = 0; c < col; c++) {
            for (int r = 0; r < row; r++) {
                if (matrix[r][c] != 0) {
                    sb.append(matrix[r][c]);
                }
            }
            sb.append(' ');
        }

        return sb.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        int input = 1;
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("io/encryption/output."+input+".txt"));
//        Scanner scanner = new Scanner(new File("io/encryption/input."+input+".txt"));

        String s = scanner.nextLine();

        String result = encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
