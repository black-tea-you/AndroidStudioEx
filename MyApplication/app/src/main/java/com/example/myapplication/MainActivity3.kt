package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnFragment1 = findViewById<Button>(R.id.btn_fragment1)
        val btnFragment2 = findViewById<Button>(R.id.btn_fragment2)
        val btnFragment3 = findViewById<Button>(R.id.btn_fragment3)

        btnFragment1.setOnClickListener { setFlag(0) }
        btnFragment2.setOnClickListener { setFlag(1) }
        btnFragment3.setOnClickListener { setFlag(2) }

        setFlag(0)
    }

    private fun setFlag(fragNum: Int) {
        val ft=supportFragmentManager.beginTransaction()//fragmentTransaction 변수


        //switch 문
        when(fragNum){
            0->{
                //Frame 화면 내에서만 교체 하겠다는 뜻
                ft.replace(R.id.Main_frame,Fragment1()).commit()//commit() 저장하겠다는 뜻
            }
            1->{
                //Frame 화면 내에서만 교체 하겠다는 뜻
                ft.replace(R.id.Main_frame,Fragment2()).commit()//commit() 저장하겠다는 뜻
            }
            2->{
                //Frame 화면 내에서만 교체 하겠다는 뜻
                ft.replace(R.id.Main_frame,Fragment3()).commit()//commit() 저장하겠다는 뜻
            }


        }
    }

}