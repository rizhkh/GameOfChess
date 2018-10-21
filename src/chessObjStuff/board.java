package chessObjStuff;

public class board implements typeInter {

static String[][] boards = new String[9][9];	
String[][] boardsNonEditable = new String[9][9]; //This one is a blank grid with blackspots to check which
//index has a black spot so then we can add blackspots on the static array

String wR = "wR ";
String wN = "wN ";
String wQ = "wQ ";

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
	

//We need an interface for this one
public void initializePiece(String a)
{
	if(a.equals("wR"))
		{
		boards[7][0] = null;	
		boards[7][0] = wR;
		//boards[7][1] = "wN ";
		//boards[7][2] = "wB ";
		//boards[7][3] = "wQ ";		
		//boards[6][0] = "wp ";
		boards[7][7] = null;
		boards[7][7] = wR;
		}
}
/*
public void move(int a)
{ 
	
}
*/



//This method first checks the path of the piece-if clear it would send empty 
//string but if not it would send the location it can move to
public String isPathClear()
{
return "";
}

//This method checks if the given position is a Piece or not
public boolean isPiece(int a,int b)
{
	if( ((boards[a][b]).equals(wR)) || ((boards[a][b]).equals(wQ)) || ((boards[a][b]).equals(wN)))
	{
		return true;
	}
	return false;
}

//This method returns the string that contains name of the piece on the index so we know what piece is going to move
public String checkPiece(int a,int b)
{
	String c = "";
	 if( isPiece(a,b) )c = boards[a][b] ;
	return c;
}

//This method returns the piece that is going to be moved - made to be used in other class
//This woudd get "WR,WQ" in chess piece class
public String getPiece()
{
String piece = piece2;

return piece;
}

static String piece2 = "";


//This method is used to get Entered position from the input
public String getCoordinates()
{
	String d = routeForGetPos;
	return d;
}

static String routeForGetPos = "";
//Converts the string to actual coordinates on the board

//converts string to int in coordinates
//String is the input, int is the char at (0,1 or 3,4)
public int intcordinatesfromString(String abc,int b)
{
	char s1 = abc.charAt(b);
	String ss1 = String.valueOf(s1);
	int ent1 = Integer.parseInt(ss1);
	
	return ent1;
}


public void translator(String route)
{
	String abc = "";
	abc = routeTranslation(route);
	routeForGetPos = abc;

	//Input : e1 d1 - e1 is taken care by s1,s2 an d1 is done by a,b below
	
	int ent1 = intcordinatesfromString(abc,0); // Integer.parseInt(ss1);
	int ent2 = intcordinatesfromString(abc,1);
	
	 
	String piece = "";
	piece = checkPiece(ent1,ent2);		//This would store the name of the string and then redirect that string to move
	piece2 = piece;

	int dest1 = intcordinatesfromString(abc,3);
	int dest2 = intcordinatesfromString(abc,4);
	
}


int posForJ;
int posForI;
int posFors1;
int posFors2;

//This method converts Indices to string format e1 e2
//and returns that index number as string that can be
//converted into the position for movement
public String routeTranslation(String route)
{
	//Note: Change this to 3 and 4 later on

	char s1 = route.charAt(0); 
	char s2 = route.charAt(1);
	
	
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
	

	String coordinate =String.valueOf(posFors2) + String.valueOf(posFors1) + " " + String.valueOf(posForI) + String.valueOf(posForJ);    
	return coordinate;
}





}
