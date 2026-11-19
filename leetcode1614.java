import java.util.Stack;

/*Leetcode- 1614. Maximum Nesting Depth of the Parentheses
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
Explanation:
Digit 8 is inside of 3 nested parentheses in the string.

Example 2:
Input: s = "(1)+((2))+(((3)))"
Output: 3
Explanation:
Digit 3 is inside of 3 nested parentheses in the string.

Example 3:
Input: s = "()(())((()()))"
Output: 3

Constraints:
1 <= s.length <= 100
s consists of digits 0-9 and characters '+', '-', '*', '/', '(', and ')'.
It is guaranteed that parentheses expression s is a VPS.
*/

class Solution {
    // Method-1
    // public int maxDepth(String s) {
    //     Stack<Character> st = new Stack<>();

    //     int result = 0;
    //     for(int i=0; i<s.length(); i++){
    //         if(s.charAt(i) == '('){
    //             st.push(s.charAt(i));
    //         } else if(s.charAt(i) == ')'){
    //             st.pop();
    //         }
    //         result = Math.max(result, st.size());
    //     }
    //     return result;
    // }

    // Method-2
    public int maxDepth(String s) {
        int openBracket = 0;
        int result = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                openBracket++;
            } else if(s.charAt(i) == ')'){
                openBracket--;
            }
            result = Math.max(openBracket, result);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        Solution obj = new Solution();

        int ans = obj.maxDepth(s);

        System.out.println("Output: " + ans);
    }
}