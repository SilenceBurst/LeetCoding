package solution1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class Main22 {

    public static void main(String[] args) {

    }

    // 左括号可以任意生成；但右括号生成时必须前面有多余的左括号
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", n, n);
        return result;
    }

    private void helper(List<String> result, String str, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        if (left < right) {
            if (left > 0) {
                helper(result, str + "(", left - 1, right);
            }
            helper(result, str + ")", left, right - 1);
        } else {
            helper(result, str + "(", left - 1, right);
        }
    }
}
