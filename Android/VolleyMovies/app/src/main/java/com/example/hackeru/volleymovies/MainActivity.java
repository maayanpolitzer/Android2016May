package com.example.hackeru.volleymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MOVIE_NAME = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.activity_main_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchMovie();
            }
        });
    }

    private void searchMovie(){
        EditText editText = (EditText) findViewById(R.id.activity_main_search_edit_text);
        String search = editText.getText().toString().trim();
        if (validate(search)){
            Intent intent = new Intent(this, ResultsActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(MOVIE_NAME, search);
            intent.putExtras(bundle);
            startActivity(intent);
        }else{
            editText.setError("Write something!!!!!!!");
        }
    }

    private boolean validate(String str){
        if (!str.isEmpty()){
            return true;
        }
        return false;
    }

}
