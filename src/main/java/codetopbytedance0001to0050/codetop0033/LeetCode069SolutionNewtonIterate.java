package codetopbytedance0001to0050.codetop0033;

public class LeetCode069SolutionNewtonIterate {

    /**
     * 使用牛顿迭代法求
     *
     * f(x) = x ^ 2 - C
     * 在 xi 点的斜率为 f`(xi) = 2 * xi
     *
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        // 初始点 (x0, y) = (C, C) // C = X = xi ^ 2
        double C = x, x0 = x;
        while (true){
            double xi = 0.5 * (x0 + C / x0);
            if(Math.abs(x0 - xi) < 1e-7){
                break;
            }
            x0 = xi;
        }
        return (int)x0;
    }

}
