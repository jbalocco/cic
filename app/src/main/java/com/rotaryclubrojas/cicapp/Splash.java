package com.rotaryclubrojas.cicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ProgressBar;

public class Splash extends Activity {
    public static final int segundos=3;
    public static final int milisegundos=segundos*1000;
    public static final int delay=2;
    private ProgressBar progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progreso= (ProgressBar) findViewById(R.id.pbProgreso);
        progreso.setMax(maximo_progreso());
        animacion();
    }

    public void animacion (){
        new CountDownTimer(milisegundos,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                progreso.setProgress(establecer_progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent nuevofrom=new Intent(Splash.this,Horarios.class);
                startActivity(nuevofrom);
                finish();
            }
        }.start();
    }

    public int establecer_progreso(long miliseconds){

        return (int) ((milisegundos-miliseconds)/1000);

    }

    public int maximo_progreso (){

        return segundos-delay;

    }
}
