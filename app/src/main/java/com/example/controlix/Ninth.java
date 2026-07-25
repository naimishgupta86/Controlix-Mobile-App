package com.example.controlix;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ninth extends AppCompatActivity {
    TextView t8;
    Button b1,b2,b3,b4,b5,b6,b7,b8;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ninth);
        t8=(TextView) findViewById(R.id.textView8);
        b1=(Button) findViewById(R.id.button18);
        b2=(Button)findViewById(R.id.button27) ;

        b3=(Button) findViewById(R.id.button20);
        b4=(Button) findViewById(R.id.button21);
        b5=(Button) findViewById(R.id.button22);
        b6=(Button) findViewById(R.id.button23);
        b7=(Button) findViewById(R.id.button30);
        b8=(Button) findViewById(R.id.button48);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Ninth.this, Wifi.class);
                startActivity(i);
                finish();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(Ninth.this, Twelth.class);
                startActivity(k);
                finish();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m=new Intent(Ninth.this, Sixteen.class);
                startActivity(m);
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent p=new Intent(Ninth.this, Thirteen.class);
                startActivity(p);
                finish();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y=new Intent(Ninth.this, Fourteen.class);
                startActivity(y);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Ninth.this, Bluetooth.class);
                startActivity(i);
                finish();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(Ninth.this, Browser.class);
                startActivity(a);
                finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b=new Intent(Ninth.this, Eight.class);
                startActivity(b);
                finish();
            }
        });




    }
}