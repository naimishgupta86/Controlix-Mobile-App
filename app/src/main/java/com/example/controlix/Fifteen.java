package com.example.controlix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Fifteen extends AppCompatActivity {

    Button b1;
    VideoView v1;
    MediaController m1;
    Uri ul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteen);

        b1 = findViewById(R.id.button40);
        v1 = findViewById(R.id.videoView);
        m1=new MediaController(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(i,99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==99)
        {
            ul=data.getData();
            v1.setVideoURI(ul);
            v1.setMediaController(m1);
            m1.setAnchorView(v1);
            v1.start();
        }
        else
        {
            ul=data.getData();
            v1.setVideoURI(ul);
            v1.setMediaController(m1);
            m1.setAnchorView(v1);
            v1.pause();
        }
    }
}