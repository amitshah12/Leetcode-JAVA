package GFG;

/*GFG Q - Aggressive Cows
Given an integer array arr[], which denotes the positions of stalls. All the positions are distinct. There are k aggressive cows.

Assign the cows to the stalls such that the minimum distance between any two cows is maximized.

Examples:
Input: arr[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at arr[0], the second at arr[2], and the third at arr[3]. The minimum distance between any two cows is 3 (between arr[0] and arr[2]), which is the maximum possible among all valid arrangements.

Input: arr[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at arr[0], the second at arr[1], and the third at arr[4]. In this arrangement, the minimum distance between any two cows is 4 (between arr[1] and arr[4]), which is the maximum possible among all valid arrangements.

Constraints:
arr.size() ≤ 106
0 ≤ arr[i] ≤ 108
2 ≤ k ≤ arr.size() 
*/

import java.util.*;
class Solution {
    boolean isValidAns(int[] arr, int k, int minDistance){
        int cowCount = 1;
        int lastPosition = 0;
        
        for(int i=1; i<arr.length; i++){
            //curr cow can only be placed in curr position if curr and prev cow has distance >=minDistance
            if(arr[i]-arr[lastPosition]>= minDistance){
                //can place safely
                cowCount++;
                lastPosition = i;
                if(cowCount == k){
                    return true;
                }
            }
        }
        return false;
    }
    
    public int aggressiveCows(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n = arr.length;
        
        int start = 0;
        int end = arr[n-1] - arr[0];
        
        int ans = -1;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(isValidAns(arr, k, mid)){
                ans = mid;
                start = mid+1;
            }else {
                //no possible arrangement with mid to place cows
                end = mid-1;
            }
        }
        return ans;
        
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,8,9};
        int k = 3;

        Solution obj = new Solution();
        int ans = obj.aggressiveCows(arr, k);

        System.out.println("Output: " + ans);
    }
}
