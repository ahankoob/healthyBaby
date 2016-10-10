package com.ariansoft.healthybaby.Dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.ariansoft.healthybaby.Fragments.daruList;
import com.ariansoft.healthybaby.Fragments.newBabyFragment;
import com.ariansoft.healthybaby.Models.baseInfo;
import com.ariansoft.healthybaby.R;
import com.ariansoft.healthybaby.classes.JDF;
import com.beardedhen.androidbootstrap.BootstrapButton;

public class datepickerDialog extends DialogFragment {
    View dialogView;
        public static final String G_DAY = "gDay";
        public static final String G_MONTH = "gMonth";
        public static final String G_YEAR = "gYear";
        public static final String J_DAY = "jDay";
        public static final String J_MONTH = "jMonth";
        public static final String J_YEAR = "jYear";
        private String[] monthNames = { "فروردین", "اردیبهشت", "خرداد", "تیر",
                "مرداد", "شهریور", "مهر", "آبان", "آذر", "دی", "بهمن", "اسفند" };
        private NumberPicker npDay;
        private NumberPicker npMonth;
        private NumberPicker npYear;

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        Bundle bundle = this.getArguments();
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        dialogView = layoutInflater.inflate(R.layout.datepicker_shamsi, null);
        NumberPicker.OnValueChangeListener onChangeListener = new NumberPicker.OnValueChangeListener() {



            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                                      int newVal) {
                if (picker == npMonth) {
                    if (newVal <= 6) {
                        npDay.setMaxValue(31);
                    } else {
                        npDay.setMaxValue(30);
                    }
                }


            }
        };
        npYear = (NumberPicker) dialogView.findViewById(R.id.npYear);
        npMonth = (NumberPicker) dialogView.findViewById(R.id.npMonth);
        npDay = (NumberPicker) dialogView.findViewById(R.id.npDay);
        Button btnOk = (Button) dialogView.findViewById(R.id.btnDateFrom);

        npMonth.setOnValueChangedListener(onChangeListener);
        JDF jdf = new JDF();
        int iranianYear = jdf.getIranianYear();
        int iranianMonth = jdf.getIranianMonth();
        int iranianDay = jdf.getIranianDay();

        npYear.setMinValue(1390);
        npYear.setMaxValue(iranianYear);
        npYear.setWrapSelectorWheel(true);
        npMonth.setMinValue(01);
        npMonth.setMaxValue(12);
        npMonth.setDisplayedValues(monthNames);

        npDay.setMinValue(01);
        npDay.setMaxValue(31);

        npYear.setValue(iranianYear);
        npMonth.setValue(iranianMonth);
        npDay.setValue(iranianDay);
        builder.setView(dialogView);
        final Dialog mydialog = builder.create();
        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                int newIrYear = npYear.getValue();
                int newIrMonth = npMonth.getValue();
                int newIrDay = npDay.getValue();

                JDF jdf = new JDF();
                jdf.setIranianDate(newIrYear, newIrMonth, newIrDay);

                Intent returnIntent = new Intent();
                returnIntent.putExtra(J_YEAR, newIrYear);
                returnIntent.putExtra(J_MONTH, newIrMonth);
                returnIntent.putExtra(J_DAY, newIrDay);
                returnIntent.putExtra(G_YEAR, jdf.getGregorianYear());
                returnIntent.putExtra(G_MONTH, jdf.getGregorianMonth());
                returnIntent.putExtra(G_DAY, jdf.getGregorianDay());

                /*getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, returnIntent);
                dismiss();*/
                dataFromDialog(String.valueOf(newIrYear)+"/"+String.valueOf(newIrMonth)+"/"+String.valueOf(newIrDay));
                mydialog.dismiss();

            }
        });



        return mydialog;
    }
    public static datepickerDialog newInstance(int num) {
        datepickerDialog f = new datepickerDialog();

        // Supply num input as an argument.
        Bundle args = new Bundle();
        args.putInt("num", num);
        f.setArguments(args);

        return f;
    }
    public void dataFromDialog(String data){
        newBabyFragment mf = (newBabyFragment) getFragmentManager().getFragments().get(0);

        mf.getDataFromDialog(data);
    }

}
