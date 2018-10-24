package chessObjStuff;

import java.util.ArrayList;

public class ChessObjClass extends board {

static ArrayList<String> moveTracker = new ArrayList<String>();	
static ArrayList<String> moveTrackerBlack = new ArrayList<String>();	


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
	//WHITE PIECES
	moveTracker.add("70"); //wR
	moveTracker.add("71"); // wN
	moveTracker.add("72");// wB
	moveTracker.add("73"); // wQ queen
	moveTracker.add("74");// wK
	moveTracker.add("75");// wB
	moveTracker.add("76"); //wN 
	moveTracker.add("77"); //wR starting pos in AL
	 
	moveTracker.add("60");// wp0
	moveTracker.add("61");// wp1	
	moveTracker.add("62");// wp2
	moveTracker.add("63");// wp3
	moveTracker.add("64");// wp4	
	moveTracker.add("65");// wp5
	moveTracker.add("66");// wp6
	moveTracker.add("67");// wp7	

	//BLACK PIECES
	moveTrackerBlack.add("00"); //bR
	moveTrackerBlack.add("01"); // bN
	moveTrackerBlack.add("02");// bB
	moveTrackerBlack.add("03"); // bQ queen
	moveTrackerBlack.add("04");// bK
	moveTrackerBlack.add("05");// bB
	moveTrackerBlack.add("06"); //bN 
	moveTrackerBlack.add("07"); //bR starting pos in AL
	 
	moveTrackerBlack.add("10");// bp0
	moveTrackerBlack.add("11");// bp1	
	moveTrackerBlack.add("12");// bp2
	moveTrackerBlack.add("13");// bp3
	moveTrackerBlack.add("14");// bp4	
	moveTrackerBlack.add("15");// bp5
	moveTrackerBlack.add("16");// bp5
	moveTrackerBlack.add("17");// bp7	
	
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
	if(a.equals(wR) || a.equals(bR)) 
	{
		int p=0;
		if(a.equals(wR))p=0;
		if(a.equals(bR))p=1;
		moveForWRBR(p);
	}

	if(a.equals(wN) || a.equals(bN)) 
	{
		int p=0;
		if(a.equals(wN))p=0;
		
		if(a.equals(bN))p=1;
		moveForwNbN(p);
	}	

	if(a.equals(wQ) || a.equals(bQ)) 
	{
		int p=0;
		if(a.equals(wQ))p=0;
		
		if(a.equals(bQ))p=1;
		moveForWQBQ(p); 
	}
	
	if(a.equals(wK) || a.equals(bK)) 
	{
		int p=0;
		if(a.equals(wK))p=0;
		
		if(a.equals(bK))p=1;
		moveForwKbK(p); 
	}	
	
	if(a.equals(wB) || a.equals(bB))  
	{
		int p=0;
		if(a.equals(wB))p=0;
		
		if(a.equals(bB))p=1;
		moveForwBbB(p); 
	}
	
	if(a.equals(wP0) || a.equals(wP1) || a.equals(wP2) || a.equals(wP3) || a.equals(wP4) 
			|| a.equals(wP5) || a.equals(wP6) || a.equals(wP7)	
			|| a.equals(bP0) || a.equals(bP1) || a.equals(bP2) || a.equals(bP3) || a.equals(bP4) || a.equals(bP5)
			|| a.equals(bP6) || a.equals(bP7)
			) 
	{
		int p=0;
		if(a.equals(wP0) || a.equals(wP1) || a.equals(wP2) || a.equals(wP3) || a.equals(wP4) || a.equals(wP5) || a.equals(wP6) || a.equals(wP7) )p=0;
		
		if(a.equals(bP0) || a.equals(bP1) || a.equals(bP2) || a.equals(bP3) || a.equals(bP4) || a.equals(bP5) || a.equals(bP6) || a.equals(bP7) )p=1;
		
		moveForwPbP(p); 
	}	
	
}


public void moveForwKbK(int p)
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
	int checkQ = 6;
	String al1 = "";String al2 = "";
	
	if(p==0) 
	{
		if( indexIDest<indexI && indexIDest==indexI-1 )//This moves upward
		{
			if(indexJ==indexJDest || indexJ==indexJDest-1 || indexJ==indexJDest+1) //This checks up,up-left,up -right
			{
				if(p==0)
				{
					checkQ = moveForwBbB(4);
					if(checkQ==6)checkQ=moveForWRBR(4);						
				}
				
				if(p==1)
				{
					checkQ = moveForwBbB(9);
					if(checkQ==6)checkQ=moveForWRBR(9);					
				}
			}
		}

		if( indexIDest==indexI )//KINGS MOVE IS ONLY ON THE LEFT OR RIGHT
		{
			if(indexJ>indexJDest && indexJDest==indexJ-1) //This only moves left while staying in the same row
			{
				if(p==0)
				{
					checkQ = moveForwBbB(4);
					if(checkQ==6)checkQ=moveForWRBR(4);						
				}
				
				if(p==1)
				{
					checkQ = moveForwBbB(9);
					if(checkQ==6)checkQ=moveForWRBR(9);					
				}
			}
		
			if(indexJ<indexJDest && indexJDest==indexJ+1) //This only moves right while staying in the same row		
			{
				if(p==0)
				{
					checkQ = moveForwBbB(4);
					if(checkQ==6)checkQ=moveForWRBR(4);						
				}
				
				if(p==1)
				{
					checkQ = moveForwBbB(9);
					if(checkQ==6)checkQ=moveForWRBR(9);					
				}
			}				
		}		

		if( indexIDest>indexI && indexIDest==indexI+1 )		//This moves downward
		{
			if(indexJ==indexJDest || indexJ==indexJDest-1 || indexJ==indexJDest+1) 			//This checks down,down-left,down-right
			{
				if(p==0)
				{
					checkQ = moveForwBbB(4);
					if(checkQ==6)checkQ=moveForWRBR(4);						
				}
				
				if(p==1)
				{
					checkQ = moveForwBbB(9);
					if(checkQ==6)checkQ=moveForWRBR(9);					
				}
			}
		}	
	}
	
	if(checkQ==6) {System.out.println("Illegal move.");}	
} 


//NOTE: Only need to add overlapping moves now
public void moveForwPbP(int p)
{
	String abc = getCoordinates();
	int indexI = intcordinatesfromString(abc,0);
	int indexJ = intcordinatesfromString(abc,1);
	int indexIDest = intcordinatesfromString(abc,3);
	int indexJDest = intcordinatesfromString(abc,4);	

	chessPieceInfo wPP = new chessPieceInfo(); 
	
	String wpPiece = "";
	//This only works for the very first moves
	//ID'S FOR THE WHITE PAWNS
	if(p==0)
	{
		if(indexI==6 && indexJ==0)wpPiece = "60"; 
		if(indexI==6 && indexJ==1)wpPiece = "61"; 	
		if(indexI==6 && indexJ==2)wpPiece = "62"; 
		if(indexI==6 && indexJ==3)wpPiece = "63"; 
		if(indexI==6 && indexJ==4)wpPiece = "64"; 
		if(indexI==6 && indexJ==5)wpPiece = "65"; 
		if(indexI==6 && indexJ==6)wpPiece = "66"; 
		if(indexI==6 && indexJ==7)wpPiece = "67"; 
	}

	if(p==1)
	{
		if(indexI==1 && indexJ==0)wpPiece = "10"; 
		if(indexI==1 && indexJ==1)wpPiece = "11"; 	
		if(indexI==1 && indexJ==2)wpPiece = "12"; 
		if(indexI==1 && indexJ==3)wpPiece = "13"; 
		if(indexI==1 && indexJ==4)wpPiece = "14"; 
		if(indexI==1 && indexJ==5)wpPiece = "15"; 
		if(indexI==1 && indexJ==6)wpPiece = "16"; 
		if(indexI==1 && indexJ==7)wpPiece = "17"; 
	}

	char idI1 = abc.charAt(0);String idI = String.valueOf(idI1);
	char idJ1 = abc.charAt(1);String idJ = String.valueOf(idJ1);	

	//This will check the id
	wPP = getObject(wpPiece,idI,idJ);

	int i=0;int j=0;
	int checkP = 0;
	String al1 = "";String al2 = "";	

	int stepsP=0;
	int checkP2 = 0; 
	
	if(p==1)
	if(indexI<indexIDest) //&& indexIDest==indexI-1)
	{
		System.out.println( wPP.getID() );
		j = indexJ;
		
		if(indexI<indexIDest && indexIDest==indexI+2)
		{
			if(wPP.getFirstMove()==0)
			{
				for( i=indexI; i<=indexIDest; i++)
				{		
					al1 = Integer.toString(indexIDest);	
					al2 = Integer.toString(indexJDest);
					String al3 = ""  + Integer.toString(indexI+1);	
					String d = al3 + al2;
					String c = al1 + al2;

					if( p==1 && (moveTrackerBlack.contains(c) ||  moveTrackerBlack.contains(d))  )
					{
						checkP=0;
						break;
					}										

					if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && stepsP==2)
					{	
						checkP = 1;
						setPiecesAgainBlack(i,j,bP1,indexI,indexJ);
						wPP.setFirstMove(1);
						checkP2 = 1;
					}					
					
					stepsP++;
				}				
			}
			
			if(wPP.getFirstMove()!=0 && checkP2==0)checkP=0;		
		}
		//For black piece to move one step downwards
		if(indexI<indexIDest && indexIDest==indexI+1)
		for( i=indexI; i<=indexIDest; i++)
		{
			al1 = Integer.toString(indexIDest);	al2 = Integer.toString(indexJDest);	String c = al1 + al2;

			if( p==1 && moveTrackerBlack.contains(c) )
			{
				checkP=0;
				break;
			}			
			
			if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && stepsP==1)
			{	
				checkP = 1;
				setPiecesAgainBlack(i,j,bP1,indexI,indexJ);
				wPP.setFirstMove(1);
			}
			
			stepsP++;
		}			
	}	
	
	///////
	if(p==0)
	if(indexI>indexIDest) //&& indexIDest==indexI-1)
	{	
		//System.out.println( wPP.getID() );
		j = indexJ;
		
		//This is just for the first move 
		if(indexI>indexIDest && indexIDest==indexI-2)
		{
			if(wPP.getFirstMove()==0)
			{
				for( i=indexI; i>=indexIDest; i--)
				{		
					al1 = Integer.toString(indexIDest);	
					al2 = Integer.toString(indexJDest);
					String al3 = ""  + Integer.toString(indexI-1);	
					String d = al3 + al2;
					String c = al1 + al2;
					if( p==0 && (moveTracker.contains(c) ||  moveTracker.contains(d))  )
					{
						checkP=0;
						break;
					}				
					
					if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && stepsP==2)
					{	
						checkP = 1;
						setPiecesAgain(i,j,wP1,indexI,indexJ);
						wPP.setFirstMove(1);
						checkP2 = 1;
					}
					stepsP++;
				}				
			}
			
			if(wPP.getFirstMove()!=0 && checkP2==0)checkP=0;		
		}
		
		//This moves 1 step upward for white
		if(indexI>indexIDest && indexIDest==indexI-1)
		for( i=indexI; i>=indexIDest; i--)
		{
			al1 = Integer.toString(indexIDest);	al2 = Integer.toString(indexJDest);	String c = al1 + al2;
			if( p==0 && moveTracker.contains(c) )
			{
				checkP=0;
				break;
			}		
			
			if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && stepsP==1)
			{	
				checkP = 1;
				setPiecesAgain(i,j,wP1,indexI,indexJ);
				wPP.setFirstMove(1);
			}
			stepsP++;
		}			
	}
	
	if(checkP==0) { System.out.println("Illegal move try again!");	}
	if(checkP==1)
	{ 
			//REMOVE (indexI,IndexJ) from Arraylist
		//setting id if legal move PUT THIS IN THE CHECK IF THE MOVE IS LEGAL
			String aaaaa = "" + indexIDest + "" +indexJDest;
			int bbbbb = Integer.parseInt(aaaaa);	
			wPP.setID(bbbbb);		
			String g1 = Integer.toString(indexI);
			String g2 = Integer.toString(indexJ);		
			String g = g1+g2;
			if( (p==0) && moveTracker.contains(g) )moveTracker.remove(g);
			if( (p==1) && moveTrackerBlack.contains(g) )moveTrackerBlack.remove(g);				
			//if( moveTracker.contains(g) )moveTracker.remove(g);
			if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
			//if(p==0)System.out.println(moveTracker);
			//if(p==1)System.out.println(moveTrackerBlack);			
	}		
	
}



//Moves for Knight
public void moveForwNbN(int p)
{
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
				
				if( p==0 && moveTracker.contains(c) )
				{checkN=0;break;}

				if( p==1 && moveTrackerBlack.contains(c) )
				{checkN=0;break;}				
				
				if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;setPiecesAgain(i,j,wN,indexI,indexJ);
				}
				
				if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;setPiecesAgainBlack(i,j,bN,indexI,indexJ);
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
				
				if( p==0 && moveTracker.contains(c) ){checkN=0;break;}
				
				if( p==1 && moveTrackerBlack.contains(c) ){checkN=0;break;}
				
				if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);
				}
				
				if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;
					setPiecesAgainBlack(i,j,bN,indexI,indexJ);
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
				
				if( p==0 && moveTracker.contains(c) ){checkN=0;break;}
				
				if( p==1 && moveTrackerBlack.contains(c) ){checkN=0;break;}
				
				if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==0))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);
				}
				
				if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && (stepsLR==3 && stepsUD==0))
				{	
					cc=1;checkN = 1;
					setPiecesAgainBlack(i,j,bN,indexI,indexJ);
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
					if( p==0 &&  moveTracker.contains(c) ){checkN=0;break;}
					
					if( p==1 &&  moveTrackerBlack.contains(c) ){checkN=0;break;}
					
					if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==0))
					{	
						cc=1;checkN = 1;
						setPiecesAgain(i,j,wN,indexI,indexJ);
					}
					
					if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && (stepsLR==3 && stepsUD==0))
					{	
						cc=1;checkN = 1;
						setPiecesAgainBlack(i,j,bN,indexI,indexJ);
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
				
				if( p==0 && moveTracker.contains(c) ){checkN=0;break;}

				if( p==1 && moveTrackerBlack.contains(c) ){checkN=0;break;}
				
				if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);
				}
				
				if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;
					setPiecesAgainBlack(i,j,bN,indexI,indexJ);
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
				
				if( p==0 && moveTracker.contains(c) ){checkN=0;break;}
					
				if( p==1 && moveTrackerBlack.contains(c) ){checkN=0;break;}
				
				if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);	
				}
				
				if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && (stepsLR==3 && stepsUD==3))
				{	
					cc=1;checkN = 1;
					setPiecesAgainBlack(i,j,bN,indexI,indexJ);	
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
				
				if( p==0 && moveTracker.contains(c) ){checkN=0;break;}
				
				if( p==1 && moveTrackerBlack.contains(c) ){checkN=0;break;}
				
				if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==0))
				{	
					cc=1;checkN = 1;
					setPiecesAgain(i,j,wN,indexI,indexJ);
				}
				
				if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && (stepsLR==3 && stepsUD==0))
				{	
					cc=1;checkN = 1;
					setPiecesAgainBlack(i,j,bN,indexI,indexJ);
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
					if(p==0 && moveTracker.contains(c) ){checkN=0;break;}
					
					if(p==1 && moveTrackerBlack.contains(c) ){checkN=0;break;}
					
					if(p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && (stepsLR==3 && stepsUD==0))
					{	
						cc=1;checkN = 1;
						setPiecesAgain(i,j,wN,indexI,indexJ);						
					}
					
					if(p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && (stepsLR==3 && stepsUD==0))
					{	
						cc=1;checkN = 1;
						setPiecesAgainBlack(i,j,bN,indexI,indexJ);						
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
			if( p==0 && moveTracker.contains(g) )moveTracker.remove(g);
			if( p==1 && moveTrackerBlack.contains(g) )moveTrackerBlack.remove(g);
			if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
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
	
	//if(p==0 || p==3 || p==4)
	//{
			//moves upper left diagonal
			if(indexJDest<indexJ && indexI>indexIDest)
			{
				int d=indexJ;
				for( i=indexI; i>=indexIDest; i--)
				{
						al1 = Integer.toString(indexIDest); 
						al2 = Integer.toString(indexJDest);
						String al3 ="";
						String al4 = "";
						if(i!=indexI) {al3 = Integer.toString(i);}
						if(j!=indexJ) {al4 = Integer.toString(d);}
						String e = al3 + al4;
						
						String c = al1 + al2;
						
						if( (p==0 || p==3 || p==4) && (moveTracker.contains(c) || moveTracker.contains(e)) )
						{
							checkB=0;break;
						}
						
						if( (p==1 || p==8 || p==9) && (moveTrackerBlack.contains(c) || moveTrackerBlack.contains(e)) )
						{
							System.out.println("BLACK contains");
							checkB=0;break;
						}						
						
						if( (p==0 || p==3 || p==4) && (i==indexIDest && d==indexJDest) && !moveTracker.contains(c))
						{ 
							checkB = 1;
							if(p==0)setPiecesAgain(i,d,wB,indexI,indexJ);
							if(p==3)setPiecesAgain(i,d,wQ,indexI,indexJ);
							if(p==4)setPiecesAgain(i,d,wK,indexI,indexJ);							
						}
						
						if( (p==1 || p==8 || p==8) && (i==indexIDest && d==indexJDest) && !moveTrackerBlack.contains(c))
						{ 
							checkB = 1;
							if(p==1)setPiecesAgainBlack(i,d,bB,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,d,bQ,indexI,indexJ);
							if(p==9)setPiecesAgainBlack(i,d,bK,indexI,indexJ);							
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
						String al3 ="";
						String al4 = "";
						if(i!=indexI) {al3 = Integer.toString(i);}
						if(j!=indexJ) {al4 = Integer.toString(d);}
						String e = al3 + al4;
						
						
						String c = al1 + al2;
						if( (p==0 || p==3 || p==4) && (moveTracker.contains(c) || moveTracker.contains(e)) )
						{
							checkB=0;break;
						}
						
						if( (p==1 || p==8 || p==9) && (moveTrackerBlack.contains(c) || moveTrackerBlack.contains(e)) )
						{
							checkB=0;break;
						}
						
						if( (p==0 || p==3 || p==4) && (i==indexIDest && d==indexJDest) && !moveTracker.contains(c))
						{	
							checkB = 1;
							if(p==0)setPiecesAgain(i,d,wB,indexI,indexJ);
							if(p==3)setPiecesAgain(i,d,wQ,indexI,indexJ);	
							if(p==4)setPiecesAgain(i,d,wK,indexI,indexJ);								
						}
						
						if( (p==1 || p==8 || p==9) && (i==indexIDest && d==indexJDest) && !moveTrackerBlack.contains(c))
						{	
							checkB = 1;
							if(p==1)setPiecesAgainBlack(i,d,bB,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,d,bQ,indexI,indexJ);	
							if(p==9)setPiecesAgainBlack(i,d,bK,indexI,indexJ);								
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
						String al3 ="";
						String al4 = "";
						if(i!=indexI) {al3 = Integer.toString(i);}
						if(j!=indexJ) {al4 = Integer.toString(d);}
						String e = al3 + al4;
						
						String c = al1 + al2;
						if( (p==0 || p==3 || p==4) && (moveTracker.contains(c) || moveTracker.contains(e)) )
						{checkB=0;break;}
						
						if( (p==1 || p==8 || p==9) && (moveTrackerBlack.contains(c) || moveTrackerBlack.contains(e)) )
						{checkB=0;break;}
						
						if( (p==0 || p==3 || p==4) &&  (i==indexIDest && d==indexJDest) && !moveTracker.contains(c))
						{	
							checkB = 1;
							if(p==0)setPiecesAgain(i,d,wB,indexI,indexJ);
							if(p==3)setPiecesAgain(i,d,wQ,indexI,indexJ);
							if(p==4)setPiecesAgain(i,d,wK,indexI,indexJ);								
						}
						
						if( (p==1 || p==8 || p==9) &&  (i==indexIDest && d==indexJDest) && !moveTrackerBlack.contains(c))
						{	
							checkB = 1;
							if(p==1)setPiecesAgainBlack(i,d,bB,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,d,bQ,indexI,indexJ);
							if(p==9)setPiecesAgainBlack(i,d,bK,indexI,indexJ);								
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
						String al3 ="";
						String al4 = "";
						if(i!=indexI) {al3 = Integer.toString(i);}
						if(j!=indexJ) {al4 = Integer.toString(d);}
						String e = al3 + al4;
						
						if( (p==0 || p==3 || p==4) && (moveTracker.contains(c) || moveTracker.contains(e)) )
						{checkB=0;break;}
						
						if( (p==1 || p==8 || p==9) && (moveTrackerBlack.contains(c) || moveTrackerBlack.contains(e)) )
						{checkB=0;break;}
						
						if( (p==0 || p==3 || p==4) &&  (i==indexIDest && d==indexJDest) && !moveTracker.contains(c))
						{	
							checkB = 1;
							if(p==0)setPiecesAgain(i,d,wB,indexI,indexJ);
							if(p==3)setPiecesAgain(i,d,wQ,indexI,indexJ);	
							if(p==4)setPiecesAgain(i,d,wK,indexI,indexJ);								
						}
						
						if( (p==1 || p==8 || p==9) &&  (i==indexIDest && d==indexJDest) && !moveTrackerBlack.contains(c))
						{	
							checkB = 1;
							if(p==1)setPiecesAgainBlack(i,d,bB,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,d,bQ,indexI,indexJ);	
							if(p==9)setPiecesAgainBlack(i,d,bK,indexI,indexJ);								
						}
						
						d++;
				}				
			}			
			
		//}		
	//}
	
	if(checkB==0) 
	{
		if(p==0)System.out.println("Illegal move try again!"); 
		if(p==3)ret = 6; //WHITE QUEEN
		if(p==4)ret = 6; //WHITE KING
		if(p==8)ret = 6; //BLACK QUEEN
		if(p==8)ret = 6; //BLACK KING			
	}
	if(checkB==1)
	{ 
			//REMOVE (indexI,IndexJ) from Arraylist
			String g1 = Integer.toString(indexI);
			String g2 = Integer.toString(indexJ);		
			String g = g1+g2;
			if( (p==0 || p==3 || p==4) && moveTracker.contains(g) )moveTracker.remove(g);
			if( (p==1 || p==8 || p==9) && moveTrackerBlack.contains(g) )moveTrackerBlack.remove(g);
			if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
			if(p==0 || p==3 || p==4)System.out.println(moveTracker);
			if(p==1 || p==8 || p==9)System.out.println(moveTrackerBlack);
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

	if(p==1) 
	{
		checkQ = moveForwBbB(8);
		if(checkQ==6) {checkQ=moveForWRBR(8);} // This only takes care of front back left right movements
	}	
	
	if(p==0) 
	{
		checkQ = moveForwBbB(3);
		if(checkQ==6) {checkQ=moveForWRBR(3);} // This only takes care of front back left right movements
	}
	
	if(checkQ==6) {System.out.println("Illegal move. Try again!");}	
	//if(p==1 && checkQ==6) {System.out.println("Illegal move for Black Queen");}	
} 

public int moveForWRBR(int p)
{
	
	/*
	if(p==0)PP = wN; //White
	if(p==3)PP = wQ; //White Queen
	if(p==4)PP = wK; //White King
	
	if(p==1)PP = bN; //Black
	if(p==8)PP = bQ; //Black Queen
	if(p==9)PP = bK; //Black King	
	
	*REPLACE ALL wN WITH PP 
	*/
	
	
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
	
		//This checks if I's are same then you're checking movements for Left  and Right
		//This only moves it to left and right only
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
						//if white pieces this if statement works
						if( (p==0 || p==3 || p==4) && moveTracker.contains(c) && j!=q )
							{checkR=3;break;}

						//if black pieces this if statement works
						if( (p==1 || p==8 || p==9) && moveTrackerBlack.contains(c) && j!=q )
							{
							//System.out.println("Black piece exists"); 
							checkR=3;break;
							}						
						
						if((p==0 || p==3 || p==4) && i==indexIDest && j==indexJDest && !moveTracker.contains(c))
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
							if(p==4)setPiecesAgain(i,j,wK,indexI,indexJ);							
						}
						
						if((p==1 || p==8 || p==9) && i==indexIDest && j==indexJDest && !moveTrackerBlack.contains(c))
						{	
							checkR = 1;
							if(p==1)setPiecesAgainBlack(i,j,bR,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,j,bQ,indexI,indexJ);
							if(p==9)setPiecesAgainBlack(i,j,bK,indexI,indexJ);							
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
						
						//if white pieces this if statement works
						if( (p==0 || p==3 || p==4) && moveTracker.contains(c) && j!=q )
							{checkR=3;break;}

						//if black pieces this if statement works
						if( (p==1 || p==8 || p==9) && moveTrackerBlack.contains(c) && j!=q )
							{
							checkR=3;break;
							}						
						
						if( (p==0 || p==3 || p==4) && i==indexIDest && j==indexJDest && !moveTracker.contains(c))
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
							if(p==4)setPiecesAgain(i,j,wK,indexI,indexJ);							
						}
						
						if((p==1 || p==8 || p==9) && i==indexIDest && j==indexJDest && !moveTrackerBlack.contains(c))
						{	
							checkR = 1;
							if(p==1)setPiecesAgainBlack(i,j,bR,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,j,bQ,indexI,indexJ);
							if(p==9)setPiecesAgainBlack(i,j,bK,indexI,indexJ);							
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
						
						if( (p==0 || p==3 || p==4) && moveTracker.contains(c) && i!=pr )
						{checkR=3; j=100+j;i=100+1;break;}		

						if( (p==1 || p==8 || p==9) && moveTrackerBlack.contains(c) && i!=pr )
						{
						checkR=3; j=100+j;i=100+1;break;
						}						
						
						if( (p==0 || p==3 || p==4) &&  i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
							if(p==4)setPiecesAgain(i,j,wK,indexI,indexJ);								
						}
						
						if( (p==1 || p==8 || p==9) &&  i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							if(p==1)setPiecesAgainBlack(i,j,bR,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,j,bQ,indexI,indexJ);
							if(p==9)setPiecesAgainBlack(i,j,bK,indexI,indexJ);									
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
						
						
						if((p==0 || p==3 || p==4) && moveTracker.contains(c) && i!=pr )
						{checkR=3; j=100+j;i=-5;break;}		

						if( (p==1 || p==8 || p==9) && moveTrackerBlack.contains(c) && i!=pr )
						{checkR=3; j=100+j;i=-5;break;}		
						
						if( (p==0 || p==3 || p==4) &&  i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
							if(p==4)setPiecesAgain(i,j,wK,indexI,indexJ);								
						}
						
						if( (p==1 || p==8 || p==9) &&  i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							if(p==1)setPiecesAgainBlack(i,j,bR,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,j,bQ,indexI,indexJ);
							if(p==9)setPiecesAgainBlack(i,j,bK,indexI,indexJ);									
						}	
						
					}
				}				
		}
	//}   /// ->> ###################################################################################  
		
		//Make this a new method - it checks for black spots and paints them back
	if(checkR==1)
		{
			//REMOVE (indexI,IndexJ) from Arraylist
		String g1 = Integer.toString(indexI);
		String g2 = Integer.toString(indexJ);		
		String g = g1+g2;
			if( (p==0 || p==3 || p==4) && moveTracker.contains(g) )moveTracker.remove(g);
			if( (p==1 || p==8 || p==9) && moveTrackerBlack.contains(g) )moveTrackerBlack.remove(g);			
			if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
			if( p==0 || p==3 || p==4)System.out.println(moveTracker);
			if( p==1 || p==8 || p==9)System.out.println(moveTrackerBlack);
		}
	
	if(checkR==0 || checkR==3)
		{
		if(p==0)System.out.println("Illegal move try again!"); 
		if(p==3)ret = 6;	//WHITE QUIEEN
		if(p==4)ret = 6;	//WHITE KING
		if(p==8)ret = 6;	//black QUIEEN
		if(p==9)ret = 6;	//black KING	
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

public void setPiecesAgainBlack(int i,int j,String piece,int indexII,int indexJJ)
{
	String io = Integer.toString(i);
	String jo = Integer.toString(j);
	boards[i][j]=piece;
	moveTrackerBlack.add(io + jo);
	boards[indexII][indexJJ]="   ";
}

}
