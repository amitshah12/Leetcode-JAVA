/*Leetcode-985. Sum of Even Numbers After Queries
You are given an integer array nums and an array queries where queries[i] = [vali, indexi].

For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.

Return an integer array answer where answer[i] is the answer to the ith query.

Example 1:
Input: nums = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation: At the beginning, the array is [1,2,3,4].
After adding 1 to nums[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to nums[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to nums[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to nums[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

Example 2:
Input: nums = [1], queries = [[4,0]]
Output: [0]
 
Constraints:
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
1 <= queries.length <= 10^4
-10^4 <= vali <= 10^4
0 <= indexi < nums.length
*/

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        int sumEven = 0;
        for(int num : nums){
            if(num % 2 == 0){
                sumEven += num;
            }
        }

        int[] result = new int[q];

        for(int i=0; i<q; i++){
            int val = queries[i][0];
            int idx = queries[i][1];

            if(nums[idx]%2 == 0){
                sumEven -= nums[idx];
            }

            nums[idx] += val;

            if(nums[idx]%2 == 0){
                sumEven += nums[idx];
            }

            result[i] = sumEven;
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3,4};
        // int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};

        Solution obj = new Solution();
        int[] ans = obj.sumEvenAfterQueries(nums, queries);

        System.out.print("Output: {");
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]);
            if(i<ans.length-1){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}