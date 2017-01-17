package com.fdmgroup.connectfour;

public class Board {

	private int rows = 6;
	private int columns = 7;
	public String[][] field = new String[rows][columns];

	private String longline = "------------------------------------";
	private String emptyEntry = " ";

	public void clearField() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				field[i][j] = emptyEntry;
			}
		}
	}

	public void displayField(Player player) {
		System.out.println("\n" + displayTopLine(player) + "\n\n");
		String string = "";
		for (int i = 0; i < field.length; i++) {
			string += "|";
			for (int j = 0; j < field[0].length; j++) {
				string += " " + field[i][j] + "  |";
			}
			string += "\n" + longline + "\n";
		}
		System.out.println(string);
	}

	private String displayTopLine(Player player) {
		String string = "             " + player.getPlayer() + "'s turn\n\n   ";
		for (int i = 1; i <= columns; i++) {
			string += i + "    ";
		}
		return string;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public String getEmptyEntry() {
		return emptyEntry;
	}

}
