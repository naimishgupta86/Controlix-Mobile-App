package com.example.controlix;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Fourth extends AppCompatActivity {
    TextView t1;
    EditText e1,e2;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
        e1=(EditText)findViewById(R.id.editTextText3);
        e2=(EditText)findViewById(R.id.editTextText4);
        b1=(Button)findViewById(R.id.button8) ;
        b2=(Button)findViewById(R.id.button9);
        t1=(TextView)findViewById(R.id.textView3) ;



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString();
                if(s1.equals("")||s2.equals(""))
                {
                    Toast.makeText(Fourth.this, "Please fill all", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase database= openOrCreateDatabase("Hospital", MODE_PRIVATE, null);
                    database.execSQL("create table if not exists student(email varchar,password varchar)");
                    String s3="select * from student where email='"+s1+"'";
                    Cursor c1=database.rawQuery(s3,null);
                    if(c1.getCount()>0)
                    {
                        Toast.makeText(Fourth.this, "User Exists", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        database.execSQL("Insert into Student values('"+s1+"','"+s2+"')");

                        Toast.makeText(Fourth.this, "database updated", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(Fourth.this, MainActivity.class);
                        startActivity(j);
                        finish();
                    }




                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(Fourth.this, MainActivity.class);
                startActivity(k);
                finish();

            }
        });
    }
}