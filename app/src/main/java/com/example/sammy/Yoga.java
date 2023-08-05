package com.example.sammy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Yoga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);
        ImageButton b=(ImageButton) findViewById(R.id.bala_btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Yoga.this,Balasana.class);
                startActivity(intent);
            }
        });
        ImageButton button=(ImageButton) findViewById(R.id.vipa_btn);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Yoga.this,Viparita.class);
                startActivity(i);
            }
        });
        ImageButton bt=(ImageButton) findViewById(R.id.sukha_btn);
        bt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Yoga.this,Sukhasana.class);
                startActivity(i);
            }
        });
        ImageButton btn=(ImageButton) findViewById(R.id.biti_btn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Yoga.this,Bitilasana.class);
                startActivity(i);
            }
        });
        ImageButton bton=(ImageButton) findViewById(R.id.tada_btn);
        bton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(Yoga.this,Tadasana.class);
                startActivity(i);
            }
        });
       }

    }
