//Dimitrios Gazos A.M. 4035
package dim;



class ComputerPlayer
{
	private String name = "HAL";
	public ShipBoard PlayerShipBoard = new ShipBoard();
	public StrikeBoard PlayerStrikeBoard = new StrikeBoard();
	//private RandomStrategy RandomPos = new RandomStrategy();
	public ComputerStrategies StrategyGame;
	
	
	public ComputerPlayer()
	{
	    PlayerShipBoard.enterAllShipsRandomly();
	    //PlayerShipBoard.printBoard();
	    StrategyGame = new ComputerStrategies(PlayerStrikeBoard);
	}
	
	public int[] nextStrike()
	{
		int pos1[] = new int[2];
		pos1 = StrategyGame.nextStrike();
		//StrategyGame.update(pos1, true);    
		System.out.println(pos1[0] + " " + pos1[1]); 
		return pos1;

	}
	
	public void update(int pos[] , boolean Hit)
	{
		PlayerStrikeBoard.addStrike(pos , Hit);
		StrategyGame.update(pos, Hit); 
		
	}
	
	public boolean getStrike(int pos[])
	{
		return PlayerShipBoard.getStrike(pos);
		
	}
	
	public boolean allShipsSank()
	{
		return PlayerShipBoard.allShipsSank();
		
	}
	
	public boolean lastStrikeSankShip()
	{
		return PlayerShipBoard.lastStrikeSankShip();
	}
	
	public String toString()
	{
		return name;
	}
	
	
	public void completeExploration()
	{
		StrategyGame.completeExploration();
	}


}

