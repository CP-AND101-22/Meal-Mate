package com.example.finalprojectapp
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

private val RecyclerView.ViewHolder.recipeInfo: TextView
    get() {return itemView.findViewById<TextView>(R.id.recipes)}
private val RecyclerView.ViewHolder.recipeImage: ImageView
    get() {return itemView.findViewById<ImageView>(R.id.recipeImage)}

class recipeAdapter(private val recipeList: MutableList<String>, private val recipeImageURL:MutableList<String>):RecyclerView.Adapter<ViewHolder>() {
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
            .inflate(R.layout.recycler_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Set more values as needed
        //val pos = position+1
        holder.recipeInfo.text = recipeList[position]
        //holder.recipeInfo.setOnClickListener(){
          //  Toast.makeText(holder.itemView.context,"That's celeb at No $pos", Toast.LENGTH_SHORT).show()
        //}
        //glide image
        Glide.with(holder.itemView)
            .load(recipeImageURL[position])
            .centerInside()
            .into(holder.recipeImage)
    }

    override fun getItemCount() = recipeList.size

}