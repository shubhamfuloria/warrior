import java.util.ArrayList;
import java.util.Stack;
import util.BinaryTreeNode;
import util.Tree;

class Program {

  public static void inorder(BinaryTreeNode root) {

    if (root == null) {
      return;
    }

    inorder(root.left);
    System.out.print(root.value + " ");
    inorder(root.right);
  }

  public static ArrayList<Integer> inorderIterative(BinaryTreeNode root) {

    ArrayList<Integer> res = new ArrayList<>();
    Stack<BinaryTreeNode> stk = new Stack<>();
    BinaryTreeNode currentNode = root;
    stk.push(root);
    boolean done = false;
    while (done == false) {

      if (currentNode != null) {
        stk.push(currentNode);
        currentNode = currentNode.left;
      } else {
        if (stk.empty()) {
          done = true;
        } else {
          currentNode = stk.pop();
          res.add(currentNode.value);
          currentNode = currentNode.right;
        }
      }
    }

    return res;

  }

  public static void main(String[] args) {

    Integer[] A = { 50, 25, 12, null, null, 37, 30, null, 75, 62, null, 70, 87, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    // ArrayList<Integer> res = inorder(root);
    inorder(root);

    // for (int el : res) {
    // System.out.print(el + " ");
    // }
    // System.out.println();
  }
}
