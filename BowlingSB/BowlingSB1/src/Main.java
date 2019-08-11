

public class Main {
	public static void main(String[] args) 
	{
		String[] scoreBoard = new String[] {"9-","9-","9-","9-","9-","9-","9-","9-","9-","9-"};
		String[] scoreBoard1 = new String[] {"5/","5/","5/","5/","5/","5/","5/","5/","5/","5/5"};
		String[] scoreBoard2 = new String[] {"X","X","X","X","X","X","X","X","X","XXX"};
		
		ScoreCalculation score = new ScoreCalculation();
		score.calculator(scoreBoard);
	}

}
