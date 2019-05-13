import java.awt.event.ActionEvent;//Imported to allow 

import javax.swing.JButton;//Imported to use buttons on GUI
import javax.swing.JLabel;//Imported to use JLabels on GUI
import javax.swing.JOptionPane;//Imported to use popups
import javax.swing.JTextField;//Imported to use TextFields 

public class Player4 
{
	//Setting up variables and assigning them values
	int RoadPlaceX;
	int RoadPlaceY;
	
	boolean MoveOn = true;
	
	int Player4Settlement0 = 15;
	int Player4Settlement1 = 16;
	int Player4Settlement2 = 17;
	int Player4Settlement3 = 18;
	int Player4Settlement4 = 19;
	
	int RRoadPosPos;
	int Player4RoadCurrent = 0;
	int Player4RoadMax = 15;
	
	int RCityPosPos;
	int Player4CityMax = 4;
	int Player4CityCurrent = 0;
	int Player4CityAm = 0;
	public static int[][] Player4CityPos = new int[2][4];
	
	int RSettlementPosPos;
	int Player4SettlementAm = 0;
	public static int[][] Player4SettlementPos = new int[2][5];
	
	Calcs calcs = new Calcs();//An object used to access the class Calcs
	public void setVars()
	{
		int b = 0;//Creates the int b and sets it to be 0
		for(int i = 150; i <= 170; i += 5)//Cycles through the positions that the settlements need to be
		{
			Player4SettlementPos[1][b] = i;//Adds the y coordinate of the settlement to the 2d array Player4SettlementPos
			b++;//Adds 1 to b
		}
	}
	public void setVars1()//Sets up the variables Player4SettlementAm and Player4RoadCurrent to be the correct values
	{
		Player4SettlementAm = 2;//Sets Player4SettlementAm to be 2
		Player4RoadCurrent = 2;//Sets Player2RoadCurrent to be 2
	}
	public void Go(ActionEvent event, JTextField TPlayer4Points, JButton JRoad, JButton JSettlement, JButton JCity, JLabel JPlayer4Road0, JLabel JPlayer4Road1, JLabel JPlayer4Road2, JLabel JPlayer4Road3, JLabel JPlayer4Road4, JLabel JPlayer4Road5, JLabel JPlayer4Road6, JLabel JPlayer4Road7, JLabel JPlayer4Road8, JLabel JPlayer4Road9, JLabel JPlayer4Road10, JLabel JPlayer4Road11, JLabel JPlayer4Road12, JLabel JPlayer4Road13, JLabel JPlayer4Road14, JLabel JPlayer4Settlement0, JLabel JPlayer4Settlement1, JLabel JPlayer4Settlement2, JLabel JPlayer4Settlement3, JLabel JPlayer4Settlement4, JLabel JPlayer4City0, JLabel JPlayer4City1, JLabel JPlayer4City2, JLabel JPlayer4City3, int PointX, int PointY, int[][] RoadPos, int RoadPosPos, int SettlementPosPos, int CityPosPos, int[][] CityPos, int[][] PlayerResources)
	{
		Main object = new Main();//An object used to access Main
		if (event.getSource() == JRoad && object.PlayerResources[3][0] >= 1 && object.PlayerResources[3][4] >= 1)//Checks that the button has been pressed and that the player has the required resources
		{
			RoadPlaceX = PointX+10;//Sets the X coordinate that the road will be placed around
			RoadPlaceY = PointY+10;//Sets the Y coordinate that the road will be placed around
			
			MoveOn = GetRoadDirection(RoadPlaceX,RoadPlaceY);//Gets the direction that the road will be placed (up, down, left, right)
			
			if (MoveOn == true && Player4RoadCurrent <= Player4RoadMax && calcs.RoadNear(RoadPlaceX, RoadPlaceY) == true)//Only allows the road to be placed if the player has a road left and if there is a road near
			{
				//Places the road on the board and adds the roads position to an array in Main
				PlaceRoad(RoadPos, RoadPosPos, JPlayer4Road0, JPlayer4Road1, JPlayer4Road2, JPlayer4Road3, JPlayer4Road4, JPlayer4Road5, JPlayer4Road6, JPlayer4Road7, JPlayer4Road8, JPlayer4Road9, JPlayer4Road10, JPlayer4Road11, JPlayer4Road12, JPlayer4Road13, JPlayer4Road14);
				object.PlayerResources[3][0] --;//Takes away a resource from the players total of the resource required to build a road
				object.PlayerResources[3][4] --;//Takes away a resource from the players total of the resource required to build a road
			}
			else MoveOn = true;//Sets MoveOn to be true so that the program can redo the operation if the button is pressed again
		}
		else if (event.getSource() == JSettlement && object.PlayerResources[3][4] >= 1 && object.PlayerResources[3][0] >= 1 && object.PlayerResources[3][3] >= 1 && object.PlayerResources[3][2] >= 1)//Checks that the button has been pressed and that the player has the required resources
		{
			if (!calcs.CheckHit(PointX,PointY,0,1,20,object.SettlementPos) && calcs.CheckNear(PointX+10, PointY+10, 0, 1, 20, object.SettlementPos) && calcs.CheckRoad(PointX+10, PointY+10, 0, 1, 60, object.RoadPos))//Checks that there is not already a settlement here and that there is a road next to it and that it is not within 1 tile of another settlement
			{
				//Places the settlement
				PlaceSettlement(PointX,PointY,TPlayer4Points,JPlayer4Settlement0,JPlayer4Settlement1,JPlayer4Settlement2,JPlayer4Settlement3,JPlayer4Settlement4);
				object.PlayerResources[3][4] --;//Takes away a resource from the players total of the required resource
				object.PlayerResources[3][0] --;//Takes away a resource from the players total of the required resource
				object.PlayerResources[3][3] --;//Takes away a resource from the players total of the required resource
				object.PlayerResources[3][2] --;//Takes away a resource from the players total of the required resource
			}
		}
		else if (event.getSource() == JCity && object.PlayerResources[3][3] >= 2 && object.PlayerResources[3][1] >= 3)//Checks that the button has been pressed and that the player has the required resources
		{
			if (calcs.CheckHit(PointX+10, PointY+10, 0, 1, 5, Player4SettlementPos) && Player4CityCurrent != Player4CityMax)//Checks that there is a settlement owned by the player at the selected point
			{
				//Add city
				object.PlayerResources[3][5] ++;//Adds 1 to the players total points
				object.PlayerResources[3][3] -= 2;//Takes away 2 resources from the players total of the required resource
				object.PlayerResources[3][1] -= 3;//Takes away 3 resources from the players total of the required resource
				TPlayer4Points.setText("Player 4 points = " + PlayerResources[3][5]);//Changes the textfield TPlayer4Points to show the players new
				Player4CityCurrent ++;//Adds 1 to the players total cities count
				switch(Player4CityAm)//Changes which city is moved to the position depending on which city the player is currently on
				{
					case 0://If no cities have been placed
						JPlayer4City0.setBounds(PointX+10,PointY+10,20,20);//Moves the city to the current position of the pointer
						
						object.CityPos[0][CityPosPos] = PointX;//Puts the cities x coordinate into the array CityPos so it can be accessed later in the program
						object.CityPos[1][CityPosPos] = PointY;//Puts the cities y coordinate into the array CityPos so it can be accessed later in the program
						object.CityPos[2][CityPosPos] = 4;//Puts the player that moved the cities player number into the array CityPosPos it can be accessed later in the program
						object.CityPosPos ++;//Adds 1 to CityPosPos so that no information is placed on top of other info in CityPos
						
						Player4CityPos[0][Player4CityAm] = PointX+10;//Puts the cities x coordinate into the array so it can be used later in the program
						Player4CityPos[1][Player4CityAm] = PointY+10;//Puts the cities y coordinate into the array so it can be used later in the program
						Player4CityAm ++;//Adds 1 to Player4CityAm to move on the point where information is added to
						
						break;
					case 1://If 1 city has been placed
						JPlayer4City1.setBounds(PointX+10, PointY+10, 20, 20);//Moves the city to the current position of the pointer

						object.CityPos[0][CityPosPos] = PointX;//Puts the cities x coordinate into the array CityPos so it can be accessed later in the program
						object.CityPos[1][CityPosPos] = PointY;//Puts the cities y coordinate into the array CityPos so it can be accessed later in the program
						object.CityPos[2][CityPosPos] = 4;//Puts the player that moved the cities player number into the array CityPosPos it can be accessed later in the program
						object.CityPosPos ++;//Adds 1 to CityPosPos so that no information is placed on top of other info in CityPos
						
						Player4CityPos[0][Player4CityAm] = PointX+10;//Puts the cities x coordinate into the array so it can be used later in the program
						Player4CityPos[1][Player4CityAm] = PointY+10;//Puts the cities y coordinate into the array so it can be used later in the program
						Player4CityAm ++;//Adds 1 to Player4CityAm to move on the point where information is added to
						
						break;
					case 2://If 2 cities have been placed
						JPlayer4City2.setBounds(PointX+10, PointY+10, 20, 20);//Moves the city to the current position of the pointer

						object.CityPos[0][CityPosPos] = PointX;//Puts the cities x coordinate into the array CityPos so it can be accessed later in the program
						object.CityPos[1][CityPosPos] = PointY;//Puts the cities y coordinate into the array CityPos so it can be accessed later in the program
						object.CityPos[2][CityPosPos] = 4;//Puts the player that moved the cities player number into the array CityPosPos it can be accessed later in the program
						object.CityPosPos ++;//Adds 1 to CityPosPos so that no information is placed on top of other info in CityPos
						
						Player4CityPos[0][Player4CityAm] = PointX+10;//Puts the cities x coordinate into the array so it can be used later in the program
						Player4CityPos[1][Player4CityAm] = PointY+10;//Puts the cities y coordinate into the array so it can be used later in the program
						Player4CityAm ++;//Adds 1 to Player4CityAm to move on the point where information is added to
						
						break;
					case 3://If 3 cities have been placed
						JPlayer4City3.setBounds(PointX+10, PointY+10, 20, 20);//Moves the city to the current position of the pointer

						object.CityPos[0][CityPosPos] = PointX;//Puts the cities x coordinate into the array CityPos so it can be accessed later in the program
						object.CityPos[1][CityPosPos] = PointY;//Puts the cities y coordinate into the array CityPos so it can be accessed later in the program
						object.CityPos[2][CityPosPos] = 4;//Puts the player that moved the cities player number into the array CityPosPos it can be accessed later in the program
						object.CityPosPos ++;//Adds 1 to CityPosPos so that no information is placed on top of other info in CityPos
						
						Player4CityPos[0][Player4CityAm] = PointX+10;//Puts the cities x coordinate into the array so it can be used later in the program
						Player4CityPos[1][Player4CityAm] = PointY+10;//Puts the cities y coordinate into the array so it can be used later in the program
						Player4CityAm ++;//Adds 1 to Player4CityAm to move on the point where information is added to
						
						break;
				}
				//Remove settlement
				int SettlementToMove = calcs.FindSettlement(PointX+10,PointY+10,0,1,5,Player4SettlementPos);//Finds the settlement that needs to be moved
				if (SettlementToMove != -1)//If there is a settlement where the city is now being placed (There always should be)
				{
					switch(SettlementToMove)//Switches based on the int SettlementToMove
					{
						case 0://If settlement0 needs to be moved
							JPlayer4Settlement0.setBounds(410,150,20,20);//Move the settlement
							
							Player4SettlementPos[0][0] = 410;//Set the new x coordinate
							Player4SettlementPos[1][0] = 150;//Set the new y coordinate
							
							break;
						case 1://If settlement1 needs to be moved
							JPlayer4Settlement1.setBounds(410,155,20,20);//Move the settlement
							
							Player4SettlementPos[0][1] = 410;//Set the new x coordinate
							Player4SettlementPos[1][1] = 155;//Set the new y coordinate
							
							break;
						case 2://If settlement2 needs to be moved
							JPlayer4Settlement2.setBounds(410,160,20,20);//Move the settlement
							
							Player4SettlementPos[0][2] = 410;//Set the new x coordinate
							Player4SettlementPos[1][2] = 160;//Set the new y coordinate
							
							break;
						case 3://If settlement3 needs to be moved
							JPlayer4Settlement3.setBounds(410,165,20,20);//Move the settlement
							
							Player4SettlementPos[0][3] = 410;//Set the new x coordinate
							Player4SettlementPos[1][3] = 165;//Set the new y coordinate
							
							break;
						case 4://If settlement4 needs to be moved
							JPlayer4Settlement4.setBounds(410,170,20,20);//Move the settlement
							
							Player4SettlementPos[0][4] = 410;//Set the new x coordinate
							Player4SettlementPos[1][4] = 170;//Set the new y coordinate
							
							break;
					}
				}
			}
		}
	}
	public boolean GetRoadDirection(int x, int y)//Gets the direction that the player has inputed for the road to be placed in
	{
		String SRoadPlace;//Setting up the string SRoadplace
		Main object = new Main();//An object used to access the class Main
		SRoadPlace = JOptionPane.showInputDialog(null, "Where do you want to place the road (up, down, left, right)");//Gets where the user want the road to be placed
		RoadPlaceY = y;//Sets RoadPlaceY to be the inputed y coordinate
		RoadPlaceX = x;//Sets RoadPlaceX to be the inputed x coordinate
		switch(SRoadPlace)//Switches depending on what the user has set SRoadPlace to be
		{
			case "up"://If the user wants to place the road upwards from the pointer
				if (!calcs.CheckHit(RoadPlaceX, RoadPlaceY-20, 0, 1, 60, object.RoadPos)) RoadPlaceY = y - 20;//Sets the new Road coordinate if there is not already a road there
				else//If there is a road where the user want to place one
				{
					JOptionPane.showMessageDialog(null, "There is already a road there");//Tells the user that they cannot place a road there
					MoveOn = false;//Sets MoveOn to be false so that the program knows not to place any roads
				}
				break;
			case "down": 
				if (!calcs.CheckHit(RoadPlaceX, RoadPlaceY+20, 0, 1, 60, object.RoadPos)) RoadPlaceY = y + 20;//Sets the new Road coordinate if there is not already a road there 
				else//If there is a road where the user want to place one
				{
					JOptionPane.showMessageDialog(null, "There is already a road there");//Tells the user that they cannot place a road there
					MoveOn = false;//Sets MoveOn to be false so that the program knows not to place any roads
				}
				break;
			case "right": 
				if (!calcs.CheckHit(RoadPlaceX+20, RoadPlaceY, 0, 1, 60, object.RoadPos)) RoadPlaceX = x + 20;//Sets the new Road coordinate if there is not already a road there
				else//If there is a road where the user want to place one
				{
					JOptionPane.showMessageDialog(null, "There is already a road there");//Tells the user that they cannot place a road there
					MoveOn = false;//Sets MoveOn to be false so that the program knows not to place any roads
				}
				break;
			case "left": 
				if (!calcs.CheckHit(RoadPlaceX-20, RoadPlaceY, 0, 1, 60, object.RoadPos)) RoadPlaceX = x - 20;//Sets the new Road coordinate  if there is not already a road there
				else//If there is a road where the user want to place one
				{
					JOptionPane.showMessageDialog(null, "There is already a road there");//Tells the user that they cannot place a road there
					MoveOn = false;//Sets MoveOn to be false so that the program knows not to place any roads
				}
				break;
			case "":
				JOptionPane.showMessageDialog(null, "You must enter a direction");//If the user has not entered any direction
				MoveOn = false;//Sets MoveOn to be false so that the program knows not to place any roads
				break;
				}
		return MoveOn;//Returns the boolean MoveOn
	}
	public void PlaceRoad(int[][] RoadPos, int RoadPosPos,JLabel JPlayer4Road0, JLabel JPlayer4Road1, JLabel JPlayer4Road2, JLabel JPlayer4Road3, JLabel JPlayer4Road4, JLabel JPlayer4Road5, JLabel JPlayer4Road6, JLabel JPlayer4Road7, JLabel JPlayer4Road8, JLabel JPlayer4Road9, JLabel JPlayer4Road10, JLabel JPlayer4Road11, JLabel JPlayer4Road12, JLabel JPlayer4Road13, JLabel JPlayer4Road14)
	{
		Main object = new Main();//Sets up an object used to access the class Main
		switch(Player4RoadCurrent)//Switches depending on how many roads the user has placed
		{
			case 0://If the player has not placed down any roads
				JPlayer4Road0.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 1://If the user has placed down 1 road
				JPlayer4Road1.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 2://If the user has placed down 2 roads
				JPlayer4Road2.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 3://If the user has placed down 3 roads
				JPlayer4Road3.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 4://If the user has placed down 4 roads
				JPlayer4Road4.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 5://If the user has placed down 5 roads
				JPlayer4Road5.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 6://If the user has placed down 6 roads
				JPlayer4Road6.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 7://If the user has placed down 7 roads
				JPlayer4Road7.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 8://If the user has placed down 8 roads
				JPlayer4Road8.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 9://If the user has placed down 9 roads
				JPlayer4Road9.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 10://If the user has placed down 10 roads
				JPlayer4Road10.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 11://If the user has placed down 11 roads
				JPlayer4Road11.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 12://If the user has placed down 12 roads
				JPlayer4Road12.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 13://If the user has placed down 13 roads
				JPlayer4Road13.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
			case 14://If the user has placed down 14 roads
				JPlayer4Road14.setBounds(RoadPlaceX, RoadPlaceY, 20, 20);//Moves the road
				
				object.RoadPos[0][RoadPosPos] = RoadPlaceX;//Sets the new x coordinate
				object.RoadPos[1][RoadPosPos] = RoadPlaceY;//Sets the new y coordinate
				object.RoadPosPos ++;//Moves the input point in the array along by 1
				
				Player4RoadCurrent ++;//Adds one to the current roads for this player
				
				break;
		}
	}
	public void PlaceSettlement(int PointX, int PointY, JTextField TPlayer4Points, JLabel JPlayer4Settlement0, JLabel JPlayer4Settlement1, JLabel JPlayer4Settlement2, JLabel JPlayer4Settlement3, JLabel JPlayer4Settlement4)
	{
		Main object = new Main();//An object used to access the class Main
		
		if (Player4SettlementPos[1][0] == 150)//If there is a settlement at x: 150
		{
			JPlayer4Settlement0.setBounds(PointX+10, PointY+10, 20, 20);//Moves the settlement
			
			object.SettlementPos[0][Player4Settlement0] = PointX;//Sets the new x coordinate
			object.SettlementPos[1][Player4Settlement0] = PointY;//Sets the new y coordinate
			object.SettlementPos[2][Player4Settlement0] = 4;//Sets the player which owns the settlement
			object.SettlementPosPos ++;//Adds 1 to SettlementPosPos in the class Main
		
			Player4SettlementPos[0][0] = PointX+10;//Sets the x coordinate
			Player4SettlementPos[1][0] = PointY+10;//Sets the y coordinate
			Player4SettlementAm ++;//Adds 1 to the settlement amount
		}
		else if (Player4SettlementPos[1][1] == 155)//If there is a settlement at x: 155
		{
			JPlayer4Settlement1.setBounds(PointX+10, PointY+10, 20, 20);//Moves the settlement
			
			object.SettlementPos[0][Player4Settlement1] = PointX;//Sets the new x coordinate
			object.SettlementPos[1][Player4Settlement1] = PointY;//Sets the new y coordinate
			object.SettlementPos[2][Player4Settlement1] = 4;//Sets the player which owns the settlement
			object.SettlementPosPos ++;//Adds 1 to SettlementPosPos in the class Main
			
			Player4SettlementPos[0][1] = PointX+10;//Sets the x coordinate
			Player4SettlementPos[1][1] = PointY+10;//Sets the y coordinate
			Player4SettlementAm ++;//Adds 1 to the settlement amount
		}
		else if (Player4SettlementPos[1][2] == 160)//If there is a settlement at x: 160
		{
			JPlayer4Settlement2.setBounds(PointX+10, PointY+10, 20, 20);//Moves the settlement
			
			object.SettlementPos[0][Player4Settlement2] = PointX;//Sets the new x coordinate
			object.SettlementPos[1][Player4Settlement2] = PointY;//Sets the new y coordinate
			object.SettlementPos[2][Player4Settlement2] = 4;//Sets the player which owns the settlement
			object.SettlementPosPos ++;//Adds 1 to SettlementPosPos in the class Main
			
			Player4SettlementPos[0][2] = PointX+10;//Sets the x coordinate
			Player4SettlementPos[1][2] = PointY+10;//Sets the y coordinate
			Player4SettlementAm ++;//Adds 1 to the settlement amount
		}
		else if (Player4SettlementPos[1][3] == 165)//If there is a settlement at x: 165
		{
			JPlayer4Settlement3.setBounds(PointX+10, PointY+10, 20, 20);//Moves the settlement
			
			object.SettlementPos[0][Player4Settlement3] = PointX;//Sets the new x coordinate
			object.SettlementPos[1][Player4Settlement3] = PointY;//Sets the new y coordinate
			object.SettlementPos[2][Player4Settlement3] = 4;//Sets the player which owns the settlement
			object.SettlementPosPos ++;//Adds 1 to SettlementPosPos in the class Main
			
			Player4SettlementPos[0][3] = PointX+10;//Sets the x coordinate
			Player4SettlementPos[1][3] = PointY+10;//Sets the y coordinate
			Player4SettlementAm ++;//Adds 1 to the settlement amount
		}
		else if (Player4SettlementPos[1][4] == 170)//If there is a settlement at x: 170
		{
			JPlayer4Settlement4.setBounds(PointX+10, PointY+10, 20, 20);//Moves the settlement
			
			object.SettlementPos[0][Player4Settlement4] = PointX;//Sets the new x coordinate
			object.SettlementPos[1][Player4Settlement4] = PointY;//Sets the new y coordinate
			object.SettlementPos[2][Player4Settlement4] = 4;//Sets the player which owns the settlement
			object.SettlementPosPos ++;//Adds 1 to SettlementPosPos in the class Main
			
			Player4SettlementPos[0][4] = PointX+10;//Sets the x coordinate
			Player4SettlementPos[1][4] = PointY+10;//Sets the y coordinate
			Player4SettlementAm ++;//Adds 1 to the settlement amount
		}
		object.PlayerResources[3][5] ++;
		TPlayer4Points.setText("Player 4 points = " + object.PlayerResources[3][5]);
	}
}
