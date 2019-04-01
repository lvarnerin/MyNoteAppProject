package com.example.mynoteappproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private Notes currentNote;

    currentNote = new Notes();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListButton();
        setForEditing();
        initSettings();
        initSortByClick();
        initTextChangedEvents();
        initSaveButton();
    }


    private void initDisplayButton() {
        Button displayButton = (Button) findViewById(R.id.buttonDisplay);
        displayButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EditText editName = (EditText) findViewByID(R.id.editTextName);
                TextView textDisplay = (TextView) findViewById(R.id.textViewDisplay);
                String nameToDisplay = editName.getText().toString();
                textDisplay.setText("Hello " + nameToDisplay)
            }
        });
    }


    private void initListButton() {
        ImageButton mainMenuButton = (ImageButtonButton) findViewByID(R.id.imageButtonMenu);
        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListofNotesMenu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initToggleButton(){
        final ToggleButton editToggle = (ToggleButton)findViewById(R.id.)
    }



    private void setForEditing(boolean enabled) {
        EditText editNoteText = (EditText) findViewById(R.id.editNoteText);
        RadioButton highPriorityOption = (RadioButton) findViewById(R.id.highPriorityRB);
        RadioButton mediumPriorityOption = (RadioButton) findViewById(R.id.mediumPriorityRB);
        RadioButton lowPriorityOption = (RadioButton) findViewById(R.id.lowPriorityRB);

        editNoteText.setEnabled(enabled);
        highPriorityOption.setEnabled(enabled);
        mediumPriorityOption.setEnabled(enabled);
        lowPriorityOption.setEnabled(enabled);

        if (enabled) {
            editNoteText.requestFocus();
        }
    }

    private void initSettings() {
        String sortBy = getSharedPreferences("MyNoteListPreferences", Contect.MODE_PRIVATE).getString("sortfield", "note_Priority");

        RadioButton highPriorityOption = (RadioButton) findViewById(R.id.highPriorityRB);
        RadioButton mediumPriorityOption = (RadioButton) findViewById(R.id.mediumPriorityRB);
        RadioButton lowPriorityOption = (RadioButton) findViewById(R.id.lowPriorityRB);
        if (sortBy.equals(1)) {
            highPriorityOption.setChecked(true);
        }
        if (sortBy.equals(2)) {
            mediumPriorityOption.setChecked(true);
        }
        if (sortBy.equals(3)) {
            lowPriorityOption.setChecked(true);
        }
    }

    private void initSortByClick() {
        RadioGroup RGSortBy = (RadioGroup) findViewById(R.id.priorityRBGroup);
        RGSortBy.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup arg0, arg1) {
                RadioButton highPriorityOption = (RadioButton) findViewById(R.id.highPriorityRB);
                RadioButton mediumPriorityOption = (RadioButton) findViewById(R.id.mediumPriorityRB);
                RadioButton lowPriorityOption = (RadioButton) findViewById(R.id.lowPriorityRB);
                if (highPriorityOption.isChecked()) {
                    getSharedPreferences("MyNoteListPreferences", Contect.MODE_PRIVATE).edit().putString("sortfield", "note_Priority");
                } else if (mediumPriorityOption.isChecked()) {
                    getSharedPreferences("MyNoteListPreferences", Contect.MODE_PRIVATE).edit().putString("sortfield", "note_Priority");
                } else {
                    getSharedPreferences("MyNoteListPreferences", Contect.MODE_PRIVATE).edit().putString("sortfield", "note_Priority");
                }
            }
        });

    }
    private void initTextChangedEvents(){
       final EditText etNoteText = (EditText) findViewById(R.id.editNoteText);

       etNoteText.addTextChangedListener(new Text Watcher() {

           public void afterTextChanged(Editable s){
                currentNote.setNoteText(etNoteText.getText().toString());
           }
           public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3){

           }
           public void onTextChanged(CharSequence s, int start, int before, int count){

           }
        });

    }
    private void initSaveButton(){
        Button saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                boolean wasSuccessful = false;
                NoteDataSource ds = new NoteDataSource(MainActivity.this);
                try {
                    ds.open();

                    if(currentNote.getNoteID() == -1){
                        wasSuccessful = ds.insertNote(currentNote);
                    }
                    else {
                        wasSuccessful = ds.updateNote(currentNote)
                    }
                    ds.close();
                }
                catch (Exception e) {
                    wasSuccessful = false;
                }
            }

            if (wasSuccessful) {

            }

        });
    }






}

