package com.ariansoft.healthybaby.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.ariansoft.healthybaby.Adapters.mainMenuAdapter;
import com.ariansoft.healthybaby.Models.mainMenuItems;
import com.ariansoft.healthybaby.R;

import java.util.ArrayList;
import java.util.List;


public class mainFragment extends Fragment {
    GridView gridView;
    Context context;
    List<mainMenuItems> arrayList;


    public mainFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentLayout = inflater.inflate(R.layout.fragment_main, container, false);
        /*testDataInsert();
        ((FloatingActionButton)fragmentLayout.findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getContext(),insertDaru.class));
                getFragmentManager().beginTransaction().replace(R.id.container, new com.ariansoft.healthybaby.Fragments.daruList()).commit();
            }
        });*/
        gridView = (GridView) fragmentLayout.findViewById(R.id.grid);

        arrayList = new ArrayList<mainMenuItems>();
        mainMenuItems mainMenuItems = new mainMenuItems("دارو", getResources().getDrawable(R.drawable.menu1));
        arrayList.add(mainMenuItems);
        mainMenuItems = new mainMenuItems("واکسن", getResources().getDrawable(R.drawable.menu2));

        arrayList.add(mainMenuItems);
        mainMenuItems = new mainMenuItems("قد و وزن", getResources().getDrawable(R.drawable.menu3));
        arrayList.add(mainMenuItems);
        mainMenuItems = new mainMenuItems("درباره ما", getResources().getDrawable(R.drawable.menu4));
        arrayList.add(mainMenuItems);

        mainMenuAdapter mainMenuAdapter = new mainMenuAdapter(fragmentLayout.getContext(), R.layout.daru_list_item, arrayList);

        gridView.setAdapter(mainMenuAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            /*    getFragmentManager().beginTransaction().replace(R.id.container, new com.ariansoft.healthybaby.Fragments.daruList()).commit();*/
                Toast.makeText(fragmentLayout.getContext(),"sss",Toast.LENGTH_LONG).show();
            }
        });


        return fragmentLayout;
    }
    public void testDataInsert()
    {

    }
}
