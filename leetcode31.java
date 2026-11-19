import java.util.Arrays;
import java.util.Collections;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;

        //1. find the pivot
        for(int i=n-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        //2. if element are arranged in decending order i.e pivot is still -1
        if(pivot == -1){
            int left = 0;
            int right = nums.length-1;

            while(left<right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
            return;
        }

        // 3. Find the smallest element greater than nums[pivot]
        //    from the right side
        for(int i=n-1; i>pivot; i--){
            if(nums[i]>nums[pivot]){
                int temp = nums[i];
                nums[i] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }

        // 4. Reverse the suffix
        int i = pivot+1;
        int j = n-1;
        while(i<=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        // int[] nums = {1,2,3};
        int[] nums = {3,2,1};

        Solution obj = new Solution();
        obj.nextPermutation(nums);

        System.out.print("Output: {");
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]);
            if(i<nums.length-1){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}