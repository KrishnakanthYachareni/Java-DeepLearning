```java
package com.epam.algo;

/**
 * @author Krishnakanth
 *
 */
public class SubStringPalindrome {

    public String subPalindrome(String str, int start, int end, int key) {
        String subStr = str.substring(start, end);
        if (key >= subStr.length() && subStr.length() != 0) {
            return "1";
        }
        if (minimumNumberOfDeletions(subStr) <= key) {
            return "1";
        } else
            return "0";
    }

    // Returns the length of the longest
    // palindromic subsequence in 'str'
    static int lps(String str) {
        int n = str.length();

        // Create a table to store
        // results of subproblems
        int L[][] = new int[n][n];

        // Strings of length 1
        // are palindrome of length 1
        for (int i = 0; i < n; i++)
            L[i][i] = 1;

        // Build the table. Note that the lower diagonal
        // values of table are useless and not filled in
        // the process. c1 is length of substring
        for (int cl = 2; cl <= n; cl++) {
            for (int i = 0; i < n - cl + 1; i++) {
                int j = i + cl - 1;
                if (str.charAt(i) == str.charAt(j) && cl == 2)
                    L[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j))
                    L[i][j] = L[i + 1][j - 1] + 2;
                else
                    L[i][j] = Integer.max(L[i][j - 1], L[i + 1][j]);
            }
        }

        // length of longest palindromic subsequence
        return L[0][n - 1];
    }

    // function to calculate minimum
    // number of deletions
    static int minimumNumberOfDeletions(String str) {
        int n = str.length();

        // Find longest palindromic subsequence
        int len = lps(str);

        // After removing characters other than
        // the lps, we get palindrome.
        return (n - len);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "aa";
        SubStringPalindrome stringPalindrome = new SubStringPalindrome();

        String pattern = stringPalindrome.subPalindrome(str, 0, 1, 2);
        System.out.println(pattern);
    }

}
```