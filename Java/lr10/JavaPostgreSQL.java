package com.example.lr10;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import javafx.beans.property.SimpleStringProperty;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class JavaPostgreSQL {
    public static void writeToDatabase(LocalDate Date, String Title, String Text, String AuthorName, Boolean Checked) {

        String url = "jdbc:postgresql://localhost:5432/Notes";
        String user = "postgres";
        String password = "123";

        LocalDate date = Date;
        String text= Text;
        String title = Title;
        String author = AuthorName;
        Boolean check = Checked;

        // query
        String query = "INSERT INTO notes(date, title, text, done, creatorName) VALUES(?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            //pst.setString(1, String.valueOf(date));
            pst.setString(3, text);
            pst.setString(2, title);
            pst.setString(5, author);
            pst.setBoolean(4, check);
            pst.setDate(1, java.sql.Date.valueOf(date));
            pst.executeUpdate();
            System.out.println("Sucessfully created.");

        } catch(NullPointerException e){
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setHeaderText("Не вірно введені дані");
            a.show();
            System.out.println("Error");
        }
        catch (SQLException ex) {

            Logger lgr = Logger.getLogger(JavaPostgreSQL.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }

    }

    public static void outputFromDatabase(TableView table, ObservableList<ObservableList> data, String sql) throws SQLException {
        table.getColumns().clear();
        String url = "jdbc:postgresql://localhost:5432/Notes";
        String user = "postgres";
        String password = "123";

        data = FXCollections.observableArrayList();

        Connection con = DriverManager.getConnection(url, user, password);
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            resultSet = con.createStatement().executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace();
        }

        ObservableList dbData = FXCollections.observableArrayList(dataBaseArrayList(resultSet));

        for(int i=0 ; i<resultSet.getMetaData().getColumnCount(); i++) {
            TableColumn column = new TableColumn<>();
            switch (resultSet.getMetaData().getColumnName(i+1)) {
                case "date":
                    column.setText("Date");
                    break;
                case "title":
                    column.setText("Title");
                    break;
                case "text":
                    column.setText("Text");
                    break;
                case "creatorname":
                    column.setText("Creator Name");
                    break;
                case "done":
                    column.setText("Status done");
                    break;
                default: column.setText(resultSet.getMetaData().getColumnName(i+1)); //if column name in SQL Database is not found, then TableView column receive SQL Database current column name (not readable)
                    break;
            }
            column.setCellValueFactory(new PropertyValueFactory<>(resultSet.getMetaData().getColumnName(i+1))); //Setting cell property value to correct variable from Person class.
            table.getColumns().add(column);
        }

        //Filling up tableView with data
        table.setItems(dbData);
    }

    public static ArrayList dataBaseArrayList(ResultSet resultSet) throws SQLException {
        ArrayList<Note> data =  new ArrayList<>();
        while (resultSet.next()) {
            Note note = new Note();
            note.date.set(resultSet.getString("date"));
            note.title.set(resultSet.getString("title"));
            note.text.set(resultSet.getString("text"));
            note.creatorname.set(resultSet.getString("creatorname"));
            note.done.set(resultSet.getBoolean("done"));
            data.add(note);
        }
        return data;
    }

    public static void sortDatabase(TableView table, TableColumn myColumn){
        myColumn.setSortType(TableColumn.SortType.DESCENDING);
        table.getSortOrder().add(myColumn);
        table.sort();
    }

    public static void editDatabase(String sql) throws SQLException{
        String url = "jdbc:postgresql://localhost:5432/Notes";
        String user = "postgres";
        String password = "123";

        Connection con = DriverManager.getConnection(url, user, password);
        try {
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            con.createStatement().executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }


}
