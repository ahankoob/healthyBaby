package com.ariansoft.healthybaby.Fragments;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.FontAwesome.Example.TextAwesome;
import com.ariansoft.healthybaby.Adapters.babySelectorGridAdapter;
import com.ariansoft.healthybaby.Adapters.daru_lis_adapter;
import com.ariansoft.healthybaby.App.myApplication;
import com.ariansoft.healthybaby.Dialogs.datepickerDialog;
import com.ariansoft.healthybaby.Dialogs.babyForm;
import com.ariansoft.healthybaby.Models.babyDaru;
import com.ariansoft.healthybaby.Models.baseInfo;
import com.ariansoft.healthybaby.R;

import java.util.List;


public class daruList extends Fragment {
    int babyID;
    FrameLayout frameLayout;
    public List<babyDaru> myList;
    public static final int THIS_FRAGMENT = 1;
    public daruList() {
        // Required empty public constructor
    }
    public static daruList newInstance(int index) {
        daruList f = new daruList();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myApplication myApp = ((myApplication) getActivity().getApplicationContext());
        babyID=myApp.getBabyID();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_daru_list, container, false);
        List<babyDaru> babyDarus = new babyDaru().find(babyDaru.class,"BABY_ID = ?",String.valueOf(babyID));
        daru_lis_adapter adapter = new daru_lis_adapter(getActivity().getApplicationContext(),R.layout.daru_list_item,babyDarus);
        /*List<baseInfo> arrayList = baseInfo.find(baseInfo.class,"");
        babySelectorGridAdapter adapter = new babySelectorGridAdapter(getContext(),R.layout.baby_selector_grid_item,arrayList);*/
        ((ListView)frameLayout.findViewById(R.id.listView)).setAdapter(adapter);
/*
                Bundle bundle = new Bundle();;
                bundle.putInt("babyID", babyID );
                FragmentManager manager = getFragmentManager();
                babyForm editNameDialog = new babyForm().newInstance(1);
                editNameDialog.setArguments(bundle);
                editNameDialog.show(manager, "fragment_edit_name");
*/




        return  frameLayout;
    }


}
