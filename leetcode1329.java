import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Leetcode-1329. Sort the Matrix Diagonally1329. Sort the Matrix Diagonally
A matrix diagonal is a diagonal line of cells starting from some cell in either the topmost row or leftmost column and going in the bottom-right direction until reaching the matrix's end. For example, the matrix diagonal starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells mat[2][0], mat[3][1], and mat[4][2].

Given an m x n matrix mat of integers, sort each matrix diagonal in ascending order and return the resulting matrix.

Example 1:
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]

Example 2:
Input: mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
Output: [[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]

Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 100
1 <= mat[i][j] <= 100
*/
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        //storing diagonal element in map
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mp.computeIfAbsent(i-j, key->new ArrayList<>()).add(mat[i][j]);
            }
        }

        //sort them
        mp.forEach((key, list) -> Collections.sort(list));
        
        //Restore sorted element into the matrix
        //traverse from bottom-right to top-left
        Map<Integer, Integer> indexMap = new HashMap<>();

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int key = i-j;
                
                List<Integer> list = mp.get(key);
                
                int index = indexMap.getOrDefault(key, list.size()-1);
                
                mat[i][j] = list.get(index);

                indexMap.put(key, index-1);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        // int[][] mat = {{3,3,1,1},
        //                {2,2,1,2},
        //                {1,1,1,2}};

        int[][] mat = {{3,3,1,1},
                       {2,2,1,2},
                       {1,1,1,2}};

        Solution obj = new Solution();
        int[][] ans = obj.diagonalSort(mat);

        System.out.print("Output: {");
        for(int i=0; i<mat.length; i++){
            System.out.print("{");
            for(int j=0; j<mat[i].length; j++){
                System.out.print(mat[i][j]);
                if(j<ans[i].length-1){
                    System.out.print(",");
                }
            }
            System.out.print("}");
            if(i<ans.length-1){
                System.out.print(",");
            }
        }
        System.out.println("}");
    }
}