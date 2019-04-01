package com.example.mynoteappproject;

import java.util.Calender;

public class Notes {
    private int noteID;
    private String noteText;
    private String notePriority;
    private Date noteDate;

    public Notes(){
        noteID = -1;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public String getNotePriority() {
        return notePriority;
    }

    public void setNotePriority(String notePriority) {
        this.notePriority = notePriority;
    }

    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }
}
public boolean insertNote(Notes n){
    boolean didSucceed = false;
    try{
        ContentValues initialValues = new ContentValues();

        initialValues.put("note_Text", n.getNoteText());

        didSucceed = database.insert("note", null, initialValues) > 0;
    }
    catch (Exception e) {

    }
    return didSucceed
}
public boolean updateNote(Notes n){
    boolean didSucceed = false;

    try{
        Long rowID = (long) n.getNoteID();

        updateValues.put("note_Text", n.getNoteText());

        didSucceed = database.update("note", updateValues, "_id=" + rowID, null) > 0;
    }
    catch (Exception e){

    }
    return didSucceed;
}


