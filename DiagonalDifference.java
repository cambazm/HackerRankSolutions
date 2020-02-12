import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int l = arr.size();
        int colLength = arr.get(0).size();
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;

        for(int i=0; i<l; i++) {
            for(int j=0; j<l; j++) {
                if(i==j) {
                    leftDiagonalSum = leftDiagonalSum + arr.get(i).get(j);
                    //System.out.println("left-"+arr.get(i).get(j));
                }
                if(i+j == colLength-1){
                    rightDiagonalSum = rightDiagonalSum + arr.get(i).get(j);
                    //System.out.println("right-"+arr.get(i).get(j));
                }
            }    
        }
        //System.out.println("leftDiagonalSum-"+leftDiagonalSum);
        //System.out.println("rightDiagonalSum-"+rightDiagonalSum);
        int response = leftDiagonalSum - rightDiagonalSum;
        if(response < 0)
            return -1*response;
        return response;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
