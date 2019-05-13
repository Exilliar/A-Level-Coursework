import javax.swing.JTextField;//Imported to allow use of TextFields

public class ResourceGive 
{
	Calcs calcs = new Calcs();//An object used to access the class calcs
	Main Main = new Main();//An object used to access the class Main
	//Giving Resources to players
		public void Resource(int rolled, int[][] Resources, JTextField Wood0, JTextField Wood1, JTextField Wood2, JTextField Wood3, JTextField Stone0, JTextField Stone1, JTextField Stone2, JTextField Stone3, JTextField Sheep0, JTextField Sheep1, JTextField Sheep2, JTextField Sheep3, JTextField Wheat0, JTextField Wheat1, JTextField Wheat2, JTextField Wheat3, JTextField Brick0, JTextField Brick1, JTextField Brick2, JTextField Brick3)
		{
			for (int x = 40; x <= 400; x += 40)//Cycles through x axis
			{
				for (int y = 260; y <= 460; y += 40)//Cycles through the y axis
				{
					if (CheckArray(x,y,60,rolled))//Checks if there is a tile with the rolled number at the current coordinates
					{
						int Pos = GetPos(x,y);//Sets the integer Pos to be the position in the array that the coordinates are currently on
						int xx = Main.AResource[0][Pos];//Sets the integer xx to be the current x coordinate of the tile that the coordinates are currently on
						int yy = Main.AResource[1][Pos];//Sets the integer yy to be the current y coordinate of the tile that the coordinates are currently on
						int Type = Main.AResource[2][Pos];//Sets the integer Type to be the type of resource on the tile that the current coordinates are on
						int Number = Main.AResource[3][Pos];//Sets the integer Number to be the number on the tile that the coordinates are currently on
						
						if (CheckSettlement(xx,yy))//Checks if there is a settlement/city next to the current tile
						{
							if (CheckCity(xx,yy))//Checks if there is a city near the current tile
							{
								int[] Players = ReturnCities(x,y);//Gets the players that have cities near the current tile
								for (int i = 0; i < 4; i ++)//Cycles through the array Players
								{
									if (Players[i] == 1) Main.PlayerResources[0][Type] ++;//If player 1 has a city near the current tile it adds 1 of the resource type of the current tile to their total
									else if (Players[i] == 2) Main.PlayerResources[1][Type] ++;//If player 2 has a city near the current tile it adds 1 of the resource type of the current tile to their total
									else if (Players[i] == 3) Main.PlayerResources[2][Type] ++;//If player 3 has a city near the current tile it adds 1 of the resource type of the current tile to their total
									else if (Players[i] == 4) Main.PlayerResources[3][Type] ++;//If player 4 has a city near the current tile it adds 1 of the resource type of the current tile to their total
								}
							}
							int[] Players = ReturnSettlements(x,y);//Gets the players that have settlements near the current tile
							for (int i = 0; i < 4; i ++)//Cycles through the array Players
							{
								if (Players[i] == 1) Main.PlayerResources[0][Type] ++;//If player 1 has a city near the current tile it adds 1 of the resource type of the current tile to their total
								else if (Players[i] == 2) Main.PlayerResources[1][Type] ++;//If player 1 has a city near the current tile it adds 1 of the resource type of the current tile to their total
								else if (Players[i] == 3) Main.PlayerResources[2][Type] ++;//If player 1 has a city near the current tile it adds 1 of the resource type of the current tile to their total
								else if (Players[i] == 4) Main.PlayerResources[3][Type] ++;//If player 1 has a city near the current tile it adds 1 of the resource type of the current tile to their total
							}
						}
						calcs.SetTextFields(Main.PlayerResources, Wood0, Wood1, Wood2, Wood3, Stone0, Stone1, Stone2, Stone3, Sheep0, Sheep1, Sheep2, Sheep3, Wheat0, Wheat1, Wheat2, Wheat3, Brick0, Brick1, Brick2, Brick3);//Changes the TextFields so that they show the new resource values
					}
				}
			}
		}
		public boolean CheckArray(int x, int y, int length, int number)//Checks if there is a tile with the rolled number on it
		{
			for (int i = 0; i < 60; i ++)//Cycles through the 2d array Main.AResource
			{
				if (Main.AResource[0][i] == x && Main.AResource[1][i] == y && Main.AResource[3][i] == number) return true;//If there is a tile that is at the current x and y coordinate and has the number that has been rolled assigned to it
			}
			return false;//Returns false if there is not a tile at the current coordinates and has the current rolled number
		}
		public int GetPos( int x, int y)//Gets the position in the 2d array Main.AResource that the tile at the current coordinates
		{
			for (int i = 0; i < 60; i ++)//Cycles through the 2d array Main.AResource
			{
				if (Main.AResource[0][i] == x && Main.AResource[1][i] == y) return i;//If the x and y coordinates are correct then it returns the position in the array that the x and y coordinates were at
			}
			return -1;//Returns -1 if there are no tiles near the current settlement (this should never be returned)
		}
		public boolean CheckSettlement(int x,int y)//Checks for if there is a settlement near the current tile (also checks for cities as coordinates are never removed from list when city added)
		{
			for (int i = 0; i < 20; i ++)//Cycles through the 2d array Main.SettlementPos
			{
				if (Main.SettlementPos[0][i] == x-20 && Main.SettlementPos[1][i] == y-20) return true;//If the settlement is at the top left of the tile returns true
				else if (Main.SettlementPos[0][i] == x-20 && Main.SettlementPos[1][i] == y+20) return true;//If the settlement is at the bottom left of the tile returns true
				else if (Main.SettlementPos[0][i] == x+20 && Main.SettlementPos[1][i] == y-20) return true;//If the settlement is at the top right of the tile returns true
				else if (Main.SettlementPos[0][i] == x+20 && Main.SettlementPos[1][i] == y+20) return true;//If the settlement is at the bottom right of the tile returns true
			}
			return false;//Returns false if there is not a settlement next to the current tile
		}
		public int[] ReturnSettlements(int x, int y)//Returns all of the players that have a settlement near the current tile
		{
			int[] Players = new int[4];//Sets up an array which stores all the players which have a settlement near the current tile
			int PlayersPos = 0;//Sets up an integer which is used to place data values in the array Players
			
			for (int i = 0; i < 20; i ++)//Cycles through the 2d array Main.SettlementPos
			{
				if (Main.SettlementPos[0][i] == x-20 && Main.SettlementPos[1][i] == y-20)//If the settlement is at the top left of the tile
				{
					Players[PlayersPos] = Main.SettlementPos[2][i];//Adds the player that has a settlement at this position to the array Players
					PlayersPos ++;//Adds 1 to PlayersPos
				}
				else if (Main.SettlementPos[0][i] == x-20 && Main.SettlementPos[1][i] == y+20)//If the settlement is at the bottom left of the tile 
				{
					Players[PlayersPos] = Main.SettlementPos[2][i];//Adds the player that has a settlement at this position to the array Players
					PlayersPos ++;//Adds 1 to PlayersPos
				}
				else if (Main.SettlementPos[0][i] == x+20 && Main.SettlementPos[1][i] == y-20)//If the settlement is at the top right of the tile
				{
					Players[PlayersPos] = Main.SettlementPos[2][i];//Adds the player that has a settlement at this position to the array Players
					PlayersPos ++;//Adds 1 to PlayersPos
				}
				else if (Main.SettlementPos[0][i] == x+20 && Main.SettlementPos[1][i] == y+20)//If the settlement is at the bottom right of the tile
				{
					Players[PlayersPos] = Main.SettlementPos[2][i];//Adds the player that has a settlement at this position to the array Players
					PlayersPos ++;//Adds 1 to PlayersPos
				}
			}
			
			return Players;//Returns the array Players
		}
		public boolean CheckCity(int x, int y)//Checks for any cities near the current tile
		{
			for (int i = 0; i < 16; i ++)//Cycles through the 2d array Main.CityPos
			{
				if (Main.CityPos[0][i] == x-20 && Main.CityPos[1][i] == y-20) return true;//If there is a city to the top left return true
				else if (Main.CityPos[0][i] == x-20 && Main.CityPos[1][i] == y+20) return true;//If there is a city to the bottom left return true
				else if (Main.CityPos[0][i] == x+20 && Main.CityPos[1][i] == y-20) return true;//If there is a city to the top right return true
				else if (Main.CityPos[0][i] == x+20 && Main.CityPos[1][i] == y+20) return true;//If there is a city to the bottom right return true
			}
			return false;//Returns false if there is not a city near the tile
		}
		public int[] ReturnCities(int x, int y)//Returns all of the players which have cities next to the current tile
		{
			int[] Players = new int[4];//Sets up an array which stores all the players which have a city near the current tile
			int PlayersPos = 0;//Sets up an integer which is used to place data values in the array Players
			
			for (int i = 0; i < 16; i ++)//Cycles through the 2d array Main.CityPos
			{
				if (Main.CityPos[0][i] == x-20 && Main.CityPos[1][i] == y-20)//If there is a city to the top left of the current tile
				{
					Players[PlayersPos] = Main.CityPos[2][i];//Adds the player that has a city at this position to the array Players
					PlayersPos ++;//Adds 1 to PlayersPos
				}
				else if (Main.CityPos[0][i] == x-20 && Main.CityPos[1][i] == y+20)//If there is a city to the top left of the current tile 
				{
					Players[PlayersPos] = Main.CityPos[2][i];//Adds the player that has a city at this position to the array Players
					PlayersPos ++;//Adds 1 to PlayersPos
				}
				else if (Main.CityPos[0][i] == x+20 && Main.CityPos[1][i] == y-20)//If there is a city to the top left of the current tile
				{
					Players[PlayersPos] = Main.CityPos[2][i];//Adds the player that has a city at this position to the array Players
					PlayersPos ++;//Adds 1 to PlayersPos
				}
				else if (Main.CityPos[0][i] == x+20 && Main.CityPos[1][i] == y+20)//If there is a city to the top left of the current tile 
				{
					Players[PlayersPos] = Main.CityPos[2][i];//Adds the player that has a city at this position to the array Players
					PlayersPos ++;//Adds 1 to PlayersPos
				}
			}
			
			return Players;//Returns the array Players
		}
}
