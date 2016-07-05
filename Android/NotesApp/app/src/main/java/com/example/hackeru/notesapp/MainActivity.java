package com.example.hackeru.notesapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private static final int ADD_NOTE_REQUEST_CODE = 1;
    private static final int EDIT_NOTE_REQUEST_CODE = 2;
    public static final String ACTION = "action";
    public static final String POSITION = "position";
    private FloatingActionButton addBtn;

    private ArrayList<String> noteList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addSampleNotes();

        ListView listView = (ListView) findViewById(R.id.activity_main_list_view);
        addBtn = (FloatingActionButton) findViewById(R.id.activity_main_add_note_button);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, noteList);
        listView.setAdapter(adapter);

        addBtn.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);

    }

    private void addSampleNotes(){
        noteList = new ArrayList<>();
        noteList.add("note1");
        noteList.add("note2");
        noteList.add("note3");
    }

    @Override
    public void onClick(View v) {
        if (v == addBtn){
            goToNoteActivity(ADD_NOTE_REQUEST_CODE, null, -1);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        goToNoteActivity(EDIT_NOTE_REQUEST_CODE, noteList.get(position), position);
    }

    private void goToNoteActivity(int requestCode, String note, int position){
        Intent intent = new Intent(this, NoteEditorActivity.class);
        intent.putExtra(ACTION, requestCode);
        intent.putExtra(NoteEditorActivity.NOTE, note);
        intent.putExtra(POSITION, position);
        startActivityForResult(intent, requestCode);
    }

    // this method will be called when coming back to this activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ADD_NOTE_REQUEST_CODE){  // from where!!!
            if (resultCode == RESULT_OK){   // how
                String note = data.getStringExtra(NoteEditorActivity.NOTE);// note is string so save it as String.
                if (note != null){
                    noteList.add(note);
                    adapter.notifyDataSetChanged();
                }
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Clicked the back button", Toast.LENGTH_SHORT).show();
            }
        }else if (requestCode == EDIT_NOTE_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String note = data.getStringExtra(NoteEditorActivity.NOTE);// note is string so save it as String.
                if (note != null){
                    int position = data.getIntExtra(POSITION, -1);  // -1 if POSITION not exists
                    if (position != -1){
                        noteList.set(position, note);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        /*
        new AlertDialog.Builder(this)
                .setTitle("Out title")
                .setMessage("Out message")
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
                */
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Our Title");
        builder.setMessage("Message");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                noteList.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("cancel", null);
        builder.show();
        return true;
    }
}














