import java.util.Stack;

/*Leetcode-1047. Remove All Adjacent Duplicates In String
You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

Example 1:
Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".

Example 2:
Input: s = "azxxzy"
Output: "ay"
 
Constraints:
1 <= s.length <= 105
s consists of lowercase English letters.
*/

class Solution {
    //Method-1
    // public String removeDuplicates(String s) {
    //     Stack<Character> st = new Stack<>();
    //     String result = "";

    //     for(int i=s.length()-1; i>=0; i--){
    //         if(st.empty() || st.peek() != s.charAt(i)){
    //             st.add(s.charAt(i));
    //         } else {
    //             st.pop();
    //         }
    //     }

    //     while(!st.empty()){
    //         result += st.peek();
    //         st.pop();
    //     }
    //     return result;
    // }

    // Method-2
    // public String removeDuplicates(String s) {
    //     String result = "";

    //     for(int i = 0; i<s.length(); i++){
    //         if(result.isEmpty() || result.charAt(result.length() - 1) != s.charAt(i)){
    //             result += s.charAt(i);
    //         } else if(result.charAt(result.length()-1) == s.charAt(i)){
    //             result = result.substring(0, result.length() - 1);
    //         }
    //     }
    //     return result;
    // }

    //Method-3 -> using string Builder
    // public String removeDuplicates(String s) {
    //     String result = "";

    //     for(int i = 0; i<s.length(); i++){
    //         if(result.isEmpty() || result.charAt(result.length() - 1) != s.charAt(i)){
    //             result += s.charAt(i);
    //         } else if(result.charAt(result.length()-1) == s.charAt(i)){
    //             result = result.substring(0, result.length() - 1);
    //         }
    //     }
    //     return result;
    // }

    //Method-4
    public String removeDuplicates(String s) {
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            //compare ans rightmost char with current char of s
            if(ans.length()>0 && ans.charAt(ans.length()-1) == ch){
                ans.deleteCharAt(ans.length()-1);
            } else {
                // char does not match then append
                ans.append(ch);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        // String s = "abbaca";
        String s = "abccbccba";

        Solution obj = new Solution();

        String ans = obj.removeDuplicates(s);

        System.out.println("Output: " + ans);
    }
}