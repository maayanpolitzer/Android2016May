package com.example.hackeru.sqlitewithimagesaving;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, UpdateListViewListener, AdapterView.OnItemLongClickListener {

    private static final int BACK_FROM_ADD_CONTACT_ACTIVITY_REQUEST_CODE = 1;
    public static final String ID = "id";
    private ContactsAdapter adapter;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        DBOpenHelper helper = new DBOpenHelper(this);

        db = helper.getReadableDatabase();

        adapter = new ContactsAdapter(this, getData());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);


        findViewById(R.id.addContactBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivityForResult(intent, BACK_FROM_ADD_CONTACT_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.close();
    }

    private Cursor getData(){
        //return db.rawQuery("SELECT * FROM " + DBOpenHelper.TABLE_CONTACTS, null); // SQL statement.
        return db.query(DBOpenHelper.TABLE_CONTACTS, null, null, null, null, null, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BACK_FROM_ADD_CONTACT_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                // refresh the listView...
                adapter.changeCursor(getData());
                Log.d("TAG", "changed!");
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        EditContactDialog dialog = new EditContactDialog();
        Bundle bundle = new Bundle();
        bundle.putLong(ID, id);
        dialog.setArguments(bundle);
        dialog.show(getFragmentManager(), null);
    }

    @Override
    public void update() {
        adapter.changeCursor(getData());
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
        //Log.d("TAG", "delete: " + id);
        db.delete(
                DBOpenHelper.TABLE_CONTACTS,
                DBOpenHelper.COLUMN_ID + "=?",
                new String[]{id + ""});
        update();
        return true;
    }
}
