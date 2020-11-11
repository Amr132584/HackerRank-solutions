package src.problemSet.algorithm.sorting;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentActivityNotifications {

    static int activityNotifications(int[] expenditure, int d) {

        if (expenditure.length < d + 1)
            return 0;

        int noti = 0;

        for (int i = d, start = 0; i < expenditure.length; i++, start++) {
            Arrays.sort(expenditure, start, i - 1);

            float median;

            if (d % 2 == 1)

                median = expenditure[d / 2 + start];

            else
                median = (float) ((expenditure[d / 2 + start]) + (expenditure[d / 2 + start] + 1)) / 2;

            if (median * 2 <= expenditure[i])
                noti++;


        }


        return noti;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
