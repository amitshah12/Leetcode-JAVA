/*Leetcode-151. Reverse Words in a String
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Constraints:

1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
 */
class Solution {
    // Method-1
    // public String reverseWords(String s) {
    //     int n = s.length();
    //     String ans = "";

    //     String reversed = new StringBuilder(s).reverse().toString();

    //     for(int i=0; i<n; i++){
    //         String word = "";
    //         while(i < n && reversed.charAt(i) != ' '){
    //             word += reversed.charAt(i);
    //             i++;
    //         }

    //         String wordReversed = new StringBuilder(word).reverse().toString();
    //         if(wordReversed.length() > 0){
    //                 ans += " " + wordReversed;
    //         }
    //     }
    //     return ans.substring(1);
    // }

    // Method-2
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        int i = s.length()-1;

        while(i >= 0){
            //remove all the trailing spaces
            while(i>=0 && s.charAt(i) == ' '){
                i--;
            }
            //check value of i
            if(i<0){
                break;
            }
            int j = i;
            //find the start index of the word
            while(j>=0 && s.charAt(j) != ' '){
                j--;
            }
            //
            //
            ans.append(s.substring(j+1, i+1));
            //remove unwanted space
            while(j>=0 && s.charAt(j) == ' '){
                j--;
            }
            
            //j<0, iska matlb first word k upar that main -> no space needed
            if(j >= 0){
                ans.append(' ');
            }
            //place i at last index of the remaining stirng
            i = j;
        }
        return  ans.toString();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";

        Solution obj = new Solution();

        String ans = obj.reverseWords(s);
        
        System.out.println("Output: " + ans);
    }
}