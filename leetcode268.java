class Solution{
    /*Leetcode -268. Missing Number
    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    Example 1:
    Input: nums = [3,0,1]
    Output: 2
    Explanation:
    n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

    Example 2:
    Input: nums = [0,1]
    Output: 2
    Explanation:
    n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

    Example 3:
    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation:
    n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

    Constraints:
    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    All the numbers of nums are unique.
    */
   
    // Method-1
    // public int missingNumber(int[] nums){
    //     int xorSum = 0;
        
    //     //XOR with all the array element
    //     for(int n : nums){
    //         xorSum = xorSum ^ n;
    //     }
    //     int n = nums.length;
    //     //XOR with all the elements in the range
    //     for(int i=0; i<=n; i++){
    //         xorSum = xorSum ^ i;
    //     }
    //     return  xorSum;
    // }

    // Method-2
    public int missingNumber(int[] nums){
        int n = nums.length;
        int numSum = 0;
        int sum = 0;

        for(int num:nums){
            numSum += num;
        }

        for(int i=0; i<=n; i++){
            sum += i;
        }
        return sum - numSum;
    }
    
    public static void main(String[] args) {
        int[] nums = {5,6,0,2,4,1,8,7};

        Solution obj = new  Solution();

       int ans = obj.missingNumber(nums);
        
       System.out.println("Missing numeber is: " + ans);

    }
}