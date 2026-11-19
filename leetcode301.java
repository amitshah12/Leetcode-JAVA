import java.util.*;

/*Leetcode-301. Remove Invalid Parentheses
Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.

Return a list of unique strings that are valid with the minimum number of removals. You may return the answer in any order.

Example 1:
Input: s = "()())()"
Output: ["(())()","()()()"]

Example 2:
Input: s = "(a)())()"
Output: ["(a())()","(a)()()"]

Example 3:
Input: s = ")("
Output: [""]

Constraints:
1 <= s.length <= 25
s consists of lowercase English letters and parentheses '(' and ')'.
There will be at most 20 parentheses in s.
*/

class Solution {
    private Set<String> st = new HashSet<>();
    private int n;
    private int maxLen;

    private void solve(String s, int i, StringBuilder curr, int count) {
        if(count<0) return;

        //base case
        if(i==n){
            if(count==0){
                if(curr.length() > maxLen){
                    maxLen = curr.length();
                    st.clear();
                }

                if(curr.length() == maxLen){
                    st.add(curr.toString());
                }
            }
            return;
        }

        if(s.charAt(i) != ')' && s.charAt(i) != '('){//alphate
            curr.append(s.charAt(i));
            solve(s, i+1, curr, count);
            curr.deleteCharAt(curr.length()-1);
            return;
        }

        curr.append(s.charAt(i));
        solve(s, i+1, curr, count+(s.charAt(i) =='(' ? 1 : -1));

        curr.deleteCharAt(curr.length()-1);
        solve(s, i+1, curr, count);
    }

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        st.clear();

        maxLen = 0;
        String curr = "";

        solve(s, 0, new StringBuilder(), 0);

        return new ArrayList<>(st);
    }

    public static void main(String[] args) {
        String s = "()())()";

        Solution obj = new Solution();
        List<String> ans = obj.removeInvalidParentheses(s);

        System.out.println("Output: " + ans);
    }
}