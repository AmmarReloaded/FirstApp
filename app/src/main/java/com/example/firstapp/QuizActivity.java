package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    Button mTrueButton;
    Button mFalseButton;
    Button mNextButton;
    TextView mQuestionTextView;
    Question[] mQuestionBank = new Question[] {
            new Question( R.string.question_Australia,true),
            new Question( R.string.question_oceans,true),
            new Question( R.string.question_africa,true),
            new Question( R.string.question_americas,true),
            new Question( R.string.question_asia,true),
            new Question( R.string.question_mideast,true),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton = (Button)  findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.question_textView);
        mNextButton = (Button) findViewById(R.id.next_button);

        mTrueButton.setOnClickListener(v -> {
            checkAnswer(true);
        });

        mFalseButton.setOnClickListener(v -> {
            checkAnswer(false);
        });

        mQuestionTextView.setOnClickListener(v -> {
            mCurrentIndex = (mCurrentIndex + 1 ) % mQuestionBank.length;
            updateQuestion();
        });
    }

    public void checkAnswer( boolean userPressedTrue ) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResourceID;

        if (answerIsTrue == userPressedTrue) {
            messageResourceID = R.string.correct_Toast;
        }
        else {
            messageResourceID = R.string.incorrect_Toast;
        }

        Toast.makeText( this, messageResourceID , Toast.LENGTH_SHORT).show();
    }

    public void updateQuestion() {

        int cQuestion = mQuestionBank[mCurrentIndex].getTextResID();
        mQuestionTextView.setText(cQuestion);
    }
}

