import dynamic_array.Dynamic_Array;
import binary_tree.Binary_Tree;

public class Main {

  public static void main(String[] args) {

    Dynamic_Array arrayList = new Dynamic_Array(3);
    Binary_Tree binaryTree = new Binary_Tree();
    arrayList.insert(5);
    arrayList.insert(6);
    arrayList.insert(7);
    arrayList.insert(8);
    arrayList.insert(9);
    
    System.out.println(arrayList.locationOf(6));
    System.out.println(arrayList.toString());

  }

}
