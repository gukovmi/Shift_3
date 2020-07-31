package com.example.shift_3.modules.note_details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shift_3.R
import com.example.shift_3.data.Note
import kotlinx.android.synthetic.main.activity_note_details.*

class NoteDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_details)

        val note: Note= intent.getSerializableExtra("note") as Note
        noteDetailsTittle.text=note.tittle
        noteDetailsDescription.text=note.description
    }
}