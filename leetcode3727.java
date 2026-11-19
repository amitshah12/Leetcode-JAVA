import java.util.Arrays;

/*Leetcode-3727. Maximum Alternating Sum of Squares
You are given an integer array nums. You may rearrange the elements in any order.

The alternating score of an array arr is defined as:

score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 + ...
Return an integer denoting the maximum possible alternating score of nums after rearranging its elements.

Example 1:
Input: nums = [1,2,3]
Output: 12
Explanation:
A possible rearrangement for nums is [2,1,3], which gives the maximum alternating score among all possible rearrangements.
The alternating score is calculated as:
score = 22 - 12 + 32 = 4 - 1 + 9 = 12

Example 2:
Input: nums = [1,-1,2,-2,3,-3]
Output: 16
Explanation:
A possible rearrangement for nums is [-3,-1,-2,1,3,2], which gives the maximum alternating score among all possible rearrangements.

The alternating score is calculated as:

score = (-3)2 - (-1)2 + (-2)2 - (1)2 + (3)2 - (2)2 = 9 - 1 + 4 - 1 + 9 - 4 = 16

Constraints:
1 <= nums.length <= 105
-4 * 104 <= nums[i] <= 4 * 104
*/

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int mid = n/2;

        //Finding square of each element and storing in same array
        for(int i=0; i<n; i++){
            nums[i] = nums[i]*nums[i];
        }

        //Sorting array elements
        Arrays.sort(nums);

        //finding sum of 1st half and second half and retuning their difference
        long sum1 = Arrays.stream(nums, 0, mid).asLongStream().sum();
        long sum2 = Arrays.stream(nums, mid, n).asLongStream().sum();

        return sum2 - sum1;
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3};
        int[] nums = {1,-1,2,-2,3,-3};
        // int[] nums = {1,2,3,4,5,6};

        Solution obj = new Solution();
        long ans = obj.maxAlternatingSum(nums);

        System.out.println("Output: " + ans);
    }
}