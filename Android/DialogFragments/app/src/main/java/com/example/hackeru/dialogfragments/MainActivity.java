package com.example.hackeru.dialogfragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private String name = "Maayan";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        RatingFragment fragment = new RatingFragment();
        //fragment.getData(name);
        Bundle bundle = new Bundle();   // android wants you to use that!
        bundle.putString("NAME", name);
        bundle.putInt("AGE", 30);
        fragment.setArguments(bundle);
        fragment.show(getFragmentManager(), "");
    }
}
