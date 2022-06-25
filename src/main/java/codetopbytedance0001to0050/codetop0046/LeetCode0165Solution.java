package codetopbytedance0001to0050.codetop0046;

public class LeetCode0165Solution {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int l1 = v1.length, l2 = v2.length;
        for(int i = 0; i < l1 || i < l2; i++){
            int x = 0, y = 0;
            if(i < l1){
                x = Integer.parseInt(v1[i]);
            }
            if(i < l2){
                y = Integer.parseInt(v2[i]);
            }
            if(x > y){
                return 1;
            }
            if(x < y){
                return -1;
            }
        }
        return 0;

    }

}
