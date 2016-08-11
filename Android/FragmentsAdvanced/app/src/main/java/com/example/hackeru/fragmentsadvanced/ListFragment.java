package com.example.hackeru.fragmentsadvanced;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Hackeru on 11/08/2016.
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {

    private Monster[] monsters = {
            new Monster("one", R.drawable.one),
            new Monster("two", R.drawable.two),
            new Monster("three", R.drawable.three),
            new Monster("four", R.drawable.four),
            new Monster("five", R.drawable.five),
            new Monster("one", R.drawable.one),
            new Monster("two", R.drawable.two),
            new Monster("three", R.drawable.three),
            new Monster("four", R.drawable.four),
            new Monster("five", R.drawable.five),
            new Monster("one", R.drawable.one),
            new Monster("two", R.drawable.two),
            new Monster("three", R.drawable.three),
            new Monster("four", R.drawable.four),
            new Monster("five", R.drawable.five),
            new Monster("six", R.drawable.six)
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listView);
        //ArrayAdapter<Monster> adapter = new ArrayAdapter<Monster>(getActivity(), android.R.layout.simple_list_item_1, monsters);
        MonsterAdapter adapter = new MonsterAdapter(getActivity(), monsters);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Log.d("TAG", "Position: " + position + ", id: " + id);
        Bundle bundle = new Bundle();
        /*
        bundle.putString(MainActivity.NAME, monsters[position].getName());
        bundle.putInt(MainActivity.ICON, monsters[position].getIcon());
        */
        bundle.putSerializable(MainActivity.MONSTER, monsters[position]);
        ((OnMonsterClickListener)getActivity()).changeView(bundle);
    }
}
