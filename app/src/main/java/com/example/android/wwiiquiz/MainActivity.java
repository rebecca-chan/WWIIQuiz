package com.example.android.wwiiquiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.wwiiquiz.R;

import java.text.NumberFormat;


/**
 * This app is a quiz of some WWII knowledge.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the RESULTS button is clicked.
     */
    public void submitAnswers(View view) {

        int correctAnswers = 0;

        //Question 1 conditions
        RadioButton question1answer = (RadioButton) findViewById(R.id.question1_answer);
        boolean question1correct = question1answer.isChecked();
        Log.v("MainActivity", "Answer :" + question1answer);

        if (question1correct) {
            correctAnswers = correctAnswers + 1;
        }
        //Question 2 conditions
        CheckBox question2germany = (CheckBox) findViewById(R.id.question2_germany);
        boolean question2germanychecked = question2germany.isChecked();
        Log.v("MainActivity", "Answer: " + question2germany);

        CheckBox question2japan = (CheckBox) findViewById(R.id.question2_japan);
        boolean question2japanchecked = question2japan.isChecked();
        Log.v("MainActivity", "Answer: " + question2japan);

        CheckBox question2italy = (CheckBox) findViewById(R.id.question2_italy);
        boolean question2italychecked = question2italy.isChecked();
        Log.v("MainActivity", "Answer: " + question2italy);

        CheckBox question2france = (CheckBox) findViewById(R.id.question2_france);
        boolean question2francechecked = question2france.isChecked();
        Log.v("MainActivity", "Answer: " + question2france);

        if (question2germanychecked && question2japanchecked && question2italychecked && !question2francechecked) {
            correctAnswers = correctAnswers + 1;
        }
        //Question 3 conditions
        RadioButton question3answer = (RadioButton) findViewById(R.id.question3_answer);
        boolean question3correct = question3answer.isChecked();
        Log.v("MainActivity", "Answer :" + question3answer);

        if (question3correct) {
            correctAnswers = correctAnswers + 1;
        }
        //Question 4 conditions
        CheckBox question4britain = (CheckBox) findViewById(R.id.question4_britain);
        boolean question4britainchecked = question4britain.isChecked();
        Log.v("MainActivity", "Answer: " + question4britain);

        CheckBox question4france = (CheckBox) findViewById(R.id.question4_france);
        boolean question4francechecked = question4france.isChecked();
        Log.v("MainActivity", "Answer: " + question4france);

        CheckBox question4russia = (CheckBox) findViewById(R.id.question4_russia);
        boolean question4russiachecked = question4russia.isChecked();
        Log.v("MainActivity", "Answer: " + question4russia);

        CheckBox question4spain = (CheckBox) findViewById(R.id.question4_spain);
        boolean question4spainchecked = question4spain.isChecked();
        Log.v("MainActivity", "Answer: " + question4spain);

        if (question4britainchecked && question4francechecked && !question4russiachecked && !question4spainchecked) {
            correctAnswers = correctAnswers + 1;
        }

        //Bonus question condition
        EditText answerfield = (EditText) findViewById(R.id.bonus_answer);
        String answer5 = answerfield.getText().toString();
        answer5 = answer5.trim();
        Log.v("MainActivity", "Answer: " + answerfield);

        if (answer5.equalsIgnoreCase("Enigma")) {
            correctAnswers = correctAnswers + 1;
        }

        if (correctAnswers == 5) {
            CharSequence allcorrect = "Congrats! You got all the questions AND the Bonus!";
            int duration = Toast.LENGTH_SHORT;
            Toast goodjob = Toast.makeText(getApplicationContext(), allcorrect, duration);
            goodjob.show();
        } else if (correctAnswers < 5) {
            CharSequence other = "You got " + correctAnswers + " answers correct";
            int duration = Toast.LENGTH_SHORT;
            Toast results = Toast.makeText(getApplicationContext(), other, duration);
            results.show();
        }


    }


}


