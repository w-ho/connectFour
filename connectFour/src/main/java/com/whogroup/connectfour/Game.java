package com.whogroup.connectfour;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Scanner scanner = new Scanner(System.in);
    
    private Player player = new Player();
    private Board board = new Board();
    private CheckWinner checkWinner = new CheckWinner();
    private SetPlace setPlace = new SetPlace();
    private Check check = new Check();
    
    private boolean endOfGame = false;
    private int number;
    
    public void play(){
    	setup();
        while(!endOfGame){
            try {
                placement();
                if (check.placeWithin(board, number)){
                    endOfGame = setPlace.setEntry(board, player,checkWinner, number);
                    if(check.draw(board)){
                    	displaydraw();
                    }
                } else {
                    System.out.println("This place is not available\nPlease enter another number");
                }
                System.out.println("\n");
                board.displayField(player);
            } catch (InputMismatchException e){
                endOfGame = true;
                player.togglePlayer();
                System.out.println("You enter a non number\nYou lose");
            }
        }
        displayWinner();
    }

	private void setup(){
    	board.clearField();
    	System.out.println("Connect Four in the a row, column or diagonal to win.");
        board.displayField(player);
    }
    
    private void placement(){
    	System.out.println("    Where would you like to go?");
    	number = scanner.nextInt();
    }
    
    private void displayWinner() {
    	System.out.println("The winner is " + player.getPlayer());
        System.out.println("!!! Congratulation !!!");
        scanner.close();
	}
    
    private void displaydraw() {
		System.out.println("It's a draw, everybody wins!!!");
		System.exit(0);
	}

}
    