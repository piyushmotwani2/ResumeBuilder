package com.example.resumebuilder;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Jobs extends AppCompatActivity {

    private TextInputLayout textInputJob;
    private TextInputLayout textInputDuration;
    private TextInputLayout textInputCompany;
    private TextInputLayout textInputUpdateJob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        textInputJob = findViewById(R.id.text_input_job);
        textInputDuration = findViewById(R.id.text_input_duration);
        textInputCompany = findViewById(R.id.text_input_company);
        textInputUpdateJob = findViewById(R.id.text_input_update_job);
    }
}
