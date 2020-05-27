import javax.swing.*;
import java.awt.*;

public class TilingView {
	/* Graphics to be implemented after program works
	private JFrame f;

	public void displayBoard(int boardSize) {
	f = new JFrame();

	f.setSize(640, 640);
	f.setVisible(true);
	}
	*/

	public void displayBoard(char[][] board, int boardSize) {
		for (int i=0; i < boardSize; i++) {
			for (int j=0; j < boardSize; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}
}
