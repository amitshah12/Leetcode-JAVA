import java.util.ArrayList;
import java.util.List;

/*Leetcode-54-Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100 
*/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int startingRow = 0;
        int endingRow = m-1;
        int startingCol = 0;
        int endingCol = n-1;

        while(startingRow <= endingRow && startingCol<=endingCol){
            //row wise left to right -> print startingRow, from startingCol to endingcol
            for(int col=startingCol; col<=endingCol; col++){
                result.add(matrix[startingRow][col]);
            }
            startingRow++;

            //col wise top to bottom -> print endingcol, from startingRow to endingRow
            for(int row=startingRow; row<=endingRow; row++){
                result.add(matrix[row][endingCol]);
            }
            endingCol--;

            //row wise right to left -> print endingRow, from endingCol to startingCol
            //valid endingRow <= startingRow <= endingRow
            if(startingRow<=endingRow){
                for(int col=endingCol; col>= startingCol; col--){
                    result.add(matrix[endingRow][col]);
                }
                endingRow--;
            }
            
            //col wise bottom to top -> print startingCol, from endRow to startingRow
            //valid statingCols preset?
            if(startingCol<=endingCol){
                for(int row=endingRow; row>=startingRow; row--){
                    result.add(matrix[row][startingCol]);
                }
                startingCol++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},
                          {4,5,6},
                          {7,8,9}};

        Solution obj = new Solution();

        List<Integer> ans = obj.spiralOrder(matrix);

        System.out.println("Output: "+ ans);
    }
}