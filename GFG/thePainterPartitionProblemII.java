package GFG;

/*GFG Q- The Painter's Partition Problem-II
Given an array arr[] where each element denotes the length of a board, and an integer k representing the number of painters available. Each painter takes 1 unit of time to paint 1 unit length of a board.

Determine the minimum amount of time required to paint all the boards, under the constraint that each painter can paint only a contiguous sequence of boards (no skipping or splitting allowed).

Examples:
Input: arr[] = [5, 10, 30, 20, 15], k = 3
Output: 35
Explanation: The optimal allocation of boards among 3 painters is - 
Painter 1 → [5, 10] → time = 15
Painter 2 → [30] → time = 30
Painter 3 → [20, 15] → time = 35
Job will be done when all painters finish i.e. at time = max(15, 30, 35) = 35

Input: arr[] = [10, 20, 30, 40], k = 2
Output: 60
Explanation: A valid optimal partition is - 
Painter 1 → [10, 20, 30] → time = 60
Painter 2 → [40] → time = 40
Job will be complete at time = max(60, 40) = 60

Input: arr[] = [100, 200, 300, 400], k = 1
Output: 1000
Explanation: There is only one painter, so the painter must paint all boards sequentially. The total time taken will be the sum of all board lengths, i.e., 100 + 200 + 300 + 400 = 1000.

Constraints:
1 ≤ arr.size(), k ≤ 105
1 ≤ arr[i] ≤ 104
*/

class Solution {
    boolean isValid(int[] arr, int k, int mid){
        int painterCount = 1;
        int painterSum = 0;
        
        for(int i=0; i<arr.length; i++){
            if(painterSum + arr[i] <= mid){
                painterSum += arr[i];
            } else {
                painterCount++;
                if(painterCount>k || arr[i]>mid){
                    return false;
                }
                painterSum = arr[i];
            }
        }
        return true;
    }
    
    public int minTime(int[] arr, int k) {
        // code here
        int start = 0;
        int sum = 0;
        int n = arr.length;
        
        
        for(int i=0; i<n; i++){
            sum += arr[i];
        }
        
        int end = sum;
        int ans = -1;
        
        while(start <= end){
            int mid = start + (end-start)/2;
            if(isValid(arr, k, mid)){
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 15};
        int k = 3;

        Solution obj = new Solution();

        int ans = obj.minTime(arr, k);

        System.out.println("Output: "+ ans);
    }
}