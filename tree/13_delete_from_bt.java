import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;
import java.util.*;
import util.*;

class Program {

  public static void deleteFromBt(BinaryTreeNode root, int key) {

    // last node proeccessed in the queue from level order traversal is deepest node

    Queue<BinaryTreeNode> q = new LinkedList<>();

    q.offer(root);
    BinaryTreeNode lastNode = null;
    BinaryTreeNode targetNode = null;
    while (q.isEmpty() == false) {

      lastNode = q.poll();

      if (lastNode.value == key) {
        targetNode = lastNode;
      }

      if (lastNode.left != null) {
        q.offer(lastNode.left);
      }

      if (lastNode.right != null) {
        q.offer(lastNode.right);
      }
    }

    targetNode.value = lastNode.value;

    q.clear();
    q.offer(root);
    while (q.isEmpty() == false) {

      BinaryTreeNode rem = q.poll();

      if (rem.left == lastNode) {
        rem.left = null;
      } else if (rem.right == lastNode) {
        rem.right = null;
      }

      if (rem.left != null) {
        q.offer(rem.left);
      }

      if (rem.right != null) {
        q.offer(rem.right);
      }
    }

  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);
    Tree.preorder(root);
    System.out.println();
    deleteFromBt(root, 4);
    // System.out.println(res);
    Tree.preorder(root);
    System.out.println();

  }
}