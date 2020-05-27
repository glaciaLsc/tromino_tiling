public class Tiling {
	private int boardSize;
	private int[] missingTile;
	private char[][] board;

	public void setBoard(int boardSize, int[] missingTile) {
		this.boardSize = boardSize;
		this.missingTile = missingTile;

		this.board = new char[boardSize][boardSize];
		for (int i=0; i < boardSize; i++) {
			for (int j=0; j < boardSize; j++) {
				if (i == missingTile[0] && j == missingTile[1])
					board[i][j] = ' ';
				else
					board[i][j] = '0';
			}
		}
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public int getBoardSize() {
		return boardSize;
	}
	
	public int[] getMissingTile() {
		return missingTile;
	}

	public char[][] getBoard() {
		return board;
	}
}
