/*Leetcode-3736. Minimum Moves to Equal Array Elements III
You are given an integer array nums.

In one move, you may increase the value of any single element nums[i] by 1.

Return the minimum total number of moves required so that all elements in nums become equal.

Example 1:
Input: nums = [2,1,3]
Output: 3
Explanation:
To make all elements equal:
Increase nums[0] = 2 by 1 to make it 3.
Increase nums[1] = 1 by 1 to make it 2.
Increase the updated nums[1] = 2 by 1 to make it 3.
Now, all elements of nums are equal to 3. The minimum total moves is 3.

Example 2:
Input: nums = [4,4,5]
Output: 2
Explanation:
To make all elements equal:
Increase nums[0] = 4 by 1 to make it 5.
Increase nums[1] = 4 by 1 to make it 5.
Now, all elements of nums are equal to 5. The minimum total moves is 2.

Constraints:
1 <= nums.length <= 100
1 <= nums[i] <= 100
*/


import java.util.*;
class Solution {
    public int minMoves(int[] nums) {
        int maxEl = Arrays.stream(nums).max().getAsInt();
        
        int moves = 0;
        for (int num : nums) {
            moves += maxEl - num;
        }
        /*
            Or you can do it like this : 
            moves = (maxEl - nums[0]) + (maxEl - nums[1]) + .....
            moves = (maxEl + maxEl + ...) - (nums[0] + nums[1] + ...)
            
            Final moves = n*maxEl - sum(nums);
        */
        
        return moves;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};

        Solution obj = new Solution();
        int ans = obj.minMoves(nums);

        System.out.println("Output: " + ans);
    }
}