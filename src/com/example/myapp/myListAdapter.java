package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class myListAdapter extends ArrayAdapter{
    private final Context context;
    private final ArrayList list;

    public myListAdapter(Context context, ArrayList list) {
        super(context, R.layout.listviewitem, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listviewitem, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.ListView_caption);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.ListView_image);
        textView.setText(list.get(position).toString());

        if (position%2 == 1) {
            imageView.setImageResource(R.drawable.ic_launcher);
        } else {
            imageView.setImageResource(R.drawable.success_icon);
        }

        return rowView;
    }
}

class NewListAdapter extends BaseAdapter {
    private ArrayList<DataObject> list;
    private final Context context;

    public NewListAdapter(Context context, ArrayList<DataObject> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public DataObject getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        DataObject object = getItem(position);
        View rowView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.listviewitem, parent, false);
        } else {
            rowView = convertView;
        }

        TextView textView = (TextView) rowView.findViewById(R.id.ListView_caption);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.ListView_image);

        textView.setText(object.getCaption());
        imageView.setImageResource(object.getImageResId());

        return rowView;
    }
}

class DataObject {
    private String caption;
    private int imageResId;

    public DataObject(String caption, int imageResId){
        this.caption = caption;
        this.imageResId = imageResId;
    }

    public String getCaption(){
        return caption;
    }

    void setCaption(String caption) {
        this.caption = caption;
    }

    int getImageResId() {
        return imageResId;
    }

    void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}