package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.net.Uri;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    LinearLayout container;
    @SuppressLint("MissingInflatedId")
    String tag = "LifeCycle";

    CheckBox chkCream;
    CheckBox chkSugar;
    Button btnPay;
    MainFragment mainFragment;
    MenuFragment menuFragment;

    TextView textView;
    String[] items = {"mike", "angel", "crow", "john", "ginnie", "sally", "cohen", "rice"};
    LinearLayout mLinearLayout;


    private boolean running;
    private int value;

    TextView textView0;
    ProgressBar bar;
    ProgressHandler handler;

    Handler handler2;
    ProgressRunnable runnable;
    boolean isRunning=false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        
        
//        //animation 예제
//        mLinearLayout = new LinearLayout(this);
//        // Instantiate an ImageView and define its properties
//        ImageView img = new ImageView(this);
//        Drawable myImage = getResources().getDrawable(R.drawable.ic_launcher_foreground);
//        img.setImageDrawable(myImage);
//        // to match the Drawable's dimensions
//        img.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.WRAP_CONTENT,
//                Gallery.LayoutParams.WRAP_CONTENT));
//        // Add the ImageView to the layout and set the layout as the content view
//        mLinearLayout.addView(img);
//        setContentView(mLinearLayout);

        setContentView(R.layout.activity_thread);//parsing 해오기 위한 작업
        //동적 작업 하는 것 확인 유니티에서 코드로 오브젝트 생성하는 것과 비슷
        //id를 R.java가 모두 모아서 관리한다

        Log.d(tag, "In the onCreate() event");

        final TextView textview = (TextView) findViewById(R.id.textView01);
        Button button_Thread=(Button)findViewById(R.id.button_thread);

        button_Thread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.setText("스레드에서 받은 값: " + value);
            }
        });

        textView0 = (TextView) findViewById(R.id.TextView01);
        bar = (ProgressBar) findViewById(R.id.progress);
        handler = new ProgressHandler();

        handler2 = new Handler();
        runnable = new ProgressRunnable();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_Thread), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });


        //Adapter 추가

     /*   textView = (TextView) findViewById(R.id.textView);

        ListView listview = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        listview.setAdapter(adapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(items[position]);
                Toast.makeText(getApplicationContext(), items[position], Toast.LENGTH_SHORT).show();
            }
        });*/


        //Fragnent EX
      /*  mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.con, mainFragment).commit();
        menuFragment = new MenuFragment();
    }
    public void onFragmentChanged(int index) {
        if (index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.con, menuFragment).commit();
        } else if (index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.con, mainFragment).commit();
        }
    }*/



/*
        container=(LinearLayout)findViewById(R.id.container);
        Button button =(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                inflater.inflate(R.layout.sub1,container, true);

                TextView textview = (TextView) container.findViewById(R.id.textview);//이 부분의 container
                textview.setText("클릭되었습니다.");
                
                CheckBox checkBox = (CheckBox) container.findViewById(R.id.checkBox);
                checkBox.setText("로딩되었어요.");
            }

        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                startActivityForResult(intent,1);
            }
        });
        Button btnStart = findViewById(R.id.btnStartService);
        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MyService.class));
            }
        });

        Button btnStop = findViewById(R.id.btnStopService);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(getApplicationContext(), MyService.class));
            }
        });*/
        //제한적인 범위에서 찾는게 좋다 .container?

    }

    class MyThread extends Thread{

        @Override
        public void run() {
            super.run();
        }
    }

    class MyRunnableClass implements Runnable{

        @Override
        public void run() {

        }
    }

    public void onStart() {
        super.onStart();
        bar.setProgress(0);
        Thread thread1=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    for(int i=0; i<20 &&isRunning; i++) {
                        Thread.sleep(1000);
                        Message msg=handler.obtainMessage();
                        //handler.sendMessage(msg);
                        handler.post(runnable);//Handler의 post() method는 runnable 객체내의 run() 메소드를 실행하게 함


                    }
                } catch (Exception ex) {
                    Log.e("MainActivity","Exception in processing message.",ex);
                }
            }
        });
        isRunning = true;
        thread1.start();
        Log.d(tag, "In the onStart() event");
    }

    
    //두가지 다른 예제들
    public class ProgressHandler extends Handler {
        public void handleMessage(Message msg){
            bar.incrementProgressBy(5);//5씩 게이지 바 값이 증가한다는 말
            if(bar.getProgress()==bar.getMax()){
                textView0.setText("Done");
            } else {
                textView0.setText("Working..."+bar.getProgress());
            }
        }
    }

    public class ProgressRunnable implements Runnable {
        public void run(){
            bar.incrementProgressBy(5);
            if(bar.getProgress()==bar.getMax()){
                textView0.setText("Done");
            } else {
                textView0.setText("Working..."+bar.getProgress());
            }
        }
    }

    public void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }


    //Thread 예제
    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        Thread thread1 = new BackgroundThread();
        thread1.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        running = false;
        value = 0;
    }
    class BackgroundThread extends Thread {
        public void run(){
            while (running){
                try{
                    Thread.sleep(1000);
                    value++;
                }
                catch(Exception ex){}
            }
        }
    }

    public void onStop() {
        Log.d(tag, "In the onStop() event");
        super.onStop();
        isRunning = false;
    }

    public void onDestroy() {
        Log.d(tag, "In the onDestroy() event");
        super.onDestroy();
    }
}

