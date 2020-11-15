package solution251_300;

/**
 * 283.移动零
 */
public class Main283 {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                // 保证被占的0没有被丢掉
                if (index != i) {
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}
