package us.cv64.collections.fundamentals.sudoku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku {

	// test matrix
	private static int[][] matrix = { { 1, 6, 0, 0, 0, 5 }, { 0, 0, 5, 2, 0, 0 }, { 5, 0, 0, 0, 3, 0 },
			{ 0, 4, 0, 0, 0, 1 }, { 0, 0, 4, 1, 0, 0 }, { 3, 0, 0, 0, 5, 4 } };

	private static final int ARRAY_SIZE = 6;
	private static final String filename = "sudoku/sudoku.txt";

	// no argument Constructor
	public Sudoku() {
	}

	// prints out Matrix
	public void printMatrix(int[][] array) {
		System.out.println();
		for (int j = 0; j < array.length; j++) {
			for (int i = 0; i < array.length; i++) {
				if (i == array.length - 1) {
					System.out.println(array[j][i]);
				} else {
					System.out.print(array[j][i]);
				}
			}
		}
	}

	// checks for duplicate values in a row
	public boolean checkRow(int[][] matrix, int row, int num) {
		for (int col = 0; col < ARRAY_SIZE; col++) {
			if (matrix[row][col] == num) {
				return false;
			}
		}

		return true;
	}

	// checks for duplicate values in a column
	public boolean checkCol(int[][] matrix, int col, int num) {
		for (int row = 0; row < ARRAY_SIZE; row++) {
			if (matrix[row][col] == num) {
				return false;
			}
		}
		return true;
	}

	// checks for duplicate values in the box
	public boolean checkBox(int[][] matrix, int row, int col, int num) {
		row = (row / 2) * 2;
		col = (col / 3) * 3;

		for (int r = 0; r < 2; r++) {
			for (int c = 0; c < 3; c++) {
				if (matrix[row + r][col + c] == num) {
					return false;
				}
			}
		}

		return true;
	}

	// checks for duplicate values in a row
	public void next(int[][] puzzle, int row, int col) {
		if (col <= 4)
			solveMatrix(puzzle, row, col + 1);
		else
			solveMatrix(puzzle, row + 1, 0);
	}

	// checks for duplicate values in a row
	public int solveMatrix(int[][] puzzle, int row, int col) {
		if (row > 5) {
			System.out.println("Solution Found:");
			printMatrix(puzzle);
			return 0;
		}
		if (puzzle[row][col] != 0) {
			next(puzzle, row, col);
		} else {
			for (int num = 1; num < 7; num++) {
				if (checkRow(puzzle, row, num) && checkCol(puzzle, col, num) && checkBox(puzzle, row, col, num)) {
					puzzle[row][col] = num;
					next(puzzle, row, col);
				}
			}
			puzzle[row][col] = 0;
		}
		return 0;
	}

	// builds the Matrix from a file
	private void buildMatrix(String filename) {
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;

		try {

			bufferedReader = new BufferedReader(new FileReader(filename));

			String record;
			int i = 0;

			while ((record = bufferedReader.readLine()) != null) {
				System.out.println(record);

				// replace all spaces with zero
				record = record.replaceAll(" ", "0");

				for (int j = 0; j < ARRAY_SIZE; j++) {

					// converts strings to integers
					matrix[i][j] = Integer.parseInt(record.substring(j, j + 1));
				}
				
				i++; // get next record
			}

		} catch (IOException exception) {
			System.err.println(exception.getMessage());
			exception.printStackTrace();

		} finally {

			try {

				if (bufferedReader != null)
					bufferedReader.close();

				if (fileReader != null)
					fileReader.close();

			} catch (IOException exception) {

				exception.printStackTrace();

			}
		}
	}

	public static void main(String[] args) {

		System.out.println("Sudoku Start Matrix:");

		Sudoku sudoku = new Sudoku();
		sudoku.buildMatrix(filename);
		sudoku.printMatrix(matrix);
		System.out.println();
		sudoku.solveMatrix(matrix, 0, 0);

		System.out.println("Sudoku End Matrix:");
	}
}