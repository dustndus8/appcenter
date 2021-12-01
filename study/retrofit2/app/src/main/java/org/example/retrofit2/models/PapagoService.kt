package org.example.retrofit2.models

import org.w3c.dom.DOMStringList
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST
val exampleText = "이것은 한글을 영어로 번역해주는 앱이야"
interface PapagoService {
    @FormUrlEncoded
    @POST("n2mt")
    fun requestTranslation(@Header("X-Naver-Client-Id")clientID: String = Configs.clientID,
                           @Header("X-Naver-Client-Secret")apiKey: String = Configs.apiKey,
                           @Field("source")fromLang: String = "ko",
                           @Field("target")toLang: String = "en",
                           @Field("text")text: String? = exampleText): Call<PapagoEntity>
}