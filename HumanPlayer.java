//Dimitrios Gazos A.M. 4035
package dim;

import java.util.Scanner;



class HumanPlayer
{
	private String name;
	public ShipBoard PlayerShipBoard = new ShipBoard();
	public StrikeBoard PlayerStrikeBoard = new StrikeBoard();
	
	public HumanPlayer(String name)
	{
	    this.name = name;
	    System.out.println(name + " enter your ships");
	    PlayerShipBoard.enterAllShipsManually();
	    //PlayerShipBoard.printBoard();
	}
	
	public int[] nextStrike()
	{
		int pos[] = new int[2];
		Scanner input = new Scanner(System.in);
		while (true)
		{
			System.out.println("Give position of hit , row 0-9 , column 0-9");
			
			String number;
			
			number = input.nextLine();
			
			if (!number.matches("\\d+ \\d+"))  // integer space integer example 5 6
	 		{
			    System.out.println("Invalid numbers");
			    continue;
			}
		
			String[] split = number.split(" ");//Split using space hyphen space
						
			
			int row =  Integer.parseInt(split[0]);
			int column=Integer.parseInt(split[1]);
			
			
			//int row = input.nextInt();
			//int column = input.nextInt();
			
			if ((row > 9) || (row < 0) || (column > 9) || (column < 0))
			{
				System.out.println("ERROR invalid input");
			}
			else 
			{
				pos[0] = row;
				pos[1] = column; 
				
				return pos;
			}
			
		}
		
	}
	
	public void update(int pos[] , boolean Hit)
	{
		PlayerStrikeBoard.addStrike(pos , Hit);
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

}

