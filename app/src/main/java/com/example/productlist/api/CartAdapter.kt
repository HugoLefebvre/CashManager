package com.example.productlist.api

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.productlist.R
import com.example.productlist.model.Article
import kotlinx.android.synthetic.main.addarticle.view.*
import kotlinx.android.synthetic.main.cart_row.view.*


class CartAdapter(private val article: List<Article>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount() = article.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val article = article[position]
            d("basma",article.name)
            holder.name.text = article.name
            holder.price.text = article.price.toString()

    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.name
        val price: TextView = itemView.price
    }
}
