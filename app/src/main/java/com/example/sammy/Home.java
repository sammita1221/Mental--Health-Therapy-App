package com.example.sammy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Thread thread=new Thread(){
            public void run(){
                try{
                    sleep(5000);

                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                finally{
                    Intent i=new Intent(Home.this,Quest.class);
                    startActivity(i);
                }
            }
        };thread.start();
    }
}