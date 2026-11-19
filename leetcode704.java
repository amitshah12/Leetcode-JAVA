/*Leetcode-704.Binary Search
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
*/

class Solution {
    int binarySearch(int[] nums, int start, int end, int target){
        //base case
        if(start>end){
            return -1;
        }

        int mid = start + (end-start)/2;
        //element found
        if(nums[mid] == target){
            return mid;
        }

        //processing
        if(nums[mid] < target){
            int index = binarySearch(nums, mid+1, end, target);
            return index;
        } else {
            int index = binarySearch(nums, start, mid-1, target);
            return index;
        }
    }

    public int search(int[] nums, int target) {
        int ans = binarySearch(nums, 0, nums.length-1, target);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        Solution obj = new Solution();

        int ans = obj.search(nums, target);

        System.out.println("Output: " + ans);
    }
}