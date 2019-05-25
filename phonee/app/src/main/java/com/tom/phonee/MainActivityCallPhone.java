/*
package com.tom.phonee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityCallPhone extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b =  this.findViewById(R.id.b);
        b.setOnClickListener(new  BCL());
    }

    private final class BCL implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            EditText et = findViewById(R.id.m);
            String mobile = et.getText().toString();
            System.out.println(mobile+"------------------------");
            Intent i = new Intent();
            i.setAction("android.intent.action.CALL");
            i.setData(Uri.parse("tel:"+mobile));
            System.out.println("====="+"------------------------");
            startActivity(i);
        }
    }
}
*/
