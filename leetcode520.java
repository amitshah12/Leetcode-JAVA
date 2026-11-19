/* Leetcode - 520. Detect Capital
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:
Input: word = "USA"
Output: true

Example 2:
Input: word = "FlaG"
Output: false

Constraints:
1 <= word.length <= 100
word consists of lowercase and uppercase English letters.
*/
class Solution {
    boolean allCapital(String word){
        for(char ch : word.toCharArray()){
            if(ch < 'A' || ch > 'Z'){
                return false;
            }
        }
        return true;
    }

    boolean allSmall(String word){
        for(char ch : word.toCharArray()){
            if(ch < 'a' || ch < 'z'){
                return false;
            }
        }
        return true;
    }

    public boolean detectCapitalUse(String word) {
        if(allCapital(word) || allSmall(word) || allSmall(word.substring(1))){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // String word = "USA";
        String word = "FlaG";

        Solution obj = new Solution();
        boolean ans = obj.detectCapitalUse(word);

        System.out.println("Output: " + ans);
    }
}