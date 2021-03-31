package authentication;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Player.Player;

public class Opening extends JPanel implements ActionListener{
	private JFrame main = new JFrame("BrickingBad Authentication");
	private ImageIcon background = new ImageIcon("src/images/authenticationbg.jpg");
	private JButton button = new JButton("Ready To Play !!");
	private JButton help = new JButton("Help");
	private JTextField tf = new JTextField(10);
	private Player player = new Player(0,0,0,0,0,0,0,3);
	private boolean ready=false;
	public Opening(boolean openingVisible){
		if(openingVisible) {
			JPanel usernameFrame = new JPanel();
			JLabel text = new JLabel("Enter your username: ");
			usernameFrame.add(text,BorderLayout.EAST);
			usernameFrame.add(tf,BorderLayout.WEST);
			usernameFrame.setBackground(Color.ORANGE);
			JPanel buttonFrame = new JPanel();
			button.addActionListener(this);
			help.addActionListener(this);
			buttonFrame.add(button);
			buttonFrame.add(help);
			buttonFrame.setBackground(Color.ORANGE);
			main.add(buttonFrame,BorderLayout.SOUTH);
			main.add(usernameFrame,BorderLayout.NORTH);
			main.add(this);
			main.setSize(600, 600);
			main.setTitle("BrickingBad Authentication");
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			main.setVisible(true);	
			main.setResizable(false);
		}
	}
	public void paint(Graphics g) {
		g.drawImage(background.getImage(),0,0,null);
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(button)) {
			this.setReady(true);
			player.setName(tf.getText());
			main.dispose();
		}
		if(e.getSource().equals(help)) {
			JOptionPane.showMessageDialog(null, "Welcome to Bricking Bad Game by Gandhi.\n"
					+ "************************************************************\n"
					+ "There will be two mode in the game first BuildingMode second RunningMode.\n"
					+ "************************************************************\n"
					+ "BuildingMode Details:\n"
					+ "------------------------------------------------------------\n"
					+ "You must create your map there.\n"
					+ "There will be buttons in the south of the screen which are called 'SimpleBrick','WrapperBrick','HalfMetalBrick','MineBrick' or 'DeleteMode'\n"
					+ "If you want to generate a random map enter the amounts to each and click 'Generate Random Map with given amounts'. \n"
					+ "You can also click on each and convert your cursor to selected type brick adder or deleter.\n"
					+ "You can save & load your map (local or to mongodatabase) for future plays from the buttons of the north side of the screen.\n"
					+ "If you want to play immediately click 'Go Run Mode With Given Amounts'\n"
					+ "************************************************************\n"
					+ "RunningMode Details:\n"
					+ "------------------------------------------------------------\n"
					+ "You must destroy all the bricks without going out of lives(3).\n"
					+ "The ball reflects from the paddle, bricks and aliens.\n"
					+ "If you catch a powerUp you can use in anytime you want.\n"
					+ "Press(W) for throwing the ball from the padlle.\n"
					+ "Press(RightArrow) for moving the paddle right.\n"
					+ "Press(LeftArrow) for moving the paddle left.\n"
					+ "Press(T) for activating the tallerPaddle.\n"
					+ "Press(Q) for activating the destructiveLaserGun.\n"
					+ "Press(M) for activating the magnet.\n"
					+ "Press(C) for activating the chemicalBall.\n"
					+ "Press(F) for activating the fireBall.\n"
					+ "Press(G) for activating the gangOfBalls.\n"
					+ "You can save & load your game (local or to mongodatabase) for future plays from the buttons of the north side of the screen.\n"
					+ "You can pause your game from the 'Pause' button.\n"
					+ "************************************************************\n"
					+ "Click 'Ready To Play' to enjoy the Game.\n"
					+ "Have Fun  :) ");
		}
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
}
