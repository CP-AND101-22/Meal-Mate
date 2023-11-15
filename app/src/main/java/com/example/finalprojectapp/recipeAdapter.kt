package com.example.finalprojectapp
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide


private val RecyclerView.ViewHolder.recipeInfo: TextView
    get() {return itemView.findViewById<TextView>(R.id.recipes)}
private val RecyclerView.ViewHolder.recipeImage: ImageView
    get() {return itemView.findViewById<ImageView>(R.id.recipeImage)}

class recipeAdapter(private val recipeList: MutableList<String>, private val recipeImageURL:MutableList<String>, private val recipeId:MutableList<String>):RecyclerView.Adapter<ViewHolder>() {

    //var onItemClick : ((MutableList<String>, MutableList<String>, MutableList<String>) -> Unit)? = null

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val recipeInfo: TextView
        val recipeImage:ImageView
        init {
            recipeInfo = view.findViewById(R.id.recipes)
            recipeImage = view.findViewById(R.id.recipeImage)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_search, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.recipeInfo.text = recipeList[position]

        //glide image
        Glide.with(holder.itemView)
            .load(recipeImageURL[position])
            .centerInside()
            .into(holder.recipeImage)

        holder.itemView.setOnClickListener() {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)  //need to pass recipeID[position] to DetailActivity.kt
            intent.putExtra("rId", recipeId[position])

            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount() = recipeList.size

}