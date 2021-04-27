package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sigin extends AppCompatActivity {
 EditText t1,t2,t3;
 Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sigin);
        t1 = findViewById(R.id.name);
        t2 = findViewById(R.id.p1);
        t3 = findViewById(R.id.p2);
        b1 = findViewById(R.id.save);
        DBHelper DB = new DBHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user  = t1.getText().toString();
                String pasword  = t2.getText().toString();
                String pasword2  = t3.getText().toString();
                if (user.equals("") || pasword.equals("") || pasword2.equals(""))
                    Toast.makeText(sigin.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pasword.equals(pasword2)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pasword);
                            if (insert == true) {
                                Toast.makeText(sigin.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), login.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(sigin.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(sigin.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(sigin.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}