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

  public static BinaryTreeNode buildTree(int[] post, int postStart, int postEnd, int[] in, int inStart, int inEnd) {

    if (postStart > postEnd || inStart > inEnd) {
      return null;
    }

    // last element of postorder traversal will be root

    BinaryTreeNode root = new BinaryTreeNode(post[postEnd]);

    int rootIndex = getIndex(in, inStart, inEnd, root.value);

    int leftSubtreeSize = rootIndex - inStart;
    int rightSubTreeSize = inEnd - rootIndex;

    root.left = buildTree(post, postStart, postStart + leftSubtreeSize - 1, in, inStart, rootIndex - 1);
    root.right = buildTree(post, postEnd - rightSubTreeSize, postEnd - 1, in, rootIndex + 1, inEnd);

    return root;
  }

  public static void main(String[] args) {
    int[] post = { 4, 5, 2, 6, 7, 3, 1 };
    int[] in = { 4, 2, 5, 1, 6, 3, 7 };

    int postStart = 0, inStart = 0;
    int postEnd = post.length - 1, inEnd = in.length - 1;
    BinaryTreeNode root = buildTree(post, postStart, postEnd, in, inStart, inEnd);

    Tree.preorder(root);
    System.out.println();
  }
}