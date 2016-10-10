package com.ariansoft.healthybaby.Activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ariansoft.healthybaby.App.myApplication;
import com.ariansoft.healthybaby.Fragments.daruList;
import com.ariansoft.healthybaby.Fragments.mainFragment;
import com.ariansoft.healthybaby.Models.amountTypeList;
import com.ariansoft.healthybaby.Models.babyDaru;
import com.ariansoft.healthybaby.Models.baseInfo;
import com.ariansoft.healthybaby.Models.daru;
import com.ariansoft.healthybaby.Models.daruTypeList;
import com.ariansoft.healthybaby.R;
import com.ariansoft.healthybaby.Services.heakthyBabyService;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail;

import java.io.File;
import java.io.FileInputStream;
//import com.ariansoft.healthybaby.classes.tabFragments;


public class main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private int babyID;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        myApplication myApp = ((myApplication) getApplicationContext());
        babyID=myApp.getBabyID();

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            amountTypeList amountTypeList = new amountTypeList("عدد");
            amountTypeList.save();
            amountTypeList = new amountTypeList("قاشق چایخوری");
            amountTypeList.save();
            amountTypeList = new amountTypeList("قاشق مرباخوری");
            amountTypeList.save();
            amountTypeList = new amountTypeList("قاشق چایخوری");
            amountTypeList.save();
            amountTypeList = new amountTypeList("قطره");
            amountTypeList.save();

            daruTypeList daruTypeList = new daruTypeList("قرص");
            daruTypeList.save();
            daruTypeList = new daruTypeList("کسپول");
            daruTypeList.save();
            daruTypeList = new daruTypeList("قطره");
            daruTypeList.save();
            daruTypeList = new daruTypeList("شربت");
            daruTypeList.save();

            babyDaru babyDaru = new babyDaru(1,20,5,3,"مولتی ویتامین",8);
            babyDaru.save();
            babyDaru = new babyDaru(1,8,5,3,"کولیکیز",12);
            babyDaru.save();

        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();

        if (babyID==0)
        {
            Intent intent = new Intent(this, babySelector.class);
            startActivity(intent);
            finish();

        }
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            //setSupportActionBar(toolbar);

            mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
            mViewPager = (ViewPager) findViewById(R.id.container);
            mViewPager.setAdapter(mSectionsPagerAdapter);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(mViewPager);

           DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            View navHeaderView = navigationView.inflateHeaderView(R.layout.nav_header_home);
            navigationView.setNavigationItemSelectedListener(this);
            startService(new Intent(main.this, heakthyBabyService.class));


        BootstrapCircleThumbnail profile_image = (BootstrapCircleThumbnail) findViewById(R.id.profileIMG);
        BootstrapCircleThumbnail profile_image1 = (BootstrapCircleThumbnail) navHeaderView.findViewById(R.id
                .profile_image_drawer);
        TextView babyname = (TextView) findViewById(R.id.babyName);
        TextView babyage = (TextView) findViewById(R.id.babyAge);
        baseInfo baby = baseInfo.findById(baseInfo.class,babyID);
        try {
            File direct = new File(getApplicationContext().getFilesDir().getAbsolutePath()+File
                    .separator+"profiles");
            File file = new File(direct, baby.getId()+".png");
            FileInputStream in = new FileInputStream(file);
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            Drawable d = new BitmapDrawable(getResources(), bitmap);
            profile_image.setImageDrawable(d);
            profile_image1.setImageDrawable(d);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        findViewById(R.id.changeBabyBTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                babySelector dialogBabySelector = new babySelector();
                //dialogBabySelector.setTheme(android.R.style.Theme_Dialog);
                //dialogBabySelector.setFinishOnTouchOutside(false);
                Intent intent = new Intent(main.this,dialogBabySelector.getClass());
                Bundle b = new Bundle();
                b.putInt("dialog_mode", 1);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        });
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Bundle bundle = new Bundle();
            bundle.putInt("babyID", babyID );

            if(position==0) {
                daruList fragInfo = new daruList().newInstance(1);
                fragInfo.setArguments(bundle);
                return fragInfo;
            }
            else if(position==1){
                daruList fragInfo = new daruList().newInstance(1);
                fragInfo.setArguments(bundle);
                return fragInfo;
            }
            else if(position==2){
                mainFragment fragInfo = new mainFragment();
                //fragInfo.setArguments(bundle);
                return fragInfo;
            }
            else if(position==3){
                mainFragment fragInfo = new mainFragment();
                //fragInfo.setArguments(bundle);
                return fragInfo;
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "لیست داروها";
                case 1:
                    return "لیست  واکسن ها";
                case 2:
                    return "رشد نوزاد";
                case 3:
                    return "SECTION 3";
            }
            return null;
        }

    }
}
