package com.example.controlix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Third extends AppCompatActivity {
    TextView t1;
    EditText e1,e2;
    ProgressBar p1;
    Button b1,b2;
    FirebaseAuth fa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        t1=(TextView) findViewById(R.id.textView2);
        e1=(EditText) findViewById(R.id.editTextText);
        e2=(EditText) findViewById(R.id.editTextText2);
        b1=(Button) findViewById(R.id.button5);
        b2=(Button) findViewById(R.id.button6);
        p1=(ProgressBar)findViewById(R.id.progressBar);
        fa=FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString();
                if(s1.isEmpty())
                {
                    e1.setError("Fill Email");
                    return;
                }
                else {
                    if(s2.isEmpty())
                    {
                        e2.setError("Fill password");
                        return;
                    }
                    else {
                        p1.setVisibility(View.VISIBLE);
                        fa.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(Third.this, "Database Updated", Toast.LENGTH_SHORT).show();
                                    Intent k=new Intent(Third.this, MainActivity.class);
                                    startActivity(k);
                                    finish();
                                }
                                else {
                                    Toast.makeText(Third.this, "Database not updated", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Third.this,Second.class);
                startActivity(j);
                finish();
            }
        });


    }
}