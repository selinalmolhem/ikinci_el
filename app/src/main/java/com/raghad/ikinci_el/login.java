package com.raghad.ikinci_el;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    TextView t1;
    Button b1;
    EditText et1,et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        et1= findViewById(R.id.name);
        et2= findViewById(R.id.p1);

        t1 = findViewById(R.id.t1);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, sigin.class);
                startActivity(intent);

            }
        });
        DBHelper DB = new DBHelper(this);
        b1 =findViewById(R.id.save);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // String user ="";
                //String password= "";
                User user1 =new User();
               String user=user1.username = et1.getText().toString();
              String  password=user1.pasword = et2.getText().toString();

                if(user.equals("")||password.equals(""))
                    Toast.makeText(login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, password);
                    if(checkuserpass==true){
                        Toast.makeText(login.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), main.class);
                        intent.putExtra( "name",user);
                        startActivity(intent);
                    }else{
                        Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}