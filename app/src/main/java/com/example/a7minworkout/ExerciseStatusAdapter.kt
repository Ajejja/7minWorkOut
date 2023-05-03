package com.example.a7minworkout

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.a7minworkout.databinding.ItemExerciseStatusBinding

class ExerciseStatusAdapter(var items:ArrayList<ExerciseModel>)
    :RecyclerView.Adapter<ExerciseStatusAdapter.ViewHolder>() {
        class ViewHolder(binding: ItemExerciseStatusBinding):
                RecyclerView.ViewHolder(binding.root){
                    val tvItem=binding.tvItem
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemExerciseStatusBinding.inflate(
            LayoutInflater.from(parent.context),parent,false) )}

    override fun getItemCount(): Int {
        return items.size
    }
    fun updateItems(newItems: ArrayList<ExerciseModel>) {
        items = newItems
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model :ExerciseModel=items[position]
        Log.d("ExerciseStatusAdapter", "Updating item at position $position")
        holder.tvItem.text=model.getId().toString()
        when{
            model.getIsSelected()->{
                holder.tvItem.background=
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_thin_color_background)
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
            model.getIsCompleted()->{
                holder.tvItem.background=
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_color_accent_background)
                holder.tvItem.setTextColor(Color.parseColor("#FFFFFF"))

            }
            else->{
                holder.tvItem.background=
                    ContextCompat.getDrawable(holder.itemView.context, R.drawable.item_circular_gray_background)
                holder.tvItem.setTextColor(Color.parseColor("#212121"))
            }
        }
    }


}