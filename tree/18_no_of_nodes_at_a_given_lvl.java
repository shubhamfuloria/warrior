
import java.util.*;
import util.*;

class Program {

  public static int noOfNodesAtGivenLvl(BinaryTreeNode root, int depth) {

    if (root == null) {
      return 0;
    } else if (depth == 0) {
      return 1;
    }

    int left_nodes = noOfNodesAtGivenLvl(root.left, depth - 1);
    int right_nodes = noOfNodesAtGivenLvl(root.right, depth - 1);

    return left_nodes + right_nodes;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    int res = noOfNodesAtGivenLvl(root, 1);
    System.out.println(res);

  }
}