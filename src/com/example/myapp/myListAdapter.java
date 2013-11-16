package com.example.myapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

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
    ImageLoader imageLoader;

    public void setData(final ArrayList<DataObject> data)
    {
        list = data;
        notifyDataSetChanged();
    }

    public NewListAdapter(Context context, ArrayList<DataObject> list) {
        this.context = context;
        imageLoader = new ImageLoader(Volley.newRequestQueue(context), new BitmapLruCache());
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
        final DataObject object = getItem(position);
        View rowView;
        ViewHolder holder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.listviewitem, parent, false);

            holder.captionView = (TextView) rowView.findViewById(R.id.ListView_caption);
            holder.imageView = (ImageView) rowView.findViewById(R.id.ListView_image);

            rowView.setTag(holder);
        } else {
            rowView = convertView;

            holder = (ViewHolder) rowView.getTag();
        }

        holder.captionView.setText(object.getCaption());
        /*if(object.bitmapMode){
            holder.imageView.setImageBitmap(object.getBitmap());
        }else{
            holder.imageView.setImageResource(object.getImageResId());
        }*/

        final ViewHolder finalHolder = holder;
        imageLoader.get(object.getImageURL(), new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer imageContainer, boolean b) {
                // TODO: image was loaded
                finalHolder.imageView.setImageBitmap(imageContainer.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                // TODO: Please inform about failed
                object.setImageResId(R.drawable.ic_launcher);
                finalHolder.imageView.setImageResource(object.getImageResId());
            }
        });

        return rowView;
    }
}

class ViewHolder{
    TextView captionView;
    ImageView imageView;
}

class DataObject {
    private String caption;
    private int imageResId;
    private String URL;
    boolean bitmapMode;
    private String imageURL;

    public DataObject(String caption, int imageResId, String URL){
        this.caption = caption;
        this.imageResId = imageResId;
        this.URL = URL;
        bitmapMode = false;
    }

    public DataObject(String caption, String imageURL, String URL){
        this.caption = caption;
        this.imageURL = imageURL;
        this.URL = URL;
        bitmapMode = true;
    }

    public String getCaption(){
        return caption;
    }

    int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imgID) {
        this.imageResId = imgID;
    }

    String getURL() {
        return URL;
    }

    String getImageURL() {
        return imageURL;
    }
}