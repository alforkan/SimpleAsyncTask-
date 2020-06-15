package com.fatrain.android.simpleasynctask;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private static final String TEXT_STATE = "currentText";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.textView1);

        // Restore TextView if there is a savedInstanceState
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }


    }

    public void startTask(View view) {
        // Put a message in the text view
        mTextView.setText(R.string.napping);
        //Start the AsyncTask.
        new SimpleAsyncTask(mTextView).execute();
    }


    /**
     * Saves the contents of the TextView to restore on configuration change.
     *
     * @param outState The bundle in which the state of the activity is saved
     *                 when it is spontaneously destroyed.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }

}

