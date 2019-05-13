import javax.swing.JFrame;//Imported to allow setting up a JFrame

public class SoCMain 
{
	public static void main(String[] args) 
	{
		Board object = new Board();//Creates an object used to access the class Board
		
		object.setSize(900,600);//Sets the window to be 900 by 600
		object.setVisible(true);//Sets the window to be visible
		object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Sets the program to end when the x is pressed
		object.setResizable(false);//Sets the window to not be resizable by the user
	}

}
