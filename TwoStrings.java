import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static String twoStrings(String s1, String s2) {

        final String Y = "YES";
        final String N = "NO";
        
        HashSet<Character> s = new HashSet<Character>();

        int i;
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        if(s1Chars.length < s2Chars.length) {
            for(i=0; i<s1Chars.length; i++) {
                s.add(s1Chars[i]);
            }
            for(i=0; i<s2Chars.length; i++) {
                if(s.contains(s2Chars[i]))
                    return Y;
            }
        }
        else {
            for(i=0; i<s2Chars.length; i++) {
                s.add(s2Chars[i]);
            }
            for(i=0; i<s1Chars.length; i++) {
                if(s.contains(s1Chars[i]))
                    return Y;
            }
        }
        return N;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
