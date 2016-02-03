package com.example.simoncao.widgettest;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity {

    Button button1, button2;
    EditText et;
    String day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1=(Button)findViewById(R.id.upload);
        button2=(Button)findViewById(R.id.download);
        et=(EditText)findViewById(R.id.et);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences share=getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor=share.edit();
                String getname=et.getText().toString();
                editor.putString("Time",getname);
                editor.apply();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences share = getSharedPreferences("data", MODE_PRIVATE);
                day = share.getString("Time", "defaultname");
                Log.d("Tag", "The Birthday is" + day);
            }
        });
    }



}
