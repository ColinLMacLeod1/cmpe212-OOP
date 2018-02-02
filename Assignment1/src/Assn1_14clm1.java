import javax.swing.JOptionPane;
import java.util.Random;

public class Assn1_14clm1 {
	public static Random generator = new Random(System.currentTimeMillis());
	public static void main(String[] args) {
		int humanScore = 0; // The total player score at the beginning of each turn
		int compScore = 0;  // The total computer score at the beginning of each turn
		int turns = 0;      // Turn counter
		System.out.println("Assignment1: The Game of Pig");		
		while (humanScore<100 && compScore<100) { //Updating scores and counting turns
			turns++;
			humanScore += humanTurn(humanScore);
			compScore += compTurn(compScore);
			System.out.println("Player's Sum is: " + humanScore + ", Computer's Sum is: " + compScore);
		} // end while
		if(humanScore>compScore) {   // Defining victory conditions
			System.out.println("The player wins in " + turns + " turns with " + humanScore + " points!");
		} else if (humanScore<compScore){
			System.out.println("The computer wins in "+ turns + " turns with " + compScore + " points!");
		} else {
			System.out.println("It's a Tie! With " + humanScore + " points!");
		} // end if
	} // end main()
	
	public static int humanTurn(int totalScore) {
		System.out.println("Player's turn:");
		boolean noChoice = false;     // Indicator of whether or no the play will be force to roll again
		boolean hold = UI(noChoice);  // Indicator of whether or not the turn will end
		int score = 0;                // Turn score
		int[] roll;                   // Array of the roll
		
		while (!hold) {		          // While the player has not chosen to hold, roll	
			noChoice = false;
			roll = rollDice();
			System.out.println("Player rolled: " + num2String(roll[0]) + " " + num2String(roll[1]));
			if(roll[0] == 1 && roll[1] == 1) {  // Setting different outcomes of a roll
				score += 25;
				noChoice = true;
			} else if(roll[0] == 1 || roll[1] == 1) {
				System.out.println("TURN OVER! Turn sum is zero!");
				return 0;
			} else if(roll[0] == roll[1]) {
				score=+ 4*roll[0];
				noChoice = true;
				System.out.println("DOUBLES!");
			} else {
				score += roll[0] + roll[1];
			} // end if
			System.out.println("Player's turn sum is: " + score + " and game sum would be: " + (score+ totalScore));
			if(noChoice) System.out.println("Player must roll again!");
			hold = UI(noChoice);    // Determining if the player must roll again
		} // end while
		return score;
	} // end humanTurn()
	
	public static int compTurn(int totalScore) {
		System.out.println("Computer's turn:");
		boolean noChoice = false;  // Indicator of whether or no the play will be force to roll again
		boolean hold = false;	   // Indicator of whether or not the turn will end
		int score = 0;             // Turn score
		int[] roll;                // Array of the roll
		int count = 0;             // Roll count to limit the computer
		
		while (!hold) {			   // While the player has not chosen to hold, roll	
			noChoice = false;
			roll = rollDice();
			System.out.println("Computer rolled:" + num2String(roll[0]) + " " + num2String(roll[1]));
			if(roll[0] == 1 && roll[1] == 1) {  // Setting different outcomes of a roll
				score += 25;
				noChoice = true;
			} else if(roll[0] == 1 || roll[1] == 1) {
				System.out.println("TURN OVER! Turn sum is zero!");
				return 0;
			} else if(roll[0] == roll[1]) {
				score=+ 4*roll[0];
				noChoice = true;
				System.out.println("DOUBLES!");
			} else {
				score += roll[0] + roll[1];
			} // end if
			count++;
			if(count > 2 && !noChoice) hold = true;
			System.out.println("Copmuter's turn sum is: " + score + " and game sum would be: " + (score+ totalScore));
			if(noChoice) System.out.println("Copmuter must roll again!");
		} // end while
		return score;
	} // end compTurn()
	
	public static int[] rollDice(){	// Rolling the dice out putting an array of two integers
		int[] roll = new int[2];
		roll[0] = 1 + generator.nextInt(6);
		roll[1] = 1 + generator.nextInt(6);
		return roll;
	} // end rollDice()
	
	public static boolean UI(boolean noChoice) {  // Taking the user input of either rolling or holding
		String input;
		boolean goodInput = false;
		if(noChoice) return false;
		while(!goodInput) {
			input = JOptionPane.showInputDialog("Enter 'hold' or 'roll'");
			if(input.equals("hold")) return true;
			else if(input.equals("roll")) return false;
			else {
				JOptionPane.showMessageDialog(null, "Please enter 'hold' or 'roll'");			
			} // end if
		}// end while
		return false;
	} // end UI()
	
	public static String num2String(int num) {  // Converts ints to string for the roll
		switch(num) {
			case 1: return "one";
			case 2: return "two";
			case 3: return "three";
			case 4: return "four";
			case 5: return "five";
			case 6: return "six";
			default: return "error";
		} // end switch 
	} // end num2String()
	
	
}
