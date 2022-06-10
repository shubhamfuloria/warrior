import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.*;
import util.*;

class Program {

  static int countLeaves(BinaryTreeNode root) {

    if (root == null) {
      return 0;
    } else if (root.left == null && root.right == null) {
      return 1;
    }

    int left_leaves = countLeaves(root.left);
    int right_leaves = countLeaves(root.right);

    return left_leaves + right_leaves;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);
    int res = countLeaves(root);
    System.out.println(res);

  }
}