package com.acseed.practice.algorithms.trees.redblack;

import com.acseed.practice.algorithms.trees.BinarySearchTree;

import java.util.Objects;

/**
 * implementation of red black tree
 * Date: 2019-08-18 14:21
 *
 * @author hongchen.cao
 */
public class RBTree<K extends Comparable<K>, V> implements BinarySearchTree<K, V> {

    /**
     * the root of this tree
     */
    private RBNode<K, V> root;

    /**
     * factory method for a empty tree
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K extends Comparable<K>, V> RBTree<K, V> create() {
        return new RBTree<>();
    }

    private RBTree() {
        this.root = null;
    }

    /**
     * put key, val into the tree
     * @param key
     * @param val
     * @return the val of this key
     */
    @Override
    public V put(K key, V val) {
        //new node always red
        RBNode<K, V> node = new RBNode<>(key, val, Color.RED);
        insert(node);
        return val;
    }

    /**
     * insert x to the tree
     * @param node node to insert
     */
    private void insert(RBNode<K, V> node) {
        RBNode<K, V> p = null;
        RBNode<K, V> y = this.root;
        while (y != null) {
            p = y;
            int cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                y = y.left;
            } else if (cmp > 0) {
                y = y.right;
            } else {
                y.val = node.val;
                return;
            }
        }

        node.parent = p;
        if (Objects.isNull(p)) {
            this.root = node;
        } else if (node.key.compareTo(p.key) < 0) {
            p.left = node;
        } else {
            p.right = node;
        }

        insertFixUp(node);
    }

    /**
     * there is three cases
     * 1. the position of node is a 2 node, which means the parent is black, so nothing have to do
     * 2. the node join a 3 node, when we insert the node, it becomes a 4 node,
     *    so, we should keep the 4 node balance,
     * 3. the node join a 4 node, it becomes a temporary 5 node, we should split the origin 4 node,
     *    transmit the middle value to the parent, so, we can process up recursively
     */
    private void insertFixUp(RBNode<K, V> node) {
        while (node.parent != null
                && node.parent.color == Color.RED) {
            if (node.parent == node.parent.parent.left) {
                RBNode<K, V> uncle = node.parent.parent.right;
                // we joi a 3 node, only should rotate and recolor
                // null will be treated as black
                if (null == uncle || uncle.color == Color.BLACK) {
                    if (node == node.parent.right) {
                        node = node.parent;
                        leftRotate(node);
                    }

                    rightRotate(node.parent);

                    /**
                     * after rote, the node is the root of the subTree
                     */
                    node.parent.color = Color.BLACK;
                    node.parent.right.color = Color.RED;
                } else {
                    /**
                     * when we split the 4 node, the parent is black , job done
                     */
                    split4Node(node.parent.parent);

                    /**
                     * the grandfather is red, may conflict with tree properties,
                     * we go up to fix this
                     */
                    node = node.parent.parent;
                }
            } else { // the opposite way
                RBNode<K, V> uncle = node.parent.parent.left;
                if (null == uncle || uncle.color == Color.BLACK) {
                    if (node == node.parent.left) {
                        node = node.parent;
                        rightRotate(node);
                    }
                    leftRotate(node.parent.parent);
                    node.parent.color = Color.BLACK;
                    node.parent.left.color = Color.RED;
                } else {
                    split4Node(node.parent.parent);
                    node = node.parent.parent;
                }
            }
        }

        this.root.color = Color.BLACK;
    }

    /**
     * split the 4 node
     * @param p
     */
    private void split4Node(RBNode<K, V> p) {
        p.color = Color.RED;
        p.left.color = Color.BLACK;
        p.right.color = Color.BLACK;
    }

    /**
     * left rotate the subTree node
     * @param node
     */
    private RBNode<K, V> leftRotate(RBNode<K, V> node) {
        RBNode<K, V> right = node.right;
        if (node.parent != null) {
            if (node == node.parent.left) {
                node.parent.left = right;
            } else {
                node.parent.right = right;
            }
        } else {
            this.root = right;
        }



        node.right = right.left;
        right.left = node;
        right.parent = node.parent;
        node.parent = right;
        fixSize(node);
        fixSize(right);
        return right;
    }

    private void fixSize(RBNode<K, V> node) {
        node.size = size(node.left) + size(node.right);
    }

    private int size(RBNode<K, V> node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        return node.size;
    }

    /**
     * right rotate the subTree node
     * @param node
     */
    private RBNode<K, V> rightRotate(RBNode<K, V> node) {
        RBNode<K, V> left = node.left;
        if (node.parent != null) {
            if (node == node.parent.left) {
                node.parent.left = left;
            } else {
                node.parent.right = left;
            }
        } else {
            this.root = left;
        }

        left.parent = node.parent;
        node.left = left.right;
        left.right = node;
        node.parent = left;

        fixSize(node);
        fixSize(left);
        return left;
    }

    public int maxDepth() {
        return maxDepth(this.root);
    }

    private int maxDepth(RBNode<K, V> node) {
        if (Objects.isNull(node)) {
            return 0;
        }

        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }

    private void printLeftToParentBranchTop(int w) {
        putchars(' ', w + 1);
        putchars('_', w - 3);
        System.out.print("/ ");
    }

    private void printRightToParentBranchTop(int w) {
        System.out.print('\\');
        putchars('_', w - 3);
        printW(" ", w + 2);
    }

    private void printLeftToParentBranchBottom(int w) {
        printW("/", w + 1);
        printW(" ", w - 1);
    }

    private void printRightToParentBranchBottom(int w) {
        printW("\\", w - 1);
        printW(" ", w + 1);
    }

    public void printTree() {
        int maxDepth = maxDepth();
        RBNode[] array = fillArray(maxDepth);
        for (int j = 0, index = 1; j < maxDepth; ++j) {
            int w = 1 << (maxDepth - j + 1);
            if (j > 0) {
                // Top part of node to parent branch
                for(int i = 0; i < 1 << j; i++) {
                    if (array[index + i] != null) {
                        if (i % 2 == 0) {
                            printLeftToParentBranchTop(w);
                        } else {
                            printRightToParentBranchTop(w);
                        }
                    } else {
                        putchars(' ', w * 2);
                    }
                }
                System.out.print('\n');
                // Bottom part of node to parent branch
                for (int i = 0; i < 1 << j; i++) {
                    if (array[index + i] != null) {
                        if (i % 2 == 0) {
                            printLeftToParentBranchBottom(w);
                        } else {
                            printRightToParentBranchBottom(w);
                        }
                    } else {
                        putchars(' ', w * 2);
                    }
                }
                System.out.print('\n');
            }
            for (int i = 0; i < (1 << j); ++i, ++index) {
                if (array[index] != null) {
                    putchars(' ', 2 * w - printNode(array[index], w));
                } else {
                    putchars(' ', w * 2);
                }
            }
            System.out.println();
        }
    }

    private void putchars(char c, int n) {
        while (n > 0) {
            System.out.print(c);
            --n;
        }
    }

    private int printW(String str, int w) {
        StringBuilder sb = new StringBuilder();
        int ret = str.length();
        if (str.length() < w) {
            int cnt = str.length();
            ret += w - cnt;
            putchars(' ', w - cnt);
        }
        System.out.printf("%s", str);
        return ret;
    }

    private int printNode(RBNode node, int w) {
        String str = node.key.toString();
        str += "(" + (Color.BLACK == node.color ? "B" : "R") + ")";
        int ret = printW(str, w);
        return ret;
    }

    private RBNode[] fillArray(int depth) {
        RBNode[] array = new RBNode[(1 << depth) | 1];
        fillArray(array, 1, this.root);
        return array;
    }

    private void fillArray(RBNode[] array, int index, RBNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        array[index] = node;
        fillArray(array, index << 1, node.left);
        fillArray(array, (index << 1) | 1, node.right);
    }

    //for node color
    enum Color {
        RED,BLACK
    }

    //node in the tree
    static class RBNode<K extends Comparable<K>, V> {
        Color color;
        RBNode<K, V> parent;
        RBNode<K, V> left;
        RBNode<K, V> right;
        int size = 0;
        K key;
        V val;

        RBNode(K key, V val, Color color) {
            this.key = key;
            this.val = val;
            this.parent = null;
            this.left = null;
            this.right = null;
            this.size = 1;
            this.color = color;
        }
    }
}
