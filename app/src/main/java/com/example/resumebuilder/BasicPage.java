package com.example.resumebuilder;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class BasicPage extends AppCompatActivity {
    final String TAG4 = "Basic";
    private TextInputLayout textInputEmail;
    private TextInputLayout textInputName;
    private TextInputLayout textInputPhone;
    private TextInputLayout textInputAddress;
    DatabaseHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG4,"Basic3");
        super.onCreate(savedInstanceState);
        Log.d(TAG4,"Basic4");
        setContentView(R.layout.activity_basic_page);
        Log.d(TAG4,"Basic5");

        textInputName = findViewById(R.id.text_input_name);
        textInputEmail = findViewById(R.id.text_input_email);
        textInputPhone = findViewById(R.id.text_input_phone_num);
        textInputAddress = findViewById(R.id.text_input_address);
        mydb = new DatabaseHelper(this);
    }


    private boolean validateEmail() {
        String emailInput = textInputEmail.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputEmail.setError("Field can't be empty");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean validatePhone() {
        String emailInput = textInputPhone.getEditText().getText().toString().trim();

        if (emailInput.isEmpty()) {
            textInputPhone.setError("Field can't be empty");
            return false;
        } else {
            textInputPhone.setError(null);
            return true;
        }
    }

    private boolean validateName() {
        String nameInput = textInputName.getEditText().getText().toString().trim();

        if (nameInput.isEmpty()) {
            textInputName.setError("Field can't be empty");
            return false;
        }
        else {
            textInputName.setError(null);
            return true;
        }
    }

    private boolean validateAddress() {
        String addressInput = textInputAddress.getEditText().getText().toString().trim();

        if (addressInput.isEmpty()) {
            textInputAddress.setError("Field can't be empty");
            return false;
        } else {
            textInputAddress.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateEmail() | !validateName() | !validateAddress()| !validatePhone()) {
            return;
        }
        boolean isInserted = mydb.insertData(textInputName.getEditText().getText().toString(),textInputEmail.getEditText().getText().toString(),textInputPhone.getEditText().getText().toString(),textInputAddress.getEditText().getText().toString());
        if(isInserted==true)
            Toast.makeText(BasicPage.this,"Data Inserted",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(BasicPage.this,"Data not Inserted",Toast.LENGTH_SHORT).show();
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
            buffer.append("Address: " + res.getString(3) + "\n\n");
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
        boolean isUpdated = mydb.updateData(textInputName.getEditText().getText().toString(),textInputEmail.getEditText().getText().toString(),textInputPhone.getEditText().getText().toString(),textInputAddress.getEditText().getText().toString());
        if (isUpdated==true)
            Toast.makeText(BasicPage.this,"Data Updated",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(BasicPage.this,"Data Not Updated",Toast.LENGTH_SHORT).show();

    }

}
