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

public class Sixth extends AppCompatActivity {
    TextView t1;
    EditText e1,e2;
    Button b1,b2;
    ProgressBar p1;
    FirebaseAuth fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sixth);
        t1=(TextView) findViewById(R.id.textView5);
        e1=(EditText) findViewById(R.id.editTextText8);
        e2=(EditText) findViewById(R.id.editTextText10);
        b1=(Button) findViewById(R.id.button12);
        b2=(Button) findViewById(R.id.button13);
        p1=(ProgressBar) findViewById(R.id.progressBar2);
        fa=FirebaseAuth.getInstance();
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Sixth.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
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
                    p1.setVisibility(View.VISIBLE);
                    fa.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                p1.setVisibility(View.INVISIBLE);
                                Toast.makeText(Sixth.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                Intent k=new Intent(Sixth.this, Fiftth.class);
                                startActivity(k);
                                finish();
                            }
                            else
                            {
                                Toast.makeText(Sixth.this, "mismatch", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }
}