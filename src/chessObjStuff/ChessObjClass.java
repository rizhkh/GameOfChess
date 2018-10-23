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
	 
	moveTracker.add("71"); // wN
	moveTracker.add("76"); //wN 
	//moveTracker.add("72");
	moveTracker.add("73"); // wQ queen
	moveTracker.add("72");// wB
	
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

	if(a.equals(wN) || a.equals("bN ")) 
	{
		int p=0;
		if(a.equals(wN))p=0;
		
		if(a.equals("bN "))p=1;
		moveForwNbN(p);
	}	

	if(a.equals(wQ) || a.equals("bQ ")) 
	{
		int p=0;
		if(a.equals(wQ))p=0;
		
		if(a.equals("bN "))p=1;
		moveForWQBQ(p); 
	}	
	
	if(a.equals(wB) || a.equals("bB ")) 
	{
		int p=0;
		if(a.equals(wB))p=0;
		
		if(a.equals("bB "))p=1;
		
		moveForwBbB(p); 
	}		
	
}

//Moves for Knight
public void moveForwNbN(int p)
{
	String PP="";
	/*
	if(p==0)PP = wN;
	if(p==1)PP = "bN ";
	
	*REPLACE ALL wN WITH PP 
	*/
	
	String abc = getCoordinates();
	int indexI = intcordinatesfromString(abc,0);int indexJ = intcordinatesfromString(abc,1);
	//you get destination pos e.g in above example you get e5
	int indexIDest = intcordinatesfromString(abc,3);int indexJDest = intcordinatesfromString(abc,4);	

	int i=0;int j=0;int checkN = 0;String al1 = "";String al2 = "";	
	int stepsUD=0;
	int stepsLR=0;int cc = 0;
	
	//moves to the left 
	if(indexJDest<indexJ)
	{
		//up and left index i is being manipulated here	
		if(indexI>indexIDest && indexI-2==indexIDest)
		for( i=indexI; i>=indexIDest; i--)
		{
			if(cc==0)stepsUD++;	
			for( j=indexJDest; j>=indexJDest;j--)		//for( j=indexJ; j<8;j++)
			{
				if(cc==0)stepsLR++;	al1 = Integer.toString(indexIDest);	al2 = Integer.toString(indexJDest);	String c = al1 + al2;
				if( moveTracker.contains(c) ){checkN=0;break;}
					
				if( (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;setPiecesAgain(i,j,wN,indexI,indexJ);
				}
			}			
			if(stepsUD!=1 && stepsLR!=3)checkN=0;	
		}
		////
		//moves down and left index i is being manipulated here	
		if(indexI<indexIDest && indexI+2==indexIDest) // U
		for( i=indexI; i<=indexIDest; i++)
		{
			if(cc==0)stepsUD++;	
			for( j=indexJDest; j>=indexJDest;j--)		//for( j=indexJ; j<8;j++)
			{
				if(cc==0)stepsLR++;al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
				if( moveTracker.contains(c) ){checkN=0;break;}
					
				if( (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);
				}
			}			
			if(stepsUD!=1 && stepsLR!=3)checkN=0;	
		}
		////

		
		
		if(indexI>indexIDest && indexI-1==indexIDest) // UP
		for( i=indexIDest; i>=indexIDest; i--)
		{
			for( j=indexJ; j>=indexJDest;j--)		//for( j=indexJ; j<8;j++)
			{
				if(cc==0)stepsLR++;	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
				if( moveTracker.contains(c) ){checkN=0;break;}
				
				if( (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==0))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);
				}
			}
			if(cc==0)stepsUD++;	
			if(stepsUD!=1 && stepsLR!=3)checkN=0;	
		}

		if(indexI<indexIDest && indexI+1==indexIDest) // down
			for( i=indexIDest; i>=indexIDest; i--)
			{
				for( j=indexJ; j>=indexJDest;j--)		//for( j=indexJ; j<8;j++)
				{
					if(cc==0)stepsLR++;	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) ){checkN=0;break;}
					
					if( (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==0))
					{	
						cc=1;checkN = 1;
						setPiecesAgain(i,j,wN,indexI,indexJ);
					}
				}
				if(cc==0)stepsUD++;if(stepsUD!=1 && stepsLR!=3)checkN=0;	
			}
	}
	
	//Moves to the right 
	if(indexJDest>indexJ)
	{	
		//moves down and rigt index i is being manipulated here	
		if(indexI<indexIDest && indexI+2==indexIDest) // U
		for( i=indexI; i<=indexIDest; i++)
		{
			if(cc==0)stepsUD++;	
			for( j=indexJDest; j<=indexJDest;j++)		//for( j=indexJ; j<8;j++)
			{
				if(cc==0)stepsLR++;	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
				if( moveTracker.contains(c) ){checkN=0;break;}
					
				if( (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);
				}
			}			
			if(stepsUD!=1 && stepsLR!=3)checkN=0;	
		}
		////		
		
		//moves to the up and rigt index i is being manipulated here	
		if(indexI>indexIDest && indexI-2==indexIDest) // U
		for( i=indexI; i>=indexIDest; i--)
		{
			if(cc==0)stepsUD++;	
			for( j=indexJDest; j<=indexJDest;j++)		//for( j=indexJ; j<8;j++)
			{
				if(cc==0)stepsLR++;al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
				if( moveTracker.contains(c) ){checkN=0;break;}
					
				if( (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);	
				}
			}			
			if(stepsUD!=1 && stepsLR!=3)checkN=0;	
		}
		////		
		
		if(indexI>indexIDest && indexI-1==indexIDest) // UP
		for( i=indexIDest; i>=indexIDest; i--)
		{
			for( j=indexJ; j<=indexJDest;j++)		//for( j=indexJ; j<8;j++)
			{
				if(cc==0)stepsLR++;	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
				if( moveTracker.contains(c) ){checkN=0;break;}
				
				if( (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==0))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);
				}
			}
			if(cc==0)stepsUD++;if(stepsUD!=1 && stepsLR!=3)checkN=0;	
		}

		if(indexI<indexIDest && indexI+1==indexIDest) // down
			for( i=indexIDest; i>=indexIDest; i--)
			{
				for( j=indexJ; j<=indexJDest;j++)		//for( j=indexJ; j<8;j++)
				{
					if(cc==0)stepsLR++;al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) ){checkN=0;break;}
					
					if( (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==0))
					{	
						cc=1;checkN = 1;
						setPiecesAgain(i,j,wN,indexI,indexJ);						
					}
				}
				if(cc==0)stepsUD++;
				if(stepsUD!=1 && stepsLR!=3)checkN=0;	
			}
	}	
	//////////////////////////////// 

	if(checkN==0) { System.out.println("Illegal move try again!");	}
	if(checkN==1)
	{ 
			//REMOVE (indexI,IndexJ) from Arraylist
			String g1 = Integer.toString(indexI);
			String g2 = Integer.toString(indexJ);		
			String g = g1+g2;
			if( moveTracker.contains(g) )moveTracker.remove(g);
			if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
			System.out.println(moveTracker);
	}	
}




//////////////////////////
public int moveForwBbB(int p)
{
	int ret = 5;
	String abc = getCoordinates(); //You get a whole string of input e.g "a1 e5"
	//you get starting pos e.g in above example you get a1
	int indexI = intcordinatesfromString(abc,0);
	int indexJ = intcordinatesfromString(abc,1);
	//you get destination pos e.g in above example you get e5
	int indexIDest = intcordinatesfromString(abc,3);
	int indexJDest = intcordinatesfromString(abc,4);
	
	int i=0;
	int j=0;	
	int checkB = 0;
	String al1 = "";String al2 = "";
	
	if(p==0 || p==3)
	{
			//moves upper left diagonal
			if(indexJDest<indexJ && indexI>indexIDest)
			{
				int d=indexJ;
				for( i=indexI; i>=indexIDest; i--)
				{
						al1 = Integer.toString(indexIDest); 
						al2 = Integer.toString(indexJDest);
						String c = al1 + al2;
						if( moveTracker.contains(c) )
						{
							System.out.println("contains");
							checkB=0;break;
						}
						
						if( (i==indexIDest && d==indexJDest) && !moveTracker.contains(c))
						{ 
							checkB = 1;
							if(p==0)setPiecesAgain(i,d,wB,indexI,indexJ);
							if(p==3)setPiecesAgain(i,d,wQ,indexI,indexJ);
						}
					d--;
				}				
			}
			
			//upper andright movements
			if(indexJDest>indexJ && indexI>indexIDest)
			{
				int d=indexJ;
				for( i=indexI; i>=indexIDest; i--)
				{
						al1 = Integer.toString(indexIDest);
						al2 = Integer.toString(indexJDest);
						String c = al1 + al2;
						if( moveTracker.contains(c) )
						{
							checkB=0;break;
						}
						
						if( (i==indexIDest && d==indexJDest) && !moveTracker.contains(c))
						{	
							checkB = 1;
							if(p==0)setPiecesAgain(i,d,wB,indexI,indexJ);
							if(p==3)setPiecesAgain(i,d,wQ,indexI,indexJ);				
						}
					d++;
				}					
			}
			
			//This moves down and left
			if(indexJDest<indexJ && indexI<indexIDest)
			{
				int d = indexJ ;
				for( i=indexI; i<=indexIDest; i++)
				{
						al1 = Integer.toString(indexIDest); 
						al2 = Integer.toString(indexJDest);
						String c = al1 + al2;
						if( moveTracker.contains(c) )
						{checkB=0;break;}
						
						if( (i==indexIDest && d==indexJDest) && !moveTracker.contains(c))
						{	
							checkB = 1;
							if(p==0)setPiecesAgain(i,d,wB,indexI,indexJ);
							if(p==3)setPiecesAgain(i,d,wQ,indexI,indexJ);					
						}
						d--;
				}				
			}

			//This moves down and right
			if(indexJDest>indexJ && indexI<indexIDest)
			{
				int d = indexJ;
				for( i=indexI; i<=indexIDest; i++)
				{
						al1 = Integer.toString(indexIDest); 
						al2 = Integer.toString(indexJDest);
						String c = al1 + al2;
						if( moveTracker.contains(c) )
						{checkB=0;break;}
						
						if( (i==indexIDest && d==indexJDest) && !moveTracker.contains(c))
						{	
							checkB = 1;
							if(p==0)setPiecesAgain(i,d,wB,indexI,indexJ);
							if(p==3)setPiecesAgain(i,d,wQ,indexI,indexJ);					
						}
						d++;
				}				
			}			
			
		}		
	//}
	
	if(checkB==0) 
	{
		if(p==0)System.out.println("Illegal move try again!"); 
		if(p==3)ret = 6;	
	}
	if(checkB==1)
	{ 
			//REMOVE (indexI,IndexJ) from Arraylist
			String g1 = Integer.toString(indexI);
			String g2 = Integer.toString(indexJ);		
			String g = g1+g2;
			if( moveTracker.contains(g) )moveTracker.remove(g);
			if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
			System.out.println(moveTracker);
	}		
	
	return ret;
}
///////////////////

//Method to move Queen and checks legal moves
public void moveForWQBQ(int p)
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
	int checkQ = 0;
	String al1 = "";String al2 = "";
	
	if(p==0) 
	{
		//This moves upper left or diagonl
		/*
		
		if(indexJ<indexJDest)
		{
			if(indexIDest<indexI)
			{
				
			}
			
			if(indexIDest>indexI)
			{
				
			}
			
		}
		*/
		// if diagonal moves give you illegal message then this method will run
		
		checkQ = moveForwBbB(3);
		System.out.println("return from wbbb: " + checkQ);
		if(checkQ==6) {checkQ=moveForWRBR(3);} // This only takes care of front back left right movements
		System.out.println("return from WRBR: " + checkQ);
	}
	
	if(checkQ==6) {System.out.println("Illegal");}
	
} 

public int moveForWRBR(int p)
{
	int ret = 5;
	//**************************NOTE : ADD CASTLING	
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
	String al1 = "";String al2 = "";
	
	//NOTE: PUT AN IF STATEMENT WHERE P IS EITHER 0 OR 1
	// P==1 IS WHITE
	
	//For black
	if(p==1) {}
	
	//For White
	if(p==0 || p==3)
	{
		//This checks if I's are same then you're checking movements for Left  and Right
		if(indexI==indexIDest)
		{
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
						if( moveTracker.contains(c) && j!=q )
							{checkR=3;break;}
						
						if(i==indexIDest && j==indexJDest && !moveTracker.contains(c))
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
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
						if( moveTracker.contains(c) && j!=q )
						{checkR=3;break;}
						
						if(i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
						}
					}
				}			
		}	

		//This checks if J's are same then you're checking movements for up and down		
		if(indexJ==indexJDest)
		{
			int pr = indexI;
			int q = indexJ;
			if(checkR==0)
				for(i=indexI; i<=indexIDest; i++)
				{
					for(j=indexJ; j<indexJ+1;j++)
					{
						al1 = Integer.toString(i);
						al2 = Integer.toString(j);
						String c = al1 + al2;
						if( moveTracker.contains(c) && i!=pr )
						{checkR=3; j=100+j;i=100+1;break;}					
						if(i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
						}
					}
				} 

				//This moves it up
				if(checkR==0)
				for( i=indexI; i>=indexIDest; i--)
				{
					for( j=indexJ; j<indexJ+1;j++)
					{
						al1 = Integer.toString(i);
						al2 = Integer.toString(j);
						String c = al1 + al2;
						if( moveTracker.contains(c) && i!=pr )
						{checkR=3; j=100+j;i=-5;break;}						
						if(i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
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
	
	if(checkR==0 || checkR==3)
		{
		if(p==0)System.out.println("Illegal move try again!"); 
		if(p==3)ret = 6;			
		}
	return ret;
}

//This method sets the new piece on the board,clears it and adds piece to arraylist
public void setPiecesAgain(int i,int j,String piece,int indexII,int indexJJ)
{
	String io = Integer.toString(i);
	String jo = Integer.toString(j);
	boards[i][j]=piece;
	moveTracker.add(io + jo);
	boards[indexII][indexJJ]="   ";
}

}
