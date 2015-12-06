package org.casino.games;

public class Card {
	private Integer suit;
	private Integer value;
	
	public Card(Integer aSuit, Integer aValue){
		suit = aSuit;
		value = aValue;
	}
	public Integer getSuit() {
		return suit;
	}
	public void setSuit(Integer suit) {
		this.suit = suit;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	public String suitToString(){
		switch(suit){
		case 0: return "Spades";
		case 1: return "Hearts";
		case 2: return "Diamonds";
		case 3: return "Clubs";
		}
		return null;
	}
	
	public String valueToString(){
		switch(value){
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "Jack";
		case 12: return "Queen";
		case 13: return "King";
		case 14: return "Ace";
		}
		return null;
	}
	
	public String toString(){
		return valueToString() + "of" + suitToString();
	}
	
	public String imageString(){
		return valueToString().toLowerCase() + "_of_" + suitToString().toLowerCase() + ".png";
	}
	
}
