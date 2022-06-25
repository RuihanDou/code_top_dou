package codetopbytedance0001to0050.codetop0045;

import java.util.Random;

public class QuickSort {

    public int[] sortArray(int[] nums) {
        Random rnd = new Random();
        sort(nums, 0, nums.length - 1, rnd);
        return nums;
    }

    private void sort(int[] arr, int l, int r, Random rnd) {
        if(l >= r){
            return;
        }
        int p = partition(arr, l, r, rnd);
        sort(arr, l, p - 1, rnd);
        sort(arr, p + 1, r, rnd);
    }

    private int partition(int[] arr, int l, int r, Random rnd){
        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1 ... i-1] <= v; arr[j+1 ... r] >= v
        int i = l + 1, j = r;
        while (true){
            while (i <= j && arr[i] < arr[l]){
                i++;
            }
            while (j >= i && arr[j] > arr[l]){
                j--;
            }

            if(i >= j){
                break;
            }

            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
