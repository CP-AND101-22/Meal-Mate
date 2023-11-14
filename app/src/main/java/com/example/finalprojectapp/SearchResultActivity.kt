package com.example.finalprojectapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONObject

class SearchResultActivity : AppCompatActivity() {

    private lateinit var rvRecipe: RecyclerView
    private lateinit var recipeInfo: MutableList<String>
    private lateinit var recipeImages: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_search_result)


        rvRecipe = findViewById<RecyclerView>(R.id.recipeList)
        recipeInfo = mutableListOf()
        recipeImages = mutableListOf()


        // Implement logic to fetch and display search results based on 'searchQuery'
        //call function
        val searchQuery = intent.getStringExtra("SEARCH_QUERY")

        if (searchQuery != null) {
            getRecipes(searchQuery)
        }
    }

    private fun getRecipes(searchQuery: String) {
        val client = AsyncHttpClient()
        val apiURL = "https://www.themealdb.com/api/json/v1/1/filter.php?i=$searchQuery"

        client[apiURL, object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String,
                throwable: Throwable?
            ) {
                Log.d("API Error", response)
                // Handle failure, show a message, or take appropriate action
                Toast.makeText(this@SearchResultActivity, "Failed to fetch meals. Please try again.", Toast.LENGTH_SHORT
                ).show()
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                try {
                        val recipeArray = json.jsonObject.getJSONArray("meals")

                        for (i in 0 until recipeArray.length()) {
                            val recipeObject = recipeArray.getJSONObject(i)
                            recipeInfo.add(recipeObject.getString("strMeal"))
                            recipeImages.add(recipeObject.getString("strMealThumb"))
                        }

                        val adapter = recipeAdapter(recipeInfo, recipeImages)
                        rvRecipe.adapter = adapter
                        rvRecipe.layoutManager = LinearLayoutManager(this@SearchResultActivity)
                        rvRecipe.addItemDecoration(
                            DividerItemDecoration(
                                this@SearchResultActivity,
                                LinearLayoutManager.VERTICAL
                            )
                        )

                } catch (e: Exception) {
                    // Handle JSON parsing exception if entry doesn't exist
                    e.printStackTrace()
                    Log.e("JSON Parsing Error", "Error parsing JSON", e)
                    Toast.makeText(this@SearchResultActivity, "Failed to fetch meal for that ingredient. Please try again.", Toast.LENGTH_SHORT).show()

                    finish()
                }
            }
        }]
    }

}