import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.*;
import util.*;

class Program {

  public static void reverseLvlOrder(BinaryTreeNode root) {

    Stack<BinaryTreeNode> stk = new Stack<>();
    Queue<BinaryTreeNode> q = new LinkedList<>();

    q.offer(root);

    while (q.isEmpty() == false) {
      BinaryTreeNode rem = q.poll();
      stk.push(rem);

      if (rem.right != null) {
        q.offer(rem.right);
      }

      if (rem.left != null) {
        q.offer(rem.left);
      }

    }

    while (stk.empty() == false) {
      System.out.print(stk.pop().value + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    reverseLvlOrder(root);
    // System.out.println(res);
  }
}