package com.example.controlix;

import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Thirteen extends AppCompatActivity {
    TextView tv;
    Button b1,b2,b3;
    CameraManager cm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thirteen);

        b1=(Button)findViewById(R.id.button34);
        b2=(Button)findViewById(R.id.button35);
        b3=(Button)findViewById(R.id.button36);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1 = cm.getCameraIdList()[0];
                    cm.setTorchMode(s1, true);

                } catch (CameraAccessException e) {
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String s1 = cm.getCameraIdList()[0];
                    cm.setTorchMode(s1, false);

                }
                catch (CameraAccessException e) {
                }


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Thirteen.this,Ninth.class);
                startActivity(i);
                finish();
            }
        });


    }
}