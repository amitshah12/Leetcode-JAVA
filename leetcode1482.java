import java.util.Arrays;

class Solution {
    int canMakeMBouq(int[] bloomDay, int mid, int k){
        int bouqCount = 0;
        int consecutive_Count = 0;

        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i] <= mid){
                consecutive_Count++;
            } else {
                consecutive_Count = 0;
            }

            if(consecutive_Count == k){
                bouqCount++;
                consecutive_Count=0;
            }
        }
        return bouqCount;
    }
    
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        int startDay = 0;
        int endDay = Arrays.stream(bloomDay).max().getAsInt();

        int minDays = -1;

        while(startDay <= endDay){
            int mid = startDay + (endDay-startDay)/2;

            if(canMakeMBouq(bloomDay, mid, k) >= m){
                minDays = mid;
                endDay = mid-1;
            } else {
                startDay = mid + 1;
            }
        }
        return minDays;
    }

    public static void main(String[] args) {
        int[] arr = {12,10,2,4,32,8};

        int maxValue = Arrays.stream(arr).max().getAsInt();

        System.out.println("Output: " + maxValue);
    }
}