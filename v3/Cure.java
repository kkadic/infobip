import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Cure {

  //Harcoded values removed.

  static int num;
  static int[] medicine;
  static int[] virus;


  public static void main(String args[]) throws IOException {

    //Decided to user BufferedReader over Scanner due to performance benefits.

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter a number of desired virus/medicine pairs: ");

    num = Integer.parseInt(input.readLine());
    medicine = new int[num];
    virus = new int[num];

    System.out.print("Enter " + num + " int values representing medicine strengths: ");

    String[] temp = input.readLine().split("\\s");

    for(int i=0; i<temp.length; i++)
      medicine[i] = Integer.parseInt(temp[i]);

    System.out.print("Enter " + num + " int values representing virus strengths: ");

    temp = input.readLine().split("\\s");

    for(int i=0; i<temp.length; i++)
      virus[i] = Integer.parseInt(temp[i]);

    input.close();

    insertionSort(medicine);
    insertionSort(virus);

    OUTER:
    for (int i = 0; i < num; i++) {

      for (int j = i; j < num; j++) {

        if (virus[i] >= medicine[j]) {
          System.out.println("No!");
          break OUTER;
        }
      }

      if (i == (num-1))
        System.out.println("Yes!");

    }
  }

  //Decided to use insertion sort algorithm due to performance
  //benefits when dealing with small arrays. Discarded the
  //descending version of the algorithm.

  public static void insertionSort(int[] array) {

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