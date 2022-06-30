package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(private val context: Context, private val articles: List<Articles>):RecyclerView.Adapter<MyAdapter.viewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view=LayoutInflater.from(context)
            .inflate(R.layout.items_list,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val arti=articles[position]
        holder.title.text=arti.title
        holder.descrip.text=arti.description
        holder.publish.text=arti.publishedAt
        holder.author.text=arti.author
        Glide.with(context).load(arti.urlToImage).into(holder.image)
    }

    override fun getItemCount(): Int {
        return articles.size
    }
    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image=itemView.findViewById<ImageView>(R.id.Image)
        val title=itemView.findViewById<TextView>(R.id.Title)
        val descrip=itemView.findViewById<TextView>(R.id.Description)
        val author=itemView.findViewById<TextView>(R.id.Author)
        val publish=itemView.findViewById<TextView>(R.id.PublishedAt)
    }
}