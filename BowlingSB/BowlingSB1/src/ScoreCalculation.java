

public class ScoreCalculation {
	
	private int totalScore = 0;
	private int spareScore = 0;
	private int strikeScore1 = 0;
	private int strikeScore2 = 0;
	
	public void calculator(String[] scoreBoard)
	{
		for(int i = 0; i < Rules.getFrames(); i++)
		{
			char[] temp = scoreBoard[i].toCharArray();
			for(int j = 0; j < temp.length; j++) 
			{
				//Skjekker om runden inneholder 3 kast, implisitt siste runde
				if(temp.length == 3)
				{
					if(temp[j] == '-') 
					{
						missThree(j);
					}
					else if(temp[j] == '/')
					{
						spareThree(j, Integer.valueOf(temp[j-1] - '0'));
					}
					else if(temp[j] == 'X')
					{
						strikeThree(j);
					}
					else
					{
						restThree(j, Integer.valueOf(temp[j] - '0'));
					}
				}
				else
				{
					if(temp[j] == '-')
					{
						miss();
					}
					else if(temp[j] == '/')
					{
						spare(Integer.valueOf(temp[j - 1] - '0'));
					}
					else if(temp[j] == 'X')
					{
						strike();
					}
					else
					{
						rest(Integer.valueOf(temp[j] - '0'));
					}
				}
			}
		}
		System.out.println("Total: " + this.totalScore);
	}
	
	//Ved bom
	public void miss()
	{
		if(strikeScore2 != 0)
		{
			totalScore += strikeScore2;
			strikeScore2 = 0;
		}
		if(strikeScore1 != 0)
		{
			strikeScore2 = strikeScore1;
			strikeScore1 = 0;
		}
	}
	
	//Ved spare
	public void spare(int k) 
	{
		spareScore = Rules.getPins();
		totalScore -= k;
		if(strikeScore2 != 0)
		{
			totalScore += k + strikeScore2;
			strikeScore2 = 0;
		}
		if(strikeScore1 != 0)
		{
			strikeScore2 = strikeScore1 + k;
			strikeScore1 = 0;
		}
	}
	
	//Ved strike
	public void strike()
	{
		if(strikeScore2 != 0)
		{
			totalScore += Rules.getPins() + strikeScore2;
			strikeScore2 = 0;
		}
		if(strikeScore1 != 0)
		{
			strikeScore2 = strikeScore1 + Rules.getPins();
			
		}
		strikeScore1 = Rules.getPins();
	}
	
	//Ved alle andre kast som ikke er i trekastrunde
	public void rest(int k)
	{
		if(spareScore == Rules.getPins()) 
		{
			totalScore += spareScore + 2 * k;
			spareScore = 0;
		}
		else
		{
			totalScore += k;
		}
		if(strikeScore2 != 0)
		{
			totalScore += k + strikeScore2;
			strikeScore2 = 0;
		}
		if(strikeScore1 != 0)
		{
			strikeScore2 = strikeScore1 + k;
			strikeScore1 = 0;
		}
	}
	
	//Ved bom i runde med tre kast
	public void missThree(int j) 
	{
		if(j == 0)
		{
			if(strikeScore2 != 0)
			{
				totalScore += strikeScore2;
				strikeScore2 = 0;
			}
			if(strikeScore1 != 0)
			{
				strikeScore2 = strikeScore1 + 0;
				strikeScore1 = 0;
			}
		}
		else if(j == 1) 
		{
			if(strikeScore2 != 0)
			{
				totalScore += strikeScore2;
				strikeScore2 = 0;
			}
		}
		else
		{
			
		}
	}
	
	//Ved spare i runde med tre kast
	public void spareThree(int j, int k) 
	{
		if(j == 1) 
		{
			totalScore += Rules.getPins() - k;
		}
		else
		{
			totalScore += Rules.getPins();
		}
		if(strikeScore2 != 0)
		{
			totalScore += strikeScore2;
			strikeScore2 = 0;
		}
		if(strikeScore1 != 0)
		{
			strikeScore2 = strikeScore1;
			strikeScore1 = 0;
		}
	}
	
	//Ved strike i runde med tre kast
	public void strikeThree(int j) 
	{
		if(j == 0) 
		{
			if(strikeScore2 != 0)
			{
				totalScore += Rules.getPins() + strikeScore2;
				strikeScore2 = 0;
			}
			if(strikeScore1 != 0)
			{
				strikeScore2 = strikeScore1 + Rules.getPins();
				strikeScore1 = Rules.getPins();
			}
			if(strikeScore1 == 0 && strikeScore2 == 0)
			{
				totalScore += Rules.getPins();
			}
		}
		else if(j == 1) 
		{
			if(strikeScore2 != 0)
			{
				totalScore += Rules.getPins() + strikeScore2;
				strikeScore2 = Rules.getPins();
			}
			else
			{
				totalScore += Rules.getPins();
			}
		}
		else
		{
			totalScore += Rules.getPins();
			if(strikeScore2 != 0)
			{
				totalScore += strikeScore2;
				strikeScore2 = 0;
			}
			if(strikeScore1 != 0)
			{
				totalScore += strikeScore1;
				strikeScore1 = 0;
			}
		}
	}
	
	//Ved alle andre kast i runde med tre kast
	public void restThree(int j, int k) 
	{
		if(spareScore == Rules.getPins() && j == 0)
		{
			totalScore += spareScore + 2*k;
			spareScore = 0;
		}
		else if(j == 0) 
		{
			if(strikeScore2 != 0)
			{
				totalScore += k + strikeScore2;
				strikeScore2 = 0;
			}
			if(strikeScore1 != 0)
			{
				strikeScore2 = strikeScore1 + k;
				strikeScore1 = k;
			}
		}
		else if(j == 1) 
		{
			if(strikeScore2 != 0)
			{
				totalScore += k + strikeScore2;
				strikeScore2 = k;
			}
		}
		else
		{
			totalScore += k;
		}
	}

}

