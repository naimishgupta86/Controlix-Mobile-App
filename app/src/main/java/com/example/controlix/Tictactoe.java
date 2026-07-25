package com.example.controlix;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Handler;


public class Tictactoe extends AppCompatActivity implements View.OnClickListener {
    Button[] b = new Button[9];
    boolean playerX = true;
    Button b1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tictactoe);
        b1=(Button) findViewById(R.id.button58);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Tictactoe.this,Eight.class);
                startActivity(j);
                finish();
            }
        });
        int[] ids = {
                R.id.b1, R.id.b2, R.id.b3,
                R.id.b4, R.id.b5, R.id.b6,
                R.id.b7, R.id.b8, R.id.b9
        };

        for (int i = 0; i < 9; i++) {
            b[i] = findViewById(ids[i]);
            b[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;

        if (!btn.getText().toString().equals("")) {
            return;
        }

        if (playerX) {
            btn.setText("X");
        } else {
            btn.setText("O");
        }

        playerX = !playerX;

        checkWinner();
    }

    private void checkWinner() {

        int[][] win = {
                {0,1,2},
                {3,4,5},
                {6,7,8},
                {0,3,6},
                {1,4,7},
                {2,5,8},
                {0,4,8},
                {2,4,6}
        };

        for (int[] w : win) {

            String s1 = b[w[0]].getText().toString();
            String s2 = b[w[1]].getText().toString();
            String s3 = b[w[2]].getText().toString();

            if (!s1.equals("") && s1.equals(s2) && s2.equals(s3)) {

                Toast.makeText(this, s1 + " Wins!", Toast.LENGTH_SHORT).show();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        resetGame();
                    }
                }, 1500);

                return;
            }
        }

        // Draw Check
        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (b[i].getText().toString().equals("")) {
                draw = false;
                break;
            }
        }

        if (draw) {
            Toast.makeText(this, "Match Draw!", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    resetGame();
                }
            }, 1500);
        }
    }

    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            b[i].setText("");
        }
        playerX = true;


    }
}