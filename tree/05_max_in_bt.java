import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

import util.*;

class Program {

  public static int maxInBtree(BinaryTreeNode root) {

    if (root == null) {
      return Integer.MIN_VALUE;
    }

    int left_max = maxInBtree(root.left);
    int right_max = maxInBtree(root.right);

    return Math.max(left_max, Math.max(right_max, root.value));
  }

  public static int maxInBtree2(BinaryTreeNode root) {
    Queue<BinaryTreeNode> q = new LinkedList<>();

    int res = Integer.MIN_VALUE;
    q.offer(root);

    while (q.isEmpty() == false) {

      BinaryTreeNode rem = q.poll();
      res = Math.max(res, rem.value);

      if (rem.left != null) {
        q.offer(rem.left);
      }
      if (rem.right != null) {
        q.offer(rem.right);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);
    int res = maxInBtree2(root);
    System.out.println(res);
  }
}