//Dimitrios Gazos A.M. 4035
package dim;

import java.util.Scanner;


class ShipBoard
{
	private int ShipSize[] = new int[5];
	private int ShipPosition[][] = new int[10][10];
	private boolean HitPosition[][] = new boolean[10][10];
	private boolean LastHit=false;
	private int HitShips[] = new int[5];
	public ShipBoard()
	{
		ShipSize[0] = 5;
		ShipSize[1] = 4;
		ShipSize[2] = 3;
		ShipSize[3] = 3;
		ShipSize[4] = 2;
		for (int i = 0; i <5; i++)
		{
			HitShips[i] = ShipSize[i];
		}
				
	}
	
	private boolean check (int id , int row , int column, boolean inform)
	{
		if ((row > 9) || (row < 0) || (column > 9) || (column < 0))
		{
			if (inform)
				System.out.println("ERROR ship out of board!");
				//System.out.println("Give position of ship " + id + " row 0-9 , column 0-9");
			return false;
		}
		
		if(ShipPosition[row][column] != 0)
		{
			if (inform)
				System.out.println("ERROR ship " + ShipPosition[row][column] +  " already in this space" );
			return false;
		}
		
		return true;
		
	}
	
	private void DeleteShip(int id)
	{
		for(int i = 0; i<10; i++)
		{
			for(int j = 0; j<10; j++) 
			{
				if (ShipPosition[i][j] == id)
					ShipPosition[i][j] = 0;
					
			}
		}
	}
	
	
	
	
	
	
	
	
	private boolean enterShipManually(int id)
	{
		Scanner input = new Scanner(System.in);
		
		int row = -1;
		int column = -1;
		
		while (true)
		{
			System.out.println("Give position of ship " + id + " , row 0-9 , column 0-9 (example:5 6)");
			
			
			String number;
		
			number = input.nextLine();
			
			if (!number.matches("\\d+ \\d+"))  // integer space integer example 5 6
	 		{
			    System.out.println("Invalid numbers");
			    continue;
			}
		
			String[] split = number.split(" ");//Split using space hyphen space
						
			
			row =  Integer.parseInt(split[0]);
			column=Integer.parseInt(split[1]);
			
			//System.out.println(" "+row+" "+column);
			
			/*							
			row=input.nextInt();
			column=input.nextInt();
			*/
			
			
			if (check(id ,row,column,true) == true)
			{	
		
				while(true)
				{
				System.out.println("Give orientation (H)orizontal or (V)ertical");
				char orientation = input.next().charAt(0);
							
				
				if (orientation == 'V')
				{
					for (int i = 0; i < ShipSize[id-1]; i++)
					{
						if (check(id ,row+i,column,true) == true)
							ShipPosition [row + i][column] = id ;
						else
						{
							DeleteShip(id);
							
							return false;
							
						}
						
					}
					
					return true;
				
				}
				else if (orientation == 'H')
				{
					for (int i = 0; i < ShipSize[id-1]; i++)
					{
						if (check(id ,row,column+i,true) == true)
							ShipPosition [row][column + i] = id ;
						else
						{
							DeleteShip(id);
							
							return false;
							
						}
						
					}
					
					return true;
				}
				else
				{
					System.out.println("only ('V') or ('H') is acceptable ");
				    continue;	
				}
				}
			}
		}
			
		
	}
	
	public void enterAllShipsManually()
	{
		for(int i = 0; i <5; i++)
		{
			while(enterShipManually(i + 1) == false)
			{
				
			}
		}
	}
	
	public boolean getStrike(int position[])
	{
		int row = position[0];
		int column = position[1];
		HitPosition[row][column] = true;
		int pos = ShipPosition[row][column];
		//System.out.print(pos + " " + row + " " + column);
		if (pos > 0)
		{
			HitShips[pos - 1] --;
			if (HitShips[pos - 1] == 0)
			{
				LastHit = true;
				System.out.println("The ship has sank");
			}
			else LastHit = false;
			return true;
		}
		return false;
	}
	
	public boolean allShipsSank()
	{
		
		for (int i=0; i < 5; i++)
		{
			if (HitShips[i] != 0) return false;
		}
		return true;
	}
	
	public boolean lastStrikeSankShip()
	{
		return LastHit;
	}
	
	public void printBoard()
	{
		for(int i = 0; i<10; i++)
		{
			for(int j = 0; j<10; j++) 
			{
				System.out.printf("%3d" , ShipPosition[i][j]);
			}
			System.out.println("\n");
		}
	
	}
	
	
	
	
	private boolean enterShipsRandomly(int id)
	{
		int row = -1;
		int column = -1;
			
		int orient = -1;

		
		
		
		while (true)
		{
			row = (int)(Math.random() * 10);
			column = (int)(Math.random() * 10);
			
			
			if (check(id ,row,column,false) == true)
			{	
				orient = (int)(Math.random() * 2);
				
				char orientation;
				if (orient == 0) orientation = 'H';
				else orientation = 'V';
				
				if (orientation == 'V')
				{
					for (int i = 0; i < ShipSize[id-1]; i++)
					{
						if (check(id ,row+i,column,false) == true)
							ShipPosition [row + i][column] = id ;
						else
						{
							DeleteShip(id);
							return false;
							
						}
						
					}
					return true;
				
				}
				else if (orientation == 'H')
				{
					for (int i = 0; i < ShipSize[id-1]; i++)
					{
						if (check(id ,row,column+i,false) == true)
							ShipPosition [row][column + i] = id ;
						else
						{
							DeleteShip(id);
							return false;
							
						}
						
					}
					return true;
				}
				
			}
		}
		
		
		
	}
	
	public void enterAllShipsRandomly()
	{
		for(int i = 0; i <5; i++)
		{
			while(enterShipsRandomly(i + 1) == false)
			{
				
			}
		}
	}
	
	
}
