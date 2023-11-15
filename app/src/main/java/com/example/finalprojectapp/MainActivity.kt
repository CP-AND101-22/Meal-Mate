package com.example.finalprojectapp

import android.content.Intent
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

         val searchButton: Button = findViewById(R.id.searchButton)
         val searchBox: EditText = findViewById(R.id.searchBox)
         val categoryText: TextView = findViewById(R.id.categoryText)


         categoryText.setOnClickListener {
             val intent = Intent(this, categoryResultActivity::class.java)
             startActivity(intent)
         }

        searchButton.setOnClickListener {
            val searchText = searchBox.text.toString()

            if (searchText == ""){
                Toast.makeText(this, "Please enter an ingredient in the search bar!", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, SearchResultActivity::class.java)
                intent.putExtra("SEARCH_QUERY", searchText)
                startActivity(intent)
            }
        }
    }
}