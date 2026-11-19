class Solution {
    /*Leetcode-189-Rotate Array
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

    Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]
    
    Example 2:
    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation: 
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]
    
    Constraints:
    1 <= nums.length <= 105
    -231 <= nums[i] <= 231 - 1
    0 <= k <= 105
     */

    // Method-1
    // public void rotate(int[] nums, int k) {
    //     int n =  nums.length;

    //     int[] temp = new int[n];
    //     for(int i = 0; i<n; i++){
    //         temp[(i+k) % n] = nums[i];
    //     }
        
    //     for(int i = 0; i < n; i++){
    //         nums[i] = temp[i];
    //     }
    // }

    // Method-2
    void reverse(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        if(k==0){
            return;
        }

        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        Solution obj = new Solution();
        obj.rotate(nums, k);

        System.out.print("Output: {");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]);
            if(i < nums.length - 1) System.out.print(",");
        }
        System.out.println("}");
    }
}