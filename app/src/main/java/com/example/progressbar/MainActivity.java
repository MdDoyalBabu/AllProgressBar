package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.progressbar.ProgressBarWithParcentage.ProgressBarParcentageActivity;
import com.example.progressbar.ProgressBarWithhoutParcentage.ProgressWithoutParcentageActivity;

public class MainActivity extends AppCompatActivity {


    private Button btn1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, ProgressBarParcentageActivity.class);
                startActivity(intent);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, ProgressWithoutParcentageActivity.class);
                startActivity(intent);

            }
        });


    }
}