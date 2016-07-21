package com.example.hackeru.dateandtimepickerfragments;

import android.app.TimePickerDialog;
import android.content.Context;

/**
 * Created by hackeru on 7/21/2016.
 */
public class MyTimeFragment extends TimePickerDialog {

    public MyTimeFragment(Context context, OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) {
        super(context, listener, hourOfDay, minute, is24HourView);
    }
}
