package binary_tree;

import dynamic_array.Dynamic_Array;

import java.util.Arrays;
import java.util.Random;

public class Binary_Tree {

  Tree_Node rootNode;
	
  public Binary_Tree(int height) {

    rootNode = new Tree_Node(-1);
    initRandomTree(height);

  }

  public void initRandomTree(int height) {

    Random rand = new Random();
    int counter = 0;
    Tree_Node[] prevLeaves = new Tree_Node[1];
    Tree_Node[] newLeaves = new Tree_Node[2];
    
    prevLeaves[0] = rootNode;

    for(int level = 1; level < height; level++) {

      newLeaves = new Tree_Node[(int)Math.pow(2, level)];
    	
      for(int i = 0; i < prevLeaves.length; i++) {

        newLeaves[i * 2] = addNode(prevLeaves[i], "left", rand.nextInt(100));
        newLeaves[i * 2 + 1] = addNode(prevLeaves[i], "right", rand.nextInt(100));
        counter++;

      } prevLeaves = newLeaves;
      
    }

  }

  public Tree_Node addNode(Tree_Node parent, String orientation, int data) {

     Tree_Node node = new Tree_Node(data);

     if(orientation.equals("left")) { parent.setLeftNode(node); }
     if(orientation.equals("right")) { parent.setRightNode(node); }

     return node;

  }

}
