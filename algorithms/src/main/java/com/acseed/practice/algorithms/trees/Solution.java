package com.acseed.practice.algorithms.trees;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @author hongchen.cao
 * @date 2020/03/19 19:03
 **/
public class Solution {
    public static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode parent;
    }


    private static final List<Character> symbols = Lists.newArrayList(')', '(', ',');
    public static TreeNode buildTree(String str, int start, int end) {
        if (start >= end) {
            return null;
        }

        int index = start;
        StringBuilder sb = new StringBuilder();
        char c = str.charAt(index);
        while (!symbols.contains(str.charAt(index))) {
            sb.append(c);
            index++;
        }
        String val = sb.toString();

        int commaIndex = findComma(str, index, end);

        TreeNode root = new TreeNode();
        root.val = val;

        root.left = buildTree(str, index + 1, commaIndex - 1);
        root.right = buildTree(str, commaIndex + 1, end - 1);
        if (Objects.nonNull(root.left)) {
            root.left.parent = root;
        }

        if (Objects.nonNull(root.right)) {
            root.right.parent = root;
        }
        return root;

    }

    private static int findComma(String str, int start, int end) {
        Stack<Integer> symbolStack = new Stack<>();
        int index = start;
        while (index < end) {
            if (str.charAt(index) == '(') {
                symbolStack.add(index);
            } else if (str.charAt(index) == ')') {
                symbolStack.pop();
            } else if (str.charAt(index) == ',' && symbolStack.size() == 1) {
                return index;
            }
            ++index;
        }
        return -1;
    }
    public static void main(String[] args) {
        String str = "A(B(C(,),),E(,))";
        TreeNode root = buildTree(str, 0, str.length() - 1);
        System.out.println();
    }
}
