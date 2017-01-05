package com.example.listviewbaseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<UserInfo> datalist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.mylistview);
        
        datalist = new ArrayList<UserInfo>();
        for(int i=0; i<50; i++){
            UserInfo ui = new UserInfo("Student #"+i,i%2==0?"Male":"Female",10+i);
            datalist.add(ui);
        }

        UserInfoAdapter adpt = new UserInfoAdapter();
        lv.setAdapter(adpt);
    }
    class UserInfoAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return datalist.size();
        }

        @Override
        public Object getItem(int position) {
            return datalist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_info,null);

            TextView tvname = (TextView) rootview.findViewById(R.id.tv_name);
            tvname.setText(datalist.get(position).name);

            TextView tvsex = (TextView) rootview.findViewById(R.id.tv_sex);
            tvsex.setText(datalist.get(position).sex);

            TextView tvage = (TextView) rootview.findViewById(R.id.tv_age);
            tvage.setText(datalist.get(position).age+"");

            ImageView iv = (ImageView) rootview.findViewById(R.id.tv_sex_img);
            if(datalist.get(position).sex.equals("Male")){
                iv.setBackgroundResource(R.drawable.male);
            }
            else{
                iv.setBackgroundResource(R.drawable.female);
            }

            return rootview;
        }
    }

    class UserInfo{
        public String name;
        public String sex;
        public int age;
        public UserInfo(String n, String s, int a){
            name = n;
            sex = s;
            age = a;
        }
    }
}
