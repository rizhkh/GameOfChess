package chessObjStuff;

import java.util.ArrayList;

public class ChessObjClass extends board {

static ArrayList<String> moveTracker = new ArrayList<String>();	
	
int rookcount = 2;
int knight = 2;
int queen = 1;
	
//when game is started this becomes 1
int start = 1;
String rook = "wR";
board b = new board();

public ChessObjClass()
{
	//board b = new board();
	b.initializePiece(rook);
	b.showBoard();
}

//When you have movements sorted make sure you put all pieces initialize in this 
//and call the method in constructor
public void beginningInitialize()
{
}



public void move()
{
	//This would get you the piece to move
	String a = b.getPiece();
	if(a.equals(wR) || a.equals("bR ")) 
	{
		int p=0;
		if(a.equals(wR))p=0;
		if(a.equals("bR "))p=1;
		moveForWRBR(p);

	}

}

public void moveForWRBR(int p)
{
	String abc = getCoordinates(); //You get a whole string of input e.g "a1 e5"
	//you get starting pos e.g in above example you get a1
	int indexI = intcordinatesfromString(abc,0);
	int indexJ = intcordinatesfromString(abc,1);
	//you get destination pos e.g in above example you get e5
	int indexIDest = intcordinatesfromString(abc,3);
	int indexJDest = intcordinatesfromString(abc,4);
	
	
	int i=0;
	int j=0;	
	int checkR = 0;
	
	
	//This moves it down
	if(checkR==0)
	for(i=indexI; i<8; i++)
	{
		for(j=indexJ; j<indexJ+1;j++)
		{
			if(i==indexIDest && j==indexJDest)
			{	
				checkR = 1;
				boards[i][j]=wR;
				boards[indexI][indexJ]="   ";
			}
		}
	} 

	//This moves it up
	if(checkR==0)
	for( i=indexI; i>=0; i--)
	{
		for( j=indexJ; j<indexJ+1;j++)
		{
			if(i==indexIDest && j==indexJDest)
			{	
				checkR = 1;
				boards[i][j]=wR;
				boards[indexI][indexJ]="   ";
			}
		}
	}
	
	//This moves it to right ->
	if(checkR==0)
	for( i=indexI; i<indexI+1; i++)
	{
		for( j=indexJ; j<=indexJDest;j++)		//for( j=indexJ; j<8;j++)
		{
			if(i==indexIDest && j==indexJDest)
			{	
				checkR = 1;
				boards[i][j]=wR;
				boards[indexI][indexJ]="   ";
			}		
		}
	}
	
	//This moves it to left <-
	if(checkR==0)
	for(i=indexI; i<indexI+1; i++)
	{
		for(j=indexJ; j>=indexJDest ;j--) //		for(j=indexJ; j>=0;j--)
		{
			if(i==indexIDest && j==indexJDest)
			{	
				checkR = 1;
				boards[i][j]=wR;
				boards[indexI][indexJ]="   ";
			}
		}
	}
	
	//Make this a new method - it checks for black spots and paints them back
	if(checkR==1)if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
	
	if(checkR==0) System.out.println("Illegal move try again!");	
}
	
}
