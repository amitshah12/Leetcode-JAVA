class Solution {
    //Method -1
    // public int minChanges(String s) {
    //     int n = s.length();
    //     int count = 0;
    //     int change = 0;
    //     char curr = s.charAt(0);

    //     for(int i=0; i<n; i++){
    //         if(s.charAt(i) == curr){
    //             count++;
    //             continue;
    //         }

    //         //current char is not equal to s.charAt(i)
    //         if(count % 2 == 0){//even
    //             count = 1;
    //         } else {//odd
    //             //s.charAt(i) needs to change to make even substring length
    //             count = 0;
    //             change++;
    //         }
    //         curr = s.charAt(i);
    //     }
    //     return change;
    // }

    // Method-2
    public int minChanges(String s) {
        int n = s.length();
        int count = 0;

        for(int i=0; i<n; i+=2){
            if(s.charAt(i) != s.charAt(i+1)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "1001";

        Solution obj = new Solution();
        int ans = obj.minChanges(s);

        System.out.println("Output: " + ans);
    }
}