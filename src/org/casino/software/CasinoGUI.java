package org.casino.software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CasinoGUI extends JFrame {
	private Casino casino;
	JPanel	menuPane;
	JButton pokerButton;
	JButton blckjckButton;
	JButton slotButton;
	
	
	public CasinoGUI(String windowTitle, Casino aCasino){
		super(windowTitle);
		casino = aCasino;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);
		//setLayout(new GridLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();
		setVisible(true);
	}
	
	public void buildGUI(){
		menuPane = new JPanel();
		pokerButton = new JButton();
		blckjckButton = new JButton();
		slotButton = new JButton();
		
		menuPane.setLayout(new GridLayout());
		menuPane.setBackground(Color.BLUE);
		
		pokerButton.addActionListener(new MenuListener());
		blckjckButton.addActionListener(new MenuListener());
		slotButton.addActionListener(new MenuListener());
		
		pokerButton.setIcon(new ImageIcon("Images/video_poker.png"));
		blckjckButton.setIcon(new ImageIcon("Images/blackjackpng.png"));
		slotButton.setIcon(new ImageIcon("Images/amazing7s.png"));

		menuPane.add(pokerButton);
		menuPane.add(blckjckButton);
		menuPane.add(slotButton);
		
		menuPane.setVisible(true);
		
		add(menuPane);
	}
	
	private class MenuListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			
			if(source.equals(pokerButton)){
				handlePokerButton();
			} else if(source.equals(blckjckButton)){
				handleBlckJckButton();
			}else if(source.equals(slotButton)){
				handleSlotButton();
			}
		}
		
		private void handlePokerButton(){
			
		}
		
		private void handleBlckJckButton(){
			
		}
		
		private void handleSlotButton(){
			
		}
		
	}
	
	public static void main(String[] args){
		Casino aCasino = new Casino();
		new CasinoGUI("Casino",aCasino);
	}
}
