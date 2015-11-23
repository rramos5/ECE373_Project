package org.casino.games;

import org.casino.people.Player;

public abstract class Game {
	protected Player player;
	protected Double moneyWon;
	protected Double bet;
	protected String gameType;
	protected String gameName;

	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Double getMoneyWon() {
		return moneyWon;
	}
	public void setMoneyWon(Double moneyWon) {
		this.moneyWon = moneyWon;
	}
	public Double getBet() {
		return bet;
	}
	public void setBet(Double bet) {
		this.bet = bet;
		player.setMoney(player.getMoney() - bet);
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
		
}
