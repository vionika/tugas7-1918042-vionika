package com.example.tugaspertemuan7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Kopi> movieItems;
    public CustomListAdapter(Activity activity, List<Kopi>
            movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView merk = (TextView)
                convertView.findViewById(R.id.text_merk);
        TextView jenis = (TextView)
                convertView.findViewById(R.id.text_jenis);
        TextView harga = (TextView)
                convertView.findViewById(R.id.text_harga);
        Kopi tokokopi = movieItems.get(position);
        merk.setText("Merk : "+ tokokopi.get_merk());
        jenis.setText("Jenis : "+ tokokopi.get_jenis());
        harga.setText("Harga : "+ tokokopi.get_harga());
        return convertView;
    }
}
