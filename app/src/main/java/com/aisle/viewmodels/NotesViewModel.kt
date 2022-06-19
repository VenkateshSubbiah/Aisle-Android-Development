package com.aisle.viewmodels

import androidx.lifecycle.ViewModel
import com.aisle.Constants
import com.aisle.pojo.NotesResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request


class NotesViewModel : ViewModel() {

    suspend fun fetchNotes(token: String): NotesResponse? {
        val client = OkHttpClient()
        val gson = Gson()
        val request = Request.Builder()
            .url(Constants.BASE_URL + Constants.NOTES_END_POINT)
            .header("authorization", token)
            .get()
            .build()
        val jsonString = withContext(Dispatchers.IO) {
            kotlin.runCatching {
                val response = client.newCall(request).execute()
                response.body?.string()
            }
        }.getOrNull()
        return if (jsonString != null)
            gson.fromJson(jsonString, NotesResponse::class.java) else null
    }
}