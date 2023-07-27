package labs.lab5;

public interface Game {
	boolean isValidMove(String move);

	void executeMove(String move);

	boolean gameOver();

	String displayBoard();

	int determineWinner();
}
