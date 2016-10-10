package com.ariansoft.healthybaby.Adapters;

import android.app.Activity;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andexert.library.RippleView;
import com.ariansoft.healthybaby.Fragments.daruList;
import com.ariansoft.healthybaby.Models.mainMenuItems;
import com.ariansoft.healthybaby.R;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import android.support.v4.app.Fragment;
/**
 * Created by abolfazl on 17/08/2016.
 */
public class mainMenuAdapter extends ArrayAdapter<mainMenuItems> {
	Context mContext;
	List<mainMenuItems> myList;
	int myResourceID;

	public mainMenuAdapter(Context context, int resource, List<mainMenuItems> objects) {
		super(context, resource, objects);
		this.mContext = context;
		this.myList = objects;
		myResourceID = resource;
	}

	@Override
	public View getView(int p, View convertView, ViewGroup parent) {
		View grid;
		LayoutInflater inflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (convertView == null) {

			grid = new View(mContext);
			grid = inflater.inflate(R.layout.main_grid_item, null);
			TextView textView = (TextView) grid.findViewById(R.id.gridview_text);
			ImageView imageView = (ImageView)grid.findViewById(R.id.gridview_image);
			LinearLayout linearLayout = (LinearLayout) grid.findViewById(R.id.linearLayout);
			RippleView rippleView = (RippleView) grid.findViewById(R.id.more);

			textView.setText(myList.get(p).getMenuName());
			imageView.setImageDrawable(myList.get(p).getMenuImage());
			Random r = new Random();

			switch (p)
			{
				case 0:
					linearLayout.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu5Primary));
					textView.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu5secondery));


					break;
				case 1:
					linearLayout.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu1Primary));
					textView.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu1secondery));
					break;
				case 2:
					linearLayout.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu7Primary));
					textView.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu7secondery));
					break;
				case 3:
					linearLayout.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu2Primary));
					textView.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu2secondery));
					break;
				case 4:
					linearLayout.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu6Primary));
					textView.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu6secondery));
					break;
				case 5:
					linearLayout.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu3Primary));
					textView.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu3secondery));
					break;
				case 6:
					linearLayout.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu4Primary));
					textView.setBackgroundColor(grid.getResources().getColor( R.color.mainmenu4secondery));
					break;

			}

		} else {
			grid = convertView;
		}

		return grid;
	}
}

