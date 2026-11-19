import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Leetcode- 49.Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
*/

class Solution {
    //Method-1
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     Map<String, List<String>> mp = new HashMap<>();
    //     for(String str : strs){
    //         char[] temp = str.toCharArray();
    //         Arrays.sort(temp);

    //         String sorted = new String(temp);

    //         // mp.put(sorted, new ArrayList<>());
    //         mp.computeIfAbsent(sorted, key -> new ArrayList<>()).add(str);
    //     }
    //     return new ArrayList<>(mp.values());
    // }

    //Method-2
    String generate(String word){
        int[] arr = new int[26];

        for(char ch : word.toCharArray()){
            arr[ch-'a']++;
        }

        StringBuilder new_word = new StringBuilder();
        for(int i=0; i<26; i++){
            if(arr[i]>0){
                new_word.append(String.valueOf((char)(i+'a')).repeat(arr[i]));
            }
        }
        return new_word.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            String word = strs[i];

            String new_word = generate(word);

            mp.computeIfAbsent(new_word, key-> new ArrayList<>()).add(word);
        }

        return  new ArrayList<>(mp.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        Solution obj = new Solution();
        List<List<String>> ans = obj.groupAnagrams(strs);

        System.out.println("Output: " + ans);
    }
}