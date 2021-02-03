package com.example.game3connect;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //1.red  2.yellow  0.Empty

    int activePlayer=2;

    int[] gameState={0,0,0,0,0,0,0,0,0};

    int[][] winningPositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    boolean gameActive=true;

    public void dropIn(View view){
        ImageView counter=(ImageView) view;

        int tappedCounter=Integer.parseInt(counter.getTag().toString());

        if(gameState[tappedCounter]==0 && gameActive) {

            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-2000);

            if (activePlayer == 2) {
                counter.setImageResource(R.drawable.red);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 2;
            }
            counter.animate().translationYBy(2000).setDuration(300);

            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[2]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[0]] && gameState[winningPosition[2]] != 0) {

                    gameActive=false;

                    String winner;

                    if (gameState[winningPosition[2]]==2) {
                        winner = "Red";
                    } else {
                        winner = "Yellow";
                    }

                    Button playAgainButton=findViewById(R.id.resetButton);

                    TextView winnerTextView=findViewById(R.id.winnerTextView);

                    winnerTextView.setText(winner+" has won!");

                    playAgainButton.setVisibility(View.VISIBLE);

                    winnerTextView.setVisibility(View.VISIBLE);
                }
            }
        }

        if(gameState[tappedCounter]!=0){
            Button playAgainButton=findViewById(R.id.resetButton);

            playAgainButton.setVisibility(View.VISIBLE);
        }
    }

    public void playAgain(View view){
        Button playAgainButton=findViewById(R.id.resetButton);

        TextView winnerTextView=findViewById(R.id.winnerTextView);

        playAgainButton.setVisibility(View.INVISIBLE);

        winnerTextView.setVisibility(View.INVISIBLE);

        ImageView imageView1=findViewById(R.id.imageView1);
        ImageView imageView2=findViewById(R.id.imageView2);
        ImageView imageView3=findViewById(R.id.imageView3);
        ImageView imageView4=findViewById(R.id.imageView4);
        ImageView imageView5=findViewById(R.id.imageView5);
        ImageView imageView6=findViewById(R.id.imageView6);
        ImageView imageView7=findViewById(R.id.imageView7);
        ImageView imageView8=findViewById(R.id.imageView8);
        ImageView imageView9=findViewById(R.id.imageView9);

        imageView1.setImageDrawable(null);
        imageView2.setImageDrawable(null);
        imageView3.setImageDrawable(null);
        imageView4.setImageDrawable(null);
        imageView5.setImageDrawable(null);
        imageView6.setImageDrawable(null);
        imageView7.setImageDrawable(null);
        imageView8.setImageDrawable(null);
        imageView9.setImageDrawable(null);

        activePlayer=1;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=0;
        }
        gameActive=true;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}