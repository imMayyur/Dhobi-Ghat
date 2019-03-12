package com.example.mayur.laundryhome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class createProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);

        SharedPreferences sharedPreferences = getSharedPreferences("first",0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int count = sharedPreferences.getInt("count",0);

        if(count == 0)
        {
            count++;
            editor.putInt("count",count);
            editor.commit();
        }
        else
        {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
