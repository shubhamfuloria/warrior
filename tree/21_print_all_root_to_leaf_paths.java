
import java.util.*;
import util.*;

class Program {

  public static List<List<Integer>> rootToLeafPaths(BinaryTreeNode root) {

    if (root == null) {
      return new ArrayList<>();
    } else if (root.left == null && root.right == null) {
      List<List<Integer>> res = new ArrayList<>();
      List<Integer> path = new ArrayList<>();
      path.add(root.value);
      res.add(path);
      return res;
    }

    List<List<Integer>> left_paths = rootToLeafPaths(root.left);
    List<List<Integer>> right_paths = rootToLeafPaths(root.right);

    List<List<Integer>> f_list = new ArrayList<>();

    for (List<Integer> path : left_paths) {
      path.add(0, root.value);
      f_list.add(path);
    }
    for (List<Integer> path : right_paths) {
      path.add(0, root.value);
      f_list.add(path);
    }
    return f_list;
  }

  public static void main(String[] args) {
    Integer[] A = { 1, 2, 4, null, null, 5, null, null, 3, 6, null, null, 7, null, null };
    BinaryTreeNode root = Tree.constructTree(A, 0, A.length - 1);

    List<List<Integer>> res = rootToLeafPaths(root);

    for(List<Integer> list : res) {
      for(Integer el : list) {
        System.out.print(el + " ");
      }
      System.out.println();
    }
  }
}