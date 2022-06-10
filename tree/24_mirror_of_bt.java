
import java.util.*;
import util.*;

class Program {

  static BinaryTreeNode mirrorTree(BinaryTreeNode root) {

    if (root == null) {
      return null;
    }

    BinaryTreeNode left_mirrored = mirrorTree(root.left);
    BinaryTreeNode right_mirrored = mirrorTree(root.right);

    root.left = right_mirrored;
    root.right = left_mirrored;

    return root;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    root = mirrorTree(root);

    Tree.preorder(root);
  }
}