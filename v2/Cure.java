public class Cure {

  //Hardcoded values during algorithm testing phase.

  static int num = 5;
  static int[] medicine = {22, 34, 4, 5, 100};
  static int[] virus = {2, 2, 3, 4, 5};

  public static void main(String args[]) {

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