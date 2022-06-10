
import java.util.*;
import util.*;

class Program {

  static int sumBT(BinaryTreeNode root) {

    if (root == null) {
      return 0;
    }

    int left_bt_sum = sumBT(root.left);
    int right_bt_sum = sumBT(root.right);

    return root.value + left_bt_sum + right_bt_sum;
  }

  public static int sumOfBT(BinaryTreeNode root) {

    Queue<BinaryTreeNode> q = new LinkedList<>();

    q.offer(root);

    int sum = 0;

    while (q.isEmpty() == false) {

      int size = q.size();

      for (int i = 0; i < size; i++) {
        BinaryTreeNode rem = q.poll();

        sum += rem.value;

        if (rem.left != null) {
          q.offer(rem.left);
        }

        if (rem.right != null) {
          q.offer(rem.right);
        }
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    int res1 = sumBT(root);
    int res2 = sumOfBT(root);

    System.out.println(res1);
    System.out.println(res2);
  }
}