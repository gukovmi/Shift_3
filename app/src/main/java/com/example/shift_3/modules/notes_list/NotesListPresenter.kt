package com.example.shift_3.modules.notes_list


import com.example.shift_3.modules.notes_list.INotesListContracts.*
import com.example.shift_3.data.Note

class NotesListPresenter(private var view: INotesListView
): INotesListPresenter {

    private var model: INotesListModel =
        NotesListModel()

    override fun onViewAttached() {
        view.initView()
    }

    override fun onNoteItemClick(note: Note) {
        view.navigateToNoteDetails(note)
    }

    override fun getNotesList(): ArrayList<Note>? = model.getNotesList()
}