package util;

public class Tree {

  // generates binary tree from preorder traversal
  public static BinaryTreeNode constructTree(Integer[] A, int start, int end) {

    if (A[start] == null) {
      return null;
    } else if (end < start) {
      return null;
    }

    BinaryTreeNode root = new BinaryTreeNode(A[start]);
    int mid = (start + end) / 2;
    root.left = constructTree(A, start + 1, mid);
    root.right = constructTree(A, mid + 1, end);

    return root;
  }

  public static void preorder(BinaryTreeNode root) {

    if (root == null) {
      return;
    }

    System.out.print(root.value + " ");
    preorder(root.left);
    preorder(root.right);
  }

}
