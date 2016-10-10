package com.ariansoft.healthybaby.Dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.FontAwesome.Example.ButtonAwesome;
import com.ariansoft.healthybaby.Models.baseInfo;
import com.ariansoft.healthybaby.R;
import com.beardedhen.androidbootstrap.BootstrapButton;
import com.dd.processbutton.iml.ActionProcessButton;

import java.util.Calendar;
import java.util.zip.Inflater;

public class babyForm extends DialogFragment {
    View dialogView;
    int babyID;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        Bundle bundle = this.getArguments();
        if(bundle!=null)
            babyID = bundle.getInt("babyID");
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        dialogView = layoutInflater.inflate(R.layout.fragment_baby_form, null);
        BootstrapButton returnBTN = (BootstrapButton) dialogView.findViewById(R.id.returnBTN);
        returnBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseInfo baby = baseInfo.findById(baseInfo.class,babyID);
                AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext()).
                    setPositiveButton(baby.babyName, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getContext(),"hello",Toast.LENGTH_LONG).show();
                        }
                    })
                        .setNegativeButton("bye", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(),"bye",Toast.LENGTH_LONG).show();
                            }
                        });
                AlertDialog alertDialog = builder1.create();
                alertDialog.show();

            }
        });
        builder.setView(dialogView);
        Dialog mydialog = builder.create();

        return mydialog;
    }
    public static babyForm newInstance(int num) {
        babyForm f = new babyForm();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }
    public static java.util.Date getDateFromDatePicker(DatePicker datePicker){
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year =  datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar.getTime();
    }

}