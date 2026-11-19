import java.util.Stack;

/*Leetcode-678. Valid Parenthesis String
Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

->Any left parenthesis '(' must have a corresponding right parenthesis ')'.
->Any right parenthesis ')' must have a corresponding left parenthesis '('.
->Left parenthesis '(' must go before the corresponding right parenthesis ')'.
->'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "(*)"
Output: true

Example 3:
Input: s = "(*))"
Output: true

Example 4:
Input: s = "("
Output: false

Constraints:
1 <= s.length <= 100
s[i] is '(', ')' or '*'.
*/
class Solution {
    public boolean checkValidString(String s) {
        char[] temp = s.toCharArray();
        int n = temp.length;
        Stack<Integer> st = new Stack<>();
        Stack<Integer> tp = new Stack<>();

        for(int i=0; i<n; i++){
            if(temp[i] == '('){
                st.push(i);
            } else if(temp[i] == '*'){
                tp.push(i);
            } else if(temp[i] == ')'){
                if(!st.empty()){
                    st.pop();
                } else if(!tp.empty()){
                    tp.pop();
                } else {
                    return false;
                }
            }
        }
        
        
        while(!tp.empty() && !st.empty()){
            if(st.peek() > tp.peek()){
                return false;
            }
            st.pop();
            tp.pop();
        }
        return st.empty();
    }

    public static void main(String[] args) {
        // String s = "()";
        // String s = "(*)";
        // String s = "(*))";
        // String s = "(";
        String s = "*(())(*";

        Solution obj = new Solution();
        boolean ans = obj.checkValidString(s);

        System.out.println("Output: " + ans);
    }
}