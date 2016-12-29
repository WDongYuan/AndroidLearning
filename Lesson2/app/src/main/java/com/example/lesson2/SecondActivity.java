package com.example.lesson2;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by weidong on 23/12/2016.
 */

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second );
        Log.e("SecondActivity","taskID: "+getTaskId());

        Button btn = (Button) findViewById(R.id.go_to_sec_again);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent itn = new Intent(SecondActivity.this, SecondActivity.class);
                startActivity(itn);
            }
        });
    }
}
