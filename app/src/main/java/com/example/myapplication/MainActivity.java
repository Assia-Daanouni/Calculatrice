package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView Name;
    TextView Pass;
    EditText EnName;
    EditText EnPass;
    Button Btn1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //installation
        Name=findViewById(R.id.Name);
        Pass=findViewById(R.id.Pass);
        EnName=findViewById(R.id.editName);
        EnPass=findViewById(R.id.editPass);
        Btn1=findViewById(R.id.bttng);

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=EnName.getText().toString();
                String userPassword=EnPass.getText().toString();

                if(userName.equals("Assia Daanouni") && userPassword.equals("Queen Assia")){
                    intent=new Intent(MainActivity.this, MainSecondActivity.class);
                    startActivity(intent);
                } else if ((! userName.equals("Assia Daanouni")) && userPassword.equals("Queen Assia")) {
                    Toast.makeText(MainActivity.this, "Invalid Username ", Toast.LENGTH_LONG).show();
                } else if ((! userPassword.equals("Queen Assia")) &&  userName.equals("Assia Daanouni")) {
                    Toast.makeText(MainActivity.this, "Invalid Password", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}