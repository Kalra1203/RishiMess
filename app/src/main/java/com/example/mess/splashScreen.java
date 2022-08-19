package com.example.mess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread thread= new Thread(){
            @Override
            public void run() {
                try{
                    sleep(2000);

                }
                catch (Exception e){
                    e.getMessage();

                }
                finally{
                    Intent intent= new Intent(splashScreen.this, registerEmail.class);
                    startActivity(intent);
                }
            }
        };thread.start();





    }



}