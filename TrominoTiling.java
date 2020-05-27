import java.util.Scanner;

public class TrominoTiling {

	public TrominoTiling(int boardSize, int[] missingTile, int rowOffset, int colOffset) {
		Tiling model = new Tiling();
		TilingView view = new TilingView();
		TilingController controller = new TilingController(model, view);
		
		controller.setBoard(boardSize, missingTile);

		controller.tile(boardSize, missingTile, rowOffset, colOffset);
		controller.setBoard(controller.getBoard());
		controller.updateView();
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int boardSize, rowOffset, colOffset;
		int[] missingTile = new int[2];

		System.out.print("Enter desired size of board: ");
		boardSize = s.nextInt();
		System.out.println("Enter location of missing tile (row followed by column): ");
		missingTile[0] = s.nextInt();
		missingTile[1] = s.nextInt();
		System.out.println();

		new TrominoTiling(boardSize, missingTile, 0, 0);
	}

}
