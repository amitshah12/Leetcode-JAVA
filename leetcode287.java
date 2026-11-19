import java.util.HashMap;
/*Leetcode-287. Find the Duplicate Number
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.

Example 1:
Input: nums = [1,3,4,2,2]
Output: 2

Example 2:
Input: nums = [3,1,3,4,2]
Output: 3

Example 3:
Input: nums = [3,3,3,3,3]
Output: 3

Constraints:
1 <= n <= 105
nums.length == n + 1
1 <= nums[i] <= n
All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
class Solution {
    // Method-1 brute force
    /*
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int result;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }
     */

    // Method-2
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        for(int i : nums){
            if(freq.get(i)>1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};

        Solution obj = new Solution();
        int ans = obj.findDuplicate(nums);

        System.out.println("Output: " + ans);
    }
}