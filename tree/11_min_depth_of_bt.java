import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.*;
import util.*;

class Program {

  static int minDepth2(BinaryTreeNode root) {
    // the first leaf node processed from level order is minDepht

    Queue<BinaryTreeNode> q = new LinkedList<>();

    q.offer(root);
    int min_depth = 0;
    while (q.isEmpty() == false) {

      int size = q.size();

      for (int i = 0; i < size; i++) {
        BinaryTreeNode rem = q.poll();

        if (rem.left == null && rem.right == null) {
          return min_depth + 1;
        }

        if (rem.left != null) {
          q.offer(rem.left);
        }

        if (rem.right != null) {
          q.offer(rem.right);
        }
      }

      min_depth++;

    }

    return min_depth;

  }

  static int minDepth(BinaryTreeNode root) {

    if (root == null) {
      return Integer.MAX_VALUE - 1;
    } else if (root.left == null && root.right == null) {
      return 1;
    }

    int left_min_depth = minDepth(root.left);
    int right_min_depth = minDepth(root.right);

    return Math.min(left_min_depth, right_min_depth) + 1;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    int res = minDepth2(root);
    System.out.println(res);
  }
}