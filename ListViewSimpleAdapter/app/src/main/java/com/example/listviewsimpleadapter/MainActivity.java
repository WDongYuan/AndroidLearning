package com.example.listviewsimpleadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.mylistview);

        List<Map<String,String>> ll = new ArrayList<Map<String,String>>();
        for(int i=0; i<50; i++){
            HashMap<String,String> tmpm = new HashMap<String,String>();
            tmpm.put("name","Student #"+i);
            tmpm.put("age",String.valueOf(i));
            tmpm.put("sex",i%2==0?"Male":"Female");
            ll.add(tmpm);
        }

        String[] from = {"name","age","sex"};
        int[] to = {R.id.tv_name,R.id.tv_age,R.id.tv_sex};
        SimpleAdapter sadpt = new SimpleAdapter(this,ll,R.layout.user_info,from,to);
        lv.setAdapter(sadpt);
    }
}
