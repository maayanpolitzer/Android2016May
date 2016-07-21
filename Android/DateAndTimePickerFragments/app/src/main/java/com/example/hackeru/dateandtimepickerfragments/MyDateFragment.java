package com.example.hackeru.dateandtimepickerfragments;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;

/**
 * Created by hackeru on 7/21/2016.
 */
public class MyDateFragment extends DatePickerDialog {


    public MyDateFragment(Context context, OnDateSetListener callBack, int year, int monthOfYear, int dayOfMonth) {
        super(context, callBack, year, monthOfYear, dayOfMonth);
    }
}
