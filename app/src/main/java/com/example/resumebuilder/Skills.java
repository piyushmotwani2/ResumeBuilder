package com.example.resumebuilder;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Skills extends AppCompatActivity {

    private TextInputLayout textInputSkills;
    private TextInputLayout textInputProficiency;
    private TextInputLayout textInputUpdateSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        textInputSkills = findViewById(R.id.text_input_skill);
        textInputProficiency = findViewById(R.id.text_input_proficiency);
        textInputUpdateSkills = findViewById(R.id.text_input_update_skill);
    }
}
