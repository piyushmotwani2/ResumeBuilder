package com.example.resumebuilder;

import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Education extends AppCompatActivity {
    private TextInputLayout textInputSchool;
    private TextInputLayout textInputCourse;
    private TextInputLayout textInputYear;
    private TextInputLayout textInputUpdate;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        textInputSchool = findViewById(R.id.text_input_school);
        textInputCourse = findViewById(R.id.text_input_course);
        textInputYear = findViewById(R.id.text_input_year);
        textInputUpdate = findViewById(R.id.text_input_update);
        mydb = new DatabaseHelper(this);
    }

    private boolean validateschool() {
        String emailInput = textInputSchool.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputSchool.setError("Field can't be empty");
            return false;
        } else {
            textInputSchool.setError(null);
            return true;
        }
    }

    private boolean validatecourse() {
        String emailInput = textInputCourse.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputCourse.setError("Field can't be empty");
            return false;
        } else {
            textInputCourse.setError(null);
            return true;
        }
    }

    private boolean validateyear() {
        String emailInput = textInputYear.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputYear.setError("Field can't be empty");
            return false;
        } else {
            textInputYear.setError(null);
            return true;
        }
    }

    /*public void confirmInput(View v) {
        if (!validateschool() | !validatecourse() | !validateyear()) {
            return;
        }
        boolean isInserted = mydb.insertData(textInputSchool.getEditText().getText().toString(),textInputCourse.getEditText().getText().toString(),textInputYear.getEditText().getText().toString());
        if(isInserted==true)
            Toast.makeText(Education.this,"Data Inserted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Education.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
    }

    public void viewAll1(View v){
        Cursor res = mydb.getAllData();
        if (res.getCount()==0){
            showMessage("Error","Nothing Found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()){
            buffer.append("School " + res.getString(4) + "\n");
            buffer.append("Course: " + res.getString(14) + "\n");
            buffer.append("Year: " + res.getString(13) + "\n\n");
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

    public void Updatedata(View v){
        boolean isUpdated = mydb.updateData1(textInputSchool.getEditText().getText().toString(),textInputCourse.getEditText().getText().toString(),textInputYear.getEditText().getText().toString(),textInputUpdate.getEditText().getText().toString());
        if (isUpdated==true)
            Toast.makeText(Education.this,"Data Updated",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(Education.this,"Data Not Updated",Toast.LENGTH_SHORT).show();

    }*/

}
