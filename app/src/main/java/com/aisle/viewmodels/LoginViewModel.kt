package com.aisle.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aisle.Constants
import com.aisle.pojo.AisleParams
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.util.*

class LoginViewModel : ViewModel() {

    val countryCode = MutableLiveData<String>()
    val phoneNum = MutableLiveData<String>()
    val otpTimeout = MutableLiveData<String>()
    var token: String? = null

    private val client = OkHttpClient()
    private val gson = Gson()

    suspend fun checkPhoneNum(): Boolean {
        val number = countryCode.value + phoneNum.value
        val jsonObject = fetch(number, null, Constants.PHONE_NUM_END_POINT)
        val status = jsonObject?.getAsJsonPrimitive("status")?.asBoolean == true
        if (status) {
            startOtpTimeout()
        }
        return status
    }

    suspend fun checkOtp(otp: String): Boolean {
        val number = countryCode.value + phoneNum.value
        val jsonObject = fetch(number, otp, Constants.OTP_END_POINT)
        val jsonElement = jsonObject?.get("token")
        token = if (jsonElement?.isJsonPrimitive == true) jsonElement.asString else null
        return token != null
    }

    private fun startOtpTimeout() {
        val timer = Timer(false)
        var timeInSeconds = 60
        val timerTask: TimerTask = object : TimerTask() {
            override fun run() {
                otpTimeout.postValue(
                    "${
                        (timeInSeconds / 60).toString().padStart(2, '0')
                    }:${(timeInSeconds % 60).toString().padStart(2, '0')}"
                )

                timeInSeconds--
                if (timeInSeconds < 0) {
                    otpTimeout.postValue("Resend OTP")
                    timer.cancel()
                }
            }
        }
        timer.scheduleAtFixedRate(timerTask, 0, 1000)
    }

    private suspend fun fetch(number: String, otp: String?, endPoint: String): JsonObject? {
        val param = AisleParams(number, otp)
        val mediaType = "application/json; charset=utf-8".toMediaTypeOrNull()
        val request = Request.Builder()
            .url(Constants.BASE_URL + endPoint)
            .post(gson.toJson(param).toRequestBody(mediaType))
            .build()
        val jsonString = withContext(Dispatchers.IO) {
            kotlin.runCatching {
                val response = client.newCall(request).execute()
                response.body?.string()
            }
        }.getOrNull()

        val jsonElement = if (jsonString != null) JsonParser.parseString(jsonString) else null
        return if (jsonElement != null && jsonElement.isJsonObject)
            jsonElement.asJsonObject else null
    }
}