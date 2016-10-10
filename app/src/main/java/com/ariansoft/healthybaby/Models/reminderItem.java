package com.ariansoft.healthybaby.Models;

/**
 * Created by abolfazl on 22/08/2016.
 */
public class reminderItem {
	public String reminderTimeLeft;
	public String reminderName;
	public String reminderLastUse;
	public String reminderUsage;
	public boolean isReminderSet;
	public int remiderType;

	public reminderItem(String reminderTimeLeft, String reminderName, String reminderLastUse, String reminderUsage, boolean isReminderSet, int remiderType) {
		this.reminderTimeLeft = reminderTimeLeft;
		this.reminderName = reminderName;
		this.reminderLastUse = reminderLastUse;
		this.reminderUsage = reminderUsage;
		this.isReminderSet = isReminderSet;
		this.remiderType = remiderType;
	}
}
