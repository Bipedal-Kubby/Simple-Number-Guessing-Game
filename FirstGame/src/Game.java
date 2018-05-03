import java.util.Scanner;

public class Game {
	static Scanner input = new Scanner(System.in);
	
	public static void game(int range) { // range = maximum number in range to be guessed
		// variables
		int guess, randNum = (int) (Math.random() * (range - 1)) + 1;
		
		// game loop
		while(true) {
			// Prompt for guess
			System.out.println("\n\tEnter a number between 1 and " + range + " or 0 to exit.");
			guess = input.nextInt();
			
			// Determine guess and provide feedback
			if (guess >= 0 && guess <= range) {
				if (guess == 0) {
					System.exit(0);
				} else if (guess < randNum) {
					System.out.println("\tHigher");
				} else if (guess > randNum) {
					System.out.println("\tLower");
				} else {
					System.out.println("\n\tCongratulations! The number was " + randNum + "!");
					randNum = (int) (Math.random() * (range - 1)) + 1;
					System.out.println("New number generated");
					continue;
				}
			} else {
				System.out.println("\n\tThat's not in the accepted range.");
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		// Variables
		int diff;
		
		// Print game intro
		System.out.println("This is a guessing game. The program generates a pseudorandom number");
		System.out.println("in the range specified by your difficulty. You keep guessing until you get it or quit.");
		
		// Continuously ask for difficulty while answer is not in range of accepted answers
		do {
			System.out.println("\n\tSelect a difficulty or exit:");
			System.out.println("\t1  Easy (1 - 10)");
			System.out.println("\t2  Medium (1 - 50) (default)");
			System.out.println("\t3  Hard (1 - 100)");
			System.out.println("\t4  Exit");
			diff = input.nextInt();
		} while (diff < 1 || diff > 3);
		
		// Call game() with appropriate range
		switch (diff) {
		case 1:
			// Run game with range of 1 to 10
			game(10);
			break;
		case 2:
			// Run game with range of 1 to 50
			game(50);
			break;
		case 3:
			// Run game with range of 1 to 100
			game(100);
			break;
		case 4:
			// Close the VM (exit the program)
			System.exit(0);
		default:
			// Run game with range of 1 to 50
			game(50);
		}
	}
}
