package com.example.shift_3.modules.notes_list

import com.example.shift_3.data.Note

interface INotesListContracts {

    interface INotesListView {
        fun initView(notesList: ArrayList<Note>?)
        fun navigateToNoteDetails(note: Note)
        fun updateView(notesList: ArrayList<Note>?)
    }

    interface INotesListPresenter {
        fun onViewAttached()
        fun onNoteItemClick(note: Note)
        fun update()
        fun getNotesList(): ArrayList<Note>?
        fun deleteNote(position: Int)
    }

    interface INotesListModel {
        fun getNotesList(): ArrayList<Note>?
        fun deleteNote(position: Int)
    }

}