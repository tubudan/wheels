package pers.hx.leetcode;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * @create: 2021-12-02 15:55
 */

public class SumTwoNums {
    public static int[] nums = {1,2,3,4,5,6,6,7};

    public static int target = 10;

    public static int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        twoSum(nums, target);
    }
}
