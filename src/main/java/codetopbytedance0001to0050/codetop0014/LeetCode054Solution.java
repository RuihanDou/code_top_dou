package codetopbytedance0001to0050.codetop0014;

import java.util.ArrayList;
import java.util.List;

public class LeetCode054Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return list;
        }

        int rows = matrix.length, columns = matrix[0].length;

        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        // 每个循环只考虑一层
        while (left <= right && top <= bottom){

            for(int column = left; column <= right; column++){
                list.add(matrix[top][column]);
            }
            for(int row = top + 1; row <= bottom; row++){
                list.add(matrix[row][right]);
            }

            if (left < right && top < bottom) {
                for(int column = right - 1; column > left; column --) {
                    list.add(matrix[bottom][column]);
                }
                for(int row = bottom; row > top; row --){
                    list.add(matrix[row][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;

        }

        return list;

    }

}
