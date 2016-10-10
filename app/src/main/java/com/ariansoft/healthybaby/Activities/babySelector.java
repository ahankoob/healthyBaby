package com.ariansoft.healthybaby.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.ariansoft.healthybaby.Adapters.babySelectorGridAdapter;
import com.ariansoft.healthybaby.App.myApplication;
import com.ariansoft.healthybaby.Models.baseInfo;
import com.ariansoft.healthybaby.Models.mainMenuItems;
import com.ariansoft.healthybaby.R;

import java.util.ArrayList;
import java.util.List;

public class babySelector extends AppCompatActivity {
    List<baseInfo> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_selector);
        boolean fDialogMode     = getIntent().hasExtra( "dialog_mode" );

        if( ! fDialogMode ) {
            super.setTheme( android.R.style.Theme );
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        arrayList = baseInfo.find(baseInfo.class,"");
        babySelectorGridAdapter adapter = new babySelectorGridAdapter(getApplicationContext(),R.layout.baby_selector_grid_item,arrayList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                long babyID = ((baseInfo)arrayList.get(position)).getId();
                myApplication myApp = ((myApplication) getApplicationContext());
                myApp.setBabyID(((int) babyID));
                startActivity(new Intent(babySelector.this,main.class));
            }
        });
        findViewById(R.id.newBabyBTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(babySelector.this,register.class));
            }
        });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_baby_selector, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
