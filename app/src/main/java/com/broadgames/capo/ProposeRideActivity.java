package com.broadgames.capo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class ProposeRideActivity extends AppCompatActivity {

    private RadioButton mYesReturnRadioButton;
    private RadioButton mNoReturnRadioButton;
    private boolean isReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propose_ride);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Propose Ride");
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "This will show a Map soon!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mYesReturnRadioButton = (RadioButton) findViewById(R.id.round_trip_yes);
        mNoReturnRadioButton = (RadioButton) findViewById(R.id.round_trip_no);

        isReturn = false;

        mYesReturnRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isReturn = true;
                processReturnRadioButtonToggle();
            }
        });

        mNoReturnRadioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isReturn = false;
                processReturnRadioButtonToggle();
            }
        });

    }

    private void processReturnRadioButtonToggle(){
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.return_date_layout);
        if(isReturn){
            if(mNoReturnRadioButton.isChecked()) {
                mNoReturnRadioButton.setChecked(false);
            }
            linearLayout.setVisibility(View.VISIBLE);
        }else{
            if(mYesReturnRadioButton.isChecked()) {
                mYesReturnRadioButton.setChecked(false);
            }
            linearLayout.setVisibility(View.INVISIBLE);
        }
    }

}
