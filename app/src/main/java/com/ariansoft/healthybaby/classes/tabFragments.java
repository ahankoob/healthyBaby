/*
package com.ariansoft.healthybaby.classes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.FontAwesome.Example.TextAwesome;
import com.ariansoft.healthybaby.Activities.main;
import com.ariansoft.healthybaby.Adapters.mainMenuAdapter;
import com.ariansoft.healthybaby.Dialogs.babyForm;
import com.ariansoft.healthybaby.Models.mainMenuItems;
import com.ariansoft.healthybaby.R;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by elahe on 28/08/2016.
 *//*

public class tabFragments {
    public static View showFrame1(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState, final main.PlaceholderFragment mainFragment,int babiID)
    {
        GridView gridView;
        List<mainMenuItems> arrayList;
        final View rootView = inflater.inflate(R.layout.fragment_main,container,false);
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ViewGroup mContainer = (ViewGroup) rootView.findViewById(R.id.container);
        ((FloatingActionButton)rootView.findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getContext(),insertDaru.class));
                */
/*mainFragment.getFragmentManager().beginTransaction().replace(R.id.container, new com.ariansoft.healthybaby.Fragments.daruList()).commit();*//*

                FragmentManager manager = mainFragment.getFragmentManager();
                babyForm editNameDialog = new babyForm();
                editNameDialog.show(manager, "fragment_edit_name");

            }
        });
        gridView = (GridView) rootView.findViewById(R.id.grid);

        arrayList = new ArrayList<mainMenuItems>();
        mainMenuItems mainMenuItems = new mainMenuItems("دارو", rootView.getResources().getDrawable(R.drawable.menu1));
        arrayList.add(mainMenuItems);
        mainMenuItems = new mainMenuItems("واکسن", rootView.getResources().getDrawable(R.drawable.menu2));

        arrayList.add(mainMenuItems);
        mainMenuItems = new mainMenuItems("قد و وزن", rootView.getResources().getDrawable(R.drawable.menu3));
        arrayList.add(mainMenuItems);
        mainMenuItems = new mainMenuItems("درباره ما", rootView.getResources().getDrawable(R.drawable.menu4));
        arrayList.add(mainMenuItems);

        mainMenuAdapter mainMenuAdapter = new mainMenuAdapter(rootView.getContext(), R.layout.home_list_reminder, arrayList);

        gridView.setAdapter(mainMenuAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            */
/*    getFragmentManager().beginTransaction().replace(R.id.container, new com.ariansoft.healthybaby.Fragments.daruList()).commit();*//*

                Toast.makeText(view.getContext(),"sss",Toast.LENGTH_LONG).show();
            }
        });


        return rootView;
    }
    public static View showFrame2(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState, final main.PlaceholderFragment mainFragment,int babiID)
    {
        GridView gridView;
        List<mainMenuItems> arrayList;
        View rootView=null;

        rootView = inflater.inflate(R.layout.fragment_daru_list,container,false);

        com.FontAwesome.Example.TextAwesome daruPlusBTN =
                (TextAwesome)rootView.findViewById(R.id.daruPlus);


        return rootView;
    }
    public static View showFrame3(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState, final main.PlaceholderFragment mainFragment,int babiID)
    {
        GridView gridView;
        List<mainMenuItems> arrayList;
        View rootView=null;

        rootView = inflater.inflate(R.layout.fragment_daru_list,container,false);

        com.FontAwesome.Example.TextAwesome daruPlusBTN =
                (TextAwesome)rootView.findViewById(R.id.daruPlus);


        return rootView;
    }
    public static View showFrame4(LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState, final main.PlaceholderFragment mainFragment,int babiID)
    {
        GridView gridView;
        List<mainMenuItems> arrayList;
        View rootView=null;

        rootView = inflater.inflate(R.layout.fragment_daru_list,container,false);

        com.FontAwesome.Example.TextAwesome daruPlusBTN =
                (TextAwesome)rootView.findViewById(R.id.daruPlus);


        return rootView;
    }
}
*/
