
import java.util.*;
import util.*;

class Program {
  // width of bt: maximum number of nodes at any level.

  public static int maxLevelSum(BinaryTreeNode root) {
    Queue<BinaryTreeNode> q = new LinkedList<>();

    q.offer(root);
    int curr_level = 0;
    int res_level = 1;
    int max_sum = Integer.MIN_VALUE;

    while (q.isEmpty() == false) {
      int size = q.size();
      int curr_sum = 0;
      curr_level++;
      for (int i = 0; i < size; i++) {
        BinaryTreeNode rem = q.poll();
        curr_sum += rem.value;

        if (rem.left != null) {
          q.offer(rem.left);
        }

        if (rem.right != null) {
          q.offer(rem.right);
        }
      }

      if (curr_sum > max_sum) {
        max_sum = curr_sum;
        res_level = curr_level;
      }
    }

    return res_level;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    int res = maxLevelSum(root);
    System.out.println(res);

  }
}