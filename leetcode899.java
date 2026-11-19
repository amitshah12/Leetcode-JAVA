import java.util.Arrays;

/*Leetcode-899. Orderly Queue
You are given a string s and an integer k. You can choose one of the first k letters of s and append it at the end of the string.

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

Example 1:
Input: s = "cba", k = 1
Output: "acb"
Explanation: 
In the first move, we move the 1st character 'c' to the end, obtaining the string "bac".
In the second move, we move the 1st character 'b' to the end, obtaining the final result "acb".

Example 2:
Input: s = "baaca", k = 3
Output: "aaabc"
Explanation: 
In the first move, we move the 1st character 'b' to the end, obtaining the string "aacab".
In the second move, we move the 3rd character 'c' to the end, obtaining the final result "aaabc".

Constraints:
1 <= k <= s.length <= 1000
s consist of lowercase English letters.
*/

class Solution {
    public String orderlyQueue(String s, int k) {
        // When k == 1, only rotations are possible
        if(k==1){
            String result = s;
            for(int i=1; i<=s.length()-1; i++){
                String temp =  s.substring(i) + s.substring(0, i); //substring(i)->takes the string from index 1 to the end, substring(0,i)->takes characters from index 0 up to, but not including, index i
                
                if(temp.compareTo(result)<0){
                    result = temp;
                }
            }
            return result;
        }

        //if k>1 simply sort the string character
        char[] str = s.toCharArray();
        Arrays.sort(str);

        return new String(str);

    }

    public static void main(String[] args) {
        // String s = "cba";
        // int k = 1;
        String s = "baaca";
        int k = 3;

        Solution obj = new Solution();
        String ans = obj.orderlyQueue(s, k);

        System.out.println("Output: " + ans);
    }
}