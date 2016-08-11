package com.example.hackeru.sqlitewithimagesaving;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.io.IOException;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CHANGE_AVATAR_REQUEST_CODE = 1;
    private FrameLayout changeAvatarLayout;
    private Button saveContactBtn;
    private ProgressBar progressBar;
    private File imageFile;
    private String folderName = "SQLiteWithImageSaving";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        File folder = new File(Environment.getExternalStorageDirectory(), folderName);
        if (!folder.isDirectory()){
            folder.mkdir();
        }




        changeAvatarLayout = (FrameLayout) findViewById(R.id.change_avatar_frame_layout);
        saveContactBtn = (Button) findViewById(R.id.save_contact_button);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        changeAvatarLayout.setOnClickListener(this);
        saveContactBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == changeAvatarLayout){
            // change avatar:
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            startActivityForResult(intent, CHANGE_AVATAR_REQUEST_CODE);
            progressBar.setVisibility(View.VISIBLE);
        }else if(v == saveContactBtn){
            // save the contact data to database.
            DBOpenHelper helper = new DBOpenHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            String name = ((EditText) findViewById(R.id.name_edit_text)).getText().toString().trim();
            String phone = ((EditText) findViewById(R.id.phone_edit_text)).getText().toString().trim();
            values.put(DBOpenHelper.COLUMN_NAME, name);
            values.put(DBOpenHelper.COLUMN_PHONE, phone);
            values.put(DBOpenHelper.COLUMN_IMAGE_URI, imageFile.getPath());
            db.insert(DBOpenHelper.TABLE_CONTACTS, null, values);
            db.close();
            setResult(RESULT_OK);
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CHANGE_AVATAR_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                createImageFile();
                Uri imageUri = data.getData();
                Uri squareImageUri = Uri.fromFile(imageFile);
                new Crop(imageUri).asSquare().output(squareImageUri).start(this);
            }
        }else if(requestCode == Crop.REQUEST_CROP){
            ((ImageView) findViewById(R.id.avatar_image_view)).setImageURI(Uri.fromFile(imageFile));
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    private void createImageFile() {
        imageFile = new File(Environment.getExternalStorageDirectory() + "/" + folderName, System.currentTimeMillis() + ".jpg");
        try {
            imageFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
