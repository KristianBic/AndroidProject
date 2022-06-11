package com.example.android.navigation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R
import com.example.android.navigation.database.Tasks
import kotlinx.android.synthetic.main.task_row.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var taskList = emptyList<Tasks>()

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.task_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = taskList[position]
        holder.itemView.taskID.text = currentItem.taskId.toString()
        holder.itemView.taskName.text = currentItem.taskName
        holder.itemView.taskTime.text = currentItem.timeType
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
    fun setData(task : List<Tasks>) {
        this.taskList = task
        notifyDataSetChanged()
    }
}