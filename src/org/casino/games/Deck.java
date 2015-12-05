package org.casino.games;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards;
	
	public Deck(){
		cards = new ArrayList<Card>();
		for (int i = 0; i<4; i++){
			for(int j = 2; j<15; j++){
				cards.add(new Card(i,j));
			}
		}
		shuffle();
	}
	
	public void shuffle(){
		Collections.shuffle(cards);
	}
	
	public Card dealACard(){
		//deal a card from the deck
		Card card = cards.get(0);
		cards.remove(0);
		return card;
	}
	
	public int cardsLeft(){
		return cards.size();
	}
}
