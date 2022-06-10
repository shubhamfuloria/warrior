
import java.util.*;
import util.*;

class Program {
  // width of bt: maximum number of nodes at any level.



  public static int height(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }

    int left_height = height(root.left);
    int right_height = height(root.right);

    return Math.max(left_height, right_height) + 1;
  }

  public static int calculateWidth(BinaryTreeNode root) {

    int levels = height(root);
    int width = 0;
    for (int i = 0; i < levels; i++) {
      int curr_width = noOfNodesAtGivenLvl(root, i);
      width = Math.max(curr_width, width);
    }

    return width;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    int res = calculateWidth(root);
    System.out.println(res);

  }
}