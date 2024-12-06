//Dimitrios Gazos A.M. 4035
package dim;

class StrikeBoard
{
	private int PlayerHit[][] = new int[10][10];
	
	public void addStrike(int pos[], boolean Hit)
	{
		if(Hit == true)
			PlayerHit[pos[0]][pos[1]] = 1;
		else
			PlayerHit[pos[0]][pos[1]] = -1;
	}
	
	public void printBoard()
	{
		for(int i = 0; i<10; i++)
		{
			for(int j = 0; j<10; j++) 
			{
				System.out.printf("%3d" , PlayerHit[i][j]);
			}
			System.out.println("\n");
		}
	
	}
	
	public boolean isValidCandidate(int pos[])
	{
		if ((pos[0] > 9) || (pos[0] < 0) || (pos[1] > 9) || (pos[1] < 0))
			return false;
		if (PlayerHit[pos[0]][pos[1]] != 0)
			return false;
		
		return true;
	}
}

