package com.ariansoft.healthybaby.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.ariansoft.healthybaby.Models.babyDaru;
import com.ariansoft.healthybaby.Models.reminderItem;
import com.ariansoft.healthybaby.R;

import java.util.List;

/**
 * Created by abolfazl on 22/08/2016.
 */
public class daru_lis_adapter extends ArrayAdapter<babyDaru> {
	Context _context;
	List<babyDaru> darus;
	int itemID;

	public daru_lis_adapter(Context _context, int resource, List<babyDaru> darus) {
		super(_context, resource, darus);
		this.darus = darus;
		this._context = _context;
		this.itemID = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View myitem = convertView;
		LayoutInflater inflater = (LayoutInflater) _context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (myitem == null) {
			myitem = new View(_context);
			myitem = inflater.inflate(R.layout.daru_list_item, null);
			ImageView daruImage = (ImageView) myitem.findViewById(R.id.daruIMG);
			TextView daruTimeLeft = (TextView) myitem.findViewById(R.id.daruTimeLeft);
			TextView daruname = (TextView) myitem.findViewById(R.id.daruName);
			TextView daruLastUse = (TextView) myitem.findViewById(R.id.daruLastUse);
			TextView reminderUsage = (TextView) myitem.findViewById(R.id.reminderUsage);
			babyDaru babyDaru = darus.get(position);

			daruname.setText(babyDaru.DaruName);
			reminderUsage.setText(" هر "+babyDaru.countHour+" ساعت ");
			if(babyDaru.daruTypeID==1){

			}
			else if(babyDaru.daruTypeID==2){

			}
			else if(babyDaru.daruTypeID==3){
				daruImage.setImageDrawable(myitem.getResources().getDrawable(R.drawable.icon1));
			}
			else if(babyDaru.daruTypeID==4){

			}



		}
		else
		{
			myitem = convertView;
		}
		return myitem;
	}
}


