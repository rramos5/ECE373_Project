package org.casino.software;

import org.casino.games.AmazingSevens;
import org.casino.games.BlackJack;
import org.casino.games.Classic;
import org.casino.people.Player;

public class Casino {
	private Player player;
	private Classic classic;
	private BlackJack blkjck;
	private	AmazingSevens slot;
	
	public Casino(){
		setPlayer(new Player("Player1"));
		setClassic(new Classic());
		setBlkjck(new BlackJack());
		slot = new AmazingSevens();
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Classic getClassic() {
		return classic;
	}

	public void setClassic(Classic classic) {
		this.classic = classic;
	}

	public BlackJack getBlkjck() {
		return blkjck;
	}

	public void setBlkjck(BlackJack blkjck) {
		this.blkjck = blkjck;
	}
	
}
