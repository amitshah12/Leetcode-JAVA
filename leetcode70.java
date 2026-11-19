import java.util.*;

/*Leetcode-70. Climbing Stairs
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:
Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps

Example 2:
Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:
1 <= n <= 45
*/

class Solution {
    //Method-1 -> Using memoization
    // int[] t = new int[46];
    // int solve(int n){
    //     if(n==1){
    //         return n;
    //     }
    //     if(n==2){
    //         return n;
    //     }

    //     if(t[n] != -1){
    //         return t[n];
    //     }

    //     int one_step = solve(n-1);
    //     int two_step = solve(n-2);

    //     return t[n] = one_step + two_step;
    // }
    // public int climbStairs(int n) {
    //     Arrays.fill(t, -1);
    //     return solve(n);
    // }

    // Method-2 -> Using Bottom Up DP
    // public int climbStairs(int n) {
    //     if(n == 1 || n == 2 || n ==3){
    //         return n;
    //     }

    //     int[] t = new int[n+1];
        
    //     t[0] = 0;
    //     t[1] = 1;
    //     t[2] = 2;

    //     for(int i=3; i<=n; i++){
    //         t[i] = t[i-1] + t[i-2];
    //     }

    //     return t[n];
    // }

    // Method-3 -> Improving approach-2
    public int climbStairs(int n) {
        if(n == 1 || n == 2){
            return n;
        }

        int a = 1;
        int b = 2;
        int c = 3;

        for(int i=3; i<=n; i++){
            c = b + a;
            int temp_b = b;
            b = c;
            a = temp_b;
        }
        return c;
    }

    public static void main(String[] args) {
        int n = 45;

        Solution obj = new Solution();
        int ans = obj.climbStairs(n);

        System.out.println("Output: " + ans);
    }
}