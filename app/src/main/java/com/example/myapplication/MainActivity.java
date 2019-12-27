package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlerThread mThread = new HandlerThread("name");
        mThread.start();
        Handler mThreadHandler=new Handler(mThread.getLooper());
        mThreadHandler.post(r1);
    }
    private Runnable r1=new Runnable () {
        public void run() {
            Log.d("test", "Runing..");
            mUI_HandlerMSG.postDelayed(r2, 2000);
            mUI_HandlerMSG.sendEmptyMessage(MSG_UPLOAD_OK);
        }
    };

    //工作名稱 r2 的工作內容
    private Runnable r2=new Runnable () {

        public void run() {
            TextView tv = findViewById(R.id.TextView);
            tv.setText("Got it");
        }

    };
    final int MSG_UPLOAD_OK = 1;
    final int MSG_UPLOAD_ERR = 2;
    private Handler mUI_HandlerMSG = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case MSG_UPLOAD_OK:
                    TextView tv = findViewById(R.id.TextView);
                    tv.setText("Got Message");

                    break;
                case MSG_UPLOAD_ERR:
                    TextView tv1 = findViewById(R.id.TextView);
                    tv1.setText("Message err");

                    break;
            }
        }
    };

}
