package com.example.productlist.api

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.productlist.R
import com.example.productlist.activities.DetailsActivity
import com.example.productlist.model.Article
import kotlinx.android.synthetic.main.article_row.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticleAdapter(private val article: List<Article>, val i: Int) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_row, parent, false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            val intent = Intent(parent.context, DetailsActivity::class.java)
            intent.putExtra("idUser", i)
            intent.putExtra("id", article[holder.adapterPosition].id)
            intent.putExtra("name", article[holder.adapterPosition].name)
            intent.putExtra("price", article[holder.adapterPosition].price)
            intent.putExtra("code", article[holder.adapterPosition].code)
            parent.context.startActivity(intent)
        }
        return holder
    }

    override fun getItemCount() = article.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = article[position]
        d("basma", "rezig ${article.name}")
        holder.name.text = article.name
        holder.code.text = article.code
        holder.price.text = article.price.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val code: TextView = itemView.code
        val name: TextView = itemView.name
        val price: TextView = itemView.price
    }


}