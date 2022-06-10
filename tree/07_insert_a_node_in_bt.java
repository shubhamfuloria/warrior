import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

import util.*;

class Program {

  public static void insertNode(BinaryTreeNode root, int data) {
    Queue<BinaryTreeNode> q = new LinkedList<>();

    q.offer(root);

    while (q.isEmpty() == false) {

      BinaryTreeNode rem = q.poll();

      if (rem.left != null) {
        q.offer(rem.left);
      } else {
        rem.left = new BinaryTreeNode(data);
        return;
      }

      if (rem.right != null) {
        q.offer(rem.right);
      } else {
        rem.right = new BinaryTreeNode(data);
        return;
      }

    }
  }

  public static void insertRecursive(BinaryTreeNode root, int data) {

    if (root == null) {
      root = new BinaryTreeNode(data);
    }

    if (root.left == null) {
      root.left = new BinaryTreeNode(data);
      return;
    } else if (root.right == null) {
      root.right = new BinaryTreeNode(data);
      return;
    } else {
      insertRecursive(root.left, data);
    }

  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);
    insertRecursive(root, 100);
    Tree.preorder(root);
  }
}