package codetopbytedance0051to0100.codetop0069;

public class LeetCode0240Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1;
        while (i < rows && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else { // matrix[i][j] < target
                i++;
            }
        }
        return false;
    }

}
