/*Leetcode-334. Increasing Triplet Subsequence
You are given an integer array nums.

Return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.

Example 2:
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.

Example 3:
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: One of the valid triplet is (1, 4, 5), because nums[1] == 1 < nums[4] == 4 < nums[5] == 6.

Constraints:
1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
*/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;
        
        for(int i = 0; i<n; i++) {
            
            int num3 = nums[i];
            
            //first ask num1
            if(num3 <= num1) {
                num1 = num3;
            } else if(num3 <= num2) { //ask num2
                num2 = num3;
            } else { //num1 < num2 inki life set hai already
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3,4,5};
        // int[] nums = {5,4,3,2,1};
        int[] nums = {1,1,1};

        Solution obj = new Solution();
        boolean ans = obj.increasingTriplet(nums);

        System.out.println("Output: " + ans);
    }
}