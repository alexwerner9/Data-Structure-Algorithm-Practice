package dynamic_array;
import java.util.*;

public class Dynamic_Object_Array {

  Object[] mainArray;
  public Dynamic_Object_Array(int length) {

    mainArray = new Object[length];
    for(int i = 0; i < mainArray.length; i++) mainArray[i] = null;

  }

  public void insert(Object obj) {

    //Start at end and check for last non-null element
    //Insert num right after
    outer: 
    for(int i = mainArray.length - 1; i >= -1; i--) {

      if(i == -1 || mainArray[i] != null) {
    	  
        //Check if array needs expansion
        /* This app only expands the array by 1 each time.
           However, this app is set up in a way where it would
           be easy to change this to doubling the array size and
           filling the end with null entries, etc. */
        if(i + 1 >= mainArray.length) {
        	
          mainArray = concantenate(mainArray, new Object[] { obj });

        } else { mainArray[i + 1] = obj; }

      break outer;
      }

    }

  }

  public void removeAt(int i) {

    Object[] first = new Object[i];
    Object[] second = new Object[mainArray.length - (i+1)];

    for(int n = 0; n < first.length; n++) first[n] = mainArray[n];
    for(int n = 0; n < second.length; n++) second[n] = mainArray[n + first.length + 1];

    mainArray = concantenate(first, second);

  }

  public int locationOf(Object obj) {

    for(int n = 0; n < mainArray.length; n++) {
      if(mainArray[n].equals(obj)) return n;
    }

    return -1;

  }


  //Private util classes
  private Object[] concantenate(Object[] first, Object[] second) {

    Object tempArray[] = new Object[first.length + second.length];

    for(int i = 0; i < first.length; i++) tempArray[i] = first[i];
    for(int i = 0; i < second.length; i++) tempArray[i + first.length] = second[i];

    return tempArray;

  }

}
