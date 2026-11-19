import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int n = nums.length;
        int closestSum = 100000;

        for(int i=0; i<n-2; i++){
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                
                if(Math.abs(target-sum) <  Math.abs(target-closestSum)){
                    closestSum = sum;
                }

                if(sum<target){
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        // int[] nums = {0,0,0};
        // int target = 1;
        // int[] nums = {10,20,30,40,50,60,70,80,90};
        // int target = 1;

        Solution obj = new Solution();
        int ans = obj.threeSumClosest(nums, target);

        System.out.println("Output: " + ans);
    }
}