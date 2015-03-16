package judge;

import java.util.Scanner;

public class _03_FireTheArrows {
	static int hasNext;
	static boolean movement = false;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int size = Integer.parseInt(input.nextLine());
		char[][] chArray = new char[size][];
		for(int cnt = 0; cnt < size; cnt++)
		{
			chArray[cnt] = input.nextLine().toCharArray();
		}
		
		while(true)
		{
			hasNext = 0;
			for(int row = 0; row < size; row++){	
				for(int col = 0; col < chArray[0].length; col++){
					if(chArray[row][col] != 'o'){
						chArray = shootArrow(chArray, row, col);
					}
				}	
			}
			
			if(hasNext == 0)
			{
				if(!movement)
				{
					break;
				}
				movement = false;
			}
		}
		
		//visualize
		for(int cnt = 0; cnt < size; cnt++)
		{
			for(char x: chArray[cnt])
			{
				System.out.print(x);
			}
			System.out.println();
		}
	}

	private static char[][] shootArrow(char[][] chArray, int row, int col) {
		char direction = chArray[row][col];
			//UP
			if(direction == '^' && row > 0 && chArray[row - 1][col] == 'o'){
					chArray[row - 1][col] = direction;
					chArray[row][col] = 'o';
					row--;
					movement = true;
					if(row > 0 && chArray[row - 1][col] == 'o')	{
						hasNext++;
					}
			}
			//Down
			if(direction == 'v' && row < chArray.length - 1 && chArray[row + 1][col] == 'o'){
					chArray[row + 1][col] = direction;
					chArray[row][col] = 'o';
					row++;
					movement = true;
					if(row < chArray.length - 1 && chArray[row + 1][col] == 'o'){
						hasNext++;
					}
			}
			//Left
			if(direction == '<' && col > 0 && chArray[row][col - 1] == 'o'){
					chArray[row][col - 1] = direction;
					chArray[row][col] = 'o';
					col--;
					movement = true;
					if(col > 0 && chArray[row][col - 1] == 'o')	{
						hasNext++;
					}
			}
			//right
			if(direction == '>' && col < chArray[row].length - 1 && chArray[row][col + 1] == 'o'){
					chArray[row][col + 1] = direction;
					chArray[row][col] = 'o';
					col++;
					movement = true;
					if(col < chArray[row].length - 1 && chArray[row][col + 1] == 'o'){
						hasNext++;
					}
			}		
		return chArray;
	}
}