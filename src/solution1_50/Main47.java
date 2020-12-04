package solution1_50;

import java.util.*;

/**
 * 47. 全排列 II
 */
public class Main47 {

    public static void main(String[] args) {
        new Main47().permuteUnique(new int[]{1, 1});
    }

    /**
     * 回溯算法
     * 时间复杂度：
     * 空间复杂度：
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new LinkedList<>();
        helper(nums, path, used, result);
        return result;
    }

    private void helper(int[] nums, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // !used[i - 1]的判断究极难理解
            //
            // 如果num[i] = num[i-1] && !used[i - 1]，即i-1位置必须选中，相同元素必须被顺序选中
            // eg：1, 1', 1''
            // 必须是被顺序选中1, 1', 1'',以1'/1''开头均会被立即剪枝
            //
            // 而num[i] = num[i-1] && used[i - 1]，即i-1位置必须没有被选中
            // 最后的结果会是1'',1',1，以1, 1'开头的并不会最立即剪枝，多了多余计算
            //
            // https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) continue;
            path.addLast(nums[i]);
            used[i] = true;
            helper(nums, path, used, result);
            path.removeLast();
            used[i] = false;
        }
    }
}
