package com.rotaryclubrojas.cicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

import com.zl.reik.dilatingdotsprogressbar.DilatingDotsProgressBar;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        DilatingDotsProgressBar progressBar = (DilatingDotsProgressBar)findViewById(R.id.progress);
        progressBar.showNow();
        new InitLoader().execute();
    }

    class InitLoader extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Intent nuevofrom=new Intent(Splash.this,Horarios.class);
            startActivity(nuevofrom);
            finish();
        }
    }
}
