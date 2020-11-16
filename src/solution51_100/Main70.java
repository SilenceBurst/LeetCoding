package solution51_100;

/**
 * 70. 爬楼梯
 * 可以理解为倒数第二阶楼梯的走法 + 倒数第一阶楼梯的走法 以此类推 斐波拉契数列
 */
public class Main70 {

    public static void main(String[] args) {

    }

    /**
     * 动态规划法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        int p = 1, q = 2, temp;
        for (int i = 3; i <= n; i++) {
            temp = p;
            p = q;
            q = temp + q;
        }
        return q;
    }

    /**
     * 记忆数组法 使用长度为n的数组缓存 已计算f(n)值；不做缓存的话，时间复杂度为：O(n^2)
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public int climbStairs1(int n) {
        int[] memo = new int[n];
        return climbStairsMemo(n, memo);
    }

    public int climbStairsMemo(int n, int[] memo) {
        if (memo[n - 1] != 0) {
            return memo[n - 1];
        }
        if (n == 1) {
            return memo[n - 1] = 1;
        } else if (n == 2) {
            return memo[n - 1] = 2;
        } else {
            return memo[n - 1] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        }
    }
}
