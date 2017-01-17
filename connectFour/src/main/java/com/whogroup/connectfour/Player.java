package com.whogroup.connectfour;

public class Player {
	
	private String player = "X"; 
	
    public void togglePlayer(){
        if(player=="X"){
            player = "O";
        } else {
            player = "X";
        }
    }
    
    public String getPlayer(){
        return player;
    }

}
