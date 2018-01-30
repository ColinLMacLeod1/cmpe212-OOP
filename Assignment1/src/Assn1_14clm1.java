
public class Assn1_14clm1 {

	public static void main(String[] args) {
		int humanScore = 0;
		int compScore = 0;
		System.out.println("Assignment1");
		humanScore = updateScore(1,2);
		System.out.println(humanScore);
	}
	public static int updateScore(int die1, int die2) {
		System.out.println(die1 + ", " + die2);
		return die1 + die2;
		
	}
}
