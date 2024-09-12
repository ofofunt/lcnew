package com.shuatmd.leetcodetraining.Easy;

//88. 合并两个有序数组
//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
//请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//
//注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n
public class MergeTwoOrderedArray88 {
    //官方解法2：双指针 但是从后往前插
    //因为后nums1中后n个数字为0 刚好留出了空位
    //我们只需要从后面遍历 然后将大的数字放在末尾 即可
    public void mergeOfficial2(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int left = m-1;
        int right = n-1;
        int cur = 0;
        //条件需要设置为 >=0  index为0仍然需要进循环
        while(left >= 0 || right >= 0){
            //边界需要设置为-1 因为left == 0的时候说明还有一位未处理完
            if(left == -1){
                cur = nums2[right];
                right --;
            } else if (right == -1) {
                cur = nums1[left];
                left --;
            } else if (nums1[left] >= nums2[right]) {
                cur = nums1[left];
                left --;
            }
            else {
                cur = nums2[right];
                right --;
            }
            nums1[length - 1] = cur;
            length --;
        }
    }

    //官方解法1：更优雅的双指针
    public void mergeOfficial(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int[] res = new int[m + n];
        int cur = 0;
        //while判断用||
        while(left < m || right < n ){
            if(left == m){
                cur = nums2[right];
                right ++;
            }
            else if (right == n){
                cur = nums1[left];
                left++;
            }
            else if(nums1[left] <= nums2[right]){
                cur = nums1[left];
                left++;
            }
            else{
                cur = nums2[right];
                right ++;
            }
            res[left + right - 1] = cur;
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = res[i];
        }

    }

    //手搓解法 双指针插入 插入前做比较
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int[] num3 = new int[m + n];
        for (int i = 0; i < m + n; i++) {
            int leftCur = nums1[left];
            int rightCur = nums2[right];
            if (left < m && right < n) {
                //如果当前nums1中的数小于nums2 则不需要操作 left++
                if (leftCur <= rightCur) {
                    num3[i] = leftCur;
                    left++;
                }
                //如果当前nums1中的数大于nums2 则需要插入nums2 并且将nums1整体后移
                else {
                    num3[i] = rightCur;
                    right++;
                }
            } else {
                if (left == m) {
                    num3[i] = rightCur;
                    right++;
                } else {
                    num3[i] = leftCur;
                    left++;
                }
            }
        }
        for (int i = 0; i != m + n; ++i) {
            nums1[i] = num3[i];
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        int m = 0;
        int n = 1;
        MergeTwoOrderedArray88 mergeTwoOrderedArray = new MergeTwoOrderedArray88();
        mergeTwoOrderedArray.merge(nums1, m, nums2, n);
    }
}
