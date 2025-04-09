public class PracticeProblem {

	public static void main(String args[]) {

	}
	public static int searchMazeMoves(String[][] arr) {
		int curRow = arr.length - 1;
		int curCol = 0;
		int noOfMoves = 0;
		return dfsMovesHelper(arr, curRow, curCol, noOfMoves);

	}
	public static int dfsMovesHelper(String[][] arr, int curRow, int curCol, int noOfMoves) {
		if (curRow < 0 || curCol >= arr[0].length) {
			return -1;
		}
		if (arr[curRow][curCol].equals("F")) {
			return noOfMoves;
		}
		if (arr[curRow][curCol].equals("*")) {
			return -1;
		}
		int right = dfsMovesHelper(arr, curRow, curCol + 1, noOfMoves + 1);
		int up = dfsMovesHelper(arr, curRow - 1, curCol, noOfMoves + 1);

		if (right == -1 && up == -1) {
			return -1;
		}
		if (right == -1) {
			return up;
		}
		if (up == -1) {
			return right;
		}
		return Math.min(right, up);
 	}
	public static int noOfPaths(String[][] arr) {
		int curRow = arr.length - 1;
		int curCol = 0;
		int noOfMoves = 0;
		return dfsPathsHelper(arr, curRow, curCol, noOfMoves);
	}
		public static int dfsPathsHelper(String[][] arr, int curRow, int curCol, int noOfMoves) {
		if (curRow < 0 || curCol >= arr[0].length) {
			return 0;
		}
		if (arr[curRow][curCol].equals("F")) {
			return 1;
		}
		if (arr[curRow][curCol].equals("*")) {
			return 0;
		}
		int right = dfsPathsHelper(arr, curRow, curCol + 1, noOfMoves + 1);
		int up = dfsPathsHelper(arr, curRow - 1, curCol, noOfMoves + 1);
		
		return right + up;
	}

	
}
