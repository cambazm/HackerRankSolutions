import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.HashMap; 
import java.util.Map; 

public class Solution {

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int aliceSum = 0;
        int ranking = 1;
        int lastScore = 0;
        List<Integer> response = new ArrayList<Integer>();
        HashMap<Integer, Integer> hmap = new HashMap<>(); 
        
        for(int i=0; i<scores.length; i++) {
            if(i == 0) {
                lastScore = scores[i];
                hmap.put(ranking, scores[i]);
            }
            else {
                if(lastScore == scores[i]) {
                    hmap.put(ranking, scores[i]);
                }
                else {
                    ranking++;
                    hmap.put(ranking, scores[i]);
                    lastScore = scores[i];
                }
            }
        }
        int row = 0;
        int alicesRanking = -1;
        int currentRanking = 0;
        for(int i=0; i<alice.length; i++) {
            aliceSum = alice[i];
            Set set = hmap.entrySet();
            Iterator iterator = set.iterator();
            while(iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = (Map.Entry)iterator.next();
                row = (int)entry.getValue();
                currentRanking = (int)(entry.getKey());
                if(aliceSum >= row) {
                    if(aliceSum == row) {
                        alicesRanking = currentRanking;
                        response.add(alicesRanking);
                        break;
                    }
                    else {
                        alicesRanking = currentRanking;
                        response.add(alicesRanking);
                        break;
                    }
                }
            }  
            if(alicesRanking == -1) {
                alicesRanking = currentRanking+1;
                response.add(alicesRanking);
            } 
        }       
        return convertIntegers(response);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

