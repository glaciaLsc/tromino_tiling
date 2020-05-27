import java.util.Random;

public class TilingController {
	private Tiling model;
	private TilingView view;
	private char[][] board;
	
	public TilingController(Tiling model, TilingView view) {
		this.model = model;
		this.view = view;
		this.board = new char[model.getBoardSize()][model.getBoardSize()];
	}

	public void setBoard(int size, int[] tile) {
		model.setBoard(size, tile);
		this.board = model.getBoard();
	}

	public void setBoard(char[][] board) {
		model.setBoard(board);
	}	

	public void tile(int n, int[] L, int r, int c) {
		Random rand = new Random();
		int mid = n / 2;
		String alphabet = "QWERTYUIOPASDFGHJKLZCVBNM123456789";
		char let = alphabet.charAt(rand.nextInt(34));

		if (n == 2) {
			//board is right tromino T
			//tile with T
			//return
			if (L[0] < mid+r && L[1] < mid+c) {
				board[0+r][1+c] = let;
				board[1+r][0+c] = let;
				board[1+r][1+c] = let;
			} else if (L[0] < mid+r && L[1] >= mid+c) {
				board[0+r][0+c] = let;
				board[1+r][0+c] = let;
				board[1+r][1+c] = let;
			} else if (L[0] >= mid+r && L[1] >= mid+c) {
				board[0+r][0+c] = let;
				board[0+r][1+c] = let;
				board[1+r][0+c] = let;
			} else if (L[0] >= mid+r && L[1] < mid+c) {
				board[0+r][0+c] = let;
				board[0+r][1+c] = let;
				board[1+r][1+c] = let;
			}

		} else {
			int[] m1, m2, m3, m4;
			m1 = m2 = m3 = m4 = new int[]{0, 0};

			if (L[0] < mid+r && L[1] < mid+c) {
				board[mid-1+r][mid+c] = let;
				board[mid+r][mid+c] = let;
				board[mid+r][mid-1+c] = let;
				
				m1 = L;
				m2 = new int[]{mid-1+r, mid+c};
				m3 = new int[]{mid+r, mid+c};
				m4 = new int[]{mid+r, mid-1+c};
			} else if (L[0] < mid+r && L[1] >= mid+c) {
				board[mid-1+r][mid-1+c] = let;
				board[mid+r][mid+c] = let;
				board[mid+r][mid-1+c] = let;

				m1 = new int[]{mid-1+r, mid-1+c};
				m2 = L;
				m3 = new int[]{mid+r, mid+c};
				m4 = new int[]{mid+r, mid-1+c};
			} else if (L[0] >= mid+r && L[1] >= mid+c) {
				board[mid+r][mid-1+c] = let;
				board[mid-1+r][mid-1+c] = let;
				board[mid-1+r][mid+c] = let;

				m1 = new int[]{mid-1+r, mid-1+c};
				m2 = new int[]{mid-1+r, mid+c};
				m3 = L;
				m4 = new int[]{mid+r, mid-1+c};
			} else if (L[0] >= mid+r && L[1] < mid+c) {
				board[mid-1+r][mid-1+c] = let;
				board[mid-1+r][mid+c] = let;
				board[mid+r][mid+c] = let;

				m1 = new int[]{mid-1+r, mid-1+c};
				m2 = new int[]{mid-1+r, mid+c};
				m3 = new int[]{mid+r, mid+c};
				m4 = L;
			}
			
			//divide board into four (n/2)*(n/2) boards
			//
			//rotate the board so that the missing square is in the
			//upper-left quadrant
			//
			//place one right tromino in the center
			//
			//consider each of the squares covered by the center tromino as
			//missing, and denote the missing squares as m1, m2, m3, m4
			//
			tile(n/2, m1, 0+r, 0+c);
			tile(n/2, m2, 0+r, mid+c);
			tile(n/2, m3, mid+r, mid+c);
			tile(n/2, m4, mid+r, 0+c);
		}
	}

	public char[][] getBoard() {
		return board;
	}

	public void updateView() {
		view.displayBoard(model.getBoard(), model.getBoardSize());
	}

}
