package binary_tree;

public class Tree_Node {

  int data;
  Tree_Node leftNode;
  Tree_Node rightNode;

  public Tree_Node(int d) {
    
    data = d;
    leftNode = null;
    rightNode = null;

  }

  public void setLeftNode(Tree_Node node) { leftNode = node; }
  public void setRightNode(Tree_Node node) { rightNode = node; }
  public void setData(int d) { data = d; }

}
