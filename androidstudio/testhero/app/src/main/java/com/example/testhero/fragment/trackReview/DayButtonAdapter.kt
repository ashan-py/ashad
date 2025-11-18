package com.example.testhero.fragment.trackReview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testhero.databinding.ItemDayButtonBinding

class DayButtonAdapter(
    private val onDateClicked: (String) -> Unit
) : RecyclerView.Adapter<DayButtonAdapter.DayViewHolder>() {

    private var dateList: List<String> = emptyList()

    fun submitList(newList: List<String>) {
        dateList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val binding = ItemDayButtonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(dateList[position])
    }

    override fun getItemCount(): Int = dateList.size

    inner class DayViewHolder(private val binding: ItemDayButtonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(date: String) {
            val displayText = date.replace("-", "/").replace("_", " ")
            binding.dayButton.text = displayText
            binding.dayButton.setOnClickListener {
                onDateClicked(date)
            }
        }
    }
}