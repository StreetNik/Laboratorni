package com.example.lr10;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @FXML
    private TableView table;

    @FXML
    private ComboBox comboBox;

    private ObservableList<ObservableList> data;

    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 740, 423);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        //Add.showData();
    }

    public static void main(String[] args) {
        launch();
    }
}