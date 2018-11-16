//Terrence Light
//COP 3503 University of Central Florida

import java.io.*;
import java.lang.*;

public class RunLikeHell
{
	public static void main(String[] args)
	{
	
	}
	
	public static int maxGain(int[] blocks)
	{
		//Call the DP solution
		return maxGainDP(blocks);
	}

	public static double difficultyRating()
	{
		return 3.0;
	}
	
	public static double hoursSpent()
	{
		return 8.0;
	}
	
	//Dynamic Programming solution utilizing only a 1-dimensional array of equal length to the length of the blocks array
	public static int maxGainDP(int[] blocks)
	{
		int[] maxGain = new int[blocks.length];
		
		//The first slot in the array is the same as blocks
		//The second of the max of the first two slots in the blocks array
		//After that, you are looking at the max of the slot before, or the blocks[i] + maxGain[i-2]
		//This works because you will never do a jump larger than 2 spaces to obtain the largest gains
		//So you only need to look back at most 2 slots
		for(int i = 0; i < blocks.length; i++)
		{
			if(i == 0)
				maxGain[0] = blocks[0];
			
			else if(i == 1)
				maxGain[1] = Math.max(blocks[0], blocks[1]);
			
			else maxGain[i] = Math.max((blocks[i] + maxGain[i-2]),
								maxGain[i-1]);
		}
		
		//Answer is stored at the end of the array
		return maxGain[blocks.length-1];
	}
	
}


