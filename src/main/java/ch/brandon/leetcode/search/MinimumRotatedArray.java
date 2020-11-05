package ch.brandon.leetcode.search;

/*
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class MinimumRotatedArray {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid >= 1 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[mid] >= nums[left] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

}