package org.casino.software;

import javax.swing.*;

import org.casino.games.Classic;
import org.casino.people.Player;

import java.awt.*;
import java.awt.event.*;

public class ClassicPanel extends JPanel {
	JPanel panels;
	private Player player;
	private Classic game;
	private JButton card1,card2,card3,card4,card5,deal,draw,back;
	
	public ClassicPanel(Player aPlayer, Classic aGame, JPanel aPanels){
		player = aPlayer;
		game = aGame;
		panels = aPanels;
		
		setLayout(new GridBagLayout());
		setBackground(Color.BLUE);
		
		card1 = new JButton();
		add(card1);
		card2= new JButton();
		add(card2);
		card3 = new JButton();
		add(card3);
		card4 = new JButton();
		add(card4);
		card5 = new JButton();
		add(card5);
		deal = new JButton("Deal");
		add(deal);
		draw = new JButton("Draw");
		add(draw);
		back = new JButton("Back");
		back.addActionListener(new ButtonListener());
		add(back);
		
		draw.setVisible(false);
		setVisible(true);
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(back)){
				CardLayout cl = (CardLayout)(panels.getLayout());
				cl.show(panels,"MENUPANEL");
			}
		}
		
	}
	
}
