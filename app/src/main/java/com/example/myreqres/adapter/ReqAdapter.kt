package com.example.myreqres.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myreqres.databinding.CardViewReqBinding
import com.example.myreqres.model.Req
import com.squareup.picasso.Picasso

class ReqAdapter : RecyclerView.Adapter<ReqAdapter.ReqViewHolder>() {
    private var list = ArrayList<Req>()

    inner class ReqViewHolder(var binding: CardViewReqBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReqViewHolder {
        val binding = CardViewReqBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReqViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReqViewHolder, position: Int) {

        holder.binding.tvEmail.text = list.get(position).email
        holder.binding.tvId.text = list.get(position).id.toString()
        holder.binding.tvFname.text = list.get(position).first_name
        holder.binding.tvLname.text = list.get(position).last_name
        Picasso.get()
            .load(list.get(position).avatar)
            .resize(150, 150)
            .centerCrop()
            .into(holder.binding.ivPokemon)
    }

    fun setList(List: ArrayList<Req>) {
        list = ArrayList<Req>()
        this.list = List
    }

    override fun getItemCount(): Int {
        return list.size
    }

}