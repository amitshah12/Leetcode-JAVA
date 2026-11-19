package GFG;

/*GFG- Allocate Minimum Pages
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:

Each student receives atleast one book.
Each student is assigned a contiguous sequence of books.
No book is assigned to more than one student.
All books must be allocated.
The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum. If it is not possible to allocate books to all students, return -1;

Examples:

Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.
Constraints:

1 ≤ arr.size() ≤ 10^6
1 ≤ arr[i], k ≤ 10^4
*/

class Solution {
    boolean isValid(int[] arr, int k, int mid){
        int studentCount = 1;
        int pages = 0;
        
        for(int i=0; i<arr.length; i++){
            if(pages + arr[i] <= mid){
                pages += arr[i];
            } else {
                studentCount++;
                if(studentCount>k || arr[i]>mid){
                    return false;
                }
                pages = arr[i];
            }
        }
        return true;
    }
    
    public int findPages(int[] arr, int k) {
        // code here
        if(arr.length<k){ //to find a valid answer, books count must be >= student present
            return -1;
        }
        
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
        // int[] nums = {7,2,5,10,8};
        // int k = 2;
        int[] nums = {12,34,67,90};
        int k = 2;

        Solution obj = new Solution();

        int ans = obj.findPages(nums, k);

        System.out.println("Output: " + ans);
    }
}
