package com.example.hackeru.whatsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatActivity extends BaseAuthenticatedActivity implements View.OnClickListener {

    private LinearLayout messagesLayout;
    private EditText messageEditText;
    private ImageView sendMessageImageView;

    @Override
    protected void onLoggedIn(Bundle savedInstanceState) {
        setContentView(R.layout.activity_chat);

        messagesLayout = (LinearLayout) findViewById(R.id.messages_layout);
        messageEditText = (EditText) findViewById(R.id.input_message_edit_text);
        sendMessageImageView = (ImageView) findViewById(R.id.input_message_send_btn);

        sendMessageImageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String message = messageEditText.getText().toString().trim();
        if (!message.isEmpty()){
            displayMessages(message);
        }
    }

    

    private void displayMessages(String message) {
        View view = getLayoutInflater().inflate(R.layout.message_out, null);
        TextView textView = (TextView) view.findViewById(R.id.message_body);
        textView.setText(message);
        messagesLayout.addView(view);
        new SendMessageThread(message).start();
    }
}
