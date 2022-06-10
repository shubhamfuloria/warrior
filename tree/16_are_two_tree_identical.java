
import java.util.*;
import util.*;

class Program {

  static boolean areIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {

    if (root1 == null && root2 == null) {
      return true;
    } else if (root1 == null) {
      return false;
    } else if (root2 == null) {
      return false;
    }

    boolean is_left_st_identical = areIdentical(root1.left, root2.left);
    boolean is_right_st_identical = areIdentical(root1.right, root2.right);

    return is_left_st_identical && is_right_st_identical;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    Integer[] B = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null };
    BinaryTreeNode root1 = Tree.constructTree(A, 0, A.length - 1);
    BinaryTreeNode root2 = Tree.constructTree(B, 0, B.length - 1);

    // int res = noOfFullNodes(root);
    boolean res = areIdentical(root1, root2);
    System.out.println(res);

  }
}