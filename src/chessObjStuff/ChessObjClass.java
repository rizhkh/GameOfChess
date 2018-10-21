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
	moveTracker.add("70"); //wR
	moveTracker.add("77"); //wR starting pos in AL
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

public void legalMoveWRBR()
{
	
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
	int counterwr = 0;
	
	//NOTE: PUT AN IF STATEMENT WHERE P IS EITHER 0 OR 1
	// P==1 IS WHITE
	
	//For black
	if(p==1) {}
	
	//For White
	if(p==0)
	{
		//This checks if I's are same then you're checking movements for Left  and Right

		if(indexI==indexIDest)
		{
			
			String al1 = "";
			String al2 = "";
			int pr = indexI;
			int q = indexJ;
			
			//This moves it to right ->
			if(checkR==0)
				for( i=indexI; i<indexI+1; i++)
				{
					for( j=indexJ; j<=indexJDest;j++)		//for( j=indexJ; j<8;j++)
					{
						al1 = Integer.toString(i);
						al2 = Integer.toString(j);
						String c = al1 + al2;
						//System.out.println(i + "," + j + "- " + pr + " " + q);
						//This part checks arraylist for positions and then determines if its legal move or not
						if( moveTracker.contains(c) && j!=q )// && (i!=pr && j!=q) )
							{//(i!=pr && j!=q) // Only J==Q becuase  we know I is equal
								System.out.println("Illegal!");
								checkR=0;break;
							}
						
						if(i==indexIDest && j==indexJDest && !moveTracker.contains(c))
						{	
							checkR = 1;
							String io = Integer.toString(i);
							String jo = Integer.toString(j);
							boards[i][j]=wR;
							moveTracker.add(io + jo);
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
						al1 = Integer.toString(i);
						al2 = Integer.toString(j);
						String c = al1 + al2;
						//System.out.println(i + "," + j + "- " + pr + " " + q);
						
						if( moveTracker.contains(c) && j!=q )// && (i!=pr && j!=q) )
							{//(i!=pr && j!=q) // Only J==Q becuase  we know I is equal
								System.out.println("Illegal!");
								checkR=0;break;
							}						
						if(i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							String io = Integer.toString(i);
							String jo = Integer.toString(j);
							boards[i][j]=wR;
							moveTracker.add(io + jo);
							boards[indexI][indexJ]="   ";
						}
					}
				}			
		}	

		//This checks if J's are same then you're checking movements for up and down		
		if(indexJ==indexJDest)
		{
			if(checkR==0)
				for(i=indexI; i<=indexIDest; i++)
				{
					for(j=indexJ; j<indexJ+1;j++)
					{
						if(i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							String io = Integer.toString(i);
							String jo = Integer.toString(j);
							boards[i][j]=wR;
							moveTracker.add(io + jo);
							boards[indexI][indexJ]="   ";
						}
					}
				} 

				//This moves it up
				if(checkR==0)
				for( i=indexI; i>=indexIDest; i--)
				{
					for( j=indexJ; j<indexJ+1;j++)
					{
						if(i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							String io = Integer.toString(i);
							String jo = Integer.toString(j);
							boards[i][j]=wR;
							moveTracker.add(io + jo);
							boards[indexI][indexJ]="   ";
						}
					}
				}				
		}
	}
		
		//Make this a new method - it checks for black spots and paints them back
	if(checkR==1)
		{
			//REMOVE (indexI,IndexJ) from Arraylist
		String g1 = Integer.toString(indexI);
		String g2 = Integer.toString(indexJ);		
		String g = g1+g2;
			if( moveTracker.contains(g) )moveTracker.remove(g);
			if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
			System.out.println(moveTracker);
		}
	if(checkR==0) System.out.println("Illegal move try again!");				
}
	
}
