package com.rawks.jeremy.passingdatawithintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity
{
    // Object representations of activity widgets
    TextView txtString, txtInteger, txtDouble;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        // Get object representations of activity widgets
        txtString = findViewById(R.id.txtString);
        txtInteger = findViewById(R.id.txtInteger);
        txtDouble = findViewById(R.id.txtDouble);

        // Get the information passed within the Intent
        Intent intentFromMainActivity = getIntent();
        String strUserInput = intentFromMainActivity.getStringExtra("theString");
        int intUserInput = intentFromMainActivity.getIntExtra("theInteger", 0);
        Double dblUserInput = intentFromMainActivity.getDoubleExtra("theDouble", 0);

        // Display passed information
        txtString.setText(strUserInput);
        txtInteger.setText(Integer.toString(intUserInput));
        txtDouble.setText(dblUserInput.toString());
    }
}
