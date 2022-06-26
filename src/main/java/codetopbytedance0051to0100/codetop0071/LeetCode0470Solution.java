package codetopbytedance0051to0100.codetop0071;

import java.util.Random;

public class LeetCode0470Solution {

    /**
     *  这个不用写在答案里，返回[1,2,3,4,5,6,7]中随机一数
     * @return
     */
    private int rand7(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    public int rand10() {
        int a, b, idx;
        while (true) {
            a = rand7();
            b = rand7();
            // 1 <= idx <= 49
            idx = b + (a - 1) * 7;
            if (idx <= 40) {
                // 为了概率平均，取余操作
                // 0 <= idx - 1 <= 39
                // 1 + (idx - 1) % 10 为概率均等的 [1,2,3,4,5,6,7,8,9,10]
                return 1 + (idx - 1) % 10;
            }
            // 以下 到循环结束注释掉 依然成立
            // 1 <= a <= 9
            a = idx - 40;
            b = rand7();
            // get uniform dist from 1 - 63
            // 1 <= idx <= 63
            idx = b + (a - 1) * 7;
            if (idx <= 60) {
                return 1 + (idx - 1) % 10;
            }
            // 以下到循环结束注释掉 依然成立
            // 1 <= a <= 3
            a = idx - 60;
            b = rand7();
            // get uniform dist from 1 - 21
            // 1 <= idx <= 21
            idx = b + (a - 1) * 7;
            if (idx <= 20) {
                return 1 + (idx - 1) % 10;
            }
        }
    }


}
