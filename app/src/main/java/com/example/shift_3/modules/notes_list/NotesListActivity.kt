package com.example.shift_3.modules.notes_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shift_3.R
import com.example.shift_3.data.Note
import com.example.shift_3.modules.note_details.NoteDetailsActivity
import com.example.shift_3.modules.notes_list.INotesListContracts.*
import kotlinx.android.synthetic.main.activity_notes_list.*

class NotesListActivity : AppCompatActivity(), INotesListView {

    private lateinit var presenter: INotesListPresenter

    private var notesListAdapter: NotesListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)

        presenter = NotesListPresenter(this)
        presenter.onViewAttached()
    }

    override fun initView(notesList: ArrayList<Note>?) {
        if (notesList.isNullOrEmpty()) {
            Toast.makeText(this, "Notes list is empty!", Toast.LENGTH_LONG).show()
        }
        else {
            notesListAdapter = NotesListAdapter(
                this,
                notesList = notesList,
                onNoteItemClick = { note -> presenter.onNoteItemClick(note) },
                onDeleteNoteItemClick = { position -> presenter.deleteNote(position) })

            notesListRecyclerView.layoutManager = LinearLayoutManager(this)
            notesListRecyclerView.adapter = notesListAdapter
        }
    }

    override fun navigateToNoteDetails(note: Note) {
        val intent = Intent(this, NoteDetailsActivity::class.java)
        intent.putExtra("note", note)
        startActivity(intent)
    }

    override fun updateView(notesList: ArrayList<Note>?) {
        if (notesList.isNullOrEmpty()) {
            notesListRecyclerView.adapter=null
            Toast.makeText(this, "Notes list is empty!", Toast.LENGTH_LONG).show()
        }
        else {
            notesListAdapter = NotesListAdapter(
                this,
                notesList = notesList,
                onNoteItemClick = { note -> presenter.onNoteItemClick(note) },
                onDeleteNoteItemClick = { position -> presenter.deleteNote(position) })

            notesListRecyclerView.layoutManager = LinearLayoutManager(this)
            notesListRecyclerView.adapter = notesListAdapter
        }
    }
}
