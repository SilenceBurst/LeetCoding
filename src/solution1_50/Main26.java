package solution1_50;


/**
 * 26. 删除排序数组中的重复项
 */
public class Main26 {

    public static void main(String[] args) {

    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }

}
