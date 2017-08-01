package com.cihangul.retrofit;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Cihan on 26.06.2017.
 */

public class ListAdapter extends BaseAdapter {
    List<Kullanici> kullaniciList;
    LayoutInflater layoutInflater;
    Activity activity;

    public ListAdapter(List<Kullanici> kullaniciList, Activity activity) {
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.kullaniciList = kullaniciList;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return kullaniciList.size();
    }

    @Override
    public Object getItem(int i) {
        return kullaniciList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        View view =layoutInflater.inflate(R.layout.item_view,parent,false);

        TextView isim =(TextView)view.findViewById(R.id.tv_isim);
        ImageView resim =(ImageView)view.findViewById(R.id.imageView);

        isim.setText(kullaniciList.get(position).getIsim());
        Picasso.with(activity).load(kullaniciList.get(position).getResim()).into(resim);

        return view;
    }
}
