package com.example.hackeru.customlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hackeru on 7/4/2016.
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
        TextView name;
        ImageView image;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {  // recycle the views!!!
            Log.d("Maayan", "new");
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            viewHolder.name = (TextView) convertView.findViewById(R.id.list_item_name_text_view);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.list_item_image_view);
            convertView.setTag(viewHolder);
        }else{
            Log.d("Maayan", "recycled");
            viewHolder =(ViewHolder) convertView.getTag();
        }
        viewHolder.name.setText(monsters[position].getName());
        viewHolder.image.setImageResource(monsters[position].getImage());
        return convertView;
    }
}
