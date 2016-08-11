package com.example.hackeru.fragmentsadvanced;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hackeru on 11/08/2016.
 */
public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Monster monster = (Monster) getArguments().getSerializable(MainActivity.MONSTER);

        TextView nameTextView = (TextView) view.findViewById(R.id.fragment_detail_name_text_view);
        ImageView iconImageView = (ImageView) view.findViewById(R.id.fragment_detail_icon_image_view);
        /*
        nameTextView.setText(getArguments().getString(MainActivity.NAME));
        iconImageView.setImageResource(getArguments().getInt(MainActivity.ICON));
        */
        nameTextView.setText(monster.getName());
        iconImageView.setImageResource(monster.getIcon());
        return view;
    }
}
