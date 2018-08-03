package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/4sum/description/

Given an array nums of n integers and an integer target,
are there elements a, b, c, and d in nums such that a + b + c + d = target?
Find all unique quadruplets in the array which gives the sum of target.

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
 */
public class _4Sum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> ret = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < len - 2; j++) {
                if (j > 1 && nums[j] == nums[j - 1] && j - i > 1) {
                    continue;
                }

                int left = j + 1, right = len - 1;

                while (left < right) {
                    int _4sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (_4sum == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1])
                            left++;
                        while (left < right && nums[right] == nums[right - 1])
                            right--;
                        left++;
                        right--;
                    } else if (_4sum > target)
                        right--;
                    else
                        left++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] a = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
        System.out.println(fourSum(a, 0));
    }
}