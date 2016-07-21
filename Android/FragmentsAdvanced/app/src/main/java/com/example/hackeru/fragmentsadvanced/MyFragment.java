package com.example.hackeru.fragmentsadvanced;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyFragment extends DialogFragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Activity activity;
    private SeekBar seekBar;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        String name = getArguments().getString("NAME");

        builder.setTitle("this is the title");
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_my, null);
        TextView textView = (TextView) view.findViewById(R.id.fragmentTextView);

        seekBar = (SeekBar) view.findViewById(R.id.seekbar);
        seekBar.setMax(255);    // the seekbar default minimum is 0;
        try {
            seekBar.setProgress(Settings.System.getInt(activity.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS));
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        seekBar.setOnSeekBarChangeListener(this);
        textView.setText("Hi " + name + ", How R U ?");
        Button button = (Button) view.findViewById(R.id.setBtn);
        button.setOnClickListener(this);
        builder.setView(view);
        /*
        builder.setMessage("message");
        builder.setIcon(android.R.drawable.btn_star);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        */
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }


    @Override
    public void onClick(View v) {
        // save the new data...
        //((MainActivity) activity).setHappiness(seekBar.getProgress());
        ((HappinessChangedListener) activity).setHappiness(seekBar.getProgress());
        dismiss();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        float brightNess = ((float) progress);
        Settings.System.putInt(activity.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, progress);
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        brightNess /= 255;
        Log.d("Maayan", "brightness is: " + brightNess/255);
        params.screenBrightness = brightNess;
        activity.getWindow().setAttributes(params);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
