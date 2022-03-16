package com.example.ex3a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public static final int REGISTER_ID = 1;
    private TextView tv1;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Main Activity"); // Set the name of the new activity to "Register"
        tv1 = (TextView) findViewById(R.id.textView);
        registerBtn = (Button) findViewById(R.id.buttonReg);
    }

    public void registerButton (View view){

        Intent intent = new Intent(this,Register.class);
        startActivityForResult(intent,REGISTER_ID);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REGISTER_ID) {
            if (resultCode == RESULT_OK) {
                if (data.getExtras() != null) {
                    getSupportActionBar().setTitle("Main Activity with the registeration details"); // Set the name of the new activity to "Register"
                    String gender;
                    gender = data.getStringExtra(Register.GENDER);
                    if (gender.equals("Male"))
                        gender = "Mr.";
                    else gender = "Ms.";
                    tv1.setText("Welcome back " + gender + data.getStringExtra(Register.FIRST_NAME) + ", " + data.getStringExtra(Register.LAST_NAME));
                    registerBtn.setText("again...");
                }
            }
        }
    }
}