import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.*;
import util.*;

class Program {

  public static BinaryTreeNode deepestNode(BinaryTreeNode root) {

    // last node proeccessed in the queue from level order traversal is deepest node

    Queue<BinaryTreeNode> q = new LinkedList<>();

    q.offer(root);
    BinaryTreeNode rem = null;
    while (q.isEmpty() == false) {

      rem = q.poll();

      if (rem.left != null) {
        q.offer(rem.left);
      }

      if (rem.right != null) {
        q.offer(rem.right);
      }
    }

    return rem;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    int res = deepestNode(root).value;
    System.out.println(res);
  }
}