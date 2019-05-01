package puzzle;

import java.util.Random;

public class Puzzler {

	private int rowIndex = 0;
	private int colIndex = 0;
	private boolean[] westAligned = null;

	// rotate each of the puzzle pieces clockwise one time
	public void rotateAll(PuzzlePiece[][] thePuzzle) {
		System.out.println("rotateAll");

		for (int i = 0; i < thePuzzle.length; i++) {
			for (int j = 0; j < thePuzzle[i].length; j++) {
				PuzzlePiece piece = thePuzzle[i][j];
				piece.rotateClockwise();
			}
		}
	}

	// rotate each of the puzzle pieces clockwise a random number of times so that
	// each one is
	// facing a random direction, potentially including its original direction
	public void randomlyRotate(PuzzlePiece[][] thePuzzle) {
		System.out.println("randomlyRotate");
		PuzzlePiece piece = null;

		for (int i = 0; i < thePuzzle.length; i++) {
			for (int j = 0; j < thePuzzle[i].length; j++) {
				piece = thePuzzle[i][j];
				for (int k = 0; k < getRandomNumberInRange(1, 5); k++) {
					piece.rotateClockwise();
				}
			}
		}
	}

	// rotate each piece in the puzzle until they are all facing the correct
	// direction. You may
	// assume that the pieces are in the correct location.
	public void fixRotation(PuzzlePiece[][] thePuzzle) {
		System.out.println("fixRotation");
		getRowsColumns(thePuzzle);
		fixRotateBoarders(thePuzzle);
		fixRotatePieces(thePuzzle);
	}

	// randomize the location of each puzzle piece
	public void randomizeOrder(PuzzlePiece[][] thePuzzle) {
		System.out.println("randomizeOrder");
		getRowsColumns(thePuzzle);
		PuzzlePiece piece = null;

		for (int i = 0; i < thePuzzle.length; i++) {
			for (int j = 0; j < thePuzzle[i].length; j++) {
				piece = thePuzzle[i][j];
				int randomRow = getRandomNumberInRange(0, rowIndex);
				int randomCol = getRandomNumberInRange(0, colIndex);
				thePuzzle[i][j] = thePuzzle[randomRow][randomCol];
				thePuzzle[randomRow][randomCol] = piece;
			}
		}
	}

	// randomize the location and direction of each puzzle piece
	public void randomizeCompletely(PuzzlePiece[][] thePuzzle) {
		System.out.println("randomizeCompletely");
		randomizeOrder(thePuzzle);
		randomlyRotate(thePuzzle);
	}

	// puts each of the puzzle pieces in its correct location. You may assume they
	// are all facing
	// the correct direction.
	public void fixPlacement(PuzzlePiece[][] thePuzzle) {
		System.out.println("fixPlacement");
		getRowsColumns(thePuzzle);
		fixBoardersPlacement(thePuzzle);
		fixBoardersPiecesPlacement(thePuzzle);
		fixPiecesPlacement(thePuzzle);
	}

	// moves and rotates the pieces until they are in the correct order and
	// orientation. You may
	// not assume that any of the pieces are in the correct location or facing the
	// correct direction.
	public void solve(PuzzlePiece[][] thePuzzle) {
		System.out.println("solve");
		fixPlacement(thePuzzle);
		fixRotation(thePuzzle);
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	private void getRowsColumns(PuzzlePiece[][] thePuzzle) {
		rowIndex = thePuzzle.length - 1;
		colIndex = thePuzzle[0].length - 1;
	}

	// fixes rotate boarder pieces
	private void fixRotateBoarders(PuzzlePiece[][] thePuzzle) {
		boolean fixed = true;
		PuzzlePiece piece = null;
		for (int i = 0; i < thePuzzle.length; i++) {
			for (int j = 0; j < thePuzzle[i].length; j++) {
				piece = thePuzzle[i][j];

				// corner piece (upper left)
				if ((i == 0) && (j == 0)) {

					while (fixed) {
						if ((piece.getNorth() == -2) && (piece.getWest() == -2))
							break;
						piece.rotateClockwise();
					}
				}

				// corner piece (upper right)
				if ((i == 0) && (j == colIndex)) {

					while (fixed) {
						if ((piece.getNorth() == -1) && (piece.getEast() == -1))
							break;
						piece.rotateClockwise();
					}
				}

				// corner piece (lower left)
				if ((i == rowIndex) && (j == 0)) {

					while (fixed) {
						if ((piece.getSouth() == -1) && (piece.getWest() == -1))
							break;
						piece.rotateClockwise();
					}
				}

				// corner piece (lower right)
				if ((i == rowIndex) && (j == colIndex)) {

					while (fixed) {
						if ((piece.getSouth() == -1) && (piece.getEast() == -1))
							break;
						piece.rotateClockwise();
					}
				}

				// north pieces
				if ((i == 0) && (j != 0) && (j != colIndex)) {

					while (piece.getNorth() != -1) {
						piece.rotateClockwise();
					}
				}

				// south pieces
				if ((i == rowIndex) && (j != 0) && (j != colIndex)) {

					while (piece.getSouth() != -1) {
						piece.rotateClockwise();
					}
				}

				// west pieces
				if ((i != 0) && (i != rowIndex) && (j == 0)) {

					while (piece.getWest() != -1) {
						piece.rotateClockwise();
					}
				}

				// east pieces
				if ((i != 0) && (i != rowIndex) && (j == colIndex)) {

					while (piece.getEast() != -1) {
						piece.rotateClockwise();
					}
				}
			}
		}
	}

	// fixes rotate inside pieces
	private void fixRotatePieces(PuzzlePiece[][] thePuzzle) {
		PuzzlePiece piece = null;
		for (int i = 1; i < thePuzzle.length; i++) {
			for (int j = 1; j < thePuzzle[i].length; j++) { // inside pieces
				if ((i != rowIndex) && (j != colIndex)) {
					PuzzlePiece alignmentPiece = thePuzzle[i][j - 1];

					piece = thePuzzle[i][j];

					while (alignmentPiece.getEast() != piece.getWest()) {
						piece.rotateClockwise();
					}
				}
			}
		}
	}

	// fixes boarders placement
	private void fixBoardersPlacement(PuzzlePiece[][] thePuzzle) {
		PuzzlePiece piece = null;
		boolean mainPieceAligned = false;

		for (int i = 0; i < thePuzzle.length; i++) {
			for (int j = 0; j < thePuzzle[i].length; j++) {
				piece = thePuzzle[i][j];

				// corner piece (upper left)
				if ((piece.getNorth() == -2) || (piece.getEast() == -2) || (piece.getSouth() == -2)
						|| (piece.getWest() == -2)) {

					thePuzzle[i][j] = thePuzzle[0][0];
					thePuzzle[0][0] = piece;

					// fix the main piece alignment
					while (!mainPieceAligned) {
						if ((piece.getWest() == -2) && (piece.getNorth() == -2)) {
							mainPieceAligned = true;
						} else {
							piece.rotateClockwise();
						}
					}
				}
				/*
				 * // corner piece (upper right) if ((piece.getNorth() == -1) &&
				 * (piece.getEast() == -1)) {
				 * 
				 * thePuzzle[i][j] = thePuzzle[0][colIndex]; thePuzzle[0][colIndex] = piece; }
				 * 
				 * // corner piece (lower left) if ((piece.getSouth() == -1) && (piece.getWest()
				 * == -1)) {
				 * 
				 * thePuzzle[i][j] = thePuzzle[rowIndex][0]; thePuzzle[rowIndex][0] = piece; }
				 * 
				 * // corner piece (lower right) if ((piece.getSouth() == -1) &&
				 * (piece.getEast() == -1)) {
				 * 
				 * thePuzzle[i][j] = thePuzzle[rowIndex][colIndex];
				 * thePuzzle[rowIndex][colIndex] = piece; }
				 */
			}
		}
	}

	// sets the west boarder
	private void fixBoardersPiecesPlacement(PuzzlePiece[][] thePuzzle) {
		PuzzlePiece piece = null;
		PuzzlePiece alignmentPiece = thePuzzle[0][0];
		int east = alignmentPiece.getEast();
		int south = alignmentPiece.getSouth();
		westAligned = new boolean[thePuzzle.length];

		for (int i = 0; i < westAligned.length; i++) {
			westAligned[i] = false;
		}

		for (int i = 1; i < thePuzzle.length - 1; i++) {

			for (int j = 0; j < thePuzzle.length; j++) {

				for (int k = 1; k < thePuzzle[i].length; k++) {

					piece = thePuzzle[j][k];

					if (south == piece.getNorth()) {

						thePuzzle[j][k] = thePuzzle[i][0];
						thePuzzle[i][0] = piece;
						alignmentPiece = thePuzzle[i][0];
						westAligned[i] = true;
						break;
					}

					if (south == piece.getEast()) {

						piece.rotateClockwise();
						thePuzzle[j][k] = thePuzzle[i][0];
						thePuzzle[i][0] = piece;
						alignmentPiece = thePuzzle[i][0];
						westAligned[i] = true;
						break;
					}

					if (south == piece.getSouth()) {

						piece.rotateClockwise();
						piece.rotateClockwise();
						thePuzzle[j][k] = thePuzzle[i][0];
						thePuzzle[i][0] = piece;
						alignmentPiece = thePuzzle[i][0];
						westAligned[i] = true;
						break;
					}

					if (south == piece.getEast()) {

						piece.rotateClockwise();
						piece.rotateClockwise();
						piece.rotateClockwise();
						thePuzzle[j][k] = thePuzzle[i][0];
						thePuzzle[i][0] = piece;
						alignmentPiece = thePuzzle[i][0];
						westAligned[i] = true;
						break;
					}
				}
			}
		}
	}

	// sets the west boarder
	private void fixBoardersPiecesPlacementOriginal(PuzzlePiece[][] thePuzzle) {
		PuzzlePiece piece = null;
		PuzzlePiece alignmentPiece = thePuzzle[0][0];

		for (int i = 1; i < thePuzzle.length - 1; i++) {

			for (int j = 0; j < thePuzzle.length; j++) {

				for (int k = 1; k < thePuzzle[i].length; k++) {

					piece = thePuzzle[j][k];

					if ((alignmentPiece.getSouth() == piece.getNorth()) && (piece.getWest() == -1)) {

						thePuzzle[j][k] = thePuzzle[i][0];
						thePuzzle[i][0] = piece;
						alignmentPiece = thePuzzle[i][0];
						break;
					}
				}
			}
		}
	}

	// sets the remaining pieces
	private void fixPiecesPlacement(PuzzlePiece[][] thePuzzle) {
		PuzzlePiece piece = null;
		PuzzlePiece alignmentPiece = thePuzzle[0][0];

		for (int i = 0; i < thePuzzle.length; i++) {
			alignmentPiece = thePuzzle[i][0];

			for (int j = 1; j < thePuzzle[i].length; j++) {
				for (int k = 0; k < thePuzzle.length; k++) {
					for (int l = 1; l < thePuzzle[i].length; l++) {

						piece = thePuzzle[k][l];

						if (alignmentPiece.getEast() == piece.getWest()) {

							thePuzzle[k][l] = thePuzzle[i][j];
							thePuzzle[i][j] = piece;
							alignmentPiece = piece;
							k = thePuzzle.length + 2;
							break;
						}
					}
				}
			}
		}
	}
}
