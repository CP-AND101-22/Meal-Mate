package com.example.finalprojectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class DetailActivity : AppCompatActivity() {
    private lateinit var mealTitle: String
    private lateinit var mealInfo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title: TextView = findViewById(R.id.titleTextView)
        val info: TextView = findViewById(R.id.instructionTextView)

        val recipeId: String? = intent.getStringExtra("rId")

        if (recipeId != null) {
            getRecipeDetails(recipeId) {
                // Update UI here after getting details
                title.text = mealTitle
                info.text = mealInfo
            }
        }
    }

    private fun getRecipeDetails(idReceived: String, onSuccessCallback: () -> Unit) {
        val client = AsyncHttpClient()
        val apiURl = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=$idReceived"

        client[apiURl, object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String,
                throwable: Throwable?
            ) {
                Log.d("API Error", response)
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {
                Log.d("ID", "onSuccess called!")
                val recipeArray = json.jsonObject.getJSONArray("meals")
                for (i in 0 until recipeArray.length()) {
                    val recipeObject = recipeArray.getJSONObject(i)
                    mealTitle = recipeObject.getString("strMeal")
                    mealInfo = recipeObject.getString("strInstructions")
                }

                onSuccessCallback.invoke()
            }
        }]
    }

}