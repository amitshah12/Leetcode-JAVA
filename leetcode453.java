import java.util.Arrays;

/*Leetcode-453. Minimum Moves to Equal Array Elements
You are given an integer array nums of size n.

Return the minimum number of moves required to make all array elements equal.

In one move, you must increment n - 1 elements of the array by 1.

Example 1:
Input: nums = [1,2,3]
Output: 3
Explanation: Only three moves are needed (remember each move increments two elements):
[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

Example 2:
Input: nums = [1,1,1]
Output: 0

Constraints:
n == nums.length
1 <= nums.length <= 105
-109 <= nums[i] <= 109
The answer is guaranteed to fit in a 32-bit integer.
*/

class Solution {
    //Method-1
    // public int minMoves(int[] nums) {
    //     int opr = 0;
        
    //     int minElement = Arrays.stream(nums).min().getAsInt();

    //     for(int num : nums){
    //         opr += (num - minElement);
    //     }
    //     return opr;
    // }

    //Method -2
    public int minMoves(int[] nums) {
        int n = nums.length;

        long sum = 0;
        // for(int num : nums){
        //     sum += num;
        // }
        sum = Arrays.stream(nums).sum();

        int minE1 = Integer.MAX_VALUE;
        for(int x : nums){
            minE1 = Math.min(minE1, x);
        }

        return (int) (sum-(long) n * minE1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        Solution obj = new Solution();
        int ans = obj.minMoves(nums);

        System.out.println("Output: " + ans);
    }
}