/*Leetcode-567. Permutation in String
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Constraints:
1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/

class Solution {
    static boolean compareFreq(int[] count1, int[] count2){
        for(int i=0; i<26; i++){
            if(count1[i] != count2[i]){
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        //algo wise
        if(s1.length() > s2.length()){
            return  false;
        }

        //s1 freq table
        int count1[] = new int[26];
        for(int i=0; i<s1.length(); i++){
            char ch = s1.charAt(i);
            int index = ch-'a';
            count1[index]++;
        }

        int i = 0;
        int windowLength = s1.length();
        int count2[] = new int[26];
        //first window freq table
        for(i=0; i<windowLength; i++){
            char ch = s2.charAt(i);
            int index = ch -'a';
            count2[index]++;
        }

        if(compareFreq(count1, count2) == true){
            return true;
        } else {
            //both the freq tables are not matching
            //process remaining windows
            while(i < s2.length()){
                //if moving to the new windows then add new char to freq table
                char newChar = s2.charAt(i);
                int newCharIndx = newChar-'a';
                count2[newCharIndx]++;
                //remove old char entry form table
                int oldCharIndex = i - windowLength;
                char oldChar = s2.charAt(oldCharIndex);
                int freqTableIndexOfOldChar = oldChar - 'a';
                count2[freqTableIndexOfOldChar]--;
                
                //now you have updated table
                //compare new freq with reference of s1 table
                if(compareFreq(count1, count2) == true){
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // String s1 = "ab";
        // String s2 = "eidbaooo";

        String s1 = "ab";
        String s2 = "eidboaooo";

        Solution obj = new Solution();
        boolean ans = obj.checkInclusion(s1, s2);

        System.out.println("Output: " + ans);
    }
}