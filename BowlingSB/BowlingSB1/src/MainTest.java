
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void noBonusTest() {
		System.out.println("No bonus:");
		ScoreCalculation score = new ScoreCalculation();
		score.calculator(new String[] {"9-","9-","9-","9-","9-","9-","9-","9-","9-","9-"});//90
		
	}
	
	@Test
	void fullSpareTest() {
		System.out.println("Spare:");
		ScoreCalculation score = new ScoreCalculation();
		score.calculator(new String[] {"5/","5/","5/","5/","5/","5/","5/","5/","5/","5/5"});//150
	}

	@Test
	void FullStrikeTest() {
		System.out.println("Strike:");
		ScoreCalculation score = new ScoreCalculation();
		score.calculator(new String[] {"X","X","X","X","X","X","X","X","X","XXX"});//300
	}
	
	@Test
	void randomTest() {
		System.out.println("Random:");
		ScoreCalculation score = new ScoreCalculation();
		score.calculator(new String[] {"45","3/","53","X","62","63","71","72","X","45"});//112
	}
	
	@Test
	void missTest() {
		ScoreCalculation score = new ScoreCalculation();
		score.miss();
	}
	
	@Test
	void spareTest() {
		ScoreCalculation score = new ScoreCalculation();
		score.spare(5);
	}
	
	@Test
	void strikeTest() {
		ScoreCalculation score = new ScoreCalculation();
		score.strike();
	}
	
	@Test
	void restTest() {
		ScoreCalculation score = new ScoreCalculation();
		score.rest(5);
	}
	
	@Test
	void missThreeTest() {
		ScoreCalculation score = new ScoreCalculation();
		score.missThree(0);
	}
	
	@Test
	void spareThreeTest() {
		ScoreCalculation score = new ScoreCalculation();
		score.spareThree(0,5);
	}
	
	@Test
	void strikeThreeTest() {
		ScoreCalculation score = new ScoreCalculation();
		score.strikeThree(0);
	}
	
	@Test
	void restThreeTest() {
		ScoreCalculation score = new ScoreCalculation();
		score.restThree(0,5);
	}
}
