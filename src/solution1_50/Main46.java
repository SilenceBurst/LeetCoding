package solution1_50;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Main46 {

    public static void main(String[] args) {
        new Main46().permute(new int[]{1, 2, 3});
    }

    /**
     * 回溯算法
     * 深度优先遍历
     * 时间复杂度：不会
     * 空间复杂度：不会
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        // 以空间换时间
        boolean[] used = new boolean[nums.length];
        Deque<Integer> path = new LinkedList<>();
        dns(nums, path, used, result);
        return result;
    }

    private void dns(int[] nums, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.addLast(nums[i]);
            used[i] = true;
            dns(nums, path, used, result);
            // 重置状态 回溯
            path.removeLast();
            used[i] = false;
        }
    }
}
