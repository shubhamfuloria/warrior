
import java.util.*;
import util.*;

class Program {

  public static boolean hasPathSum(BinaryTreeNode root, int targetSum) {

    if (root == null) {
      return false;
    } else if (root.left == null && root.right == null && targetSum == root.value) {
      return true;
    }

    boolean left_has_path_sum = hasPathSum(root.left, targetSum - root.value);
    boolean right_has_path_sum = hasPathSum(root.right, targetSum - root.value);

    return left_has_path_sum || right_has_path_sum;

  }

  

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    boolean res = hasPathSum(root, 10);
    System.out.println(res);
  }
}