
import java.util.*;
import util.*;

class Program {

  static int height(BinaryTreeNode root) {

    if (root == null) {
      return 0;
    }

    int left_height = height(root.left);
    int right_height = height(root.right);

    return Math.max(left_height, right_height) + 1;
  }

  static int diameter(BinaryTreeNode root) {

    if (root == null) {
      return 0;
    }

    int left_subtree_diameter = diameter(root.left);
    int right_subtree_diameter = diameter(root.right);

    int root_diameter = height(root.left) + height(root.right) + 1;

    return Math.max(left_subtree_diameter, Math.max(right_subtree_diameter, root_diameter));
  }

  private static int diameter = 0;

  public static int calculatesDiaReturnsHeight(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }

    int left_height = height(root.left);
    int right_height = height(root.right);

    diameter = Math.max(diameter, left_height + right_height + 1);

    return Math.max(left_height, right_height) + 1;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    // int res = noOfFullNodes(root);
    // int res = diameter(root);
    calculatesDiaReturnsHeight(root);
    System.out.println(diameter);

  }
}