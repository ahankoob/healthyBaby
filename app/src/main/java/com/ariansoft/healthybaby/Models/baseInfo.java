package com.ariansoft.healthybaby.Models;


import com.orm.SugarRecord;

public class baseInfo extends SugarRecord {
	public int babyID;
	public String babyName;

	public int babyGender;

	public double birthDate;

	public baseInfo(){};
	public baseInfo(int babyID, String babyName, int babyGender, double birthDate) {
		this.babyID = babyID;
		this.babyName = babyName;
		this.babyGender = babyGender;
		this.birthDate = birthDate;
	}
}
