package codetopbytedance0001to0050.codetop0016;

public class LeetCode05Solution {

    // 使用动态规划思想
    public String longestPalindromeV1(String s) {
        int n = s.length();
        if (null == s || n < 1) {
            return "";
        }
        String longest = "";
        boolean[][] tableLR = new boolean[n+1][n+1];
        for (int r = 0; r <= n; r++) {
            for (int l = 0; l <= r; l++) {
                String sub = s.substring(l, r);
//                System.out.println(l);
//                System.out.println(r);
//                System.out.println(sub);
                if (r - l <= 1) {
                    tableLR[l][r] = true;
                    if(longest.length() < r - l) {
                        longest = sub;
                    }
                } else if (s.charAt(l) == s.charAt(r-1) && tableLR[l+1][r-1]) {
                    tableLR[l][r] = true;
                    if(longest.length() < r - l) {
                        longest = sub;
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(tableLR));
        return longest;
    }

}
