package com.example.myapplication;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        
        
        //animation 예제
        mLinearLayout = new LinearLayout(this);
        // Instantiate an ImageView and define its properties
        ImageView img = new ImageView(this);
        Drawable myImage = getResources().getDrawable(R.drawable.ic_launcher_foreground);
        img.setImageDrawable(myImage);
        // to match the Drawable's dimensions
        img.setLayoutParams(new Gallery.LayoutParams(Gallery.LayoutParams.WRAP_CONTENT,
                Gallery.LayoutParams.WRAP_CONTENT));
        // Add the ImageView to the layout and set the layout as the content view
        mLinearLayout.addView(img);
        setContentView(mLinearLayout);

        //setContentView(R.layout.activity_canvas);//parsing 해오기 위한 작업
        //동적 작업 하는 것 확인 유니티에서 코드로 오브젝트 생성하는 것과 비슷
        //id를 R.java가 모두 모아서 관리한다
        Log.d(tag, "In the onCreate() event");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.canvas), (v, insets) -> {
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

    public void onStart() {
        super.onStart();
        Log.d(tag, "In the onStart() event");
    }

    public void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }

    public void onResume() {
        super.onResume();
        Log.d(tag, "In the onResume() event");
    }

    public void onPause() {
        Log.d(tag, "In the onPause() event");
        super.onPause();
    }

    public void onStop() {
        Log.d(tag, "In the onStop() event");
        super.onStop();
    }

    public void onDestroy() {
        Log.d(tag, "In the onDestroy() event");
        super.onDestroy();
    }
}