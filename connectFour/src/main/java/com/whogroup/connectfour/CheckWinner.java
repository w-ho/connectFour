package com.whogroup.connectfour;

public class CheckWinner {

	public boolean checkWinner(Board board, Player player, int row, int column) {
		boolean winnerexists = checkNS(board, player, row, column);
		winnerexists = (winnerexists || checkWE(board, player, row, column));
		winnerexists = (winnerexists || checkSW_NE(board, player, row, column));
		winnerexists = (winnerexists || checkNW_SE(board, player, row, column));
		return winnerexists;
	}

	private boolean checkNS(Board board, Player player, int row, int column) {
		int cnt = 1;
		int move = 1;
		while (row + move < board.getRows()) {
			if (board.field[row + move][column] == player.getPlayer()) {
				cnt++;
				move++;
			} else {
				move = board.getRows();
			}
		}

		if (cnt > 3) {
			return true;
		}

		return false;
	}

	private boolean checkWE(Board board, Player player, int row, int column) {
		int cnt = 1;
		int move = 1;
		while (column + move < board.getColumns()) {
			if (board.field[row][column + move] == player.getPlayer()) {
				cnt++;
				move++;
			} else {
				move = board.getColumns() + 1;
			}
		}
		move = -1;
		while (column + move >= 0) {
			if (board.field[row][column + move] == player.getPlayer()) {
				cnt++;
				move--;
			} else {
				move = -board.getColumns() - 1;
			}
		}

		if (cnt > 3) {
			return true;
		}

		return false;
	}

	private boolean checkSW_NE(Board board, Player player, int row, int column) {
		int cnt = 1;
		int move = 1;
		while (column + move < board.getColumns() && row - move >= 0) {
			if (board.field[row - move][column + move] == player.getPlayer()) {
				cnt++;
				move++;
			} else {
				move = board.getColumns() + 1;
			}
		}
		move = -1;
		while (column + move >= 0 && row - move < board.getRows()) {
			if (board.field[row - move][column + move] == player.getPlayer()) {
				cnt++;
				move--;
			} else {
				move = -board.getColumns() - 1;
			}
		}

		if (cnt > 3) {
			return true;
		}

		return false;
	}

	private boolean checkNW_SE(Board board, Player player, int row, int column) {
		int cnt = 1;
		int move = 1;
		while (column + move < board.getColumns() && row + move < board.getRows()) {
			if (board.field[row + move][column + move] == player.getPlayer()) {
				cnt++;
				move++;
			} else {
				move = board.getColumns() + 1;
			}
		}
		move = -1;
		while (column + move >= 0 && row + move >= 0) {
			if (board.field[row + move][column + move] == player.getPlayer()) {
				cnt++;
				move--;
			} else {
				move = -board.getColumns() - 1;
			}
		}

		if (cnt > 3) {
			return true;
		}

		return false;
	}

}
