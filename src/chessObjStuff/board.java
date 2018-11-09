package chessObjStuff;

/**
 * 
 * 
 * @version 1.0
 * Displays the board and sets the pieces
 *
 */
public class board implements typeInter {


static String indexForObj1 = "";
static String indexForObj2 = "";
static String inputString = "";

/**
 * Shows all pieces in play
 */
static String[][] boards = new String[9][9];	

/**
 * To set the black pieces on the board.
 */
String[][] boardsNonEditable = new String[9][9]; //This one is a blank grid with blackspots to check which
//index has a black spot so then we can add blackspots on the static array

//public chessPieceInfo(String piece, String color,int id,int firstMove)
chessPieceInfo bKObj = new chessPieceInfo("bK ","black",0,0);
chessPieceInfo bQObj = new chessPieceInfo("bQ ","black",0,0);
chessPieceInfo bRObj = new chessPieceInfo("bR ","black",0,0);
chessPieceInfo bNObj = new chessPieceInfo("bN ","black",0,0);
chessPieceInfo bBObj = new chessPieceInfo("bB ","black",0,0);
chessPieceInfo bPObj0 = new chessPieceInfo("bp ","black",10,0); 
chessPieceInfo bPObj1 = new chessPieceInfo("bp ","black",11,0);
chessPieceInfo bPObj2 = new chessPieceInfo("bp ","black",62,0);
chessPieceInfo bPObj3 = new chessPieceInfo("bp ","black",63,0);
chessPieceInfo bPObj4 = new chessPieceInfo("bp ","black",64,0);
chessPieceInfo bPObj5 = new chessPieceInfo("bp ","black",65,0); 
chessPieceInfo bPObj6 = new chessPieceInfo("bp ","black",66,0); 
chessPieceInfo bPObj7 = new chessPieceInfo("bp ","black",67,0); 


chessPieceInfo wKObj = new chessPieceInfo("wK ","white",0,0);
chessPieceInfo wQObj = new chessPieceInfo("wQ ","white",0,0);
chessPieceInfo wRObj = new chessPieceInfo("wR ","white",0,0);
chessPieceInfo wNObj = new chessPieceInfo("wN ","white",0,0);
chessPieceInfo wBObj = new chessPieceInfo("wB ","white",0,0);
chessPieceInfo wPObj0 = new chessPieceInfo("wp ","white",60,0);
chessPieceInfo wPObj1 = new chessPieceInfo("wp ","white",61,0);
chessPieceInfo wPObj2 = new chessPieceInfo("wp ","white",62,0);
chessPieceInfo wPObj3 = new chessPieceInfo("wp ","white",63,0);
chessPieceInfo wPObj4 = new chessPieceInfo("wp ","white",64,0);
chessPieceInfo wPObj5 = new chessPieceInfo("wp ","white",65,0); 
chessPieceInfo wPObj6 = new chessPieceInfo("wp ","white",66,0); 
chessPieceInfo wPObj7 = new chessPieceInfo("wp ","white",67,0); 

String bR = bRObj.piece;
String bN = bNObj.piece;
String bQ = bQObj.piece;
String bB = bBObj.piece;
String bK = bKObj.piece;

String bP0 = bPObj0.piece;
String bP1 = bPObj1.piece;
String bP2 = bPObj2.piece;
String bP3 = bPObj3.piece;
String bP4 = bPObj4.piece;
String bP5 = bPObj5.piece;
String bP6 = bPObj6.piece;
String bP7 = bPObj7.piece;

String wR = wRObj.piece;
String wN = wNObj.piece;
String wQ = wQObj.piece; //"wQ ";
String wB = wBObj.piece;
String wK = wKObj.piece;

String wP0 = wPObj0.piece;
String wP1 = wPObj1.piece;
String wP2 = wPObj2.piece;
String wP3 = wPObj3.piece;
String wP4 = wPObj4.piece;
String wP5 = wPObj5.piece;
String wP6 = wPObj6.piece;
String wP7 = wPObj7.piece;

/**
 * Sets up how the board will look
 */
public board()
{
	//ChessObjClass rook = new ChessObjClass();
	for(int i=0; i<9; i++)
	{
		for(int j=0;j<9;j++)
		{
			boards[i][j] = "";
			boardsNonEditable[i][j] = "";			
		}
	}	
	 
	
	for(int i=0; i<8; i++)
	{
		for(int j=0;j<8;j++)
		{
			boards[i][j] = "   ";
			boardsNonEditable[i][j] = " ";
		}
	}		
	
	//SHOWS NUMBER ON BOARD
	int c = 8;
	for(int i=0; i<8; i++)
	{
		for(int j=8;j<9;j++)
		{
			boards[i][j] = " " + Integer.toString(c);
			boardsNonEditable[i][j] = " " + Integer.toString(c);
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
				boards[i][j] =" a ";
				boardsNonEditable[i][j] ="a";
				break;
			case 1:
				boards[i][j] =" b ";
				boardsNonEditable[i][j] ="b ";
				break;
			case 2:
				boards[i][j] =" c ";		
				boardsNonEditable[i][j] ="c ";		
				break;
			case 3:
				boards[i][j] =" d ";
				boardsNonEditable[i][j] ="d ";
				break;
			case 4:
				boards[i][j] =" e ";	
				boardsNonEditable[i][j] ="e ";	
				break;
			case 5:
				boards[i][j] =" f ";	
				boardsNonEditable[i][j] ="f ";	
				break;
			case 6:
				boards[i][j] =" g ";	
				boardsNonEditable[i][j] ="g ";	
				break;
			case 7:
				boards[i][j] =" h";	
				boardsNonEditable[i][j] ="h ";	
				break;
			default:;
			}
			
		}
	}

	setBlackSpots();	
	 //showBoard();
}
 
/**
 * Sets the black on the board
 */
public void setBlackSpots()
{
	for(int i=0; i<8; i++)
	{
		if(i%2==0)
		{
			for(int j=1;j<8;j=j+2)
			{
				boards[i][j] = "## "; 
				boardsNonEditable[i][j]  = "##"; 
			}			
		}
		
		if(i%2!=0)
		{
			for(int j=0;j<8;j=j+2)
			{
				boards[i][j] = "## ";
				boardsNonEditable[i][j]  = "##";
			}			
		}		
			
	}	
}

/**
 * Displays the board with all pieces on it
 */
public void showBoard()
{
	for(int i=0; i<9; i++)
	{
		for(int j=0;j<9;j++)
		{
			System.out.print( boards[i][j]);
		}
		System.out.println();
	}	
}

/**
 * Initializes each index on the board to a specific piece. Called ChessObjClass constructor
 * @param The piece to begin the initialization
 */
public void initializePiece(String a)
{
////// <-- COMMENT THIS
//This methods sets up the very first places on the board (e.g how pieces are set up on the examples)

	if(a.equals("wR"))
		{
		//boards[7][0] = null;	
		
		
		//boards[1][5] = wR;
		//boards[0][0] = bK;
		
		boards[7][0] = wR;
		boards[7][1] = wN;// "wN ";	
		boards[7][2] = wB;// "wB ";		
		boards[7][3] = wQ;// "wQ "; 
		boards[7][4] = wK;// "wK "; 	
		boards[7][5] = wB;// "wB ";		
		boards[7][6] = wN;		
		boards[7][7] = wR;
		
		boards[0][0] = bR;// "wN ";	
		boards[0][1] = bN;// "wN ";	
		boards[0][2] = bB;// "wB ";		
		boards[0][3] = bQ;// "wQ "; 
		boards[0][4] = bK;// "wQ "; 	
		boards[0][5] = bB;// "wB ";		
		boards[0][6] = bN;		
		boards[0][7] = bR;
	

		boards[6][0] = wPObj0.getName();		
		boards[6][1] = wPObj1.getName();		
		boards[6][2] = wPObj2.getName();
		boards[6][3] = wPObj3.getName();
		boards[6][4] = wPObj4.getName();		
		boards[6][5] = wPObj5.getName();	
		boards[6][6] = wPObj6.getName();	
		boards[6][7] = wPObj7.getName();
		
		boards[1][0] = bPObj0.getName();		
		boards[1][1] = bPObj1.getName();		
		boards[1][2] = bPObj2.getName();
		boards[1][3] = bPObj3.getName();
		boards[1][4] = bPObj4.getName();		
		boards[1][5] = bPObj5.getName();	
		boards[1][6] = bPObj6.getName();	
		boards[1][7] = bPObj7.getName();			

		//boards[6][0] = "wp ";
		//boards[7][7] = null;
		}
}
/*
public void move(int a)
{ 
	
}
*/

/**
 * Gets the object reference for each pieces. 
 * @param wP, piece to get object reference for
 * @param aa, x coordinate of piece space
 * @param bb, y coordinate of piece space
 * @return ChessPieceInfo object
 */
public chessPieceInfo getObject(String wP,String aa, String bb)
{
//This method is created so we can return the object reference in the other class to access specically the id of that piece - in this case each pawn has a sep id

	chessPieceInfo a = new chessPieceInfo();
	
	String abcd = "" + aa + "" + bb;
	
	int IDindex = Integer.parseInt(abcd);
	
	//Note: the numbers in the string indicate the location and that is how We get their ID's - if the locat
	
	//wP.equals(wP1) )//wP.equals("60") )
	if( wPObj0.getID()==IDindex )a = wPObj0;
	if( bPObj0.getID()==IDindex )a = bPObj0;	
	
	//wP.equals(wP1) )//wP.equals("61") )
	if( wPObj1.getID()==IDindex )a = wPObj1;
	if( bPObj1.getID()==IDindex )a = bPObj1;		
	
	//wP.equals(wP1) )//wP.equals("62") )
	if( wPObj2.getID()==IDindex )a = wPObj2;
	if( bPObj2.getID()==IDindex )a = bPObj2;		

	//wP.equals(wP1) )//wP.equals("63") )
	if( wPObj3.getID()==IDindex )a = wPObj3;
	if( bPObj3.getID()==IDindex )a = bPObj3;
	
	//wP.equals(wP1) )//wP.equals("64") )
	if( wPObj4.getID()==IDindex )a = wPObj4;
	if( bPObj4.getID()==IDindex )a = bPObj4;			

	//wP.equals(wP1) )//wP.equals("65") )
	if( wPObj5.getID()==IDindex )a = wPObj5;
	if( bPObj5.getID()==IDindex )a = bPObj5;		
	
	//wP.equals(wP1) )//wP.equals("66") )
	if( wPObj6.getID()==IDindex )a = wPObj6;
	if( bPObj6.getID()==IDindex )a = bPObj6;		
	
	//wP.equals(wP1) )//wP.equals("67") )
	if( wPObj7.getID()==IDindex )a = wPObj7;
	if( bPObj7.getID()==IDindex )a = bPObj7;			
	
	return a;
}

/**
 * Checks if space passed in is occupied by a piece or not
 * @param a, x coordinate of space
 * @param b, y coordinate of space
 * @return boolean
 */
public boolean isPiece(int a,int b)
{
//This method checks if the given position is any of the pieces or not

	if( 
		((boards[a][b]).equals(wR)) || ((boards[a][b]).equals(wN)) || ((boards[a][b]).equals(wB)) || ((boards[a][b]).equals(wQ)) 
		|| ((boards[a][b]).equals(wK)) || ((boards[a][b]).equals(wP0) ) || ((boards[a][b]).equals(wP1) ) || ((boards[a][b]).equals(wP2) )
		|| ((boards[a][b]).equals(wP3) ) || ((boards[a][b]).equals(wP4) ) || ((boards[a][b]).equals(wP5) ) || ((boards[a][b]).equals(wP6) )
		|| ((boards[a][b]).equals(wP7) )
		|| ((boards[a][b]).equals(bR)) || ((boards[a][b]).equals(bN)) || ((boards[a][b]).equals(bB)) || ((boards[a][b]).equals(bQ)) 
		|| ((boards[a][b]).equals(bK)) || ((boards[a][b]).equals(bP0) ) || ((boards[a][b]).equals(bP1) ) || ((boards[a][b]).equals(bP2) )
		|| ((boards[a][b]).equals(bP3) ) || ((boards[a][b]).equals(bP4) ) || ((boards[a][b]).equals(bP5) ) || ((boards[a][b]).equals(bP6) )
		|| ((boards[a][b]).equals(bP7) ) 	
			)
	{
		return true; 
	}
	
	/*
	if( ((boards[a][b]).equals(bR)) || ((boards[a][b]).equals(bQ)) || ((boards[a][b]).equals(bN)) || ((boards[a][b]).equals(bB)) )
	{
		return true;
	} 
	*/
	
	return false;
}

/**
 * Returns what type of piece is on passed in place
 * @param a, x coordinate of space
 * @param b, y coordinate of space
 * @return String containing name of piece
 */
public String checkPiece(int a,int b)
{
//This method returns the string that contains name of the piece on the index so we know what piece is going to move
//This method is used in Translator() method

	String c = "";
	 if( isPiece(a,b) )c = boards[a][b] ; //If the selected PIECE exists on the board(any piece) then it is copied to a string and returned
	return c;
}

/**
 * Returns index from the board(in string) - does not check whether its a piece or a blank spot
 * @return String
 */
public String getPiece() //THIS METHOD IS USED IN chessObjClass 
{
//This method RETURNS the piece that is going to be moved - made to be used in other class
//This would get "WR,WQ" in chess piece class

String piece = piece2;
return piece;
}

/**
 * A static variable to return a single piece info between classes
 */
static String piece2 = ""; //
//This variable is used in Translator(), whichever the current chosen piece is, is set to this variable - because it is static it would be visible in other classes

/**
 * Returns a string representation of the index of pieces on board
 * @return String
 */
public String getCoordinates()
{
//This method returns a string type of length 4> (Its the input from terminal converted e.g "e4 e5" -> "44 34")
//This method is used in EVERY MOVING METHOD in ChessObjClass

	String d = routeForGetPos;
	return d;
}

static String routeForGetPos = "";
//Converts the string to actual coordinates on the board

/**
 * Converts a character from String abc at index b into an integer
 * @param abc, String representation of coordinates
 * @param b, index to convert into integer
 * @return int
 */
public int intcordinatesfromString(String abc,int b)
{
//converts string to int to get the coordinates
//String (abc) the is the input string e.g "e4 e5",int b is the charat (0,1 or 3,4)

	char s1 = abc.charAt(b); //b could be 0,1,2,3
	String ss1 = String.valueOf(s1);
	int ent1 = Integer.parseInt(ss1);
	
	return ent1;
}

/**
 * Returns string representation of the movement requested by the player
 * @return
 */
public String getInputString() 
{
	String route2 = inputString;
	return route2;
}

int posForJ;
int posForI;
int posFors1;
int posFors2;

/**
 * Converts the route input from String into an index on the board
 * @param route
 * @return String representation of indexes to move between
 *  
 */
public String routeTranslation(String route)
{
//This method converts Indices to string format -> e1 e2 = 65 64
//and returns that index number as string that can be
//converted into the position for movement

	//Note: Change this to 3 and 4 later on

	char s1 = route.charAt(0); 
	char s2 = route.charAt(1);

	indexForObj1 = "" + s1;
	indexForObj1 = "" + s2;	
	
	// 's1' is J
	if(s1=='a')posFors1 = 0;
	if(s1=='b')posFors1 = 1;
	if(s1=='c')posFors1 = 2;
	if(s1=='d')posFors1 = 3;
	if(s1=='e')posFors1 = 4;
	if(s1=='f')posFors1 = 5;
	if(s1=='g')posFors1 = 6;
	if(s1=='h')posFors1 = 7;

	
	// 's2' is i
	if(s2=='1')posFors2 = 7;
	if(s2=='2')posFors2 = 6;
	if(s2=='3')posFors2 = 5;
	if(s2=='4')posFors2 = 4;
	if(s2=='5')posFors2 = 3;
	if(s2=='6')posFors2 = 2;
	if(s2=='7')posFors2 = 1;
	if(s2=='8')posFors2 = 0;

	
	char a = route.charAt(3); 
	char b = route.charAt(4);
	
	// 'a' is J
	if(a=='a')posForJ = 0;
	if(a=='b')posForJ = 1;
	if(a=='c')posForJ = 2;
	if(a=='d')posForJ = 3;
	if(a=='e')posForJ = 4;
	if(a=='f')posForJ = 5;
	if(a=='g')posForJ = 6;
	if(a=='h')posForJ = 7;


	// 'b' is i
	if(b=='1')posForI = 7;
	if(b=='2')posForI = 6;
	if(b=='3')posForI = 5;
	if(b=='4')posForI = 4;
	if(b=='5')posForI = 3;
	if(b=='6')posForI = 2;
	if(b=='7')posForI = 1;
	if(b=='8')posForI = 0;

	String coordinate = "";
	
	//iFNORE THIS FOR NOW
	if(posFors2==55 || posFors1==55 || posForI==55 || posForJ==55)coordinate = "end";

	coordinate =String.valueOf(posFors2) + String.valueOf(posFors1) + " " + String.valueOf(posForI) + String.valueOf(posForJ);    
	return coordinate;
}

/**
 * Combines all methods defined above into a single process, one that gets the input from the
 * user and converts it to an index to move.
 * @param route 
 */
public void translator(String route)
{
//This method is kind of useless and useful - Its not called anywhere but it does set up static string values for getter methods in this class

	String abc = "";
	inputString = route;
	abc = routeTranslation(route); //gets the string from routetranslation in the form of "12 34"
	routeForGetPos = abc; //routeForGetPos gets a value here that can be used by getCoordinates method in ChessObjClass ("12 34" gets passed to chessobjclass)

	//Input : e1 d1 - e1 is taken care by s1,s2 an d1 is done by a,b below
	
	//BELOW: YOU HAVE THE STRING : "64 65" ->IN 64 , 6 IS (abc,0) AND 4 IS (abc,1)
	int ent1 = intcordinatesfromString(abc,0); // Integer.parseInt(ss1);
	int ent2 = intcordinatesfromString(abc,1);
	 
	String piece = "";
	//checkPiece method sends int ent1,ent2 as 6 and 4 ->index[6][4] and gets a string variable of whatever
	//that index holds -> e.g String value; value = boards[i][j] ->
	//whatever that existed at boards[i][j] is now stored as a string in "value" variable
	piece = checkPiece(ent1,ent2);		//This would store the name of the string and then redirect that string to move
	piece2 = piece;	//This initializes a static variable so it usable in getter methods

	int dest1 = intcordinatesfromString(abc,3); //DOES NOTHING IGNORE
	int dest2 = intcordinatesfromString(abc,4); //DOES NOTHING IGNORE
	
}

/**
 * Checks if the input from the user is valid input or not. Returns "end" if input is not valid.
 * @param route
 * @return String
 */
public String validity(String route)
{
//FOR THE MAIN INPUT TO CHECK IF THE INPUT STRING IS VALID

	//Note: Change this to 3 and 4 later on
 if(route.length()>=4)
 {
	char s1 = route.charAt(0); 
	char s2 = route.charAt(1);
	

	// 's1' is J
	if(s1=='a')posFors1 = 0;if(s1=='b')posFors1 = 1;if(s1=='c')posFors1 = 2;if(s1=='d')posFors1 = 3;
	if(s1=='e')posFors1 = 4;if(s1=='f')posFors1 = 5;if(s1=='g')posFors1 = 6;if(s1=='h')posFors1 = 7;
	else {posFors1=55;}
	
	// 's2' is i
	if(s2=='1')posFors2 = 7;if(s2=='2')posFors2 = 6;if(s2=='3')posFors2 = 5;if(s2=='4')posFors2 = 4;
	if(s2=='5')posFors2 = 3;if(s2=='6')posFors2 = 2;if(s2=='7')posFors2 = 1;if(s2=='8')posFors2 = 0;
	else {posFors2=55;}
	
	char a = route.charAt(3); 
	char b = route.charAt(4);
	 
	// 'a' is J
	if(a=='a')posForJ = 0;if(a=='b')posForJ = 1;if(a=='c')posForJ = 2;if(a=='d')posForJ = 3;
	if(a=='e')posForJ = 4;if(a=='f')posForJ = 5;if(a=='g')posForJ = 6;if(a=='h')posForJ = 7;
	else {posForJ=55;}

	// 'b' is i
	if(b=='1')posForI = 7;if(b=='2')posForI = 6;if(b=='3')posForI = 5;if(b=='4')posForI = 4;
	if(b=='5')posForI = 3;if(b=='6')posForI = 2;if(b=='7')posForI = 1;if(b=='8')posForI = 0;
	else {posForI=55;}
	String coordinate = "";
	
	if(posFors2==55 || posFors1==55 || posForI==55 || posForJ==55)coordinate = "end";

	coordinate =String.valueOf(posFors2) + String.valueOf(posFors1) + " " + String.valueOf(posForI) + String.valueOf(posForJ);    
	return coordinate;
 }
 else return "end";
}
}
