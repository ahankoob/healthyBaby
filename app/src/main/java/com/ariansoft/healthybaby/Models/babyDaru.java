package com.ariansoft.healthybaby.Models;


import com.orm.SugarRecord;

public class babyDaru extends SugarRecord {
	public int babyID;
	public int amount;
	public int amountTypeID;
	public int daruTypeID;
	public String DaruName;
	public int countHour;

	public babyDaru() {
	}

	public babyDaru(int babyID, int amount, int amountTypeID, int daruTypeID, String daruName, int countHour) {
		this.babyID = babyID;
		this.amount = amount;
		this.amountTypeID = amountTypeID;
		this.daruTypeID = daruTypeID;
		DaruName = daruName;
		this.countHour = countHour;
	}
}