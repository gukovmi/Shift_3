package com.example.shift_3.modules.notes_list

import com.example.shift_3.modules.notes_list.INotesListContracts.*
import com.example.shift_3.data.Note

class NotesListModel: INotesListModel {
    private var notesList = arrayListOf<Note>(
        Note("title1", "description1"),
        Note("title2", "description2"),
        Note("title3", "description3")
    )

    override fun getNotesList(): ArrayList<Note>? = notesList

    override fun deleteNote(position: Int) {
        notesList.removeAt(position)
    }

}