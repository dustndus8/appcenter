package org.example.inu_login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.login_button).setOnClickListener{
            val id = findViewById<EditText>(R.id.id_edit)
            val pw = findViewById<EditText>(R.id.pw_edit)
            if (id.text.toString().isBlank() || pw.text.toString().isBlank()){
                Toast.makeText(this,"아이디 혹은 비밀번호를 입력하세요.",Toast.LENGTH_SHORT).show()
                if (id.text.toString().isBlank()) {
                    id.requestFocus()
                }
                else if (pw.text.toString().isBlank()){
                    pw.requestFocus()
                }
            }
            else {
                findViewById<TextView>(R.id.no_answer_textview).visibility= View.VISIBLE
            }
        }
    }
}