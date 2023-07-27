package labs.lab5;

public class ConnectFourGame implements Game {
	String[][] board = new String[6][7];
	private String turn;
	private boolean firstmove; 
	private String player1;
	private int winner;
	
	public ConnectFourGame() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				board[i][j] = " ";
			}
		}
		firstmove = true;
	}

	@Override
	public boolean isValidMove(String move) {
		if (move.length() != 2) {
			return false;
		}
		else if (firstmove) {
			turn = move.substring(1);
			player1 = turn;
			firstmove = false;
		}
		else if (!move.substring(1).equals(turn)) {
			return false;
		}
		boolean space = false;
		for (int i = 0; i < 6; i++) {
			if (board[i][Integer.valueOf(move.substring(0, 1))].equals(" ")) {
				space = true;
			}
		}
		if (!space) {
			return false;
		}
		return true;
	}

	@Override
	public void executeMove(String move) {
		if (isValidMove(move)) {
			for (int i = 5; i >= 0; i--) {
				if (board[i][Integer.valueOf(move.substring(0, 1))].equals(" ")) {
					board[i][Integer.valueOf(move.substring(0, 1))] = move.substring(1);
					break;
				}
			}
			if (turn.equals("r")) {
				turn = "y";
			}
			else {
				turn = "r";
			}
		}
	}

	@Override
	public boolean gameOver() {
	    for (int i = 0; i < 6 ; i++) {
	        for (int j = 0; j < 4; j++) {
	            if (board[i][j].equals("r") && board[i][j + 1].equals("r") && board[i][j + 2].equals("r") 
	            		&& board[i][j + 3].equals("r")) {
	            	if (player1.equals("r")) {
	            		winner = 1;
	            	}
	            	else {
	            		winner = 2;
	            	}
	                return true;
	            }
	            else if (board[i][j].equals("y") && board[i][j + 1].equals("y") && board[i][j + 2].equals("y") 
	            		&& board[i][j + 3].equals("y")) {
	            	if (player1.equals("y")) {
	            		winner = 1;
	            	}
	            	else {
	            		winner = 2;
	            	}
	            	return true;
	            }
	        }
	    }
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 7; j++) {
	            if (board[i][j].equals("r") && board[i + 1][j].equals("r") && board[i + 2][j].equals("r") 
	            		&& board[i + 3][j].equals("r")) {
	            	if (player1.equals("r")) {
	            		winner = 1;
	            	}
	            	else {
	            		winner = 2;
	            	}
	                return true;
	            }
	            else if (board[i][j].equals("y") && board[i + 1][j].equals("y") && board[i + 2][j].equals("y") 
	            		&& board[i + 3][j].equals("y")) {
	            	if (player1.equals("y")) {
	            		winner = 1;
	            	}
	            	else {
	            		winner = 2;
	            	}
	                return true;
	            }
	        }
	    }
	    for (int i = 3; i < 6; i++){
	        for (int j = 0 ; j < 4; j++){
	            if (board[i][j].equals("r") && board[i - 1][j + 1].equals("r") && board[i - 2][j + 2].equals("r")
	            		&& board[i - 3][j + 3].equals("r")) {
	            	if (player1.equals("r")) {
	            		winner = 1;
	            	}
	            	else {
	            		winner = 2;
	            	}
	            	return true;
	            }
	            else if (board[i][j].equals("y") && board[i - 1][j + 1].equals("y") && board[i - 2][j + 2].equals("y")
	            		&& board[i - 3][j + 3].equals("y")) {
	            	if (player1.equals("y")) {
	            		winner = 1;
	            	}
	            	else {
	            		winner = 2;
	            	}
	            	return true;
	            }
	        }
	    }
	    for (int i = 0; i < 3; i++){
	        for (int j = 0; j < 4; j++){
	            if (board[i][j].equals("r") && board[i + 1][j + 1].equals("r") && board[i + 2][j + 2].equals("r")
	            		&& board[i + 3][j + 3].equals("r")) {
	            	if (player1.equals("r")) {
	            		winner = 1;
	            	}
	            	else {
	            		winner = 2;
	            	}
	            	return true;
	            }
	            else if (board[i][j].equals("y") && board[i + 1][j + 1].equals("y") && board[i + 2][j + 2].equals("y")
	            		&& board[i + 3][j + 3].equals("y")) {
	            	if (player1.equals("y")) {
	            		winner = 1;
	            	}
	            	else {
	            		winner = 2;
	            	}
	            	return true;
	            }
	        }
	    }
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
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
					if (i == row.length - 1) {
						strboard += "   ";
					}
					else {
						strboard += "   |";
					}
				}
				else {
					if (i == row.length - 1) {
						strboard += " " + row[i] + " ";
					}
					else {
						strboard += " " + row[i] + " |";
					}
				}
			}
			if (row != board[5]) {
				strboard += "\r\n" + "---------------------------" + "\r\n";
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