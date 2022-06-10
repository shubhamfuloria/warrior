import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

import util.*;

class Program {
  public static int size(BinaryTreeNode root) {

    if (root == null) {
      return 0;
    }

    int left_st_size = size(root.left);
    int right_st_size = size(root.right);

    return left_st_size + right_st_size + 1;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    int res = size(root);
    System.out.println(res);
  }
}