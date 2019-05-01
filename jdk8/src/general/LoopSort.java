package general;

public class LoopSort {

	/**
	 * Sorts the integers in the given array so that they are in ascending order.
	 * 
	 * @param a
	 *            array to sort
	 */
	public static void selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = findMin(a, i);
			swap(a, min, i);
		}
	}

	/**
	 * Sorts the integers in the given array so that they are in ascending order.
	 * 
	 * @param a
	 *            array to sort
	 */
	public static void bubbleSort(int[] a) {
		boolean swapped = true;
		for (int r = 0; r < a.length - 1 && swapped; r++) {
			swapped = false;
			for (int i = 0; i < a.length - (r + 1); i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					swapped = true;
				}
			}
		}
	}

	/**
	 * Swaps the two integers in the given array at the given indexes.
	 * 
	 * @param a
	 *            array
	 * @param x
	 *            index of first number to swap
	 * @param y
	 *            index of second number to swap
	 */
	public static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

	/**
	 * Returns the index of the smallest integer in the given array starting at the
	 * given index.
	 * 
	 * @param a
	 *            array to examine
	 * @param start
	 *            index to start examining array
	 * @return smallest int in array between start and length-1
	 */
	public static int findMin(int[] a, int start) {
		int min = start;
		for (int i = start + 1; i < a.length; i++) {
			if (a[i] < a[min]) {
				min = i;
			}
		}
		return min;
	}

}
