package codetopbytedance0001to0050.codetop0009;

public class LeetCode0200Solution {

    public int numIslands(char[][] grid) {
        if(null == grid || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        return deeplySearchNumIslands(grid);

    }

    private int deeplySearchNumIslands(char[][] grid) {
        int nums = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == '1'){
                    nums++;
                    wrapout(grid, i, j);
                }

            }
        }

        return nums;

    }

    private void wrapout(char[][] grid, int i, int j) {
        if(i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1'){
            grid[i][j] = '0';
            wrapout(grid, i-1, j);
            wrapout(grid, i, j-1);
            wrapout(grid, i+1, j);
            wrapout(grid, i, j+1);
        }
    }


}
