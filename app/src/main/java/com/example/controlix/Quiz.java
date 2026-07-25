package com.example.controlix;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Quiz extends AppCompatActivity {
    TextView question;
    RadioGroup radioGroup;
    RadioButton r1, r2, r3, r4;
    Button b1, next;

    String[] questions = {
            "Capital of India?",
            "2 + 2 = ?",
            "Android language?"
    };

    String[][] options = {
            {"Delhi", "Mumbai", "Lucknow", "Kanpur"},
            {"3", "4", "5", "6"},
            {"Java", "HTML", "PHP", "CSS"}
    };

    String[] answers = {"Delhi", "4", "Java"};

    int index = 0;
    int score = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz);
        question = findViewById(R.id.textView10);
        radioGroup = findViewById(R.id.radiogroup);
        r1 = findViewById(R.id.radioButton);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        r4 = findViewById(R.id.radioButton4);
        next = findViewById(R.id.button38);
        b1=findViewById(R.id.button47);

        loadQuestion();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = radioGroup.getCheckedRadioButtonId();

                if (id == -1) {
                    Toast.makeText(Quiz.this, "Select an answer", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton rb = findViewById(id);

                if (rb.getText().toString().equals(answers[index])) {
                    score++;
                }

                index++;

                if (index < questions.length) {
                    loadQuestion();
                } else {
                    Toast.makeText(Quiz.this,
                            "Quiz Finished\nScore = " + score + "/" + questions.length,
                            Toast.LENGTH_LONG).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Quiz.this,Eight.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void loadQuestion() {
        question.setText(questions[index]);

        r1.setText(options[index][0]);
        r2.setText(options[index][1]);
        r3.setText(options[index][2]);
        r4.setText(options[index][3]);

        radioGroup.clearCheck();

    }
}