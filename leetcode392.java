/*Leetcode-392. Is Subsequence
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false

Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
*/

import java.util.*;

class Solution {
    // Method-1
    // public boolean isSubsequence(String s, String t) {
    //     int m = s.length();
    //     int n = t.length();

    //     int i = 0;
    //     int j = 0;
    //     while(i<m && j<n){
    //         if(s.charAt(i) == t.charAt(j)){
    //             i++;
    //             j++;
    //         } else {
    //             j++;
    //         }
    //     }

    //     if(i==m){
    //         return true;
    //     }
    //     return false;
    // }
    public boolean isSubsequence(String s, String t) {
        Map<Character, List<Integer>> idx = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            // computeIfAbsent fetches the list or creates a new ArrayList if it doesn't exist
            idx.computeIfAbsent(t.charAt(i), k -> new ArrayList<>()).add(i);
        }

        int prev = -1;
        for(char ch : s.toCharArray()){
            if(!idx.containsKey(ch)){
                return false;
            }

            List<Integer>indices = idx.get(ch);
            int index = Collections.binarySearch(indices, prev+1);

            if(index<0){
                index = -index-1;
            }

            if(index == indices.size()){
                return false;
            }

            prev = indices.get(index);
        }
        return true;
    }

    public static void main(String[] args) {
        // String s = "abc";
        // String t = "ahbgdc";
        String s = "axc";
        String t = "ahbgdc";

        Solution obj = new Solution();
        boolean ans = obj.isSubsequence(s, t);

        System.out.println("Output: " + ans);
    }
}