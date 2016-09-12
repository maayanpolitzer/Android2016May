package com.example.hackeru.whatsapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends BaseAuthenticatedActivity implements View.OnClickListener, OnUsersArrived, AdapterView.OnItemClickListener {

    //private Spinner usersSpinner;
    //private Button startChatBtn;
    private ListView listView;
    private String[] users;
    private TextView emptyList;
    private ArrayAdapter<String> adapter;

    @Override
    public void messageArrived(int from, String message) {
        //Log.d("TAG", "MainActivity :)/...");
        sendNotification(from, message);
    }

    @Override
    protected void onLoggedIn(Bundle savedInstanceState) {  // like onCreate but for logged in users
        setContentView(R.layout.activity_main);

        //usersSpinner = (Spinner) findViewById(R.id.users);
        //startChatBtn = (Button) findViewById(R.id.activity_main_start_chat_btn);

        //startChatBtn.setOnClickListener(this);
        new GetUsersThread(this).start();
        users = new String[0];


        listView = (ListView) findViewById(R.id.listView);
        emptyList = (TextView) findViewById(R.id.emptyListTextView);

        listView.setEmptyView(emptyList);



    }

    public void displayUsers(String[] users){
        this.users = users;
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        //usersSpinner.setAdapter(adapter);


        if (users.length > 1) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, users);
        }

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /*
        Intent intent = new Intent(this, ChatActivity.class);
        int position = usersSpinner.getSelectedItemPosition();
        intent.putExtra(CHATTER, users[position]);
        intent.putExtra(CHATTER_ID, position);
        startActivity(intent);
        */
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (settings.getInt(USER_ID, -1) == position){
            Toast.makeText(this, "Dont talk to yourself... get a life", Toast.LENGTH_SHORT).show();
        }else {
            Intent intent = new Intent(this, ChatActivity.class);
            intent.putExtra(CHATTER, users[position]);
            intent.putExtra(CHATTER_ID, position);
            startActivity(intent);
        }
    }
}

interface OnUsersArrived {
    void displayUsers(String[] users);
}
