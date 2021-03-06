package haifeng.cong.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 81. 搜索旋转排序数组 II
 *
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 *
 * Copyright: Copyright (c) 2021
 * Company: Ruijie Co., Ltd.
 * Create Time: 2021/4/7 10:29
 *
 * @author conghaifeng
 */
public class LQ81 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{1,1,3,5}, 3));
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        while (right >= 0 && left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[0] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;

    }


    public boolean search2(int[] nums, int target) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        return list.contains(target);
    }

    public boolean search3(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return true;
            }
        }
        return false;
    }

}
