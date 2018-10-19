package chessObjStuff;

public class board {

String[][] board = new String[9][9];	

public board()
{
	for(int i=0; i<9; i++)
	{
		for(int j=0;j<9;j++)
		{
			board[i][j] = "";
		}
	}	
	
	
	for(int i=0; i<8; i++)
	{
		for(int j=0;j<8;j++)
		{
			board[i][j] = "  |";
		}
	}		
	
	//SHOWS NUMBER ON BOARD
	int c = 8;
	for(int i=0; i<8; i++)
	{
		for(int j=8;j<9;j++)
		{
			board[i][j] =" " + Integer.toString(c);
			c--;
		}
	}	
	
	//SHOWS ALPHABETS ON BOARD
	for(int i=8; i<9; i++)
	{
		for(int j=0;j<9;j++)
		{
			switch(j) {
			case 0:
				board[i][j] ="a |";
				break;
			case 1:
				board[i][j] ="b |";
				break;
			case 2:
				board[i][j] ="c |";			
				break;
			case 3:
				board[i][j] ="d |";
				break;
			case 4:
				board[i][j] ="e |";			
				break;
			case 5:
				board[i][j] ="f |";			
				break;
			case 6:
				board[i][j] ="g |";			
				break;
			case 7:
				board[i][j] ="h |";			
				break;
			default:;
			}
			
		}
	}

	
	setBlackSpots();	
	 showBoard();

}





public void setBlackSpots()
{
	for(int i=0; i<8; i++)
	{
		if(i%2==0)
		{
			for(int j=1;j<8;j=j+2)
			{
				board[i][j] = "##|";
			}			
		}
		
		if(i%2!=0)
		{
			for(int j=0;j<8;j=j+2)
			{
				board[i][j] = "##|";
			}			
		}		
			
	}	
}


public void showBoard()
{
	for(int i=0; i<9; i++)
	{
		for(int j=0;j<9;j++)
		{
			System.out.print( board[i][j]);
		}
		System.out.println();
	}	
}
	
}
