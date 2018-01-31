import javax.swing.JOptionPane;
import java.util.Random;

public class Assn1_14clm1 {
	public static Random generator = new Random(System.currentTimeMillis());
	public static void main(String[] args) {
		int humanScore = 0;
		int compScore = 0;
		int turns = 0;
		System.out.println("Assignment1");		
		while (humanScore<100 && compScore<100) {
			turns++;
			humanScore += humanTurn();
			compScore += compTurn();
			System.out.println("Player: " + humanScore + ", Computer: " + compScore);
		} // end while
		if(humanScore>compScore) {
			System.out.println("The player wins in " + turns + " turns with " + humanScore + " points!");
		} else if (humanScore<compScore){
			System.out.println("The computer wins in "+ turns + " turns with " + compScore + " points!");
		} else {
			System.out.println("It's a Tie! With " + humanScore + " points!");
		} // end if
	} // end main()
	
	public static int humanTurn() {
		System.out.println("Player's turn");
		boolean noChoice = false;
		boolean hold = UI(noChoice);	
		int score = 0;
		int[] roll;
		
		while (!hold) {			
			noChoice = false;
			roll = rollDice();
			System.out.println("Roll: " + roll[0] + " " + roll[1]);
			if(roll[0] == 1 && roll[1] == 1) {
				score += 25;
				noChoice = true;
			} else if(roll[0] == 1 || roll[1] == 1) {
				System.out.println("Human scored 0 points");
				return 0;
			} else {
				score += roll[0] + roll[1];
			}
			System.out.println("Score on the line: " + score);
			hold = UI(noChoice);
		} // end while
		return score;
	} // end humanTurn()
	
	public static int compTurn() {
		System.out.println("Computer's turn");
		boolean noChoice = false;
		boolean hold = false;	
		int score = 0;
		int[] roll;
		int count = 0;
		
		while (!hold) {			
			noChoice = false;
			roll = rollDice();
			System.out.println(roll[0] + " " + roll[1]);
			if(roll[0] == 1 && roll[1] == 1) {
				score += 25;
				noChoice = true;
			} else if(roll[0] == 1 || roll[1] == 1) {
				System.out.println("Computer scored 0 points");
				return 0;
			} else {
				score += roll[0] + roll[1];
			}
			count++;
			if(count > 2 && !noChoice) hold = true;
			System.out.println("Score on the line: " + score);
		} // end while
		return score;
	} // end compTurn()
	
	public static int[] rollDice(){
		
		int[] roll = new int[2];
		roll[0] = 1 + generator.nextInt(6);
		roll[1] = 1 + generator.nextInt(6);
		return roll;
	} // end rollDice()
	
	public static boolean UI(boolean noChoice) {
		String input;
		boolean goodInput = false;
		if(noChoice) return false;
		while(!goodInput) {
			input = JOptionPane.showInputDialog("Enter 'hold' or 'roll'");
			if(input.equals("hold")) return true;
			else if(input.equals("roll")) return false;
			else {
				JOptionPane.showMessageDialog(null, "Please enter 'hold' or 'roll'");
				
			}
		}
		return false;
	}
	
	
}
