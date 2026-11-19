import java.util.*;

class Solution {
    int findDayOfYear(String date, int[] cumMonthDays){
        int month = Integer.parseInt(date.substring(0, 2));
        int days = Integer.parseInt(date.substring(3));

        return cumMonthDays[month-1] + days;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int[] cumMonthDays = new int[13];
        //1st index = January
        //2nd index = February
        cumMonthDays[1] = 31;//January
        for(int i=2; i<=12; i++){
            cumMonthDays[i] = cumMonthDays[i-1] + monthDays[i-1];
        }

        int arriveAliceDay = findDayOfYear(arriveAlice, cumMonthDays);
        int leaveAliceDay = findDayOfYear(leaveAlice, cumMonthDays);
        int arriveBobDay = findDayOfYear(arriveBob, cumMonthDays);
        int leaveBobDay = findDayOfYear(leaveBob, cumMonthDays);

        int overLapDays = Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1;

        return overLapDays < 0 ? 0 : overLapDays;
    }

    public static void main(String[] args) {
        String arriveAlice = "08-15";
        String leaveAlice = "08-18";

        String arriveBob = "08-16";
        String leaveBob = "08-19";

        Solution obj = new Solution();
        int ans = obj.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);

        System.out.println("Output: " + ans);
    }
}