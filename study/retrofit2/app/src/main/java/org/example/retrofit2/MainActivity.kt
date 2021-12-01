package org.example.retrofit2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import org.example.retrofit2.Adapter.ChattingAdapter
import org.example.retrofit2.models.PapagoEntity
import org.example.retrofit2.models.PapagoServiceCreator
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = "MainActivity Request"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.main_recyclerview)

        val papagoService = PapagoServiceCreator().create()
        val call = papagoService.requestTranslation()
        call.enqueue(object : retrofit2.Callback<PapagoEntity> {
            override fun onResponse(call: Call<PapagoEntity>, response: Response<PapagoEntity>) {
                if(response.isSuccessful) {
                    // 성공
                    Log.d(LOG_TAG, "Successful!")

                    val result = response.body()
                    val chattingList = arrayListOf( ChattingAdapter.Message(result?.message?.result?.translatedText!!) )

                    recyclerView.adapter = ChattingAdapter(chattingList)
                    Log.e(LOG_TAG, response.raw().toString());
                }
                else {
                    // 서버에 연결은 됐으나 결과 받기 실패
                    Log.e(LOG_TAG, "fail!")
                    Log.e(LOG_TAG, "error code : " + response.code())
                    Log.e(LOG_TAG, "error message : " + response.message())
                }
            }
            // 서버 연결 실패
            override fun onFailure(call: Call<PapagoEntity>, t: Throwable) {
                Log.d(LOG_TAG, "onFailure!")
                t.printStackTrace()
            }
        })
    }
}