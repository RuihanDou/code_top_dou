package codetopbytedance0001to0050.codetop0040;

import java.util.ArrayList;
import java.util.List;

public class LeetCode022Solution {

    public List<String> generateParenthesis(int n){
        List<String> rst = new ArrayList<>();
        recursion(rst, new StringBuilder(), 0, 0, n);
        return rst;
    }

    /**
     *
     * 递归加回溯
     *
     * @param rstList   结果列表
     * @param cur        目前的括号字符串
     * @param l             已经使用的左括号数量
     * @param r            已经使用的右括号数量
     * @param max       最大括号数量
     */
    private void recursion(List<String> rstList, StringBuilder cur, int l, int r, int max){

        // 递归成功且结束
        if(cur.length() == max * 2){
            rstList.add(cur.toString());
            return;
        }

        // 左括号数量只要小于最大值就可以添加
        if (l < max){
            cur.append('(');
            recursion(rstList, cur, l+1, r, max);
            // 本轮结束 要恢复状态，使该递归函数调用下，后面的代码能正常生效
            cur.deleteCharAt(cur.length() - 1);
        }

        // 右括号必须数量小于左括号才可以添加
        if (r < max && r < l){
            cur.append(')');
            recursion(rstList, cur, l, r+1, max);
            // 本轮结束 要恢复状态，使该递归函数调用下，后面的代码能正常生效
            cur.deleteCharAt(cur.length() - 1);
        }
    }


}
