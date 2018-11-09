import chessObjStuff.ChessObjClass;
import java.util.Scanner;
import chessObjStuff.board;

/**
 * 
 * @author Rizwan Khan(mrk150) && Ahmed Ghoneim(asg179)
 * @version 1.0
 * Main application driver for Chess project
 *
 */
public class Chess {
	private static String draw = null;//in case of a draw

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner inp = new Scanner(System.in);
		int xyz = 0;
		ChessObjClass a = new ChessObjClass();
		int i =0;
		do 
		{
		//board b = new board();
		
		  if(a.getPrevColor().equals("black")){
			  System.out.print("\nWhite's Move (e.g a1 e5):");
		  }else if (a.getPrevColor().equals("white")){
			  System.out.print("\nBlack's Move (e.g a1 e5):");
		  }
			
	      String s = inp.nextLine();
	      
	      
	      
	      //resign, done before index check
	      if (s.toLowerCase().equals("resign")){
	    	  if(a.getPrevColor().equals("black")){
				  System.out.print("Black wins");
				  return;
			  }else if (a.getPrevColor().equals("white")){
				  System.out.print("White wins");
				  return;
			  }
	      }
	      
	      
	      //player asks for a draw
	      if (s.length() > 5){
	    	  draw = s.substring(6, s.length()-1);
	    	  
	    	  //make a move then wait for draw next turn
	    	  if (draw.equals("draw")){

	    	      String bc = a.validity(s.substring(0, 5));
	    	      System.out.println();
	    		      if(bc.equals("end") )
	    		      {
	    		    	  System.out.println("Invalid Input. Try Again!\n"); 
	    		      }
	    		      else
	    		      {
	    		    	  a.translator(s);
	    		    	  boolean invalid = a.move();
	    		    	  
	    		    	  if(!invalid)
	    		    		  System.out.println("Invalid Input. Try Again!\n");
	    		    	  
	    		    	  a.showBoard();
	    		    	  System.out.println();		    	  
	    		      } 
	    		      continue;
	    	  }
	      }
	      
		  //player confirms draw or continues playing
	      if ((s.equals("draw") || s.equals("draw?")) && draw == null){
	    	  System.out.println("\nIllegal move, try again\n");
	    	  a.showBoard();
	    	  System.out.println();
	    	  continue;
	      }else if (s.equals("draw") && draw.equals("draw")){
	    	  return;
	      }
	      
	      String bc = a.validity(s);
	      System.out.println();
		      if(bc.equals("end") )
		      {
		    	  System.out.println("Illegal move, try again\n"); 
		      }
		      else
		      {
		    	  a.translator(s);
		    	  boolean invalid = a.move();
		    	  
		    	  if(!invalid)
		    		  System.out.println("Invalid Input. Try Again!\n");
		    	  
		    	  a.showBoard();
		    	  System.out.println();		    	  
		      }
	      } 
		while(i==0);
		inp.close();
	}
}
