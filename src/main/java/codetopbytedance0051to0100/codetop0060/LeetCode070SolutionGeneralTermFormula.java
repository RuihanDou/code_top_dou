package codetopbytedance0051to0100.codetop0060;

public class LeetCode070SolutionGeneralTermFormula {

    public int climbStairs(int n) {
        double n1 = n + 1.0;
        double rst = (1.0 / Math.sqrt(5.0)) * (Math.pow(((1.0 + Math.sqrt(5.0)) / 2.0), n1) - Math.pow(((1.0 - Math.sqrt(5.0)) / 2.0), n1));
        return (int) rst;
    }

}
