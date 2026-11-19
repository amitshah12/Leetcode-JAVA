import java.util.Arrays;

/*Leetcode-1657. Determine if Two Strings Are Close
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

Example 1:
Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"

Example 2:
Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.

Example 3:
Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
 
Constraints:
1 <= word1.length, word2.length <= 105
word1 and word2 contain only lowercase English letters.
*/

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        if(m != n) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        //finding frequency of character in word1 and word2
        for(int i=0; i<m; i++){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            int idx1 = ch1 - 'a';
            int idx2 = ch2 - 'a';

            freq1[idx1]++;
            freq2[idx2]++;
        }

        //1st point -> char present in word1 should also be present in word2
        for(int i=0; i<26; i++){
            if(freq1[i] != 0 && freq2[i] != 0) continue;

            if(freq1[i] == 0 && freq2[i] == 0) continue;

            return false;
        }

        //2nd point -> match the frequency
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        // String word1 = "abc";
        // String word2 = "bca";
        
        // String word1 = "a";
        // String word2 = "aa";
        
        String word1 = "cabbba";
        String word2 = "abbccc";

        Solution obj = new Solution();
        boolean ans = obj.closeStrings(word1, word2);

        System.out.println("Output: " + ans);
    }
}