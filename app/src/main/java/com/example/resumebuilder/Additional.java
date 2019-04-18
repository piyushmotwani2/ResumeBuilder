package com.example.resumebuilder;

import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

    private boolean validateProject() {
        String emailInput = textInputProject.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputProject.setError("Field can't be empty");
            return false;
        } else {
            textInputProject.setError(null);
            return true;
        }
    }

    private boolean validateDescription() {
        String emailInput = textInputDescription.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputDescription.setError("Field can't be empty");
            return false;
        } else {
            textInputDescription.setError(null);
            return true;
        }
    }

    private boolean validateTraining() {
        String nameInput = textInputTraining.getEditText().getText().toString().trim();

        if (nameInput.isEmpty()) {
            textInputTraining.setError("Field can't be empty");
            return false;
        }
        else {
            textInputTraining.setError(null);
            return true;
        }
    }

    private boolean validateAchievement() {
        String addressInput = textInputAchievement.getEditText().getText().toString().trim();

        if (addressInput.isEmpty()) {
            textInputAchievement.setError("Field can't be empty");
            return false;
        } else {
            textInputAchievement.setError(null);
            return true;
        }
    }

    private boolean validateHeadline() {
        String addressInput = textInputHeadline.getEditText().getText().toString().trim();

        if (addressInput.isEmpty()) {
            textInputHeadline.setError("Field can't be empty");
            return false;
        } else {
            textInputHeadline.setError(null);
            return true;
        }
    }

    /*public void confirmInput(View v) {
        if(validateProject()|validateDescription())
        if (!validateProject() | !validateDescription() | !validateTraining()| !validateAchievement()| !validateHeadline()) {
            return;
        }
        boolean isInserted = mydb.insertData(textInputName.getEditText().getText().toString(),textInputEmail.getEditText().getText().toString(),textInputPhone.getEditText().getText().toString(),textInputAddress.getEditText().getText().toString());
        if(isInserted==true)
            Toast.makeText(Additional.this,"Data Inserted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Additional.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
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
    }*/
}
