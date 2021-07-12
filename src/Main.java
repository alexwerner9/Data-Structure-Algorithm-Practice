import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    Dynamic_array arrayList = new Dynamic_array(3);
    arrayList.insert(5);
    arrayList.insert(6);
    arrayList.insert(7);
    arrayList.insert(8);
    arrayList.insert(9);
    
    System.out.println(arrayList.locationOf(6));
    System.out.println(arrayList.toString());

  }

}
