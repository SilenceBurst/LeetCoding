package solution1_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class Main15 {

    public static void main(String[] args) {
        Main15 main15 = new Main15();
        System.out.println(main15.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    /**
     * 时间复杂度：O(N^2) 两层循环
     * 空间复杂度：O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            // 最小的数就大于0 肯定不存在解
            if (nums[first] > 0) break;
            // 当不是第一轮遍历时，找到不和上一轮相同的数
            if (first > 0 && nums[first] == nums[first - 1]) continue;
            // 最大的数的指针 为数组最末端
            // 注意：不需要在每次遍历second时重置
            // 因为second遍历过程时递增的，要满足nums[second] + nums[third] > target，third只可能是递减的
            int third = nums.length - 1;
            int target = -nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                // 当不是第一轮遍历时，找到和上一轮不相同的数
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                while (third > second) {
                    if (nums[second] + nums[third] > target) {
                        third--;
                        continue;
                    } else if (nums[second] + nums[third] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[first]);
                        list.add(nums[second]);
                        list.add(nums[third]);
                        result.add(list);
                        // 一旦出现相等值，这个third可以被丢弃了，因为下一个合法的second一定大于当前second
                        third--;
                    }
                    break;
                }
            }
        }
        return result;
    }
}
