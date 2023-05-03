package com.example.a7minworkout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minworkout.databinding.ItemHistoryRowBinding

class HistoryAdapter(private val items:ArrayList<String>):RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {
    var onDeleteClickListener: ((String) -> Unit)? = null

    class ViewHolder(binding:ItemHistoryRowBinding):RecyclerView.ViewHolder(binding.root){
        val llHistoryItemMain=binding.llHistoryItemMain
        val tvItem=binding.tvItem
        val tvPosition=binding.tvPosition
        val imDelete=binding.imDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHistoryRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        ))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val date:String=items.get(position)
        holder.tvPosition.text=(position+1).toString()
        holder.tvItem.text=date
        if(position%2==0){
            holder.llHistoryItemMain.setBackgroundColor(Color.parseColor("#EBEBEB"))
        }else{
            holder.llHistoryItemMain.setBackgroundColor(Color.parseColor("#FFFFFF"))

        }
        holder.imDelete.setOnClickListener {
            val itemToDelete = items[position]
            items.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
            onDeleteClickListener?.invoke(itemToDelete) // Inform the activity about the deletion
        }
    }
}