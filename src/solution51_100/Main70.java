package solution51_100;

/**
 * 70. 爬楼梯
 */
public class Main70 {
    public static void main(String[] args) {

    }

    private static int result = 0;

    public static int climbStairs(int n) {
        int level = 1;
        helper(n, level);
        return result;
    }

    public static void helper(int currN, int level) {
        if (currN - 1 > 0) {
            if (currN - 1 > 1) {
                level *= 2;
                helper(currN - 1, level);
                helper(currN - 2, level);
            } else {
                helper(currN - 1, level);
            }
        } else {
            result += level;
        }
    }
}
