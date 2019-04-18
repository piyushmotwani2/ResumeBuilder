package com.example.resumebuilder;

import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Skills extends AppCompatActivity {

    private TextInputLayout textInputSkills;
    private TextInputLayout textInputProficiency;
    private TextInputLayout textInputUpdateSkills;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        textInputSkills = findViewById(R.id.text_input_skill);
        textInputProficiency = findViewById(R.id.text_input_proficiency);
        textInputUpdateSkills = findViewById(R.id.text_input_update_skill);
        mydb = new DatabaseHelper(this);
    }

    private boolean validateSkill() {
        String emailInput = textInputSkills.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputSkills.setError("Field can't be empty");
            return false;
        } else {
            textInputSkills.setError(null);
            return true;
        }
    }

    private boolean validateProficiency() {
        String emailInput = textInputProficiency.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputProficiency.setError("Field can't be empty");
            return false;
        } else {
            textInputProficiency.setError(null);
            return true;
        }
    }



    public void confirmInput(View v) {
        if (!validateSkill() | !validateProficiency()) {
            return;
        }
        boolean isInserted = mydb.insertData3(textInputSkills.getEditText().getText().toString(),textInputProficiency.getEditText().getText().toString());
        if(isInserted==true)
            Toast.makeText(Skills.this,"Data Inserted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Skills.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
    }

    public void viewAll(View v){
        Cursor res = mydb.getAllData();
        if (res.getCount()==0){
            showMessage("Error","Nothing Found");
            return;
        }



        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Name: " + res.getString(0) + "\n");
            buffer.append("Email: " + res.getString(1) + "\n");
            buffer.append("Phone No.: " + res.getString(2) + "\n");
            buffer.append("Address: " + res.getString(3) + "\n");
        }

        showMessage("Data",buffer.toString());
    }
    public void showMessage(String title,String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
