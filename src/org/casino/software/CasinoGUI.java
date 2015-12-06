package org.casino.software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CasinoGUI extends JFrame {
	private Casino casino;
	JPanel	panels;
	JPanel	menuPanel;
	ClassicPanel classicPanel;
	JButton pokerButton;
	JButton blckjckButton;
	JButton slotButton;
	
	
	public CasinoGUI(String windowTitle, Casino aCasino){
		super(windowTitle);
		casino = aCasino;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);
		setLayout(new GridLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();
		setVisible(true);
	}
	
	public void buildGUI(){
		panels = new JPanel(new CardLayout());
		menuPanel = new JPanel();
		pokerButton = new JButton();
		blckjckButton = new JButton();
		slotButton = new JButton();
		
		menuPanel.setLayout(new GridLayout());
		menuPanel.setBackground(Color.BLUE);
		
		pokerButton.addActionListener(new MenuListener());
		blckjckButton.addActionListener(new MenuListener());
		slotButton.addActionListener(new MenuListener());
		
		pokerButton.setIcon(new ImageIcon("Images/video_poker.png"));
		blckjckButton.setIcon(new ImageIcon("Images/blackjackpng.png"));
		slotButton.setIcon(new ImageIcon("Images/amazing7s.png"));

		menuPanel.add(pokerButton);
		menuPanel.add(blckjckButton);
		menuPanel.add(slotButton);
		menuPanel.setVisible(true);
		
		classicPanel = new ClassicPanel(casino.getPlayer(),casino.getClassic(),panels);
		// Add blackjack panel and slots panel
		
		panels.add(menuPanel,"MENUPANEL");
		panels.add(classicPanel,"CLASSICPANEL");
		
		CardLayout cl = (CardLayout)(panels.getLayout());
		cl.show(panels,"MENUPANEL");
		
		add(panels);
	}
	
	private class MenuListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			CardLayout cl = (CardLayout)(panels.getLayout());
			if(source.equals(pokerButton)){
				cl.show(panels,"CLASSICPANEL");
			}else if(source.equals(blckjckButton)){

			}else if(source.equals(slotButton)){

			}
		}
	}
	
	public static void main(String[] args){
		Casino aCasino = new Casino();
		new CasinoGUI("Casino",aCasino);
	}
}
