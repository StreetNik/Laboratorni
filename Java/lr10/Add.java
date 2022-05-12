package com.example.lr10;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class Add implements Initializable{
    @FXML
    private Button AddBtn;
    @FXML
    private DatePicker Date;
    @FXML
    private TextField Title;
    @FXML
    private TextField Text;
    @FXML
    private TextField AuthorName;
    @FXML
    private CheckBox Checked;
    @FXML
    private TableView table;
    @FXML
    private ComboBox<String> comboBox;
    @FXML
    private TextField searchField;
    @FXML
    private TextField titleFieldEdit;
    @FXML
    private TextField newTitleField;
    @FXML
    private TextField newTextField;
    @FXML
    private Button searchBtn;
    @FXML
    private Button editBtn;
    @FXML
    private TextField titleRemove;
    @FXML
    private Button removeBtn;

    private ObservableList<ObservableList> data;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        comboBox.getItems().addAll("Date", "Title", "Text", "Creator Name", "Status done");
    }

    public void addData(ActionEvent event) throws IOException, SQLException {
        JavaPostgreSQL.writeToDatabase(Date.getValue(), Title.getText(), Text.getText(), AuthorName.getText(), Checked.isSelected());
        JavaPostgreSQL.outputFromDatabase(table, data, "SELECT * FROM notes");

        Title.clear();
        Text.clear();
        AuthorName.clear();
        Checked.setSelected(false);
    }

    public void showData(ActionEvent event) throws IOException, SQLException {
        if(comboBox.getValue() == null)
            JavaPostgreSQL.outputFromDatabase(table, data, "SELECT * FROM notes");
        else{
            String str = comboBox.getValue().toString();
            TableColumn col = getTableColumnByName(table, str);
            JavaPostgreSQL.sortDatabase(table, col);
        }
    }

    private <T> TableColumn<T, ?> getTableColumnByName(TableView<T> tableView, String name) {
        for (TableColumn<T, ?> col : tableView.getColumns())
            if (col.getText().equals(name)) return col ;
        return null ;
    }

    public void searchData(ActionEvent event) throws SQLException {
        String title = searchField.getText().toString();
        JavaPostgreSQL.outputFromDatabase(table, data, "SELECT * FROM notes WHERE title = '" + title + "'");
        searchField.clear();
    }

    public void editData(ActionEvent event) throws SQLException{
        String newTitle = newTitleField.getText();
        String newText = newTextField.getText();
        String title = titleFieldEdit.getText();

        JavaPostgreSQL.editDatabase("UPDATE notes SET title = '" + newTitle + "', text = '" + newText + "' WHERE title = '" + title + "';");
        JavaPostgreSQL.outputFromDatabase(table, data, "SELECT * FROM notes");

        newTitleField.clear();
        newTextField.clear();
        titleFieldEdit.clear();
    }

    public void removeData(ActionEvent event) throws SQLException{
        String title = titleRemove.getText();
        JavaPostgreSQL.editDatabase("DELETE FROM notes WHERE title = '" + title + "';");
        JavaPostgreSQL.outputFromDatabase(table, data, "SELECT * FROM notes");

        titleRemove.clear();
    }
}
