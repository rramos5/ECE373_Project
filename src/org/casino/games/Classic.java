package org.casino.games;

import java.util.ArrayList;
import java.util.Collections;

public class Classic extends Game{
	private Deck deck;
	private ArrayList<Card> playerHand;
	
	public Classic(){
		setDeck(new Deck());
		playerHand = new ArrayList<Card>();
		setGameType("Video Poker");
		setGameName("Classic");
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public ArrayList<Card> getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(ArrayList<Card> playerHand) {
		this.playerHand = playerHand;
	}
	
	public void dealCards(){
		for(int i = 0; i < 5; i++){
			playerHand.add(deck.dealACard());
		}
	}
	
	public Card replaceCard(Integer handIndex){
		playerHand.set(handIndex, deck.dealACard());
		return getPlayerHand().get(handIndex);
	}
	
	public void resetGame(){
		deck = new Deck();
		playerHand = new ArrayList<Card>();
	}
	
	public Integer checkMatches(){
		playerHand.sort((c1, c2)-> Integer.compare(c1.getValue(),c2.getValue()));
		for(int i = 0; i < 4; i++){
			if(playerHand.get(i).getValue() == playerHand.get(i+1).getValue()){
				// Pair found. Check for 3 of a kind and four of a kind unless
				// we are at the 4th card in the hand.
				if(i < 2 && playerHand.get(i+2).getValue() == playerHand.get(i).getValue()
						&& playerHand.get(i+3).getValue() == playerHand.get(i).getValue()){
					// Four of a kind found
					return 4;
				} else if (i < 3 && playerHand.get(i+2).getValue() == playerHand.get(i).getValue()){
					// Three of a kind found
					return 3;
				} else {
					// Check for two pair here
					if(i == 0 && (playerHand.get(2).getValue() == playerHand.get(3).getValue() || 
							playerHand.get(3).getValue() == playerHand.get(4).getValue()))
						return 2;
					else if (i == 1 && playerHand.get(3).getValue() == playerHand.get(4).getValue())
						return 2;
					else
						// Only a single pair found.
						return 1;
					
				}				
			}
		}
		// No pairs found.
		return 0;
	}
	
	public Boolean checkFullHouse(){
		playerHand.sort((c1, c2)-> Integer.compare(c1.getValue(),c2.getValue()));
		if(playerHand.get(0).getValue() == playerHand.get(1).getValue() 
				&& playerHand.get(2).getValue() == playerHand.get(3).getValue()
				&& playerHand.get(2).getValue() == playerHand.get(4).getValue())
			return true;
		else if(playerHand.get(0).getValue() == playerHand.get(1).getValue() 
				&& playerHand.get(0).getValue() == playerHand.get(2).getValue()
				&& playerHand.get(3).getValue() == playerHand.get(4).getValue())
			return true;
		return false;
	}
	
	public Boolean checkFlush(){
		for(int i = 0; i< 4; i++){
			if(playerHand.get(i).getSuit() != playerHand.get(i+1).getSuit()){
				return false;
			}
		}
		return true;
	}
	
	public int checkStraight(){
		playerHand.sort((c1, c2)-> Integer.compare(c1.getValue(),c2.getValue()));
		for(int i = 0; i < 4; i++){
			if(playerHand.get(i).getValue() + 1 != playerHand.get(i+1).getValue())
				// Cannot be a straight. Return 0
				return 0;
		}
		// Straight has been found. Check for straight flush and royal flush.
		if(checkFlush()){
			// If the first card in the list is a 10 then we have found a Royal Flush
			// otherwise it is just a straight flush.
			if(playerHand.get(0).getValue() == 10)
				return 3;
			else
				return 2;
		}
		// We have detected a Straight, but it is not a flush.
		return 1;
	}
	
	public Integer result(){
		int result;
		if(checkFullHouse()){
			player.setMoney(player.getMoney()+bet*50);
			setMoneyWon(bet*50);
			return 7;
		} else if((result = checkMatches()) != 0){
			switch(result){
			case 1:
				player.setMoney(player.getMoney()+bet);
				setMoneyWon(bet);
				return 1;
			case 2:
				player.setMoney(player.getMoney()+bet*2);
				setMoneyWon(bet*2);
				return 2;
			case 3:
				player.setMoney(player.getMoney()+bet*3);
				setMoneyWon(bet*3);
				return 3;
			case 4:
				player.setMoney(player.getMoney()+bet*100);
				setMoneyWon(bet*100);
				return 8;
			}
		} else if((result = checkStraight()) != 0){
			switch(result){
			case 1:
				player.setMoney(player.getMoney()+bet*10);
				setMoneyWon(bet*10);
				return 4;
			case 2:
				player.setMoney(player.getMoney()+bet*20);
				setMoneyWon(bet*20);
				return 6;
			case 3:
				player.setMoney(player.getMoney()+bet*5000);
				setMoneyWon(bet*5000);
				return 9;
			}
		} else if(checkFlush()){
			player.setMoney(player.getMoney()+bet*20);
			setMoneyWon(bet*20);
			return 5;
		}
		setMoneyWon(0.00);
		return 0;
	}
}
