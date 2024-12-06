//Dimitrios Gazos A.M. 4035
package dim;

import java.util.Scanner;




public class Battleship 
{
	private void HumanVsHuman(String Player1, String Player2)
	{
		HumanPlayer Play1 = new HumanPlayer(Player1);
		HumanPlayer Play2 = new HumanPlayer(Player2);
		int pos1[] = new int[2];
		while(true)
		{
			System.out.println("-------------------------------");
			System.out.println("PLAYER " + Play1.toString());
			Play1.PlayerStrikeBoard.printBoard();
			System.out.println("===============================");
			Play1.PlayerShipBoard.printBoard();
			pos1 = Play1.nextStrike();
			
			//System.out.println(pos1[0] + " " + pos1[1]);
			
			boolean Hit = Play2.getStrike(pos1);
			Play1.update(pos1, Hit);
			if (Hit == true)
				System.out.println("HIT ");
			else
				System.out.println("MISS");
			Play2.lastStrikeSankShip();
				
			if (Play2.allShipsSank() == true)
			{
				System.out.println(Play1.toString() + " IS THE WINNER !!!!");
				break;
			}
			
			System.out.println("-------------------------------");
			System.out.println("PLAYER " + Play2.toString());
			Play2.PlayerStrikeBoard.printBoard();
			System.out.println("===============================");
			Play2.PlayerShipBoard.printBoard();
			pos1 = Play2.nextStrike();
			
			//System.out.println(pos1[0] + " " + pos1[1]);
			
			Hit = Play1.getStrike(pos1);
			Play2.update(pos1, Hit);
			if (Hit == true)
				System.out.println("HIT");
			else
				System.out.println("MISS");
			Play1.lastStrikeSankShip();
			if (Play1.allShipsSank() == true)
			{
				System.out.println(Play2.toString() + " IS THE WINNER !!!!");
				break;
			}
		}
	}
	
	private void HumanVsComputer(String Player1)
	{
		HumanPlayer Play1 = new HumanPlayer(Player1);
		ComputerPlayer Play2 = new ComputerPlayer();
		int pos1[] = new int[2];
		while(true)
		{
			System.out.println("-------------------------------");
			System.out.println("PLAYER " + Play1.toString());
			Play1.PlayerStrikeBoard.printBoard();
			System.out.println("===============================");
			Play1.PlayerShipBoard.printBoard();
			pos1 = Play1.nextStrike();
			
			//System.out.println(pos1[0] + " " + pos1[1]);
			
			boolean Hit = Play2.getStrike(pos1);
			Play1.update(pos1, Hit); 
			
			if (Hit == true)
				System.out.println("HIT ");
			else
				System.out.println("MISS");
			if (Play2.lastStrikeSankShip() == true)
			{
				//Play2.StrategyGame.completeExploration();
			}
				
			if (Play2.allShipsSank() == true)
			{
				System.out.println(Play1.toString() + " IS THE WINNER !!!!");
				break;
			}
			
			System.out.println("-------------------------------");
			System.out.println("PLAYER " + Play2.toString());
			//Play2.PlayerStrikeBoard.printBoard();
			//System.out.println("===============================");
			//Play2.PlayerShipBoard.printBoard();
			pos1 = Play2.nextStrike();
			
			//System.out.println(pos1[0] + " " + pos1[1]);
			
			Hit = Play1.getStrike(pos1);
			Play2.update(pos1, Hit);
			if (Hit == true)
				System.out.println("HIT");
			else
				System.out.println("MISS");
			//Play1.lastStrikeSankShip();
			if (Play1.lastStrikeSankShip() == true)
			{
				Play2.StrategyGame.completeExploration();
			}
			if (Play1.allShipsSank() == true)
			{
				System.out.println(Play2.toString() + " IS THE WINNER !!!!");
				break;
			}
		}
	}
	
	
	
	
	public static void main(String args[])
	{
		
		System.out.println("BATTLESHIP");
		System.out.println("Select the numbers of players. (1) for 1 player , (2) for 2 players game");
		
		Scanner input = new Scanner(System.in);
		
		
		String choice = "y";
	    while (choice.equalsIgnoreCase("y"))
	    {
		   while(true)
		   {					
			   char type = input.next().charAt(0);
			   //String choice=input.nextLine();
						
			   if (type == '2')
			   {
				   Battleship Human2Human = new Battleship();
				   Human2Human.HumanVsHuman("spy" , "dim");
				   break;
			   }
			   if (type == '1')
			   {
				   Battleship Human2Computer = new Battleship();
				   Human2Computer.HumanVsComputer("dim");
				   break;
			   }
			   else
			   {
				    System.out.println("invalid input");
			   }
					
		    }
		   
		    System.out.print("Continue? (y/n): ");
	        choice = input.nextLine();
	        System.out.println();
		
	    }
	    //input.close();
		
		
	}
	
	
	
	/*
	public static void main(String args[])
	{
		System.out.println("battleship");
		ShipBoard MyBattle = new ShipBoard();
		MyBattle.enterAllShipsManually();
		MyBattle.printBoard();
		
	}
	*/

}