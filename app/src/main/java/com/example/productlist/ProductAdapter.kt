package com.example.productlist

import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_row.view.*


class ProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount()= products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        d("basma","rezig ${product.name}" )
        holder.name.text = product.name
        holder.pcode.text = product.pCode
        holder.prixUnit.text = product.prix_unit.toString()
    }
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val pcode: TextView = itemView.pcode
        val name: TextView = itemView.name
        val prixUnit: TextView = itemView.prixUnit
    }

}