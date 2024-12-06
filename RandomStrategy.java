//Dimitrios Gazos A.M. 4035
package dim;

import java.util.ArrayList;
import java.util.Collections;



class RandomStrategy
{
	private ArrayList<String> RandomNumbers = new ArrayList<String>();
	private String number;
	
	
	public RandomStrategy()
	{
		for(int i = 0; i<10; i++)
		{
			for(int j = 0; j<10; j++) 
			{
				String s1 = String.format("%d" , i);
				String s2 = String.format("%d" , j);
				number = s1 + s2;
				RandomNumbers.add(number);
				Collections.shuffle(RandomNumbers);
			}
			
		}
		//System.out.println(RandomNumbers);
	}
	
	public int[] nextStrike()
	{
		int pos[] = new int[2];
		
		number = RandomNumbers.get(0);
		//System.out.println(number);
		int row = Character.getNumericValue(number.charAt(0));
		int column = Character.getNumericValue(number.charAt(1));
		
		pos[0] = row;
		pos[1] = column; 
		return pos;
		
	}
	
	public void delItem(String item)
	{
		RandomNumbers.remove(item);
	}
	
	public void update()
	{
		RandomNumbers.remove(0);
	}
	
	
	
}

