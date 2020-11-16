package solution1_50;

/**
 * 11 盛最多水的容器
 */
public class Main11 {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxArea(int[] height) {
        // 边界移动
        // 初始边界为数组两端，找出两者最小值移动，因为移动最大值后，盛水量只可能会比目前的小
        // 不断移动，直至重合
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

}
