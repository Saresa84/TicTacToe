import java.util.Arrays;
import java.util.Scanner;

public class ticTacToeGame {
	// array with spaces for marks
	static String[][] spaces = { { " ", " ", " " }, { " ", " ", " " }, { " ", " ", " " } };
	static int xLocation = 0;
	static int yLocation = 0;
	static int tieCounter = 0;

	public static void main(String[] args) {
		// open Scanner
		Scanner input = new Scanner(System.in);

		// title and directions
		System.out.println("Welcome to Tic Tac Toe!" + "\n");
		System.out.println("You will be playing against the computer");

		// array that allows user to enter location as decimals to go through
		// getCoordinatesForUserMove and get coordinates
		String[][] moves = { { "1.1", "1.2", "1.3" }, { "2.1", "2.2", "2.3" }, { "3.1", "3.2", "3.3" } };
		String keepGoing = "y";
		while (keepGoing.equalsIgnoreCase("y")) {

			// prompt user for move
			System.out.print("Enter your move: ");
			String userMove = input.nextLine();
			// get user move coordinates and make sure spot no already filled,
			// if so prompts for another move
			getUserMove(input, moves, spaces, userMove);
			tieCounter++;
			// check for win
			if (tieCounter > 2) {
				if (checkForWin() == true) {
					System.out.println("You Won!! Your a Genius!!");
					// print updated board
					printBoard(spaces);
					System.out.print("Continue y/n? ");
					keepGoing = input.nextLine();
					if (keepGoing.equalsIgnoreCase("y")) {
						resetBoard();
						tieCounter = 0;
						System.out.print("Enter your move: ");
						userMove = input.nextLine();
						getUserMove(input, moves, spaces, userMove);
					}
				}

				// check for tie
				doThisForTie(input, moves, keepGoing);
			} // if tie notify and prompt for new game
				// print updated board
			if (keepGoing.equalsIgnoreCase("y")) {
				printBoard(spaces);
				// get pc move
				System.out.println("My turn!");
				getPCmove();
				tieCounter++;
			}

			if (tieCounter > 3) {
				// check for win
				if (checkForWin() == true && keepGoing.equals("y")) {
					System.out.println("Loser!! I Won, and I'm not even good!!");
					// print updated board
					printBoard(spaces);
					System.out.print("Continue y/n? ");
					keepGoing = input.next();
					input.nextLine();
					if (keepGoing.equalsIgnoreCase("y")) {
						resetBoard();
						tieCounter = 0;
						System.out.print("Enter your move: ");
						userMove = input.nextLine();
						getUserMove(input, moves, spaces, userMove);
					}
				}
			}
			if (keepGoing.equalsIgnoreCase("y")) {
				// print updated board
				printBoard(spaces);
			}
		} // end while keepGoing
		System.out.println("Bye!! Thanks for playing!!");
	}

	public static String doThisForTie(Scanner input, String[][] moves, String keepGoing) {
		String userMove;
		if (tieCounter >= 8) {
			System.out.println("It's a tie!!");
			printBoard(spaces);
			System.out.print("Continue y/n? ");
			keepGoing = input.nextLine();
			if (keepGoing.equalsIgnoreCase("y")) {
				resetBoard();
				tieCounter = 0;
				System.out.print("Enter your move: ");
				userMove = input.nextLine();
				getUserMove(input, moves, spaces, userMove);
			}
		}
		return keepGoing;
	}

	public static void tieCounter(String[][] moves) {
		for (int e = 0; e < moves.length; e++) {
			for (int f = 0; f < moves.length; f++) {
				if (moves[e][f].equalsIgnoreCase("X") || moves[e][f].equalsIgnoreCase("O")) {
					tieCounter++;
				}
			}
		}
	}

	public static boolean checkForWin() {
		// check for win
		if (spaces[0][0].equals(spaces[0][1]) && spaces[0][1].equals(spaces[0][2])
				&& (spaces[0][0].equals("X") || spaces[0][0].equals("O"))) {
			return true;
		} else if (spaces[1][0].equals(spaces[1][1]) && spaces[1][1].equals(spaces[1][2])
				&& (spaces[1][0].equals("X") || spaces[1][0].equals("O"))) {
			return true;
		} else if (spaces[2][0].equals(spaces[2][1]) && spaces[2][1].equals(spaces[2][2])
				&& (spaces[2][0].equals("X") || spaces[2][0].equals("O"))) {
			return true;
		} else if (spaces[0][0].equals(spaces[1][0]) && spaces[1][0].equals(spaces[2][0])
				&& (spaces[0][0].equals("X") || spaces[0][0].equals("O"))) {
			return true;
		} else if (spaces[0][1].equals(spaces[1][1]) && spaces[1][1].equals(spaces[2][1])
				&& (spaces[1][0].equals("X") || spaces[1][0].equals("O"))) {
			return true;
		} else if (spaces[0][2].equals(spaces[1][2]) && spaces[1][2].equals(spaces[2][2])
				&& (spaces[0][2].equals("X") || spaces[0][2].equals("O"))) {
			return true;
		} else if (spaces[0][0].equals(spaces[1][1]) && spaces[1][1].equals(spaces[2][2])
				&& (spaces[0][0].equals("X") || spaces[0][0].equals("O"))) {
			return true;
		} else if (spaces[0][2].equals(spaces[1][1]) && spaces[1][1].equals(spaces[2][0])
				&& (spaces[0][2].equals("X") || spaces[0][2].equals("O"))) {
			return true;
		}
		return false;
	}

	public static void getUserMove(Scanner input, String[][] moves, String[][] spaces, String userMove) {
		getCoordinatesForUserMove(moves, userMove);
		while (spaces[xLocation][yLocation].equalsIgnoreCase("X")
				|| spaces[xLocation][yLocation].equalsIgnoreCase("O")) {
			System.out.println("You must pick a spot that does not have a 'X' or 'O'.");
			System.out.print("Enter your move: ");
			userMove = input.nextLine();
			getCoordinatesForUserMove(moves, userMove);
		}
		spaces[xLocation][yLocation] = "X";
	}

	public static void printBoard(String[][] spaces) {
		// print board
		System.out.print(" " + spaces[0][0] + " |" + " " + spaces[0][1] + " |" + " " + spaces[0][2] + "\n");
		System.out.println("---|---|---");
		System.out.print(" " + spaces[1][0] + " |" + " " + spaces[1][1] + " |" + " " + spaces[1][2] + "\n");
		System.out.println("---|---|---");
		System.out.print(" " + spaces[2][0] + " |" + " " + spaces[2][1] + " |" + " " + spaces[2][2] + "\n");
		// end prints game board
	}

	public static void getCoordinatesForUserMove(String[][] moves, String userMove) {
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves.length; j++) {
				if (userMove.equalsIgnoreCase(moves[i][j])) {
					// moves [i][j]="0";
					xLocation = i;
					yLocation = j;
					// System.out.println("X and Y Coordinates for that move: "
					// + xLocation +"-" + yLocation);
				} // end if statement finding move
			}

		} // end for loop getting variables for coordinates
	}

	public static void getPCmove() {
		// PC picks move
		for (int x = 0; x < spaces.length; x++) {
			for (int y = 0; y < spaces.length; y++) {
				// checks if spot is avaiable on board
				if (spaces[x][y].equalsIgnoreCase(" ")) {
					spaces[x][y] = "O";
					return;
				}
			}
		}
	}

	public static void resetBoard() {
		for (String[] rows : spaces)
			Arrays.fill(rows, " ");
	}
}
