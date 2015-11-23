package org.casino.people;

public class Player {
	private String name;
	private Double money;
	
	public Player(String aName){
		name = aName;
		money = 5000.00;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
	
}
