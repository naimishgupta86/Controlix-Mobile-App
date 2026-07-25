package com.example.controlix;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Seventh extends AppCompatActivity {
    TextView t1;
    EditText e1,e2;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seventh);
        t1=(TextView) findViewById(R.id.textView6);
        e1=(EditText) findViewById(R.id.editTextText11);
        e2=(EditText) findViewById(R.id.editTextText12);
        b1=(Button) findViewById(R.id.button14);
        b2=(Button) findViewById(R.id.button15);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString().trim();
                String s2 = e2.getText().toString();
                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(Seventh.this, "Please fill all", Toast.LENGTH_SHORT).show();
                }
                else {
                    SQLiteDatabase database = openOrCreateDatabase("Hospital", MODE_PRIVATE, null);
                    database.execSQL("create table if not exists student(email varchar,password varchar)");
                    String s3 = "select * from student where email='" + s1 + "' and password='" + s2 + "'";
                    Cursor c1 = database.rawQuery(s3, null);
                    if (c1.getCount() > 0) {
                        Toast.makeText(Seventh.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Seventh.this, Fiftth.class);
                        startActivity(i);
                        finish();

                    } else {
                        Toast.makeText(Seventh.this, "Login nahi hua", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Seventh.this,Second.class);
                startActivity(i);
                finish();
            }
        });
    }
}