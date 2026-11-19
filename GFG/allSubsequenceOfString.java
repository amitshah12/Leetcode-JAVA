package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*GFG Q:- All Subsequences of String
Given a string s, generate all possible subsequences of the string (including the empty subsequence) and return them in lexicographical order.

A subsequence is obtained by deleting zero or more characters from the string without changing the relative order of the remaining characters.

Examples:

Input : s = "abc"
Output: ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Explanation: There are a total of 8 non-empty subsequences for the given string. 
Input: s = "aa"
Output: ["", "a", "a", "aa"]
Constraints:

1 ≤ s.size() ≤ 16
s contains: [a-z].
 */

class Solution{
    static void getAllSubsequences(String s, int index, StringBuilder output, List<String>ans){
        //base case
        if(index >= s.length()){
            //susequence ready
            String subsequence = output.toString();
            ans.add(subsequence);
            return;
        }
        
        //solve 1 case remaining recursion will handle
        
        
        // include-exclude pattern
        char ch = s.charAt(index);
        //include
        output.append(ch);
        getAllSubsequences(s,index+1,output,ans);
        //exclude
        output.deleteCharAt(output.length()-1);
        getAllSubsequences(s,index+1,output,ans);
        
    }
    public List<String> powerSet(String s) {
        // Code here
        List<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        int index = 0;
        
        getAllSubsequences(s, index, output, ans);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        String s = "abc";

        Solution obj = new Solution();
        List<String> ans = obj.powerSet(s);

        System.out.println("Output: "+ ans);
    }
}
