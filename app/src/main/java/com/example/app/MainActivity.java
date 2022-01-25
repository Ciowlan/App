package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    List<HashMap<String,Object>> data;
    HashMap<String,Object>h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        h = new HashMap<>();
        data = new ArrayList<>();
        h.put("icon",R.drawable.dola);
        h.put("name","多拉A夢");
        data.add(h);

        h = new HashMap<>();
        h.put("icon",R.drawable.cat2);
        h.put("name","貓");
        data.add(h);

        h = new HashMap<>();
        h.put("icon",R.drawable.cat);
        h.put("name","pog cat");
        data.add(h);
        Log.v("Jacky",data.toString());
        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new MyAdapter(this));

    }



    class MyAdapter extends BaseAdapter{
        LayoutInflater inflater;

        public MyAdapter (Context c){
            inflater = LayoutInflater.from(c);
        }
        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return data.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder h;
            if(convertView==null){
                convertView = inflater.inflate(R.layout.item,parent,false);
                h = new ViewHolder();
                convertView.setTag(h);
            }else{
                h = (ViewHolder) convertView.getTag();
            }
            h.iv = convertView.findViewById(R.id.img);
            h.tv = convertView.findViewById(R.id.tv);
            h.iv.setImageResource(Integer.valueOf(data.get(position).get("icon").toString()));
            h.tv.setText(data.get(position).get("name").toString());

            return convertView;
        }

        class ViewHolder{
            ImageView iv;
            TextView tv;
        }
    }
}
