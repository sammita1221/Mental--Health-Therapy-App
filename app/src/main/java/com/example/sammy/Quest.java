package com.example.sammy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;




public class Quest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
         ImageButton b= (ImageButton) findViewById(R.id.hap_btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            Intent intent=new Intent(Quest.this,Todo.class);
            startActivity(intent);

        }


    });
       ImageButton button=(ImageButton) findViewById(R.id.stress_btn);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Quest.this,Yoga.class);
               startActivity(i);
            }
       });
        ImageButton butn=(ImageButton) findViewById(R.id.dep_btn);
        butn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Quest.this,Therapist.class);
                startActivity(i);
            }
        });
}
}