package com.ariansoft.healthybaby.App;

import android.app.Application;

;import com.beardedhen.androidbootstrap.TypefaceProvider;
import com.orm.SugarContext;

/**
 * Created by abolfazl on 19/08/2016.
 */
public class myApplication extends Application {
	private int babyID;
	@Override
	public void onCreate() {
		super.onCreate();
		SugarContext.init(getApplicationContext());
		TypefaceProvider.registerDefaultIconSets();

	}

	public int getBabyID() {
		return babyID;
	}

	public void setBabyID(int babyID) {
		this.babyID = babyID;
	}
}
