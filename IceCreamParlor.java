import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        int remaining = 0;
        int firstValue = 0;
        int secondValue = 0;
        int firstIndex = 0;
        int secondIndex = 0;
        int[] response;
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        for(int i=0; i<arr.length; i++) {
            h.put(arr[i], i);
        }
        System.out.println("m="+m);
        int[] arrCopy = arr;
        Arrays.sort(arr);
        PrintArr(arr);
        for(int i=0; i<arr.length; i++) {
            firstValue = arr[i];
            remaining = m - firstValue;
            secondValue = Find(arr, i+1, remaining);           
            if(secondValue > 0) {
                if(firstValue == secondValue) {
                    int duplicatesFound = 0;
                    for(i=0; i<arrCopy.length; i++) {
                        if(arrCopy[i] == firstValue) {
                            firstIndex = i+1;
                            duplicatesFound++;
                            for(int j=i+1; j<arrCopy.length; j++) {
                                if(arrCopy[j] == firstValue) {
                                    secondIndex = j+1;
                                    return new int[] { firstIndex, secondIndex };
                                }
                            }
                        }
                    }
                }
                else {
                    firstIndex = h.get(firstValue)+1;
                    secondIndex = h.get(secondValue)+1; 
                               
                }
                if(firstIndex < secondIndex)
                    return new int[] { firstIndex, secondIndex };
                else
                    return new int[] { secondIndex, firstIndex };
            }
        }
                return new int[] { -1, -1 };
    }
    static int Find(int[] arr, int start, int toFind) {
        for(int i=start; i<arr.length; i++) {
            if(arr[i]==toFind) {
                return arr[i];
            }
        }
        return -1;
    }
    static void PrintArr(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
