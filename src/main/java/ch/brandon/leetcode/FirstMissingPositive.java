package ch.brandon.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {


    public int firstMissingPositive(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            if (nums[i] < 0 || nums[i] > length) {
                nums[i] = length + 1;
            }
        }

        for (int i = 0; i < length; i++) {
            int num = Math.abs(nums[i]);
            if (num > length) {
                continue;
            }
            num--;
            if (nums[num] > 0) {
                nums[num] = -1 * num;
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }


    public int firstMissingPositiveSlow(int[] nums) {

        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (!numList.contains(1)) {
            return 1;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 > 0 && nums[i] + 1 < nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

}
