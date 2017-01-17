package com.whogroup.connectfour;

public class SetPlace {
	
	public void updateField(Player player,Board board, int row, int column) {
		board.field[row][column] = player.getPlayer();
	}
	
	public boolean setEntry(Board board, Player player, CheckWinner check, int number){
        int row = getLowestEmptyPlaceinColumn(board, number-1);
        if (row >= 0 ){
            updateField(player,board, row,number-1);
            boolean winnerexists = check.checkWinner(board, player, row, number-1);
                if (!winnerexists){ 
                    player.togglePlayer();
                } else {
                    return true;
                }
        } else {
            System.out.println("Column " + number + " is full!!");
        }
        return false;
    }
    
    private int getLowestEmptyPlaceinColumn(Board board, int number){
        for(int i = board.getRows()-1 ; i >=0 ;i--){
            if (board.field[i][number].equals(board.getEmptyEntry())){
                return i;
            }
        }
        return -1;
    }


}
