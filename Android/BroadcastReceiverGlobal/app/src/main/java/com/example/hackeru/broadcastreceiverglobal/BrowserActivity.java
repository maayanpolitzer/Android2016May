package com.example.hackeru.broadcastreceiverglobal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class BrowserActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private ArrayList<Website> websites;
    private Spinner spinner;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        initWebsiteList();

        spinner = (Spinner) findViewById(R.id.spinner);
        webView = (WebView) findViewById(R.id.webView);

        ArrayAdapter<Website> adapter = new ArrayAdapter<Website>(this,
                android.R.layout.simple_spinner_item, websites);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    private void initWebsiteList(){
        websites = new ArrayList<>();
        websites.add(new Website("וואלה", "http://www.walla.co.il"));
        websites.add(new Website("one", "http://www.one.co.il"));
        websites.add(new Website("facebook", "http://www.facebook.com"));
        websites.add(new Website("חינוכית 23", "http://www.23tv.co.il"));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this, websites.get(position).getAddress(), Toast.LENGTH_SHORT).show();
        displayWebsite(websites.get(position).getAddress());
    }

    private void displayWebsite(String address){
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(address);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
