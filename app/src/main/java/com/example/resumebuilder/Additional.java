package com.example.resumebuilder;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Additional extends AppCompatActivity {
    private TextInputLayout textInputProject;
    private TextInputLayout textInputDescription;
    private TextInputLayout textInputTraining;
    private TextInputLayout textInputAchievement;
    private TextInputLayout textInputHeadline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additional);

        textInputProject = findViewById(R.id.text_input_project);
        textInputDescription = findViewById(R.id.text_input_description);
        textInputTraining = findViewById(R.id.text_input_training);
        textInputAchievement = findViewById(R.id.text_input_achievement);
        textInputHeadline = findViewById(R.id.text_input_headline);
    }
}
