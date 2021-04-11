package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView snack_image=(ImageView) findViewById(R.id.snack_image);
        snack_image.setImageResource(R.drawable.snackbite);

    }
    public void enter(View v)
    {
        Intent gotoSecond = new Intent();
        gotoSecond.setClass(this,MainActivity2.class);
        startActivity(gotoSecond);
    }
}