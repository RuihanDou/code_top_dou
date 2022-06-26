package codetopbytedance0051to0100.codetop0080;

public class LeetCode079Solution {

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private char[][] board;
    private boolean[][] visited;
    private int rows, cols;
    private String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        rows = board.length;
        cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if(check(i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param i    横坐标
     * @param j    纵坐标
     * @param k    单词字符位置
     * @return
     */
    private boolean check(int i, int j, int k){
        if(board[i][j] != word.charAt(k)){
            return false;
        }
        else if(k == word.length() - 1){
            return true;
        }

        visited[i][j] = true;
        boolean rst = false;
        for(int[] dir : directions){
            int nextI = i + dir[0], nextJ = j + dir[1];
            if(validateLocation(nextI, nextJ) && !visited[nextI][nextJ]){
                if(check(nextI, nextJ, k + 1)){
                    rst = true;
                }
            }
        }
        visited[i][j] = false;
        return rst;
    }

    private boolean validateLocation(int i, int j){
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }


}
