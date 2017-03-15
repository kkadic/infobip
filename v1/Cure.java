import java.util.Arrays;

public class Cure {

  //Hardcoded values during algorithm testing phase

  int number = 5;
  int[] medicine = {40, 21, 56, 1, 7};
  int[] viruses = {32, 3, 22, 67, 90};

  public static void main(String args[]) {

  Cure cure = new Cure();
 
  System.out.println("Printing the arrays as they are...");
  System.out.println("medicine: " + Arrays.toString(cure.medicine));
  System.out.println("viruses: " + Arrays.toString(cure.viruses));
  System.out.println();

  System.out.println("Sorting the arrays in ascending order...");
  insertionSortAsc(cure.medicine);
  insertionSortAsc(cure.viruses);

  System.out.println("medicine: " + Arrays.toString(cure.medicine));
  System.out.println("viruses: " + Arrays.toString(cure.viruses));
  System.out.println();

  System.out.println("Sorting the arrays in descending order...");
  insertionSortDesc(cure.medicine);
  insertionSortDesc(cure.viruses);

  System.out.println("medicine: " + Arrays.toString(cure.medicine));
  System.out.println("viruses: " + Arrays.toString(cure.viruses));

  }


  //Decided to use insertion sort algorithm due to performance
  //benefits when dealing with small arrays.

  public static void insertionSortDesc(int[] array) {

    int j;
    int key;
    int i;

     for (j=1; j < array.length; j++) {

       key = array[j];

       for (i = j - 1; (i >= 0) && (array[i] < key); i--) {
         array[i+1] = array[i];
       }

       array[i+1] = key;

     }
  }

  public static void insertionSortAsc(int[] array) {

    int temp;
    int pos;
	
    for (int i = 1; i < array.length; i++) {

      temp = array[i];
      pos = i - 1;
		
      while ((pos >= 0) && (temp < array[pos])) {
        array[pos+1] = array[pos];
        pos--;
      }

      array[pos + 1] = temp;
    }
  }
}