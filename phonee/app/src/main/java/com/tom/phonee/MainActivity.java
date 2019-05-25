package com.tom.phonee;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText num;
    private EditText dx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num =  this.findViewById(R.id.m);
        dx =  this.findViewById(R.id.dx);
        Button b =  this.findViewById(R.id.b);
        b.setOnClickListener(new  BCL());
    }
    private final class BCL implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS)
                    == PackageManager.PERMISSION_GRANTED) {
                onSMS();
            }else{
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{android.Manifest.permission.SEND_SMS},10000);
            }
        }
    }

    private void onSMS(){
        String number = num.getText().toString();
        String duanxin = dx.getText().toString();
        SmsManager manager = SmsManager.getDefault();
        ArrayList<String> texts = manager.divideMessage(duanxin);
        for (String text : texts) {
            manager.sendTextMessage(number, null, text, null, null);
        }
        //需要获取上下文 而在内部所以不能用this
        Toast.makeText(MainActivity.this, R.string.success, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        if(requestCode==10000){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                onSMS();
            }else{
                Toast.makeText(MainActivity.this, "权限被拒绝了哦~ 亲", Toast.LENGTH_SHORT).show();
            }
        }
        super.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
}
