import java.awt.event.ActionEvent;//Allows for program to listen for inputs

import javax.swing.JButton;//Allows use of buttons
import javax.swing.JLabel;//Allows use of JLabels
import javax.swing.JTextField;//Allows use of TextFields

public class Main 
{
	Calcs calcs = new Calcs();//Creates an object used to access the class Calcs
	
	//Setting up variables and assigning them values
	
	//Booleans
	boolean MoveOn = false;
		
	//Arrays
	//Resources
	//Players
	public static int[][] PlayerResources = new int[4][6]; //0 = wood; 1 = stone; 2 = sheep; 3 = wheat; 4 = brick; 5 = points
		
	//Resource positions and type
	public static int[][] AResource = new int[4][60]; //0 = x coordinate; 1 = y coordinate; 2 = type of resource; 3 = number attached to tile
		
	//Road Positions
	public static int[][] RoadPos = new int[2][60];
	public static int RoadPosPos = 0;
	
	int Player1RoadMax = 15;
	int Player1RoadCurrent = 0;
	
	//Settlement positions
	public static int[][] SettlementPos = new int[3][20]; //0 = x coordinate; 1 = y coordinate; 2 = Player at settlement
	public static int SettlementPosPos = 0;
	
	int PlayerCityMax = 4;
	
	//City positions
	public static int[][] CityPos = new int[3][16]; //0 = x coordinate; 1 = y coordinate; 2 = Player at city
	public static int CityPosPos = 0;
	
	//Numbers
	int[] NumberPack = new int[12];
	
	//Variables
	//Resource array positions
	int Pos = 0;
	
	//Players total resource cards
	int Player1Total = 0;
	int Player2Total = 0;
	int Player3Total = 0;
	int Player4Total = 0;
	
	//Dice
	int Dice0;
	int Dice1;
	int DiceTotal;
	
	//Pointer coordinates
	int PointX = 60;
	int PointY = 320;
	
	//Board width + height
	int BoardWidthMax = 460;
	int BoardWidthMin = -20;
	
	int BoardHeightMax = 520;
	int BoardHeightMin = 200;
	
	public int Handle(ActionEvent event, JTextField TTurn, int Turn, JButton JEndTurn, JButton JRoll, JButton JUp, JButton JDown, JButton JRight, JButton JLeft, JButton JTrade, JButton JRoad, JButton JSettlement, JButton JCity, JLabel JPointer, JTextField TDice0, JTextField TDice1, JTextField TDiceTotal, JTextField TTradePlayer1, JTextField TTradePlayer2, JTextField TTradeResource1, JTextField TTradeResource2, JTextField TTradeQuantity1, JTextField TTradeQuantity2, JTextField TPlayer1Wood, JTextField TPlayer2Wood, JTextField TPlayer3Wood, JTextField TPlayer4Wood, JTextField TPlayer1Stone, JTextField TPlayer2Stone, JTextField TPlayer3Stone, JTextField TPlayer4Stone, JTextField TPlayer1Sheep, JTextField TPlayer2Sheep, JTextField TPlayer3Sheep, JTextField TPlayer4Sheep, JTextField TPlayer1Wheat, JTextField TPlayer2Wheat, JTextField TPlayer3Wheat, JTextField TPlayer4Wheat, JTextField TPlayer1Brick, JTextField TPlayer2Brick, JTextField TPlayer3Brick, JTextField TPlayer4Brick, JTextField TPlayerPoints)
	{
			ResourceGive Give = new ResourceGive();//Ceates an object used to access ResourceGive
		//Rolling the Dice
		if (event.getSource() == JRoll && MoveOn == false)//If the roll button has been pressed and if the boolean MoveOn is false(this means that the player has not already rolled once this turn)
		{
			DiceTotal = calcs.RollDice(Dice0, Dice1, DiceTotal, TDice0, TDice1, TDiceTotal);//Sets the variable DiceTotal to be the total to two other dice which are rolled in the class Calcs
			Give.Resource(DiceTotal, SettlementPos, TPlayer1Wood, TPlayer2Wood, TPlayer3Wood, TPlayer4Wood, TPlayer1Stone, TPlayer2Stone, TPlayer3Stone, TPlayer4Stone, TPlayer1Sheep, TPlayer2Sheep, TPlayer3Sheep, TPlayer4Sheep, TPlayer1Wheat, TPlayer2Wheat, TPlayer3Wheat, TPlayer4Wheat, TPlayer1Brick, TPlayer2Brick, TPlayer3Brick, TPlayer4Brick);//Gives the players the resources depending on what has been rolled
			MoveOn = true;//Sets MoveOn to be true so that the dice cannot be rolled this turn again
		}
		//Trading
		else if (event.getSource() == JTrade)//If the trade button has been pressed
		{
			PlayerResources = calcs.Trade(PlayerResources, TTradePlayer1, TTradePlayer2, TTradeResource1, TTradeResource2, TTradeQuantity1, TTradeQuantity2);//Runs a method in Calcs which trades the resources
			calcs.SetTextFields(PlayerResources, TPlayer1Wood, TPlayer2Wood, TPlayer3Wood, TPlayer4Wood, TPlayer1Stone, TPlayer2Stone, TPlayer3Stone, TPlayer4Stone, TPlayer1Sheep, TPlayer2Sheep, TPlayer3Sheep, TPlayer4Sheep, TPlayer1Wheat, TPlayer2Wheat, TPlayer3Wheat, TPlayer4Wheat, TPlayer1Brick, TPlayer2Brick, TPlayer3Brick, TPlayer4Brick);//Changes the resource TextFields to show the new values
		}
		//End Turn
		else if (event.getSource() == JEndTurn && MoveOn == true)//If the end turn button has been pressed and MoveOn is true(the dice has been rolled)
		{
			MoveOn = false;//Sets MoveOn to be false (the dice can now be rolled again)
			Turn = calcs.ChangeTurn(Turn);//Runs a method in Calcs which changes the turn
			TTurn.setText("Player" + Turn + "'s turn");//Changes the TextField TTurn to be the player who's turn it is after the turn has been changed
		}
		//Moving the Pointer
		MovePointer(event, JUp,JDown,JLeft,JRight,JPointer);//Runs the MovePointer Method
		return Turn;//Returns the int Turn (which players turn it is)
	}
	public void MovePointer(ActionEvent event, JButton JUp, JButton JDown, JButton JLeft, JButton JRight, JLabel JPointer)//A method to move the pointer
	{
		if (event.getSource() == JUp)//If the up button has been pressed
		{
			PointY = calcs.MovePointerMinus(PointY, PointX, PointY, BoardHeightMin, JPointer);//Runs a method in Calcs which moves the pointer up
			JPointer.setBounds(PointX,PointY,40,40);//Moves the pointer to its new position
		}
		else if (event.getSource() == JDown)//If the down button has been pressed
		{
			PointY = calcs.MovePointerAdd(PointY,PointX,PointY,BoardHeightMax,JPointer);//Runs a method in Calcs which moves the pointer down
			JPointer.setBounds(PointX, PointY, 40, 40);//Moves the pointer to its new position
		}
		else if (event.getSource() == JRight)//If the right button has been pressed
		{
			PointX = calcs.MovePointerAdd(PointX, PointX, PointY, BoardWidthMax, JPointer);//Runs a method in Calcs which moves the pointer right
			JPointer.setBounds(PointX,PointY,40,40);//Moves the pointer to its new position
		}
		else if (event.getSource() == JLeft)//If the left button has been pressed
		{
			PointX = calcs.MovePointerMinus(PointX, PointX, PointY, BoardWidthMin, JPointer);//Runs a method in Calcs which moves the pointer left
			JPointer.setBounds(PointX, PointY, 40, 40);//Moves the pointer to its new position
		}
	}
	public int ReturnPointX()//A method to return the pointers x coordinate
	{
		return PointX;//Returns PointX
	}
	public int ReturnPointY()//A method to return the pointers y coordinate
	{
		return PointY;//Returns PointY
	}
}