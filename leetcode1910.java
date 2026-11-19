/*Leetcode-1910. Remove All Occurrences of a Substring
Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:

Find the leftmost occurrence of the substring part and remove it from s.
Return s after removing all occurrences of part.

A substring is a contiguous sequence of characters in a string.

Example 1:
Input: s = "daabcbaabcbc", part = "abc"
Output: "dab"
Explanation: The following operations are done:
- s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
- s = "dababc", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".

Example 2:
Input: s = "axxxxyyyyb", part = "xy"
Output: "ab"
Explanation: The following operations are done:
- s = "axxxxyyyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axxxyyyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "axxyyb", remove "xy" starting at index 2 so s = "axyb".
- s = "axyb", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".

Constraints:
1 <= s.length <= 1000
1 <= part.length <= 1000
s​​​​​​ and part consists of lowercase English letters.
 */
class Solution {
    //method-1
    // public String removeOccurrences(String s, String part) {
    //     StringBuilder result = new StringBuilder();
    //     int n = s.length();
    //     int m = part.length();

    //     for(int i=0; i<n; i++){
    //         result.append(s.charAt(i));

    //         if(result.length() >= m){
    //             String sub = result.substring(result.length()-m);
    //             if(sub.equals(part)){
    //                 result.setLength(result.length() - m);
    //             }
    //         }
    //     }
    //     return result.toString();
    // }

    // Method-2
    public String removeOccurrences(String s, String part) {
        // flow the 2 step till part exist in s string
        while(s.contains(part)){
            //search part inside s
            int index = s.indexOf(part);
            //create a new string by merging the left and right part of substring inside s string
            s = s.substring(0, index) + s.substring(index + part.length());
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc";
        String part = "abc";

        Solution obj = new Solution();

        String ans = obj.removeOccurrences(s, part);

        System.out.println("Output: " + ans);
    }
}