package com.example.resumebuilder;


import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    final String TAG2 = "Activity2";
    private CardView Basic,Education,Skills,Additional,Jobs,Downloads;
    DatabaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG2,"Status: onCreate");
        Basic = (CardView)findViewById(R.id.Basic);
        Education = (CardView)findViewById(R.id.Education);
        Skills = (CardView)findViewById(R.id.Skills);
        Jobs = (CardView)findViewById(R.id.Jobs);
        Additional = (CardView)findViewById(R.id.Additional);
        Downloads = (CardView)findViewById(R.id.Download);

        Basic.setOnClickListener(this);
        Education.setOnClickListener(this);
        Skills.setOnClickListener(this);
        Jobs.setOnClickListener(this);
        Additional.setOnClickListener(this);
        Downloads.setOnClickListener(this);
        mydb = new DatabaseHelper(this);
    }



    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.Basic : i = new Intent(this,BasicPage.class); startActivity(i); break;
            case R.id.Education : i = new Intent(this,Education.class); startActivity(i);break;
            case R.id.Skills : i = new Intent(this,Skills.class); startActivity(i); break;
            case R.id.Jobs : i = new Intent(this,Jobs.class); startActivity(i); break;
            case R.id.Additional : i = new Intent(this,Additional.class); startActivity(i); break;
            case R.id.Download : i = new Intent(this,Download.class); startActivity(i); break;
            default:break;
        }
    }
}

