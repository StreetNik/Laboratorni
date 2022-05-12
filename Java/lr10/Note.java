package com.example.lr10;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class Note {
    StringProperty date = new SimpleStringProperty();
    StringProperty title = new SimpleStringProperty();
    StringProperty text = new SimpleStringProperty();
    StringProperty creatorname = new SimpleStringProperty();
    BooleanProperty done = new SimpleBooleanProperty();

    public StringProperty dateProperty(){
        return date;
    }
    public StringProperty titleProperty(){
        return title;
    }
    public StringProperty textProperty(){
        return text;
    }
    public StringProperty creatornameProperty(){
        return creatorname;
    }
    public BooleanProperty doneProperty(){
        return done;
    }
    Note(){}
}
