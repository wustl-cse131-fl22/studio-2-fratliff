package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Start amount: ");
		double startAmount = in.nextDouble();
		double currentAmount = startAmount;
		System.out.println("Win Chance: ");
		double winChance = in.nextDouble();
		System.out.println("Win limit ");
		double winLimit = in.nextDouble();
		System.out.println("Total simulations ");
		int totalSimulations = in.nextInt();
		int dayNumber = 1;
		int plays = 0;
		int loss = 0;
		
		for(int i = 0; i < totalSimulations; i++ ) {
		
		while(currentAmount > 0 && currentAmount < winLimit) {
			double game = Math.random();
			if(winChance > game) {
				System.out.println("You won!");
				currentAmount++;
				
			}
			else {
					System.out.println("You lost.");
					currentAmount--;
					

			}
			System.out.println("Current Amount: " + currentAmount);

		}
		
		currentAmount = startAmount; 
		dayNumber ++;
		System.out.println("Day number: " + dayNumber);
		System.out.println("Plays: " + plays);
		if (currentAmount <= 0) {
			System.out.println("You lost all your money for the day. Sell your house and play some more. ");
			loss++;
		}
		else {
			System.out.println("You hit the win limit! Good job.");
		}
	
		
		
		
	}
		
		System.out.println("Ruin Rate: " + loss/totalSimulations);
		double alpha = (1 - winChance)/winChance;
		double expectedRuin = 0;
		if(winChance == 0.5) {
			expectedRuin = 1 - (double)startAmount/winLimit;

		}
		else {
			expectedRuin = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit))/(1- Math.pow(alpha, winLimit));
			
		}
		
System.out.println(expectedRuin);
		
		
	}

}
