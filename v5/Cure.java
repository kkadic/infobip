//Added exception handling mechanisms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Cure {

  //Harcoded values removed.

  static int medicineVirusPairs;
  static int[] medicines;
  static int[] viruses;


  public static void main(String args[]) throws IOException {

    //Decided to user BufferedReader over Scanner due to performance benefits.

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Enter a number of desired virus/medicine pairs: ");

    int inputMedicineVirusPairs = Integer.parseInt(input.readLine());

    try {

      if (!(inputMedicineVirusPairs > 1 && inputMedicineVirusPairs < 10))

        throw new IOException();
   
    } catch(IOException e) {

        System.out.println("IOException. Value must be greater than 1 and less than 10.");

        System.exit(0);
    
      }

    medicineVirusPairs = inputMedicineVirusPairs;
    medicines = new int[medicineVirusPairs];
    viruses = new int[medicineVirusPairs];

    System.out.print("Enter " + medicineVirusPairs + " int values representing medicine strengths: ");

    String[] inputMedicineOrVirusArray = input.readLine().split("\\s");

    try {

      if (!(inputMedicineOrVirusArray.length == medicineVirusPairs))

        throw new IOException();


    } catch(IOException e) {

        System.out.println("Array must match the number of virus/medicine pairs");

          System.exit(0);

        }

    for(int i = 0; i < inputMedicineOrVirusArray.length; i++)
      medicines[i] = Integer.parseInt(inputMedicineOrVirusArray[i]);

    System.out.print("Enter " + medicineVirusPairs + " int values representing virus strengths: ");

    inputMedicineOrVirusArray = input.readLine().split("\\s");

    try {

      if (!(inputMedicineOrVirusArray.length == medicineVirusPairs))

        throw new IOException();

     }  catch(IOException e) {

          System.out.println("Array must match the number of virus/medicine pairs");

          System.exit(0);

        }

    for(int i = 0; i < inputMedicineOrVirusArray.length; i++)
      viruses[i] = Integer.parseInt(inputMedicineOrVirusArray[i]);

    input.close();

    insertionSort(medicines);
    insertionSort(viruses);

    for (int i = 0; i < medicineVirusPairs; i++) {

      if (viruses[i] >= medicines[i]) {
        System.out.println("No!");
        break;
      }

      if (i == (medicineVirusPairs - 1))
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
        array[pos + 1] = array[pos];
        pos--;
      }

      array[pos + 1] = temp;

    }
  }

}