package com.example.shift_3.modules.notes_list

import com.example.shift_3.data.Note

interface INotesListContracts {

    interface INotesListView {
        fun initView()
        fun navigateToNoteDetails(note: Note)
    }

    interface INotesListPresenter {
        fun onViewAttached()
        fun onNoteItemClick(note: Note)
        fun getNotesList(): ArrayList<Note>?
    }

    interface INotesListModel {
        fun getNotesList(): ArrayList<Note>?
    }

}