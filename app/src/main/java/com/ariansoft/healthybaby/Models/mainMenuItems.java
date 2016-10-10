package com.ariansoft.healthybaby.Models;

import android.graphics.drawable.Drawable;

public class mainMenuItems {
	private String menuName;
	private Drawable menuImage;

	public mainMenuItems(String menuName, Drawable menuImage) {
		this.menuName = menuName;
		this.menuImage = menuImage;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Drawable getMenuImage() {
		return menuImage;
	}

	public void setMenuImage(Drawable menuImage) {
		this.menuImage = menuImage;
	}
}
