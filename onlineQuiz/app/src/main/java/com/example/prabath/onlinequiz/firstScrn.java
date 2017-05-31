package com.example.prabath.onlinequiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class firstScrn extends AppCompatActivity {



    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button quit;

    private String mAnswer;
    public int mScore = 0;
    private int mQuestionNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_scrn);

        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        quit=(Button) findViewById(R.id.quit);

        updateQuestion();

        //Start of Button Listner for Button1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optional
                    Toast.makeText(firstScrn.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(firstScrn.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //End of Button Listner for Button1

        //Start of Button Listner for Button2
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optional
                    Toast.makeText(firstScrn.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(firstScrn.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //End of Button Listner for Button2

        //Start of Button Listner for Button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //My logic for Button goes in here
                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    //This line of code is optional
                    Toast.makeText(firstScrn.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(firstScrn.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }
        });
        //End of Button Listner for Button3
        quit.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
                Bundle bun=new Bundle();
                bun.putString("s",mScoreView.getText().toString());
                Intent openStart=new Intent(firstScrn.this,end.class);
                openStart.putExtras(bun);
                startActivity(openStart);
            }


        });

    }

    private void  updateQuestion(){
        if(mQuestionNumber<=3) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));

            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
        else{
            Bundle bun=new Bundle();
            bun.putString("s",mScoreView.getText().toString());
            Intent openStart=new Intent(firstScrn.this,end.class);
            openStart.putExtras(bun);
            startActivity(openStart);


        }
    }

    private void updateScore(int point){
        mScoreView.setText("" + mScore);
    }

    protected void onPause() {
        super.onPause();
        finish();
    }




}
