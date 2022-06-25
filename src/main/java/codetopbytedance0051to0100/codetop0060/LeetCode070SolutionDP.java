package codetopbytedance0051to0100.codetop0060;

public class LeetCode070SolutionDP {

    public int climbStairs(int n) {
        int p = 0, q = 1, r = 1;
        for(int i = 1; i < n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
