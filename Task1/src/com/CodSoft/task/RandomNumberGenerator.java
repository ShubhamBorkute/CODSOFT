package com.CodSoft.task;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {

	public static void main(String[] args) {

		Random obj = new Random();    
		//Created Object of Random class to generator random Number
		Scanner sc = new Scanner(System.in);
         //Scanner to take User Input
		int num = 0;
		int attemptsLimits = 5;       //Initially 5 Attempts
		int rounds = 0;
		int totalScore = 0;          //getting totalScore

		boolean reset = true;

		while (reset) {
			int org = obj.nextInt(100);
			int attempt = 0;
			System.out.println("Welcome To the Number Guessing game");
			System.out.println("Enter Number from 1 to 100");

			while (attempt < attemptsLimits) {            
                   //attempt validate 
				
				num = sc.nextInt();
				attempt++;

				if (num == org) {
					//if User guess it Right
					System.out.println("Congratulations! Your Guessed the number in " + attempt+" attempts.");
					System.out.println();

					totalScore ++;
					break;
				
				} if (num < org) {
					
					System.out.println("Too Low! Try again");

				} else {
					System.out.println("Too High! Try again");
				}
				
			}

			if (attempt == attemptsLimits && org!=num) {
				System.out.println();
				System.out.println("Sorry, No Attempts Left ," + "The Number was " + org);
			
			}
			rounds++;

			System.out.println("Do You want to play again? (yes/no):");
              //Giving Choice
			String choice = sc.next();
			reset = choice.equalsIgnoreCase("yes");

		}

		System.out.println("Thanks for playing " + "Your Win score is : " + totalScore + " ,Your Attempt round is : " +rounds +".");

	}

}
