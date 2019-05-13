import java.awt.event.ActionEvent;//Allows program to find which button has been pressed

import javax.swing.JButton;//Allows use of buttons
import javax.swing.JLabel;//Used for moving images on the GUI
import javax.swing.JOptionPane;//Allows use of popups
import javax.swing.JTextField;//Allows use of TextFields

public class StartGame 
{
	//Setting up ints
	int RoadPlaceX;
	int RoadPlaceY;
	
	int Player1SettlementX0;
	int Player1SettlementY0;
	int Player1SettlementX1;
	int Player1SettlementY1;
	int Player2SettlementX0;
	int Player2SettlementY0;
	int Player2SettlementX1;
	int Player2SettlementY1;
	int Player3SettlementX0;
	int Player3SettlementY0;
	int Player3SettlementX1;
	int Player3SettlementY1;
	int Player4SettlementX0;
	int Player4SettlementY0;
	int Player4SettlementX1;
	int Player4SettlementY1;
	
	int stage = 0;
	int playeron = 0;
	int DiceTotal, Dice0, Dice1;
	int ArrayTurn = 0;
	
	//Setting up booleans
	boolean MoveOn = true;
	boolean PlacedRoad = false;
	boolean PlacedSettlement = false;
	boolean Looped = false;
	boolean Road = false;
	boolean Settlement = false;
	
	//Setting up a 2d array
	int[][] order = new int[2][4];
	
	Player1 player1 = new Player1();//An object used to access the class Player1
	Player2 player2 = new Player2();//An object used to access the class Player2
	Player3 player3 = new Player3();//An object used to access the class Player3
	Player4 player4 = new Player4();//An object used to access the class Player4
	
	ResourceGive resourcegive = new ResourceGive();//An object used to access the class resourcegive
	Calcs calcs = new Calcs();//An object used to access the class Calcs
	Main main = new Main();//An object used to access the class Main
	
	public void SetVars()//Sets up basic variables
	{
		player1.setVars();//Sets up variables in player1
		player2.setVars();//Sets up variables in player2
		player3.setVars();//Sets up variables in player3
		player4.setVars();//Sets up variables in player4
	}
	
	public boolean go(ActionEvent event, boolean Begin, JTextField TPlayerTurn, JTextField TPlayer1Points, JTextField TPlayer2Points, JTextField TPlayer3Points, JTextField TPlayer4Points, JButton JUp, JButton JDown, JButton JLeft, JButton JRight, JLabel JPointer, JButton JRoll, JButton JEndTurn, JButton JRoad, JButton JSettlement, JTextField TDice0, JTextField TDice1, JTextField TDiceTotal, JLabel JPlayer1Road0, JLabel JPlayer1Road1, JLabel JPlayer1Road2, JLabel JPlayer1Road3, JLabel JPlayer1Road4, JLabel JPlayer1Road5, JLabel JPlayer1Road6, JLabel JPlayer1Road7, JLabel JPlayer1Road8, JLabel JPlayer1Road9, JLabel JPlayer1Road10, JLabel JPlayer1Road11, JLabel JPlayer1Road12, JLabel JPlayer1Road13, JLabel JPlayer1Road14, JLabel JPlayer2Road0, JLabel JPlayer2Road1, JLabel JPlayer2Road2, JLabel JPlayer2Road3, JLabel JPlayer2Road4, JLabel JPlayer2Road5, JLabel JPlayer2Road6, JLabel JPlayer2Road7, JLabel JPlayer2Road8, JLabel JPlayer2Road9, JLabel JPlayer2Road10, JLabel JPlayer2Road11, JLabel JPlayer2Road12, JLabel JPlayer2Road13, JLabel JPlayer2Road14, JLabel JPlayer3Road0, JLabel JPlayer3Road1, JLabel JPlayer3Road2, JLabel JPlayer3Road3, JLabel JPlayer3Road4, JLabel JPlayer3Road5, JLabel JPlayer3Road6, JLabel JPlayer3Road7, JLabel JPlayer3Road8, JLabel JPlayer3Road9, JLabel JPlayer3Road10, JLabel JPlayer3Road11, JLabel JPlayer3Road12, JLabel JPlayer3Road13, JLabel JPlayer3Road14, JLabel JPlayer4Road0, JLabel JPlayer4Road1, JLabel JPlayer4Road2, JLabel JPlayer4Road3, JLabel JPlayer4Road4, JLabel JPlayer4Road5, JLabel JPlayer4Road6, JLabel JPlayer4Road7, JLabel JPlayer4Road8, JLabel JPlayer4Road9, JLabel JPlayer4Road10, JLabel JPlayer4Road11, JLabel JPlayer4Road12, JLabel JPlayer4Road13, JLabel JPlayer4Road14, JLabel JPlayer1Settlement0, JLabel JPlayer1Settlement1, JLabel JPlayer1Settlement2, JLabel JPlayer1Settlement3, JLabel JPlayer1Settlement4, JLabel JPlayer2Settlement0, JLabel JPlayer2Settlement1, JLabel JPlayer2Settlement2, JLabel JPlayer2Settlement3, JLabel JPlayer2Settlement4, JLabel JPlayer3Settlement0, JLabel JPlayer3Settlement1, JLabel JPlayer3Settlement2, JLabel JPlayer3Settlement3, JLabel JPlayer3Settlement4, JLabel JPlayer4Settlement0, JLabel JPlayer4Settlement1, JLabel JPlayer4Settlement2, JLabel JPlayer4Settlement3, JLabel JPlayer4Settlement4, JTextField TPlayer1Wood, JTextField TPlayer2Wood, JTextField TPlayer3Wood, JTextField TPlayer4Wood, JTextField TPlayer1Stone, JTextField TPlayer2Stone, JTextField TPlayer3Stone, JTextField TPlayer4Stone, JTextField TPlayer1Sheep, JTextField TPlayer2Sheep, JTextField TPlayer3Sheep, JTextField TPlayer4Sheep, JTextField TPlayer1Wheat, JTextField TPlayer2Wheat, JTextField TPlayer3Wheat, JTextField TPlayer4Wheat, JTextField TPlayer1Brick, JTextField TPlayer2Brick, JTextField TPlayer3Brick, JTextField TPlayer4Brick)
	{
		switch(stage)//Switches depending on which stage of the startgame the program is on
		{
			case 0: //Each Player Rolling the dice
				if (event.getSource() == JRoll && playeron <= 4)//If the dice has been rolled and all 4 players have not rolled already
				{
					TPlayerTurn.setText("Player: " + (playeron+1) + "'s turn");//Sets the TextField TPlayerTurn to be the new player whos turn it is
					DiceTotal = calcs.RollDice(Dice0, Dice1, DiceTotal, TDice0, TDice1, TDiceTotal);//Rolls the dice using a method in calcs
					order[0][playeron] = DiceTotal;//Puts the diceroll into the 2d array order
					order[1][playeron] = playeron+1;//Puts the player that rolled the dice in the 2d array
					JOptionPane.showMessageDialog(null, "Player " + (playeron+1) + " got " + DiceTotal);//Shows the player which number they rolled
					if (playeron == 3)//If all the players have rolled
					{
						order = calcs.Sort2d(order, 4);//Sorts the 2d array order
					}
					playeron ++;//Adds 1 to the int playeron which tells the program how many players have rolled
					if (playeron > 3)//If all the players have rolled
					{
						stage = 1;//Move the program on to the next stage
					}
				}
				break;
			case 1: //Players placing down settlements and roads
				main.MovePointer(event, JUp, JDown, JLeft, JRight, JPointer);//Moves the pointer
				int PointX = main.ReturnPointX();//Sets PointX to be the x coordinate of the Pointer
				int PointY = main.ReturnPointY();//Sets PointY to be the y coordinate of the Pointer
				switch(ArrayTurn)//Switches depending on ArrayTurn which is changed depending on how many people have placed down a settlement and road
				{
					case 0://If no one has gone
						switch(order[1][ArrayTurn])//Switches depending on what people rolled
						{
							case 1://If player1 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player1.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player1.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer1Road0, JPlayer1Road1, JPlayer1Road2, JPlayer1Road3, JPlayer1Road4, JPlayer1Road5, JPlayer1Road6, JPlayer1Road7, JPlayer1Road8, JPlayer1Road9, JPlayer1Road10, JPlayer1Road11, JPlayer1Road12, JPlayer1Road13, JPlayer1Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player1.PlaceSettlement(PointX, PointY, TPlayer1Points, JPlayer1Settlement0, JPlayer1Settlement1, JPlayer1Settlement2, JPlayer1Settlement3, JPlayer1Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
										if (Looped == false)//If the program has not already looped
										{
											Player1SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
											Player1SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
										}
										else//If the program has looped
										{
											Player1SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
											Player1SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
										}
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed down a road and a settlement
								{
									if (Looped == true) Begin = false;//If the program has looped, set Begin to be false(stops the program running this class and starts the main game)
									else ArrayTurn ++;//Adds 1 to ArrayTurn to move the program to the next position in the array order
									
									PlacedRoad = false;//Sets PlacedRoad to be false so the user can place down a road again
									PlacedSettlement = false;//Sets SettlementRoad to be false so the user can place down a settlement again
								}
								break;
							case 2://If player2 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player2.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player2.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer2Road0, JPlayer2Road1, JPlayer2Road2, JPlayer2Road3, JPlayer2Road4, JPlayer2Road5, JPlayer2Road6, JPlayer2Road7, JPlayer2Road8, JPlayer2Road9, JPlayer2Road10, JPlayer2Road11, JPlayer2Road12, JPlayer2Road13, JPlayer2Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed down a road and a settlement
								{
									if (Looped == true) Begin = false;//If the program has looped, set Begin to be false(stops the program running this class and starts the main game)
									else ArrayTurn ++;//Adds 1 to ArrayTurn to move the program to the next position in the array order
									
									PlacedRoad = false;//Sets PlacedRoad to be false so the user can place down a road again
									PlacedSettlement = false;//Sets SettlementRoad to be false so the user can place down a settlement again
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not alread placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player2.PlaceSettlement(PointX, PointY, TPlayer2Points, JPlayer2Settlement0, JPlayer2Settlement1, JPlayer2Settlement2, JPlayer2Settlement3, JPlayer2Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped
									{
										Player2SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player2SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped
									{
										Player2SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player2SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								break;
							case 3://If player3 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player3.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player3.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer3Road0, JPlayer3Road1, JPlayer3Road2, JPlayer3Road3, JPlayer3Road4, JPlayer3Road5, JPlayer3Road6, JPlayer3Road7, JPlayer3Road8, JPlayer3Road9, JPlayer3Road10, JPlayer3Road11, JPlayer3Road12, JPlayer3Road13, JPlayer3Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed down a road and a settlement
								{
									if (Looped == true) Begin = false;//If the program has looped, set Begin to be false(stops the program running this class and starts the main game)
									else ArrayTurn ++;//Adds 1 to ArrayTurn to move the program to the next position in the array order
									
									PlacedRoad = false;//Sets PlacedRoad to be false so the user can place down a road again
									PlacedSettlement = false;//Sets SettlementRoad to be false so the user can place down a settlement again
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed te settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player3.PlaceSettlement(PointX, PointY, TPlayer3Points, JPlayer3Settlement0, JPlayer3Settlement1, JPlayer3Settlement2, JPlayer3Settlement3, JPlayer3Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player3SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player3SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player3SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player3SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								break;
							case 4://If player4 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player4.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player4.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer4Road0, JPlayer4Road1, JPlayer4Road2, JPlayer4Road3, JPlayer4Road4, JPlayer4Road5, JPlayer4Road6, JPlayer4Road7, JPlayer4Road8, JPlayer4Road9, JPlayer4Road10, JPlayer4Road11, JPlayer4Road12, JPlayer4Road13, JPlayer4Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player4.PlaceSettlement(PointX, PointY, TPlayer4Points, JPlayer4Settlement0, JPlayer4Settlement1, JPlayer4Settlement2, JPlayer4Settlement3, JPlayer4Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player4SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player4SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player4SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player4SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed down a road and a settlement
								{
									if (Looped == true) Begin = false;//If the program has looped, set Begin to be false(stops the program running this class and starts the main game)
									else ArrayTurn ++;//Adds 1 to ArrayTurn to move the program to the next position in the array order
									
									PlacedRoad = false;//Sets PlacedRoad to be false so the user can place down a road again
									PlacedSettlement = false;//Sets SettlementRoad to be false so the user can place down a settlement again
								}
								break;
						}
						break;
					case 1://If one player has gone
						switch(order[1][ArrayTurn])
						{
							case 1://If player1 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player1.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player1.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer1Road0, JPlayer1Road1, JPlayer1Road2, JPlayer1Road3, JPlayer1Road4, JPlayer1Road5, JPlayer1Road6, JPlayer1Road7, JPlayer1Road8, JPlayer1Road9, JPlayer1Road10, JPlayer1Road11, JPlayer1Road12, JPlayer1Road13, JPlayer1Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player1.PlaceSettlement(PointX, PointY, TPlayer1Points, JPlayer1Settlement0, JPlayer1Settlement1, JPlayer1Settlement2, JPlayer1Settlement3, JPlayer1Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player1SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player1SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player1SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player1SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else ArrayTurn ++;//If the program has not looped, +1 to ArrayTurn
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								break;
							case 2://If player2 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player2.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player2.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer2Road0, JPlayer2Road1, JPlayer2Road2, JPlayer2Road3, JPlayer2Road4, JPlayer2Road5, JPlayer2Road6, JPlayer2Road7, JPlayer2Road8, JPlayer2Road9, JPlayer2Road10, JPlayer2Road11, JPlayer2Road12, JPlayer2Road13, JPlayer2Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else ArrayTurn ++;//If the program has not looped, +1 to ArrayTurn
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If the user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player2.PlaceSettlement(PointX, PointY, TPlayer2Points, JPlayer2Settlement0, JPlayer2Settlement1, JPlayer2Settlement2, JPlayer2Settlement3, JPlayer2Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player2SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player2SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player2SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player2SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								break;
							case 3://If player3 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player3.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player3.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer3Road0, JPlayer3Road1, JPlayer3Road2, JPlayer3Road3, JPlayer3Road4, JPlayer3Road5, JPlayer3Road6, JPlayer3Road7, JPlayer3Road8, JPlayer3Road9, JPlayer3Road10, JPlayer3Road11, JPlayer3Road12, JPlayer3Road13, JPlayer3Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else ArrayTurn ++;//If the program has not looped, +1 to ArrayTurn
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If the user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player3.PlaceSettlement(PointX, PointY, TPlayer3Points, JPlayer3Settlement0, JPlayer3Settlement1, JPlayer3Settlement2, JPlayer3Settlement3, JPlayer3Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player3SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player3SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player3SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player3SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								break;
							case 4://If player4 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player4.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player4.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer4Road0, JPlayer4Road1, JPlayer4Road2, JPlayer4Road3, JPlayer4Road4, JPlayer4Road5, JPlayer4Road6, JPlayer4Road7, JPlayer4Road8, JPlayer4Road9, JPlayer4Road10, JPlayer4Road11, JPlayer4Road12, JPlayer4Road13, JPlayer4Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player4.PlaceSettlement(PointX, PointY, TPlayer4Points, JPlayer4Settlement0, JPlayer4Settlement1, JPlayer4Settlement2, JPlayer4Settlement3, JPlayer4Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player4SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player4SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player4SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player4SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else ArrayTurn ++;//If the program has not looped, +1 to ArrayTurn
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								break;
						}
						break;
					case 2://If 2 players have gone
						switch(order[1][ArrayTurn])
						{
							case 1://If player1 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player1.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player1.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer1Road0, JPlayer1Road1, JPlayer1Road2, JPlayer1Road3, JPlayer1Road4, JPlayer1Road5, JPlayer1Road6, JPlayer1Road7, JPlayer1Road8, JPlayer1Road9, JPlayer1Road10, JPlayer1Road11, JPlayer1Road12, JPlayer1Road13, JPlayer1Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player1.PlaceSettlement(PointX, PointY, TPlayer1Points, JPlayer1Settlement0, JPlayer1Settlement1, JPlayer1Settlement2, JPlayer1Settlement3, JPlayer1Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player1SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player1SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player1SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player1SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else ArrayTurn ++;//If the program has not looped, +1 to ArrayTurn
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								break;
							case 2://If player2 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player2.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player2.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer2Road0, JPlayer2Road1, JPlayer2Road2, JPlayer2Road3, JPlayer2Road4, JPlayer2Road5, JPlayer2Road6, JPlayer2Road7, JPlayer2Road8, JPlayer2Road9, JPlayer2Road10, JPlayer2Road11, JPlayer2Road12, JPlayer2Road13, JPlayer2Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else ArrayTurn ++;//If the program has not looped, +1 to ArrayTurn
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not  already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player2.PlaceSettlement(PointX, PointY, TPlayer2Points, JPlayer2Settlement0, JPlayer2Settlement1, JPlayer2Settlement2, JPlayer2Settlement3, JPlayer2Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player2SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player2SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player2SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player2SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								break;
							case 3://If player3 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player3.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player3.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer3Road0, JPlayer3Road1, JPlayer3Road2, JPlayer3Road3, JPlayer3Road4, JPlayer3Road5, JPlayer3Road6, JPlayer3Road7, JPlayer3Road8, JPlayer3Road9, JPlayer3Road10, JPlayer3Road11, JPlayer3Road12, JPlayer3Road13, JPlayer3Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else ArrayTurn ++;//If the program has not looped, +1 to ArrayTurn
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player3.PlaceSettlement(PointX, PointY, TPlayer3Points, JPlayer3Settlement0, JPlayer3Settlement1, JPlayer3Settlement2, JPlayer3Settlement3, JPlayer3Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player3SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player3SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player3SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player3SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								break;
							case 4://If player4 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player4.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player4.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer4Road0, JPlayer4Road1, JPlayer4Road2, JPlayer4Road3, JPlayer4Road4, JPlayer4Road5, JPlayer4Road6, JPlayer4Road7, JPlayer4Road8, JPlayer4Road9, JPlayer4Road10, JPlayer4Road11, JPlayer4Road12, JPlayer4Road13, JPlayer4Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player4.PlaceSettlement(PointX, PointY, TPlayer4Points, JPlayer4Settlement0, JPlayer4Settlement1, JPlayer4Settlement2, JPlayer4Settlement3, JPlayer4Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player4SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player4SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player4SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player4SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else ArrayTurn ++;//If the program has not looped, +1 to ArrayTurn
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								break;
						}
						break;
					case 3://If 3 players have gone
						switch(order[1][ArrayTurn])
						{
							case 1://If player1 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player1.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player1.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer1Road0, JPlayer1Road1, JPlayer1Road2, JPlayer1Road3, JPlayer1Road4, JPlayer1Road5, JPlayer1Road6, JPlayer1Road7, JPlayer1Road8, JPlayer1Road9, JPlayer1Road10, JPlayer1Road11, JPlayer1Road12, JPlayer1Road13, JPlayer1Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player1.PlaceSettlement(PointX, PointY, TPlayer1Points, JPlayer1Settlement0, JPlayer1Settlement1, JPlayer1Settlement2, JPlayer1Settlement3, JPlayer1Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player1SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player1SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player1SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player1SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else Looped = true;//If the program has not looped, set Looped to be true so that the program knows to loop
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								break;
							case 2://If player2 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player2.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player2.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer2Road0, JPlayer2Road1, JPlayer2Road2, JPlayer2Road3, JPlayer2Road4, JPlayer2Road5, JPlayer2Road6, JPlayer2Road7, JPlayer2Road8, JPlayer2Road9, JPlayer2Road10, JPlayer2Road11, JPlayer2Road12, JPlayer2Road13, JPlayer2Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player2.PlaceSettlement(PointX, PointY, TPlayer2Points, JPlayer2Settlement0, JPlayer2Settlement1, JPlayer2Settlement2, JPlayer2Settlement3, JPlayer2Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player2SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player2SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player2SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player2SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else Looped = true;//If the program has not looped, set Looped to be true so that the program knows to loop
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								break;
							case 3://If player3 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player3.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player3.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer3Road0, JPlayer3Road1, JPlayer3Road2, JPlayer3Road3, JPlayer3Road4, JPlayer3Road5, JPlayer3Road6, JPlayer3Road7, JPlayer3Road8, JPlayer3Road9, JPlayer3Road10, JPlayer3Road11, JPlayer3Road12, JPlayer3Road13, JPlayer3Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player3.PlaceSettlement(PointX, PointY, TPlayer3Points, JPlayer3Settlement0, JPlayer3Settlement1, JPlayer3Settlement2, JPlayer3Settlement3, JPlayer3Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player3SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player3SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player3SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player3SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else Looped = true;//If the program has not looped, set Looped to be true so that the program knows to loop
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
								break;
							case 4://If player4 rolled the number in this position in the array
								if (event.getSource() == JRoad && PlacedRoad == false)//If the user has pressed the road button and the user has not already placed a road
								{
									RoadPlaceX = PointX+10;//Sets the x coordinate that the road is placed around
									RoadPlaceY = PointY+10;//Sets the y coordinate that the road is placed around
									
									MoveOn = player4.GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets where the road will be placed
									
									if (MoveOn == true)//If there is not a road already where the user wants to place the road
									{
										//Places the road
										player4.PlaceRoad(main.RoadPos, main.RoadPosPos, JPlayer4Road0, JPlayer4Road1, JPlayer4Road2, JPlayer4Road3, JPlayer4Road4, JPlayer4Road5, JPlayer4Road6, JPlayer4Road7, JPlayer4Road8, JPlayer4Road9, JPlayer4Road10, JPlayer4Road11, JPlayer4Road12, JPlayer4Road13, JPlayer4Road14);
										PlacedRoad = true;//Sets PlacedRoad to be true so the user cannot place another road
									}
									else MoveOn = true;
								}
								else if (event.getSource() == JSettlement && PlacedSettlement == false)//If user has pressed the settlement button and has not already placed a settlement
								{
									//Checks that there is not a settlement where the user wants to place one and that there is a road nearby
									if (!calcs.CheckHit(PointX,PointY,0,1,20,main.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, main.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, main.RoadPos))
									{
										//Places the settlement
										player4.PlaceSettlement(PointX, PointY, TPlayer4Points, JPlayer4Settlement0, JPlayer4Settlement1, JPlayer4Settlement2, JPlayer4Settlement3, JPlayer4Settlement4);
										PlacedSettlement = true;//Sets PlaceSettlement to be true so that the user cannot place another one
									}
									if (Looped == false)//If the program has not already looped 
									{
										Player4SettlementX0 = PointX;//Saves the x coordinate of the settlement in the variable
										Player4SettlementY0 = PointY;//Saves the y coordinate of the settlement in the variable
									}
									else//If the program has looped 
									{
										Player4SettlementX1 = PointX;//Saves the x coordinate of the settlement in the variable
										Player4SettlementY1 = PointY;//Saves the y coordinate of the settlement in the variable
									}
								}
								if (PlacedRoad == true && PlacedSettlement == true)//If the user has placed a settlement and a road
								{
									if (Looped == true) ArrayTurn --;//If the program has looped, -1 from ArrayTurn
									else Looped = true;//If the program has not looped, set Looped to be true so that the program knows to loop
									
									PlacedRoad = false;//Set PlacedRoad to be false so the next user can place a road
									PlacedSettlement = false;//Set PlacedSettlement to be false so the next user can place a settlement
								}
							break;
						}
						break;
				}
				break;
		}
		if (stage == 1) TPlayerTurn.setText("Player: " + order[1][ArrayTurn] + "'s turn");//If the game is in the 2nd stage, set TPlayerTurn to show which players turn it is
		if (Begin == false)//If all players have gone
		{
			//Giving the players the required resources
			for (int i = 1; i <= 12; i ++) resourcegive.Resource(i, main.SettlementPos, TPlayer1Wood, TPlayer2Wood, TPlayer3Wood, TPlayer4Wood, TPlayer1Stone, TPlayer2Stone, TPlayer3Stone, TPlayer4Stone, TPlayer1Sheep, TPlayer2Sheep, TPlayer3Sheep, TPlayer4Sheep, TPlayer1Wheat, TPlayer2Wheat, TPlayer3Wheat, TPlayer4Wheat, TPlayer1Brick, TPlayer2Brick, TPlayer3Brick, TPlayer4Brick);
		}
		return Begin;//Return begin so that the program knows not to run this class again
	}
	public int ReturnPlayer1SettlementX0()//Returns a Settlement x coordinate
	{
		return Player1SettlementX0;
	}
	public int ReturnPlayer1SettlementY0()//Returns a Settlement y coordinate
	{
		return Player1SettlementY0;
	}
	public int ReturnPlayer2SettlementX0()//Returns a Settlement x coordinate
	{
		return Player2SettlementX0;
	}
	public int ReturnPlayer2SettlementY0()//Returns a Settlement y coordinate
	{
		return Player2SettlementY0;
	}
	public int ReturnPlayer3SettlementX0()//Returns a Settlement x coordinate
	{
		return Player3SettlementX0;
	}
	public int ReturnPlayer3SettlementY0()//Returns a Settlement y coordinate
	{
		return Player3SettlementY0;
	}
	public int ReturnPlayer4SettlementX0()//Returns a Settlement x coordinate
	{
		return Player4SettlementX0;
	}
	public int ReturnPlayer4SettlementY0()//Returns a Settlement y coordinate
	{
		return Player4SettlementY0;
	}
	public int ReturnPlayer1SettlementX1()//Returns a Settlement x coordinate
	{
		return Player1SettlementX1;
	}
	public int ReturnPlayer1SettlementY1()//Returns a Settlement y coordinate
	{
		return Player1SettlementY1;
	}
	public int ReturnPlayer2SettlementX1()//Returns a Settlement x coordinate
	{
		return Player2SettlementX1;
	}
	public int ReturnPlayer2SettlementY1()//Returns a Settlement y coordinate
	{
		return Player2SettlementY1;
	}
	public int ReturnPlayer3SettlementX1()//Returns a Settlement x coordinate
	{
		return Player3SettlementX1;
	}
	public int ReturnPlayer3SettlementY1()//Returns a Settlement y coordinate
	{
		return Player3SettlementY1;
	}
	public int ReturnPlayer4SettlementX1()//Returns a Settlement x coordinate
	{
		return Player4SettlementX1;
	}
	public int ReturnPlayer4SettlementY1()//Returns a Settlement y coordinate
	{
		return Player4SettlementY1;
	}
}
