package com.example.hackeru.files;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // write to internal storage
        String fileName = "myFile.txt";
        String content = "787874545";
        try {
            FileOutputStream out = openFileOutput(fileName, MODE_PRIVATE);
            FileOutputStream out = openFileOutput(fileName, MODE_APPEND);
            out.write(content.getBytes());
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        // append to file
        File file = new File(getFilesDir(), "myFile.txt");
        if (file.exists()){
            try {
                FileWriter writer = new FileWriter(file, true);
                writer.append(" wow great!!!");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */

        /*
        // get data from file:
        FileInputStream in = null;
        try {

            in = openFileInput("myFile.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String data = "";
            String line;
            while ((line = reader.readLine()) != null){
                data += line;
            }
            Log.d("Maayan", data);
            Toast.makeText(this, "The data is: " + data, Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        */
        // writing to external storage:

        if (isExternalStorageAvailable()){
            // we can write to the external storage.
            // permission!
            // build.gradle targetSDKVersion 22.
            File f = new File(Environment.getExternalStorageDirectory(), "maayanFile.txt");
            if (!f.exists()){
                try {
                    f.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private boolean isExternalStorageAvailable(){
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }

}
