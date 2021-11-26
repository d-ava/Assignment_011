package com.example.testprojectusinghilt

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_011.databinding.ItemBinding
import com.example.assignment_011.extensions.glideExtension
import com.example.assignment_011.model.Item


class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    private val list: MutableList<Item> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Item>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ChatViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private lateinit var model: Item

        fun onBind() {
            model = list[adapterPosition]
            binding.tvFirstName.text = model.firstName
            binding.tvLastName.text = model.lastName
            binding.tvMessage.text = model.lastMessage
            binding.tvUnreadMessage.text = model.unreaMessage.toString()
            binding.ivAvatar.glideExtension(model.avatar)
        }


    }
}