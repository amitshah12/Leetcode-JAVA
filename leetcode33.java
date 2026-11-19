class Solution {
    public int getPivot(int[] nums){//finds the index of the smallest element.
        int s = 0;
        int e = nums.length-1;

        while(s<e){
            int mid = s + (e-s)/2;
            if(nums[mid] >= nums[0]){
                s = mid+1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    // searches for the target in the appropriate sorted half.
    public  int binarySearch(int[] nums, int s, int e, int target){
        int start = s;
        int end = e;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        return -1;

        
    }

    public int search(int[] nums, int target) {
        int pivot = getPivot(nums);

        if(target >= nums[pivot] && target <= nums[nums.length-1]){
            return binarySearch(nums, pivot, nums.length-1, target);
        } else {
            return binarySearch(nums, 0, pivot-1, target);
        }
    }

    public static void main(String[] args) {
        // int[] nums = {4,5,6,7,0,1,2};
        // int target = 0;

        // int[] nums = {4,5,6,7,0,1,2};
        // int target = 3;

        int[] nums = {1,3};
        int target = 1;
        
        Solution obj = new Solution();

        int ans = obj.search(nums, target);

        System.out.println("Output: "+ ans);
    }
}