package com.example.lesson3_transmsgact;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent itn = new Intent(MainActivity.this, SecondActivity.class);
                Intent itn = new Intent();
                itn.setAction("Launch_SecondActivity");
//                itn.setData(Uri.parse("test_data: "));
                itn.setDataAndType(Uri.parse("test_data:"),"text/plain");
//                TextView tv = (TextView) findViewById(R.id.main_message);
                EditText tv = (EditText) findViewById(R.id.main_message);
//                itn.putExtra("Integer_to_Transfer",100);
//                itn.putExtra("Message_to_Transfer",tv.getText());

                EditText name = (EditText) findViewById(R.id.user_name);
                EditText age = (EditText) findViewById(R.id.user_age);
                User usr = new User(name.getText().toString(),age.getText().toString());

                Bundle myBundle = new Bundle();
                myBundle.putString("Message_to_Transfer",tv.getText().toString());
                myBundle.putInt("Integer_to_Transfer",100);
                myBundle.putSerializable("User_to_Transfer",usr);
                itn.putExtra("My_Bundle",myBundle);

                startActivity(itn);
            }
        });

        Button callbtn = (Button) findViewById(R.id.Call_Button);
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call = new Intent();
                call.setAction(Intent.ACTION_DIAL);
                startActivity(call);
            }
        });

        Button sendmsg = (Button) findViewById(R.id.Send_Msg_Button);
        sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send = new Intent();
                send.setAction(Intent.ACTION_SENDTO);
                Uri smsuri = Uri.parse("smsto:"+"10086");
                send.setData(smsuri);
                send.putExtra("sms_body","China Mobile is the worst company in the world.");
                startActivity(send);
            }
        });

        Button takepic = (Button) findViewById(R.id.Take_Pic_Button);
        takepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cam = new Intent();
                cam.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(cam);
            }
        });
    }
}
