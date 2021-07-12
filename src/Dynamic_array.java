import java.util.*;

public class Dynamic_array {

  int[] mainArray;
  public Dynamic_array(int length) {

    mainArray = new int[length];
    for(int i = 0; i < mainArray.length; i++) mainArray[i] = -1;

  }

  public void insert(int num) {

    //Start at end and check for last non-null element
    //Insert num right after
    outer: 
    for(int i = mainArray.length - 1; i >= -1; i--) {

      if(i == -1 || mainArray[i] != -1) {
    	  
        //Check if array needs expansion
        /* This app only expands the array by 1 each time.
           However, this app is set up in a way where it would
           be easy to change this to doubling the array size and
           filling the end with null entries, etc. */
        if(i + 1 >= mainArray.length) {
        	
          mainArray = concantenate(mainArray, new int[] { num });

        } else { mainArray[i + 1] = num; }

      break outer;
      }

    }

  }

  public void removeAt(int i) {

    int[] first = new int[i];
    int[] second = new int[mainArray.length - (i+1)];

    for(int n = 0; n < first.length; n++) first[n] = mainArray[n];
    for(int n = 0; n < second.length; n++) second[n] = mainArray[n + first.length + 1];

    mainArray = concantenate(first, second);

  }

  public int locationOf(int i) {

    for(int n = 0; n < mainArray.length; n++) {
      if(mainArray[n] == i) return n;
    }

    return -1;

  }

  public String toString() {

    String arrayString = "[" + Integer.toString(mainArray[0]);

    for(int i = 1; i < mainArray.length; i++) {
      arrayString = arrayString + "," + Integer.toString(mainArray[i]);
    }
    arrayString = arrayString + "]";

    return arrayString;

  }


  //Private util classes
  private int[] concantenate(int[] first, int[] second) {

    int tempArray[] = new int[first.length + second.length];

    for(int i = 0; i < first.length; i++) tempArray[i] = first[i];
    for(int i = 0; i < second.length; i++) tempArray[i + first.length] = second[i];

    return tempArray;

  }

}
