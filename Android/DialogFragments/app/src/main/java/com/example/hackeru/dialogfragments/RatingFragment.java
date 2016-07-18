package com.example.hackeru.dialogfragments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by hackeru on 7/18/2016.
 */
public class RatingFragment extends DialogFragment {

    private Context context;
    private String name;

    /*
    public void getData(String name){
        this.name = name;
    }
    */

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder  = new AlertDialog.Builder(context);
        /*
        builder.setTitle("this is the title");
        builder.setMessage("this is the message");
        //builder.setIcon(R.mipmap.ic_launcher);
        builder.setIcon(android.R.drawable.ic_dialog_map);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNeutralButton("settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });
        */
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_login, null);
        EditText editText = (EditText) view.findViewById(R.id.username);
        name = getArguments().getString("NAME");
        editText.setText(name);
        Button button = (Button) view.findViewById(R.id.loginBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
}

