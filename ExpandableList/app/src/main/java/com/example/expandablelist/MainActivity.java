package com.example.expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView elv;
    String[] sarr = {"Baidu","Tencent","Ali"};
    String[][] prod = {
            {"Search","Map"},
            {"QQ","WeChat","QQBrowser"},
            {"Taobao","AliPay"}
    };
    List<Map<String,String>> groupdata;
    List<List<Map<String,String>>> childData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groupdata = new ArrayList<Map<String, String>>();
        childData = new ArrayList<List<Map<String, String>>>();
        elv = (ExpandableListView) findViewById(R.id.expandable_lv);
        for(int i=0; i<sarr.length; i++){
            HashMap<String, String> map = new HashMap<String,String>();
            map.put("name",sarr[i]);
            groupdata.add(map);

            List<Map<String,String>> itemlist = new ArrayList<Map<String,String>>();
            for(int j=0; j<prod[i].length; j++){
                Map<String,String> mapp = new HashMap<String,String>();
                mapp.put("itemname",prod[i][j]);
                itemlist.add(mapp);
            }
            childData.add(itemlist);
        }

        SimpleExpandableListAdapter apt = new SimpleExpandableListAdapter(this,groupdata,R.layout.item_group,
                new String[]{"name"},new int[]{R.id.tv_name},childData,R.layout.item_child,new String[]{"itemname"},new int[]{R.id.tv_child});

        elv.setAdapter(apt);
    }
}
