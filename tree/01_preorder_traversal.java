import java.util.ArrayList;
import java.util.Stack;
import util.*;

class Program {

  public static void preorder(BinaryTreeNode root) {

    if (root == null) {
      return;
    }

    System.out.print(root.value + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static ArrayList<Integer> preorderIterative(BinaryTreeNode root) {

    ArrayList<Integer> res = new ArrayList<>();
    Stack<BinaryTreeNode> stk = new Stack<>();

    stk.push(root);

    while (stk.empty() == false) {
      BinaryTreeNode node = stk.pop();

      // System.out.println(node.value);
      res.add(node.value);

      if (node.right != null) {
        stk.push(node.right);
      }

      if (node.left != null) {
        stk.push(node.left);
      }

    }

    return res;

  }

  public static void main(String[] args) {

    Integer[] A = { 50, 25, 12, null, null, 37, 30, null, 75, 62, null, 70, 87, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    ArrayList<Integer> res = preorderIterative(root);

    for (int el : res) {
      System.out.print(el + " ");
    }
    System.out.println();
  }
}
