package binary_tree;

import dynamic_array.Dynamic_Array;
import java.util.Random;

public class Binary_Tree {

  Tree_Node rootNode;
	
  public Binary_Tree() {

    rootNode = new Tree_Node(-1);
    
    initRandomTree(4);

  }

  public void initRandomTree(int height) {

    Random rand = new Random();
    int counter = 0;
    Tree_Node[] prevLeaves = new Tree_Node[2];
    Tree_Node[] newLeaves = new Tree_Node[2];

    for(int n = 1; n < height; n++) {

      newLeaves = new Tree_Node[(int)Math.pow(2, n)];
    	
      for(int i = 0; i < prevLeaves.length; i++) {

        newLeaves[i] = addNode(rootNode, "left", rand.nextInt(100));
        newLeaves[i] = addNode(rootNode, "right", rand.nextInt(100));
        counter++;

      } prevLeaves = newLeaves;

    } System.out.println(counter);

  }

  public Tree_Node addNode(Tree_Node parent, String orientation, int data) {

     Tree_Node node = new Tree_Node(data);

     if(orientation.equals("left")) { parent.setLeftNode(node); }
     if(orientation.equals("right")) { parent.setRightNode(node); }

     return node;

  }

}
