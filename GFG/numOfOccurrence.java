package GFG;

/*Leetcode-Number of Occurrence
Given a sorted array arr[] and a number target, find the number of occurrences of target in given array. 

Examples:
Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
Output: 4
Explanation: target = 2 occurs 4 times in the given array so the output is 4.

Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
Output: 0
Explanation: target = 4 is not present in the given array so the output is 0.

Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
Output: 3
Explanation: target = 12 occurs 3 times in the given array so the output is 3.
Constraints:
1 ≤ arr.size(), arr[i], target ≤ 106

 */

class Solution {
    int getLowerBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int s = 0;
        int e = n;
        int leftIndex = n;
        
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[mid] >= target){
                //store leftIndex
                leftIndex = mid;
                //move to left
                e = mid - 1;
            } else {
                //right move
                s = mid + 1;
            }
        }
        return leftIndex;
    }

    int getUpperBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int s = 0;
        int e = arr.length-1;
        int rightIndex = n;
        
        while(s<=e){
            int mid = s + (e-s)/2;
            if(arr[mid] <= target){
                //move to right
                s = mid+1;
            } else {
                //store rightIndex
                rightIndex = mid;
                e = mid - 1; 
            }
        }
        return rightIndex;
    }

    int countFreq(int[] arr, int target) {
        // code here
        int ans = getUpperBound(arr, target) - getLowerBound(arr, target);
        return  ans;
    }

    public static void main(String[] args) {
        // int[] arr = {1, 1, 2, 2, 2, 2, 3};
        // int target = 2;

        int[] arr = {8, 9, 10, 12, 12, 12};
        int target = 12;

        // int[] arr = {10,20,20,20,20,20,30,40,50};
        // int target = 20;

        Solution obj = new Solution();

        int lower = obj.getLowerBound(arr, target);
        int upper = obj.getUpperBound(arr, target);
        int ans = obj.countFreq(arr, target);

        System.out.println("Lower: " + lower);
        System.out.println("Upper: " + upper);
        System.out.println("Output: " + ans);

    }
}
