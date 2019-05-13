import java.awt.event.ActionEvent;//Allows use inputs
import java.awt.event.ActionListener;//Allows program to listen for inputs
import java.util.concurrent.ThreadLocalRandom;//Allows use of random number generators

import javax.swing.ImageIcon;//Allows for adding ImageIcons which are used to add images to the GUI
import javax.swing.JButton;//Allows for use of buttons
import javax.swing.JFrame;//Allows creating a new JFrame
import javax.swing.JLabel;//Used for creating and adding images onto the GUI
import javax.swing.JOptionPane;//Used for creating popups
import javax.swing.JTextField;//Used for creating TextFields

public class Board extends JFrame
{
	//Object
	theHandler object = new theHandler();//An object to access the theHandler class
	Calcs calcs = new Calcs();//An object to access the Calcs class
	
	Player1 player1 = new Player1();//An object used to access the Player1 class
	Player2 player2 = new Player2();//An object used to access the Player2 class
	Player3 player3 = new Player3();//An object used to access the Player3 class
	Player4 player4 = new Player4();//An object used to access the Player4 class
	
	StartGame startgame = new StartGame();//An object used to access the StartGame class
	
	Main main = new Main();//An object used to access the Main class
	
	int Pos = 0;//Setting up an integer and assigning it a value
	int Turn = 1;//Setting up an integer and assigning it a value
	
	JLabel TNumber;
	
	boolean Begin = true;//Setting up a boolean and assigning it a value
	boolean Started = true;//Setting up a boolean and assigning it a value
	boolean Won = false;//Setting up a boolean and assigning it a value
	
	JButton JRulesGUI;//Setting up a JButton
	
	//Setting up variables, IageIcons, JLabels and TextFields
	//Images
	//Tiles
	ImageIcon IWoodTile;
	ImageIcon IStoneTile;
	ImageIcon ISheepTile;
	ImageIcon IWheatTile;
	ImageIcon IBrickTile;
	
	JLabel JWoodTile;
	JLabel JStoneTile;
	JLabel JSheepTile;
	JLabel JWheatTile;
	JLabel JBrickTile;
	
	//Pointer
	ImageIcon IPointer;
	
	JLabel JPointer;
	
	//Buildings
	//Player1
	//Roads (15)
	ImageIcon IPlayer1Road0;
	ImageIcon IPlayer1Road1;
	ImageIcon IPlayer1Road2;
	ImageIcon IPlayer1Road3;
	ImageIcon IPlayer1Road4;
	ImageIcon IPlayer1Road5;
	ImageIcon IPlayer1Road6;
	ImageIcon IPlayer1Road7;
	ImageIcon IPlayer1Road8;
	ImageIcon IPlayer1Road9;
	ImageIcon IPlayer1Road10;
	ImageIcon IPlayer1Road11;
	ImageIcon IPlayer1Road12;
	ImageIcon IPlayer1Road13;
	ImageIcon IPlayer1Road14;
	
	JLabel JPlayer1Road0;
	JLabel JPlayer1Road1;
	JLabel JPlayer1Road2;
	JLabel JPlayer1Road3;
	JLabel JPlayer1Road4;
	JLabel JPlayer1Road5;
	JLabel JPlayer1Road6;
	JLabel JPlayer1Road7;
	JLabel JPlayer1Road8;
	JLabel JPlayer1Road9;
	JLabel JPlayer1Road10;
	JLabel JPlayer1Road11;
	JLabel JPlayer1Road12;
	JLabel JPlayer1Road13;
	JLabel JPlayer1Road14;
	
	int Player1RoadAm = 0;//Setting up an integer and assigning it a value
	
	//Settlement (5)
	ImageIcon IPlayer1Settlement0;
	ImageIcon IPlayer1Settlement1;
	ImageIcon IPlayer1Settlement2;
	ImageIcon IPlayer1Settlement3;
	ImageIcon IPlayer1Settlement4;
	
	JLabel JPlayer1Settlement0;
	JLabel JPlayer1Settlement1;
	JLabel JPlayer1Settlement2;
	JLabel JPlayer1Settlement3;
	JLabel JPlayer1Settlement4;
	
	int Player1SettlementAm = 0;//Setting up an integer and assigning it a value
	
	//Cities (4)
	ImageIcon IPlayer1City0;
	ImageIcon IPlayer1City1;
	ImageIcon IPlayer1City2;
	ImageIcon IPlayer1City3;
	
	JLabel JPlayer1City0;
	JLabel JPlayer1City1;
	JLabel JPlayer1City2;
	JLabel JPlayer1City3;
	
	int Player1CityAm = 0;//Setting up an integer and assigning it a value
	
	//Player2
	//Roads (15)
	ImageIcon IPlayer2Road0;
	ImageIcon IPlayer2Road1;
	ImageIcon IPlayer2Road2;
	ImageIcon IPlayer2Road3;
	ImageIcon IPlayer2Road4;
	ImageIcon IPlayer2Road5;
	ImageIcon IPlayer2Road6;
	ImageIcon IPlayer2Road7;
	ImageIcon IPlayer2Road8;
	ImageIcon IPlayer2Road9;
	ImageIcon IPlayer2Road10;
	ImageIcon IPlayer2Road11;
	ImageIcon IPlayer2Road12;
	ImageIcon IPlayer2Road13;
	ImageIcon IPlayer2Road14;
	
	JLabel JPlayer2Road0;
	JLabel JPlayer2Road1;
	JLabel JPlayer2Road2;
	JLabel JPlayer2Road3;
	JLabel JPlayer2Road4;
	JLabel JPlayer2Road5;
	JLabel JPlayer2Road6;
	JLabel JPlayer2Road7;
	JLabel JPlayer2Road8;
	JLabel JPlayer2Road9;
	JLabel JPlayer2Road10;
	JLabel JPlayer2Road11;
	JLabel JPlayer2Road12;
	JLabel JPlayer2Road13;
	JLabel JPlayer2Road14;
	
	int Player2RoadAm = 0;//Setting up an integer and assigning it a value
	
	//Settlement (5)
	ImageIcon IPlayer2Settlement0;
	ImageIcon IPlayer2Settlement1;
	ImageIcon IPlayer2Settlement2;
	ImageIcon IPlayer2Settlement3;
	ImageIcon IPlayer2Settlement4;

	JLabel JPlayer2Settlement0;
	JLabel JPlayer2Settlement1;
	JLabel JPlayer2Settlement2;
	JLabel JPlayer2Settlement3;
	JLabel JPlayer2Settlement4;
	
	int Player2SettlementAm = 0;//Setting up an integer and assigning it a value
	
	//Cities (4)
	ImageIcon IPlayer2City0;
	ImageIcon IPlayer2City1;
	ImageIcon IPlayer2City2;
	ImageIcon IPlayer2City3;
	
	JLabel JPlayer2City0;
	JLabel JPlayer2City1;
	JLabel JPlayer2City2;
	JLabel JPlayer2City3;
	
	int Player2CityAm = 0;//Setting up an integer and assigning it a value
		
	//Player3
	//Roads (15)
	ImageIcon IPlayer3Road0;
	ImageIcon IPlayer3Road1;
	ImageIcon IPlayer3Road2;
	ImageIcon IPlayer3Road3;
	ImageIcon IPlayer3Road4;
	ImageIcon IPlayer3Road5;
	ImageIcon IPlayer3Road6;
	ImageIcon IPlayer3Road7;
	ImageIcon IPlayer3Road8;
	ImageIcon IPlayer3Road9;
	ImageIcon IPlayer3Road10;
	ImageIcon IPlayer3Road11;
	ImageIcon IPlayer3Road12;
	ImageIcon IPlayer3Road13;
	ImageIcon IPlayer3Road14;
	
	JLabel JPlayer3Road0;
	JLabel JPlayer3Road1;
	JLabel JPlayer3Road2;
	JLabel JPlayer3Road3;
	JLabel JPlayer3Road4;
	JLabel JPlayer3Road5;
	JLabel JPlayer3Road6;
	JLabel JPlayer3Road7;
	JLabel JPlayer3Road8;
	JLabel JPlayer3Road9;
	JLabel JPlayer3Road10;
	JLabel JPlayer3Road11;
	JLabel JPlayer3Road12;
	JLabel JPlayer3Road13;
	JLabel JPlayer3Road14;
	
	int Player3RoadAm = 0;//Setting up an integer and assigning it a value
	
	//Settlement (5)
	ImageIcon IPlayer3Settlement0;
	ImageIcon IPlayer3Settlement1;
	ImageIcon IPlayer3Settlement2;
	ImageIcon IPlayer3Settlement3;
	ImageIcon IPlayer3Settlement4;
	
	JLabel JPlayer3Settlement0;
	JLabel JPlayer3Settlement1;
	JLabel JPlayer3Settlement2;
	JLabel JPlayer3Settlement3;
	JLabel JPlayer3Settlement4;
	
	int Player3SettlementAm = 0;//Setting up an integer and assigning it a value
	
	//Cities (4)
	ImageIcon IPlayer3City0;
	ImageIcon IPlayer3City1;
	ImageIcon IPlayer3City2;
	ImageIcon IPlayer3City3;
	
	JLabel JPlayer3City0;
	JLabel JPlayer3City1;
	JLabel JPlayer3City2;
	JLabel JPlayer3City3;
	
	int Player3CityAm = 0;//Setting up an integer and assigning it a value
	
	//Player4
	//Roads (15)
	ImageIcon IPlayer4Road0;
	ImageIcon IPlayer4Road1;
	ImageIcon IPlayer4Road2;
	ImageIcon IPlayer4Road3;
	ImageIcon IPlayer4Road4;
	ImageIcon IPlayer4Road5;
	ImageIcon IPlayer4Road6;
	ImageIcon IPlayer4Road7;
	ImageIcon IPlayer4Road8;
	ImageIcon IPlayer4Road9;
	ImageIcon IPlayer4Road10;
	ImageIcon IPlayer4Road11;
	ImageIcon IPlayer4Road12;
	ImageIcon IPlayer4Road13;
	ImageIcon IPlayer4Road14;
	
	JLabel JPlayer4Road0;
	JLabel JPlayer4Road1;
	JLabel JPlayer4Road2;
	JLabel JPlayer4Road3;
	JLabel JPlayer4Road4;
	JLabel JPlayer4Road5;
	JLabel JPlayer4Road6;
	JLabel JPlayer4Road7;
	JLabel JPlayer4Road8;
	JLabel JPlayer4Road9;
	JLabel JPlayer4Road10;
	JLabel JPlayer4Road11;
	JLabel JPlayer4Road12;
	JLabel JPlayer4Road13;
	JLabel JPlayer4Road14;
	
	int Player4RoadAm = 0;//Setting up an integer and assigning it a value
	
	//Settlement (5)
	ImageIcon IPlayer4Settlement0;
	ImageIcon IPlayer4Settlement1;
	ImageIcon IPlayer4Settlement2;
	ImageIcon IPlayer4Settlement3;
	ImageIcon IPlayer4Settlement4;
	
	JLabel JPlayer4Settlement0;
	JLabel JPlayer4Settlement1;
	JLabel JPlayer4Settlement2;
	JLabel JPlayer4Settlement3;
	JLabel JPlayer4Settlement4;
	
	int Player4SettlementAm = 0;//Setting up an integer and assigning it a value
	
	//Cities (4)
	ImageIcon IPlayer4City0;
	ImageIcon IPlayer4City1;
	ImageIcon IPlayer4City2;
	ImageIcon IPlayer4City3;
	
	JLabel JPlayer4City0;
	JLabel JPlayer4City1;
	JLabel JPlayer4City2;
	JLabel JPlayer4City3;
	
	int Player4CityAm = 0;//Setting up an integer and assigning it a value
	
	//TextFields
	
	//Player Points
	JTextField TPlayer1Points;
	JTextField TPlayer2Points;
	JTextField TPlayer3Points;
	JTextField TPlayer4Points;
	
	//Player Wood
	JTextField TPlayer1Wood;
	JTextField TPlayer2Wood;
	JTextField TPlayer3Wood;
	JTextField TPlayer4Wood;
	
	//Player Stone
	JTextField TPlayer1Stone;
	JTextField TPlayer2Stone;
	JTextField TPlayer3Stone;
	JTextField TPlayer4Stone;
	
	//Player Sheep
	JTextField TPlayer1Sheep;
	JTextField TPlayer2Sheep;
	JTextField TPlayer3Sheep;
	JTextField TPlayer4Sheep;
	
	//Player Wheat
	JTextField TPlayer1Wheat;
	JTextField TPlayer2Wheat;
	JTextField TPlayer3Wheat;
	JTextField TPlayer4Wheat;
	
	//Player Brick
	JTextField TPlayer1Brick;
	JTextField TPlayer2Brick;
	JTextField TPlayer3Brick;
	JTextField TPlayer4Brick;
	
	//ShowTurn
	JTextField TTurn;
	
	//Dice
	JTextField TDice0;
	JTextField TDice1;
	JTextField TDiceTotal;
	
	//Trading
	//Players
	JTextField TTradePlayer1;
	JTextField TTradePlayer2;
	
	//Resource
	JTextField TTradeResource1;
	JTextField TTradeResource2;
	
	//Quantity
	JTextField TTradeQuantity1;
	JTextField TTradeQuantity2;
	
	//JButtons
	//Trade
	JButton JTrade;
	
	//Rolling
	JButton JRoll;
	
	//Movement of Pointer
	JButton JUp;
	JButton JDown;
	JButton JLeft;
	JButton JRight;
	
	//Building
	JButton JRoad;
	JButton JSettlement;
	JButton JCity;
	
	//Misc Controls
	JButton JEndTurn;
	
	public Board()
	{
		super("Board Game");//Sets the title of the program
		setLayout(null);//Sets the layout to be null so that I can position TextFields and images manually
		
		startgame.SetVars();//Gets StartGame to set up its basic variables
		
		//Info for the players
		//Player Points
		TPlayer1Points = new JTextField("Player 1 points = 0");//Creates the TextField and adds the text to it
		TPlayer1Points.setBounds(16, 16, 120, 20);//Sets the position and the size of the TextField
		TPlayer1Points.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer1Points);//Adds the TextField
		
		TPlayer2Points = new JTextField("Player 2 points = 0");//Creates the TextField and adds the text to it
		TPlayer2Points.setBounds(136, 16, 120, 20);//Sets the position and the size of the TextField
		TPlayer2Points.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer2Points);//Adds the TextField
		
		TPlayer3Points = new JTextField("Player 3 points = 0");//Creates the TextField and adds the text to it
		TPlayer3Points.setBounds(256, 16, 120, 20);//Sets the position and the size of the TextField
		TPlayer3Points.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer3Points);//Adds the TextField
		
		TPlayer4Points = new JTextField("Player 4 points = 0");//Creates the TextField and adds the text to it
		TPlayer4Points.setBounds(376, 16, 120, 20);//Sets the position and the size of the TextField
		TPlayer4Points.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer4Points);//Adds the TextField
		
		//Player Wood
		TPlayer1Wood = new JTextField("Player 1 wood = 0");//Creates the TextField and adds the text to it
		TPlayer1Wood.setBounds(16,36,120,20);//Sets the position and the size of the TextField
		TPlayer1Wood.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer1Wood);//Adds the TextField
		
		TPlayer2Wood = new JTextField("Player 2 wood = 0");//Creates the TextField and adds the text to it
		TPlayer2Wood.setBounds(136,36,120,20);//Sets the position and the size of the TextField
		TPlayer2Wood.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer2Wood);//Adds the TextField
		
		TPlayer3Wood = new JTextField("Player 3 wood = 0");//Creates the TextField and adds the text to it
		TPlayer3Wood.setBounds(256,36,120,20);//Sets the position and the size of the TextField
		TPlayer3Wood.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer3Wood);//Adds the TextField
		
		TPlayer4Wood = new JTextField("Player 4 wood = 0");//Creates the TextField and adds the text to it
		TPlayer4Wood.setBounds(376,36,120,20);//Sets the position and the size of the TextField
		TPlayer4Wood.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer4Wood);//Adds the TextField
		
		//Player Stone
		TPlayer1Stone = new JTextField("Player 1 stone = 0");//Creates the TextField and adds the text to it
		TPlayer1Stone.setBounds(16, 56, 120, 20);//Sets the position and the size of the TextField
		TPlayer1Stone.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer1Stone);//Adds the TextField
		
		TPlayer2Stone = new JTextField("Player 2 stone = 0");//Creates the TextField and adds the text to it
		TPlayer2Stone.setBounds(136, 56, 120, 20);//Sets the position and the size of the TextField
		TPlayer2Stone.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer2Stone);//Adds the TextField
		
		TPlayer3Stone = new JTextField("Player 3 stone = 0");//Creates the TextField and adds the text to it
		TPlayer3Stone.setBounds(256, 56, 120, 20);//Sets the position and the size of the TextField
		TPlayer3Stone.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer3Stone);//Adds the TextField
		
		TPlayer4Stone = new JTextField("Player 4 stone = 0");//Creates the TextField and adds the text to it
		TPlayer4Stone.setBounds(376, 56, 120, 20);//Sets the position and the size of the TextField
		TPlayer4Stone.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer4Stone);//Adds the TextField
		
		//Player Sheep
		TPlayer1Sheep = new JTextField("Player 1 sheep = 0");//Creates the TextField and adds the text to it
		TPlayer1Sheep.setBounds(16, 76, 120, 20);//Sets the position and the size of the TextField
		TPlayer1Sheep.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer1Sheep);//Adds the TextField
		
		TPlayer2Sheep = new JTextField("Player 2 sheep = 0");//Creates the TextField and adds the text to it
		TPlayer2Sheep.setBounds(136, 76, 120, 20);//Sets the position and the size of the TextField
		TPlayer2Sheep.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer2Sheep);//Adds the TextField
		
		TPlayer3Sheep = new JTextField("Player 3 sheep = 0");//Creates the TextField and adds the text to it
		TPlayer3Sheep.setBounds(256, 76, 120, 20);//Sets the position and the size of the TextField
		TPlayer3Sheep.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer3Sheep);//Adds the TextField
		
		TPlayer4Sheep = new JTextField("Player 4 sheep = 0");//Creates the TextField and adds the text to it
		TPlayer4Sheep.setBounds(376, 76, 120, 20);//Sets the position and the size of the TextField
		TPlayer4Sheep.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer4Sheep);//Adds the TextField
		
		//Player Wheat
		TPlayer1Wheat = new JTextField("Player 1 wheat = 0");//Creates the TextField and adds the text to it
		TPlayer1Wheat.setBounds(16, 96, 120, 20);//Sets the position and the size of the TextField
		TPlayer1Wheat.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer1Wheat);//Adds the TextField
		
		TPlayer2Wheat = new JTextField("Player 2 wheat = 0");//Creates the TextField and adds the text to it
		TPlayer2Wheat.setBounds(136, 96, 120, 20);//Sets the position and the size of the TextField
		TPlayer2Wheat.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer2Wheat);//Adds the TextField
		
		TPlayer3Wheat = new JTextField("Player 3 wheat = 0");//Creates the TextField and adds the text to it
		TPlayer3Wheat.setBounds(256, 96, 120, 20);//Sets the position and the size of the TextField
		TPlayer3Wheat.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer3Wheat);//Adds the TextField
		
		TPlayer4Wheat = new JTextField("Player 4 wheat = 0");//Creates the TextField and adds the text to it
		TPlayer4Wheat.setBounds(376, 96, 120, 20);//Sets the position and the size of the TextField
		TPlayer4Wheat.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer4Wheat);//Adds the TextField
		
		//Player Brick
		TPlayer1Brick = new JTextField("Player 1 brick = 0");//Creates the TextField and adds the text to it
		TPlayer1Brick.setBounds(16, 116, 120, 20);//Sets the position and the size of the TextField
		TPlayer1Brick.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer1Brick);//Adds the TextField
		
		TPlayer2Brick = new JTextField("Player 2 brick = 0");//Creates the TextField and adds the text to it
		TPlayer2Brick.setBounds(136, 116, 120, 20);//Sets the position and the size of the TextField
		TPlayer2Brick.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer2Brick);//Adds the TextField
		
		TPlayer3Brick = new JTextField("Player 3 brick = 0");//Creates the TextField and adds the text to it
		TPlayer3Brick.setBounds(256, 116, 120, 20);//Sets the position and the size of the TextField
		TPlayer3Brick.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer3Brick);//Adds the TextField
		
		TPlayer4Brick = new JTextField("Player 4 brick = 0");//Creates the TextField and adds the text to it
		TPlayer4Brick.setBounds(376, 116, 120, 20);//Sets the position and the size of the TextField
		TPlayer4Brick.setEditable(false);//Sets the TextField to not be editable by the user
		add(TPlayer4Brick);//Adds the TextField
		
		//Roads
		//Player 1
		IPlayer1Road0 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road0 = new JLabel(IPlayer1Road0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road0.setBounds(16, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road0);//Adds the image
		
		IPlayer1Road1 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road1 = new JLabel(IPlayer1Road1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road1.setBounds(16, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road1);//Adds the image
		
		IPlayer1Road2 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road2 = new JLabel(IPlayer1Road2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road2.setBounds(16, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road2);//Adds the image
		
		IPlayer1Road3 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road3 = new JLabel(IPlayer1Road3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road3.setBounds(16, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road3);//Adds the image
		
		IPlayer1Road4 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road4 = new JLabel(IPlayer1Road4);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road4.setBounds(16, 170, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road4);//Adds the image
		
		IPlayer1Road5 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road5 = new JLabel(IPlayer1Road5);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road5.setBounds(16, 175, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road5);//Adds the image
		
		IPlayer1Road6 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road6 = new JLabel(IPlayer1Road6);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road6.setBounds(16, 180, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road6);//Adds the image
		
		IPlayer1Road7 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road7 = new JLabel(IPlayer1Road7);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road7.setBounds(16, 185, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road7);//Adds the image
		
		IPlayer1Road8 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road8 = new JLabel(IPlayer1Road8);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road8.setBounds(16, 190, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road8);//Adds the image
		
		IPlayer1Road9 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road9 = new JLabel(IPlayer1Road9);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road9.setBounds(16, 195, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road9);//Adds the image
		
		IPlayer1Road10 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road10 = new JLabel(IPlayer1Road10);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road10.setBounds(16, 200, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road10);//Adds the image
		
		IPlayer1Road11 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road11 = new JLabel(IPlayer1Road11);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road11.setBounds(16, 205, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road11);//Adds the image
		
		IPlayer1Road12 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road12 = new JLabel(IPlayer1Road12);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road12.setBounds(16, 210, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road12);//Adds the image
		
		IPlayer1Road13 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road13 = new JLabel(IPlayer1Road13);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road13.setBounds(16, 215, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road13);//Adds the image
		
		IPlayer1Road14 = new ImageIcon("../Road1.png");//Tells the program which image to use
		JPlayer1Road14 = new JLabel(IPlayer1Road14);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Road14.setBounds(16, 220, 20, 20);//Sets the position and size of the image
		add(JPlayer1Road14);//Adds the image
		
		//Settlements
		IPlayer1Settlement0 = new ImageIcon("../Settlement1.png");//Tells the program which image to use
		JPlayer1Settlement0 = new JLabel(IPlayer1Settlement0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Settlement0.setBounds(50, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer1Settlement0);//Adds the image
		
		IPlayer1Settlement1 = new ImageIcon("../Settlement1.png");//Tells the program which image to use
		JPlayer1Settlement1 = new JLabel(IPlayer1Settlement1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Settlement1.setBounds(50, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer1Settlement1);//Adds the image
		
		IPlayer1Settlement2 = new ImageIcon("../Settlement1.png");//Tells the program which image to use
		JPlayer1Settlement2 = new JLabel(IPlayer1Settlement2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Settlement2.setBounds(50, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer1Settlement2);//Adds the image
		
		IPlayer1Settlement3 = new ImageIcon("../Settlement1.png");//Tells the program which image to use
		JPlayer1Settlement3 = new JLabel(IPlayer1Settlement3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Settlement3.setBounds(50, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer1Settlement3);//Adds the image
		
		IPlayer1Settlement4 = new ImageIcon("../Settlement1.png");//Tells the program which image to use
		JPlayer1Settlement4 = new JLabel(IPlayer1Settlement4);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1Settlement4.setBounds(50, 170, 20, 20);//Sets the position and size of the image
		add(JPlayer1Settlement4);//Adds the image
		
		//Cities
		IPlayer1City0 = new ImageIcon("../city1.png");//Tells the program which image to use
		JPlayer1City0 = new JLabel(IPlayer1City0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1City0.setBounds(100, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer1City0);//Adds the image
		
		IPlayer1City1 = new ImageIcon("../city1.png");//Tells the program which image to use
		JPlayer1City1 = new JLabel(IPlayer1City1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1City1.setBounds(100, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer1City1);//Adds the image
		
		IPlayer1City2 = new ImageIcon("../city1.png");//Tells the program which image to use
		JPlayer1City2 = new JLabel(IPlayer1City2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1City2.setBounds(100, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer1City2);//Adds the image
		
		IPlayer1City3 = new ImageIcon("../city1.png");//Tells the program which image to use
		JPlayer1City3 = new JLabel(IPlayer1City3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer1City3.setBounds(100, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer1City3);//Adds the image
		
		//Roads
		//Player 2
		IPlayer2Road0 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road0 = new JLabel(IPlayer2Road0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road0.setBounds(136, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road0);//Adds the image

		IPlayer2Road1 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road1 = new JLabel(IPlayer2Road1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road1.setBounds(136, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road1);//Adds the image

		IPlayer2Road2 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road2 = new JLabel(IPlayer2Road2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road2.setBounds(136, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road2);//Adds the image

		IPlayer2Road3 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road3 = new JLabel(IPlayer2Road3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road3.setBounds(136, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road3);//Adds the image

		IPlayer2Road4 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road4 = new JLabel(IPlayer2Road4);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road4.setBounds(136, 170, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road4);//Adds the image

		IPlayer2Road5 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road5 = new JLabel(IPlayer2Road5);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road5.setBounds(136, 175, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road5);//Adds the image

		IPlayer2Road6 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road6 = new JLabel(IPlayer2Road6);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road6.setBounds(136, 180, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road6);//Adds the image

		IPlayer2Road7 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road7 = new JLabel(IPlayer2Road7);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road7.setBounds(136, 185, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road7);//Adds the image

		IPlayer2Road8 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road8 = new JLabel(IPlayer2Road8);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road8.setBounds(136, 190, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road8);//Adds the image

		IPlayer2Road9 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road9 = new JLabel(IPlayer2Road9);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road9.setBounds(136, 195, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road9);//Adds the image

		IPlayer2Road10 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road10 = new JLabel(IPlayer2Road10);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road10.setBounds(136, 200, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road10);//Adds the image

		IPlayer2Road11 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road11 = new JLabel(IPlayer2Road11);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road11.setBounds(136, 205, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road11);//Adds the image

		IPlayer2Road12 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road12 = new JLabel(IPlayer2Road12);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road12.setBounds(136, 210, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road12);//Adds the image

		IPlayer2Road13 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road13 = new JLabel(IPlayer2Road13);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road13.setBounds(136, 215, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road13);//Adds the image

		IPlayer2Road14 = new ImageIcon("../Road2.png");//Tells the program which image to use
		JPlayer2Road14 = new JLabel(IPlayer2Road14);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Road14.setBounds(136, 220, 20, 20);//Sets the position and size of the image
		add(JPlayer2Road14);//Adds the image

		//Settlements
		IPlayer2Settlement0 = new ImageIcon("../Settlement2.png");//Tells the program which image to use
		JPlayer2Settlement0 = new JLabel(IPlayer2Settlement0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Settlement0.setBounds(170, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer2Settlement0);//Adds the image

		IPlayer2Settlement1 = new ImageIcon("../Settlement2.png");//Tells the program which image to use
		JPlayer2Settlement1 = new JLabel(IPlayer2Settlement1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Settlement1.setBounds(170, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer2Settlement1);//Adds the image

		IPlayer2Settlement2 = new ImageIcon("../Settlement2.png");//Tells the program which image to use
		JPlayer2Settlement2 = new JLabel(IPlayer2Settlement2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Settlement2.setBounds(170, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer2Settlement2);//Adds the image

		IPlayer2Settlement3 = new ImageIcon("../Settlement2.png");//Tells the program which image to use
		JPlayer2Settlement3 = new JLabel(IPlayer2Settlement3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Settlement3.setBounds(170, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer2Settlement3);//Adds the image

		IPlayer2Settlement4 = new ImageIcon("../Settlement2.png");//Tells the program which image to use
		JPlayer2Settlement4 = new JLabel(IPlayer2Settlement4);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2Settlement4.setBounds(170, 170, 20, 20);//Sets the position and size of the image
		add(JPlayer2Settlement4);//Adds the image

		//Cities
		IPlayer2City0 = new ImageIcon("../City2.png");//Tells the program which image to use
		JPlayer2City0 = new JLabel(IPlayer2City0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2City0.setBounds(220, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer2City0);//Adds the image

		IPlayer2City1 = new ImageIcon("../City2.png");//Tells the program which image to use
		JPlayer2City1 = new JLabel(IPlayer2City1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2City1.setBounds(220, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer2City1);//Adds the image

		IPlayer2City2 = new ImageIcon("../City2.png");//Tells the program which image to use
		JPlayer2City2 = new JLabel(IPlayer2City2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2City2.setBounds(220, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer2City2);//Adds the image

		IPlayer2City3 = new ImageIcon("../City2.png");//Tells the program which image to use
		JPlayer2City3 = new JLabel(IPlayer2City3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer2City3.setBounds(220, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer2City3);//Adds the image
		
		//Roads
		//Player 3
		IPlayer3Road0 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road0 = new JLabel(IPlayer3Road0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road0.setBounds(256, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road0);//Adds the image

		IPlayer3Road1 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road1 = new JLabel(IPlayer3Road1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road1.setBounds(256, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road1);//Adds the image

		IPlayer3Road2 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road2 = new JLabel(IPlayer3Road2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road2.setBounds(256, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road2);//Adds the image

		IPlayer3Road3 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road3 = new JLabel(IPlayer3Road3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road3.setBounds(256, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road3);//Adds the image

		IPlayer3Road4 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road4 = new JLabel(IPlayer3Road4);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road4.setBounds(256, 170, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road4);//Adds the image

		IPlayer3Road5 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road5 = new JLabel(IPlayer3Road5);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road5.setBounds(256, 175, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road5);//Adds the image

		IPlayer3Road6 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road6 = new JLabel(IPlayer3Road6);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road6.setBounds(256, 180, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road6);//Adds the image

		IPlayer3Road7 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road7 = new JLabel(IPlayer3Road7);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road7.setBounds(256, 185, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road7);//Adds the image

		IPlayer3Road8 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road8 = new JLabel(IPlayer3Road8);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road8.setBounds(256, 190, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road8);//Adds the image

		IPlayer3Road9 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road9 = new JLabel(IPlayer3Road9);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road9.setBounds(256, 195, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road9);//Adds the image

		IPlayer3Road10 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road10 = new JLabel(IPlayer3Road10);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road10.setBounds(256, 200, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road10);//Adds the image

		IPlayer3Road11 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road11 = new JLabel(IPlayer3Road11);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road11.setBounds(256, 205, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road11);//Adds the image

		IPlayer3Road12 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road12 = new JLabel(IPlayer3Road12);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road12.setBounds(256, 210, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road12);//Adds the image

		IPlayer3Road13 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road13 = new JLabel(IPlayer3Road13);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road13.setBounds(256, 215, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road13);//Adds the image

		IPlayer3Road14 = new ImageIcon("../Road3.png");//Tells the program which image to use
		JPlayer3Road14 = new JLabel(IPlayer3Road14);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Road14.setBounds(256, 220, 20, 20);//Sets the position and size of the image
		add(JPlayer3Road14);//Adds the image

		//Settlements
		IPlayer3Settlement0 = new ImageIcon("../Settlement3.png");//Tells the program which image to use
		JPlayer3Settlement0 = new JLabel(IPlayer3Settlement0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Settlement0.setBounds(290, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer3Settlement0);//Adds the image

		IPlayer3Settlement1 = new ImageIcon("../Settlement3.png");//Tells the program which image to use
		JPlayer3Settlement1 = new JLabel(IPlayer3Settlement1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Settlement1.setBounds(290, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer3Settlement1);//Adds the image

		IPlayer3Settlement2 = new ImageIcon("../Settlement3.png");//Tells the program which image to use
		JPlayer3Settlement2 = new JLabel(IPlayer3Settlement2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Settlement2.setBounds(290, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer3Settlement2);//Adds the image

		IPlayer3Settlement3 = new ImageIcon("../Settlement3.png");//Tells the program which image to use
		JPlayer3Settlement3 = new JLabel(IPlayer3Settlement3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Settlement3.setBounds(290, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer3Settlement3);//Adds the image

		IPlayer3Settlement4 = new ImageIcon("../Settlement3.png");//Tells the program which image to use
		JPlayer3Settlement4 = new JLabel(IPlayer3Settlement4);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3Settlement4.setBounds(290, 170, 20, 20);//Sets the position and size of the image
		add(JPlayer3Settlement4);//Adds the image

		//Cities
		IPlayer3City0 = new ImageIcon("../City3.png");//Tells the program which image to use
		JPlayer3City0 = new JLabel(IPlayer3City0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3City0.setBounds(340, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer3City0);//Adds the image

		IPlayer3City1 = new ImageIcon("../City3.png");//Tells the program which image to use
		JPlayer3City1 = new JLabel(IPlayer3City1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3City1.setBounds(340, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer3City1);//Adds the image

		IPlayer3City2 = new ImageIcon("../City3.png");//Tells the program which image to use
		JPlayer3City2 = new JLabel(IPlayer3City2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3City2.setBounds(340, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer3City2);//Adds the image

		IPlayer3City3 = new ImageIcon("../City3.png");//Tells the program which image to use
		JPlayer3City3 = new JLabel(IPlayer3City3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer3City3.setBounds(340, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer3City3);//Adds the image
		
		//Roads
		//Player 4
		IPlayer4Road0 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road0 = new JLabel(IPlayer4Road0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road0.setBounds(376, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road0);//Adds the image

		IPlayer4Road1 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road1 = new JLabel(IPlayer4Road1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road1.setBounds(376, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road1);//Adds the image

		IPlayer4Road2 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road2 = new JLabel(IPlayer4Road2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road2.setBounds(376, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road2);//Adds the image

		IPlayer4Road3 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road3 = new JLabel(IPlayer4Road3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road3.setBounds(376, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road3);//Adds the image

		IPlayer4Road4 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road4 = new JLabel(IPlayer4Road4);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road4.setBounds(376, 170, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road4);//Adds the image

		IPlayer4Road5 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road5 = new JLabel(IPlayer4Road5);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road5.setBounds(376, 175, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road5);//Adds the image

		IPlayer4Road6 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road6 = new JLabel(IPlayer4Road6);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road6.setBounds(376, 180, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road6);//Adds the image

		IPlayer4Road7 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road7 = new JLabel(IPlayer4Road7);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road7.setBounds(376, 185, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road7);//Adds the image

		IPlayer4Road8 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road8 = new JLabel(IPlayer4Road8);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road8.setBounds(376, 190, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road8);//Adds the image

		IPlayer4Road9 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road9 = new JLabel(IPlayer4Road9);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road9.setBounds(376, 195, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road9);//Adds the image

		IPlayer4Road10 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road10 = new JLabel(IPlayer4Road10);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road10.setBounds(376, 200, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road10);//Adds the image

		IPlayer4Road11 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road11 = new JLabel(IPlayer4Road11);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road11.setBounds(376, 205, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road11);//Adds the image

		IPlayer4Road12 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road12 = new JLabel(IPlayer4Road12);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road12.setBounds(376, 210, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road12);//Adds the image

		IPlayer4Road13 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road13 = new JLabel(IPlayer4Road13);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road13.setBounds(376, 215, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road13);//Adds the image

		IPlayer4Road14 = new ImageIcon("../Road4.png");//Tells the program which image to use
		JPlayer4Road14 = new JLabel(IPlayer4Road14);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Road14.setBounds(376, 220, 20, 20);//Sets the position and size of the image
		add(JPlayer4Road14);//Adds the image

		//Settlements
		IPlayer4Settlement0 = new ImageIcon("../Settlement4.png");//Tells the program which image to use
		JPlayer4Settlement0 = new JLabel(IPlayer4Settlement0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Settlement0.setBounds(410, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer4Settlement0);//Adds the image

		IPlayer4Settlement1 = new ImageIcon("../Settlement4.png");//Tells the program which image to use
		JPlayer4Settlement1 = new JLabel(IPlayer4Settlement1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Settlement1.setBounds(410, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer4Settlement1);//Adds the image

		IPlayer4Settlement2 = new ImageIcon("../Settlement4.png");//Tells the program which image to use
		JPlayer4Settlement2 = new JLabel(IPlayer4Settlement2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Settlement2.setBounds(410, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer4Settlement2);//Adds the image

		IPlayer4Settlement3 = new ImageIcon("../Settlement4.png");//Tells the program which image to use
		JPlayer4Settlement3 = new JLabel(IPlayer4Settlement3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Settlement3.setBounds(410, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer4Settlement3);//Adds the image

		IPlayer4Settlement4 = new ImageIcon("../Settlement4.png");//Tells the program which image to use
		JPlayer4Settlement4 = new JLabel(IPlayer4Settlement4);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4Settlement4.setBounds(410, 170, 20, 20);//Sets the position and size of the image
		add(JPlayer4Settlement4);//Adds the image

		//Cities
		IPlayer4City0 = new ImageIcon("../City4.png");//Tells the program which image to use
		JPlayer4City0 = new JLabel(IPlayer4City0);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4City0.setBounds(460, 150, 20, 20);//Sets the position and size of the image
		add(JPlayer4City0);//Adds the image

		IPlayer4City1 = new ImageIcon("../City4.png");//Tells the program which image to use
		JPlayer4City1 = new JLabel(IPlayer4City1);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4City1.setBounds(460, 155, 20, 20);//Sets the position and size of the image
		add(JPlayer4City1);//Adds the image

		IPlayer4City2 = new ImageIcon("../City4.png");//Tells the program which image to use
		JPlayer4City2 = new JLabel(IPlayer4City2);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4City2.setBounds(460, 160, 20, 20);//Sets the position and size of the image
		add(JPlayer4City2);//Adds the image

		IPlayer4City3 = new ImageIcon("../City4.png");//Tells the program which image to use
		JPlayer4City3 = new JLabel(IPlayer4City3);//Creates a JLabel and sets it to be the ImageIcon
		JPlayer4City3.setBounds(460, 165, 20, 20);//Sets the position and size of the image
		add(JPlayer4City3);//Adds the image
		
		//Show Player Turn
		TTurn = new JTextField("Player 1's turn");//Creates the TextField and adds the text to it
		TTurn.setBounds(496,16,105,20);//Sets the position and the size of the TextField
		TTurn.setEditable(false);//Sets the TextField to not be editable by the user
		add(TTurn);//Adds the TextField to the GUI
		
		//Trading
		//Players
		TTradePlayer1 = new JTextField("Trade Player 1");//Creates the TextField and adds the text to it
		TTradePlayer1.setBounds(600,16,120,20);//Sets the position and the size of the TextField
		add(TTradePlayer1);//Adds the TextField
		
		TTradePlayer2 = new JTextField("Trade Player 2");//Creates the TextField and adds the text to it
		TTradePlayer2.setBounds(720,16,120,20);//Sets the position and the size of the TextField
		add(TTradePlayer2);//Adds the TextField
		
		//Resources
		TTradeResource1 = new JTextField("Resource 1");//Creates the TextField and adds the text to it
		TTradeResource1.setBounds(600, 36, 120, 20);//Sets the position and the size of the TextField
		add(TTradeResource1);//Adds the TextField
		
		TTradeResource2 = new JTextField("Resource 2");//Creates the TextField and adds the text to it
		TTradeResource2.setBounds(720, 36, 120, 20);//Sets the position and the size of the TextField
		add(TTradeResource2);//Adds the TextField
		
		//Quantity
		TTradeQuantity1 = new JTextField("Quantity 1");//Creates the TextField and adds the text to it
		TTradeQuantity1.setBounds(600, 56, 120, 20);//Sets the position and the size of the TextField
		add(TTradeQuantity1);//Adds the TextField
		
		TTradeQuantity2 = new JTextField("Quantity 2");//Creates the TextField and adds the text to it
		TTradeQuantity2.setBounds(720, 56, 120, 20);//Sets the position and the size of the TextField
		add(TTradeQuantity2);//Adds the TextField
		
		//Trade Button
		JTrade = new JButton("Trade");//Creates a new JButton and adds the text
		JTrade.setBounds(660,76,120,20);//Sets the position and text of the button
		add(JTrade);//Adds the button to the GUI
		JTrade.addActionListener(object);//Adds an action listener to the button
		
		//Turn Controls
		//Roll
		//Dice
		TDice0 = new JTextField("Dice 0: ");//Creates the TextField and adds the text to it
		TDice0.setBounds(660, 96, 60, 20);//Sets the position and the size of the TextField
		TDice0.setEditable(false);//Sets the TextField to not be editable by the user
		add(TDice0);//Adds the TextField
		
		TDice1 = new JTextField("Dice 1: ");//Creates the TextField and adds the text to it
		TDice1.setBounds(720, 96, 60, 20);//Sets the position and the size of the TextField
		TDice1.setEditable(false);//Sets the TextField to not be editable by the user
		add(TDice1);//Adds the TextField
		
		TDiceTotal = new JTextField("Total: ");//Creates the TextField and adds the text to it
		TDiceTotal.setBounds(660, 116, 120, 20);//Sets the position and the size of the TextField
		TDiceTotal.setEditable(false);//Sets the TextField to not be editable by the user
		add(TDiceTotal);//Adds the TextField
		
		//Buttons
		//Roll
		JRoll = new JButton("Roll");//Creates a new JButton and adds the text
		JRoll.setBounds(660, 136, 120, 20);//Sets the position and text of the button
		add(JRoll);//Adds the button to the GUI
		JRoll.addActionListener(object);//Adds an action listener to the button
		
		//Movement of Pointer
		JUp = new JButton("Up");//Creates a new JButton and adds the text
		JUp.setBounds(690, 166, 60, 20);//Sets the position and text of the button
		add(JUp);//Adds the button to the GUI
		JUp.addActionListener(object);//Adds an action listener to the button
		
		JDown = new JButton("Down");//Creates a new JButton and adds the text
		JDown.setBounds(690, 226, 60, 20);//Sets the position and text of the button
		add(JDown);//Adds the button to the GUI
		JDown.addActionListener(object);//Adds an action listener to the button
		
		JRight = new JButton(">");//Creates a new JButton and adds the text
		JRight.setBounds(750, 176, 20, 60);//Sets the position and text of the button
		add(JRight);//Adds the button to the GUI
		JRight.addActionListener(object);//Adds an action listener to the button
		
		JLeft = new JButton("<");//Creates a new JButton and adds the text
		JLeft.setBounds(670, 176, 20, 60);//Sets the position and text of the button
		add(JLeft);//Adds the button to the GUI
		JLeft.addActionListener(object);//Adds an action listener to the button
		
		//Building
		JRoad = new JButton("Road");//Creates a new JButton and adds the text
		JRoad.setBounds(660, 266, 120, 20);//Sets the position and text of the button
		add(JRoad);//Adds the button to the GUI
		JRoad.addActionListener(object);//Adds an action listener to the button
		
		JSettlement = new JButton("Settlement");//Creates a new JButton and adds the text
		JSettlement.setBounds(660, 286, 120, 20);//Sets the position and text of the button
		add(JSettlement);//Adds the button to the GUI
		JSettlement.addActionListener(object);//Adds an action listener to the button
		
		JCity = new JButton("City");//Creates a new JButton and adds the text
		JCity.setBounds(660, 306, 120, 20);//Sets the position and text of the button
		add(JCity);//Adds the button to the GUI
		JCity.addActionListener(object);//Adds an action listener to the button
		
		//Misc Controls
		JEndTurn = new JButton("End Turn");//Creates a new JButton and adds the text
		JEndTurn.setBounds(660, 346, 120, 20);//Sets the position and text of the button
		add(JEndTurn);//Adds the button to the GUI
		JEndTurn.addActionListener(object);//Adds an action listener to the button
		
		JRulesGUI = new JButton("Rules");//Creates a new JButton and adds the text
		JRulesGUI.setBounds(660,400,120,20);//Sets the position and text of the button
		add(JRulesGUI);//Adds the button to the GUI
		JRulesGUI.addActionListener(object);//Adds an action listener to the button
		
		//Pointer
		IPointer = new ImageIcon("../Point.png");//Tells the program which image to use
		JPointer = new JLabel(IPointer);//Creates a JLabel and sets it to be the ImageIcon
		JPointer.setBounds(60,320,40,40);//Sets the position and size of the image
		add(JPointer);//Adds the image to the GUI
		
		//Jen Board
		int MaxTile = 12;//Sets the maximum amount of tiles allowed for each resource
		int[] tile = {0,0,0,0,0}; // An array which counts how many of each type of tile there is
		//An array containing all of the numbers that can be on the tiles, when a number is used then it is set to 0
		int[] Numbers = {9,8,7,6,5,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5,6,6,6,6,6,7,7,7,7,7,8,8,8,8,8,9,9,9,9,9,10,10,10,10,10,11,11,11,11,11,12,12,12,12,12};
		
		for (int x = 40; x <= 400; x += 40) //Goes through the x axis
		{
			for (int y = 260; y <= 460; y += 40) //Goes through the y axis
			{
				int choosetile = ThreadLocalRandom.current().nextInt(0, 5); //Decides which resource the tile is
				int ChooseNumber = ThreadLocalRandom.current().nextInt(0,60); //Decides which number is on the tile (the position in the numbers list)
				while(tile[choosetile] == MaxTile) //Checks that there can be another of the type of tile selected, if there cannot be another tile is chosen and is checked again
				{
					choosetile = ThreadLocalRandom.current().nextInt(0,5);//Decides which resource the tile is
				}
				while(Numbers[ChooseNumber] == 0) //Checks that the selected position in the array has not yet been used and chan
				{
					ChooseNumber = ThreadLocalRandom.current().nextInt(0,60);//Decides which resource the tile is
				}
				//Sets the tile to be the number selected 
				int Number = Numbers[ChooseNumber];//Sets which number will be on the selected tile
				TNumber = new JLabel();//Creates the JLabel
				TNumber.setText(""+Number);//Sets the text in the JLabel
				add(TNumber);//Adds the JLabel to the GUI
				TNumber.setBounds(x+15, y+10,20,20);//Sets the position and the size of the JLabel
				
				Numbers[ChooseNumber] = 0;//Gets rid of the number from the selected position in the array
				
				switch (choosetile) //Adds the Tile to the board, the type of tile is dependent on the variable choosetile
				{
					case 0: //Wood
					{
						AddImage(IWoodTile,JWoodTile,"../WoodTile.png",x,y,40,40);//Adds the Image to the GUI at the current x and Y coordinate and sets the size of the image
						
						Pos = calcs.AddTile(x, y, choosetile, Number, 0);//Sends the type of tile and the number on the tile to a procedure in calcs that adds the tile and also adds them to an array in Main
						
						tile[0] ++;//Adds 1 to the position in the array tile that relates to this type of tile
						
						break;
					}
					case 1: //Stone
					{
						AddImage(IStoneTile,JStoneTile,"../StoneTile.png",x,y,40,40);//Adds the Image to the GUI at the current x and Y coordinate and sets the size of the image
						
						Pos = calcs.AddTile(x, y, choosetile, Number, 1);//Sends the type of tile and the number on the tile to a procedure in calcs that adds the tile and also adds them to an array in Main
						
						tile[1] ++;//Adds 1 to the position in the array tile that relates to this type of tile
						break;
					}
					case 2: //Sheep
					{
						AddImage(ISheepTile,JSheepTile,"../SheepTile.png",x,y,40,40);//Adds the Image to the GUI at the current x and Y coordinate and sets the size of the image
						
						Pos = calcs.AddTile(x, y, choosetile, Number, 2);//Sends the type of tile and the number on the tile to a procedure in calcs that adds the tile and also adds them to an array in Main
						
						tile[2] ++;//Adds 1 to the position in the array tile that relates to this type of tile
						break;
					}
					case 3: //Wheat
					{
						AddImage(IWheatTile,JWheatTile,"../WheatTile.png",x,y,40,40);//Adds the Image to the GUI at the current x and Y coordinate and sets the size of the image
						
						Pos = calcs.AddTile(x, y, choosetile, Number, 3);//Sends the type of tile and the number on the tile to a procedure in calcs that adds the tile and also adds them to an array in Main
						
						tile[3] ++;//Adds 1 to the position in the array tile that relates to this type of tile
						break;
					}
					case 4: // Brick
					{
						AddImage(IBrickTile,JBrickTile,"../BrickTile.png",x,y,40,40);//Adds the Image to the GUI at the current x and Y coordinate and sets the size of the image
						
						Pos = calcs.AddTile(x, y, choosetile, Number, 4);//Sends the type of tile and the number on the tile to a procedure in calcs that adds the tile and also adds them to an array in Main
						
						tile[4] ++;//Adds 1 to the position in the array tile that relates to this type of tile
						break;
					}
				}
			}
		}
	}
	public void AddImage(ImageIcon Image, JLabel Label, String Place, int x, int y, int width, int height)//Method for adding images that do not need to be moved
	{
		Image = new ImageIcon(Place);//Tells the program which image to use
		Label = new JLabel(Image);//Creates a JLabel and sets it to be the ImageIcon
		Label.setBounds(x, y, width, height);//Sets the position and size of the image
		add(Label);//Adds the image to the GUI
	}
	private class theHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if (Won == false)//Checks that the game has not already been won
			{
				if (Begin == false)//Checks that the players have gone through the starting game
				{
					if (Started == true)//Checks that all the classes variables have been set up
					{
						player1.setVars();//Sets up variables
						player2.setVars();//Sets up variables
						player3.setVars();//Sets up variables
						player4.setVars();//Sets up variables
						
						player1.setVars1();//Sets up variables
						player2.setVars1();//Sets up variables
						player3.setVars1();//Sets up variables
						player4.setVars1();//Sets up variables
						
						player1.Player1SettlementPos[0][0] = startgame.ReturnPlayer1SettlementX0()+10;//Gets the x coordinate of one of the already placed settlements
						player1.Player1SettlementPos[1][0] = startgame.ReturnPlayer1SettlementY0()+10;//Gets the y coordinate of one of the already placed settlements
						player1.Player1SettlementPos[0][1] = startgame.ReturnPlayer1SettlementX1()+10;//Gets the x coordinate of one of the already placed settlements
						player1.Player1SettlementPos[1][1] = startgame.ReturnPlayer1SettlementY1()+10;//Gets the y coordinate of one of the already placed settlements
						player2.Player2SettlementPos[0][0] = startgame.ReturnPlayer2SettlementX0()+10;//Gets the x coordinate of one of the already placed settlements
						player2.Player2SettlementPos[1][0] = startgame.ReturnPlayer2SettlementY0()+10;//Gets the y coordinate of one of the already placed settlements
						player2.Player2SettlementPos[0][1] = startgame.ReturnPlayer2SettlementX1()+10;//Gets the x coordinate of one of the already placed settlements
						player2.Player2SettlementPos[1][1] = startgame.ReturnPlayer2SettlementY1()+10;//Gets the y coordinate of one of the already placed settlements
						player3.Player3SettlementPos[0][0] = startgame.ReturnPlayer3SettlementX0()+10;//Gets the x coordinate of one of the already placed settlements
						player3.Player3SettlementPos[1][0] = startgame.ReturnPlayer3SettlementY0()+10;//Gets the y coordinate of one of the already placed settlements
						player3.Player3SettlementPos[0][1] = startgame.ReturnPlayer3SettlementX1()+10;//Gets the x coordinate of one of the already placed settlements
						player3.Player3SettlementPos[1][1] = startgame.ReturnPlayer3SettlementY1()+10;//Gets the y coordinate of one of the already placed settlements
						player4.Player4SettlementPos[0][0] = startgame.ReturnPlayer4SettlementX0()+10;//Gets the x coordinate of one of the already placed settlements
						player4.Player4SettlementPos[1][0] = startgame.ReturnPlayer4SettlementY0()+10;//Gets the y coordinate of one of the already placed settlements
						player4.Player4SettlementPos[0][1] = startgame.ReturnPlayer4SettlementX1()+10;//Gets the x coordinate of one of the already placed settlements
						player4.Player4SettlementPos[1][1] = startgame.ReturnPlayer4SettlementY1()+10;//Gets the y coordinate of one of the already placed settlements
						
						main.SettlementPos[0][0] = startgame.ReturnPlayer1SettlementX0();//Gets the x coordinate of one of the already placed settlements
						main.SettlementPos[1][0] = startgame.ReturnPlayer1SettlementY0();//Gets the y coordinate of one of the already placed settlements
						main.SettlementPos[0][1] = startgame.ReturnPlayer1SettlementX1();//Gets the x coordinate of one of the already placed settlements
						main.SettlementPos[1][1] = startgame.ReturnPlayer1SettlementY1();//Gets the y coordinate of one of the already placed settlements
						main.SettlementPos[0][2] = startgame.ReturnPlayer2SettlementX0();//Gets the x coordinate of one of the already placed settlements
						main.SettlementPos[1][2] = startgame.ReturnPlayer2SettlementY0();//Gets the y coordinate of one of the already placed settlements
						main.SettlementPos[0][3] = startgame.ReturnPlayer2SettlementX1();//Gets the x coordinate of one of the already placed settlements
						main.SettlementPos[1][3] = startgame.ReturnPlayer2SettlementY1();//Gets the y coordinate of one of the already placed settlements
						main.SettlementPos[0][4] = startgame.ReturnPlayer3SettlementX0();//Gets the x coordinate of one of the already placed settlements
						main.SettlementPos[1][4] = startgame.ReturnPlayer3SettlementY0();//Gets the y coordinate of one of the already placed settlements
						main.SettlementPos[0][5] = startgame.ReturnPlayer3SettlementX1();//Gets the x coordinate of one of the already placed settlements
						main.SettlementPos[1][5] = startgame.ReturnPlayer3SettlementY1();//Gets the y coordinate of one of the already placed settlements
						main.SettlementPos[0][6] = startgame.ReturnPlayer4SettlementX0();//Gets the x coordinate of one of the already placed settlements
						main.SettlementPos[1][6] = startgame.ReturnPlayer4SettlementY0();//Gets the y coordinate of one of the already placed settlements
						main.SettlementPos[0][7] = startgame.ReturnPlayer4SettlementX1();//Gets the x coordinate of one of the already placed settlements
						main.SettlementPos[1][7] = startgame.ReturnPlayer4SettlementY1();//Gets the y coordinate of one of the already placed settlements
						
						main.SettlementPosPos = 8;//Sets the variable SettlementPosPos in Main to 8 to account for already placed settlements
						
						Started = false;//Sets Started to false so main game can start
					}
					Turn = main.Handle(event, TTurn, Turn, JEndTurn, JRoll, JUp, JDown, JRight, JLeft, JTrade, JRoad, JSettlement, JCity, JPointer, TDice0, TDice1, TDiceTotal, TTradePlayer1, TTradePlayer2, TTradeResource1, TTradeResource2, TTradeQuantity1, TTradeQuantity2, TPlayer1Wood, TPlayer2Wood, TPlayer3Wood, TPlayer4Wood, TPlayer1Stone, TPlayer2Stone, TPlayer3Stone, TPlayer4Stone, TPlayer1Sheep, TPlayer2Sheep, TPlayer3Sheep, TPlayer4Sheep, TPlayer1Wheat, TPlayer2Wheat, TPlayer3Wheat, TPlayer4Wheat, TPlayer1Brick, TPlayer2Brick, TPlayer3Brick, TPlayer4Brick, TPlayer1Points);//Main class for misc controls
					
					//Adding Buildings
					switch (Turn)//Switches depending on which players turn it is
					{
						case 1: 
							player1.Go(event, TPlayer1Points, JRoad, JSettlement, JCity, JPlayer1Road0, JPlayer1Road1, JPlayer1Road2, JPlayer1Road3, JPlayer1Road4, JPlayer1Road5, JPlayer1Road6, JPlayer1Road7, JPlayer1Road8, JPlayer1Road9, JPlayer1Road10, JPlayer1Road11, JPlayer1Road12, JPlayer1Road13, JPlayer1Road14, JPlayer1Settlement0, JPlayer1Settlement1, JPlayer1Settlement2, JPlayer1Settlement3, JPlayer1Settlement4, JPlayer1City0, JPlayer1City1, JPlayer1City2, JPlayer1City3, main.PointX, main.PointY, main.RoadPos, main.RoadPosPos, main.SettlementPosPos, main.CityPosPos, main.CityPos, main.PlayerResources);//Main class for Player1
							break;
						case 2:
							player2.Go(event, TPlayer2Points, JRoad, JSettlement, JCity, JPlayer2Road0, JPlayer2Road1, JPlayer2Road2, JPlayer2Road3, JPlayer2Road4, JPlayer2Road5, JPlayer2Road6, JPlayer2Road7, JPlayer2Road8, JPlayer2Road9, JPlayer2Road10, JPlayer2Road11, JPlayer2Road12, JPlayer2Road13, JPlayer2Road14, JPlayer2Settlement0, JPlayer2Settlement1, JPlayer2Settlement2, JPlayer2Settlement3, JPlayer2Settlement4, JPlayer2City0, JPlayer2City1, JPlayer2City2, JPlayer2City3, main.PointX, main.PointY, main.RoadPos, main.RoadPosPos, main.SettlementPosPos, main.CityPosPos, main.CityPos, main.PlayerResources);//Main class for Player2
							break;
						case 3:
							player3.Go(event, TPlayer3Points, JRoad, JSettlement, JCity, JPlayer3Road0, JPlayer3Road1, JPlayer3Road2, JPlayer3Road3, JPlayer3Road4, JPlayer3Road5, JPlayer3Road6, JPlayer3Road7, JPlayer3Road8, JPlayer3Road9, JPlayer3Road10, JPlayer3Road11, JPlayer3Road12, JPlayer3Road13, JPlayer3Road14, JPlayer3Settlement0, JPlayer3Settlement1, JPlayer3Settlement2, JPlayer3Settlement3, JPlayer3Settlement4, JPlayer3City0, JPlayer3City1, JPlayer3City2, JPlayer3City3, main.PointX, main.PointY, main.RoadPos, main.RoadPosPos, main.SettlementPosPos, main.CityPosPos, main.CityPos, main.PlayerResources);//Main class for Player3
							break;
						case 4:
							player4.Go(event, TPlayer4Points, JRoad, JSettlement, JCity, JPlayer4Road0, JPlayer4Road1, JPlayer4Road2, JPlayer4Road3, JPlayer4Road4, JPlayer4Road5, JPlayer4Road6, JPlayer4Road7, JPlayer4Road8, JPlayer4Road9, JPlayer4Road10, JPlayer4Road11, JPlayer4Road12, JPlayer4Road13, JPlayer4Road14, JPlayer4Settlement0, JPlayer4Settlement1, JPlayer4Settlement2, JPlayer4Settlement3, JPlayer4Settlement4, JPlayer4City0, JPlayer4City1, JPlayer4City2, JPlayer4City3, main.PointX, main.PointY, main.RoadPos, main.RoadPosPos, main.SettlementPosPos, main.CityPosPos, main.CityPos, main.PlayerResources);//Main class for Player4
							break;
					}
					calcs.SetTextFields(main.PlayerResources, TPlayer1Wood, TPlayer2Wood, TPlayer3Wood, TPlayer4Wood, TPlayer1Stone, TPlayer2Stone, TPlayer3Stone, TPlayer4Stone, TPlayer1Sheep, TPlayer2Sheep, TPlayer3Sheep, TPlayer4Sheep, TPlayer1Wheat, TPlayer2Wheat, TPlayer3Wheat, TPlayer4Wheat, TPlayer1Brick, TPlayer2Brick, TPlayer3Brick, TPlayer4Brick);//Resets the resource TextFields to show changes
				}
				else
				{
					Begin = startgame.go(event, Begin, TTurn, TPlayer1Points, TPlayer2Points, TPlayer3Points, TPlayer4Points, JUp, JDown, JLeft, JRight, JPointer, JRoll, JEndTurn, JRoad, JSettlement, TDice0, TDice1, TDiceTotal, JPlayer1Road0, JPlayer1Road1, JPlayer1Road2, JPlayer1Road3, JPlayer1Road4, JPlayer1Road5, JPlayer1Road6, JPlayer1Road7, JPlayer1Road8, JPlayer1Road9, JPlayer1Road10, JPlayer1Road11, JPlayer1Road12, JPlayer1Road13, JPlayer1Road14, JPlayer2Road0, JPlayer2Road1, JPlayer2Road2, JPlayer2Road3, JPlayer2Road4, JPlayer2Road5, JPlayer2Road6, JPlayer2Road7, JPlayer2Road8, JPlayer2Road9, JPlayer2Road10, JPlayer2Road11, JPlayer2Road12, JPlayer2Road13, JPlayer2Road14, JPlayer3Road0, JPlayer3Road1, JPlayer3Road2, JPlayer3Road3, JPlayer3Road4, JPlayer3Road5, JPlayer3Road6, JPlayer3Road7, JPlayer3Road8, JPlayer3Road9, JPlayer3Road10, JPlayer3Road11, JPlayer3Road12, JPlayer3Road13, JPlayer3Road14, JPlayer4Road0, JPlayer4Road1, JPlayer4Road2, JPlayer4Road3, JPlayer4Road4, JPlayer4Road5, JPlayer4Road6, JPlayer4Road7, JPlayer4Road8, JPlayer4Road9, JPlayer4Road10, JPlayer4Road11, JPlayer4Road12, JPlayer4Road13, JPlayer4Road14, JPlayer1Settlement0, JPlayer1Settlement1, JPlayer1Settlement2, JPlayer1Settlement3, JPlayer1Settlement4, JPlayer2Settlement0, JPlayer2Settlement1, JPlayer2Settlement2, JPlayer2Settlement3, JPlayer2Settlement4, JPlayer3Settlement0, JPlayer3Settlement1, JPlayer3Settlement2, JPlayer3Settlement3, JPlayer3Settlement4, JPlayer4Settlement0, JPlayer4Settlement1, JPlayer4Settlement2, JPlayer4Settlement3, JPlayer4Settlement4, TPlayer1Wood, TPlayer2Wood, TPlayer3Wood, TPlayer4Wood, TPlayer1Stone, TPlayer2Stone, TPlayer3Stone, TPlayer4Stone, TPlayer1Sheep, TPlayer2Sheep, TPlayer3Sheep, TPlayer4Sheep, TPlayer1Wheat, TPlayer2Wheat, TPlayer3Wheat, TPlayer4Wheat, TPlayer1Brick, TPlayer2Brick, TPlayer3Brick, TPlayer4Brick);//Class that is run when program starts
				}
				if (event.getSource() == JRulesGUI)//Checks if the button JRulesGUI has been pressed
				{
					RulesGUI object = new RulesGUI();//Creates an object for the class RulesGUI
					
					object.setSize(1300,800);//Sets the size of the window to be 900 by 600
					object.setVisible(true);//Sets the window to be visible
					object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Tells the program to end the window when the window is closed
				}
			}
			for (int i = 0; i < 4; i ++)//A for loop to find if any player has won yet
			{
				if (main.PlayerResources[i][5] >= 7)//Checks if the players have enough points to win
				{
					Won = true;//Sets won to be true so that the rest of the program will no longer run
					JOptionPane.showMessageDialog(null, "Player " + (i+1) + " has won");//Tells the players that a player has won
					break;
				}
			}
		}
	}
}
