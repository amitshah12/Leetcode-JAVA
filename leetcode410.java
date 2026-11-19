/*Leetcode-410. Split Array Largest Sum / Book allocation problem
Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

Return the minimized largest sum of the split.

A subarray is a contiguous part of the array.

Example 1:
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

Example 2:
Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

Constraints:
1 <= nums.length <= 1000
0 <= nums[i] <= 106
1 <= k <= min(50, nums.length)
*/

class Solution{
    boolean isValid(int[] nums, int k, int mid){
        //check if mid is a valid Solution or not
        int count = 1;
        int sum = 0;

        for(int i=0; i<nums.length; i++){
            if(sum+nums[i] <= mid){
                //assign it
                sum += nums[i];
            } else {
                //cannot be assigned as it exids the limit
                count++;
                if(count > k || nums[i]>mid){
                    return false;
                }
                //assign to new student
                sum = nums[i];
            }
        }
        return true;
    }
    public int splitArray(int[] nums, int k){
        int start = 0;
        int sum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            sum += nums[i];
        }

        int end = sum;
        int ans = -1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            if(isValid(nums, k, mid)){
                //true case
                ans = mid;
                end = mid-1;
            } else {
                //false case
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[] nums = {7,2,5,10,8};
        // int k = 2;
        int[] nums = {15,17,20};
        int k = 5;

        Solution obj = new Solution();

        int ans = obj.splitArray(nums, k);

        System.out.println("Output: " + ans);
    }
}