package org.example.inu_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.login_button).setOnClickListener{
            val idText = findViewById<EditText>(R.id.id_edit).text.toString()
            val pwText = findViewById<EditText>(R.id.pw_edit).text.toString()
            if ("".equals(idText) || "".equals(pwText)){
                Toast.makeText(this,"아이디 혹은 비밀번호를 입력하세요.",Toast.LENGTH_SHORT).show()
            }
        }



    }
}