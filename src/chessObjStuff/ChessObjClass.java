package chessObjStuff;

import java.util.ArrayList;

/**
 * 
 * @author Rizwan Khan(mrk150) && Ahmed Ghoneim(asg179)
 * @version 1.0
 * This class contains all the possible movements for any piece
 * as well as illegal moves, castling, and check as well as checkmate
 *
 */
public class ChessObjClass extends board {

/**
 * Stores every index of the white pieces
 */

static ArrayList<String> moveTracker = new ArrayList<String>();	 //current positions of pieces where they are places

/**
 * Stores every index of the black pieces
 */
static ArrayList<String> moveTrackerBlack = new ArrayList<String>();	

/**
 * Stores every single move made by all players
 */
static ArrayList<String> allMoves = new ArrayList<String>();	//All possible moves done so far

static int blackRookCastlingLeft = 0;
static int blackRookCastlingRight = 0;
static int whiteRookCastlingLeft = 0;
static int whiteRookCastlingRight = 0;
static int whiteKingsMovementForCastling = 0;
static int blackKingsMovementForCastling = 0;

int whitePawn = 8;
int whiteRook = 2;
int whiteknight = 2;
int whiteBishop = 2;
int whitequeen = 1;

int blackPawn=8;
int blackRook = 2;
int blackknight = 2;
int blackBishop = 2;
int blackqueen = 1;


	//this will store what color moved the last turn to know which one moves this turn
	//starting it out as black in order to let white go first
	//this will be updated in move()
	private String prevColor = "black";
	
//when game is started this becomes 1
int start = 1;
String rook = "wR";

board b = new board();

/**
 * Initializes every single piece on the board into a String ArrayList
 * in order to be able to correctly id which piece is moved and which piece
 * is taken out. It also displays the board for the first time.
 */
public ChessObjClass()
{
	b.initializePiece(rook);

	moveTracker.add("70"); //wR
	moveTracker.add("71"); // wN
	moveTracker.add("72");// wB
	moveTracker.add("73"); // wQ queen
	moveTracker.add("74");// wK
	moveTracker.add("75");// wB
	moveTracker.add("76"); //wN 
	moveTracker.add("77"); //wR starting pos 
	

	moveTrackerBlack.add("00"); //bR
	moveTrackerBlack.add("01"); // bN
	moveTrackerBlack.add("02");// bB
	moveTrackerBlack.add("03"); // bQ queen
	moveTrackerBlack.add("04"); // bQ queen
	moveTrackerBlack.add("05");// bB
	moveTrackerBlack.add("06"); //bN
	moveTrackerBlack.add("07"); //bR  

	moveTrackerBlack.add("10");// bp0
	moveTrackerBlack.add("11");// bp1	
	moveTrackerBlack.add("12");// bp2
	moveTrackerBlack.add("13");// bp3
	moveTrackerBlack.add("14");// bp4	
	moveTrackerBlack.add("15");// bp5
	moveTrackerBlack.add("16");// bp5
	moveTrackerBlack.add("17");// bp7	

	moveTracker.add("60");// wp0
	moveTracker.add("61");// wp1	
	moveTracker.add("62");// wp2
	moveTracker.add("63");// wp3
	moveTracker.add("64");// wp4	
	moveTracker.add("65");// wp5
	moveTracker.add("66");// wp6
	moveTracker.add("67");// wp7		

	b.showBoard();
}

/**
 * Determines what the type of the piece to be moved is. Checks which player
 * moved the previous turn in order to determine who's turn it currently is.
 * Returns a boolean in order to check is a move made was valid or not.
 * 
 * @return Boolean
 */
public boolean move()
{
	//This would get you the piece to move
	String a = b.getPiece();
	
	//moving pieces
	if (prevColor.equals("black") && a.equals(wR))
	{
		int x = moveForWRBR(0);//moving rook, passing white as argument
		/*
		 * added this check in every move in order to know if move 
		 * was successful or not. the move() method determines successful
		 * moves. Converted void move() methods to ints to return -1
		 * when unsuccessful
		 */
		if (x == -1){
			return false;
		}
		prevColor = "white";
	}
	else if(prevColor.equals("white") && a.equals(bR))
	{
		int x = moveForWRBR(1);//moving rook, passing black as argument
		if (x == -1){
			return false;
		}
		prevColor = "black";
	}
	else if (prevColor.equals("black") && a.equals(wN))
	{//moving knight
		int x = moveForwNbN(0);//moving knight, passing white as argument
		if (x == -1){
			return false;
		}
		prevColor = "white";
	}
	else if(prevColor.equals("white")  && a.equals(bN))
	{
		int x = moveForwNbN(1);//moving knight, passing black as argument
		if (x == -1){
			return false;
		}
		prevColor = "black";
	}
	else if (prevColor.equals("black") && a.equals(wQ))
	{//moving queen
		int x = moveForWQBQ(0);//moving queen, passing white as argument
		if (x == -1){
			return false;
		}
		prevColor = "white";
	}
	else if(prevColor.equals("white") && a.equals(bQ))
	{
		int x = moveForWQBQ(1);//moving knight, passing black as argument
		if (x == -1){
			return false;
		}
		prevColor = "black";
	}
	else if (prevColor.equals("black") && a.equals(wK))
	{//moving king
		int x = moveForwKbK(0);//moving king, passing white as argument
		whiteKingsMovementForCastling++;
		if (x == -1){
			return false;
		}
		prevColor = "white";
	}else if(prevColor.equals("white") && a.equals(bK))
	{
		int x = moveForwKbK(1);//moving king, passing black as argument
		blackKingsMovementForCastling++;	
		if (x == -1){
			return false;
		}
		prevColor = "black";
	}else if (prevColor.equals("black") && a.equals(wB))
	{//moving bishop
		int x = moveForwBbB(0);//moving bishop, passing white as argument
		if (x == -1){
			return false;
		}
		prevColor = "white";
	}else if(prevColor.equals("white") && a.equals(bB))
	{
		int x = moveForwBbB(1);//moving bishop, passing black as argument
		if (x == -1){
			return false;
		}
		prevColor = "black";
	}else if (prevColor.equals("black") && (a.equals(wP0) || a.equals(wP1) || a.equals(wP2) || a.equals(wP3) || a.equals(wP4) 
			|| a.equals(wP5) || a.equals(wP6) || a.equals(wP7)))
	{
		int x = moveForwPbP(0);//moving pawn, passing white as argument
		if (x == -1){
			return false;
		}
		prevColor = "white";
	}
	else if(prevColor.equals("white") && (a.equals(bP0) || a.equals(bP1) || a.equals(bP2) || a.equals(bP3) || a.equals(bP4) 
			|| a.equals(bP5) || a.equals(bP6) || a.equals(bP7) ))
	{
		int x = moveForwPbP(1);//moving pawn, passing black as argument
		if (x == -1){
			return false;
		}
		prevColor = "black";
	}
	else
	{
		//user tried to move opponent piece
		return false;
	}

	return true;
	
}


	/**
 	* Returns the color of the previous move.
 	* 
 	* @return String
 	*/
	public String getPrevColor()
	{
		return prevColor;
	}

/**
 * Checks if move about to be done is a kill move or not. Removes killed pieces from the
 * ArrayList trackers, both black and white, and decrements the count number for each piece 
 * appropriately.
 */
public void overlap()
{

	String abc = getCoordinates(); //You get a whole string of input e.g "a1 e5"
	//you get starting pos e.g in above example you get a1
	int indexI = intcordinatesfromString(abc,0);
	int indexJ = intcordinatesfromString(abc,1);
	//you get destination pos e.g in above example you get e5
	int indexIDest = intcordinatesfromString(abc,3);
	int indexJDest = intcordinatesfromString(abc,4);		
	
	String cont = "" + indexI + indexJ; //Index of the current piece moved
	String cont2 = "" + indexIDest + indexJDest; //Index of the piece taken out

	String move1=boards[indexI][indexJ];;
	String move2=boards[indexIDest][indexJDest];

	//white takes out
	if(move1.equals(wR) || move1.equals(wB) || move1.equals(wN) || move1.equals(wQ) ||   move2.equals(wP0) || move2.equals(wP1)|| move2.equals(wP2)|| move2.equals(wP3)||
	   move2.equals(wP4) || move2.equals(wP5)|| move2.equals(wP6)|| move2.equals(wP7)  )
		if( moveTracker.contains(cont) && !moveTrackerBlack.contains(cont2) )
		{
			move1 = boards[indexI][indexJ]; //Players piece 
			move2 = boards[indexIDest][indexJDest]; //taken out piece 	
		}

	//Black takes out
	if(move1.equals(bR)  || move1.equals(bB) || move1.equals(bN) || move1.equals(bQ) ||   move1.equals(bP0) || move1.equals(bP1)|| move1.equals(bP2)|| move1.equals(bP3)||
	   move1.equals(bP4) || move1.equals(bP5)|| move1.equals(bP6)|| move1.equals(bP7) )
		if( moveTracker.contains(cont2) && moveTrackerBlack.contains(cont) )
		{
			move1 = boards[indexI][indexJ]; //Players piece 
			move2 = boards[indexIDest][indexJDest]; //taken out piece 	
		}
 
	//Black piece gets taken out
	if(move2.equals(bR)  || move2.equals(bB) || move2.equals(bN) || move2.equals(bQ) 
		||
	   move2.equals(bP0) || move2.equals(bP1)|| move2.equals(bP2)|| move2.equals(bP3)||
	   move2.equals(bP4) || move2.equals(bP5)|| move2.equals(bP6)|| move2.equals(bP7)
	  )
	{
		
		if(move2.equals(bR) )
		{
			blackRook--;
		}

		if(move2.equals(bB) )
		{
			blackBishop--;
		}		
	
		if(move2.equals(bN) )
		{
			blackknight--;
		}

		if(move2.equals(bQ) )
		{
			blackqueen--;
		}
		
		if( move2.equals(bP0) || move2.equals(bP1)|| move2.equals(bP2)|| move2.equals(bP3)||
				   move2.equals(bP4) || move2.equals(bP5)|| move2.equals(bP6)|| move2.equals(bP7) )
		{
			blackPawn--;
		}

		String g1 = Integer.toString(indexIDest);
		String g2 = Integer.toString(indexJDest);		
		String g = g1+g2;
		moveTrackerBlack.remove(g);
	}	

	//White piece gets taken out
	if(move2.equals(wR) || move2.equals(wB) || move2.equals(wN) || move2.equals(wQ) 
	 ||
	  move2.equals(wP0) || move2.equals(wP1)|| move2.equals(wP2)|| move2.equals(wP3)||
	  move2.equals(wP4) || move2.equals(wP5)|| move2.equals(wP6)|| move2.equals(wP7)
		)			
	{
		
		if(move2.equals(wR) )
		{
			whiteRook--;
		}

		if(move2.equals(wB) )
		{
			whiteBishop--;
		}		
	
		if(move2.equals(wN) )
		{
			whiteknight--;
		}

		if(move2.equals(wQ) )
		{
			whitequeen--;
		}

		if( move2.equals(wP0) || move2.equals(wP1)|| move2.equals(wP2)|| move2.equals(wP3)||
				   move2.equals(wP4) || move2.equals(wP5)|| move2.equals(wP6)|| move2.equals(wP7) )
		{
			whitePawn--;
		}		
		
		String g1 = Integer.toString(indexIDest);
		String g2 = Integer.toString(indexJDest);		
		String g = g1+g2;
		moveTracker.remove(g);		
	}

}


static int checkForCastling = 0;

/**
 * Specific move for King pieces, white or black. Returns an -1 for an invalid move and
 * 1 for a valid move. Calls moveForWRBR method to move in a straight line, (up, down, left,
 * right). Calls moveForwBbB method to move in a diagonal manner (upper left, upper right, 
 * lower left, lower right). In charge of pawn promotion.
 * @param p, takes either 4 or 9, 4 for white king, 9 for black king
 * @return int, -1 for illegal move, 1 for legal move
 */
public int moveForwKbK(int p)
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
	
 //This move is Castling

		if( indexIDest==indexI && indexJDest==indexJ-2 && whiteRookCastlingLeft==0 && blackRookCastlingLeft==0 && whiteKingsMovementForCastling==0) //THIS castles to the left
		{
				if(p==0 && !moveTracker.contains("71") && !moveTracker.contains("72") && !moveTracker.contains("73") )//&& !moveTracker.contains("75") && !moveTracker.contains("76"))
				{
					int bbb = ifCheckDiagonal(wKI,wKJ);
					int ccc = ifCheckKnight(wKI,wKJ);
					if(bbb!=2 && ccc!=2)
					{
						 checkForCastling = 1;
						checkQ=moveForWRBR(4);
						if(checkQ==6)whiteKingsMovementForCastling--;
						if(checkQ!=6)castling(indexIDest,indexJDest,indexI,indexJ,0);
						checkForCastling = 0;
					}
				}

				if(p==1&& !moveTrackerBlack.contains("01") && !moveTrackerBlack.contains("02") && !moveTrackerBlack.contains("03") )//&& !moveTracker.contains("05") && !moveTracker.contains("06"))
				{
					int bbb = ifCheckDiagonal(bKI,bKJ);
					int ccc = ifCheckKnight(bKI,bKJ);
					if(bbb!=2 && ccc!=2)
					{
						 checkForCastling = 1;
						checkQ=moveForWRBR(9);
						if(checkQ==6)blackKingsMovementForCastling--;
						if(checkQ!=6)castling(indexIDest,indexJDest,indexI,indexJ,1);
						checkForCastling = 0;
					}
				}
		}	

		if( indexIDest==indexI && indexJDest==indexJ+2 && whiteRookCastlingRight==0 && blackRookCastlingRight==0 && whiteKingsMovementForCastling==0) //THIS castles to the left
		{
			if(p==0 && !moveTracker.contains("75") && !moveTracker.contains("76"))
			{
				int bbb = ifCheckDiagonal(wKI,wKJ);
				int ccc = ifCheckKnight(wKI,wKJ);
				if(bbb!=2 && ccc!=2)
				{	
					 checkForCastling = 1;
					checkQ=moveForWRBR(4);
					if(checkQ==6)whiteKingsMovementForCastling--;
					if(checkQ!=6)castling(indexIDest,indexJDest,indexI,indexJ,0);
					checkForCastling = 0;
				}
			}
				
			if(p==1&& !moveTracker.contains("05") && !moveTracker.contains("06"))
			{
				int bbb = ifCheckDiagonal(bKI,bKJ);
				int ccc = ifCheckKnight(bKI,bKJ);
				if(bbb!=2 && ccc!=2)
				{	
					checkForCastling = 1;
					checkQ=moveForWRBR(9);
					if(checkQ==6)blackKingsMovementForCastling--;
					if(checkQ!=6)castling(indexIDest,indexJDest,indexI,indexJ,1);
					checkForCastling = 0;
				}
			}
		}			
		/////////////////////////////////////////
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
	
	//if(checkQ==6 || checkQ == -1) {System.out.println("Illegal move."); return -1;}
	if(checkQ==6) {return -1;}
	
	return 0;
} 

/**
 * Moves pawn pieces (white and black). Determines if pawn is in Empassant status. p set to 0
 * moves a white piece and p set to 1 moves a black pawn. Kills pawn pieces and moves 
 * diagonally after such a kill.
 * @param p, takes either 0 or 1, 0 for white piece, 1 for black piece
 * @return int, -1 for illegal move, 1 for legal move
 */
public int moveForwPbP(int p)
{
//NOTE: Only need to add overlapping moves now
	String abc = getCoordinates();
	int indexI = intcordinatesfromString(abc,0);
	int indexJ = intcordinatesfromString(abc,1);
	int indexIDest = intcordinatesfromString(abc,3);
	int indexJDest = intcordinatesfromString(abc,4);	

	chessPieceInfo wPP = new chessPieceInfo(); 

	String wpPiece = "";
	if(p==0)
	{
		if(indexI==6 && indexJ==0)wpPiece = "60";if(indexI==6 && indexJ==1)wpPiece = "61";if(indexI==6 && indexJ==2)wpPiece = "62";if(indexI==6 && indexJ==3)wpPiece = "63"; 
		if(indexI==6 && indexJ==4)wpPiece = "64";if(indexI==6 && indexJ==5)wpPiece = "65";if(indexI==6 && indexJ==6)wpPiece = "66";if(indexI==6 && indexJ==7)wpPiece = "67"; 
	}

	if(p==1)
	{
		if(indexI==1 && indexJ==0)wpPiece = "10";if(indexI==1 && indexJ==1)wpPiece = "11";if(indexI==1 && indexJ==2)wpPiece = "12";if(indexI==1 && indexJ==3)wpPiece = "13"; 
		if(indexI==1 && indexJ==4)wpPiece = "14";if(indexI==1 && indexJ==5)wpPiece = "15";if(indexI==1 && indexJ==6)wpPiece = "16";if(indexI==1 && indexJ==7)wpPiece = "17"; 
	}

	char idI1 = abc.charAt(0);String idI = String.valueOf(idI1);char idJ1 = abc.charAt(1);String idJ = String.valueOf(idJ1);	

	//This will check the id
	wPP = getObject(wpPiece,idI,idJ);


	int i=0;int j=0;int checkP = 0;String al1 = "";String al2 = "";	

	int stepsP=0;int checkP2 = 0; 
	
	if(p==1)
	{
		if(indexI<indexIDest) //&& indexIDest==indexI-1)
		{
			j = indexJ;
			
			if(indexI<indexIDest && indexIDest==indexI+2)
			{
				if(wPP.getFirstMove()==0)
				{
					for( i=indexI; i<=indexIDest; i++)
					{		
						al1 = Integer.toString(indexIDest);	al2 = Integer.toString(indexJDest);
						String al3 = ""  + Integer.toString(indexI+1);String d = al3 + al2;	String c = al1 + al2;
	
						if( p==1  && (moveTracker.contains(c) ||  moveTracker.contains(d) || moveTrackerBlack.contains(d) || moveTrackerBlack.contains(c))  )
						{	checkP=0;break;	}										
	
						if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && stepsP==2)
						{	checkP = 1;	setPiecesAgainBlack(i,j,bP1,indexI,indexJ);wPP.setFirstMove(2);checkP2 = 1;}					
						stepsP++;						
					}				
				}
				if(wPP.getFirstMove()!=0 && checkP2==0)checkP=0;		
			}

			//////////////////////
			///////PROMOTION PART : 
			//Move to overtake opponents piece - moves up-left
			if(indexIDest==7 && indexI==6 && indexJ==indexJDest)
			{
				for( i=indexI; i<=indexIDest; i++)
				{
					al1 = Integer.toString(indexIDest);	al2 = Integer.toString(indexJDest);	String c = al1 + al2;
		
					if( p==1 && (moveTrackerBlack.contains(c) || moveTracker.contains(c)) ){checkP=0;break;}			
					
					if( p==1 && (i==indexIDest && j==indexJDest) && !moveTrackerBlack.contains(c) && stepsP==1)
					{	
						checkP = 1;	String acd = getInputString();
						if(acd.length()>5)
						{
							char s1 = acd.charAt(6); 
							if(s1=='N') {setPiecesAgain(i,j,bN,indexI,indexJ); }
							if(s1=='R') {setPiecesAgain(i,j,bR,indexI,indexJ);} 
							if(s1=='B') {setPiecesAgain(i,j,bB,indexI,indexJ);  }
						}
						else {setPiecesAgain(i,j,bQ,indexI,indexJ);}
						wPP.setFirstMove(1);
					}
					else {checkP=0;}
					stepsP++;
				}
			}
			
			if(indexJDest==indexJ-1 && indexIDest==7 && indexI==6)
			{
				for( i=indexI; i<=indexIDest; i++)
				{
					for( j=indexJ; j>=indexJDest; j--)
					{
						String endmoveleft ="" + indexIDest + indexJDest;
						if(i==indexIDest && j==indexJDest)
						if( moveTracker.contains(endmoveleft)  )
						{
							checkP = 1;	String acd = getInputString();
							if(acd.length()>5)
							{
								char s1 = acd.charAt(6); 
								if(s1=='N') {setPiecesAgain(i,j,bN,indexI,indexJ); blackknight++;}
								if(s1=='R') {setPiecesAgain(i,j,bR,indexI,indexJ); blackRook++;}
								if(s1=='B') {setPiecesAgain(i,j,bB,indexI,indexJ); blackBishop++;} 
							}
							else {setPiecesAgain(i,j,bQ,indexI,indexJ); blackqueen++;}
							wPP.setFirstMove(1);
						}
						else
						{checkP=0;}
					}
					stepsP++;
				}				
			}			
			if(indexJDest==indexJ+1 && indexIDest==7 && indexI==6)
			{
				for( i=indexI; i<=indexIDest; i++)
				{
					for( j=indexJ; j<=indexJDest; j++)
					{
						String endmoveleft ="" + indexIDest + indexJDest;
						if(i==indexIDest && j==indexJDest)
						if( moveTracker.contains(endmoveleft)  )
						{
							checkP = 1;	String acd = getInputString();
							if(acd.length()>5)
							{
								char s1 = acd.charAt(6); 
								if(s1=='N') {setPiecesAgain(i,j,bN,indexI,indexJ); blackknight++;}
								if(s1=='R') {setPiecesAgain(i,j,bR,indexI,indexJ); blackRook++;}
								if(s1=='B') {setPiecesAgain(i,j,bB,indexI,indexJ); blackBishop++;} 
							}
							else {setPiecesAgain(i,j,bQ,indexI,indexJ); blackqueen++;}
							wPP.setFirstMove(1);
						}
						else
						{checkP=0;}
					}
					stepsP++;
				}				
			}				
			//////////////////////////////////////////////////			
			//For black piece to move one step downwards
			if(indexI<indexIDest && indexIDest==indexI+1 && indexI!=6)
			for( i=indexI; i<=indexIDest; i++)
			{
				al1 = Integer.toString(indexIDest);	al2 = Integer.toString(indexJDest);	String c = al1 + al2;
	
				if( p==1 && (moveTrackerBlack.contains(c) || moveTracker.contains(c)) )
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
			//Move to overtake opponents piece - moves down-left		
			if(indexJDest==indexJ-1 && indexIDest!=7 && indexI!=6)
			{
				for( i=indexI; i<=indexIDest; i++)
				{
					for( j=indexJ; j>=indexJDest; j--)
					{
						//This is upper left diagonal kill move  - white 
						String endmoveleft ="" + indexIDest + indexJDest;
						if(i==indexIDest && j==indexJDest)
						if( moveTracker.contains(endmoveleft)  )
						{
							checkP = 1;
							setPiecesAgain(i,j,bP1,indexI,indexJ);
							wPP.setFirstMove(1);
						}	
						else
						{checkP=0;}
					}
					stepsP++;
				}				
			}
			//Move to overtake opponents piece - moves down-right
			if(indexJDest==indexJ+1  && indexIDest!=7 && indexI!=6)
			{
				for( i=indexI; i<=indexIDest; i++)
				{
					for( j=indexJ; j<=indexJDest; j++)
					{
						String endmoveleft ="" + indexIDest + indexJDest;
						if(i==indexIDest && j==indexJDest)
						if( moveTracker.contains(endmoveleft)  )
						{
							checkP = 1;
							setPiecesAgain(i,j,bP1,indexI,indexJ);
							wPP.setFirstMove(1);
						}
						else
						{checkP=0;}
					}
					stepsP++;
				}				
			}		
			/// enpassant move down left
			if(indexJDest==indexJ-1 && indexI<indexIDest && boards[indexI][indexJ-1].equals("wp ") && (boards[indexI+1][indexJ-1].equals("   ")||boards[indexI+1][indexJ-1].equals("## ")) )
			{
				/*
				chessPieceInfo wPP2 = new chessPieceInfo(); 
				String loc = "" + indexI + (indexJ-1);
				int i1 = indexI;
				int i2 = indexJ-1;
				String i11 = "" + i1;
				String i22 = "" + i2;
				wPP2 = getObject(loc,i11,i22);
				 */
				//	if( wPP2.getSteps()==1)
					//{
						for( i=indexI; i<=indexIDest; i++)
						{
							for( j=indexJ; j>=indexJDest; j--)
							{
								//This is upper left diagonal kill move  - white 
								String endmoveleft ="" + indexIDest + indexJDest;
								if(i==indexIDest && j==indexJDest)
								if( !moveTracker.contains(endmoveleft)  )
								{
									checkP = 1;
									setPiecesAgain(i,j,bP1,indexI,indexJ);
									wPP.setFirstMove(1);
								}	
							}
							stepsP++;
						}
						enpassant(indexIDest,indexJDest,indexI,indexJ,1);
					//}					
			}			
			/// enpassant move down right
			if(indexJDest==indexJ+1 && indexI<indexIDest && boards[indexI][indexJ+1].equals("wp ") && (boards[indexI+1][indexJ+1].equals("   ")||boards[indexI+1][indexJ+1].equals("## ")) )
			{
				/*
				chessPieceInfo wPP2 = new chessPieceInfo(); 
				String loc = "" + indexI + (indexJ+1);
				int i1 = indexI;
				int i2 = indexJ+1;
				String i11 = "" + i1;
				String i22 = "" + i2;
				wPP2 = getObject(loc,i11,i22);
				*/
					//if( wPP2.getSteps()==1)
					//{
						for( i=indexI; i<=indexIDest; i++)
						{
							for( j=indexJ; j>=indexJDest; j--)
							{
								//This is upper left diagonal kill move  - white 
								String endmoveleft ="" + indexIDest + indexJDest;
								if(i==indexIDest && j==indexJDest)
								if( !moveTracker.contains(endmoveleft)  )
								{
									checkP = 1;
									setPiecesAgain(i,j,bP1,indexI,indexJ);
									wPP.setFirstMove(1);
								}	
							}
							stepsP++;
						}
						enpassant(indexIDest,indexJDest,indexI,indexJ,1);
					//}
			}			
		}	
	}
	///////
	if(p==0)
	{	
		if(indexI>indexIDest) //&& indexIDest==indexI-1)
		{	j = indexJ;
			
			//This is just for the first move  // to determine if 2steps or one
			if(indexI>indexIDest && indexIDest==indexI-2 && indexI!=1)
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
						if( p==0 && (moveTracker.contains(c) ||  moveTracker.contains(d) || moveTrackerBlack.contains(d) || moveTrackerBlack.contains(c))  )
						{
							checkP=0;
							break;
						}				
						
						if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && stepsP==2)
						{	
							checkP = 1;
							setPiecesAgain(i,j,wP1,indexI,indexJ);
							wPP.setFirstMove(2);
							checkP2 = 1;
						}
						stepsP++;

					}				
				}
				
				if(wPP.getFirstMove()!=0 && checkP2==0)checkP=0;		
			}
			//////////////////////
			///////PROMOTION PART : 
			//Move to overtake opponents piece - moves up-left
			if(indexJDest==indexJ-1 && indexI==1 && indexIDest==0)
			{
				for( i=indexI; i>=indexIDest; i--)
				{
					for( j=indexJ; j>=indexJDest; j--)
					{
						//This is upper left diagonal kill move  - white 
						String endmoveleft ="" + indexIDest + indexJDest;
						if(i==indexIDest && j==indexJDest)
						if( moveTrackerBlack.contains(endmoveleft)  )
						{
							checkP = 1;	String acd = getInputString();
							if(acd.length()>5)
							{
								char s1 = acd.charAt(6); 
								if(s1=='N')setPiecesAgain(i,j,wN,indexI,indexJ);  
								if(s1=='R')setPiecesAgain(i,j,wR,indexI,indexJ); 
								if(s1=='B')setPiecesAgain(i,j,wB,indexI,indexJ);  
							}
							else {setPiecesAgain(i,j,wQ,indexI,indexJ);}
							wPP.setFirstMove(1);
						}	
						else
						{checkP=0;}
					}
					stepsP++;
				}				
			}
			//Move to overtake opponents piece - moves up-right
			if(indexJDest==indexJ+1 && indexI==1 && indexIDest==0)
			{
				for( i=indexI; i>=indexIDest; i--)
				{
					for( j=indexJ; j<=indexJDest; j++)
					{
						String endmoveleft ="" + indexIDest + indexJDest;
						if(i==indexIDest && j==indexJDest)
						if( moveTrackerBlack.contains(endmoveleft)  )
						{
							checkP = 1;	String acd = getInputString();
							if(acd.length()>5)
							{
								char s1 = acd.charAt(6); 
								if(s1=='N') {setPiecesAgain(i,j,wN,indexI,indexJ); whiteknight++;  }
								if(s1=='R') {setPiecesAgain(i,j,wR,indexI,indexJ); whiteRook++;}
								if(s1=='B') {setPiecesAgain(i,j,wB,indexI,indexJ); whiteBishop++;} 
							}
							else {setPiecesAgain(i,j,wQ,indexI,indexJ); whitequeen++;}
							wPP.setFirstMove(1);
						}
						else
						{checkP=0;}
					}
					stepsP++;
				}				
			}			
			if(indexIDest==0 && indexI==1 && indexIDest==0 && indexJ==indexJDest)
			{
				for( i=indexI; i>=indexIDest; i--)
				{
					al1 = Integer.toString(indexIDest);	al2 = Integer.toString(indexJDest);	String c = al1 + al2;
					if( p==0 && (moveTracker.contains(c) || moveTrackerBlack.contains(c) ) )
					{checkP=0;break;}		
					
					if( p==0 && (i==indexIDest && j==indexJDest) && !moveTracker.contains(c) && stepsP==1)
					{	
						checkP = 1;	String acd = getInputString();
						if(acd.length()>5)
						{
							char s1 = acd.charAt(6); 
							if(s1=='N') {setPiecesAgain(i,j,wN,indexI,indexJ); whiteknight++;  }
							if(s1=='R') {setPiecesAgain(i,j,wR,indexI,indexJ); whiteRook++;}
							if(s1=='B') {setPiecesAgain(i,j,wB,indexI,indexJ); whiteBishop++;} 
						}
						else {setPiecesAgain(i,j,wQ,indexI,indexJ); whitequeen++;}
						wPP.setFirstMove(1);
					}
					else {checkP=0;}
					stepsP++;
				}
			}				
			//////////////////////////////////////////////////
			
			//This moves 1 step upward for white
			if(indexI>indexIDest && indexIDest==indexI-1 && indexI!=1)
			{
				for( i=indexI; i>=indexIDest; i--)
				{
					al1 = Integer.toString(indexIDest);	al2 = Integer.toString(indexJDest);	String c = al1 + al2;
					if( p==0 && (moveTracker.contains(c) || moveTrackerBlack.contains(c) ) )
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
			//Move to overtake opponents piece - moves up-left
			if(indexJDest==indexJ-1 && indexI!=1)
			{
				for( i=indexI; i>=indexIDest; i--)
				{
					for( j=indexJ; j>=indexJDest; j--)
					{
						//This is upper left diagonal kill move  - white 
						String endmoveleft ="" + indexIDest + indexJDest;
						if(i==indexIDest && j==indexJDest)
						if( moveTrackerBlack.contains(endmoveleft)  )
						{
							checkP = 1;
							setPiecesAgain(i,j,wP1,indexI,indexJ);
							wPP.setFirstMove(1);
						}	
						else
						{checkP=0;}
					}
					stepsP++;
				}				
			}
			//Move to overtake opponents piece - moves up-right
			if(indexJDest==indexJ+1 && indexI!=1 )// && indexJ==indexJDest)
			{
				for( i=indexI; i>=indexIDest; i--)
				{
					for( j=indexJ; j<=indexJDest; j++)
					{
						String endmoveleft ="" + indexIDest + indexJDest;
						if(i==indexIDest && j==indexJDest)
						if( moveTrackerBlack.contains(endmoveleft)  )
						{
							checkP = 1;
							setPiecesAgain(i,j,wP1,indexI,indexJ);
							wPP.setFirstMove(1);
						}
						else
						{checkP=0;}
					}
					stepsP++;
				}				
			}
			/// enpassant move up left
			if(indexJDest==indexJ-1 && indexI>indexIDest && boards[indexI][indexJ-1].equals("bp ") && (boards[indexI-1][indexJ-1].equals("   ")||boards[indexI-1][indexJ-1].equals("## ")) )
			{
				/*
				chessPieceInfo wPP2 = new chessPieceInfo(); 
				String loc = "" + indexI + (indexJ-1);
				int i1 = indexI;
				int i2 = indexJ-1;
				String i11 = "" + i1;
				String i22 = "" + i2;
				wPP2 = getObject(loc,i11,i22);
				*/
					//if( wPP2.getSteps()==1)
					//{
						for( i=indexI; i>=indexIDest; i--)
						{
							for( j=indexJ; j>=indexJDest; j--)
							{
								//This is upper left diagonal kill move  - white 
								String endmoveleft ="" + indexIDest + indexJDest;
								if(i==indexIDest && j==indexJDest)
								if( !moveTrackerBlack.contains(endmoveleft)  )
								{
									checkP = 1;
									setPiecesAgain(i,j,wP1,indexI,indexJ);
									wPP.setFirstMove(1);
								}	
							}
							stepsP++;
						}
						enpassant(indexIDest,indexJDest,indexI,indexJ,0);	
					//}				
			}		
			
			/// enpassant move up right
			if(indexJDest==indexJ+1 && indexI>indexIDest && boards[indexI][indexJ+1].equals("bp ") && (boards[indexI-1][indexJ+1].equals("   ")||boards[indexI-1][indexJ+1].equals("## ")) )
			{
				/*
				chessPieceInfo wPP2 = new chessPieceInfo(); 
				String loc = "" + indexI + (indexJ+1);
				int i1 = indexI;
				int i2 = indexJ+1;
				String i11 = "" + i1;
				String i22 = "" + i2;
				wPP2 = getObject(loc,i11,i22);
				*/
				
					//if( wPP2.getSteps()==1)
					//{ 
						for( i=indexI; i>=indexIDest; i--)
						{
							for( j=indexJ; j<=indexJDest; j++)
							{
								//This is upper left diagonal kill move  - white 
								String endmoveleft ="" + indexIDest + indexJDest;
								if(i==indexIDest && j==indexJDest)
								if( !moveTrackerBlack.contains(endmoveleft)  )
								{
									checkP = 1;
									setPiecesAgain(i,j,wP1,indexI,indexJ);
									wPP.setFirstMove(1);
								}	
							}
							stepsP++;
						}
						enpassant(indexIDest,indexJDest,indexI,indexJ,0);	
					//}	
			}
			////			
						
		}		
	}
	if(checkP==0) {return -1;}
	if(checkP==1)
	{ 
			wPP.incrSteps();
			String aaaaa = "" + indexIDest + "" +indexJDest;int bbbbb = Integer.parseInt(aaaaa);	
			wPP.setID(bbbbb);String g1 = Integer.toString(indexI);
			String g2 = Integer.toString(indexJ);		
			String g = g1+g2;
			if( (p==0) && moveTracker.contains(g) )moveTracker.remove(g);
			if( (p==1) && moveTrackerBlack.contains(g) )moveTrackerBlack.remove(g);				
			//if( moveTracker.contains(g) )moveTracker.remove(g);
			if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
			wpPiece = "" + indexIDest + indexJDest;String iii ="" + indexIDest;String jjj ="" + indexJDest;wPP= getObject(wpPiece,iii,jjj);
		
	}		
	return 0;
}

/**
 * Moves knight pieces (white and black). 
 * @param p, takes 0 for white piece, 1 for black piece
 * @return int, -1 for illegal move, 1 for legal move
 */
public int moveForwNbN(int p)
{
//Moves for Knight

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
	if(checkN==0) { return -1;}
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
	return 0;
}

/**
 * Moves bishop pieces or any other piece that needs to move diagonally (white and black). 
 * @param p, 0 for white piece, 1 for black piece
 * @return int, -1 for illegal move, 1 for legal move, 6 if moved by king or queen.
 */
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
	int moveI = 0;
	int moveJ = 0;

			//moves upper left diagonal
			if(indexJDest<indexJ && indexI>indexIDest)
			{
				int d=indexJ;
				for( i=indexI; i>=indexIDest; i--)
				{
						al1 = Integer.toString(indexIDest); al2 = Integer.toString(indexJDest);
						String al3 ="";	String al4 = "";
						if(i!=indexI && i!=indexIDest)al3 = Integer.toString(i);if(d!=indexJ && d!=indexIDest)al4 = Integer.toString(d);
						String e ="" + al3 + al4;String c ="" + al1 + al2;
						
						if( (p==0 || p==3 || p==4) && (moveTracker.contains(c)||moveTracker.contains(e)||moveTrackerBlack.contains(e)) )
						{
							checkB=0;break;
						}
						
						if( (p==1 || p==8 || p==9) && (moveTrackerBlack.contains(c)||moveTrackerBlack.contains(e) || moveTracker.contains(e)) )
						{
							checkB=0;break;
						}						
						
						if( (p==0 || p==3 || p==4) && (i==indexIDest && d==indexJDest) && !moveTracker.contains(c) )
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
					al1 = Integer.toString(indexIDest); al2 = Integer.toString(indexJDest);
					String al3 ="";	String al4 = "";
					if(i!=indexI && i!=indexIDest)al3 = Integer.toString(i);if(d!=indexJ && d!=indexIDest)al4 = Integer.toString(d);
					String e ="" + al3 + al4;String c ="" + al1 + al2;
					
					if( (p==0 || p==3 || p==4) && (moveTracker.contains(c)||moveTracker.contains(e)||moveTrackerBlack.contains(e)) )
					{
						checkB=0;break;
					}
					
					if( (p==1 || p==8 || p==9) && (moveTrackerBlack.contains(c)||moveTrackerBlack.contains(e) || moveTracker.contains(e)) )
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
					al1 = Integer.toString(indexIDest); al2 = Integer.toString(indexJDest);
					String al3 ="";	String al4 = "";
					if(i!=indexI && i!=indexIDest)al3 = Integer.toString(i);if(d!=indexJ && d!=indexIDest)al4 = Integer.toString(d);
					String e ="" + al3 + al4;String c ="" + al1 + al2;
					
					if( (p==0 || p==3 || p==4) && (moveTracker.contains(c)||moveTracker.contains(e)||moveTrackerBlack.contains(e)) )
					{
						checkB=0;break;
					}
					
					if( (p==1 || p==8 || p==9) && (moveTrackerBlack.contains(c)||moveTrackerBlack.contains(e) || moveTracker.contains(e)) )
					{
						checkB=0;break;
					}	
						
					else if( (p==0 || p==3 || p==4) &&  (i==indexIDest && d==indexJDest) && !moveTracker.contains(c))
					{	
						checkB = 1;
						if(p==0)setPiecesAgain(i,d,wB,indexI,indexJ);
						if(p==3)setPiecesAgain(i,d,wQ,indexI,indexJ);
						if(p==4)setPiecesAgain(i,d,wK,indexI,indexJ);								
					}
						
					else if( (p==1 || p==8 || p==9) &&  (i==indexIDest && d==indexJDest) && !moveTrackerBlack.contains(c))
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
					al1 = Integer.toString(indexIDest); al2 = Integer.toString(indexJDest);
					String al3 ="";	String al4 = "";
					if(i!=indexI && i!=indexIDest)al3 = Integer.toString(i);if(d!=indexJ && d!=indexIDest)al4 = Integer.toString(d);
					String e ="" + al3 + al4;String c ="" + al1 + al2;
					
					if( (p==0 || p==3 || p==4) && (moveTracker.contains(c)||moveTracker.contains(e)||moveTrackerBlack.contains(e)) )
					{
						checkB=0;break;
					}
					
					if( (p==1 || p==8 || p==9) && (moveTrackerBlack.contains(c)||moveTrackerBlack.contains(e) || moveTracker.contains(e)) )
					{
						checkB=0;break;
					}	
						
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

	
	if(checkB==0) 
	{
		if(p==0 || p==1){
			return -1;
		}
		if(p==3)ret = 6; //WHITE QUEEN
		if(p==4)ret = 6; //WHITE KING
		if(p==8)ret = 6; //BLACK QUEEN
		if(p==9)ret = 6; //BLACK KING			
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

	}		
	 
	return ret;
}

/**
 * Moves queen pieces (white and black) by using the moveForwBbB method to move diagonally.
 * @param p, 3 for white queen, 8 for black queen
 * @return int, -1 for illegal move, 1 for legal move
 */
public int moveForWQBQ(int p)
{
//Method to move Queen and checks legal moves

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
	
	if(checkQ==6 || checkQ==-1) { return -1;}	

	return 0;
} 

/**
 * Moves rook pieces (white and black). Responsible for moving king and queen pieces \
 * (up, down, left, right). 
 * @param p, 0 for white piece, 1 for black piece
 * @return int, -1 for illegal move, 1 for legal move, 6 if moved king or queen
 */
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
						String c = "";
						if(i==indexIDest && j!=indexJDest)c = al1 + al2;
						String a3 = Integer.toString(indexIDest);
						String a4 = Integer.toString(indexJDest);
						String e = a3 + a4;
						//if white pieces this if statement works
						if( (p==0 || p==3 || p==4) && (moveTracker.contains(c) || moveTrackerBlack.contains(c)) && j!=q )
							{checkR=3;break;}

						//if black pieces this if statement works
						if( (p==1 || p==8 || p==9) && (moveTracker.contains(c) || moveTrackerBlack.contains(c)) && j!=q )
							{
							checkR=3;break;
							}						
						 
						if((p==0 || p==3 || p==4) && i==indexIDest && j==indexJDest && !moveTracker.contains(e))
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
							if(p==4)
							{
								if(checkForCastling==1)
								{
									int bbb = ifCheckDiagonal(wKI,wKJ+2);
									int ccc =  ifCheckKnight(wKI,wKJ+2);
									if(bbb!=2 && ccc!=2)
									{ 
										setPiecesAgain(i,j,wK,indexI,indexJ);
									}
									else {checkR=0;}
								}
								if(checkForCastling!=1)
								{

										setPiecesAgain(i,j,wK,indexI,indexJ);

								}
							}
							//overlap();
						}
						
						if((p==1 || p==8 || p==9) && i==indexIDest && j==indexJDest && !moveTrackerBlack.contains(e))
						{	
							checkR = 1;
							if(p==1)setPiecesAgainBlack(i,j,bR,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,j,bQ,indexI,indexJ);
							if(p==9)//setPiecesAgainBlack(i,j,bK,indexI,indexJ);
							{//This move is just for castling
								
								if(checkForCastling==1)
								{
									int bbb = ifCheckDiagonal(bKI,bKJ+2);
									int ccc =  ifCheckKnight(bKI,bKJ+2);
									if(bbb!=2 && ccc!=2)
									{ 
										setPiecesAgainBlack(i,j,bK,indexI,indexJ);
									}
									else {checkR=0;}
								}
								if(checkForCastling!=1)
								{

										setPiecesAgainBlack(i,j,bK,indexI,indexJ);

								}								
							}
							//overlap();
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
						String c = "";
						if(i==indexIDest && j!=indexJDest)c = al1 + al2;
						String a3 = Integer.toString(indexIDest);
						String a4 = Integer.toString(indexJDest);
						String e = a3 + a4;
						
						//if white pieces this if statement works
						if( (p==0 || p==3 || p==4) && (moveTracker.contains(c) || moveTrackerBlack.contains(c)) && j!=q )
							{checkR=3;break;}

						//if black pieces this if statement works
						if( (p==1 || p==8 || p==9) && (moveTracker.contains(c) || moveTrackerBlack.contains(c)) && j!=q )
							{
							checkR=3;break;
							}						
						
						if( (p==0 || p==3 || p==4) && i==indexIDest && j==indexJDest && !moveTracker.contains(e))
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
							if(p==4)
							{	////This move is just for castling
								if(checkForCastling==1)
								{
									int bbb = ifCheckDiagonal(wKI,wKJ-2);
									int ccc =  ifCheckKnight(wKI,wKJ-2);
									if(bbb!=2 && ccc!=2)
									{ 
										setPiecesAgain(i,j,wK,indexI,indexJ);
									}
									else {checkR=0;}
								}
								if(checkForCastling!=1)
								{
										setPiecesAgain(i,j,wK,indexI,indexJ);
								}
							}
							//overlap();
						}
						
						if((p==1 || p==8 || p==9) && i==indexIDest && j==indexJDest && !moveTrackerBlack.contains(e))
						{	
							checkR = 1;
							if(p==1)setPiecesAgainBlack(i,j,bR,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,j,bQ,indexI,indexJ);
							if(p==9)//setPiecesAgainBlack(i,j,bK,indexI,indexJ);
							{
								if(checkForCastling==1)
								{
									int bbb = ifCheckDiagonal(bKI,bKJ-2);
									int ccc =  ifCheckKnight(bKI,bKJ-2);
									if(bbb!=2 && ccc!=2)
									{ 
										setPiecesAgainBlack(i,j,bK,indexI,indexJ);
									}
									else {checkR=0;}
								}
								if(checkForCastling!=1)
								{

										setPiecesAgainBlack(i,j,bK,indexI,indexJ);

								}								
							}
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
						String c = "";
						if(i!=indexIDest && j==indexJDest)c = al1 + al2;
						String a3 = Integer.toString(indexIDest);
						String a4 = Integer.toString(indexJDest);
						String e = a3 + a4;
						
						if( (p==0 || p==3 || p==4) && (moveTracker.contains(c) || moveTrackerBlack.contains(c)) && i!=pr )
						{checkR=3; j=100+j;i=100+1;break;}		

						if( (p==1 || p==8 || p==9) && (moveTracker.contains(c) || moveTrackerBlack.contains(c)) && i!=pr )
						{
						checkR=3; j=100+j;i=100+1;break;
						}						
						
						if( (p==0 || p==3 || p==4) &&  i==indexIDest && j==indexJDest && !moveTracker.contains(e) )
						{	
							checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);
							if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
							if(p==4)//setPiecesAgain(i,j,wK,indexI,indexJ);								
							{
									setPiecesAgain(i,j,wK,indexI,indexJ);

							}
						}
						
						if( (p==1 || p==8 || p==9) &&  i==indexIDest && j==indexJDest)
						{	
							checkR = 1;
							if(p==1)setPiecesAgainBlack(i,j,bR,indexI,indexJ);
							if(p==8)setPiecesAgainBlack(i,j,bQ,indexI,indexJ);
							if(p==9)//setPiecesAgainBlack(i,j,bK,indexI,indexJ);	
							{
									setPiecesAgainBlack(i,j,bK,indexI,indexJ);
							}
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
						String c = "";
						if(i!=indexIDest && j==indexJDest)c = al1 + al2;
						String a3 = Integer.toString(indexIDest);
						String a4 = Integer.toString(indexJDest);
						String e = a3 + a4;
			
						if((p==0 || p==3 || p==4) && (moveTracker.contains(c) || moveTrackerBlack.contains(c)) && i!=pr )
						{checkR=3; j=100+j;i=-5;break;}		

						if( (p==1 || p==8 || p==9) && (moveTracker.contains(c) || moveTrackerBlack.contains(c)) && i!=pr )
						{checkR=3; j=100+j;i=-5;break;}		
						
						if( (p==0 || p==3 || p==4) &&  i==indexIDest && j==indexJDest && !moveTracker.contains(e) )
						{	checkR = 1;
							if(p==0)setPiecesAgain(i,j,wR,indexI,indexJ);if(p==3)setPiecesAgain(i,j,wQ,indexI,indexJ);
							if(p==4)//setPiecesAgain(i,j,wK,indexI,indexJ);
							{
									setPiecesAgain(i,j,wK,indexI,indexJ);
							}
						}
						
						if( (p==1 || p==8 || p==9) &&  i==indexIDest && j==indexJDest && !moveTrackerBlack.contains(e) )
						{	checkR = 1;
							if(p==1)setPiecesAgainBlack(i,j,bR,indexI,indexJ);if(p==8)setPiecesAgainBlack(i,j,bQ,indexI,indexJ);
							if(p==9)//setPiecesAgainBlack(i,j,bK,indexI,indexJ);
							{
									setPiecesAgainBlack(i,j,bK,indexI,indexJ);
							}
						}	
					}
				}				
		}

	if(checkR==1)
		{
		if(p==0)
		{
			if(indexI==7 && indexJ==0)whiteRookCastlingLeft++;
			if(indexI==7 && indexJ==7)whiteRookCastlingRight++;
		}
		if(p==1)
		{
			if(indexI==0 && indexJ==0)blackRookCastlingLeft++;
			if(indexI==0 && indexJ==7)blackRookCastlingRight++;			
		}
			
		
			String g1 = Integer.toString(indexI);
			String g2 = Integer.toString(indexJ);		
			String g = g1+g2;
			if( (p==0 || p==3 || p==4) && moveTracker.contains(g) )moveTracker.remove(g);
			if( (p==1 || p==8 || p==9) && moveTrackerBlack.contains(g) )moveTrackerBlack.remove(g);			
			if( boardsNonEditable[indexI][indexJ]=="##" )boards[indexI][indexJ]="## ";
		}
	
	if(checkR==0 || checkR==3)
		{
		if(p==0 || p == 1){//added p ==1 for black rook
			return -1;
		}
		if(p==3)ret = 6;	//WHITE QUIEEN
		if(p==4)ret = 6;	//WHITE KING
		if(p==8)ret = 6;	//black QUIEEN
		if(p==9)ret = 6;	//black KING	
		}
	return ret;
}



//This method sets the new piece on the board,clears it and adds piece to arraylist
static int wKI = 7;
static int wKJ = 4;
static int bKI = 0;
static int bKJ = 0;

/**
 * Changes the space occupied by a white piece. Calls overlap() to check if move is a killing
 * move or not. 
 * @param i, x coordinate of origin space
 * @param j, y coordinate of origin space
 * @param piece, piece to be moved, 
 * @param indexII, x coordinate of destination space
 * @param indexJJ, y coordinate of destination space
 */
public void setPiecesAgain(int i,int j,String piece,int indexII,int indexJJ)
{
	
	if(piece.equals(wK))
	{
		wKI = i;wKJ = j;
	}
	
	if(piece.equals(bK))
	{
		bKI = i;bKJ = j;
	}	
	
	allMoves.add(getInputString());
	overlap();
	String io = Integer.toString(i);
	String jo = Integer.toString(j);
	boards[i][j]=piece;
	moveTracker.add(io + jo);
	boards[indexII][indexJJ]="   ";
}

/**
 * Changes the space occupied by a black piece. Calls overlap() to check if move is a killing
 * move or not. 
 * @param i, x coordinate of origin space
 * @param j, y coordinate of origin space
 * @param piece, piece to be moved, 
 * @param indexII, x coordinate of destination space
 * @param indexJJ, y coordinate of destination space
 */
public void setPiecesAgainBlack(int i,int j,String piece,int indexII,int indexJJ)
{
	allMoves.add(getInputString());
	overlap();
	String io = Integer.toString(i);
	String jo = Integer.toString(j);
	boards[i][j]=piece;
	moveTrackerBlack.add(io + jo);
	boards[indexII][indexJJ]="   ";
}
 
/**
 * Checks if the king is in check from up, down, left, right.
 * @param p, 0 for white king, 1 for black king
 * @param indexI, x coordinate of king to be checked
 * @param indexJ, y coordinate of king to be checked
 * @return int, 1 if not in check, 2 if in check
 */
public int ifCheck(int p,int indexI,int indexJ)
{
//indexI current postion, indexI ,indexY,

	//returns 7 if WB BB bQ wQ exists so checkmate can be easier to implements	
// ##################For updownleftright - ROOK AND QUEEN MOVES
//checks up
int j = indexJ;
for(int i = indexI-1; i>=0; i--) 
{	String al1 = Integer.toString(i);String al2 = Integer.toString(j);String c = al1 + al2;	
	if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
	{	
		//White Kings CHECK
		if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][j].equals(bR) || boards[i][j].equals(bQ)) {System.out.println("Check");return 7;} }
		//Black Kings CHECK
		if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][j].equals(wR) || boards[i][j].equals(wQ)){System.out.println("Check");return 7;}}		
		if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=-1;
		if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=-1;
	}
}

//checks down
for(int i = indexI+1; i<8; i++)
{
	String al1 = Integer.toString(i);String al2 = Integer.toString(j);String c = al1 + al2;	
	if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
	{	
		//White Kings CHECK
		if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][j].equals(bR) || boards[i][j].equals(bQ)){System.out.println("Check");return 7;}}
		//Black Kings CHECK
		if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][j].equals(wR) || boards[i][j].equals(wQ)){System.out.println("Check");return 7;}}		
		if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=-1;
		if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=-1;
	}
}

int i = indexI;
//checks RIGHT
for(j = indexJ+1; i<8; i++)
{	String al1 = Integer.toString(j);String al2 = Integer.toString(i);String c = al1 + al2;	
	if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
	{	
		//White Kings CHECK
		if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][j].equals(bR) || boards[i][j].equals(bQ)){System.out.println("Check");return 7;}}
		//Black Kings CHECK
		if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][j].equals(wR) || boards[i][j].equals(wQ)){System.out.println("Check");return 7;}}		
		if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=-1;
		if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=-1;
	}
}

//checks left
for(j = indexJ-1; i>=0; i--)
{	String al1 = Integer.toString(j);String al2 = Integer.toString(i);String c = al1 + al2;	
	if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
	{	
		//White Kings CHECK
		if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][j].equals(bR) || boards[i][j].equals(bQ))System.out.println("Check");}
		//Black Kings CHECK
		if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][j].equals(wR) || boards[i][j].equals(wQ))System.out.println("Check");}		
		if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=-1;
		if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=-1;
	}
}	
///////////////////////////////////////////////////////////////
	
return 1;
}

/**
 * Checks if the king is in check from up diagonal, down diagonal, left diagonal, right diagonal.
 * @param p, 0 for white king, 1 for black king
 * @param indexI, x coordinate of king to be checked
 * @param indexJ, y coordinate of king to be checked
 * @return int, 1 if not in check, 2 if in check
 */
public int ifCheckDiagonal(int indexI,int indexJ)
{
	//returns 2 if WB BB bQ wQ exists so checkmate can be easier to implements
	int i=0;
	//moves upper left diagonal
	int d=indexJ;
	for( i=indexI; i>=0; i--)
	{	String al3 ="";	String al4 = "";if(i!=indexI)al3 = Integer.toString(i);if(d!=indexJ)al4 = Integer.toString(d);String e ="" + al3 + al4;
		if( moveTracker.contains(e) || moveTrackerBlack.contains(e) )
		{	//White Kings CHECK
			if(moveTrackerBlack.contains(e) && boards[wKI][wKJ].equals(wK))
			{	if(boards[i][d].equals(bB) || boards[i][d].equals(bQ)) {System.out.println("Check");return 2;}break;}
			//Black Kings CHECK
			if(moveTracker.contains(e) && boards[bKI][bKJ].equals(bK))
			{	if(boards[i][d].equals(wB) || boards[i][d].equals(wQ)){System.out.println("Check");return 2;}break;}									
			if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(e))i=-1;	if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(e))i=-1;}						
		d--;
	}				

	//upper andright movements
	d=indexJ; 
	for( i=indexI; i>=0; i--)
	{	String al3 ="";	String al4 = "";if(i!=indexI)al3 = Integer.toString(i);if(d!=indexJ)al4 = Integer.toString(d);String e ="" + al3 + al4;
		if( moveTracker.contains(e) || moveTrackerBlack.contains(e) )
		{	//White Kings CHECK
			if(moveTrackerBlack.contains(e) && boards[wKI][wKJ].equals(wK))	{if(boards[i][d].equals(bB) || boards[i][d].equals(bQ)){System.out.println("Check");return 2;}break;}
			//Black Kings CHECK
			if(moveTracker.contains(e) && boards[bKI][bKJ].equals(bK)){	if(boards[i][d].equals(wB) || boards[i][d].equals(wQ)){System.out.println("Check");return 2;}break;}									
			if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(e))i=-1;	if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(e))i=-1;
		}	
		d++;
	}					
			
			//This moves down and left
	d = indexJ ;
	for( i=indexI; i<=7; i++)
	{	String al3 ="";	String al4 = "";if(i!=indexI)al3 = Integer.toString(i);if(d!=indexJ)al4 = Integer.toString(d);String e ="" + al3 + al4;
		if( moveTracker.contains(e) || moveTrackerBlack.contains(e) )
		{	//White Kings CHECK
			if(moveTrackerBlack.contains(e) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bB) || boards[i][d].equals(bQ)){System.out.println("Check");return 2;} break;}
			//Black Kings CHECK
			if(moveTracker.contains(e) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wB) || boards[i][d].equals(wQ)){System.out.println("Check");return 2;}break;}									
			if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(e))i=-1;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(e))i=-1;
		}		
		d--;
	}
	//This moves down and right
	d = indexJ;
	for( i=indexI; i<=7; i++)
	{	String al3 ="";	String al4 = "";if(i!=indexI)al3 = Integer.toString(i);if(d!=indexJ)al4 = Integer.toString(d);String e ="" + al3 + al4;
		if( moveTracker.contains(e) || moveTrackerBlack.contains(e) )
		{	//White Kings CHECK
			if(moveTrackerBlack.contains(e) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bB) || boards[i][d].equals(bQ)){System.out.println("Check");return 2;}break;}
			//Black Kings CHECK
			if(moveTracker.contains(e) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wB) || boards[i][d].equals(wQ)){System.out.println("Check");return 2;}break;}									
			if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(e))i=-1;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(e))i=-1;
		}	
		d++; 
	}							

	return 1;
}

/**
 * Checks if the king is in check from any kinghts.
 * @param p, 0 for white king, 1 for black king
 * @param indexI, x coordinate of king to be checked
 * @param indexJ, y coordinate of king to be checked
 * @return int, 1 if not in check, 2 if in check
 */
public int ifCheckKnight(int indexI,int indexJ)
{
	int i=indexI;
	int d=indexJ;
	String al1 = "";
	String al2 = "";
	int indexIDest = 0;
	int indexJDest = 0;


	indexIDest= indexI - 2;	indexJDest = indexJ - 1;
		if(indexI>indexIDest && indexI-2==indexIDest )
		{	//up and left index i is being manipulated here
			for( i=indexI-2; i==indexIDest; i--)
			{	for( d=indexJ-1; d==indexJDest;d--)
				{	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
					{	//White Kings CHECK
						if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bN)){System.out.println("Check");return 2;}break;}
						//Black Kings CHECK
						if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wN)){System.out.println("Check");return 2;}break;}
						if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=10;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=10;
					}
				}
			}
			//up and right
			//System.out.println(x);
			indexIDest= indexI - 2;	indexJDest = indexJ + 1;
			for( i=indexI-2; i==indexIDest; i--)
			{	for( d=indexJ+1; d==indexJDest;d--)
				{	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
					{	//White Kings CHECK
						if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bN)){System.out.println("Check");return 2;}break;}
						//Black Kings CHECK
						if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wN)){System.out.println("Check");return 2;}break;}
						if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=10;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=10;
					}
				}
			}
		}
		indexIDest= indexI + 2;	indexJDest = indexJ - 1;
		if(indexI<indexIDest && indexI+2==indexIDest )
		{	//up and left index i is being manipulated here
			for( i=indexI+2; i==indexIDest; i--)
			{	for( d=indexJ-1; d==indexJDest;d--)
				{	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
					{	//White Kings CHECK
						if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bN)){System.out.println("Check");return 2;}break;}
						//Black Kings CHECK
						if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wN)){System.out.println("Check");return 2;}break;}
						if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=10;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=10;
					}
				}
			}
			//down and right
			//System.out.println(x);
			indexIDest= indexI + 2;	indexJDest = indexJ + 1;
			for( i=indexI+2; i==indexIDest; i--)
			{	for( d=indexJ+1; d==indexJDest;d--)
				{	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
					{	//White Kings CHECK
						if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bN)){System.out.println("Check");return 2;}break;}
						//Black Kings CHECK
						if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wN)){System.out.println("Check");return 2;}break;}
						if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=10;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=10;
					}
				}
			}
		}

		indexIDest= indexI - 1;	indexJDest = indexJ - 2;
		if(indexI>indexIDest && indexI-1==indexIDest )
		{	//up and left index i is being manipulated here
			for( i=indexI-1; i==indexIDest; i--)
			{	for( d=indexJ-2; d==indexJDest;d--)
				{	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
					{	//White Kings CHECK
						if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bN)){System.out.println("Check");return 2;}break;}
						//Black Kings CHECK
						if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wN)){System.out.println("Check");return 2;}break;}
						if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=10;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=10;
					}
				}
			}
			//down and right
			//System.out.println(x);
			indexIDest= indexI - 1;	indexJDest = indexJ + 2;
			for( i=indexI-1; i==indexIDest; i--)
			{	for( d=indexJ+2; d==indexJDest;d--)
				{	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
					{	//White Kings CHECK
						if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bN)){System.out.println("Check");return 2;}break;}
						//Black Kings CHECK
						if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wN)){System.out.println("Check");return 2;}break;}
						if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=10;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=10;
					}
				}
			}
		}

		indexIDest= indexI + 1;	indexJDest = indexJ - 2;
		if(indexI<indexIDest && indexI+1==indexIDest )
		{	//up and left index i is being manipulated here
			for( i=indexI+1; i==indexIDest; i--)
			{	for( d=indexJ-2; d==indexJDest;d--)
				{	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
					{	//White Kings CHECK
						if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bN)){System.out.println("Check");return 2;}break;}
						//Black Kings CHECK
						if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wN)){System.out.println("Check");return 2;}break;}
						if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=10;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=10;
					}
				}
			}
			//down and right
			//System.out.println(x);
			indexIDest= indexI + 1;	indexJDest = indexJ + 2;
			for( i=indexI+1; i==indexIDest; i--)
			{	for( d=indexJ+2; d==indexJDest;d--)
				{	al1 = Integer.toString(indexIDest);al2 = Integer.toString(indexJDest);String c = al1 + al2;
					if( moveTracker.contains(c) || moveTrackerBlack.contains(c) )
					{	//White Kings CHECK
						if(moveTrackerBlack.contains(c) && boards[wKI][wKJ].equals(wK)){if(boards[i][d].equals(bN)){System.out.println("Check");return 2;}break;}
						//Black Kings CHECK
						if(moveTracker.contains(c) && boards[bKI][bKJ].equals(bK)){if(boards[i][d].equals(wN)){System.out.println("Check");return 2;}break;}
						if(boards[wKI][wKJ].equals(wK) && moveTracker.contains(c))i=10;if(boards[bKI][bKJ].equals(bK) && moveTrackerBlack.contains(c))i=10;
					}
				}
			}
		}


	return 1;
}

/**
 * Performs castling move if the move meets valid requirements, for black and white
 * @param indexId, x coordinate of origin space
 * @param indexJd, y coordinate of origin space
 * @param indexI, x coordinate of destination space
 * @param indexJ, y coordinate of destination space
 * @param p, 0 for white king, 1 for black king
 */
public void castling(int indexId,int indexJd,int indexI, int indexJ,int p)
{
	if(indexJ-2==indexJd && p==0) // moves to left
	{	boards[7][3]=wR;moveTracker.add("73");moveTracker.remove("70");boards[7][0]="   ";if( boardsNonEditable[7][0]=="##" )boards[7][0]="## ";}
	
	if(indexJ+2==indexJd && p==0) // moves to left
	{	boards[7][5]=wR;moveTracker.add("75");moveTracker.remove("77");boards[7][7]="   ";if( boardsNonEditable[7][7]=="##" )boards[7][7]="## ";}	

	if(indexJ-2==indexJd && p==1) // moves to left
	{	boards[0][3]=bR;moveTracker.add("03");moveTracker.remove("00");boards[0][0]="   ";	if( boardsNonEditable[0][0]=="##" )boards[0][0]="## ";	}
	
	if(indexJ+2==indexJd && p==1) // moves to left
	{	boards[0][5]=bR;moveTracker.add("05");moveTracker.remove("07");boards[0][7]="   ";if( boardsNonEditable[0][7]=="##" )boards[0][7]="## ";}		
}

/**
 * Performs empassant move if the move meets valid requirements, for black and white
 * @param indexId, x coordinate of origin space
 * @param indexJd, y coordinate of origin space
 * @param indexI, x coordinate of destination space
 * @param indexJ, y coordinate of destination space
 * @param p, 0 for white pawn, 1 for black pawn
 */
public void enpassant(int indexId,int indexJd,int indexI, int indexJ,int p)
{
	if((indexJ-1==indexJd) || (indexJ+1==indexJd) && p==0) // moves to left
	{
	boards[indexId+1][indexJd] ="   ";
	int iD = indexId+1;
	String aa = "" + iD + indexJd;
	String bb = "" + indexId + indexJd;
	moveTracker.add(bb);
	moveTracker.remove(aa);
	boards[indexId+1][indexJd]="   ";
	if( boardsNonEditable[indexId+1][indexJd]=="##" )
		boards[indexId+1][indexJd]="## ";
	if( boardsNonEditable[indexI][indexJ]=="##" )
		boards[indexI][indexJ]="## ";
	}

	if((indexJ-1==indexJd) || (indexJ+1==indexJd) && p==1) // moves to left
	{

	boards[indexId-1][indexJd] ="   ";
	int iD = indexId+1;
	String aa = "" + iD + indexJd;
	String bb = "" + indexId + indexJd;
	moveTrackerBlack.add(bb);
	moveTrackerBlack.remove(aa);
	boards[indexId+1][indexJd]="   ";
	if( boardsNonEditable[indexId+1][indexJd]=="##" )
		boards[indexId+1][indexJd]="## ";
	if( boardsNonEditable[indexI][indexJ]=="##" )
		boards[indexI][indexJ]="## ";
	}		
}


}
