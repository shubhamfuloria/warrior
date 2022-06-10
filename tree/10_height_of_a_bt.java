import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.*;
import util.*;

class Program {

  static int height(BinaryTreeNode root) {

    if (root == null) {
      return 0;
    }

    int left_subtree_height = height(root.left);
    int right_subtree_height = height(root.right);

    return Math.max(left_subtree_height, right_subtree_height) + 1;
  }

  public static int height2(BinaryTreeNode root) {

    Queue<BinaryTreeNode> q = new LinkedList<>();

    q.offer(root);
    int height = 0;
    while (q.isEmpty() == false) {

      int size = q.size();

      for (int i = 0; i < size; i++) {
        BinaryTreeNode rem = q.poll();

        if (rem.left != null) {
          q.offer(rem.left);
        }

        if (rem.right != null) {
          q.offer(rem.right);
        }
      }

      height++;

    }
    return height;

  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    int res = height2(root);
    System.out.println(res);
  }
}