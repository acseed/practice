package com.acseed.practice.algorithms.trees;

/**
 * Date: 2019-08-18 14:35
 *
 * @author hongchen.cao
 */
public interface BinarySearchTree<K extends Comparable<K>, V> {

    V put(K key, V val);
}
