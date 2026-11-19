
import java.util.Arrays;

class Solution {
    public String[] createGrid(int m, int n) {
        char[][] nums = new char[m][n];

        // Fill the entire grid with obstacles
        for(char[] row : nums){
            Arrays.fill(row, '#');
        }

        // Open every cell in the first row
        Arrays.fill(nums[0], '.');

        // Open every cell in the last column
        for(int i = 0; i < m; i++){
            nums[i][n - 1] = '.';
        }

        // Convert each row into a String
        String[] result = new String[m];

        for(int i = 0; i < m; i++) {
            result[i] = new String(nums[i]); //store entier row nums[i]
            // System.out.println(Arrays.toString(result));
        }

        return result;
    }

    public static void main(String[] args) {
        // int m = 2;
        // int n = 3;
        
        int m = 3;
        int n = 3;

        Solution obj = new Solution();
        String[] ans = obj.createGrid(m, n);

        System.out.println("Output: " + Arrays.toString(ans));
    }
}
