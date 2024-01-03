Hello My Dear Connections!!

Excited to share my first project at CodSoft! 🎮🔢

👨‍💻 During my internship, I had the fantastic opportunity to work on Task 1, and I'm thrilled to present my video explanation of the Number Guessing Game! 🎥💡

🔍 Task 1 involved creating a fun and interactive number guessing game in Java. I delved into user input, random number generation, and loop structures to make this game engaging and challenging.

Here is my repo of this task: https://lnkd.in/gFQvZ_87

🕹️💡 My video breaks down the game logic, showcases the code structure, and explains the user interaction step-by-step. I'm proud of the results and eager to share my learning journey!


💬 I'd love to hear your thoughts and feedback on the project! Feel free to watch the video and drop your comments or questions below.🌟

#codsoft #JavaProgramming #NumberGuessingGame #internshipjourneypackage com.CodSoft.task;

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
