//Dimitrios Gazos A.M. 4035
package dim;




class ExplorationStrategy
{
	private int start[] = new int[2];
	private int end[] = new int[2];
	private StrikeBoard PlayerStrikeBoard = new StrikeBoard();
	
	
	public ExplorationStrategy (StrikeBoard eBoard)
	{
		PlayerStrikeBoard = eBoard;
		
	}
	
	
	
	public void initialize(int pos[])
	{
		for (int i = 0; i < 2; i++)
		{
			start[i] = end[i] = pos[i];
		}
	}
	
	public int[] nextStrike()
	{
		int pos[] = new int[2];
		
		int difX = end[0] - start[0];
		int difY = end[1] - start[1];
		
		if (difX == difY)
		{
			pos[0] = end[0];
			pos[1] = end[1] + 1;
			if (PlayerStrikeBoard.isValidCandidate(pos) == true )
				return pos;
			pos[0] = start[0];
			pos[1] = start[1] - 1;
			if (PlayerStrikeBoard.isValidCandidate(pos) == true )
				return pos;
			pos[0] = start[0] - 1;
			pos[1] = start[1];
			if (PlayerStrikeBoard.isValidCandidate(pos) == true )
				return pos;
			pos[0] = end[0] + 1;
			pos[1] = end[1];
			if (PlayerStrikeBoard.isValidCandidate(pos) == true )
				return pos;
		}
		else if (difX < difY)
		{
			pos[0] = end[0];
			pos[1] = end[1] + 1;
			if (PlayerStrikeBoard.isValidCandidate(pos) == true )
				return pos;
			pos[0] = start[0];
			pos[1] = start[1] - 1;
			if (PlayerStrikeBoard.isValidCandidate(pos) == true )
				return pos;
		}
		else 
		{
			pos[0] = start[0] - 1;
			pos[1] = start[1];
			if (PlayerStrikeBoard.isValidCandidate(pos) == true )
				return pos;
			pos[0] = end[0] + 1;
			pos[1] = end[1];
			if (PlayerStrikeBoard.isValidCandidate(pos) == true )
				return pos;
		}
		return pos;
	}
	
	public void update(int pos[],boolean Hit)
	{
		PlayerStrikeBoard.addStrike(pos, Hit);
		if (Hit == true)
		{
			
			if (pos[0] < start[0]) start[0] = pos[0];
			if (pos[0] > end[0]) end[0] = pos[0];
			if (pos[1] < start[1]) start[1] = pos[1];
			if (pos[1] > end[1]) end[1] = pos[1];	 
		}	
	}
}