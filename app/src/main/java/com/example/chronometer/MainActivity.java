package com.example.chronometer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mtvtime;
    private Button mbtnstart;
    private Button mbtnlap;
    private Button mbtnstop;

    private Context mContext;
    private Chronometer mChronometer;
    private Thread mThreadChrono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        mtvtime = (TextView)findViewById(R.id.tv_time);
        mbtnstart = (Button)findViewById(R.id.btn_start);
        mbtnlap = (Button)findViewById(R.id.btn_lap);
        mbtnstop = (Button)findViewById(R.id.btn_stop);

        mbtnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(mChronometer == null){
                    mChronometer = new Chronometer(mContext);
                    mThreadChrono = new Thread(mChronometer);
                    mThreadChrono.start();
                    mChronometer.start();

                }

            }
        });

    }
    public void updateTimerText(final String time){
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               mtvtime.setText(time);
           }
       });
    }
}
