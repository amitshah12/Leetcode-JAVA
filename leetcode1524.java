class Solution {
    // Method-1 -> Brute force T(n) = O(n^3)
    // public int numOfSubarrays(int[] arr) {
    //     int n = arr.length;
    //     int count = 0;
    //     int M = (int)1e9 + 7;

    //     for(int i=0; i<n; i++){
    //         for(int j=i; j<n; j++){
    //             int sum = 0;
    //             for(int k=i; k<=j; k++){
    //                 sum += arr[k];
    //             }
    //             if(sum % 2 != 0){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count%M;
    // }

    // Method=2 -> Improved Brute force T(n) = O(n^2)
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0;
        int M = (int)1e9 + 7;

        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += arr[j];
                if(sum%2 != 0){
                    count++;
                }    
            }
        }
        return count%M;
    }

    public static void main(String[] args) {
        // int[] arr = {1,3,5};
        // int[] arr = {2,4,6};
        int[] arr = {1,2,3,4,5,6,7};

        Solution obj = new Solution();
        int ans = obj.numOfSubarrays(arr);

        System.out.println("Output: " + ans);
    }
}