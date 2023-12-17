package com.example.kachalkaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kachalkaapp.data.DBManager;
import com.example.kachalkaapp.data.Note;

public class EditNoteActivity extends AppCompatActivity {

    EditText action, count, time;
    TextView currentDate;
    ImageView calendar;
    Button save;
    DBManager dbManager;
    Note editNote = new Note();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        calendar = findViewById(R.id.imageCalendar);
        currentDate = findViewById(R.id.showDate);
        action = findViewById(R.id.editAction);
        count = findViewById(R.id.editCountAction);
        time = findViewById(R.id.editTimeActoin);
        save = findViewById(R.id.buttonSaveEditNote);
        dbManager = new DBManager(this);
        Bundle items = getIntent().getExtras();
        if (items != null){
            editNote = (Note) items.getSerializable(Note.class.getSimpleName());
            currentDate.setText(editNote.getDate());
            action.setText(editNote.getAction());
            count.setText(editNote.getCountAction());
            time.setText(editNote.getTime());
        }
    }
}