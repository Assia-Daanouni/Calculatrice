package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainSecondActivity extends AppCompatActivity {

    Button BtnEnsaf;
    Button BtnCall;
    Button BtnCamera;
    Button BtnNext;
    Intent intent,intent2,intent3,intent4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        BtnEnsaf=findViewById(R.id.btn2);
        BtnCall=findViewById(R.id.btn3);
        BtnCamera=findViewById(R.id.btn4);
        BtnNext=findViewById(R.id.btn5);

        BtnEnsaf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url= "https://www.ensaf.ac.ma";
                intent=new Intent(Intent.ACTION_VIEW,Uri.parse(url));
                startActivity(intent);
            }
        });

        BtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Uri uri=Uri.parse("tel:0622867489");
                intent2 = new Intent(Intent.ACTION_CALL, uri);
                startActivity(intent2);
            }
        }

        );
        BtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent3=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent3);
            }
        });
        BtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent4=new Intent(MainSecondActivity.this,activity4.class);
                startActivity(intent4);
            }
        });
    }

}