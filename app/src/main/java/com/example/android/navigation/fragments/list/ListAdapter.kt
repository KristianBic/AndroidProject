package com.example.android.navigation.fragments.list
import android.text.Layout
import android.text.Layout.Directions
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R
import com.example.android.navigation.database.model.Tasks
import com.example.android.navigation.fragments.HomeFragment
import com.example.android.navigation.fragments.SettingsTaskFragment
import com.example.android.navigation.fragments.SettingsTaskFragmentDirections
import kotlinx.android.synthetic.main.task_row.view.*

/**
 * RecyclerView adapter
 * recuclerView mame pridane v layoute fragment_home ... a to upravime
 */
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
        //pre update
        holder.itemView.rowLayout.setOnClickListener {
            val action = SettingsTaskFragmentDirections.actionSettingsTaskFragmentToUpdateTaskFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
    fun setData(task : List<Tasks>) {
        this.taskList = task
        notifyDataSetChanged()
    }
}