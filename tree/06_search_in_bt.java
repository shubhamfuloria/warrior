import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

import util.*;

class Program {

  public static boolean search(BinaryTreeNode root, int target) {

    if (root == null) {
      return false;
    } else if (root.value == target) {
      return true;
    }

    boolean is_present_lst = search(root.left, target);
    boolean is_present_rst = search(root.right, target);

    return is_present_lst || is_present_rst;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);
    boolean res = search(root, 61);
    System.out.println(res);
  }
}