package com.example.noteapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class listadapter(private val listner:noteonclick): RecyclerView.Adapter<viewholder>() {

    val notelist:ArrayList<noterecord> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view = viewholder(LayoutInflater.from(parent.context).inflate(R.layout.noteview,parent,false))
        view.btn.setOnClickListener {
            listner.onclick(notelist[view.adapterPosition])
        }
       return view
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.note.text = notelist[position].note
    }

    override fun getItemCount(): Int {
        return notelist.size
    }

    fun updata(list:List<noterecord>){
           notelist.clear()
           notelist.addAll(list)
         notifyDataSetChanged()
    }

}


class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    val note : TextView = itemView.findViewById(R.id.note_text)
    val btn : ImageView = itemView.findViewById(R.id.delete_btn)
}


interface noteonclick{
    fun onclick(note: noterecord)
}