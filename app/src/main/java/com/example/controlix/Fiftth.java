package com.example.controlix;

import android.content.Intent;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.auth.FirebaseAuth;

public class Fiftth extends AppCompatActivity {
    TextView t1;
    EditText e1,e2,e3,e4;
    Button b1,b2,b3;
    FirebaseAuth fa;
    FirebaseDatabase FirebaseDatabase;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fiftth);
        t1=(TextView)findViewById(R.id.textView4);
        e1=(EditText) findViewById(R.id.editTextText5);
        e2=(EditText) findViewById(R.id.editTextText6);
        e3=(EditText) findViewById(R.id.editTextText7);
        e4=(EditText) findViewById(R.id.editTextText9);
        b1=(Button) findViewById(R.id.button7);
        b2=(Button) findViewById(R.id.button10);
        b3=(Button) findViewById(R.id.button11);


        fa=FirebaseAuth.getInstance();
        FirebaseDatabase=FirebaseDatabase.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fa.signOut();
                Intent i=new Intent(Fiftth.this,Eight.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference=FirebaseDatabase.getReference("Users");
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                String s4=e4.getText().toString();
                if(s3.length()!=10)
                {
                    e3.setError("Enter Phone number");
                    return;
                }
                else {
                    Users users = new Users(s1, s2, s3,s4);
                    databaseReference.child(s1).setValue(users);
                    Toast.makeText(Fiftth.this, "Database saved", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Fiftth.this,MainActivity.class);
                startActivity(j);
                finish();
            }
        });



    }
}