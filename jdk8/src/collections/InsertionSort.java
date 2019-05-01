package collections;

//Java program for implementation of Insertion Sort 
// insertion sort - sorting elements being added in sorting order
public class InsertionSort {

	/*
	 * 3. Do not depend on the length of the array. Instead, provide a parameter
	 * that gives the number of values to be sorted. method to sort array using
	 * insertion sort, array being passed in and the number of elements to be sorted
	 */
	static void orderedSort(int array[], int n) {

		// get the length of the array
		// int n = array.length;

		// loop through the array
		for (int i = 1; i < n; ++i) {

			// get the value
			int key = array[i];
			int j = i - 1;
			/*
			 * Move elements of array[0..i-1], that are greater than key, to one position
			 * ahead of their current position
			 */
			while (j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/*
	 * 4. Sort the values in descending order. That is, the largest number should
	 * end up as the first number in the array.
	 */
	static void descendingSort(int array[], int n) {

		// get the length of the array
		// int n = array.length;

		// loop through the array
		for (int i = 1; i < n; ++i) {

			// get the value
			int key = array[i];
			int j = i - 1;
			/*
			 * Move elements of array[0..i-1], that are less than key, to one position ahead
			 * of their current position
			 */
			while (j >= 0 && array[j] < key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j + 1] = key;
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int array[]) {
		int n = array.length;
		for (int i = 0; i < n; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {

		// initialize the array
		int array[] = { 12, 11, 13, 5, 6 };

		// sort the array
		// InsertionSort.orderedSort(array, 5);
		InsertionSort.descendingSort(array, 5);

		// print the array
		printArray(array);
	}
}