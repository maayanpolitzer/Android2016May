package com.example.hackeru.sqlitewithimagesaving;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Hackeru on 11/08/2016.
 */
public class EditContactDialog extends DialogFragment {

    private Context context;
    private EditText nameEditText, phoneEditText;
    private SQLiteDatabase db;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final long id = getArguments().getLong(MainActivity.ID);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Edit your contact");
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_edit_contact, null);
        nameEditText = (EditText) view.findViewById(R.id.dialog_edit_name);
        phoneEditText = (EditText) view.findViewById(R.id.dialog_edit_phone);
        setDataInEditTexts(id);
        builder.setView(view);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // update the table!!!!
                updateTheTable(id);
                // return to activity and refresh the listView.
                ((UpdateListViewListener)context).update();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // no need to write dismiss();
            }
        });
        return builder.create();
    }

    private void updateTheTable(long id) {
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLUMN_NAME, nameEditText.getText().toString().trim());
        values.put(DBOpenHelper.COLUMN_PHONE, phoneEditText.getText().toString().trim());
        int rowsAffected = db.update(
                DBOpenHelper.TABLE_CONTACTS,
                values,
                DBOpenHelper.COLUMN_ID + "=?",
                new String[]{id + ""}
        );

        Log.d("TAG", "rows updated: " + rowsAffected);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        db.close();
    }

    private void setDataInEditTexts(long id){
        DBOpenHelper helper = new DBOpenHelper(context);

        db = helper.getWritableDatabase();
        Cursor cursor = db.query(
                DBOpenHelper.TABLE_CONTACTS,
                new String[]{DBOpenHelper.COLUMN_NAME, DBOpenHelper.COLUMN_PHONE},
                DBOpenHelper.COLUMN_ID + "=?",
                new String[]{id + ""},
                null,
                null,
                null);
        cursor.moveToFirst();
        String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME));
        String phone = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_PHONE));
        nameEditText.setText(name);
        phoneEditText.setText(phone);

    }

    /*
    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG", "onStop");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG", "onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("TAG", "ondestroyView");
    }
*/

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }
}
