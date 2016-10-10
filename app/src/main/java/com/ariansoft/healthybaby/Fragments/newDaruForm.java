package com.ariansoft.healthybaby.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.ariansoft.healthybaby.R;

public class newDaruForm extends Fragment {
    public newDaruForm() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FrameLayout frameLayout = (FrameLayout) inflater.inflate(R.layout.fragment_new_daru_form, container, false);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (frameLayout.getContext(), android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.daruTypes));


        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
        Spinner daruType = (Spinner) frameLayout.findViewById(R.id.daruType1);
        daruType.setAdapter(dataAdapter);
        Button daruSave = (Button) frameLayout.findViewById(R.id.daruSave);
        daruSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return frameLayout;
    }

  }
