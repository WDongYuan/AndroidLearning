package com.example.lesson1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by weidong on 22/12/2016.
 */

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.e("SecondActivity","SecondActivity_onCreate");
        Button closebtn = (Button) findViewById(R.id.close_second_activity);
        closebtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SecondActivity.this.finish();
            }
        });

        Button gobtn = (Button)findViewById(R.id.go_to_first_activity);
        gobtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setClass(SecondActivity.this,MyActivity.class);
                startActivity(intent);
            }
        });
    }


    protected void onStart() {
        super.onStart();
        Log.e("SecondActivity","SecondActivity_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("SecondActivity","SecondActivity_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("SecondActivity","SecondActivity_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("SecondActivity","SecondActivity_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("SecondActivity","SecondActivity_onDestroy");
    }
}
