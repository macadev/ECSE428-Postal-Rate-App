package com.example.danielmacario.amp_ecse_428;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    EditText lengthField, widthField, weightField;
    TextView postalRateView;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = (Button) findViewById(R.id.submitButton);
        weightField = (EditText) findViewById(R.id.weight);
        lengthField = (EditText) findViewById(R.id.length);
        widthField = (EditText) findViewById(R.id.width);
        postalRateView = (TextView) findViewById(R.id.output);

        submitButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (weightField.getText().toString().length() == 0) {
                            postalRateView.setText("Invalid Input");
                            return;
                        }
                        if (lengthField.getText().toString().length() == 0) {
                            postalRateView.setText("Invalid Input");
                            return;
                        }
                        if (widthField.getText().toString().length() == 0) {
                            postalRateView.setText("Invalid Input");
                            return;
                        }
                        double length, width, weight;
                        try {
                            length = Double.parseDouble(lengthField.getText().toString());
                            width = Double.parseDouble(widthField.getText().toString());
                            weight = Double.parseDouble(weightField.getText().toString());
                        } catch (NumberFormatException e) {
                            postalRateView.setText("Only numerical input is allowed");
                            return;
                        }

                        try {
                            Envelope envelope = new Envelope(length, width, weight);
                            double rate = PostalCalculator.calculateRate(envelope);
                            postalRateView.setText("Postal Rate: " + rate);
                        } catch (MyInputException e) {
                            postalRateView.setText("Invalid Input");
                            Log.e("ERROR", e.getMessage());
                        }
                    }
                }
        );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
