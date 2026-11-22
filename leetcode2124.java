class Solution {
    // Method-1
    // public boolean checkString(String s) {
    //     int n = s.length();
    //     int aIdx;
    //     int bIdx = n;
        
    //     for(int i=0; i<n; i++){
    //         if(s.charAt(i) == 'a'){
    //             aIdx = i;
    //             if(bIdx < aIdx){
    //                 return false;
    //             }
    //         } else {
    //             bIdx = i;
                
    //         }
    //     }
    //     return true;
    // }
    
    //Method-2
    public boolean checkString(String s) {
        return !s.contains("ba");
    }

    public static void main(String[] args) {
        // String s = "aaabbb";
        String s = "abab";

        Solution obj = new Solution();
        boolean ans = obj.checkString(s);

        System.out.println("Output: " + ans);
    }
}


