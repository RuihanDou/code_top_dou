package codetopbytedance0001to0050.codetop0030;

public class LeetCode0415Solution {

    public String addStrings(String num1, String num2) {

        // 从右开始加， carry 是进位
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuffer sf = new StringBuffer();

        while (i >= 0 || j >= 0 || carry > 0){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;

            sf.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }
        // 反转字符顺序
        sf.reverse();
        return sf.toString();
    }

}
