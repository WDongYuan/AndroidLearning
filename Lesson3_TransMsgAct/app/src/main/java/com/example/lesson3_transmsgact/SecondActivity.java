package com.example.lesson3_transmsgact;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by weidong on 28/12/2016.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle myBundle = getIntent().getBundleExtra("My_Bundle");
        TextView tv = (TextView) findViewById(R.id.trans_para);
//        String msg = getIntent().getStringExtra("Message_to_Transfer");
        String msg = myBundle.getString("Message_to_Transfer");
        tv.setText(msg);

        TextView tvint = (TextView) findViewById(R.id.int_para);
//        int num = getIntent().getIntExtra("Integer_to_Transfer",0);
        int num = myBundle.getInt("Integer_to_Transfer");
        tvint.setText(tvint.getText()+""+num);

        User usr = (User) myBundle.getSerializable("User_to_Transfer");
        TextView usrinfo = (TextView) findViewById(R.id.user_information);
        usrinfo.setText("Name: "+usr.name+", Age: "+usr.age);
    }
}
