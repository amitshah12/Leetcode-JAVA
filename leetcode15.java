import java.util.ArrayList;
import java.util.List;
import java.util.*;

/*Leetcode-15. 3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 
Constraints:
3 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
*/

class Solution{
    //Method-1
    List<List<Integer>> result = new ArrayList<>();

    void twoSum(int[] nums, int target, int i, int j){
        Integer[] ans;
        while(i<j){
            if(nums[i]+nums[j] > target){
                j--;
            } else if(nums[i]+nums[j] < target){
                i++;
            } else {
                while(i<j && nums[i] == nums[i+1]){
                    i++;
                }
                while(i<j && nums[j] == nums[j-1]){
                    j--;
                }

                ans = new Integer[]{-target, nums[i], nums[j]};
                result.add(Arrays.asList(ans));
                i++;
                j--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;

        if(n<3){
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        for(int i=0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }

            int n1 = nums[i];
            int target = -n1;

            twoSum(nums, target, i+1, n-1);
        }
        return result;
    }


    //Method-2 ->brute force my get TLE
    // public List<List<Integer>> threeSum(int[] nums) {
    //     Set<List<Integer>> result = new HashSet<>();
    //     int n = nums.length;

    //     for(int i=0; i<n-2; i++){
    //         for(int j=i+1; j<n-1; j++){
    //             for(int k=j+1; k<n; k++){
    //                 if(nums[i]+nums[j]+nums[k]==0){
    //                     List<Integer> Output = new ArrayList<>();
    //                     Output.add(nums[i]);
    //                     Output.add(nums[j]);
    //                     Output.add(nums[k]);
    //                     Collections.sort(Output);
    //                     result.add(Output);
    //                 }
    //             }
    //         }
    //     }
    //     return new ArrayList<>(result);
    // }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};

        Solution obj = new Solution();

        List<List<Integer>> result =obj.threeSum(nums);

        System.out.println("Output: " + result);
    }
}