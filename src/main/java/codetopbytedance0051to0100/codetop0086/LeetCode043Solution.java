package codetopbytedance0051to0100.codetop0086;

public class LeetCode043Solution {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String ans = "0";
        int m = num1.length(), n = num2.length();
        // 乘法从个位开始计算
        for (int i = n - 1; i >= 0; i--) {
            StringBuffer curr = new StringBuffer();
            int add = 0;
            // cur 为乘法补零
            for (int j = n - 1; j > i; j--) {
                curr.append(0);
            }
            int y = num2.charAt(i) - '0';
            for (int j = m - 1; j >= 0; j--) {
                int x = num1.charAt(j) - '0';
                int product = x * y + add;
                curr.append(product % 10);
                add = product / 10;
            }
            if (add != 0) {
                curr.append(add % 10);
            }
            ans = addStrings(ans, curr.reverse().toString());
        }
        return ans;
    }

    public String addStrings(String num1, String num2) {

        // add 作为加法进位, 根据阿拉伯数字书写习惯，个位在最后，高位向前排，所以初始位置为 length - 1
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;

        StringBuffer ans = new StringBuffer();

        while (i >= 0 || j >= 0 || add != 0) {

            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;

            int result = x + y + add;

            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 因为添加结果是从个位开始，故要反转
        ans.reverse();
        return ans.toString();
    }

}
