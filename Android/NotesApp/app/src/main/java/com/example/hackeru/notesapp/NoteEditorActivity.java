package com.example.hackeru.notesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NoteEditorActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String NOTE = "note";
    private EditText noteEditText;
    private Button saveBtn;
    private int action;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        noteEditText = (EditText) findViewById(R.id.activity_note_editor_edit_text);
        saveBtn = (Button) findViewById(R.id.activity_note_editor_save_button);

        saveBtn.setOnClickListener(this);


        action = getIntent().getIntExtra(MainActivity.ACTION, -1);
        if (action == 2) {
            saveBtn.setText("update");
            String note = getIntent().getStringExtra(NOTE);
            noteEditText.setText(note);

            position = getIntent().getIntExtra(MainActivity.POSITION, -1);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (action == 2) {
            getMenuInflater().inflate(R.menu.menu_note_editor, menu);   // convert menu_main (xml) to view
            return true;
        }else{
            return super.onCreateOptionsMenu(menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.menu_note_editor_delete_action:
                // delete...
                return true;
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        String note = noteEditText.getText().toString().trim();
        if (validate(note)) {
            Intent intent = new Intent();
            intent.putExtra(NOTE, note);
            if (action == 2) {
                // update...
                intent.putExtra(MainActivity.POSITION, position);
            }
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private boolean validate(String str) {
        if (str.isEmpty()) {
            noteEditText.setError("Cannot stay empty...");
            return false;
        }
        return true;
    }

}
