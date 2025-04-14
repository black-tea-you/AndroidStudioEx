package com.example.myapplication;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ThreadEX extends AppCompatActivity implements Runnable {

    Button button1;
    ImageView img1;
    Bitmap bitmap;

    @SuppressLint("HandlerLeak")
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            img1.setImageBitmap(bitmap);

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_ex);

        button1 = (Button) findViewById(R.id.button1);
        img1 = (ImageView) findViewById(R.id.img1);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 //1

                URL url = null;
                try {

                    url = new URL("https://www.gachon.ac.kr/sites/kor/images/sub/slogan_1.png");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    bitmap = BitmapFactory.decodeStream(is);
                    handler.sendEmptyMessage(0);
                    is.close();
                    conn.disconnect();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                //2
//                Thread th = new Thread(ThreadEX.this);
//                th.start();

            }
        });


    }

    //이런 형식으로 쓸 수 있음 thread 생성이 아닌 main 안에 run()은 thread형태로 동작함
    @Override
    public void run() {
        URL url = null;
        try {

            url = new URL("https://www.gachon.ac.kr/sites/kor/images/sub/slogan_1.png");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            //handler.sendEmptyMessage(0);
            is.close();
            conn.disconnect();
             //3
            img1.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
