package com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.R
import com.example.quiz2soal3_if1_10122022_raihandafaalfarizi.model.DataItem

class HeroAdapter (private val users:MutableList<DataItem>)
    : RecyclerView.Adapter<HeroAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)

        return ListViewHolder(view)
    }

    fun addUser(newUser: DataItem) {
        users.add(newUser)
        notifyItemInserted(users.lastIndex)
    }

    fun clear(){
        users.clear()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val user = users[position]

        holder.tvName.text = user.name
        holder.tvFullName.text = user.biography.fullName

        val imageUrl = user.image?.url

        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .apply(RequestOptions().override(80, 80).placeholder(R.drawable.icon_avatar))
            .transform(CircleCrop())
            .into(holder.ivAvatar)
    }


    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.itemName)
        var tvFullName: TextView = itemView.findViewById(R.id.itemFullName)
        var ivAvatar: ImageView = itemView.findViewById(R.id.itemAvatar)
    }
}