package com.example.lesson1;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


/**
 * Created by weidong on 22/12/2016.
 */

public class MyActivity extends Activity{
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Log.e("MyActivity","MyActivity_onCreate");

        btn = (Button)findViewById(R.id.btn_start_second);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                //显示启动第一种方法
//                Intent itn = new Intent();
//                itn.setClass(MyActivity.this,SecondActivity.class);
//                startActivity(itn);

                //显示启动第二种方法
//                Intent itn2 = new Intent();
//                itn2.setClassName(MyActivity.this,"com.example.lesson1.SecondActivity");
//                startActivity(itn2);

                //3rd explicit launching method
//                Intent itn3 = new Intent();
//                ComponentName copname = new ComponentName(MyActivity.this,SecondActivity.class);
//                itn3.setComponent(copname);
//                startActivity(itn3);

                //Impilicit launching
                Intent itn4 = new Intent("LaunchSecondActivity");
                startActivity(itn4);

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MyActivity","MyActivity_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MyActivity","MyActivity_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MyActivity","MyActivity_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MyActivity","MyActivity_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MyActivity","MyActivity_onDestroy");
    }
}
