package codetopbytedance0001to0050.codetop0033;

public class LeetCode069SolutionMath {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return ((long) (ans + 1) * (ans + 1)) <= x ? ans + 1 : ans;
    }

}
