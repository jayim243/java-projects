package labs.lab5;

public class TicTacToeGame implements Game {
	String[][] board = new String[3][3];
	private String turn;
	private boolean firstmove; 
	private String player1;
	private int winner;
	public TicTacToeGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = " ";
			}
		}
		firstmove = true;
		turn = "";
	}

	@Override
	public boolean isValidMove(String move) {
		if (move.length() != 3) {
			return false;
		}
		if ((Integer.valueOf(move.substring(0, 1))) < 3 && (Integer.valueOf(move.substring(0, 1)) >= 0) &&
				(Integer.valueOf(move.substring(1, 2)) < 3) && (Integer.valueOf(move.substring(1, 2)) >= 0)) {
			if (firstmove) {
				turn = move.substring(2);
				player1 = turn;
				firstmove = false;
			}
			if (!move.substring(2).equals(turn)) {
				return false;
			}
			if (!board[Integer.valueOf(move.substring(0, 1))][Integer.valueOf(move.substring(1, 2))].equals(" ")) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}

	@Override
	public void executeMove(String move) {
		if (isValidMove(move)) {
			board[Integer.valueOf(move.substring(0, 1))][Integer.valueOf(move.substring(1, 2))] = move.substring(2);
			if (turn.equals("x")) {
				turn = "o";
			}
			else {
				turn = "x";
			}
		}
	}

	@Override
	public boolean gameOver() {
		if ((board[0][0].equals("x") && board[1][1].equals("x") && board[2][2].equals("x")) ||
				(board[0][0].equals("x") && board[1][0].equals("x") && board[2][0].equals("x")) ||
				(board[0][1].equals("x") && board[1][1].equals("x") && board[2][1].equals("x")) ||
				(board[0][2].equals("x") && board[1][2].equals("x") && board[2][2].equals("x")) ||
				(board[0][0].equals("x") && board[0][1].equals("x") && board[0][2].equals("x")) ||
				(board[1][0].equals("x") && board[1][1].equals("x") && board[1][2].equals("x")) ||
				(board[2][0].equals("x") && board[2][1].equals("x") && board[2][2].equals("x")) ||
				(board[2][0].equals("x") && board[1][1].equals("x") && board[0][2].equals("x"))) {
			if (player1.equals("x")) {
				winner = 1;
			}
			else {
				winner = 2;
			}
			return true;
		}
		else if ((board[0][0].equals("o") && board[1][1].equals("o") && board[2][2].equals("o")) ||
				(board[0][0].equals("o") && board[1][0].equals("o") && board[2][0].equals("o")) ||
				(board[0][1].equals("o") && board[1][1].equals("o") && board[2][1].equals("o")) ||
				(board[0][2].equals("o") && board[1][2].equals("o") && board[2][2].equals("o")) ||
				(board[0][0].equals("o") && board[0][1].equals("o") && board[0][2].equals("o")) ||
				(board[1][0].equals("o") && board[1][1].equals("o") && board[1][2].equals("o")) ||
				(board[2][0].equals("o") && board[2][1].equals("o") && board[2][2].equals("o")) ||
				(board[2][0].equals("o") && board[1][1].equals("o") && board[0][2].equals("o"))) {
			if (player1.equals("o")) {
				winner = 1;
			}
			else {
				winner = 2;
			}
			return true;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].equals(" ")) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public String displayBoard() {
		String strboard = "";
		for (String[] row : board) {
			for (int i = 0; i < row.length; i++) {
				if (row[i].equals(" ")) {
					if (i == 2) {
						strboard += "   ";
					}
					else {
						strboard += "   |";
					}
				}
				else {
					if (i == 2) {
						strboard += " " + row[i] + " ";
					}
					else {
						strboard += " " + row[i] + " |";
					}
				}
			}
			if (row != board[2]) {
				strboard += "\r\n" + "-----------" + "\r\n";
			}
			else {
				strboard += "\r\n";
			}
		}
		return strboard;
	}

	@Override
	public int determineWinner() {
		if (gameOver() == false) {
			return 0;
		}
		else {
			return winner;
		}
	}
}