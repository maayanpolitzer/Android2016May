package com.example.hackeru.fragmentsadvanced;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Hackeru on 11/08/2016.
 */
public class MonsterAdapter extends ArrayAdapter<Monster> {

    private Context context;
    private Monster[] monsters;

    public MonsterAdapter(Context context, Monster[] monsters){
        super(context, R.layout.list_item, monsters);
        this.context = context;
        this.monsters = monsters;
    }

    private class ViewHolder {
        TextView nameTextView;
        ImageView iconImageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.list_item_text_view);
            viewHolder.iconImageView = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nameTextView.setText(monsters[position].getName());
        viewHolder.iconImageView.setImageResource(monsters[position].getIcon());
        return convertView;
    }
}
