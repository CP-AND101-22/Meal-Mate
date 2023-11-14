package com.example.finalprojectapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONObject

class categoryResultActivity : AppCompatActivity() {

    private lateinit var rvCategory: RecyclerView
    private lateinit var categoryInfo: MutableList<String>
    private lateinit var categoryImages: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_category_display)


        rvCategory = findViewById<RecyclerView>(R.id.categoryList)
        categoryInfo = mutableListOf()
        categoryImages = mutableListOf()

        val searchQuery = intent.getStringExtra("SEARCH_QUERY")
        // Implement logic to fetch and display search results based on 'searchQuery'
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
                val categoryArray = json.jsonObject.getJSONArray("categories")

                for (i in 0 until categoryArray.length()) {
                    val categoryObject = categoryArray.getJSONObject(i)
                    val details = getRecipeDetails(categoryObject)
                    categoryInfo.add(details)         //add string from helper function
                    categoryImages.add(categoryObject.getString("strCategoryThumb")) //get image URL and add to array
                }
                val adapter = categoryAdapter(categoryInfo, categoryImages)  //load to adapter
                rvCategory.adapter = adapter
                rvCategory.layoutManager = LinearLayoutManager(this@categoryResultActivity)
                rvCategory.addItemDecoration(DividerItemDecoration(this@categoryResultActivity, LinearLayoutManager.VERTICAL))
            }

        }]
    }
}