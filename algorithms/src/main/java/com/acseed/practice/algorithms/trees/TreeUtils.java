package com.acseed.practice.algorithms.trees;

import com.acseed.practice.algorithms.trees.redblack.RBTree;

/**
 * Date: 2019-08-18 16:04
 *
 * @author hongchen.cao
 */
public class TreeUtils {
    public static void printTree(RBTree tree) {

    }

    public static void main(String[] args) {
        RBTree<String, String> tree = RBTree.create();
        tree.put("E", "A");
        tree.put("A", "A");
        tree.put("R", "A");
        tree.put("C", "A");
        tree.put("H", "A");
        tree.put("X", "A");
        tree.put("M", "A");
//        tree.printTree();
        tree.put("P", "A");
        tree.put("L", "A");
        tree.put("S", "A");
        tree.printTree();
//        tree.put("J", "A");
//        tree.put("K", "A");
//        tree.put("L", "A");
//        tree.put("M", "A");
//        tree.put("N", "A");
//        tree.put("O", "A");
//        tree.put("P", "A");
//        tree.put("Q", "A");
//        tree.put("R", "A");
//        tree.put("S", "A");
//        tree.put("T", "A");
//        tree.put("U", "A");
//        tree.put("V", "A");
//        tree.put("W", "A");
//        tree.put("X", "A");
//        tree.put("Y", "A");
//        tree.put("Z", "A");
//        tree.put("Y", "B");
//        tree.printTree();


    }
}
