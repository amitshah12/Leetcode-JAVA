/*Leetcode-1832. Check if the Sentence Is Pangram
A pangram is a sentence where every letter of the English alphabet appears at least once.

Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Example 1:
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.

Example 2:
Input: sentence = "leetcode"
Output: false

Constraints:
1 <= sentence.length <= 1000
sentence consists of lowercase English letters.
*/
class Solution {
    // Method-1
    // public boolean checkIfPangram(String sentence) {
    //     int[] arr = new int[26];
    //     for(char ch : sentence.toCharArray()){
    //         int index = ch - 'a';
    //         arr[index]++;
    //     }

    //     for(int count : arr){
    //         if(count == 0){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    //Method-2
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        int count = 0;
        for(char ch : sentence.toCharArray()){
            int index = ch - 'a';
            
            if(arr[index] == 0){
                arr[index]++;
                count++;
            }
        }

        if(count==26){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        // String sentence = "leetcode";

        Solution obj = new Solution();
        boolean ans = obj.checkIfPangram(sentence);

        System.out.println("Output: " + ans);
    }
}