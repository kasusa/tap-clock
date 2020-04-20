package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    TextView a ;
    TextView b ;
    String oldtime = "none";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getSupportActionBar().hide(); //<< this
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.textView);
        b = findViewById(R.id.textView2);


        gettime();
    }


    private void gettime() {
        b.setText("last tap : "+oldtime);

        Date dNow = new Date( );
        SimpleDateFormat timeHHMMSS = new SimpleDateFormat ("hh:mm:ss");
        SimpleDateFormat timeHHMM = new SimpleDateFormat ("HH:mm");
        SimpleDateFormat timeYYMMDD = new SimpleDateFormat ("yyyy-MM-dd");

        System.out.println("当前时间为: " + timeHHMM.format(dNow));
        a.setText(timeHHMM.format(dNow));
        oldtime =  timeHHMMSS.format(dNow);

    }


    public void updateTime(View view) {
        gettime();

    }
}
