package chessObjStuff;

/**
 * 
 * @author Rizwan Khan(mrk 150) && Ahmed Ghoneim(asg179)
 * @version 1.0
 * Class to represent Chess piece types
 *
 */
public class chessPieceInfo {

String piece;
int id;
String color;
int firstMove;
int steps;

public chessPieceInfo()
{
}

/**
* Initializes a chess piece with the passed information
* @param piece, type of piece
* @param color, color of piece
* @param id, id of piece
* @param firstMove, 0 moves all pieces by 1 space, 1 moves pawns by 2 spaces
*/
public chessPieceInfo(String piece, String color,int id,int firstMove)
{
	this.piece = piece;
	this.color = color;
	this.id = id;
	this.firstMove = firstMove;
	this.steps=0;
}
	
//THIS RETURNS THE ID OF THE PIECE

/**
* Sets id of piece
* @param id
*/
public void setID(int id)
{
	this.id = id;
}

/**
* Sets the first move of the piece
* @param firstMove
*/
public void setFirstMove(int firstMove)
{
	this.firstMove = firstMove;	
}

/**
* This increments the number of steps taken by a piece.
*/
public void incrSteps()
{
	this.steps++;
}

/**
* This returns the number of steps a piece has
* taken.
* @return int
*/
public int getSteps()
{
 return this.steps;
}

/**
* Gets the first move of the piece
* @return int, 0 for 1 space, 1 for moving pawns 2 spaces
*/
public int getFirstMove()
{
	return this.firstMove;	
}

/**
* Gets id of piece
* @return int
*/
public int getID()
{
	return this.id;
}

/**
* Gets name of piece
* @return String
*/
public String getName()
{
	return this.piece;
}
	
}
