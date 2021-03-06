//Added exception handling mechanisms

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

    int tempnum = Integer.parseInt(input.readLine());

    if (tempnum > 1 && tempnum < 10) {

      num = tempnum;
      medicine = new int[num];
      virus = new int[num];

    } else throw new IOException("Value must be greater than 1 and less than 10");

    System.out.print("Enter " + num + " int values representing medicine strengths: ");

    String[] tempstr = input.readLine().split("\\s");

    if (tempstr.length == num) {

      for(int i=0; i<tempstr.length; i++)
        medicine[i] = Integer.parseInt(tempstr[i]);

    } else throw new IOException("Array must match the number of virus/medicine pairs");

    System.out.print("Enter " + num + " int values representing virus strengths: ");

    tempstr = input.readLine().split("\\s");

    if (tempstr.length == num) {

      for(int i=0; i<tempstr.length; i++)
        virus[i] = Integer.parseInt(tempstr[i]);

    } else throw new IOException("Array must match the number of virus/medicine pairs");

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