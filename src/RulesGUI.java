import java.awt.FlowLayout;//Allows use of a FlowLayout

import javax.swing.JFrame;//Allows use of JFrames (making the window)
import javax.swing.JLabel;//Allows use of JLabels(used for showing the rules)

public class RulesGUI extends JFrame
{
	JLabel Rules;//Creating a JLabel
	public RulesGUI()//A constructor
	{
		super("Rules");//Sets the title of the window
		setLayout(new FlowLayout());//Sets the layout of the window
		
		Rules = new JLabel("<html><h1>The StartGame</h1> <br> <p>At the start of the game each player will need to roll the dice once.<br> Then each player will have to place down one road and one settlement (in that order) in order of who rolled the highest.<br> Each road must be next to a settlement and each settlement next to a road and at least 2 tiles away from another settlement.<br> Then this will be repeated but going in reverse.<br> Once each player has placed down 2 settlements and 2 roads, the main game will begin</p><h1>The Main Game</h1><br><p>At the start of each turn the player who's turn it is (shown to the right) can place down a settlement, road or city if they have enough resource.<br>Each player must also roll the dice before ending their turn<br>All roads must be connected and all settlements/cities must be connected to a road.<br>Settlements must be placed at least 2 tiles away from any other settlements like before.<br>Cities can only be placed ontop of settlements.<br>In order to get the resources needed to make buildings players will need to roll the dice, and if they have a settlement or city next to a tile with that number on it they will get a resource (2 if they have a city next to it).</p><br><h1>Costs of buildings</h1><br><p>Each road costs 1 wood and 1 brick.<br>Each settlement costs 1 sheep, 1 wood, 1 wheat and 1 brick.<br>Each city costs 2 wheat and 3 stone<p><br><h1>Winning the Game</h1><br><p>In order to win the game players must get 7 victory points.<br>Each settlement is worth 1 victory point and each city is worth 2 (the 1 from the settlement is removed)</p></html>");//Creates the text in the JLabel
		add(Rules);//Adds the Jlabel
	}
}
