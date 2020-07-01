public class Sudoku {

	int row;
	int column;
	int digit;
	private int[][] board;
	public static final int EMPTY = 0; // empty cell
	public static final int SIZE = 9; // size of our Sudoku grids

	
	public Sudoku(int[][] board) {
		this.board = new int[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}
	
	private boolean isInRow(int row, int digit) {
		for (int i = 0; i < SIZE; i++)
			if (board[row][i] == digit)
				return true;
		
		return false;
	}
	
	// we check if a possible number is already in a column
	private boolean isInCol(int column, int digit) {
		for (int i = 0; i < SIZE; i++)
			if (board[i][column] == digit)
				return true;
		
		return false;
	}
	
	// we check if a possible number is in its 3x3 box
	private boolean isInBox(int row, int column, int digit) {
		int r = row - row % 3;
		int c = column - column % 3;
		
		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (board[i][j] == digit)
					return true;
		
		return false;
	}
	
	// combined method to check if a number possible to a row,col position is ok
	private boolean isOk(int row, int column, int digit) {
		return !isInRow(row, digit)  &&  !isInCol(column, digit)  &&  !isInBox(row, column, digit);
	}
	
	public boolean checkValidity(int sudoku[][], int row, int column, int digit) {
		 
		 if (sudoku[row][column] == EMPTY) 
			 if (isOk(row, column, digit))
				 return true;

		 return false;
  }

	public static void main(String[] args) {

	    int[][] sudoku = {
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,3,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9},
		};

		Sudoku sudokuA= new Sudoku(sudoku);
		
		if (sudokuA.checkValidity(sudoku, 7, 7, 3)) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

	}
}
