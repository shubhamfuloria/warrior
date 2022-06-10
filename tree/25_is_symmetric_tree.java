
import java.util.*;
import util.*;

class Program {

  static boolean isSymmetric(BinaryTreeNode root1, BinaryTreeNode root2) {

    if (root1 == null && root2 == null) {
      return true;
    } else if (root1 == null || root2 == null) {
      return false;
    } else if (root1.value != root2.value) {
      return false;
    }

    boolean is_left_sym = isSymmetric(root1.left, root2.right);
    boolean is_right_sym = isSymmetric(root1.right, root2.left);

    return is_left_sym && is_right_sym;
  }

  static boolean isSymmetric(BinaryTreeNode root) {
    return isSymmetric(root.left, root.right);
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    boolean res = isSymmetric(root);
    System.out.println(res);
  }
}