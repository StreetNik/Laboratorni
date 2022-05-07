package com.example.lr9;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Arrays;
import java.util.Collections;

import java.io.IOException;
import java.util.Arrays;

public class HelloController {
    @FXML
    private Label myLabel;
    @FXML
    private TextField input;

    @FXML
    private TextField weeks;

    @FXML
    private TextField num1;
    @FXML
    private TextField num2;
    @FXML
    private TextField num3;

    @FXML
    private Label lab;

    @FXML
    private Button myButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToZ1(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToZ2(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("z2.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToPz2(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("pz2.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void weekDays(){
        try {


        String[] arr = {"Понеділок", "Вівторок", "Середа", "Четвер", "Пятниця", "Субота", "Неділя"};
        int i = Integer.parseInt(weeks.getText());

        Alert week = new Alert(Alert.AlertType.INFORMATION);
        week.setHeaderText("День тижня");
        week.setContentText("Це тиждень: " + arr[i - 1]);
        week.show();
        }
        catch (Exception e){
            Alert exception = new Alert(Alert.AlertType.ERROR);
            exception.setHeaderText("Вводити можна лише цифри від 1 до 7");
            exception.show();
        }
    }

    public void pz1(){
        try {
        int n1 = Integer.parseInt(num1.getText());
        int n2 = Integer.parseInt(num2.getText());
        int n3 = Integer.parseInt(num3.getText());

        int[] arr = {n1, n2, n3};
        int max = arr[0];
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        lab.setText(String.valueOf(max));
        }catch (Exception e){
            Alert exception = new Alert(Alert.AlertType.ERROR);
            exception.setHeaderText("Вводити можна лише цифри");
            exception.show();
        }
    }

    int number;

    public void submit(ActionEvent event){
        try{
            number = Integer.parseInt(input.getText());
            char[] arr = ("" + number).toCharArray();
            if(arr.length > 3 || arr.length < 3){
                myLabel.setText("Маж бути 3-значне число");
                throw new Exception("Маж бути 3-значне число");
            }else{
                char one = arr[0];
                char two = arr[1];
                char three = arr[2];
                char[] arr1 = {three, two, one};
                number = Integer.parseInt(new String(arr1));
                myLabel.setText("Before: " + new String(arr) + "; After: " + number);
            }
            System.out.println("Before: "+ new String(arr) + "; After: " +number);
        }catch (NumberFormatException e){
            myLabel.setText("Вводити можна лише цифри");
            System.out.println("Вводити можна лише цифри");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}