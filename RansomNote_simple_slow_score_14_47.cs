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

    // Complete the checkMagazine function below.
    static void checkMagazine(string[] magazine, string[] note) {
        int noteCount = 0;
        Dictionary<int, string> magazines = new Dictionary<int, string>();
        for(int i=0; i<magazine.Count(); i++) {
            magazines.Add(i, magazine[i]);
        }
        KeyValuePair<int, string> item = new KeyValuePair<int,string>();
        for(int i=0; i<note.Length; i++) {
            //Console.WriteLine(note[i]);
            try {
                item = magazines.First(m => m.Value.Equals(note[i], StringComparison.CurrentCulture));
                if(item.Key > -1) {
                    magazines.Remove(item.Key);
                    noteCount++;
                }
            }
            catch(Exception ex) {
                Console.WriteLine("No");
                return;
            }
            //Console.WriteLine(item.ToString());
        }
        if(note.Length==noteCount) {
            Console.WriteLine("Yes");
        }
        else {
            Console.WriteLine("No");
        }
    }

    static void Main(string[] args) {
        string[] mn = Console.ReadLine().Split(' ');

        int m = Convert.ToInt32(mn[0]);

        int n = Convert.ToInt32(mn[1]);

        string[] magazine = Console.ReadLine().Split(' ');

        string[] note = Console.ReadLine().Split(' ');

        checkMagazine(magazine, note);
    }
}
