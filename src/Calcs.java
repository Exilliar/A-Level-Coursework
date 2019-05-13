import java.util.concurrent.ThreadLocalRandom;//Imported to use random number generators

import javax.swing.ImageIcon;//Imported to use image icons in order to place images on the GUI
import javax.swing.JLabel;//Imported to allow use of JLabels to help place images on the GUI
import javax.swing.JTextField;//Imported to allow use of TextFields

public class Calcs 
{
	int pos = 0;//Setting up an int and setting it to 0
	public boolean RoadNear(int x, int y)//Checking if there is a road near another road
	{
		Main main = new Main();//An object used to access the class Main
		boolean dir;//Setting up a boolean
		if (x == 20 || x == 60 || x == 100 || x == 140 || x == 180 || x == 220 || x == 260 || x == 300 || x == 340 || x == 380 || x == 420) dir = true;//If the road is vertical set dir to true
		else dir = false;//If the road is horizontal
		for (int i = 0; i < 60; i ++)//Cycles through the 2d array main.RoadPos
		{
			if (dir == false)//If the road is horizontal
			{
				if (main.RoadPos[0][i] == x+40 && main.RoadPos[1][i] == y) return true;//If there is a road to the right return true
				else if (main.RoadPos[0][i] == x-40 && main.RoadPos[1][i] == y) return true;//If there is a road to the left return true
				else if (main.RoadPos[0][i] == x+20 && main.RoadPos[1][i] == y+20) return true;//If there is a road to the bottom right return true
				else if (main.RoadPos[0][i] == x+20 && main.RoadPos[1][i] == y-20) return true;//If there is a road to the top right return true
				else if (main.RoadPos[0][i] == x-20 && main.RoadPos[1][i] == y+20) return true;//If there is a road to the bottom left return true
				else if (main.RoadPos[0][i] == x+20 && main.RoadPos[1][i] == y-20) return true;//If there is a road to the top left return true
			}
			else
			{
				if (main.RoadPos[0][i] == x && main.RoadPos[1][i] == y+40) return true;//If there is a road to the right return true
				else if (main.RoadPos[0][i] == x && main.RoadPos[1][i] == y-40) return true;//If there is a road to the left return true
				else if (main.RoadPos[0][i] == x+20 && main.RoadPos[1][i] == y-20) return true;//If there is a road to the bottom right return true
				else if (main.RoadPos[0][i] == x-20 && main.RoadPos[1][i] == y-20) return true;//If there is a road to the top right return true
				else if (main.RoadPos[0][i] == x+20 && main.RoadPos[1][i] == y+20) return true;//If there is a road to the bottom left return true
				else if (main.RoadPos[0][i] == x-20 && main.RoadPos[1][i] == y+20) return true;//If there is a road to the top left return true
			}
		}
		return false;//Returns false if there is not a road next to the current road
	}
	public int[][] Sort2d(int[][] Array, int ArrayLength)//Method to sort 2d arrays
	{
		int PlaceHolder;//Setting up an int called PlaceHolder
		for (int i = 0; i < ArrayLength; i ++)//Cycles through the arrays length
		{
			for (int o = 0; o < ArrayLength-1; o ++)//Cycles through the arrays length-1
			{
				if (Array[0][o] < Array[0][o+1])//If the value at the current position in the array is less than the value in the next position in the array
				{
					PlaceHolder = Array[0][o];//Sets PlaceHolder to be the value of the current position in the array
					Array[0][o] = Array[0][o+1];//Sets the current position in the array to be the value of the next position in the array
					Array[0][o+1] = PlaceHolder;//Sets the PlaceHolder to be the value of the next position in the array
					
					PlaceHolder = Array[1][o];//Sets PlaceHolder to be the value of the current position in the array
					Array[1][o] = Array[1][o+1];//Sets the current position in the array to be the value of the next position in the array
					Array[1][o+1] = PlaceHolder;//Sets the PlaceHolder to be the value of the next position in the array
				}
			}
		}
		return Array;//Returns the, now sorted, array
	}
	
	public int RollDice (int Dice0, int Dice1, int DiceTotal, JTextField TDice0, JTextField TDice1, JTextField TDiceTotal)//Method for rolling the dice
	{
		Dice0 = ThreadLocalRandom.current().nextInt(1, 7);//Sets Dice0 to be a random value from 1 to 6
		Dice1 = ThreadLocalRandom.current().nextInt(1, 7);//Sets Dice1 to be a random value from 1 to 6
		DiceTotal = Dice0 + Dice1;//Sets DiceTotal to be the total of Dice0 and Dice1
		
		TDice0.setText("Dice0: " + Dice0);//Sets the TextField TDice0 to show the value of Dice0
		TDice1.setText("Dice1: " + Dice1);//Sets the TextField TDice1 to show the value of Dice1
		TDiceTotal.setText("Total: " + DiceTotal);//Sets the TextField TDiceTotal to show the value of DiceTotal
		
		return DiceTotal;//Returns DiceTotal
	}
	
	//Moving the Pointer
	public int MovePointerMinus(int PointC, int PointX, int Pointy, int Max, JLabel JPointer)//Subtracting from the pointers coordinate
	{
		if (PointC-40 != Max) PointC -= 40;//If the pointer is not at the edge of the board it moves the pointer by -40 in whichever direction was set
		return PointC;//Returns the new coordinate
	}
	public int MovePointerAdd(int PointC, int PointX, int PointY, int Max, JLabel JPointer)//Adding to the pointers coordinate
	{
		if (PointC+40 != Max) PointC += 40;//If the pointer is not at the edge of the board it moves the pointer by 40 in whichever direction was set
		return PointC;//Returns the new coordinate
	}
	
	//Trading
	public int[][] Trade(int[][] Resources, JTextField TPlayer1, JTextField TPlayer2, JTextField TResource1, JTextField TResource2, JTextField TQuantity1, JTextField TQuantity2)
	{
		int Player1 = Integer.parseInt(TPlayer1.getText());//Sets Player1 to be the value in the TextField TPlayer1
		int Player2 = Integer.parseInt(TPlayer2.getText());//Sets Player2 to be the value in the TextField TPlayer2
		
		String Resource1 = TResource1.getText();//Sets Resource1 to be the value in TResource1
		int IResource1 = 0;//Sets up an int IResource1 and sets it to 0
		switch(Resource1)//Switches depending on the value of Resource1
		{
			case "wood": IResource1 = 0; break;//If Resouce1 is "wood" sets IResource1 to be 0
			case "stone": IResource1 = 1; break;//If Resouce1 is "stone" sets IResource1 to be 1
			case "sheep": IResource1 = 2; break;//If Resouce1 is "sheep" sets IResource1 to be 2
			case "wheat": IResource1 = 3; break;//If Resouce1 is "wheat" sets IResource1 to be 3
			case "brick": IResource1 = 4; break;//If Resouce1 is "brick" sets IResource1 to be 4
		}
		
		String Resource2 = TResource2.getText();//Sets Resource2 to be the value in TResource2
		int IResource2 = 0;//Sets up an int IResource2 and sets it to 0
		switch(Resource2)//Switches depending on the value of Resource2
		{
		case "wood": IResource2 = 0; break;//If Resouce1 is "wood" sets IResource2 to be 0
		case "stone": IResource2 = 1; break;//If Resouce1 is "stone" sets IResource2 to be 1
		case "sheep": IResource2 = 2; break;//If Resouce1 is "sheep" sets IResource2 to be 2
		case "wheat": IResource2 = 3; break;//If Resouce1 is "wheat" sets IResource2 to be 3
		case "brick": IResource2 = 4; break;//If Resouce1 is "brick" sets IResource2 to be 4
		}
		
		int Quantity1 = Integer.parseInt(TQuantity1.getText());//Sets Quantity1 to be the value in TQuantity1
		int Quantity2 = Integer.parseInt(TQuantity2.getText());//Sets Quantity2 to be the value in TQuantity2
		
		if (CheckQuant(Player1, IResource1, Quantity1, Resources) && CheckQuant(Player2, IResource2, Quantity2, Resources))//Checks if each player has enough resources to trade
		{
			Resources[Player1-1][IResource1] -= Quantity1;//Takes away the resource being traded from the first player trading
			Resources[Player2-1][IResource1] += Quantity1;//Adds on the resource being traded from the second player trading
			
			Resources[Player2-1][IResource2] -= Quantity2;//Takes away the resource being traded from the second player trading
			Resources[Player1-1][IResource2] += Quantity2;//Adds on the resource being traded from the first player trading
		}
		return Resources;//Returns the new values of the players resources
	}
	public boolean CheckQuant(int Player, int Resource, int Quantity, int[][] Resources)//Checks if players have enough resources for trading
	{
		if (Resources[Player-1][Resource] >= Quantity) return true;//If the player has the same amount or more of the needed resource, return true
		else return false;//Returns false if the player does not have the same amount or more of the needed resource
	}
	//Checking positions
	public boolean CheckHit(int x, int y, int xPos, int yPos, int MaxVal, int[][] Checks)//Checks if one image is would collide with another
	{
		for (int i = 0; i < MaxVal; i ++)//Cycles through the inputed 2d array
		{
			if (Checks[xPos][i] == x && Checks[yPos][i] == y) return true;//If the inputed coordinates are the same as one of the set of coordinates in the 2d array returns true
		}
		return false;//If there is not a collision, return false
		
	}
	public boolean CheckNear(int x, int y, int xPos, int yPos, int MaxVal, int[][] Checks)//Checks if an image is near to another
	{
		for (int i = 0; i < MaxVal; i ++)//Cycles through the inputed 2d array
		{
			if (Checks[xPos][i] == x-10 && Checks[yPos][i] == y+30) return false;//If there is an image in the array to the bottom left, return false
			else if (Checks[xPos][i] == x-10 && Checks[yPos][i] == y-50) return false;//If there is an image in the array to the top left, return false
			else if (Checks[xPos][i] == x+30 && Checks[yPos][i] == y-10) return false;//If there is an image in the array to the top right, return false
			else if (Checks[xPos][i] == x-50 && Checks[yPos][i] == y-10) return false;//If there is an image in the array to the top left, return false
		}
		return true;//If there is not an image in the array, return true
	}
	public boolean CheckRoad(int x, int y, int xPos, int yPos, int MaxVal, int[][] Checks)//Checks if there is a road near where the user wants to place a city or settlement
	{
		for (int i = 0; i < MaxVal; i ++)//Cycles through the inputed array 
		{
			if (Checks[xPos][i] == x && Checks[yPos][i] == y-20) return true;//If there is a road above the city/settlement, return true
			else if (Checks[xPos][i] == x && Checks[yPos][i] == y+20) return true;//If there is a road bellow the city/settlement, return true
			else if (Checks[xPos][i] == x-20 && Checks[yPos][i] == y) return true;//If there is a road left the city/settlement, return true
			else if (Checks[xPos][i] == x+20 && Checks[yPos][i] == y) return true;//If there is a road right the city/settlement, return true
		}
		return false;//If there is not a road near the city/settlement, return false
	}
	//Finding settlement to move
	public int FindSettlement(int x, int y, int xPos, int yPos, int MaxVal, int[][] Checks)
	{
		for (int i = 0; i < MaxVal; i ++)//Cycles through the inputed array
		{
			if (Checks[xPos][i] == x && Checks[yPos][i] == y) return i;//If the coordinates match, return i
		}
		return -1;//Returns -1 if no coordinates match (this should never happen)
	}
	//Adding tiles to the board
	public int AddTile(int x, int y, int Pos, int ChooseNumber, int Type)
	{	
		Main main = new Main();//An object used to access the class Main
		main.AResource[0][pos] = x;//Adds the x coordinate to the array
		main.AResource[1][pos] = y;//Adds the y coordinate to the array
		main.AResource[2][pos] = Type;//Adds the type of resource to the array
		main.AResource[3][pos] = ChooseNumber;//Adds the number on the tile to the array
		pos ++;//Increases the int pos by 1
		return Pos;//Returns Pos
	}
	
	//Changing turn
	public int ChangeTurn(int Turn)
	{
		if (Turn++ == 4) Turn = 1;//If the turn+1 is equal to 4 then turn is set to 1
		return Turn;//Otherwise returns Turn
	}
	
	//Sets the text fields when the resources have been changed
	public void SetTextFields(int[][] Resources, JTextField Wood0, JTextField Wood1, JTextField Wood2, JTextField Wood3, JTextField Stone0, JTextField Stone1, JTextField Stone2, JTextField Stone3, JTextField Sheep0, JTextField Sheep1, JTextField Sheep2, JTextField Sheep3, JTextField Wheat0, JTextField Wheat1, JTextField Wheat2, JTextField Wheat3, JTextField Brick0, JTextField Brick1, JTextField Brick2, JTextField Brick3)
	{
		Wood0.setText("Player 1 wood = " + Resources[0][0]);//Sets the TextField Wood0 to be the new value
		Wood1.setText("Player 2 wood = " + Resources[1][0]);//Sets the TextField Wood1 to be the new value
		Wood2.setText("Player 3 wood = " + Resources[2][0]);//Sets the TextField Wood2 to be the new value
		Wood3.setText("Player 4 wood = " + Resources[3][0]);//Sets the TextField Wood3 to be the new value
	
		Stone0.setText("Player 1 stone = " + Resources[0][1]);//Sets the TextField Stone0 to be the new value
		Stone1.setText("Player 2 stone = " + Resources[1][1]);//Sets the TextField Stone1 to be the new value
		Stone2.setText("Player 3 stone = " + Resources[2][1]);//Sets the TextField Stone2 to be the new value
		Stone3.setText("Player 4 stone = " + Resources[3][1]);//Sets the TextField Stone3 to be the new value
				
		Sheep0.setText("Player 1 sheep = " + Resources[0][2]);//Sets the TextField Sheep0 to be the new value
		Sheep1.setText("Player 2 sheep = " + Resources[1][2]);//Sets the TextField Sheep1 to be the new value
		Sheep2.setText("Player 3 sheep = " + Resources[2][2]);//Sets the TextField Sheep2 to be the new value
		Sheep3.setText("Player 4 sheep = " + Resources[3][2]);//Sets the TextField Sheep3 to be the new value
		
		Wheat0.setText("Player 1 wheat = " + Resources[0][3]);//Sets the TextField Wheat0 to be the new value
		Wheat1.setText("Player 2 wheat = " + Resources[1][3]);//Sets the TextField Wheat1 to be the new value
		Wheat2.setText("Player 3 wheat = " + Resources[2][3]);//Sets the TextField Wheat2 to be the new value
		Wheat3.setText("Player 4 wheat = " + Resources[3][3]);//Sets the TextField Wheat3 to be the new value
		
		Brick0.setText("player 1 brick = " + Resources[0][4]);//Sets the TextField Brick0 to be the new value
		Brick1.setText("player 2 brick = " + Resources[1][4]);//Sets the TextField Brick1 to be the new value
		Brick2.setText("player 3 brick = " + Resources[2][4]);//Sets the TextField Brick2 to be the new value
		Brick3.setText("player 4 brick = " + Resources[3][4]);//Sets the TextField Brick3 to be the new value
	}
}
