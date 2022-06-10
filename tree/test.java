import util.*;
import java.util.Stack;

class Program {

  static class Pair {
    public BinaryTreeNode node;
    public int state;

    public Pair(BinaryTreeNode node) {
      this.node = node;
      this.state = 1;
    }

  }

  public static void traversals(BinaryTreeNode root) {
    Stack<Pair> stk = new Stack<>();

    String preorder = "Pre: ";
    String inorder = "In: ";
    String postorder = "Post: ";

    stk.push(new Pair(root));

    while (stk.empty() == false) {
      Pair top = stk.peek();

      if (top.state == 1) {
        preorder += top.node.value + ", ";
        if (top.node.left != null) {
          stk.push(new Pair(top.node.left));
        }
        top.state++;
      } else if (top.state == 2) {
        inorder += top.node.value + ", ";
        if (top.node.right != null) {
          stk.push(new Pair(top.node.right));
        }
        top.state++;
      } else {
        postorder += top.node.value + ", ";
        stk.pop();
      }
    }
    System.out.println(preorder);
    System.out.println(inorder);
    System.out.println(postorder);

  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 3, 4, 5, 6, 7, null, null, null, null, null, null, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);
    traversals(root);
  }
}