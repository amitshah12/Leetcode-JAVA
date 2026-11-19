package GFG;

class Solution {
    public static char getMaxOccuringChar(String s) {
        // code here
        int[] freq = new int[26];
        
        //traverse over string and update their frequency accoringly
        for(int i=0; i<s.length(); i++){
            char currChar = s.charAt(i);
            freq[currChar - 'a']++;
        }
        
        int maxFreq = -1;
        char ans = 'a';
        
        //traverse over the freq array and get the highest freq wala element
        for(int i=0; i<26; i++){
            if(freq[i]>maxFreq){
                maxFreq = freq[i];
                ans = (char)(i+'a');
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // String s = "testsample";
        String s = "output";

        // Solution obj = new Solution();

        char ans = Solution.getMaxOccuringChar(s);

        System.out.println("Output: " + ans);
    }
}
