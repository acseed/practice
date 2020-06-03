package com.acseed.practice.algorithms.trees.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author hongchen.cao
 * @date 2019/10/24 15:26
 **/
public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();

        if (num.length >= size && size >= 1) {
            Deque<Integer> index = new ArrayDeque<>();
            for (int i = 0; i < size; ++i) {
                while (!index.isEmpty() && num[i] >= num[index.getLast()]) {
                    index.pollLast();
                }

                index.addLast(i);
            }

            for (int i = size; i < num.length; ++i) {
                result.add(num[index.getFirst()]);
                while (!index.isEmpty() && num[i] >= num[index.getLast()]) {
                    index.pollLast();
                }

                while (!index.isEmpty() && i - index.getFirst() + 1 > size) {
                    index.pollFirst();
                }
                index.addLast(i);
            }

            result.add(num[index.getFirst()]);
        }

        return result;
    }

    private Integer max(int[] num, int start, int end) {
        int max = num[start];
        for (int i = start + 1; i <= end; ++i) {
            max = max > num[i] ? max : num[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] num = {2,3,4,2,6,2,5,1};
        List<Integer> result = new Solution().maxInWindows(num, 3);
        System.out.println(result);
    }
}