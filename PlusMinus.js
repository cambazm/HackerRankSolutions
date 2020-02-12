import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        int total = arr.length;
        int item = 0;

        for(int i=0; i<total; i++) {
            item = arr[i];
            if(item > 0)
                positiveCount++;
            else if(item < 0)
                negativeCount++;
            else 
                zeroCount++;         
        }

        float positiveRatio = (float)positiveCount / (float)total;
        float negativeRatio = (float)negativeCount / (float)total;
        float zeroRatio = (float)zeroCount / (float)total;

        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(5);

        System.out.println(df.format(positiveRatio));
        System.out.println(df.format(negativeRatio));
        System.out.println(df.format(zeroRatio));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
