package chessObjStuff;

public class chessPieceInfo {

String piece;
int id;
String color;
int firstMove;

public chessPieceInfo()
{
}


public chessPieceInfo(String piece, String color,int id,int firstMove)
{
	this.piece = piece;
	this.color = color;
	this.id = id;
	this.firstMove = firstMove;
}
	
//THIS RETURNS THE ID OF THE PIECE

public void setID(int id)
{
	this.id = id;
}


public int setFirstMove(int firstMove)
{
	return this.firstMove = firstMove;	
}

public int getFirstMove()
{
	return this.firstMove;	
}

public int getID()
{
	return this.id;
}

public String getName()
{
	return this.piece;
}
	
}
