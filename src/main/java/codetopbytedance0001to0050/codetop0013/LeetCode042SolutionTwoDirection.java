package codetopbytedance0001to0050.codetop0013;

public class LeetCode042SolutionTwoDirection {

    public int trap(int[] height) {

        int[] leftMaxArr = new int[height.length];

        int leftMax = 0;
        for(int i = 0; i < height.length; i++){

            leftMax = leftMax > height[i] ? leftMax : height[i];
            leftMaxArr[i] = leftMax;
        }
        int[] rightMaxArr = new int[height.length];

        int rightMax = 0;
        for(int i = height.length - 1; i > 0 ; i--){
            rightMax = rightMax > height[i] ? rightMax : height[i];
            rightMaxArr[i] = rightMax;
        }

        int rst = 0;

        for(int i = 0; i < height.length; i++){

            int edge = Math.min(leftMaxArr[i], rightMaxArr[i]);
            if(edge > height[i]){
                rst += (edge - height[i]);
            }
        }

        return rst;
    }

}
