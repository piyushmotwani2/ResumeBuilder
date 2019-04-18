package com.example.resumebuilder;

import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Jobs extends AppCompatActivity {

    private TextInputLayout textInputJob;
    private TextInputLayout textInputDuration;
    private TextInputLayout textInputCompany;
    private TextInputLayout textInputUpdateJob;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        textInputJob = findViewById(R.id.text_input_job);
        textInputDuration = findViewById(R.id.text_input_duration);
        textInputCompany = findViewById(R.id.text_input_company);
        textInputUpdateJob = findViewById(R.id.text_input_update_job);
    }

    private boolean validateJob() {
        String emailInput = textInputJob.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputJob.setError("Field can't be empty");
            return false;
        } else {
            textInputJob.setError(null);
            return true;
        }
    }

    private boolean validateDuration() {
        String emailInput = textInputDuration.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputDuration.setError("Field can't be empty");
            return false;
        } else {
            textInputDuration.setError(null);
            return true;
        }
    }

    private boolean validateComany() {
        String emailInput = textInputCompany.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputCompany.setError("Field can't be empty");
            return false;
        } else {
            textInputCompany.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateJob() | !validateDuration() | !validateComany()) {
            return;
        }
        boolean isInserted = mydb.insertData2(textInputJob.getEditText().getText().toString(),textInputDuration.getEditText().getText().toString(),textInputCompany.getEditText().getText().toString());
        if(isInserted==true)
            Toast.makeText(Jobs.this,"Data Inserted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Jobs.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
    }

    public void viewAll2(View v){
        Cursor res = mydb.getAllData();
        if (res.getCount()==0){
            showMessage("Error","Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("Job: " + res.getString(14) + "\n");
            buffer.append("Company: " + res.getString(15) + "\n");
            buffer.append("Duration: " + res.getString(16) + "\n\n");
        }

        showMessage("Data",buffer.toString());
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
