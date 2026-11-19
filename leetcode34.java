/*Leetcode-34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Example 2:
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Example 3:
Input: nums = [], target = 0
Output: [-1,-1]
 
Constraints:
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9
*/

class Solution {
    int getLowerBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int leftIndex = -1;
        
        while(s<=e){
            int mid = s + (e-s)/2;
            if(target == arr[mid]){
                //store leftIndex
                leftIndex = mid;
                //move to left
                e = mid - 1;
            } else if(target<arr[mid]){
                e = mid - 1;
            } else {
                //right move
                s = mid + 1;
            }
        }
        return leftIndex;
    }

    int getUpperBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int rightIndex = -1;
        
        while(s<=e){
            int mid = s + (e-s)/2;
            if(target == arr[mid]){
                //move to right
                rightIndex = mid;
                s = mid+1;
            } else if(target < arr[mid]){
                //store rightIndex
                e = mid - 1; 
            } else {
                s = mid+1;
            }
        }
        return rightIndex;
    }

    // int countFreq(int[] arr, int target) {
    //     // code here
    //     int ans = getUpperBound(arr, target) - getLowerBound(arr, target);
    //     return  ans;
    // }
    int[] searchRange(int[] nums, int target) {

        return new int[]{getLowerBound(nums, target), getUpperBound(nums, target)}; 
    }

    public static void main(String[] args) {
        // int[] arr = {1, 1, 2, 2, 2, 2, 3};
        // int target = 2;

        int[] arr = {5,7,7,8,8,10};
        int target = 8;

        // int[] arr = {5,7,7,8,8,10};
        // int target = 6;

        // int[] arr = {};
        // int target = 0;

        Solution obj = new Solution();

        int lower = obj.getLowerBound(arr, target);
        int upper = obj.getUpperBound(arr, target);
        // int ans = obj.countFreq(arr, target);
        int[] ans = obj.searchRange(arr, target);



        System.out.println("Lower: " + lower);
        System.out.println("Upper: " + upper);
        // System.out.println("Output: " + ans);
        System.out.print("Output: {" + ans[0]);
        System.out.print("," + ans[1]+"}");

    }
}
