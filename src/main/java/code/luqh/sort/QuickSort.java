package code.luqh.sort;

/**
 * @author luqh
 * @date 2018/10/24
 **/
public class QuickSort {


    public static void main(String[] args) {

        int[] ints = {10, 5, 3, 1, 7, 2, 8, 99};
        new QuickSort().sort(ints);

        for (int anInt : ints) {
            System.out.print(anInt+",");
        }

    }

    public void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {

        int l = left, r = right;

        if (l < r) {
            int temp = nums[l];
            while (l < r) {

                while (r > l && nums[r] >= temp) {
                    r--;
                }
                nums[l] = nums[r];
                while (r > l && nums[l] <= temp) {
                    l++;
                }
                nums[r] = nums[l];
            }

            nums[l] = temp;
            sort(nums, left, l - 1);
            sort(nums, r + 1, right);
        }

    }


}
