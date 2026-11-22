import java.util.HashMap;
import java.util.Map;

/*Leetcode- 219.Contains Duplicate II
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 10^5
-109 <= nums[i] <= 10^9
0 <= k <= 10^5
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();

        for(int i=0; i<n; i++){
            if(mp.containsKey(nums[i]) && Math.abs(mp.get(nums[i]) -i) <=k){
                return true;
            }else {
                mp.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;

        Solution obj = new Solution();
        boolean ans = obj.containsNearbyDuplicate(nums, k);

        System.out.println("Output: " + ans);
    }
}