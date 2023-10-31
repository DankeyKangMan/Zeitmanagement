package com.example.zeitmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class Scenengerippe_Controller {

    @FXML
    private MenuItem Admin_Login;

    @FXML
    private MenuItem Close;

    @FXML
    private MenuItem Logout;

    @FXML
    private MenuItem Your_Profile;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button calendar;

    @FXML
    private Button overview_month;

    @FXML
    private Button overview_year;

    @FXML
    private Button time_rec;

    @FXML
    void Calendar_Button(ActionEvent event) throws IOException {

    }

    @FXML
    void Menu_File_AdminLogin(ActionEvent event) {

    }

    @FXML
    void Menu_File_Close(ActionEvent event) {

    }

    @FXML
    void Menu_Profile_Logout(ActionEvent event) {

    }

    @FXML
    void Menu_Profile_YourProfile(ActionEvent event) {

    }

    @FXML
    void Overview_Month_Button(ActionEvent event) {

    }

    @FXML
    void Overview_Year_Button(ActionEvent event) {

    }

    @FXML
    void Time_REC_Button(ActionEvent event) throws IOException {
        if (borderpane != null) {
            BorderPane view = FXMLLoader.load(getClass().getResource("main-menu-scene.fxml"));
            borderpane.setCenter(view);
        }
    }
}
