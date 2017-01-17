package com.fdmgroup.connectfour;

public class Check {

	public boolean placeWithin(Board board, int number) {
		if (number > 0 && number <= board.getColumns())
			return true;
		else {
			return false;
		}
	}

	public boolean draw(Board board) {
		for (int i = 0; i < board.getColumns(); i++) {
			for (int j = 0; j < board.getRows(); j++) {
				if (board.field[i][j] == board.getEmptyEntry()){
					return false;
				}
			}
		}
		return true;
	}

}
