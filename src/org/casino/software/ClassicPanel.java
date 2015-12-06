package org.casino.software;

import javax.swing.*;

import org.casino.games.Classic;
import org.casino.people.Player;

import java.awt.*;
import java.awt.event.*;

public class ClassicPanel extends JPanel {
	private JPanel panels;
	private JPanel cardPane;
	private JPanel rewardsPane;
	private JPanel betPane;
	private JPanel winPane;
	private JPanel infoPane;
	private Player player;
	private Classic game;
	private JButton card1,card2,card3,card4,card5,deal,draw,back;
	private JButton	money5,money10,money25,money50,money100;
	private Double bet;
	private Boolean hasDealt;
	
	private JLabel straight, kind3, pair2, pair, sflush, kind4, full, flush, rflush;
	private JLabel winType, winAmount;
	private JLabel betLabel, playerMoney;
	
	public ClassicPanel(Player aPlayer, Classic aGame, JPanel aPanels){
		player = aPlayer;
		game = aGame;
		panels = aPanels;
		bet = 0.00;
		hasDealt = false;
		
		setLayout(new GridBagLayout());
		setBackground(Color.BLUE);
		GridBagConstraints c = new GridBagConstraints();
		
		back = new JButton("Back");
		back.addActionListener(new ButtonListener());
		//c.anchor = GridBagConstraints.PAGE_START;
		c.gridx = 0;
		c.gridy = 0;
		add(back,c);
		
		rewardsPane = new JPanel();
		rewardsPane.setLayout(new GridBagLayout());
		rewardsPane.setOpaque(true);
		rewardsPane.setSize(400,400);
		rewardsInit();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		add(rewardsPane,c);
		
		cardPane = new JPanel(new FlowLayout());
		card1 = new JButton();
		card1.setIcon(new ImageIcon("Images/cards/cardback.png","cardback"));
		card1.addActionListener(new CardListener());
		cardPane.add(card1);
		
		card2= new JButton();
		card2.setIcon(new ImageIcon("Images/cards/cardback.png","cardback"));
		card2.addActionListener(new CardListener());
		cardPane.add(card2);
		
		card3 = new JButton();
		card3.setIcon(new ImageIcon("Images/cards/cardback.png","cardback"));
		card3.addActionListener(new CardListener());
		cardPane.add(card3);
		
		card4 = new JButton();
		card4.setIcon(new ImageIcon("Images/cards/cardback.png","cardback"));
		card4.addActionListener(new CardListener());
		cardPane.add(card4);
		
		card5 = new JButton();
		card5.setIcon(new ImageIcon("Images/cards/cardback.png","cardback"));
		card5.addActionListener(new CardListener());
		cardPane.add(card5);
		c.anchor = GridBagConstraints.CENTER;
		//c.insets = new Insets(100,0,100,0);
		c.gridx = 0;
		c.gridy = 3;
		add(cardPane,c);
		
		betPane = new JPanel(new GridLayout());
		betInit();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 5;
		add(betPane,c);
		
		deal = new JButton("Deal");
		deal.addActionListener(new ButtonListener());
		//c.anchor = GridBagConstraints.SOUTH;
		c.gridx = 0;
		c.gridy = 6;
		add(deal,c);
		draw = new JButton("Draw");
		draw.addActionListener(new ButtonListener());
		c.gridx = 0;
		c.gridy = 6;
		draw.setVisible(false);
		add(draw,c);

		winPane = new JPanel(new GridLayout());
		winType = new JLabel();
		winPane.add(winType);
		winAmount = new JLabel();
		winPane.add(winAmount);
		c.gridx = 0;
		c.gridy = 7;
		winPane.setVisible(false);
		add(winPane,c);
		
		infoPane = new JPanel(new GridLayout());
		playerMoney = new JLabel("Credits: $" + player.getMoney());
		betLabel = new JLabel("Bet: $0.00");
		infoPane.add(playerMoney);
		infoPane.add(betLabel);
		c.gridx = 0;
		c.gridy=8;
		add(infoPane,c);
		
		setVisible(true);
	}
	
	private void betInit(){
		money5 = new JButton("$5");
		money5.addActionListener(new BetListener());
		betPane.add(money5);
		
		money10 = new JButton("$10");
		money10.addActionListener(new BetListener());
		betPane.add(money10);
		
		money25 = new JButton("$25");
		money25.addActionListener(new BetListener());
		betPane.add(money25);
		
		money50 = new JButton("$50");
		money50.addActionListener(new BetListener());
		betPane.add(money50);
		
		money100 = new JButton("$100");
		money100.addActionListener(new BetListener());
		betPane.add(money100);
	}
	
	private void rewardsInit(){
		GridBagConstraints c = new GridBagConstraints();
		straight = new JLabel();
		c.gridx = 0;
		c.gridy=1;
		c.anchor = GridBagConstraints.LINE_START;
		rewardsPane.add(straight,c);
		
		kind3 = new JLabel();
		c.gridx = 0;
		c.gridy=2;
		c.anchor = GridBagConstraints.LINE_START;
		rewardsPane.add(kind3,c);
		
		pair2 = new JLabel();
		c.gridx = 0;
		c.gridy = 3;
		c.anchor = GridBagConstraints.LINE_START;
		rewardsPane.add(pair2,c);
		
		pair = new JLabel();
		c.gridx = 0;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LINE_START;
		rewardsPane.add(pair,c);
		
		sflush = new JLabel();
		c.gridx = 1;
		c.gridy=1;
		c.anchor = GridBagConstraints.LINE_START;
		rewardsPane.add(sflush,c);
		
		kind4 = new JLabel();
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		rewardsPane.add(kind4,c);
		
		full = new JLabel();
		c.gridx = 1;
		c.gridy = 3;
		c.anchor = GridBagConstraints.LINE_START;
		rewardsPane.add(full,c);
		
		flush = new JLabel();
		c.gridx = 1;
		c.gridy = 4;
		c.anchor = GridBagConstraints.LINE_START;
		rewardsPane.add(flush,c);
		
		rflush = new JLabel();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		rewardsPane.add(rflush,c);
		
		updateRewards(0);
	}
	
	private void updateRewards(Integer bet){
		//straight, kind3, pair2, pair, sflush, kind4, full, flush, rflush;
		straight.setText("Straight:\t" + bet*10);
		kind3.setText("Three Of A Kind:\t" + bet*3);
		pair2.setText("Two Pair:\t" + bet*2);
		pair.setText("Pair:\t" + bet);
		sflush.setText("Straight Flush:\t" + bet*20);
		kind4.setText("Four Of A Kind:\t" + bet*100);
		full.setText("Full House:\t" + bet*50);
		flush.setText("Flush:\t" + bet*20);
		rflush.setText("Royal Flush:\t" + bet*5000);
	}
	
	public void setCardIcon(JButton aButton, String imageString){
		if(((ImageIcon)aButton.getIcon()).getDescription() == "cardback" || hasDealt == false){
			ImageIcon icon = new ImageIcon(imageString);
			ImageIcon old = new ImageIcon("Images/cards/cardback.png");
			Image imgOld = old.getImage();
			Image imgNew = icon.getImage().getScaledInstance(imgOld.getWidth(null),
					imgOld.getHeight(null), java.awt.Image.SCALE_SMOOTH);
			aButton.setIcon(new ImageIcon(imgNew,imageString));
		} else {
			aButton.setIcon(new ImageIcon("Images/cards/cardback.png","cardback"));
		}
	}
	
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(back)){
				CardLayout cl = (CardLayout)(panels.getLayout());
				cl.show(panels,"MENUPANEL");
			}else if(source.equals(deal) && bet != 0.00 && player.getMoney() >= bet){
				handleDeal();
				hasDealt = true;
			}else if(source.equals(draw)){
				handleDraw();
			}
		}
	
		public void handleDeal(){
			deal.setVisible(false);
			draw.setVisible(true);
			back.setVisible(false);
			betPane.setVisible(false);
			winPane.setVisible(false);
			
			game.setBet(bet);
			game.dealCards();
			setCardIcon(card1, game.getPlayerHand().get(0).imageString());
			setCardIcon(card2, game.getPlayerHand().get(1).imageString());
			setCardIcon(card3, game.getPlayerHand().get(2).imageString());
			setCardIcon(card4, game.getPlayerHand().get(3).imageString());
			setCardIcon(card5, game.getPlayerHand().get(4).imageString());
			
			playerMoney.setText("Credits: $" + player.getMoney());
		}
		
		public void handleDraw(){
			draw.setVisible(false);
			deal.setVisible(true);
			betPane.setVisible(true);
			back.setVisible(true);
			hasDealt = false;
			
			if(((ImageIcon)card1.getIcon()).getDescription() == "cardback")
				setCardIcon(card1, game.replaceCard(0).imageString());
			if(((ImageIcon)card2.getIcon()).getDescription() == "cardback")
				setCardIcon(card2, game.replaceCard(1).imageString());
			if(((ImageIcon)card3.getIcon()).getDescription() == "cardback")
				setCardIcon(card3, game.replaceCard(2).imageString());
			if(((ImageIcon)card4.getIcon()).getDescription() == "cardback")
				setCardIcon(card4, game.replaceCard(3).imageString());
			if(((ImageIcon)card5.getIcon()).getDescription() == "cardback")
				setCardIcon(card5, game.replaceCard(4).imageString());
			
			Integer result = game.result();
			switch(result){
			case 0:
				winType.setText("Lose");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			case 1:
				winType.setText("Pair");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			case 2:
				winType.setText("Two Pair");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			case 3:
				winType.setText("Three Of A Kind");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			case 4:
				winType.setText("Straight");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			case 5:
				winType.setText("Flush");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			case 6:
				winType.setText("Straight Flush");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			case 7:
				winType.setText("Full House");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			case 8:
				winType.setText("Four Of A Kind");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			case 9:
				winType.setText("Royal Flush");
				winAmount.setText("$" + game.getMoneyWon());
				break;
			}
			winPane.setVisible(true);
			game.resetGame();
			playerMoney.setText("Credits: $" + player.getMoney());
		}
		
	}
			
	private class BetListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton)(e.getSource());
			if(source.equals(money5)){
				updateRewards(5);
				bet = 5.00;
				betLabel.setText("Bet: $5.00");
			}else if(source.equals(money10)){
				updateRewards(10);
				bet = 10.00;
				betLabel.setText("Bet: $10.00");
			}else if(source.equals(money25)){
				updateRewards(25);
				bet = 25.00;
				betLabel.setText("Bet: $25.00");
			}else if(source.equals(money50)){
				updateRewards(50);
				bet = 50.00;
				betLabel.setText("Bet: $50.00");
			}else if(source.equals(money100)){
				updateRewards(100);
				bet = 100.00;
				betLabel.setText("Bet: $100.00");
			}
		}
		
	}
	
	private class CardListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if(hasDealt == false)
				return;
			JButton source = (JButton)(e.getSource());
			if(source.equals(card1)){
				setCardIcon(card1, game.getPlayerHand().get(0).imageString());
			}else if(source.equals(card2)){
				setCardIcon(card2, game.getPlayerHand().get(1).imageString());
			}else if(source.equals(card3)){
				setCardIcon(card3, game.getPlayerHand().get(2).imageString());
			}else if(source.equals(card4)){
				setCardIcon(card4, game.getPlayerHand().get(3).imageString());
			}else if(source.equals(card5)){
				setCardIcon(card5, game.getPlayerHand().get(4).imageString());
			}
		}
		
	}
	
}
