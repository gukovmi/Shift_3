package com.example.shift_3.modules.notes_list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shift_3.R
import com.example.shift_3.data.Note
import kotlinx.android.synthetic.main.item_note.view.*

typealias OnNoteItemClick = (Note) -> Unit

class NotesListAdapter (
    private val context: Context,
    private var notesList: ArrayList<Note>,
    private val onNoteItemClick: OnNoteItemClick

) : RecyclerView.Adapter<NotesListAdapter.ViewHolder>()
{
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindNote(note: Note, onNoteItemClick: OnNoteItemClick) {
            itemView.apply {
                itemNoteTittle.text=note.tittle
                itemNoteDescription.text=note.description

                setOnClickListener { onNoteItemClick(note) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notesList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindNote(notesList[position], onNoteItemClick)
    }

}