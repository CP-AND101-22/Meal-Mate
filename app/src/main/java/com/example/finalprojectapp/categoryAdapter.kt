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

private val RecyclerView.ViewHolder.categoryInfo: TextView
    get() {return itemView.findViewById<TextView>(R.id.categories)}
private val RecyclerView.ViewHolder.categoryImage: ImageView
    get() {return itemView.findViewById<ImageView>(R.id.categoryImage)}

class categoryAdapter(private val categoryList: MutableList<String>, private val categoryImageURL:MutableList<String>):RecyclerView.Adapter<ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val categoryInfo: TextView
        val categoryImage:ImageView
        init {
            categoryInfo = view.findViewById(R.id.categories)
            categoryImage = view.findViewById(R.id.categoryImage)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.categoryInfo.text = categoryList[position]

        //glide image
        Glide.with(holder.itemView)
            .load(categoryImageURL[position])
            .centerInside()
            .into(holder.categoryImage)
    }

    override fun getItemCount() = categoryList.size

}