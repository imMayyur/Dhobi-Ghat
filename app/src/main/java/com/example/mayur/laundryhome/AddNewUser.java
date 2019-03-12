package com.example.mayur.laundryhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddNewUser extends AppCompatActivity {

    LaundryHomeDBAdapter laundryHomeDBAdapter;
    EditText txtUserName,txtUserMno,txtUserAdd;
    Button btnAddUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        txtUserName = findViewById(R.id.txtUserName);
        txtUserMno = findViewById(R.id.txtUserMno);
        txtUserAdd = findViewById(R.id.txtUserAdd);

        btnAddUser = findViewById(R.id.btnAddUser);
        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Users users1 = new Users(txtUserName.getText().toString(),txtUserMno.getText().toString(),txtUserAdd.getText().toString());

                if(laundryHomeDBAdapter.insertData(users1))
                    Toast.makeText(AddNewUser.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(AddNewUser.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
