package src.problemSet.algorithm.dynamicProgramming;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DavisStaircase {

    // Complete the stepPerms function below.
    static int stepPerms(int n) {

        if (n == 0 || n == 1)
            return 1;

        else if (n == 2) return 2;
        int[] memo = {1, 1, 2};


        for (int i = 3; i <= n; i++) {
            int count = memo[2] + memo[1] + memo[0];
            memo[0] = memo[1];
            memo[1] = memo[2];
            memo[2] = count;

        }
        return memo[2];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int res = stepPerms(n);

            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
