package org.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        List<Integer> result = new ArrayList<>();
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        for(int index=0; index<nums.length; index++){
            int remainder = target - nums[index];
            if(numsList.contains(remainder) && !result.contains(numsList.indexOf(remainder)) && index != numsList.indexOf(remainder)){
                result.add(index);
                result.add(numsList.indexOf(remainder));
            }
        }

//        return result.stream().toArray(Integer[]::new);
        return result.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args) {

        TwoSum twoSum = new TwoSum();

        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] result = twoSum.twoSum(nums, target);
        System.out.println("Input: nums = [2,7,11,15], target = 9");
        System.out.println("Output: ");
        Arrays.stream(result).forEach(System.out::println);

        System.out.println();

        int[] nums1 = new int[]{3,2,4};
        int target1 = 6;
        int[] result2 = twoSum.twoSum(nums1, target1);
        System.out.println("Input: nums = [3,2,4], target = 6");
        System.out.println("Output: ");
        Arrays.stream(result2).forEach(System.out::println);

        int[] nums2 = new int[]{3,3};
        int target2 = 6;
        int[] result3 = twoSum.twoSum(nums2, target2);
        System.out.println("Input: nums = [3,3], target = 6");
        System.out.println("Output: ");
        Arrays.stream(result3).forEach(System.out::println);
    }
}
