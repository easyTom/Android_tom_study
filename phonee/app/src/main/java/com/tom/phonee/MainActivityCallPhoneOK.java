/*
package com.tom.phonee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityCallPhoneOK extends AppCompatActivity {
//this.findViewById(R.id.b); 重复了
    private EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et =  this.findViewById(R.id.b);
        et.setOnClickListener(new  BCL());
    }

    private final class BCL implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String mobile = et.getText().toString();
            Intent i = new Intent();
            i.setAction("android.intent.action.CALL");
            i.setData(Uri.parse("tel:"+mobile));
            startActivity(i);
        }
    }
}
*/
