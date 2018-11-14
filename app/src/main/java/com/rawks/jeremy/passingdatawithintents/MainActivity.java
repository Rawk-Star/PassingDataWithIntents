package com.rawks.jeremy.passingdatawithintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    // Object representations of activity widgets
    EditText txtString, txtInteger, txtDouble;
    Button btnNextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get object representations of activity widgets
        txtString = findViewById(R.id.txtString);
        txtInteger = findViewById(R.id.txtInteger);
        txtDouble = findViewById(R.id.txtDouble);
        btnNextActivity = findViewById(R.id.btnNextACtivity);
        btnNextActivity.setOnClickListener(bNextActivity);
    }

    Button.OnClickListener bNextActivity = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            // Values to pass to next activity
            String strToPass = null;
            int intToPass = 0;

            // Whether the data entered by user contains errors


            double dblToPass = 0.0;
            boolean inputError = false;

            // Retrieve string value entered by the user
            String strStringInput = txtString.getText().toString();
            if (strStringInput.isEmpty())
            {
                txtString.setError(getString(R.string.txtInputError));
                //txtString.requestFocus();
                inputError = true;
            }
            else
            {
                strToPass = strStringInput;
            }

            // Retrieve integer value entered by the user
            String strIntegerInput = txtInteger.getText().toString();
            if (strIntegerInput.isEmpty())
            {
                // User did not input a value
                txtInteger.setError(getString(R.string.txtInputError));
                inputError = true;
            }
            else
            {
                // User input a value
                intToPass = Integer.parseInt(strIntegerInput);

                // Validate that number is between 0 and 100
                if ((intToPass < 0) || (intToPass > 100))
                {
                    txtInteger.setError(getString(R.string.txtIntegerOutOfRange));
                    inputError = true;
                }
            }

            // Retrieve double value entered by the user
            String strDoubleInput = txtDouble.getText().toString();
            if (strDoubleInput.isEmpty())
            {
                // User did not enter any value
                txtDouble.setError(getString(R.string.txtInputError));
                txtDouble.requestFocus();
                inputError = true;
            }
            else
            {
                // User entered a value, so convert it to a double
                dblToPass = Double.parseDouble(strDoubleInput);
            }

    if (!inputError)
    {
        // Invoke the next activity, passing it all user input values
        Intent nextActivityIntent = new Intent(MainActivity.this,
                                                NextActivity.class);
        nextActivityIntent.putExtra("theString", strToPass);
        nextActivityIntent.putExtra("theInteger", intToPass);
        nextActivityIntent.putExtra("theDouble", dblToPass);
        startActivity(nextActivityIntent);
    }
        }
    };
}