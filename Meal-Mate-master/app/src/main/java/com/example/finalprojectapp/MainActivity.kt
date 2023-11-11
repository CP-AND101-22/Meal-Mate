package com.example.finalprojectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var rvRecipe: RecyclerView
    private lateinit var recipeInfo: MutableList<String>
    private lateinit var recipeImages: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        rvRecipe = findViewById<RecyclerView>(R.id.recipeList)
        recipeInfo = mutableListOf()
        recipeImages = mutableListOf()

        //call function
        getRecipes()

    }

    //helper function to put the name and description as one string
    private fun getRecipeDetails(categoryObject: JSONObject): String {
        val categoryName = categoryObject.getString("strCategory")
        val description = categoryObject.getString("strCategoryDescription")
        return "$categoryName\n$description"
    }

    private fun getRecipes(){
        val client = AsyncHttpClient()
        val apiURl = "http://www.themealdb.com/api/json/v1/1/categories.php"

        client[apiURl,object : JsonHttpResponseHandler(){
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String,
                throwable: Throwable?
            ) {
                Log.d("API Error", response)
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                val recipeArray = json.jsonObject.getJSONArray("categories")

                for (i in 0 until recipeArray.length()) {
                    val recipeObject = recipeArray.getJSONObject(i)
                    val details = getRecipeDetails(recipeObject)
                    recipeInfo.add(details)         //add string from helper function
                    recipeImages.add(recipeObject.getString("strCategoryThumb")) //get image URL and add to array
                }
                val adapter = recipeAdapter(recipeInfo, recipeImages)  //load to adapter
                rvRecipe.adapter = adapter
                rvRecipe.layoutManager = LinearLayoutManager(this@MainActivity)
                rvRecipe.addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
            }

        }]
    }
}