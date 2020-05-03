using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections;
using System.ComponentModel;
using System.Diagnostics.CodeAnalysis;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Reflection;
using System.Runtime.Serialization;
using System.Text.RegularExpressions;
using System.Text;
using System;

class Solution {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k, int n) {
        Array.Sort(prices);
        int currentToysBought = 0;
        int currentTotal = k;
        int currentRemaining = n;
        for(int i=0; i<n; i++) {
            if(prices[i] > k) {
                currentRemaining--;
                continue;
            }
            else {
                if(currentTotal > 0) {
                    if(currentTotal - prices[i] >= 0) {
                        currentToysBought++;
                        currentTotal = currentTotal - prices[i];
                    }
                }
            }
        }
        return currentToysBought;
    }

    static void Main(string[] args) {
        TextWriter textWriter = new StreamWriter(@System.Environment.GetEnvironmentVariable("OUTPUT_PATH"), true);

        string[] nk = Console.ReadLine().Split(' ');

        int n = Convert.ToInt32(nk[0]);

        int k = Convert.ToInt32(nk[1]);

        int[] prices = Array.ConvertAll(Console.ReadLine().Split(' '), pricesTemp => Convert.ToInt32(pricesTemp))
        ;
        int result = maximumToys(prices, k, n);

        textWriter.WriteLine(result);

        textWriter.Flush();
        textWriter.Close();
    }
}
