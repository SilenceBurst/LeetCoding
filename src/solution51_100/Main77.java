package solution51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 */
public class Main77 {

    public static void main(String[] args) {

    }

    /**
     * 递归解法
     * 使用temp保存当前以添加的组合值，分考虑当前位置和不考虑当前位置两种情况，进行递归
     * 时间复杂度：不知道怎么算
     * 空间复杂度：O(N+k) 递归深度+存储temp的额外空间
     */
    public List<List<Integer>> combine(int n, int k) {
        dns(1, n, k);
        return result;
    }

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    private void dns(int cur, int n, int k) {
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        // 考虑当前位置
        temp.add(cur);
        dns(cur + 1, n, k);
        // 不考虑当前位置
        temp.remove(temp.size() - 1);
        dns(cur + 1, n, k);
    }
}
