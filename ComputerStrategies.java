//Dimitrios Gazos A.M. 4035
package dim;



class ComputerStrategies
{
	private RandomStrategy RandomPos = new RandomStrategy();
	private ExplorationStrategy Strategy;
	private boolean explorerMode = false;
	
	private StrikeBoard PlayerStrikeBoard = new StrikeBoard();
	
	
	public ComputerStrategies(StrikeBoard eBoard)
	{
		
		PlayerStrikeBoard = eBoard;
		Strategy = new ExplorationStrategy(PlayerStrikeBoard);
	}
	
	public int[] nextStrike()
	{
		int pos[] = new int[2];
		if (explorerMode == false)
		{
			pos = RandomPos.nextStrike();
			
			return pos;
		}
		else
		{
			pos = Strategy.nextStrike();
			
			return pos;
		}
		
	}
	
	public void update(int pos[] , boolean Hit)
	{
		if (explorerMode == false)
			RandomPos.update();
		else 
		{
			String s1 = String.format("%d" , pos[0]);
			String s2 = String.format("%d" , pos[1]);
			String number = s1 + s2;
			RandomPos.delItem(number);
		}
		if (Hit == true && explorerMode == false)
		{
			Strategy.initialize(pos);
			explorerMode = true; 
			
		}
		else if (Hit == true)		
		{
			 
			
			
			Strategy.update(pos, Hit);
			
		}
		
	}
	
	public void completeExploration()
	{
		explorerMode = false;
	}

}
