package com.example.sammy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Therapist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist);
        Button button=(Button) findViewById(R.id.cj_btn);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Therapist.this,Juliet.class);
                startActivity(i);
            }
        });
        Button btn=(Button) findViewById(R.id.jh_btn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Therapist.this,John.class);
                startActivity(i);
            }
        });
        Button cn=(Button) findViewById(R.id.cr_btn);
        cn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Therapist.this,Carol.class);
                startActivity(i);
            }
        });
    }
}