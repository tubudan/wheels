package pers.hx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description: LC4 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 算法的时间复杂度应该为 O(log (m+n))
 * @create: 2021-12-03 14:10
 */

/*
A = 1 3 4 9                             m = 4
B = 1 2 3 4 5 6 7 8 9 10                n = 10
S = 1 1 2 3 3 4 4 5 6 7 8 9 9 10        m + n =14
奇数 k = (m+n+1)/2                      中位数 S[k]
偶数 k1 = ((m+n)/2 , k2 = (m+n)/2+1)    中位数 (S[k1] + S[k2])/2
*/

public class MedianOfTwoArr {

    // 合并求解 :不用考虑奇偶，如果是奇数 left == right
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }


    //获取两个数组合并后的第k个数
    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);  //保证nums1的长度小于nums2
        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    //二分查找法
    public static int searchArrayMidReccurence(int[] nums, int target, int first, int end) {
        if (target < nums[first] || target > nums[end] || first > end) {
            return -1;
        }
        int midIndex = (first + end) / 2;

        if (target < nums[midIndex]) {
            return searchArrayMidReccurence(nums, target, first, midIndex);
        } else if (target > nums[midIndex]) {
            return searchArrayMidReccurence(nums, target, midIndex, end);
        } else {
            return midIndex;
        }
    }

    public static int searchArrayMidDirect(int[] nums, int target) {
        int first = 0;
        int end = nums.length - 1;
        int midIndex = 0;

        while (first <= end) {
            midIndex = (first + end) / 2;
            if (target < nums[midIndex]) {
                end = midIndex - 1;
            } else if (target > nums[midIndex]) {
                first = midIndex + 1;
            } else {
                return midIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(123);
        arrayList.add(1);
        arrayList.add(143);
        arrayList.add(143);
        arrayList.add(143);
        arrayList.add(2);
        arrayList.add(5);
        Integer[] arr = arrayList.toArray(new Integer[0]);
        HashSet<Integer> hashSet = new HashSet<>(arrayList);

        Iterator iterator = hashSet.iterator();

        synchronized (iterator) {
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
    }
}

/**
 * @Description 这道题让我们求两个有序数组的中位数，而且限制了时间复杂度为O(log (m+n))，看到这个时间复杂度，自然而然的想到了应该使用二分查找法来求解。那么回顾一下中位数的定义，如果某个有序数组长度是奇数，那么其中位数就是最中间那个，如果是偶数，那么就是最中间两个数字的平均值。这里对于两个有序数组也是一样的，假设两个有序数组的长度分别为m和n，由于两个数组长度之和 m+n 的奇偶不确定，因此需要分情况来讨论，对于奇数的情况，直接找到最中间的数即可，偶数的话需要求最中间两个数的平均值。为了简化代码，不分情况讨论，我们使用一个小trick，我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可，这对奇偶数均适用。加入 m+n 为奇数的话，那么其实 (m+n+1) / 2 和 (m+n+2) / 2 的值相等，相当于两个相同的数字相加再除以2，还是其本身。
 * 这里我们需要定义一个函数来在两个有序数组中找到第K个元素，下面重点来看如何实现找到第K个元素。首先，为了避免产生新的数组从而增加时间复杂度，我们使用两个变量i和j分别来标记数组nums1和nums2的起始位置。然后来处理一些边界问题，比如当某一个数组的起始位置大于等于其数组长度时，说明其所有数字均已经被淘汰了，相当于一个空数组了，那么实际上就变成了在另一个数组中找数字，直接就可以找出来了。还有就是如果K=1的话，那么我们只要比较nums1和nums2的起始位置i和j上的数字就可以了。难点就在于一般的情况怎么处理？因为我们需要在两个有序数组中找到第K个元素，为了加快搜索的速度，我们要使用二分法，对K二分，意思是我们需要分别在nums1和nums2中查找第K/2个元素，注意这里由于两个数组的长度不定，所以有可能某个数组没有第K/2个数字，所以我们需要先检查一下，数组中到底存不存在第K/2个数字，如果存在就取出来，否则就赋值上一个整型最大值。如果某个数组没有第K/2个数字，那么我们就淘汰另一个数字的前K/2个数字即可。有没有可能两个数组都不存在第K/2个数字呢，这道题里是不可能的，因为我们的K不是任意给的，而是给的m+n的中间值，所以必定至少会有一个数组是存在第K/2个数字的。最后就是二分法的核心啦，比较这两个数组的第K/2小的数字midVal1和midVal2的大小，如果第一个数组的第K/2个数字小的话，那么说明我们要找的数字肯定不在nums1中的前K/2个数字，所以我们可以将其淘汰，将nums1的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归。反之，我们淘汰nums2中的前K/2个数字，并将nums2的起始位置向后移动K/2个，并且此时的K也自减去K/2，调用递归即可。
 * @params
 * @return
 **/