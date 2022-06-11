import java.util.*;
import util.*;

class Program {

  public static int getIndex(int[] A, int start, int end, int target) {
    for (int i = start; i <= end; i++) {
      if (A[i] == target) {
        return i;
      }
    }
    return -1;
  }

  public static BinaryTreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

    if (inStart > inEnd || preStart > preEnd) {
      return null;
    }

    // first element in pre traversal will be root
    BinaryTreeNode root = new BinaryTreeNode(pre[preStart]);

    int rootIndex = getIndex(in, inStart, inEnd, pre[preStart]);

    int leftTreeSize = rootIndex - inStart;
    int rightTreeSize = inEnd - rootIndex;

    // all elements on left side of rootIndex will be in left subtree of root
    root.left = buildTree(pre, preStart + 1, preStart + leftTreeSize, in, inStart, rootIndex - 1);
    root.right = buildTree(pre, preEnd - rightTreeSize + 1, preEnd, in, rootIndex + 1, inEnd);

    return root;
  }

  public static void main(String[] args) {
    int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
    int[] in = { 4, 2, 5, 1, 6, 3, 7 };

    int preStart = 0, inStart = 0;
    int preEnd = pre.length - 1, inEnd = in.length - 1;
    BinaryTreeNode root = buildTree(pre, preStart, preEnd, in, inStart, inEnd);

    Tree.preorder(root);
    System.out.println();
  }
}