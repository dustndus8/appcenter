package org.example.recyclerviewstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview = findViewById<RecyclerView>(R.id.main_recyclerview);
        //val temp = arrayListOf<String>("안녕하세요? 앱센터입니다.","3주차는 리사이클러뷰에 대해 배웁니다.","ㅎㅎ")
        val list = arrayListOf(
            ExampleMessage("","안녕하세요? 앱센터입니다."),
            ExampleMessage("","3주차는 리사이클러뷰에 대해 배웁니다."),
            ExampleMessage("","ㅎㅎ")
        )

        // 실무에서는 val list = temp.map{ ExampleMessage("",it) }

        recyclerview.adapter=ExampleAdapter(list)
    }
}