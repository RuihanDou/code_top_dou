package codetopbytedance0051to0100.codetop0087;

public class LeetCode062Solution {

    public int uniquePaths(int m, int n) {

        int[][] checkerboard = new int[m][n];

        for(int i = 0; i < m; i++){
            checkerboard[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            checkerboard[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++) {
                checkerboard[i][j] = checkerboard[i-1][j] + checkerboard[i][j-1];
            }
        }

        return checkerboard[m-1][n-1];
    }


}
