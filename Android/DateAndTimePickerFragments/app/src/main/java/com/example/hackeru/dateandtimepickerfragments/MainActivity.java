package com.example.hackeru.dateandtimepickerfragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener, AdapterView.OnItemLongClickListener, OnDeleteClickedListener {

    public static final String POSITION = "position";
    private Calendar now;
    private ListView listView;
    private ArrayAdapter<FullDate> adapter;
    private ArrayList<FullDate> list;
    private FullDate myDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDate = new FullDate();

        listView = (ListView) findViewById(R.id.listView);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<FullDate>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(this);

    }


    public void addDate(View view) {
        now = Calendar.getInstance();
        MyDateFragment fragment = new MyDateFragment(this, this, now.get(now.YEAR), now.get(now.MONTH), now.get(now.DAY_OF_MONTH));
        fragment.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        //Toast.makeText(this, dayOfMonth + "/" + (monthOfYear +1) + "/" + year, Toast.LENGTH_SHORT).show();
        myDate.setDate(dayOfMonth + "/" + (monthOfYear +1) + "/" + year);
        MyTimeFragment fragment = new MyTimeFragment(this, this, now.get(now.HOUR_OF_DAY), now.get(now.MINUTE), true);
        fragment.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        //Toast.makeText(this, hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
        myDate.setTime(hourOfDay + ":" + minute);
        list.add(myDate);
        myDate = new FullDate();
        adapter.notifyDataSetChanged(); // updates the list with the new data
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        OptionsFragment fragment = new OptionsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(POSITION, position);
        fragment.setArguments(bundle);
        fragment.show(getFragmentManager(), null);
        return true;
    }

    public void deleteRow(int position){
        list.remove(position);
        adapter.notifyDataSetChanged();
    }
}
