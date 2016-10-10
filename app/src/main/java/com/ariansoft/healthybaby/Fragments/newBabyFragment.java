package com.ariansoft.healthybaby.Fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Application;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.CompoundButtonCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ariansoft.healthybaby.Activities.main;
import com.ariansoft.healthybaby.App.myApplication;
import com.beardedhen.androidbootstrap.BootstrapEditText;

import com.FontAwesome.Example.TextAwesome;
import com.ariansoft.healthybaby.Activities.register;
import com.ariansoft.healthybaby.Dialogs.datepickerDialog;
import com.ariansoft.healthybaby.Models.baseInfo;
import com.ariansoft.healthybaby.R;

import java.io.File;
import java.io.FileOutputStream;
import java.security.PublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class newBabyFragment extends Fragment {
    int babyID;

    RelativeLayout relativeLayout;
    public static final int THIS_FRAGMENT = 1;
    public newBabyFragment() {
        // Required empty public constructor
    }
    public static newBabyFragment newInstance(int index) {
        newBabyFragment f = new newBabyFragment();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle!=null)
        babyID = bundle.getInt("babyID");
        else
            babyID=3;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        relativeLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_new_baby, container, false);

        final BootstrapEditText babyname = ((BootstrapEditText) relativeLayout.findViewById(R.id.babyName));
        final BootstrapEditText babyAge = ((BootstrapEditText) relativeLayout.findViewById(R.id.babyAge));
        final RadioGroup gender = ((RadioGroup) relativeLayout.findViewById(R.id.gender));
        ImageView profile_image = ((ImageView) relativeLayout.findViewById(R.id.profileIMG));

        babyAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();;
                bundle.putInt("babyID", babyID );
                FragmentManager manager = getFragmentManager();
                datepickerDialog editNameDialog = new datepickerDialog().newInstance(1);
                editNameDialog.setArguments(bundle);
                editNameDialog.show(manager, "fragment_edit_name");
            }
        });

        relativeLayout.findViewById(R.id.step1BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int checkedID =((RadioGroup)relativeLayout.findViewById(R.id.gender)).getCheckedRadioButtonId();
                if (checkedID== -1)
                {

                }
                else
                {
                    if(checkedID== R.id.isBoy)
                    {
                        relativeLayout.findViewById(R.id.profileIMG1).setVisibility(View.VISIBLE);
                        relativeLayout.findViewById(R.id.profileIMG2).setVisibility(View.VISIBLE);
                        relativeLayout.findViewById(R.id.profileIMG3).setVisibility(View.VISIBLE);
                        relativeLayout.findViewById(R.id.profileIMG4).setVisibility(View.VISIBLE);
                        relativeLayout.findViewById(R.id.profileIMG5).setVisibility(View.GONE);
                        relativeLayout.findViewById(R.id.profileIMG6).setVisibility(View.GONE);
                        relativeLayout.findViewById(R.id.profileIMG7).setVisibility(View.GONE);
                        relativeLayout.findViewById(R.id.profileIMG8).setVisibility(View.GONE);

                    }
                    else if(checkedID== R.id.isGirl)
                    {

                        relativeLayout.findViewById(R.id.profileIMG1).setVisibility(View.GONE);
                        relativeLayout.findViewById(R.id.profileIMG2).setVisibility(View.GONE);
                        relativeLayout.findViewById(R.id.profileIMG3).setVisibility(View.GONE);
                        relativeLayout.findViewById(R.id.profileIMG4).setVisibility(View.GONE);
                        relativeLayout.findViewById(R.id.profileIMG5).setVisibility(View.VISIBLE);
                        relativeLayout.findViewById(R.id.profileIMG6).setVisibility(View.VISIBLE);
                        relativeLayout.findViewById(R.id.profileIMG7).setVisibility(View.VISIBLE);
                        relativeLayout.findViewById(R.id.profileIMG8).setVisibility(View.VISIBLE);
                    }
                    final RelativeLayout step1 = (RelativeLayout)relativeLayout.findViewById(R.id.step1);
                    final RelativeLayout step2 = (RelativeLayout)relativeLayout.findViewById(R.id.step2);
                    step1.animate()
                        .translationY(0)
                        .alpha(0.0f);
                    step1.setVisibility(View.GONE);
                    step2.animate()
                            .translationY(0)
                            .alpha(1.0f);
                    step2.setVisibility(View.VISIBLE);




                }
            }
        });

        relativeLayout.findViewById(R.id.step1BTN1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final RelativeLayout step2 = (RelativeLayout)relativeLayout.findViewById(R.id.step1);
                final RelativeLayout step1 = (RelativeLayout)relativeLayout.findViewById(R.id.step2);
                step1.animate()
                        .translationY(0)
                        .alpha(0.0f);
                step1.setVisibility(View.GONE);
                step2.animate()
                        .translationY(0)
                        .alpha(1.0f);
                step2.setVisibility(View.VISIBLE);
            }
        });

        relativeLayout.findViewById(R.id.saveBTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int babyGender=0;
                int genderID =((RadioGroup)relativeLayout.findViewById(R.id.gender)).getCheckedRadioButtonId();
                if(genderID==R.id.isBoy)
                    babyGender=1;
                else if (genderID==R.id.isGirl)
                    babyGender=2;
                String [] birthdateStr = babyAge.getText().toString().split("/");
                double birthDate = Double.parseDouble(birthdateStr[0]+ String.format("%02d",Integer.parseInt(birthdateStr[1]))+String.format("%02d", Integer.parseInt(birthdateStr[2])));
                baseInfo baby = new baseInfo(1,babyname.getText().toString(),babyGender,birthDate);
                long id=baby.save();
                BitmapDrawable drawable = (BitmapDrawable) ((com.beardedhen.androidbootstrap.BootstrapCircleThumbnail)relativeLayout.findViewById(R.id.profileIMG)).getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                createDirectoryAndSaveFile(bitmap,id);

                myApplication myApp = ((myApplication) getActivity().getApplicationContext());
                myApp.setBabyID((int) id);
                getContext().startActivity(new Intent(getActivity(),main.class));
            }
        });


        com.beardedhen.androidbootstrap.BootstrapCircleThumbnail cameraBTN = (com.beardedhen.androidbootstrap.BootstrapCircleThumbnail) relativeLayout.findViewById(R.id.cameraBTN);
        cameraBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {((register)getActivity()).captureImage(); }
        });
        com.beardedhen.androidbootstrap.BootstrapCircleThumbnail galleryBTN = (com.beardedhen.androidbootstrap.BootstrapCircleThumbnail) relativeLayout.findViewById(R.id.galleryBTN);
        galleryBTN.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {((register)getActivity()).pickImage(); }
        });
        // Checking camera availability
        if (!((register)getActivity()).isDeviceSupportCamera()) {
            Toast.makeText(getContext(),
                    "Sorry! Your device doesn't support camera",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device does't have camera
            getActivity().finish();
        }

        relativeLayout.findViewById(R.id.profileIMG1).setOnClickListener(imgclick);
        relativeLayout.findViewById(R.id.profileIMG2).setOnClickListener(imgclick);
        relativeLayout.findViewById(R.id.profileIMG3).setOnClickListener(imgclick);
        relativeLayout.findViewById(R.id.profileIMG4).setOnClickListener(imgclick);
        relativeLayout.findViewById(R.id.profileIMG5).setOnClickListener(imgclick);
        relativeLayout.findViewById(R.id.profileIMG6).setOnClickListener(imgclick);
        relativeLayout.findViewById(R.id.profileIMG7).setOnClickListener(imgclick);
        relativeLayout.findViewById(R.id.profileIMG8).setOnClickListener(imgclick);

        return  relativeLayout;
    }

    public View.OnClickListener imgclick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            BitmapDrawable drawable = (BitmapDrawable) ((com.beardedhen.androidbootstrap.BootstrapCircleThumbnail)v).getDrawable();
            Bitmap bitmap = drawable.getBitmap();
            setImage(bitmap);

        }
    };
   public void setImage(Bitmap bitmap)
   {
       com.beardedhen.androidbootstrap.BootstrapCircleThumbnail profile_image = (com.beardedhen.androidbootstrap.BootstrapCircleThumbnail) relativeLayout.findViewById(R.id.profileIMG);
       profile_image.setImageBitmap(bitmap);
   }
    public void getDataFromDialog(String data)
    {
        com.beardedhen.androidbootstrap.BootstrapEditText babyAge =  ((com.beardedhen.androidbootstrap.BootstrapEditText)relativeLayout.findViewById(R.id.babyAge));


        babyAge.setText(data);
    }
    private void createDirectoryAndSaveFile(Bitmap imageToSave, long id) {

        File direct = new File(getActivity().getFilesDir().getAbsolutePath()+File.separator+"profiles");

        if (!direct.exists()) {
            direct.mkdirs();
        }

        File file = new File(direct, String.valueOf(id)+".png");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            imageToSave.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
