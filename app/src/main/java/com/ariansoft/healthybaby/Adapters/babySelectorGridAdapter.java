package com.ariansoft.healthybaby.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ariansoft.healthybaby.Models.baseInfo;
import com.ariansoft.healthybaby.Models.mainMenuItems;
import com.ariansoft.healthybaby.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.ariansoft.healthybaby.classes.AgeCalculation;
import com.ariansoft.healthybaby.classes.JalaliCalendar;
import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;
import com.beardedhen.androidbootstrap.BootstrapThumbnail;

/**
 * Created by elahe on 08/09/2016.
 */
public class babySelectorGridAdapter extends ArrayAdapter<baseInfo> {
    Context mContext;
    List<baseInfo> myList;
    int myResourceID;

    public babySelectorGridAdapter(Context context, int resource, List<baseInfo> objects) {
        super(context, resource, objects);
        mContext = context;
        myList=objects;
        myResourceID=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.baby_selector_grid_item, null);
            BootstrapCircleThumbnail profile_image = (BootstrapCircleThumbnail) grid.findViewById(R.id.profileIMG);
            TextView babyname = (TextView) grid.findViewById(R.id.babyName);
            TextView babyage = (TextView) grid.findViewById(R.id.babyAge);
            TextView babyid = (TextView) grid.findViewById(R.id.babyID);
            baseInfo baby = myList.get(position);
            try {
                File direct = new File(grid.getContext().getFilesDir().getAbsolutePath()+File.separator+"profiles");
                File file = new File(direct, baby.getId()+".png");
                FileInputStream in = new FileInputStream(file);
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                Drawable d = new BitmapDrawable(grid.getResources(), bitmap);
                profile_image.setImageDrawable(d);
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            babyname.setText(baby.babyName);
            String tempSTR = String.valueOf(baby.birthDate).replace(".","");
            String shamsiDate = String.valueOf( tempSTR).substring(0, 4)+"/"+
                    String.valueOf(tempSTR).substring(4, 6)+"/"+
                    String.valueOf(tempSTR).substring(6, 8);
            JalaliCalendar calendar = new JalaliCalendar(TimeZone.getDefault());
            Date gorgianDate = calendar.getGregorianDate(shamsiDate);
            AgeCalculation ageCalculation= new AgeCalculation(gorgianDate.getYear(),gorgianDate.getMonth(),gorgianDate.getDate());
            babyage.setText(ageCalculation.getResult());


        } else {
            grid = convertView;
        }

        return grid;


    }
}
