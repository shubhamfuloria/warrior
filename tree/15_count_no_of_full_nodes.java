
import java.util.*;
import util.*;

class Program {

  static int noOfFullNodes(BinaryTreeNode root) {

    Queue<BinaryTreeNode> q = new LinkedList<>();

    q.offer(root);
    int res = 0;
    while (q.isEmpty() == false) {
      BinaryTreeNode rem = q.poll();

      // counting
      if (rem.left != null && rem.right != null) {
        res++;
      }

      if (rem.left != null) {
        q.offer(rem.left);
      }

      if (rem.right != null) {
        q.offer(rem.right);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);
    int res = noOfFullNodes(root);
    System.out.println(res);

  }
}